package v2;

import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: WebMessagePortImpl.java */
/* loaded from: classes.dex */
public final class k extends u2.d {

    /* renamed from: a, reason: collision with root package name */
    public final WebMessagePortBoundaryInterface f20438a;

    public k(InvocationHandler invocationHandler) {
        this.f20438a = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
