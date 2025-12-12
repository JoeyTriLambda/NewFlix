package org.adblockplus.libadblockplus.android.webview;

import ac.c;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import bi.a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.adblockplus.libadblockplus.FilterEngine;
import org.adblockplus.libadblockplus.android.AdblockEngine;
import org.adblockplus.libadblockplus.android.AdblockEngineProvider;
import org.adblockplus.libadblockplus.android.SingleInstanceEngineProvider;
import org.adblockplus.libadblockplus.android.Utils;
import org.adblockplus.libadblockplus.android.webview.content_type.ContentTypeDetector;
import org.adblockplus.libadblockplus.android.webview.content_type.HeadersContentTypeDetector;
import org.adblockplus.libadblockplus.android.webview.content_type.OrderedContentTypeDetector;
import org.adblockplus.libadblockplus.android.webview.content_type.UrlFileExtensionTypeDetector;
import org.adblockplus.libadblockplus.sitekey.PublicKeyHolderImpl;
import org.adblockplus.libadblockplus.sitekey.SiteKeysConfiguration;

/* loaded from: classes2.dex */
public class AdblockWebView extends WebView {
    private static final String ASSETS_CHARSET_NAME = "UTF-8";
    private static final String BRIDGE = "jsBridge";
    private static final String BRIDGE_TOKEN = "{{BRIDGE}}";
    private static final String DEBUG_TOKEN = "{{DEBUG}}";
    private static final String EMPTY_ELEMHIDE_ARRAY_STRING = "[]";
    private static final String EMPTY_ELEMHIDE_STRING = "";
    private static final String HIDDEN_TOKEN = "{{HIDDEN_FLAG}}";
    private static final String HIDE_TOKEN = "{{HIDE}}";
    private static final String SITEKEY_EXTRACTED_TOKEN = "{{SITEKEY_EXTRACTED_FLAG}}";
    private final AtomicReference<OptionalBoolean> adblockEnabled;
    private OrderedContentTypeDetector contentTypeDetector;
    private String elementsHiddenFlag;
    private String elemhideBlockedJs;
    private final AdblockEngineProvider.EngineCreatedListener engineCreatedCb;
    private final AdblockEngineProvider.EngineDisposedListener engineDisposedCb;
    private final AdblockEngine.SettingsChangedListener engineSettingsChangedCb;
    private final AtomicReference<EventsListener> eventsListenerAtomicReference;
    private String injectJs;
    private ProxyWebChromeClient intWebChromeClient;
    private ProxyWebViewClient intWebViewClient;
    private final AtomicBoolean jsInIframesEnabled;
    private Integer loadError;
    private boolean loading;
    private final AtomicReference<String> navigationUrl;
    private final AtomicReference<AdblockEngineProvider> providerReference;
    private SiteKeyExtractor siteKeyExtractor;
    private final AtomicReference<SiteKeysConfiguration> siteKeysConfiguration;
    private String sitekeyExtractedFlag;
    private final Map<String, String> url2Referrer;
    private final Map<String, Pair<String, String>> url2Stylesheets;

    public enum AbpShouldBlockResult {
        NOT_ENABLED,
        ALLOW_LOAD,
        ALLOW_LOAD_NO_SITEKEY_CHECK,
        BLOCK_LOAD
    }

