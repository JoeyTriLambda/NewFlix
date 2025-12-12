package org.adblockplus.libadblockplus.android.webview;

import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import bi.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.adblockplus.libadblockplus.android.Utils;
import org.adblockplus.libadblockplus.sitekey.SiteKeyException;
import org.adblockplus.libadblockplus.sitekey.SiteKeyVerifier;

/* loaded from: classes2.dex */
class JsSiteKeyExtractor extends BaseSiteKeyExtractor {
    private final Handler callerThreadHandler;
    private Runnable disableStateRunner;
    private Runnable enableStateRunner;
    private final AtomicBoolean isJavascriptInterfaceSet;
    private final AtomicBoolean isSiteKeyProcessingFinished;
    private volatile CountDownLatch latch;

    public static class JsCallbackInterface {
        static final String NAME = "AbpCallback";
        private final WeakReference<JsSiteKeyExtractor> extractorRef;
        private final WeakReference<AdblockWebView> webViewRef;

        private JsSiteKeyExtractor getExtractorIfStillExist() {
            JsSiteKeyExtractor jsSiteKeyExtractor = this.extractorRef.get();
            if (jsSiteKeyExtractor != null) {
                return jsSiteKeyExtractor;
            }
            AdblockWebView adblockWebView = this.webViewRef.get();
            if (adblockWebView == null) {
                return null;
            }
            adblockWebView.removeJavascriptInterface(NAME);
            return null;
        }

        @JavascriptInterface
        public void onDomNotReady(String str) {
            JsSiteKeyExtractor extractorIfStillExist = getExtractorIfStillExist();
            if (extractorIfStillExist == null || !extractorIfStillExist.isEnabled()) {
                return;
            }
            extractorIfStillExist.isSiteKeyProcessingFinished.set(false);
            a.d("DOM not yet ready on url %s", str);
        }

        @JavascriptInterface
        public void onSiteKeyDoesNotExist(String str) {
            JsSiteKeyExtractor extractorIfStillExist = getExtractorIfStillExist();
            if (extractorIfStillExist == null || !extractorIfStillExist.isEnabled()) {
                return;
            }
            CountDownLatch countDownLatch = extractorIfStillExist.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            extractorIfStillExist.isSiteKeyProcessingFinished.set(true);
            a.d("Key does not exist on url %s", str);
        }

        @JavascriptInterface
        public void onSiteKeyExtracted(String str, String str2, String str3) {
            a.d("Received sitekey for \nurl: %s", str2);
            JsSiteKeyExtractor extractorIfStillExist = getExtractorIfStillExist();
            if (extractorIfStillExist == null || !extractorIfStillExist.isEnabled()) {
                return;
            }
            if (str != null && !str.isEmpty()) {
                extractorIfStillExist.verifySiteKey(str2, str3, str);
            }
            CountDownLatch countDownLatch = extractorIfStillExist.latch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            extractorIfStillExist.isSiteKeyProcessingFinished.set(true);
        }

        private JsCallbackInterface(JsSiteKeyExtractor jsSiteKeyExtractor) {
            this.extractorRef = new WeakReference<>(jsSiteKeyExtractor);
            this.webViewRef = jsSiteKeyExtractor.webViewWeakReference;
        }
    }

    public JsSiteKeyExtractor(AdblockWebView adblockWebView) {
        super(adblockWebView);
        this.callerThreadHandler = new Handler();
        adblockWebView.addJavascriptInterface(new JsCallbackInterface(), "AbpCallback");
        this.isJavascriptInterfaceSet = new AtomicBoolean(true);
        this.isSiteKeyProcessingFinished = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifySiteKey(String str, String str2, String str3) {
        try {
            SiteKeyVerifier siteKeyVerifier = getSiteKeysConfiguration().getSiteKeyVerifier();
            if (siteKeyVerifier == null) {
                throw new AssertionError("Verifier must be set before this is called");
            }
            if (siteKeyVerifier.verify(Utils.getUrlWithoutFragment(str), str2, str3)) {
                a.d("Url %s public key verified successfully", str);
            } else {
                a.e("Url %s public key is not verified", str);
            }
        } catch (SiteKeyException e10) {
            a.e(e10, "Failed to verify sitekey header", new Object[0]);
        }
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public WebResourceResponse extract(WebResourceRequest webResourceRequest) {
        return null;
    }

    @Override // org.adblockplus.libadblockplus.android.webview.BaseSiteKeyExtractor, org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        final AdblockWebView adblockWebView = this.webViewWeakReference.get();
        if (adblockWebView == null) {
            return;
        }
        if (z10) {
            if (this.isJavascriptInterfaceSet.get()) {
                return;
            }
            if (this.enableStateRunner == null) {
                this.enableStateRunner = new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.JsSiteKeyExtractor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        adblockWebView.addJavascriptInterface(new JsCallbackInterface(), "AbpCallback");
                        JsSiteKeyExtractor.this.isJavascriptInterfaceSet.set(true);
                    }
                };
            }
            a.d("Enabling JsSiteKeyExtractor", new Object[0]);
            this.callerThreadHandler.post(this.enableStateRunner);
            return;
        }
        if (this.disableStateRunner == null) {
            this.disableStateRunner = new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.JsSiteKeyExtractor.2
                @Override // java.lang.Runnable
                public void run() {
                    adblockWebView.removeJavascriptInterface("AbpCallback");
                    JsSiteKeyExtractor.this.isJavascriptInterfaceSet.set(false);
                }
            };
        }
        a.d("Disabling JsSiteKeyExtractor", new Object[0]);
        this.callerThreadHandler.post(this.disableStateRunner);
        if (this.latch != null) {
            this.latch.countDown();
            this.latch = null;
        }
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void startNewPage() {
        a.d("startNewPage() called", new Object[0]);
        this.isSiteKeyProcessingFinished.set(false);
        this.latch = new CountDownLatch(1);
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public boolean waitForSitekeyCheck(String str, boolean z10) throws InterruptedException {
        if (z10 || !isEnabled() || this.isSiteKeyProcessingFinished.get()) {
            return false;
        }
        CountDownLatch countDownLatch = this.latch;
        if (countDownLatch == null) {
            a.w("waitForSitekeyCheck() called for `%s` with `latch == null`!", str);
            return false;
        }
        a.d("Holding request %s", str);
        try {
            countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            a.d("Un-holding request %s", str);
        } catch (InterruptedException e10) {
            a.e("Holding request error: %s", e10);
        }
        return true;
    }
}
