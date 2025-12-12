package tf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.random.Random;
import zf.i;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: PlatformImplementations.kt */
    /* renamed from: tf.a$a, reason: collision with other inner class name */
    public static final class C0281a {

        /* renamed from: a, reason: collision with root package name */
        public static final Method f19914a;

        /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                zf.i.checkNotNullExpressionValue(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                if (r4 >= r2) goto L3a
                r5 = r1[r4]
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = zf.i.areEqual(r6, r7)
                if (r6 == 0) goto L33
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                zf.i.checkNotNullExpressionValue(r6, r7)
                java.lang.Object r6 = mf.i.singleOrNull(r6)
                boolean r6 = zf.i.areEqual(r6, r0)
                if (r6 == 0) goto L33
                r6 = 1
                goto L34
            L33:
                r6 = 0
            L34:
                if (r6 == 0) goto L37
                goto L3b
            L37:
                int r4 = r4 + 1
                goto Le
            L3a:
                r5 = 0
            L3b:
                tf.a.C0281a.f19914a = r5
                int r0 = r1.length
            L3e:
                if (r3 >= r0) goto L52
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = zf.i.areEqual(r2, r4)
                if (r2 == 0) goto L4f
                goto L52
            L4f:
                int r3 = r3 + 1
                goto L3e
            L52:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tf.a.C0281a.<clinit>():void");
        }
    }

    public void addSuppressed(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(th2, "cause");
        i.checkNotNullParameter(th3, "exception");
        Method method = C0281a.f19914a;
        if (method != null) {
            method.invoke(th2, th3);
        }
    }

    public Random defaultPlatformRandom() {
        return new dg.b();
    }
}
