package lf;

import java.lang.reflect.InvocationTargetException;
import zf.i;

/* compiled from: Exceptions.kt */
/* loaded from: classes2.dex */
public class a {
    public static final void addSuppressed(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(th2, "<this>");
        i.checkNotNullParameter(th3, "exception");
        if (th2 != th3) {
            tf.b.f19915a.addSuppressed(th2, th3);
        }
    }
}
