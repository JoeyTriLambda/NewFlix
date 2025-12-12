package uf;

import java.lang.reflect.InvocationTargetException;
import zf.i;

/* compiled from: JDK7PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a extends tf.a {

    /* compiled from: JDK7PlatformImplementations.kt */
    /* renamed from: uf.a$a, reason: collision with other inner class name */
    public static final class C0289a {

        /* renamed from: a, reason: collision with root package name */
        public static final Integer f20376a;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null) {
                if (num2.intValue() > 0) {
                    num = num2;
                }
            }
            f20376a = num;
        }
    }

    @Override // tf.a
    public void addSuppressed(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(th2, "cause");
        i.checkNotNullParameter(th3, "exception");
        Integer num = C0289a.f20376a;
        if (num == null || num.intValue() >= 19) {
            th2.addSuppressed(th3);
        } else {
            super.addSuppressed(th2, th3);
        }
    }
}
