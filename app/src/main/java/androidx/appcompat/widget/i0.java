package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: DrawableUtils.java */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1373a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1374b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f1375c = new Rect();

    /* compiled from: DrawableUtils.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f1376a;

        /* renamed from: b, reason: collision with root package name */
        public static final Method f1377b;

        /* renamed from: c, reason: collision with root package name */
        public static final Field f1378c;

        /* renamed from: d, reason: collision with root package name */
        public static final Field f1379d;

        /* renamed from: e, reason: collision with root package name */
        public static final Field f1380e;

        /* renamed from: f, reason: collision with root package name */
        public static final Field f1381f;

        /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch: java.lang.NoSuchFieldException -> L44 java.lang.ClassNotFoundException -> L49 java.lang.NoSuchMethodException -> L4e
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L3b java.lang.ClassNotFoundException -> L3e java.lang.NoSuchMethodException -> L41
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L32 java.lang.ClassNotFoundException -> L35 java.lang.NoSuchMethodException -> L38
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2f
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L2d
                r8 = 1
                goto L55
            L2d:
                goto L53
            L2f:
                r7 = r1
                goto L53
            L32:
                r6 = r1
                goto L52
            L35:
                r6 = r1
                goto L52
            L38:
                r6 = r1
                goto L52
            L3b:
                r5 = r1
                goto L47
            L3e:
                r5 = r1
                goto L4c
            L41:
                r5 = r1
                goto L51
            L44:
                r4 = r1
                r5 = r4
            L47:
                r6 = r5
                goto L52
            L49:
                r4 = r1
                r5 = r4
            L4c:
                r6 = r5
                goto L52
            L4e:
                r4 = r1
                r5 = r4
            L51:
                r6 = r5
            L52:
                r7 = r6
            L53:
                r3 = r1
                r8 = 0
            L55:
                if (r8 == 0) goto L64
                androidx.appcompat.widget.i0.a.f1377b = r4
                androidx.appcompat.widget.i0.a.f1378c = r5
                androidx.appcompat.widget.i0.a.f1379d = r6
                androidx.appcompat.widget.i0.a.f1380e = r7
                androidx.appcompat.widget.i0.a.f1381f = r3
                androidx.appcompat.widget.i0.a.f1376a = r0
                goto L70
            L64:
                androidx.appcompat.widget.i0.a.f1377b = r1
                androidx.appcompat.widget.i0.a.f1378c = r1
                androidx.appcompat.widget.i0.a.f1379d = r1
                androidx.appcompat.widget.i0.a.f1380e = r1
                androidx.appcompat.widget.i0.a.f1381f = r1
                androidx.appcompat.widget.i0.a.f1376a = r2
            L70:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i0.a.<clinit>():void");
        }
    }

    /* compiled from: DrawableUtils.java */
    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        int[] iArr = f1374b;
        int[] iArr2 = f1373a;
        if (i10 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(iArr2);
            } else {
                drawable.setState(iArr);
            }
            drawable.setState(state);
            return;
        }
        if (i10 < 29 || i10 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state2 = drawable.getState();
        if (state2 == null || state2.length == 0) {
            drawable.setState(iArr2);
        } else {
            drawable.setState(iArr);
        }
        drawable.setState(state2);
    }

    public static boolean canSafelyMutateDrawable(Drawable drawable) {
        return true;
    }

    public static Rect getOpticalBounds(Drawable drawable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            Insets insetsA = b.a(drawable);
            return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
        }
        Drawable drawableUnwrap = p0.a.unwrap(drawable);
        if (i10 >= 29) {
            boolean z10 = a.f1376a;
        } else if (a.f1376a) {
            try {
                Object objInvoke = a.f1377b.invoke(drawableUnwrap, new Object[0]);
                if (objInvoke != null) {
                    return new Rect(a.f1378c.getInt(objInvoke), a.f1379d.getInt(objInvoke), a.f1380e.getInt(objInvoke), a.f1381f.getInt(objInvoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f1375c;
    }

    public static PorterDuff.Mode parseTintMode(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