    public class AdblockWebWebChromeClient extends ProxyWebChromeClient {
        public AdblockWebWebChromeClient(WebChromeClient webChromeClient) {
            super(webChromeClient);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebChromeClient, android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            a.d("JS: level=%s, message=\"%s\", sourceId=\"%s\", line=%d", consoleMessage.messageLevel(), consoleMessage.message(), consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()));
            return super.onConsoleMessage(consoleMessage);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebChromeClient, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            a.d("onProgressChanged to %d%% for url: %s", Integer.valueOf(i10), webView.getUrl());
            AdblockWebView.this.tryInjectJs();
            super.onProgressChanged(webView, i10);
        }
    }

    public class DisposeRunnable implements Runnable {
        private final Runnable disposeFinished;

        @Override // java.lang.Runnable
        public void run() {
            AdblockWebView.this.doDispose();
            Runnable runnable = this.disposeFinished;
            if (runnable != null) {
                runnable.run();
            }
        }

        private DisposeRunnable(Runnable runnable) {
            this.disposeFinished = runnable;
        }
    }

    public interface EventsListener {

        public enum AllowlistReason {
            DOCUMENT,
            DOMAIN,
            FILTER
        }

        public static final class AllowlistedResourceInfo extends ResourceInfo {
            private final AllowlistReason reason;

            public AllowlistedResourceInfo(String str, List<String> list, AllowlistReason allowlistReason) {
                super(str, list);
                this.reason = allowlistReason;
            }

            public AllowlistReason getReason() {
                return this.reason;
            }
        }

        public static final class BlockedResourceInfo extends ResourceInfo {
            private final FilterEngine.ContentType contentType;

            public BlockedResourceInfo(String str, List<String> list, FilterEngine.ContentType contentType) {
                super(str, list);
                this.contentType = contentType;
            }

            public FilterEngine.ContentType getContentType() {
                return this.contentType;
            }
        }

        public static class ResourceInfo {
            private final List<String> parentFrameUrls;
            private final String requestUrl;

            public ResourceInfo(String str, List<String> list) {
                this.requestUrl = str;
                this.parentFrameUrls = new ArrayList(list);
            }

            public List<String> getParentFrameUrls() {
                return this.parentFrameUrls;
            }

            public String getRequestUrl() {
                return this.requestUrl;
            }
        }

        void onNavigation();

        void onResourceLoadingAllowlisted(AllowlistedResourceInfo allowlistedResourceInfo);

        void onResourceLoadingBlocked(BlockedResourceInfo blockedResourceInfo);
    }

    public enum OptionalBoolean {
        UNDEFINED,
        TRUE,
        FALSE;

        public static OptionalBoolean from(boolean z10) {
            return z10 ? TRUE : FALSE;
        }
    }

    public static class WebResponseResult {
        public static final WebResourceResponse ALLOW_LOAD = null;
        public static final WebResourceResponse BLOCK_LOAD = new WebResourceResponse("text/plain", "UTF-8", null);
        public static final String RESPONSE_CHARSET_NAME = "UTF-8";
        public static final String RESPONSE_MIME_TYPE = "text/plain";
    }

    public AdblockWebView(Context context) {
        super(context);
        this.providerReference = new AtomicReference<>();
        this.url2Referrer = Collections.synchronizedMap(new HashMap());
        this.url2Stylesheets = Collections.synchronizedMap(new HashMap());
        this.navigationUrl = new AtomicReference<>();
        this.adblockEnabled = new AtomicReference<>(OptionalBoolean.UNDEFINED);
        this.eventsListenerAtomicReference = new AtomicReference<>();
        this.siteKeysConfiguration = new AtomicReference<>();
        this.jsInIframesEnabled = new AtomicBoolean(false);
        this.engineSettingsChangedCb = new AdblockEngine.SettingsChangedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1
            @Override // org.adblockplus.libadblockplus.android.AdblockEngine.SettingsChangedListener
            public void onEnableStateChanged(boolean z10) {
                OptionalBoolean optionalBooleanFrom = OptionalBoolean.from(z10);
                OptionalBoolean optionalBoolean = (OptionalBoolean) AdblockWebView.this.adblockEnabled.getAndSet(optionalBooleanFrom);
                if (optionalBoolean == OptionalBoolean.UNDEFINED || optionalBoolean == optionalBooleanFrom) {
                    return;
                }
                a.d("Filter Engine status changed, enable status is %s", optionalBooleanFrom);
                AdblockWebView.this.post(new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdblockWebView.this.clearCache(true);
                    }
                });
            }
        };
        this.engineCreatedCb = new AdblockEngineProvider.EngineCreatedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.2
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineCreatedListener
            public void onAdblockEngineCreated(AdblockEngine adblockEngine) {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.from(adblockEngine.isEnabled()));
                a.d("Filter Engine created, enable status is %s", AdblockWebView.this.adblockEnabled.get());
                adblockEngine.addSettingsChangedListener(AdblockWebView.this.engineSettingsChangedCb);
            }
        };
        this.engineDisposedCb = new AdblockEngineProvider.EngineDisposedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.3
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineDisposedListener
            public void onAdblockEngineDisposed() {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.UNDEFINED);
            }
        };
        initAbp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> buildFramesHierarchy(String str) {
        ArrayList arrayList = new ArrayList();
        String str2 = str;
        while (true) {
            str2 = this.url2Referrer.get(str2);
            if (str2 == null) {
                break;
            }
            if (arrayList.contains(str2)) {
                a.w("Detected referrer loop, finished creating referrers list", new Object[0]);
                break;
            }
            arrayList.add(str2);
        }
        String str3 = this.navigationUrl.get();
        if (TextUtils.isEmpty(str3)) {
            return arrayList;
        }
        String domain = Utils.getDomain(str3);
        if (TextUtils.isEmpty(domain)) {
            a.e(c.j("buildFramesHierarchy() failed to obtain a domain from url ", str3), new Object[0]);
            return arrayList;
        }
        boolean z10 = (arrayList.isEmpty() || domain.equals(Utils.getDomain((String) arrayList.get(arrayList.size() - 1)))) ? false : true;
        if (arrayList.isEmpty() || z10) {
            a.d("Adding top level referrer `%s` for `%s`", str3, str);
            arrayList.add(str3);
        }
        return arrayList;
    }

    private void buildInjectJs() {
        try {
            if (this.injectJs == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(readScriptFile("inject.js").replace(HIDE_TOKEN, readScriptFile("css.js")));
                stringBuffer.append(readScriptFile("elemhideemu.js"));
                this.injectJs = stringBuffer.toString();
            }
            if (this.elemhideBlockedJs == null) {
                this.elemhideBlockedJs = readScriptFile("elemhideblocked.js");
            }
        } catch (IOException e10) {
            a.e(e10, "Failed to read script", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReferrers() {
        a.d("Clearing referrers", new Object[0]);
        this.url2Referrer.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStylesheets() {
        a.d("Clearing stylesheet", new Object[0]);
        this.url2Stylesheets.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDispose() {
        a.w("Disposing AdblockEngine", new Object[0]);
        getProvider().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elemhideBlockedResource(final String str) {
        try {
            String strExtractPathWithQuery = Utils.extractPathWithQuery(str);
            if (strExtractPathWithQuery.startsWith("/")) {
                strExtractPathWithQuery = strExtractPathWithQuery.substring(1);
            }
            a.d("Trying to elemhide visible blocked resource with url `%s` and path `%s`", str, strExtractPathWithQuery);
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("[src$='");
            sb2.append(strExtractPathWithQuery);
            sb2.append("'], [srcset$='");
            sb2.append(strExtractPathWithQuery);
            sb2.append("']");
            post(new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    AdblockWebView.this.evaluateJavascript(AdblockWebView.this.elemhideBlockedJs + "\n\nelemhideForSelector(\"" + str + "\", \"" + Utils.escapeJavaScriptString(sb2.toString()) + "\", 0)", null);
                }
            });
        } catch (MalformedURLException unused) {
            a.e(c.k("Failed to parse URI for blocked resource:", str, ". Skipping element hiding"), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContentTypeDetector ensureContentTypeDetectorCreatedAndGet() {
        if (this.contentTypeDetector == null) {
            this.contentTypeDetector = new OrderedContentTypeDetector(new HeadersContentTypeDetector(), new UrlFileExtensionTypeDetector());
        }
        return this.contentTypeDetector;
    }

    private void ensureProvider() {
        if (getProvider() == null) {
            setProvider(new SingleInstanceEngineProvider(AdblockEngine.builder(getContext(), AdblockEngine.BASE_PATH_DIRECTORY)));
        }
    }

    private EventsListener getEventsListener() {
        return this.eventsListenerAtomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdblockEngineProvider getProvider() {
        return this.providerReference.get();
    }

    private Pair<String, String> getStylesheetsForUrl(String str) {
        return this.url2Stylesheets.get(Utils.getUrlWithoutFragment(str));
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initAbp() {
        addJavascriptInterface(this, BRIDGE);
        initRandom();
        buildInjectJs();
        getSettings().setJavaScriptEnabled(true);
        this.siteKeyExtractor = new CombinedSiteKeyExtractor(this);
        this.intWebChromeClient = new AdblockWebWebChromeClient(null);
        this.intWebViewClient = new AdblockWebViewClient(null);
        super.setWebChromeClient(this.intWebChromeClient);
        super.setWebViewClient(this.intWebViewClient);
    }

    private void initRandom() {
        Random random = new Random();
        this.elementsHiddenFlag = "abp" + Math.abs(random.nextLong());
        this.sitekeyExtractedFlag = "abp" + Math.abs(random.nextLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVisibleResource(FilterEngine.ContentType contentType) {
        return contentType == FilterEngine.ContentType.IMAGE || contentType == FilterEngine.ContentType.MEDIA || contentType == FilterEngine.ContentType.OBJECT || contentType == FilterEngine.ContentType.SUBDOCUMENT;
    }

    private void loadUrlCommon() {
        ensureProvider();
        if (this.loading) {
            stopAbpLoading();
        }
        this.siteKeyExtractor.startNewPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNavigation() {
        EventsListener eventsListener = getEventsListener();
        if (eventsListener != null) {
            eventsListener.onNavigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResourceAllowlisted(EventsListener.AllowlistedResourceInfo allowlistedResourceInfo) {
        EventsListener eventsListener = getEventsListener();
        if (eventsListener != null) {
            eventsListener.onResourceLoadingAllowlisted(allowlistedResourceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResourceBlocked(EventsListener.BlockedResourceInfo blockedResourceInfo) {
        EventsListener eventsListener = getEventsListener();
        if (eventsListener != null) {
            eventsListener.onResourceLoadingBlocked(blockedResourceInfo);
        }
    }

    private String readScriptFile(String str) throws IOException {
        return Utils.readAssetAsString(getContext(), str, "UTF-8").replace(BRIDGE_TOKEN, BRIDGE).replace(DEBUG_TOKEN, "//").replace(HIDDEN_TOKEN, this.elementsHiddenFlag).replace(SITEKEY_EXTRACTED_TOKEN, this.sitekeyExtractedFlag);
    }

    private void runScript(String str) {
        a.d("runScript started", new Object[0]);
        evaluateJavascript(str, null);
        a.d("runScript finished", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAbpLoading(String str) {
        boolean z10 = false;
        a.d("Start loading %s", str);
        this.loading = true;
        this.loadError = null;
        if (str != null) {
            String urlWithoutFragment = Utils.getUrlWithoutFragment(str);
            AtomicReference<String> atomicReference = this.navigationUrl;
            while (true) {
                if (atomicReference.compareAndSet(null, urlWithoutFragment)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != null) {
                    break;
                }
            }
            if (z10) {
                generateStylesheetForUrl(urlWithoutFragment, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAbpLoading() {
        a.d("Stop abp loading", new Object[0]);
        this.loading = false;
        clearReferrers();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryInjectJs() {
        if (this.adblockEnabled.get() == OptionalBoolean.TRUE && this.loadError == null && this.injectJs != null) {
            a.d("Injecting script", new Object[0]);
            runScript(this.injectJs);
        }
    }

    public void dispose(Runnable runnable) {
        a.d("Dispose invoked", new Object[0]);
        if (getProvider() == null) {
            a.d("No internal AdblockEngineProvider created", new Object[0]);
            return;
        }
        ReentrantReadWriteLock.ReadLock readEngineLock = getProvider().getReadEngineLock();
        readEngineLock.lock();
        try {
            AdblockEngine engine = getProvider().getEngine();
            if (engine != null) {
                engine.removeSettingsChangedListener(this.engineSettingsChangedCb);
            }
            getProvider().removeEngineCreatedListener(this.engineCreatedCb);
            getProvider().removeEngineDisposedListener(this.engineDisposedCb);
            readEngineLock.unlock();
            stopLoading();
            new DisposeRunnable(runnable).run();
        } catch (Throwable th2) {
            readEngineLock.unlock();
            throw th2;
        }
    }

    public void enableJsInIframes(boolean z10) throws IllegalStateException {
        if (z10 && getSiteKeysConfiguration() == null) {
            throw new IllegalStateException("Site Keys configuration must be set (enabled) to use this feature!");
        }
        this.jsInIframesEnabled.set(z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0094 A[Catch: all -> 0x019a, TryCatch #0 {all -> 0x019a, blocks: (B:19:0x006d, B:27:0x0094, B:29:0x009e, B:31:0x00b5, B:33:0x00bf, B:35:0x00c9, B:39:0x00db, B:41:0x00e1, B:43:0x00f2, B:44:0x00fe, B:32:0x00bb, B:22:0x0079), top: B:65:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean generateStylesheetForUrl(java.lang.String r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.adblockplus.libadblockplus.android.webview.AdblockWebView.generateStylesheetForUrl(java.lang.String, boolean):boolean");
    }

    @JavascriptInterface
    public String getElemhideEmulationSelectors(String str) {
        Pair<String, String> stylesheetsForUrl = getStylesheetsForUrl(str);
        if (stylesheetsForUrl == null) {
            return "[]";
        }
        a.d("Elemhideemu selectors for `%s`, %d bytes", str, Integer.valueOf(((String) stylesheetsForUrl.second).length()));
        return (String) stylesheetsForUrl.second;
    }

    @JavascriptInterface
    public String getElemhideStyleSheet(String str) {
        Pair<String, String> stylesheetsForUrl = getStylesheetsForUrl(str);
        if (stylesheetsForUrl == null) {
            return "";
        }
        a.d("Elemhide selectors for `%s`, %d bytes", str, Integer.valueOf(((String) stylesheetsForUrl.first).length()));
        return (String) stylesheetsForUrl.first;
    }

    public String getInjectJs() {
        return this.injectJs;
    }

    public boolean getJsInIframesEnabled() {
        return this.jsInIframesEnabled.get() && getSiteKeysConfiguration() != null;
    }

    public String getNavigationUrl() {
        return this.navigationUrl.get();
    }

    public SiteKeyExtractor getSiteKeyExtractor() {
        return this.siteKeyExtractor;
    }

    public SiteKeysConfiguration getSiteKeysConfiguration() {
        return this.siteKeysConfiguration.get();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        if (this.loading) {
            stopAbpLoading();
        }
        if (canGoBack()) {
            this.navigationUrl.set(null);
            this.siteKeyExtractor.startNewPage();
        }
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goForward() {
        if (this.loading) {
            stopAbpLoading();
        }
        if (canGoForward()) {
            this.navigationUrl.set(null);
            this.siteKeyExtractor.startNewPage();
        }
        super.goForward();
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        loadUrlCommon();
        super.loadData(str, str2, str3);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        loadUrlCommon();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        loadUrlCommon();
        super.loadUrl(str);
    }

    @Override // android.webkit.WebView
    public void reload() {
        ensureProvider();
        if (this.loading) {
            stopAbpLoading();
        }
        super.reload();
    }

    @Override // android.webkit.WebView
    public WebBackForwardList restoreState(Bundle bundle) {
        this.siteKeyExtractor.startNewPage();
        return super.restoreState(bundle);
    }

    public void setEventsListener(EventsListener eventsListener) {
        this.eventsListenerAtomicReference.set(eventsListener);
    }

    public void setProvider(final AdblockEngineProvider adblockEngineProvider) {
        if (adblockEngineProvider == null) {
            throw new IllegalArgumentException("Provider cannot be null");
        }
        if (getProvider() == adblockEngineProvider) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.4
            @Override // java.lang.Runnable
            public void run() {
                AdblockWebView.this.providerReference.set(adblockEngineProvider);
                ReentrantReadWriteLock.ReadLock readEngineLock = adblockEngineProvider.getReadEngineLock();
                boolean zTryLock = readEngineLock.tryLock();
                try {
                    AdblockWebView.this.getProvider().retain(true);
                    if (!zTryLock || AdblockWebView.this.getProvider().getEngine() == null) {
                        AdblockWebView.this.getProvider().addEngineCreatedListener(AdblockWebView.this.engineCreatedCb);
                        AdblockWebView.this.getProvider().addEngineDisposedListener(AdblockWebView.this.engineDisposedCb);
                    } else {
                        AdblockWebView.this.adblockEnabled.set(OptionalBoolean.from(AdblockWebView.this.getProvider().getEngine().isEnabled()));
                        a.d("Filter Engine already created, enable status is %s", AdblockWebView.this.adblockEnabled);
                        AdblockWebView.this.getProvider().getEngine().addSettingsChangedListener(AdblockWebView.this.engineSettingsChangedCb);
                    }
                } finally {
                    if (zTryLock) {
                        readEngineLock.unlock();
                    }
                }
            }
        };
        if (getProvider() != null) {
            dispose(runnable);
        } else {
            runnable.run();
        }
    }

    public void setSiteKeyExtractor(SiteKeyExtractor siteKeyExtractor) {
        this.siteKeyExtractor = siteKeyExtractor;
    }

    public void setSiteKeysConfiguration(SiteKeysConfiguration siteKeysConfiguration) {
        this.siteKeysConfiguration.set(siteKeysConfiguration);
        this.siteKeyExtractor.setSiteKeysConfiguration(siteKeysConfiguration);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        this.intWebChromeClient.setExtWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        this.intWebViewClient.setExtWebViewClient(webViewClient);
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        stopAbpLoading();
        super.stopLoading();
    }

    public class AdblockWebViewClient extends ProxyWebViewClient {
        public AdblockWebViewClient(WebViewClient webViewClient) {
            super(webViewClient);
        }

        private String getFirstParent(List<String> list) {
            return (list == null || list.size() == 0) ? "" : list.get(0);
        }

        private AbpShouldBlockResult notifyAndReturnBlockingResponse(String str, List<String> list, FilterEngine.ContentType contentType) {
            if (AdblockWebView.this.isVisibleResource(contentType)) {
                AdblockWebView.this.elemhideBlockedResource(str);
            }
            AdblockWebView.this.notifyResourceBlocked(new EventsListener.BlockedResourceInfo(str, list, contentType));
            return AbpShouldBlockResult.BLOCK_LOAD;
        }

        private AbpShouldBlockResult shouldAbpBlockRequest(WebResourceRequest webResourceRequest) {
            boolean z10;
            String str;
            String str2;
            FilterEngine.ContentType contentType;
            String str3;
            List<String> list;
            AdblockEngine.MatchesResult matchesResultMatches;
            String str4;
            boolean z11;
            String str5;
            FilterEngine.ContentType contentType2;
            String str6;
            String str7;
            String str8;
            AdblockEngine.MatchesResult matchesResult;
            AdblockEngine.MatchesResult matchesResultMatches2;
            String string = webResourceRequest.getUrl().toString();
            String urlWithoutFragment = Utils.getUrlWithoutFragment(string);
            boolean zIsForMainFrame = webResourceRequest.isForMainFrame();
            String str9 = webResourceRequest.getRequestHeaders().get("Referer");
            ReentrantReadWriteLock.ReadLock readEngineLock = AdblockWebView.this.getProvider().getReadEngineLock();
            readEngineLock.lock();
            try {
                boolean z12 = true;
                boolean z13 = false;
                if (AdblockWebView.this.getProvider().getCounter() != 0) {
                    readEngineLock.unlock();
                    AdblockWebView.this.getProvider().waitForReady();
                    readEngineLock.lock();
                    z10 = AdblockWebView.this.getProvider().getCounter() == 0;
                }
                AdblockEngine engine = AdblockWebView.this.getProvider().getEngine();
                if (!z10 && engine != null) {
                    if (AdblockWebView.this.adblockEnabled.get() == OptionalBoolean.UNDEFINED) {
                        a.e("No adblockEnabled value", new Object[0]);
                        return AbpShouldBlockResult.NOT_ENABLED;
                    }
                    OptionalBoolean optionalBooleanFrom = OptionalBoolean.from(engine.isEnabled());
                    AdblockWebView.this.adblockEnabled.set(optionalBooleanFrom);
                    if (optionalBooleanFrom == OptionalBoolean.FALSE) {
                        a.d("adblockEnabled = false", new Object[0]);
                        return AbpShouldBlockResult.NOT_ENABLED;
                    }
                    a.d("Loading url %s", string);
                    if (str9 != null) {
                        a.d("Header referrer for %s is %s", string, str9);
                        if (string.equals(str9)) {
                            a.w("Header referrer value is the same as url, skipping url2Referrer.put()", new Object[0]);
                        } else {
                            AdblockWebView.this.url2Referrer.put(urlWithoutFragment, str9);
                        }
                    } else {
                        a.w("No referrer header for %s", string);
                    }
                    boolean z14 = engine.isAcceptableAdsEnabled() || AdblockWebView.this.getJsInIframesEnabled();
                    if (zIsForMainFrame) {
                        a.w("%s is main frame, allow loading", string);
                        AdblockWebView.this.siteKeyExtractor.setEnabled(z14);
                        AdblockWebView.this.clearStylesheets();
                        AdblockWebView.this.generateStylesheetForUrl(urlWithoutFragment, true);
                        z12 = false;
                    } else {
                        List<String> listBuildFramesHierarchy = AdblockWebView.this.buildFramesHierarchy(urlWithoutFragment);
                        SiteKeysConfiguration siteKeysConfiguration = AdblockWebView.this.getSiteKeysConfiguration();
                        String strStripPadding = siteKeysConfiguration != null ? PublicKeyHolderImpl.stripPadding(siteKeysConfiguration.getPublicKeyHolder().getAny(listBuildFramesHierarchy, "")) : null;
                        FilterEngine.ContentType contentTypeDetect = AdblockWebView.this.ensureContentTypeDetectorCreatedAndGet().detect(webResourceRequest);
                        if (contentTypeDetect == null) {
                            a.w("contentTypeDetector didn't recognize content type", new Object[0]);
                            contentTypeDetect = FilterEngine.ContentType.OTHER;
                        }
                        FilterEngine.ContentType contentType3 = contentTypeDetect;
                        if (contentType3 == FilterEngine.ContentType.SUBDOCUMENT && str9 != null) {
                            try {
                                AdblockWebView.this.url2Referrer.put(Utils.getOrigin(string), str9);
                            } catch (IllegalArgumentException | MalformedURLException e10) {
                                a.e(e10, "Failed to extract origin from %s", string);
                            }
                        }
                        FilterEngine.ContentType contentType4 = FilterEngine.ContentType.DOCUMENT;
                        if (engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType4), listBuildFramesHierarchy, strStripPadding)) {
                            a.w("%s document is allowlisted, allow loading", string);
                            AdblockWebView.this.notifyResourceAllowlisted(new EventsListener.AllowlistedResourceInfo(string, listBuildFramesHierarchy, EventsListener.AllowlistReason.DOCUMENT));
                        } else {
                            boolean z15 = contentType3 == FilterEngine.ContentType.SUBDOCUMENT || contentType3 == FilterEngine.ContentType.OTHER;
                            FilterEngine.ContentType contentType5 = FilterEngine.ContentType.GENERICBLOCK;
                            boolean zIsContentAllowlisted = engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType5), listBuildFramesHierarchy, strStripPadding);
                            if (zIsContentAllowlisted) {
                                a.w("Found genericblock filter for url %s", string);
                            }
                            if (engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType3), listBuildFramesHierarchy, strStripPadding)) {
                                matchesResultMatches = AdblockEngine.MatchesResult.ALLOWLISTED;
                                str = "Found genericblock filter for url %s";
                                str2 = "%s document is allowlisted, allow loading";
                                contentType = contentType3;
                                str3 = "";
                                list = listBuildFramesHierarchy;
                            } else {
                                str = "Found genericblock filter for url %s";
                                str2 = "%s document is allowlisted, allow loading";
                                contentType = contentType3;
                                str3 = "";
                                list = listBuildFramesHierarchy;
                                matchesResultMatches = engine.matches(string, FilterEngine.ContentType.maskOf(contentType3), getFirstParent(listBuildFramesHierarchy), strStripPadding, zIsContentAllowlisted);
                            }
                            AdblockEngine.MatchesResult matchesResult2 = AdblockEngine.MatchesResult.BLOCKED;
                            if (matchesResultMatches == matchesResult2) {
                                a.i("Attempting to block request with AA on the first try: %s", string);
                                String str10 = "enabled";
                                if (AdblockWebView.this.siteKeyExtractor.waitForSitekeyCheck(string, zIsForMainFrame)) {
                                    a.i("Restarting the check having waited for the sitekey: %s", string);
                                    String strStripPadding2 = siteKeysConfiguration != null ? PublicKeyHolderImpl.stripPadding(siteKeysConfiguration.getPublicKeyHolder().getAny(list, str3)) : null;
                                    if (strStripPadding2 != null && !strStripPadding2.isEmpty()) {
                                        if (engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType4), list, strStripPadding2)) {
                                            a.w(str2, string);
                                            AdblockWebView.this.notifyResourceAllowlisted(new EventsListener.AllowlistedResourceInfo(string, list, EventsListener.AllowlistReason.DOCUMENT));
                                            str4 = "Allowed loading %s";
                                            str5 = "Blocked loading %s with sitekeyCheckEnabled %s";
                                            contentType2 = contentType;
                                            z11 = true;
                                        } else {
                                            boolean zIsContentAllowlisted2 = engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType5), list, strStripPadding2);
                                            if (zIsContentAllowlisted2) {
                                                a.w(str, string);
                                            }
                                            contentType2 = contentType;
                                            if (engine.isContentAllowlisted(string, FilterEngine.ContentType.maskOf(contentType2), list, strStripPadding2)) {
                                                matchesResultMatches2 = AdblockEngine.MatchesResult.ALLOWLISTED;
                                                str6 = "Allowed loading %s";
                                                str7 = "Blocked loading %s with sitekeyCheckEnabled %s";
                                                str8 = "%s is allowlisted in matches()";
                                                matchesResult = matchesResult2;
                                            } else {
                                                str6 = "Allowed loading %s";
                                                str7 = "Blocked loading %s with sitekeyCheckEnabled %s";
                                                str8 = "%s is allowlisted in matches()";
                                                matchesResult = matchesResult2;
                                                matchesResultMatches2 = engine.matches(string, FilterEngine.ContentType.maskOf(contentType2), getFirstParent(list), strStripPadding2, zIsContentAllowlisted2);
                                            }
                                            if (matchesResultMatches2 == matchesResult) {
                                                Object[] objArr = new Object[2];
                                                objArr[0] = string;
                                                if (!z14) {
                                                    str10 = "disabled";
                                                }
                                                objArr[1] = str10;
                                                a.i(str7, objArr);
                                                return notifyAndReturnBlockingResponse(string, list, contentType2);
                                            }
                                            str5 = str7;
                                            if (matchesResultMatches2 == AdblockEngine.MatchesResult.ALLOWLISTED) {
                                                a.w(str8, string);
                                                AdblockWebView.this.notifyResourceAllowlisted(new EventsListener.AllowlistedResourceInfo(string, list, EventsListener.AllowlistReason.FILTER));
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            str4 = str6;
                                            a.d(str4, string);
                                        }
                                    }
                                    a.i("SiteKey is not found, blocking the resource %s", string);
                                    return notifyAndReturnBlockingResponse(string, list, contentType);
                                }
                                str4 = "Allowed loading %s";
                                str5 = "Blocked loading %s with sitekeyCheckEnabled %s";
                                contentType2 = contentType;
                                z11 = false;
                                if (!z11) {
                                    Object[] objArr2 = new Object[2];
                                    objArr2[0] = string;
                                    if (!z14) {
                                        str10 = "disabled";
                                    }
                                    objArr2[1] = str10;
                                    a.i(str5, objArr2);
                                    return notifyAndReturnBlockingResponse(string, list, contentType2);
                                }
                            } else {
                                str4 = "Allowed loading %s";
                                if (matchesResultMatches == AdblockEngine.MatchesResult.ALLOWLISTED) {
                                    a.w("%s is allowlisted in matches()", string);
                                    AdblockWebView.this.notifyResourceAllowlisted(new EventsListener.AllowlistedResourceInfo(string, list, EventsListener.AllowlistReason.FILTER));
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                            }
                            a.d(str4, string);
                            z13 = z15;
                            z12 = z11;
                        }
                    }
                    readEngineLock.unlock();
                    SiteKeysConfiguration siteKeysConfiguration2 = AdblockWebView.this.getSiteKeysConfiguration();
                    return ((z14 || (siteKeysConfiguration2 != null && siteKeysConfiguration2.getForceChecks())) && (zIsForMainFrame || (z13 && !z12))) ? AbpShouldBlockResult.ALLOW_LOAD : AbpShouldBlockResult.ALLOW_LOAD_NO_SITEKEY_CHECK;
                }
                a.e("FilterEngine already disposed", new Object[0]);
                return AbpShouldBlockResult.NOT_ENABLED;
            } finally {
                readEngineLock.unlock();
            }
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            a.d("onPageFinished called for url %s", str);
            AdblockWebView.this.loading = false;
            super.onPageFinished(webView, str);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            a.d("onPageStarted called for url %s", str);
            if (AdblockWebView.this.loading) {
                AdblockWebView.this.stopAbpLoading();
            }
            AdblockWebView.this.startAbpLoading(str);
            AdblockWebView.this.notifyNavigation();
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i10, String str, String str2) {
            a.e("onReceivedError: code=%d with description=%s for url=%s", Integer.valueOf(i10), str, str2);
            AdblockWebView.this.loadError = Integer.valueOf(i10);
            super.onReceivedError(webView, i10, str, str2);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse webResourceResponseShouldInterceptRequest;
            if (webResourceRequest.isForMainFrame()) {
                a.d("Updating navigationUrl to `%s`", webResourceRequest.getUrl().toString());
                AdblockWebView.this.navigationUrl.set(Utils.getUrlWithoutFragment(webResourceRequest.getUrl().toString()));
            }
            AbpShouldBlockResult abpShouldBlockResultShouldAbpBlockRequest = shouldAbpBlockRequest(webResourceRequest);
            if (AbpShouldBlockResult.NOT_ENABLED.equals(abpShouldBlockResultShouldAbpBlockRequest)) {
                AdblockWebView.this.clearStylesheets();
                return WebResponseResult.ALLOW_LOAD;
            }
            if (AbpShouldBlockResult.BLOCK_LOAD.equals(abpShouldBlockResultShouldAbpBlockRequest)) {
                return WebResponseResult.BLOCK_LOAD;
            }
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            String string = webResourceRequest.getUrl().toString();
            WebViewClient extWebViewClient = getExtWebViewClient();
            if (extWebViewClient == null || (webResourceResponseShouldInterceptRequest = extWebViewClient.shouldInterceptRequest(webView, webResourceRequest)) == null) {
                if (AbpShouldBlockResult.ALLOW_LOAD_NO_SITEKEY_CHECK.equals(abpShouldBlockResultShouldAbpBlockRequest)) {
                    return WebResponseResult.ALLOW_LOAD;
                }
                if (!requestHeaders.containsKey("Range")) {
                    return AdblockWebView.this.siteKeyExtractor.extract(webResourceRequest);
                }
                a.d("Skipping site key check for the request with a Range header", new Object[0]);
                return WebResponseResult.ALLOW_LOAD;
            }
            if (AbpShouldBlockResult.ALLOW_LOAD_NO_SITEKEY_CHECK.equals(abpShouldBlockResultShouldAbpBlockRequest)) {
                a.d("Skipped verifying of the site keys with external shouldInterceptRequest response", new Object[0]);
            } else {
                a.d("Verifying site keys with external shouldInterceptRequest response", new Object[0]);
                AdblockWebView.this.getSiteKeysConfiguration().getSiteKeyVerifier().verifyInHeaders(string, requestHeaders, webResourceResponseShouldInterceptRequest.getResponseHeaders());
                a.d("Finished verifying, returning external response and stop", new Object[0]);
            }
            return webResourceResponseShouldInterceptRequest;
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            a.d("shouldOverrideUrlLoading called for view.getUrl() %s", webView.getUrl());
            AdblockWebView.this.clearReferrers();
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            a.d("shouldOverrideUrlLoading called for url %s", str);
            AdblockWebView.this.clearReferrers();
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // org.adblockplus.libadblockplus.android.webview.ProxyWebViewClient, android.webkit.WebViewClient
        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            a.e("onReceivedError: code=%d with description=%s for url=%s request.isForMainFrame()=%s", Integer.valueOf(webResourceError.getErrorCode()), webResourceError.getDescription(), webResourceRequest.getUrl(), Boolean.valueOf(webResourceRequest.isForMainFrame()));
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        loadUrlCommon();
        super.loadUrl(str, map);
    }

    public AdblockWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.providerReference = new AtomicReference<>();
        this.url2Referrer = Collections.synchronizedMap(new HashMap());
        this.url2Stylesheets = Collections.synchronizedMap(new HashMap());
        this.navigationUrl = new AtomicReference<>();
        this.adblockEnabled = new AtomicReference<>(OptionalBoolean.UNDEFINED);
        this.eventsListenerAtomicReference = new AtomicReference<>();
        this.siteKeysConfiguration = new AtomicReference<>();
        this.jsInIframesEnabled = new AtomicBoolean(false);
        this.engineSettingsChangedCb = new AdblockEngine.SettingsChangedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1
            @Override // org.adblockplus.libadblockplus.android.AdblockEngine.SettingsChangedListener
            public void onEnableStateChanged(boolean z10) {
                OptionalBoolean optionalBooleanFrom = OptionalBoolean.from(z10);
                OptionalBoolean optionalBoolean = (OptionalBoolean) AdblockWebView.this.adblockEnabled.getAndSet(optionalBooleanFrom);
                if (optionalBoolean == OptionalBoolean.UNDEFINED || optionalBoolean == optionalBooleanFrom) {
                    return;
                }
                a.d("Filter Engine status changed, enable status is %s", optionalBooleanFrom);
                AdblockWebView.this.post(new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdblockWebView.this.clearCache(true);
                    }
                });
            }
        };
        this.engineCreatedCb = new AdblockEngineProvider.EngineCreatedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.2
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineCreatedListener
            public void onAdblockEngineCreated(AdblockEngine adblockEngine) {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.from(adblockEngine.isEnabled()));
                a.d("Filter Engine created, enable status is %s", AdblockWebView.this.adblockEnabled.get());
                adblockEngine.addSettingsChangedListener(AdblockWebView.this.engineSettingsChangedCb);
            }
        };
        this.engineDisposedCb = new AdblockEngineProvider.EngineDisposedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.3
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineDisposedListener
            public void onAdblockEngineDisposed() {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.UNDEFINED);
            }
        };
        initAbp();
    }

    public AdblockWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.providerReference = new AtomicReference<>();
        this.url2Referrer = Collections.synchronizedMap(new HashMap());
        this.url2Stylesheets = Collections.synchronizedMap(new HashMap());
        this.navigationUrl = new AtomicReference<>();
        this.adblockEnabled = new AtomicReference<>(OptionalBoolean.UNDEFINED);
        this.eventsListenerAtomicReference = new AtomicReference<>();
        this.siteKeysConfiguration = new AtomicReference<>();
        this.jsInIframesEnabled = new AtomicBoolean(false);
        this.engineSettingsChangedCb = new AdblockEngine.SettingsChangedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1
            @Override // org.adblockplus.libadblockplus.android.AdblockEngine.SettingsChangedListener
            public void onEnableStateChanged(boolean z10) {
                OptionalBoolean optionalBooleanFrom = OptionalBoolean.from(z10);
                OptionalBoolean optionalBoolean = (OptionalBoolean) AdblockWebView.this.adblockEnabled.getAndSet(optionalBooleanFrom);
                if (optionalBoolean == OptionalBoolean.UNDEFINED || optionalBoolean == optionalBooleanFrom) {
                    return;
                }
                a.d("Filter Engine status changed, enable status is %s", optionalBooleanFrom);
                AdblockWebView.this.post(new Runnable() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdblockWebView.this.clearCache(true);
                    }
                });
            }
        };
        this.engineCreatedCb = new AdblockEngineProvider.EngineCreatedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.2
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineCreatedListener
            public void onAdblockEngineCreated(AdblockEngine adblockEngine) {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.from(adblockEngine.isEnabled()));
                a.d("Filter Engine created, enable status is %s", AdblockWebView.this.adblockEnabled.get());
                adblockEngine.addSettingsChangedListener(AdblockWebView.this.engineSettingsChangedCb);
            }
        };
        this.engineDisposedCb = new AdblockEngineProvider.EngineDisposedListener() { // from class: org.adblockplus.libadblockplus.android.webview.AdblockWebView.3
            @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider.EngineDisposedListener
            public void onAdblockEngineDisposed() {
                AdblockWebView.this.adblockEnabled.set(OptionalBoolean.UNDEFINED);
            }
        };
        initAbp();
    }
}
