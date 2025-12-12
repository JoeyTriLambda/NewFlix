package org.adblockplus.libadblockplus.android.webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import bi.a;
import org.adblockplus.libadblockplus.android.webview.AdblockWebView;
import org.adblockplus.libadblockplus.sitekey.SiteKeysConfiguration;

/* loaded from: classes2.dex */
public class CombinedSiteKeyExtractor implements SiteKeyExtractor {
    private final SiteKeyExtractor httpExtractor;
    private final SiteKeyExtractor jsExtractor;

    public CombinedSiteKeyExtractor(AdblockWebView adblockWebView) {
        this.httpExtractor = new HttpHeaderSiteKeyExtractor(adblockWebView);
        this.jsExtractor = new JsSiteKeyExtractor(adblockWebView);
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public WebResourceResponse extract(WebResourceRequest webResourceRequest) {
        if (webResourceRequest.isForMainFrame()) {
            return AdblockWebView.WebResponseResult.ALLOW_LOAD;
        }
        a.d("Falling back to native sitekey requests for %s", webResourceRequest.getUrl().toString());
        return this.httpExtractor.extract(webResourceRequest);
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setEnabled(boolean z10) {
        this.httpExtractor.setEnabled(z10);
        this.jsExtractor.setEnabled(z10);
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setSiteKeysConfiguration(SiteKeysConfiguration siteKeysConfiguration) {
        this.httpExtractor.setSiteKeysConfiguration(siteKeysConfiguration);
        this.jsExtractor.setSiteKeysConfiguration(siteKeysConfiguration);
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void startNewPage() {
        this.httpExtractor.startNewPage();
        this.jsExtractor.startNewPage();
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public boolean waitForSitekeyCheck(String str, boolean z10) {
        return this.httpExtractor.waitForSitekeyCheck(str, z10) || this.jsExtractor.waitForSitekeyCheck(str, z10);
    }
}
