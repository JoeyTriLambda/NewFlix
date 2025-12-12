package v2;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* compiled from: WebViewProviderFactory.java */
/* loaded from: classes.dex */
public interface o {
    WebViewProviderBoundaryInterface createWebView(WebView webView);

    String[] getWebViewFeatures();
}
