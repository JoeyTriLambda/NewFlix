package vf;

import kotlin.random.Random;

/* compiled from: JDK8PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a extends uf.a {

    /* compiled from: JDK8PlatformImplementations.kt */
    /* renamed from: vf.a$a, reason: collision with other inner class name */
    public static final class C0300a {

        /* renamed from: a, reason: collision with root package name */
        public static final Integer f20776a;

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
            f20776a = num;
        }
    }

    @Override // tf.a
    public Random defaultPlatformRandom() {
        Integer num = C0300a.f20776a;
        return num == null || num.intValue() >= 34 ? new eg.a() : super.defaultPlatformRandom();
    }
}
