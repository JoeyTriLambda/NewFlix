package org.adblockplus.libadblockplus.android.webview;

import java.lang.ref.WeakReference;
import org.adblockplus.libadblockplus.sitekey.SiteKeysConfiguration;

/* loaded from: classes2.dex */
public abstract class BaseSiteKeyExtractor implements SiteKeyExtractor {
    public static final int RESOURCE_HOLD_MAX_TIME_MS = 1000;
    private boolean isEnabled = true;
    private SiteKeysConfiguration siteKeysConfiguration;
    protected final WeakReference<AdblockWebView> webViewWeakReference;

    public BaseSiteKeyExtractor(AdblockWebView adblockWebView) {
        this.webViewWeakReference = new WeakReference<>(adblockWebView);
    }

    public SiteKeysConfiguration getSiteKeysConfiguration() {
        return this.siteKeysConfiguration;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setEnabled(boolean z10) {
        this.isEnabled = z10;
    }

    @Override // org.adblockplus.libadblockplus.android.webview.SiteKeyExtractor
    public void setSiteKeysConfiguration(SiteKeysConfiguration siteKeysConfiguration) {
        this.siteKeysConfiguration = siteKeysConfiguration;
    }
}
