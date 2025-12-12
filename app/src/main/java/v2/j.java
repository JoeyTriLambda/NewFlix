package v2;

import android.net.Uri;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import u2.e;

/* compiled from: WebMessageListenerAdapter.java */
/* loaded from: classes.dex */
public final class j implements WebMessageListenerBoundaryInterface {

    /* renamed from: a, reason: collision with root package name */
    public final e.a f20437a;

    public j(e.a aVar) {
        this.f20437a = aVar;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER"};
    }

    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z10, InvocationHandler invocationHandler2) {
        u2.c cVarWebMessageCompatFromBoundaryInterface = i.webMessageCompatFromBoundaryInterface((WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, invocationHandler));
        if (cVarWebMessageCompatFromBoundaryInterface != null) {
            ((com.unity3d.services.core.webview.a) this.f20437a).a(webView, cVarWebMessageCompatFromBoundaryInterface, uri, z10, g.forInvocationHandler(invocationHandler2));
        }
    }
}
