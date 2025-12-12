package v2;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: WebViewProviderFactoryAdapter.java */
/* loaded from: classes.dex */
public final class p implements o {

    /* renamed from: a, reason: collision with root package name */
    public final WebViewProviderFactoryBoundaryInterface f20444a;

    public p(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f20444a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // v2.o
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.f20444a.createWebView(webView));
    }

    @Override // v2.o
    public String[] getWebViewFeatures() {
        return this.f20444a.getSupportedFeatures();
    }
}
