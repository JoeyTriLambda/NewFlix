package n0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import r.x;

/* compiled from: ResourcesCompat.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f16423a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<d, SparseArray<c>> f16424b = new WeakHashMap<>(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f16425c = new Object();

    /* compiled from: ResourcesCompat.java */
    public static class a {
        public static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        public static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    /* compiled from: ResourcesCompat.java */
    public static class b {
        public static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        public static ColorStateList b(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    /* compiled from: ResourcesCompat.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f16426a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f16427b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16428c;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f16426a = colorStateList;
            this.f16427b = configuration;
            this.f16428c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* compiled from: ResourcesCompat.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f16429a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f16430b;

        public d(Resources resources, Resources.Theme theme) {
            this.f16429a = resources;
            this.f16430b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f16429a.equals(dVar.f16429a) && w0.c.equals(this.f16430b, dVar.f16430b);
        }

        public int hashCode() {
            return w0.c.hash(this.f16429a, this.f16430b);
        }
    }

    /* compiled from: ResourcesCompat.java */
    public static abstract class e {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(int i10, Handler handler) {
            getHandler(handler).post(new h(i10, 0, this));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new x(1, this, typeface));
        }

        public abstract void onFontRetrievalFailed(int i10);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    /* compiled from: ResourcesCompat.java */
    public static final class f {

        /* compiled from: ResourcesCompat.java */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public static final Object f16431a = new Object();

            /* renamed from: b, reason: collision with root package name */
            public static Method f16432b;

            /* renamed from: c, reason: collision with root package name */
            public static boolean f16433c;
        }

        /* compiled from: ResourcesCompat.java */
        public static class b {
            public static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void rebase(android.content.res.Resources.Theme r6) {
            /*
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 29
                if (r0 < r1) goto La
                n0.g.f.b.a(r6)
                goto L4d
            La:
                r1 = 23
                if (r0 < r1) goto L4d
                java.lang.Object r0 = n0.g.f.a.f16431a
                monitor-enter(r0)
                boolean r1 = n0.g.f.a.f16433c     // Catch: java.lang.Throwable -> L4a
                r2 = 0
                if (r1 != 0) goto L31
                r1 = 1
                java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
                java.lang.String r4 = "rebase"
                java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L27 java.lang.Throwable -> L4a
                java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L27 java.lang.Throwable -> L4a
                n0.g.f.a.f16432b = r3     // Catch: java.lang.NoSuchMethodException -> L27 java.lang.Throwable -> L4a
                r3.setAccessible(r1)     // Catch: java.lang.NoSuchMethodException -> L27 java.lang.Throwable -> L4a
                goto L2f
            L27:
                r3 = move-exception
                java.lang.String r4 = "ResourcesCompat"
                java.lang.String r5 = "Failed to retrieve rebase() method"
                android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L4a
            L2f:
                n0.g.f.a.f16433c = r1     // Catch: java.lang.Throwable -> L4a
            L31:
                java.lang.reflect.Method r1 = n0.g.f.a.f16432b     // Catch: java.lang.Throwable -> L4a
                if (r1 == 0) goto L48
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L3b java.lang.IllegalAccessException -> L3d java.lang.Throwable -> L4a
                r1.invoke(r6, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L3b java.lang.IllegalAccessException -> L3d java.lang.Throwable -> L4a
                goto L48
            L3b:
                r6 = move-exception
                goto L3e
            L3d:
                r6 = move-exception
            L3e:
                java.lang.String r1 = "ResourcesCompat"
                java.lang.String r2 = "Failed to invoke rebase() method via reflection"
                android.util.Log.i(r1, r2, r6)     // Catch: java.lang.Throwable -> L4a
                r6 = 0
                n0.g.f.a.f16432b = r6     // Catch: java.lang.Throwable -> L4a
            L48:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
                goto L4d
            L4a:
                r6 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
                throw r6
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: n0.g.f.rebase(android.content.res.Resources$Theme):void");
        }
    }

    public static void a(d dVar, int i10, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f16425c) {
            WeakHashMap<d, SparseArray<c>> weakHashMap = f16424b;
            SparseArray<c> sparseArray = weakHashMap.get(dVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(dVar, sparseArray);
            }
            sparseArray.append(i10, new c(colorStateList, dVar.f16429a.getConfiguration(), theme));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface b(android.content.Context r17, int r18, android.util.TypedValue r19, int r20, n0.g.e r21, android.os.Handler r22, boolean r23, boolean r24) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.g.b(android.content.Context, int, android.util.TypedValue, int, n0.g$e, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    public static Typeface getCachedFont(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    public static ColorStateList getColorStateList(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateList colorStateListCreateFromXml;
        ColorStateList colorStateList;
        c cVar;
        d dVar = new d(resources, theme);
        synchronized (f16425c) {
            SparseArray<c> sparseArray = f16424b.get(dVar);
            colorStateListCreateFromXml = null;
            if (sparseArray == null || sparseArray.size() <= 0 || (cVar = sparseArray.get(i10)) == null) {
                colorStateList = null;
            } else if (!cVar.f16427b.equals(resources.getConfiguration()) || (!(theme == null && cVar.f16428c == 0) && (theme == null || cVar.f16428c != theme.hashCode()))) {
                sparseArray.remove(i10);
                colorStateList = null;
            } else {
                colorStateList = cVar.f16426a;
            }
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ThreadLocal<TypedValue> threadLocal = f16423a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        resources.getValue(i10, typedValue, true);
        int i11 = typedValue.type;
        if (!(i11 >= 28 && i11 <= 31)) {
            try {
                colorStateListCreateFromXml = n0.b.createFromXml(resources, resources.getXml(i10), theme);
            } catch (Exception e10) {
                Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            }
        }
        if (colorStateListCreateFromXml == null) {
            return Build.VERSION.SDK_INT >= 23 ? b.b(resources, i10, theme) : resources.getColorStateList(i10);
        }
        a(dVar, i10, colorStateListCreateFromXml, theme);
        return colorStateListCreateFromXml;
    }

    public static Drawable getDrawable(Resources resources, int i10, Resources.Theme theme) throws Resources.NotFoundException {
        return a.a(resources, i10, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i10, int i11, Resources.Theme theme) throws Resources.NotFoundException {
        return a.b(resources, i10, i11, theme);
    }

    public static Typeface getFont(Context context, int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static void getFont(Context context, int i10, e eVar, Handler handler) throws Resources.NotFoundException {
        w0.h.checkNotNull(eVar);
        if (context.isRestricted()) {
            eVar.callbackFailAsync(-4, handler);
        } else {
            b(context, i10, new TypedValue(), 0, eVar, handler, false, false);
        }
    }

    public static Typeface getFont(Context context, int i10, TypedValue typedValue, int i11, e eVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return b(context, i10, typedValue, i11, eVar, null, true, false);
    }
}
