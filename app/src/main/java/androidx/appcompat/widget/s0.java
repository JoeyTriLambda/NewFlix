package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.widget.k;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourceManagerInternal.java */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: i, reason: collision with root package name */
    public static s0 f1509i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, b0.l<ColorStateList>> f1511a;

    /* renamed from: b, reason: collision with root package name */
    public b0.k<String, e> f1512b;

    /* renamed from: c, reason: collision with root package name */
    public b0.l<String> f1513c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, b0.h<WeakReference<Drawable.ConstantState>>> f1514d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f1515e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1516f;

    /* renamed from: g, reason: collision with root package name */
    public f f1517g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f1508h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final c f1510j = new c(6);

    /* compiled from: ResourceManagerInternal.java */
    public static class a implements e {
        @Override // androidx.appcompat.widget.s0.e
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return t.a.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class b implements e {
        @Override // androidx.appcompat.widget.s0.e
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return r2.d.createFromXmlInner(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class c extends b0.i<Integer, PorterDuffColorFilter> {
        public c(int i10) {
            super(i10);
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class d implements e {
        @Override // androidx.appcompat.widget.s0.e
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    u.c.inflate(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e10) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e10);
                }
            }
            return null;
        }
    }

    /* compiled from: ResourceManagerInternal.java */
    public interface e {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    public interface f {
    }

    /* compiled from: ResourceManagerInternal.java */
    public static class g implements e {
        @Override // androidx.appcompat.widget.s0.e
        public Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return r2.i.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    public static void g(s0 s0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            s0Var.a("vector", new g());
            s0Var.a("animated-vector", new b());
            s0Var.a("animated-selector", new a());
            s0Var.a("drawable", new d());
        }
    }

    public static synchronized s0 get() {
        if (f1509i == null) {
            s0 s0Var = new s0();
            f1509i = s0Var;
            g(s0Var);
        }
        return f1509i;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        c cVar = f1510j;
        cVar.getClass();
        int i11 = (i10 + 31) * 31;
        porterDuffColorFilter = cVar.get(Integer.valueOf(mode.hashCode() + i11));
        if (porterDuffColorFilter == null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i10, mode);
            cVar.put(Integer.valueOf(mode.hashCode() + i11), porterDuffColorFilter);
        }
        return porterDuffColorFilter;
    }

    public final void a(String str, e eVar) {
        if (this.f1512b == null) {
            this.f1512b = new b0.k<>();
        }
        this.f1512b.put(str, eVar);
    }

    public final synchronized void b(Context context, long j10, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            b0.h<WeakReference<Drawable.ConstantState>> hVar = this.f1514d.get(context);
            if (hVar == null) {
                hVar = new b0.h<>();
                this.f1514d.put(context, hVar);
            }
            hVar.put(j10, new WeakReference<>(constantState));
        }
    }

    public final Drawable c(Context context, int i10) throws Resources.NotFoundException {
        if (this.f1515e == null) {
            this.f1515e = new TypedValue();
        }
        TypedValue typedValue = this.f1515e;
        context.getResources().getValue(i10, typedValue, true);
        long j10 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j10);
        if (drawableD != null) {
            return drawableD;
        }
        f fVar = this.f1517g;
        Drawable drawableCreateDrawableFor = fVar == null ? null : ((k.a) fVar).createDrawableFor(this, context, i10);
        if (drawableCreateDrawableFor != null) {
            drawableCreateDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j10, drawableCreateDrawableFor);
        }
        return drawableCreateDrawableFor;
    }

    public final synchronized Drawable d(Context context, long j10) {
        b0.h<WeakReference<Drawable.ConstantState>> hVar = this.f1514d.get(context);
        if (hVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = hVar.get(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            hVar.remove(j10);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized android.graphics.drawable.Drawable e(android.content.Context r5, int r6, boolean r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.f1516f     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L6
            goto L2a
        L6:
            r0 = 1
            r4.f1516f = r0     // Catch: java.lang.Throwable -> L47
            int r1 = androidx.appcompat.resources.R.drawable.abc_vector_test     // Catch: java.lang.Throwable -> L47
            android.graphics.drawable.Drawable r1 = r4.getDrawable(r5, r1)     // Catch: java.lang.Throwable -> L47
            r2 = 0
            if (r1 == 0) goto L49
            boolean r3 = r1 instanceof r2.i     // Catch: java.lang.Throwable -> L47
            if (r3 != 0) goto L28
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "android.graphics.drawable.VectorDrawable"
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L27
            goto L28
        L27:
            r0 = 0
        L28:
            if (r0 == 0) goto L49
        L2a:
            android.graphics.drawable.Drawable r0 = r4.h(r5, r6)     // Catch: java.lang.Throwable -> L47
            if (r0 != 0) goto L34
            android.graphics.drawable.Drawable r0 = r4.c(r5, r6)     // Catch: java.lang.Throwable -> L47
        L34:
            if (r0 != 0) goto L3a
            android.graphics.drawable.Drawable r0 = m0.a.getDrawable(r5, r6)     // Catch: java.lang.Throwable -> L47
        L3a:
            if (r0 == 0) goto L40
            android.graphics.drawable.Drawable r0 = r4.i(r5, r6, r7, r0)     // Catch: java.lang.Throwable -> L47
        L40:
            if (r0 == 0) goto L45
            androidx.appcompat.widget.i0.a(r0)     // Catch: java.lang.Throwable -> L47
        L45:
            monitor-exit(r4)
            return r0
        L47:
            r5 = move-exception
            goto L53
        L49:
            r4.f1516f = r2     // Catch: java.lang.Throwable -> L47
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L47
            java.lang.String r6 = "This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat."
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L47
            throw r5     // Catch: java.lang.Throwable -> L47
        L53:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.s0.e(android.content.Context, int, boolean):android.graphics.drawable.Drawable");
    }

    public final synchronized ColorStateList f(Context context, int i10) {
        ColorStateList colorStateList;
        b0.l<ColorStateList> lVar;
        WeakHashMap<Context, b0.l<ColorStateList>> weakHashMap = this.f1511a;
        ColorStateList tintListForDrawableRes = null;
        colorStateList = (weakHashMap == null || (lVar = weakHashMap.get(context)) == null) ? null : lVar.get(i10);
        if (colorStateList == null) {
            f fVar = this.f1517g;
            if (fVar != null) {
                tintListForDrawableRes = ((k.a) fVar).getTintListForDrawableRes(context, i10);
            }
            if (tintListForDrawableRes != null) {
                if (this.f1511a == null) {
                    this.f1511a = new WeakHashMap<>();
                }
                b0.l<ColorStateList> lVar2 = this.f1511a.get(context);
                if (lVar2 == null) {
                    lVar2 = new b0.l<>();
                    this.f1511a.put(context, lVar2);
                }
                lVar2.append(i10, tintListForDrawableRes);
            }
            colorStateList = tintListForDrawableRes;
        }
        return colorStateList;
    }

    public synchronized Drawable getDrawable(Context context, int i10) {
        return e(context, i10, false);
    }

    public final Drawable h(Context context, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        b0.k<String, e> kVar = this.f1512b;
        if (kVar == null || kVar.isEmpty()) {
            return null;
        }
        b0.l<String> lVar = this.f1513c;
        if (lVar != null) {
            String str = lVar.get(i10);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1512b.get(str) == null)) {
                return null;
            }
        } else {
            this.f1513c = new b0.l<>();
        }
        if (this.f1515e == null) {
            this.f1515e = new TypedValue();
        }
        TypedValue typedValue = this.f1515e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long j10 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable drawableD = d(context, j10);
        if (drawableD != null) {
            return drawableD;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1513c.append(i10, name);
                e eVar = this.f1512b.get(name);
                if (eVar != null) {
                    drawableD = eVar.createFromXmlInner(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableD != null) {
                    drawableD.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j10, drawableD);
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (drawableD == null) {
            this.f1513c.append(i10, "appcompat_skip_skip");
        }
        return drawableD;
    }

    public final Drawable i(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList colorStateListF = f(context, i10);
        if (colorStateListF == null) {
            f fVar = this.f1517g;
            if (fVar != null && ((k.a) fVar).tintDrawable(context, i10, drawable)) {
                return drawable;
            }
            f fVar2 = this.f1517g;
            if ((fVar2 != null && ((k.a) fVar2).tintDrawableUsingColorFilter(context, i10, drawable)) || !z10) {
                return drawable;
            }
            return null;
        }
        if (i0.canSafelyMutateDrawable(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableWrap = p0.a.wrap(drawable);
        p0.a.setTintList(drawableWrap, colorStateListF);
        f fVar3 = this.f1517g;
        PorterDuff.Mode tintModeForDrawableRes = fVar3 != null ? ((k.a) fVar3).getTintModeForDrawableRes(i10) : null;
        if (tintModeForDrawableRes == null) {
            return drawableWrap;
        }
        p0.a.setTintMode(drawableWrap, tintModeForDrawableRes);
        return drawableWrap;
    }

    public synchronized void onConfigurationChanged(Context context) {
        b0.h<WeakReference<Drawable.ConstantState>> hVar = this.f1514d.get(context);
        if (hVar != null) {
            hVar.clear();
        }
    }

    public synchronized void setHooks(f fVar) {
        this.f1517g = fVar;
    }
}
