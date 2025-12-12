package t;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;

/* compiled from: DrawableContainerCompat.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f19300x = 0;

    /* renamed from: b, reason: collision with root package name */
    public d f19301b;

    /* renamed from: m, reason: collision with root package name */
    public Rect f19302m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f19303n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f19304o;

    /* renamed from: q, reason: collision with root package name */
    public boolean f19306q;

    /* renamed from: s, reason: collision with root package name */
    public boolean f19308s;

    /* renamed from: t, reason: collision with root package name */
    public a f19309t;

    /* renamed from: u, reason: collision with root package name */
    public long f19310u;

    /* renamed from: v, reason: collision with root package name */
    public long f19311v;

    /* renamed from: w, reason: collision with root package name */
    public c f19312w;

    /* renamed from: p, reason: collision with root package name */
    public int f19305p = 255;

    /* renamed from: r, reason: collision with root package name */
    public int f19307r = -1;

    /* compiled from: DrawableContainerCompat.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f19313b;

        public a(e eVar) {
            this.f19313b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f19313b;
            bVar.a(true);
            bVar.invalidateSelf();
        }
    }

    /* compiled from: DrawableContainerCompat.java */
    /* renamed from: t.b$b, reason: collision with other inner class name */
    public static class C0254b {
        public static boolean canApplyTheme(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources getResources(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* compiled from: DrawableContainerCompat.java */
    public static abstract class d extends Drawable.ConstantState {
        public boolean A;
        public ColorFilter B;
        public boolean C;
        public ColorStateList D;
        public PorterDuff.Mode E;
        public boolean F;
        public boolean G;

        /* renamed from: a, reason: collision with root package name */
        public final b f19315a;

        /* renamed from: b, reason: collision with root package name */
        public Resources f19316b;

        /* renamed from: c, reason: collision with root package name */
        public int f19317c;

        /* renamed from: d, reason: collision with root package name */
        public int f19318d;

        /* renamed from: e, reason: collision with root package name */
        public int f19319e;

        /* renamed from: f, reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f19320f;

        /* renamed from: g, reason: collision with root package name */
        public Drawable[] f19321g;

        /* renamed from: h, reason: collision with root package name */
        public int f19322h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f19323i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f19324j;

        /* renamed from: k, reason: collision with root package name */
        public Rect f19325k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f19326l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f19327m;

        /* renamed from: n, reason: collision with root package name */
        public int f19328n;

        /* renamed from: o, reason: collision with root package name */
        public int f19329o;

        /* renamed from: p, reason: collision with root package name */
        public int f19330p;

        /* renamed from: q, reason: collision with root package name */
        public int f19331q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f19332r;

        /* renamed from: s, reason: collision with root package name */
        public int f19333s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f19334t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f19335u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f19336v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f19337w;

        /* renamed from: x, reason: collision with root package name */
        public int f19338x;

        /* renamed from: y, reason: collision with root package name */
        public int f19339y;

        /* renamed from: z, reason: collision with root package name */
        public int f19340z;

        public d(d dVar, b bVar, Resources resources) {
            this.f19323i = false;
            this.f19326l = false;
            this.f19337w = true;
            this.f19339y = 0;
            this.f19340z = 0;
            this.f19315a = bVar;
            this.f19316b = resources != null ? resources : dVar != null ? dVar.f19316b : null;
            int i10 = dVar != null ? dVar.f19317c : 0;
            int i11 = b.f19300x;
            i10 = resources != null ? resources.getDisplayMetrics().densityDpi : i10;
            i10 = i10 == 0 ? 160 : i10;
            this.f19317c = i10;
            if (dVar == null) {
                this.f19321g = new Drawable[10];
                this.f19322h = 0;
                return;
            }
            this.f19318d = dVar.f19318d;
            this.f19319e = dVar.f19319e;
            this.f19335u = true;
            this.f19336v = true;
            this.f19323i = dVar.f19323i;
            this.f19326l = dVar.f19326l;
            this.f19337w = dVar.f19337w;
            this.f19338x = dVar.f19338x;
            this.f19339y = dVar.f19339y;
            this.f19340z = dVar.f19340z;
            this.A = dVar.A;
            this.B = dVar.B;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            if (dVar.f19317c == i10) {
                if (dVar.f19324j) {
                    this.f19325k = dVar.f19325k != null ? new Rect(dVar.f19325k) : null;
                    this.f19324j = true;
                }
                if (dVar.f19327m) {
                    this.f19328n = dVar.f19328n;
                    this.f19329o = dVar.f19329o;
                    this.f19330p = dVar.f19330p;
                    this.f19331q = dVar.f19331q;
                    this.f19327m = true;
                }
            }
            if (dVar.f19332r) {
                this.f19333s = dVar.f19333s;
                this.f19332r = true;
            }
            if (dVar.f19334t) {
                this.f19334t = true;
            }
            Drawable[] drawableArr = dVar.f19321g;
            this.f19321g = new Drawable[drawableArr.length];
            this.f19322h = dVar.f19322h;
            SparseArray<Drawable.ConstantState> sparseArray = dVar.f19320f;
            if (sparseArray != null) {
                this.f19320f = sparseArray.clone();
            } else {
                this.f19320f = new SparseArray<>(this.f19322h);
            }
            int i12 = this.f19322h;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f19320f.put(i13, constantState);
                    } else {
                        this.f19321g[i13] = drawableArr[i13];
                    }
                }
            }
        }

        public final void a() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            SparseArray<Drawable.ConstantState> sparseArray = this.f19320f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    int iKeyAt = this.f19320f.keyAt(i10);
                    Drawable.ConstantState constantStateValueAt = this.f19320f.valueAt(i10);
                    Drawable[] drawableArr = this.f19321g;
                    Drawable drawableNewDrawable = constantStateValueAt.newDrawable(this.f19316b);
                    if (Build.VERSION.SDK_INT >= 23) {
                        p0.a.setLayoutDirection(drawableNewDrawable, this.f19338x);
                    }
                    Drawable drawableMutate = drawableNewDrawable.mutate();
                    drawableMutate.setCallback(this.f19315a);
                    drawableArr[iKeyAt] = drawableMutate;
                }
                this.f19320f = null;
            }
        }

        public final int addChild(Drawable drawable) {
            int i10 = this.f19322h;
            if (i10 >= this.f19321g.length) {
                growArray(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f19315a);
            this.f19321g[i10] = drawable;
            this.f19322h++;
            this.f19319e = drawable.getChangingConfigurations() | this.f19319e;
            this.f19332r = false;
            this.f19334t = false;
            this.f19325k = null;
            this.f19324j = false;
            this.f19327m = false;
            this.f19335u = false;
            return i10;
        }

        public abstract void b();

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i10 = this.f19322h;
            Drawable[] drawableArr = this.f19321g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f19320f.get(i11);
                    if (constantState != null && C0254b.canApplyTheme(constantState)) {
                        return true;
                    }
                } else if (p0.a.canApplyTheme(drawable)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canConstantState() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f19335u) {
                return this.f19336v;
            }
            a();
            this.f19335u = true;
            int i10 = this.f19322h;
            Drawable[] drawableArr = this.f19321g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f19336v = false;
                    return false;
                }
            }
            this.f19336v = true;
            return true;
        }

        public void computeConstantSize() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f19327m = true;
            a();
            int i10 = this.f19322h;
            Drawable[] drawableArr = this.f19321g;
            this.f19329o = -1;
            this.f19328n = -1;
            this.f19331q = 0;
            this.f19330p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f19328n) {
                    this.f19328n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f19329o) {
                    this.f19329o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f19330p) {
                    this.f19330p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f19331q) {
                    this.f19331q = minimumHeight;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f19318d | this.f19319e;
        }

        public final Drawable getChild(int i10) {
            int iIndexOfKey;
            Drawable drawable = this.f19321g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f19320f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable drawableNewDrawable = this.f19320f.valueAt(iIndexOfKey).newDrawable(this.f19316b);
            if (Build.VERSION.SDK_INT >= 23) {
                p0.a.setLayoutDirection(drawableNewDrawable, this.f19338x);
            }
            Drawable drawableMutate = drawableNewDrawable.mutate();
            drawableMutate.setCallback(this.f19315a);
            this.f19321g[i10] = drawableMutate;
            this.f19320f.removeAt(iIndexOfKey);
            if (this.f19320f.size() == 0) {
                this.f19320f = null;
            }
            return drawableMutate;
        }

        public final int getChildCount() {
            return this.f19322h;
        }

        public final int getConstantHeight() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f19327m) {
                computeConstantSize();
            }
            return this.f19329o;
        }

        public final int getConstantMinimumHeight() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f19327m) {
                computeConstantSize();
            }
            return this.f19331q;
        }

        public final int getConstantMinimumWidth() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f19327m) {
                computeConstantSize();
            }
            return this.f19330p;
        }

        public final Rect getConstantPadding() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            Rect rect = null;
            if (this.f19323i) {
                return null;
            }
            Rect rect2 = this.f19325k;
            if (rect2 != null || this.f19324j) {
                return rect2;
            }
            a();
            Rect rect3 = new Rect();
            int i10 = this.f19322h;
            Drawable[] drawableArr = this.f19321g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f19324j = true;
            this.f19325k = rect;
            return rect;
        }

        public final int getConstantWidth() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f19327m) {
                computeConstantSize();
            }
            return this.f19328n;
        }

        public final int getOpacity() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f19332r) {
                return this.f19333s;
            }
            a();
            int i10 = this.f19322h;
            Drawable[] drawableArr = this.f19321g;
            int opacity = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i11].getOpacity());
            }
            this.f19333s = opacity;
            this.f19332r = true;
            return opacity;
        }

        public void growArray(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.f19321g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.f19321g = drawableArr;
        }

        public final boolean isConstantSize() {
            return this.f19326l;
        }

        public final void setConstantSize(boolean z10) {
            this.f19326l = z10;
        }

        public final void setEnterFadeDuration(int i10) {
            this.f19339y = i10;
        }

        public final void setExitFadeDuration(int i10) {
            this.f19340z = i10;
        }

        public final void setVariablePadding(boolean z10) {
            this.f19323i = z10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f19306q = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f19303n
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f19310u
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f19305p
            r3.setAlpha(r9)
            r13.f19310u = r6
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            t.b$d r9 = r13.f19301b
            int r9 = r9.f19339y
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f19305p
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f19310u = r6
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f19304o
            if (r9 == 0) goto L65
            long r10 = r13.f19311v
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f19304o = r0
            r13.f19311v = r6
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            t.b$d r4 = r13.f19301b
            int r4 = r4.f19340z
            int r3 = r3 / r4
            int r4 = r13.f19305p
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f19311v = r6
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            t.b$a r14 = r13.f19309t
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t.b.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        d dVar = this.f19301b;
        if (theme == null) {
            dVar.getClass();
            return;
        }
        dVar.a();
        int i10 = dVar.f19322h;
        Drawable[] drawableArr = dVar.f19321g;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            if (drawable != null && p0.a.canApplyTheme(drawable)) {
                p0.a.applyTheme(drawableArr[i11], theme);
                dVar.f19319e |= drawableArr[i11].getChangingConfigurations();
            }
        }
        Resources resources = C0254b.getResources(theme);
        if (resources != null) {
            dVar.f19316b = resources;
            int i12 = resources.getDisplayMetrics().densityDpi;
            if (i12 == 0) {
                i12 = 160;
            }
            int i13 = dVar.f19317c;
            dVar.f19317c = i12;
            if (i13 != i12) {
                dVar.f19327m = false;
                dVar.f19324j = false;
            }
        }
    }

    public d b() {
        throw null;
    }

    public final void c(Drawable drawable) {
        if (this.f19312w == null) {
            this.f19312w = new c();
        }
        drawable.setCallback(this.f19312w.wrap(drawable.getCallback()));
        try {
            if (this.f19301b.f19339y <= 0 && this.f19306q) {
                drawable.setAlpha(this.f19305p);
            }
            d dVar = this.f19301b;
            if (dVar.C) {
                drawable.setColorFilter(dVar.B);
            } else {
                if (dVar.F) {
                    p0.a.setTintList(drawable, dVar.D);
                }
                d dVar2 = this.f19301b;
                if (dVar2.G) {
                    p0.a.setTintMode(drawable, dVar2.E);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f19301b.f19337w);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                p0.a.setLayoutDirection(drawable, p0.a.getLayoutDirection(this));
            }
            p0.a.setAutoMirrored(drawable, this.f19301b.A);
            Rect rect = this.f19302m;
            if (rect != null) {
                p0.a.setHotspotBounds(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f19312w.unwrap());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f19301b.canApplyTheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean d(int r10) {
        /*
            r9 = this;
            int r0 = r9.f19307r
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            t.b$d r0 = r9.f19301b
            int r0 = r0.f19340z
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f19304o
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f19303n
            if (r0 == 0) goto L29
            r9.f19304o = r0
            t.b$d r0 = r9.f19301b
            int r0 = r0.f19340z
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f19311v = r0
            goto L35
        L29:
            r9.f19304o = r4
            r9.f19311v = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f19303n
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            t.b$d r0 = r9.f19301b
            int r1 = r0.f19322h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.getChild(r10)
            r9.f19303n = r0
            r9.f19307r = r10
            if (r0 == 0) goto L5a
            t.b$d r10 = r9.f19301b
            int r10 = r10.f19339y
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f19310u = r2
        L51:
            r9.c(r0)
            goto L5a
        L55:
            r9.f19303n = r4
            r10 = -1
            r9.f19307r = r10
        L5a:
            long r0 = r9.f19310u
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f19311v
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L7c
        L67:
            t.b$a r0 = r9.f19309t
            if (r0 != 0) goto L76
            t.b$a r0 = new t.b$a
            r1 = r9
            t.e r1 = (t.e) r1
            r0.<init>(r1)
            r9.f19309t = r0
            goto L79
        L76:
            r9.unscheduleSelf(r0)
        L79:
            r9.a(r10)
        L7c:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: t.b.d(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f19304o;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void e(d dVar) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f19305p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f19301b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f19301b.canConstantState()) {
            return null;
        }
        this.f19301b.f19318d = getChangingConfigurations();
        return this.f19301b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f19303n;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f19302m;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f19301b.isConstantSize()) {
            return this.f19301b.getConstantHeight();
        }
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f19301b.isConstantSize()) {
            return this.f19301b.getConstantWidth();
        }
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f19301b.isConstantSize()) {
            return this.f19301b.getConstantMinimumHeight();
        }
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f19301b.isConstantSize()) {
            return this.f19301b.getConstantMinimumWidth();
        }
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f19303n;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f19301b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            C0254b.getOutline(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean padding;
        Rect constantPadding = this.f19301b.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
        } else {
            Drawable drawable = this.f19303n;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (isAutoMirrored() && p0.a.getLayoutDirection(this) == 1) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        d dVar = this.f19301b;
        if (dVar != null) {
            dVar.f19332r = false;
            dVar.f19334t = false;
        }
        if (drawable != this.f19303n || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f19301b.A;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f19304o;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f19304o = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f19303n;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f19306q) {
                this.f19303n.setAlpha(this.f19305p);
            }
        }
        if (this.f19311v != 0) {
            this.f19311v = 0L;
            z10 = true;
        }
        if (this.f19310u != 0) {
            this.f19310u = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f19308s && super.mutate() == this) {
            d dVarB = b();
            dVarB.b();
            e(dVarB);
            this.f19308s = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f19304o;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f19303n;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        d dVar = this.f19301b;
        int i11 = this.f19307r;
        int i12 = dVar.f19322h;
        Drawable[] drawableArr = dVar.f19321g;
        boolean z10 = false;
        for (int i13 = 0; i13 < i12; i13++) {
            Drawable drawable = drawableArr[i13];
            if (drawable != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? p0.a.setLayoutDirection(drawable, i10) : false;
                if (i13 == i11) {
                    z10 = layoutDirection;
                }
            }
        }
        dVar.f19338x = i10;
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f19304o;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f19303n;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f19304o;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f19303n;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable != this.f19303n || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f19306q && this.f19305p == i10) {
            return;
        }
        this.f19306q = true;
        this.f19305p = i10;
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            if (this.f19310u == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        d dVar = this.f19301b;
        if (dVar.A != z10) {
            dVar.A = z10;
            Drawable drawable = this.f19303n;
            if (drawable != null) {
                p0.a.setAutoMirrored(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        d dVar = this.f19301b;
        dVar.C = true;
        if (dVar.B != colorFilter) {
            dVar.B = colorFilter;
            Drawable drawable = this.f19303n;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        d dVar = this.f19301b;
        if (dVar.f19337w != z10) {
            dVar.f19337w = z10;
            Drawable drawable = this.f19303n;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            p0.a.setHotspot(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f19302m;
        if (rect == null) {
            this.f19302m = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f19303n;
        if (drawable != null) {
            p0.a.setHotspotBounds(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        d dVar = this.f19301b;
        dVar.F = true;
        if (dVar.D != colorStateList) {
            dVar.D = colorStateList;
            p0.a.setTintList(this.f19303n, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        d dVar = this.f19301b;
        dVar.G = true;
        if (dVar.E != mode) {
            dVar.E = mode;
            p0.a.setTintMode(this.f19303n, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f19304o;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f19303n;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f19303n || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* compiled from: DrawableContainerCompat.java */
    public static class c implements Drawable.Callback {

        /* renamed from: b, reason: collision with root package name */
        public Drawable.Callback f19314b;

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f19314b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f19314b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.f19314b;
            this.f19314b = null;
            return callback;
        }

        public c wrap(Drawable.Callback callback) {
            this.f19314b = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }
    }
}
