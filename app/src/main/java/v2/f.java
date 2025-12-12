package v2;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* compiled from: IncompatibleApkWebViewProviderFactory.java */
/* loaded from: classes.dex */
public final class f implements o {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f20433a = new String[0];

    @Override // v2.o
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // v2.o
    public String[] getWebViewFeatures() {
        return f20433a;
    }
}
