package v2;

import android.content.pm.PackageInfo;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: ApiHelperForO.java */
/* loaded from: classes.dex */
public final class c {
    public static PackageInfo getCurrentWebViewPackage() {
        return WebView.getCurrentWebViewPackage();
    }

    public static boolean getSafeBrowsingEnabled(WebSettings webSettings) {
        return webSettings.getSafeBrowsingEnabled();
    }

    public static WebChromeClient getWebChromeClient(WebView webView) {
        return webView.getWebChromeClient();
    }

    public static WebViewClient getWebViewClient(WebView webView) {
        return webView.getWebViewClient();
    }

    public static void setSafeBrowsingEnabled(WebSettings webSettings, boolean z10) {
        webSettings.setSafeBrowsingEnabled(z10);
    }
}
