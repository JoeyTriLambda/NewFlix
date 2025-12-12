package okhttp3.internal.platform.android;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import zf.f;
import zf.i;

/* compiled from: CloseGuard.kt */
/* loaded from: classes2.dex */
public final class CloseGuard {
    public static final Companion Companion = new Companion(null);
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    /* compiled from: CloseGuard.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final CloseGuard get() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod(AbstractCircuitBreaker.PROPERTY_NAME, String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new CloseGuard(method, method3, method2);
        }
    }

    public CloseGuard(Method method, Method method2, Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    public final Object createAndOpen(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(str, "closer");
        Method method = this.getMethod;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.openMethod;
                i.checkNotNull(method2);
                method2.invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.warnIfOpenMethod;
            i.checkNotNull(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
