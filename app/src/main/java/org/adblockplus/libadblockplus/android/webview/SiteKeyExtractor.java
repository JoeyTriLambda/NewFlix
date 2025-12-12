package org.adblockplus.libadblockplus.android.webview;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import org.adblockplus.libadblockplus.sitekey.SiteKeysConfiguration;

/* loaded from: classes2.dex */
public interface SiteKeyExtractor {
    WebResourceResponse extract(WebResourceRequest webResourceRequest);

    void setEnabled(boolean z10);

    void setSiteKeysConfiguration(SiteKeysConfiguration siteKeysConfiguration);

    void startNewPage();

    boolean waitForSitekeyCheck(String str, boolean z10);
}
