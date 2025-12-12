package v2;

import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: JavaScriptReplyProxyImpl.java */
/* loaded from: classes.dex */
public final class g extends u2.a {

    /* renamed from: a, reason: collision with root package name */
    public final JsReplyProxyBoundaryInterface f20434a;

    /* compiled from: JavaScriptReplyProxyImpl.java */
    public class a implements Callable<Object> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JsReplyProxyBoundaryInterface f20435b;

        public a(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
            this.f20435b = jsReplyProxyBoundaryInterface;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return new g(this.f20435b);
        }
    }

    public g(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f20434a = jsReplyProxyBoundaryInterface;
    }

    public static g forInvocationHandler(InvocationHandler invocationHandler) {
        JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (g) jsReplyProxyBoundaryInterface.getOrCreatePeer(new a(jsReplyProxyBoundaryInterface));
    }
}
