package wf;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Closeable.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final void closeFinally(Closeable closeable, Throwable th2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable != null) {
            if (th2 == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th3) {
                lf.a.addSuppressed(th2, th3);
            }
        }
    }
}
