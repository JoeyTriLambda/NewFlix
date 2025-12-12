package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Contract(threading = ThreadingBehavior.IMMUTABLE)
@Deprecated
/* loaded from: classes2.dex */
public class JdkIdn implements Idn {
    private final Method toUnicode;

    public JdkIdn() throws ClassNotFoundException {
        try {
            this.toUnicode = Class.forName("java.net.IDN").getMethod("toUnicode", String.class);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        } catch (SecurityException e11) {
            throw new IllegalStateException(e11.getMessage(), e11);
        }
    }

    @Override // cz.msebera.android.httpclient.client.utils.Idn
    public String toUnicode(String str) {
        try {
            return (String) this.toUnicode.invoke(null, str);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            throw new RuntimeException(cause.getMessage(), cause);
        }
    }
}
