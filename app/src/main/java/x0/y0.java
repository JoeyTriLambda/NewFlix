package x0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: WindowInsetsCompat.java */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: b, reason: collision with root package name */
    public static final y0 f21340b;

    /* renamed from: a, reason: collision with root package name */
    public final l f21341a;

    /* compiled from: WindowInsetsCompat.java */
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final Field f21342a;

        /* renamed from: b, reason: collision with root package name */
        public static final Field f21343b;

        /* renamed from: c, reason: collision with root package name */
        public static final Field f21344c;

        /* renamed from: d, reason: collision with root package name */
        public static final boolean f21345d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f21342a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f21343b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f21344c = declaredField3;
                declaredField3.setAccessible(true);
                f21345d = true;
            } catch (ReflectiveOperationException e10) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        public static y0 getRootWindowInsets(View view) throws IllegalAccessException, IllegalArgumentException {
            if (!f21345d || !view.isAttachedToWindow()) {
                return null;
            }
            try {
                Object obj = f21342a.get(view.getRootView());
                if (obj == null) {
                    return null;
                }
                Rect rect = (Rect) f21343b.get(obj);
                Rect rect2 = (Rect) f21344c.get(obj);
                if (rect == null || rect2 == null) {
                    return null;
                }
                y0 y0VarBuild = new b().setStableInsets(o0.b.of(rect)).setSystemWindowInsets(o0.b.of(rect2)).build();
                y0VarBuild.f21341a.p(y0VarBuild);
                y0VarBuild.f21341a.d(view.getRootView());
                return y0VarBuild;
            } catch (IllegalAccessException e10) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                return null;
            }
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class e extends d {
        public e() {
        }

        @Override // x0.y0.f
        public void b(int i10, o0.b bVar) {
            this.f21353c.setInsets(n.a(i10), bVar.toPlatformInsets());
        }

        public e(y0 y0Var) {
            super(y0Var);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final y0 f21354a;

        /* renamed from: b, reason: collision with root package name */
        public o0.b[] f21355b;

        public f() {
            this(new y0((y0) null));
        }

        public y0 a() {
            throw null;
        }

        public final void applyInsetTypes() {
            o0.b[] bVarArr = this.f21355b;
            if (bVarArr != null) {
                o0.b insets = bVarArr[m.a(1)];
                o0.b insets2 = this.f21355b[m.a(2)];
                y0 y0Var = this.f21354a;
                if (insets2 == null) {
                    insets2 = y0Var.getInsets(2);
                }
                if (insets == null) {
                    insets = y0Var.getInsets(1);
                }
                f(o0.b.max(insets, insets2));
                o0.b bVar = this.f21355b[m.a(16)];
                if (bVar != null) {
                    e(bVar);
                }
                o0.b bVar2 = this.f21355b[m.a(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                o0.b bVar3 = this.f21355b[m.a(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        public void b(int i10, o0.b bVar) {
            if (this.f21355b == null) {
                this.f21355b = new o0.b[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.f21355b[m.a(i11)] = bVar;
                }
            }
        }

        public void d(o0.b bVar) {
            throw null;
        }

        public void f(o0.b bVar) {
            throw null;
        }

        public f(y0 y0Var) {
            this.f21354a = y0Var;
        }

        public void c(o0.b bVar) {
        }

        public void e(o0.b bVar) {
        }

        public void g(o0.b bVar) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class i extends h {
        public i(y0 y0Var, WindowInsets windowInsets) {
            super(y0Var, windowInsets);
        }

        @Override // x0.y0.l
        public y0 a() {
            return y0.toWindowInsetsCompat(this.f21361c.consumeDisplayCutout());
        }

        @Override // x0.y0.g, x0.y0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f21361c, iVar.f21361c) && Objects.equals(this.f21365g, iVar.f21365g);
        }

        @Override // x0.y0.l
        public x0.f f() {
            DisplayCutout displayCutout = this.f21361c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new x0.f(displayCutout);
        }

        @Override // x0.y0.l
        public int hashCode() {
            return this.f21361c.hashCode();
        }

        public i(y0 y0Var, i iVar) {
            super(y0Var, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class k extends j {

        /* renamed from: q, reason: collision with root package name */
        public static final y0 f21370q = y0.toWindowInsetsCompat(WindowInsets.CONSUMED);

        public k(y0 y0Var, WindowInsets windowInsets) {
            super(y0Var, windowInsets);
        }

        @Override // x0.y0.g, x0.y0.l
        public o0.b getInsets(int i10) {
            return o0.b.toCompatInsets(this.f21361c.getInsets(n.a(i10)));
        }

        public k(y0 y0Var, k kVar) {
            super(y0Var, kVar);
        }

        @Override // x0.y0.g, x0.y0.l
        public final void d(View view) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static final class m {
        public static int a(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException(ac.c.f("type needs to be >= FIRST and <= LAST, type=", i10));
        }

        public static int ime() {
            return 8;
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int systemBars() {
            return 7;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static final class n {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f21340b = k.f21370q;
        } else {
            f21340b = l.f21371b;
        }
    }

    public y0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f21341a = new k(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.f21341a = new j(this, windowInsets);
        } else if (i10 >= 28) {
            this.f21341a = new i(this, windowInsets);
        } else {
            this.f21341a = new h(this, windowInsets);
        }
    }

    public static o0.b a(o0.b bVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, bVar.f16884a - i10);
        int iMax2 = Math.max(0, bVar.f16885b - i11);
        int iMax3 = Math.max(0, bVar.f16886c - i12);
        int iMax4 = Math.max(0, bVar.f16887d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? bVar : o0.b.of(iMax, iMax2, iMax3, iMax4);
    }

    public static y0 toWindowInsetsCompat(WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @Deprecated
    public y0 consumeDisplayCutout() {
        return this.f21341a.a();
    }

    @Deprecated
    public y0 consumeStableInsets() {
        return this.f21341a.b();
    }

    @Deprecated
    public y0 consumeSystemWindowInsets() {
        return this.f21341a.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y0) {
            return w0.c.equals(this.f21341a, ((y0) obj).f21341a);
        }
        return false;
    }

    public x0.f getDisplayCutout() {
        return this.f21341a.f();
    }

    public o0.b getInsets(int i10) {
        return this.f21341a.getInsets(i10);
    }

    @Deprecated
    public o0.b getStableInsets() {
        return this.f21341a.h();
    }

    @Deprecated
    public o0.b getSystemGestureInsets() {
        return this.f21341a.i();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.f21341a.j().f16887d;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.f21341a.j().f16884a;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.f21341a.j().f16886c;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.f21341a.j().f16885b;
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.f21341a.j().equals(o0.b.f16883e);
    }

    public int hashCode() {
        l lVar = this.f21341a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    public y0 inset(int i10, int i11, int i12, int i13) {
        return this.f21341a.l(i10, i11, i12, i13);
    }

    public boolean isConsumed() {
        return this.f21341a.m();
    }

    @Deprecated
    public y0 replaceSystemWindowInsets(int i10, int i11, int i12, int i13) {
        return new b(this).setSystemWindowInsets(o0.b.of(i10, i11, i12, i13)).build();
    }

    public WindowInsets toWindowInsets() {
        l lVar = this.f21341a;
        if (lVar instanceof g) {
            return ((g) lVar).f21361c;
        }
        return null;
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public static Field f21347e = null;

        /* renamed from: f, reason: collision with root package name */
        public static boolean f21348f = false;

        /* renamed from: g, reason: collision with root package name */
        public static Constructor<WindowInsets> f21349g = null;

        /* renamed from: h, reason: collision with root package name */
        public static boolean f21350h = false;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsets f21351c;

        /* renamed from: d, reason: collision with root package name */
        public o0.b f21352d;

        public c() {
            this.f21351c = h();
        }

        private static WindowInsets h() {
            if (!f21348f) {
                try {
                    f21347e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                f21348f = true;
            }
            Field field = f21347e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!f21350h) {
                try {
                    f21349g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                f21350h = true;
            }
            Constructor<WindowInsets> constructor = f21349g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // x0.y0.f
        public y0 a() {
            applyInsetTypes();
            y0 windowInsetsCompat = y0.toWindowInsetsCompat(this.f21351c);
            windowInsetsCompat.f21341a.setOverriddenInsets(this.f21355b);
            windowInsetsCompat.f21341a.setStableInsets(this.f21352d);
            return windowInsetsCompat;
        }

        @Override // x0.y0.f
        public void d(o0.b bVar) {
            this.f21352d = bVar;
        }

        @Override // x0.y0.f
        public void f(o0.b bVar) {
            WindowInsets windowInsets = this.f21351c;
            if (windowInsets != null) {
                this.f21351c = windowInsets.replaceSystemWindowInsets(bVar.f16884a, bVar.f16885b, bVar.f16886c, bVar.f16887d);
            }
        }

        public c(y0 y0Var) {
            super(y0Var);
            this.f21351c = y0Var.toWindowInsets();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class d extends f {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f21353c;

        public d() {
            this.f21353c = new WindowInsets.Builder();
        }

        @Override // x0.y0.f
        public y0 a() {
            applyInsetTypes();
            y0 windowInsetsCompat = y0.toWindowInsetsCompat(this.f21353c.build());
            windowInsetsCompat.f21341a.setOverriddenInsets(this.f21355b);
            return windowInsetsCompat;
        }

        @Override // x0.y0.f
        public void c(o0.b bVar) {
            this.f21353c.setMandatorySystemGestureInsets(bVar.toPlatformInsets());
        }

        @Override // x0.y0.f
        public void d(o0.b bVar) {
            this.f21353c.setStableInsets(bVar.toPlatformInsets());
        }

        @Override // x0.y0.f
        public void e(o0.b bVar) {
            this.f21353c.setSystemGestureInsets(bVar.toPlatformInsets());
        }

        @Override // x0.y0.f
        public void f(o0.b bVar) {
            this.f21353c.setSystemWindowInsets(bVar.toPlatformInsets());
        }

        @Override // x0.y0.f
        public void g(o0.b bVar) {
            this.f21353c.setTappableElementInsets(bVar.toPlatformInsets());
        }

        public d(y0 y0Var) {
            WindowInsets.Builder builder;
            super(y0Var);
            WindowInsets windowInsets = y0Var.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f21353c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class h extends g {

        /* renamed from: m, reason: collision with root package name */
        public o0.b f21366m;

        public h(y0 y0Var, WindowInsets windowInsets) {
            super(y0Var, windowInsets);
            this.f21366m = null;
        }

        @Override // x0.y0.l
        public y0 b() {
            return y0.toWindowInsetsCompat(this.f21361c.consumeStableInsets());
        }

        @Override // x0.y0.l
        public y0 c() {
            return y0.toWindowInsetsCompat(this.f21361c.consumeSystemWindowInsets());
        }

        @Override // x0.y0.l
        public final o0.b h() {
            if (this.f21366m == null) {
                WindowInsets windowInsets = this.f21361c;
                this.f21366m = o0.b.of(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.f21366m;
        }

        @Override // x0.y0.l
        public boolean m() {
            return this.f21361c.isConsumed();
        }

        @Override // x0.y0.l
        public void setStableInsets(o0.b bVar) {
            this.f21366m = bVar;
        }

        public h(y0 y0Var, h hVar) {
            super(y0Var, hVar);
            this.f21366m = null;
            this.f21366m = hVar.f21366m;
        }
    }

    public static y0 toWindowInsetsCompat(WindowInsets windowInsets, View view) {
        y0 y0Var = new y0((WindowInsets) w0.h.checkNotNull(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            y0 rootWindowInsets = j0.getRootWindowInsets(view);
            l lVar = y0Var.f21341a;
            lVar.p(rootWindowInsets);
            lVar.d(view.getRootView());
        }
        return y0Var;
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class g extends l {

        /* renamed from: h, reason: collision with root package name */
        public static boolean f21356h = false;

        /* renamed from: i, reason: collision with root package name */
        public static Method f21357i;

        /* renamed from: j, reason: collision with root package name */
        public static Class<?> f21358j;

        /* renamed from: k, reason: collision with root package name */
        public static Field f21359k;

        /* renamed from: l, reason: collision with root package name */
        public static Field f21360l;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f21361c;

        /* renamed from: d, reason: collision with root package name */
        public o0.b[] f21362d;

        /* renamed from: e, reason: collision with root package name */
        public o0.b f21363e;

        /* renamed from: f, reason: collision with root package name */
        public y0 f21364f;

        /* renamed from: g, reason: collision with root package name */
        public o0.b f21365g;

        public g(y0 y0Var, WindowInsets windowInsets) {
            super(y0Var);
            this.f21363e = null;
            this.f21361c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private o0.b q(int i10, boolean z10) {
            o0.b bVarMax = o0.b.f16883e;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    bVarMax = o0.b.max(bVarMax, getInsetsForType(i11, z10));
                }
            }
            return bVarMax;
        }

        private o0.b r() {
            y0 y0Var = this.f21364f;
            return y0Var != null ? y0Var.getStableInsets() : o0.b.f16883e;
        }

        private o0.b s(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!f21356h) {
                t();
            }
            Method method = f21357i;
            if (method != null && f21358j != null && f21359k != null) {
                try {
                    Object objInvoke = method.invoke(view, new Object[0]);
                    if (objInvoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f21359k.get(f21360l.get(objInvoke));
                    if (rect != null) {
                        return o0.b.of(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void t() throws ClassNotFoundException, SecurityException {
            try {
                f21357i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f21358j = cls;
                f21359k = cls.getDeclaredField("mVisibleInsets");
                f21360l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f21359k.setAccessible(true);
                f21360l.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            f21356h = true;
        }

        @Override // x0.y0.l
        public void d(View view) throws IllegalAccessException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
            o0.b bVarS = s(view);
            if (bVarS == null) {
                bVarS = o0.b.f16883e;
            }
            o(bVarS);
        }

        @Override // x0.y0.l
        public void e(y0 y0Var) {
            y0Var.f21341a.p(this.f21364f);
            y0Var.f21341a.o(this.f21365g);
        }

        @Override // x0.y0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f21365g, ((g) obj).f21365g);
            }
            return false;
        }

        @Override // x0.y0.l
        public o0.b getInsets(int i10) {
            return q(i10, false);
        }

        public o0.b getInsetsForType(int i10, boolean z10) {
            o0.b stableInsets;
            int i11;
            if (i10 == 1) {
                return z10 ? o0.b.of(0, Math.max(r().f16885b, j().f16885b), 0, 0) : o0.b.of(0, j().f16885b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    o0.b bVarR = r();
                    o0.b bVarH = h();
                    return o0.b.of(Math.max(bVarR.f16884a, bVarH.f16884a), 0, Math.max(bVarR.f16886c, bVarH.f16886c), Math.max(bVarR.f16887d, bVarH.f16887d));
                }
                o0.b bVarJ = j();
                y0 y0Var = this.f21364f;
                stableInsets = y0Var != null ? y0Var.getStableInsets() : null;
                int iMin = bVarJ.f16887d;
                if (stableInsets != null) {
                    iMin = Math.min(iMin, stableInsets.f16887d);
                }
                return o0.b.of(bVarJ.f16884a, 0, bVarJ.f16886c, iMin);
            }
            o0.b bVar = o0.b.f16883e;
            if (i10 != 8) {
                if (i10 == 16) {
                    return i();
                }
                if (i10 == 32) {
                    return g();
                }
                if (i10 == 64) {
                    return k();
                }
                if (i10 != 128) {
                    return bVar;
                }
                y0 y0Var2 = this.f21364f;
                x0.f displayCutout = y0Var2 != null ? y0Var2.getDisplayCutout() : f();
                return displayCutout != null ? o0.b.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : bVar;
            }
            o0.b[] bVarArr = this.f21362d;
            stableInsets = bVarArr != null ? bVarArr[m.a(8)] : null;
            if (stableInsets != null) {
                return stableInsets;
            }
            o0.b bVarJ2 = j();
            o0.b bVarR2 = r();
            int i12 = bVarJ2.f16887d;
            if (i12 > bVarR2.f16887d) {
                return o0.b.of(0, 0, 0, i12);
            }
            o0.b bVar2 = this.f21365g;
            return (bVar2 == null || bVar2.equals(bVar) || (i11 = this.f21365g.f16887d) <= bVarR2.f16887d) ? bVar : o0.b.of(0, 0, 0, i11);
        }

        @Override // x0.y0.l
        public final o0.b j() {
            if (this.f21363e == null) {
                WindowInsets windowInsets = this.f21361c;
                this.f21363e = o0.b.of(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.f21363e;
        }

        @Override // x0.y0.l
        public y0 l(int i10, int i11, int i12, int i13) {
            b bVar = new b(y0.toWindowInsetsCompat(this.f21361c));
            bVar.setSystemWindowInsets(y0.a(j(), i10, i11, i12, i13));
            bVar.setStableInsets(y0.a(h(), i10, i11, i12, i13));
            return bVar.build();
        }

        @Override // x0.y0.l
        public boolean n() {
            return this.f21361c.isRound();
        }

        @Override // x0.y0.l
        public void o(o0.b bVar) {
            this.f21365g = bVar;
        }

        @Override // x0.y0.l
        public void p(y0 y0Var) {
            this.f21364f = y0Var;
        }

        @Override // x0.y0.l
        public void setOverriddenInsets(o0.b[] bVarArr) {
            this.f21362d = bVarArr;
        }

        public g(y0 y0Var, g gVar) {
            this(y0Var, new WindowInsets(gVar.f21361c));
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class j extends i {

        /* renamed from: n, reason: collision with root package name */
        public o0.b f21367n;

        /* renamed from: o, reason: collision with root package name */
        public o0.b f21368o;

        /* renamed from: p, reason: collision with root package name */
        public o0.b f21369p;

        public j(y0 y0Var, WindowInsets windowInsets) {
            super(y0Var, windowInsets);
            this.f21367n = null;
            this.f21368o = null;
            this.f21369p = null;
        }

        @Override // x0.y0.l
        public o0.b g() {
            if (this.f21368o == null) {
                this.f21368o = o0.b.toCompatInsets(this.f21361c.getMandatorySystemGestureInsets());
            }
            return this.f21368o;
        }

        @Override // x0.y0.l
        public o0.b i() {
            if (this.f21367n == null) {
                this.f21367n = o0.b.toCompatInsets(this.f21361c.getSystemGestureInsets());
            }
            return this.f21367n;
        }

        @Override // x0.y0.l
        public o0.b k() {
            if (this.f21369p == null) {
                this.f21369p = o0.b.toCompatInsets(this.f21361c.getTappableElementInsets());
            }
            return this.f21369p;
        }

        @Override // x0.y0.g, x0.y0.l
        public y0 l(int i10, int i11, int i12, int i13) {
            return y0.toWindowInsetsCompat(this.f21361c.inset(i10, i11, i12, i13));
        }

        public j(y0 y0Var, j jVar) {
            super(y0Var, jVar);
            this.f21367n = null;
            this.f21368o = null;
            this.f21369p = null;
        }

        @Override // x0.y0.h, x0.y0.l
        public void setStableInsets(o0.b bVar) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final f f21346a;

        public b() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f21346a = new e();
            } else if (i10 >= 29) {
                this.f21346a = new d();
            } else {
                this.f21346a = new c();
            }
        }

        public y0 build() {
            return this.f21346a.a();
        }

        public b setInsets(int i10, o0.b bVar) {
            this.f21346a.b(i10, bVar);
            return this;
        }

        @Deprecated
        public b setStableInsets(o0.b bVar) {
            this.f21346a.d(bVar);
            return this;
        }

        @Deprecated
        public b setSystemWindowInsets(o0.b bVar) {
            this.f21346a.f(bVar);
            return this;
        }

        public b(y0 y0Var) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f21346a = new e(y0Var);
            } else if (i10 >= 29) {
                this.f21346a = new d(y0Var);
            } else {
                this.f21346a = new c(y0Var);
            }
        }
    }

    public y0(y0 y0Var) {
        if (y0Var != null) {
            l lVar = y0Var.f21341a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (lVar instanceof k)) {
                this.f21341a = new k(this, (k) lVar);
            } else if (i10 >= 29 && (lVar instanceof j)) {
                this.f21341a = new j(this, (j) lVar);
            } else if (i10 >= 28 && (lVar instanceof i)) {
                this.f21341a = new i(this, (i) lVar);
            } else if (lVar instanceof h) {
                this.f21341a = new h(this, (h) lVar);
            } else if (lVar instanceof g) {
                this.f21341a = new g(this, (g) lVar);
            } else {
                this.f21341a = new l(this);
            }
            lVar.e(this);
            return;
        }
        this.f21341a = new l(this);
    }

    /* compiled from: WindowInsetsCompat.java */
    public static class l {

        /* renamed from: b, reason: collision with root package name */
        public static final y0 f21371b = new b().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

        /* renamed from: a, reason: collision with root package name */
        public final y0 f21372a;

        public l(y0 y0Var) {
            this.f21372a = y0Var;
        }

        public y0 a() {
            return this.f21372a;
        }

        public y0 b() {
            return this.f21372a;
        }

        public y0 c() {
            return this.f21372a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return n() == lVar.n() && m() == lVar.m() && w0.c.equals(j(), lVar.j()) && w0.c.equals(h(), lVar.h()) && w0.c.equals(f(), lVar.f());
        }

        public x0.f f() {
            return null;
        }

        public o0.b g() {
            return j();
        }

        public o0.b getInsets(int i10) {
            return o0.b.f16883e;
        }

        public o0.b h() {
            return o0.b.f16883e;
        }

        public int hashCode() {
            return w0.c.hash(Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), f());
        }

        public o0.b i() {
            return j();
        }

        public o0.b j() {
            return o0.b.f16883e;
        }

        public o0.b k() {
            return j();
        }

        public y0 l(int i10, int i11, int i12, int i13) {
            return f21371b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void d(View view) {
        }

        public void e(y0 y0Var) {
        }

        public void o(o0.b bVar) {
        }

        public void p(y0 y0Var) {
        }

        public void setOverriddenInsets(o0.b[] bVarArr) {
        }

        public void setStableInsets(o0.b bVar) {
        }
    }
}
