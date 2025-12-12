package cz.msebera.android.httpclient.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Deprecated
/* loaded from: classes2.dex */
public final class ExceptionUtils {
    private static final Method INIT_CAUSE_METHOD = getInitCauseMethod();

    private ExceptionUtils() {
    }

    private static Method getInitCauseMethod() {
        try {
            return Throwable.class.getMethod("initCause", Throwable.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static void initCause(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = INIT_CAUSE_METHOD;
        if (method != null) {
            try {
                method.invoke(th2, th3);
            } catch (Exception unused) {
            }
        }
    }
}
