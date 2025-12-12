package v2;

import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import u2.e;

/* compiled from: WebViewProviderAdapter.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final WebViewProviderBoundaryInterface f20443a;

    public n(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.f20443a = webViewProviderBoundaryInterface;
    }

    public void addWebMessageListener(String str, String[] strArr, e.a aVar) {
        this.f20443a.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new j(aVar)));
    }
}
