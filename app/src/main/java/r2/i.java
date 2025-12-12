package r2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import o0.d;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public final class i extends r2.h {

    /* renamed from: u, reason: collision with root package name */
    public static final PorterDuff.Mode f18384u = PorterDuff.Mode.SRC_IN;

    /* renamed from: m, reason: collision with root package name */
    public g f18385m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuffColorFilter f18386n;

    /* renamed from: o, reason: collision with root package name */
    public ColorFilter f18387o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f18388p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f18389q;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f18390r;

    /* renamed from: s, reason: collision with root package name */
    public final Matrix f18391s;

    /* renamed from: t, reason: collision with root package name */
    public final Rect f18392t;

    /* compiled from: VectorDrawableCompat.java */
    public static class a extends e {
        public a() {
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (n0.i.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray typedArrayObtainAttributes = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18358d);
                String string = typedArrayObtainAttributes.getString(0);
                if (string != null) {
                    this.f18417b = string;
                }
                String string2 = typedArrayObtainAttributes.getString(1);
                if (string2 != null) {
                    this.f18416a = o0.d.createNodesFromPathData(string2);
                }
                this.f18418c = n0.i.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "fillType", 2, 0);
                typedArrayObtainAttributes.recycle();
            }
        }

        @Override // r2.i.e
        public boolean isClipPath() {
            return true;
        }

        public a(a aVar) {
            super(aVar);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static abstract class d {
        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class g extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f18436a;

        /* renamed from: b, reason: collision with root package name */
        public f f18437b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f18438c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f18439d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f18440e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f18441f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f18442g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f18443h;

        /* renamed from: i, reason: collision with root package name */
        public int f18444i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f18445j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f18446k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f18447l;

        public g(g gVar) {
            this.f18438c = null;
            this.f18439d = i.f18384u;
            if (gVar != null) {
                this.f18436a = gVar.f18436a;
                f fVar = new f(gVar.f18437b);
                this.f18437b = fVar;
                if (gVar.f18437b.f18425e != null) {
                    fVar.f18425e = new Paint(gVar.f18437b.f18425e);
                }
                if (gVar.f18437b.f18424d != null) {
                    this.f18437b.f18424d = new Paint(gVar.f18437b.f18424d);
                }
                this.f18438c = gVar.f18438c;
                this.f18439d = gVar.f18439d;
                this.f18440e = gVar.f18440e;
            }
        }

        public boolean canReuseBitmap(int i10, int i11) {
            return i10 == this.f18441f.getWidth() && i11 == this.f18441f.getHeight();
        }

        public boolean canReuseCache() {
            return !this.f18446k && this.f18442g == this.f18438c && this.f18443h == this.f18439d && this.f18445j == this.f18440e && this.f18444i == this.f18437b.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(int i10, int i11) {
            if (this.f18441f == null || !canReuseBitmap(i10, i11)) {
                this.f18441f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f18446k = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f18441f, (Rect) null, rect, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f18436a;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.f18447l == null) {
                Paint paint = new Paint();
                this.f18447l = paint;
                paint.setFilterBitmap(true);
            }
            this.f18447l.setAlpha(this.f18437b.getRootAlpha());
            this.f18447l.setColorFilter(colorFilter);
            return this.f18447l;
        }

        public boolean hasTranslucentRoot() {
            return this.f18437b.getRootAlpha() < 255;
        }

        public boolean isStateful() {
            return this.f18437b.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean zOnStateChanged = this.f18437b.onStateChanged(iArr);
            this.f18446k |= zOnStateChanged;
            return zOnStateChanged;
        }

        public void updateCacheStates() {
            this.f18442g = this.f18438c;
            this.f18443h = this.f18439d;
            this.f18444i = this.f18437b.getRootAlpha();
            this.f18445j = this.f18440e;
            this.f18446k = false;
        }

        public void updateCachedBitmap(int i10, int i11) {
            this.f18441f.eraseColor(0);
            this.f18437b.draw(new Canvas(this.f18441f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public g() {
            this.f18438c = null;
            this.f18439d = i.f18384u;
            this.f18437b = new f();
        }
    }

    public i() {
        this.f18389q = true;
        this.f18390r = new float[9];
        this.f18391s = new Matrix();
        this.f18392t = new Rect();
        this.f18385m = new g();
    }

    public static i create(Resources resources, int i10, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f18383b = n0.g.getDrawable(resources, i10, theme);
            new h(iVar.f18383b.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("VectorDrawableCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        }
    }

    public static i createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f18383b;
        if (drawable == null) {
            return false;
        }
        p0.a.canApplyTheme(drawable);
        return false;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f18392t;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f18387o;
        if (colorFilter == null) {
            colorFilter = this.f18386n;
        }
        Matrix matrix = this.f18391s;
        canvas.getMatrix(matrix);
        float[] fArr = this.f18390r;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && p0.a.getLayoutDirection(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        this.f18385m.createCachedBitmapIfNeeded(iMin, iMin2);
        if (!this.f18389q) {
            this.f18385m.updateCachedBitmap(iMin, iMin2);
        } else if (!this.f18385m.canReuseCache()) {
            this.f18385m.updateCachedBitmap(iMin, iMin2);
            this.f18385m.updateCacheStates();
        }
        this.f18385m.drawCachedBitmapWithRootAlpha(canvas, colorFilter, rect);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.getAlpha(drawable) : this.f18385m.f18437b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f18385m.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.getColorFilter(drawable) : this.f18387o;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f18383b != null && Build.VERSION.SDK_INT >= 24) {
            return new h(this.f18383b.getConstantState());
        }
        this.f18385m.f18436a = getChangingConfigurations();
        return this.f18385m;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f18385m.f18437b.f18429i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f18385m.f18437b.f18428h;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f18383b;
        return drawable != null ? p0.a.isAutoMirrored(drawable) : this.f18385m.f18440e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        g gVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((gVar = this.f18385m) != null && (gVar.isStateful() || ((colorStateList = this.f18385m.f18438c) != null && colorStateList.isStateful())));
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f18388p && super.mutate() == this) {
            this.f18385m = new g(this.f18385m);
            this.f18388p = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.f18385m;
        ColorStateList colorStateList = gVar.f18438c;
        if (colorStateList == null || (mode = gVar.f18439d) == null) {
            z10 = false;
        } else {
            this.f18386n = a(colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!gVar.isStateful() || !gVar.onStateChanged(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f18385m.f18437b.getRootAlpha() != i10) {
            this.f18385m.f18437b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setAutoMirrored(drawable, z10);
        } else {
            this.f18385m.f18440e = z10;
        }
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // r2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTint(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTintList(drawable, colorStateList);
            return;
        }
        g gVar = this.f18385m;
        if (gVar.f18438c != colorStateList) {
            gVar.f18438c = colorStateList;
            this.f18386n = a(colorStateList, gVar.f18439d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.setTintMode(drawable, mode);
            return;
        }
        g gVar = this.f18385m;
        if (gVar.f18439d != mode) {
            gVar.f18439d = mode;
            this.f18386n = a(gVar.f18438c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f18383b;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f18448a;

        public h(Drawable.ConstantState constantState) {
            this.f18448a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f18448a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f18448a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f18383b = (VectorDrawable) this.f18448a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f18383b = (VectorDrawable) this.f18448a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f18383b = (VectorDrawable) this.f18448a.newDrawable(resources, theme);
            return iVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f18387o = colorFilter;
            invalidateSelf();
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static abstract class e extends d {

        /* renamed from: a, reason: collision with root package name */
        public d.a[] f18416a;

        /* renamed from: b, reason: collision with root package name */
        public String f18417b;

        /* renamed from: c, reason: collision with root package name */
        public int f18418c;

        /* renamed from: d, reason: collision with root package name */
        public final int f18419d;

        public e() {
            this.f18416a = null;
            this.f18418c = 0;
        }

        public d.a[] getPathData() {
            return this.f18416a;
        }

        public String getPathName() {
            return this.f18417b;
        }

        public boolean isClipPath() {
            return false;
        }

        public void setPathData(d.a[] aVarArr) {
            if (o0.d.canMorph(this.f18416a, aVarArr)) {
                o0.d.updateNodes(this.f18416a, aVarArr);
            } else {
                this.f18416a = o0.d.deepCopyNodes(aVarArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            d.a[] aVarArr = this.f18416a;
            if (aVarArr != null) {
                d.a.nodesToPath(aVarArr, path);
            }
        }

        public e(e eVar) {
            this.f18416a = null;
            this.f18418c = 0;
            this.f18417b = eVar.f18417b;
            this.f18419d = eVar.f18419d;
            this.f18416a = o0.d.deepCopyNodes(eVar.f18416a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f18383b;
        if (drawable != null) {
            p0.a.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f18385m;
        gVar.f18437b = new f();
        TypedArray typedArrayObtainAttributes = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18355a);
        g gVar2 = this.f18385m;
        f fVar = gVar2.f18437b;
        int namedInt = n0.i.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "tintMode", 6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (namedInt == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (namedInt != 5) {
            if (namedInt != 9) {
                switch (namedInt) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        gVar2.f18439d = mode;
        int i10 = 1;
        ColorStateList namedColorStateList = n0.i.getNamedColorStateList(typedArrayObtainAttributes, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            gVar2.f18438c = namedColorStateList;
        }
        gVar2.f18440e = n0.i.getNamedBoolean(typedArrayObtainAttributes, xmlPullParser, "autoMirrored", 5, gVar2.f18440e);
        fVar.f18430j = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "viewportWidth", 7, fVar.f18430j);
        float namedFloat = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "viewportHeight", 8, fVar.f18431k);
        fVar.f18431k = namedFloat;
        if (fVar.f18430j <= 0.0f) {
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (namedFloat > 0.0f) {
            fVar.f18428h = typedArrayObtainAttributes.getDimension(3, fVar.f18428h);
            int i11 = 2;
            float dimension = typedArrayObtainAttributes.getDimension(2, fVar.f18429i);
            fVar.f18429i = dimension;
            if (fVar.f18428h <= 0.0f) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                fVar.setAlpha(n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArrayObtainAttributes.getString(0);
                if (string != null) {
                    fVar.f18433m = string;
                    fVar.f18435o.put(string, fVar);
                }
                typedArrayObtainAttributes.recycle();
                gVar.f18436a = getChangingConfigurations();
                gVar.f18446k = true;
                g gVar3 = this.f18385m;
                f fVar2 = gVar3.f18437b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(fVar2.f18427g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z10 = true;
                for (int i12 = 3; eventType != i10 && (xmlPullParser.getDepth() >= depth || eventType != i12); i12 = 3) {
                    if (eventType == i11) {
                        String name = xmlPullParser.getName();
                        c cVar = (c) arrayDeque.peek();
                        boolean zEquals = ClientCookie.PATH_ATTR.equals(name);
                        b0.b<String, Object> bVar = fVar2.f18435o;
                        if (zEquals) {
                            b bVar2 = new b();
                            bVar2.inflate(resources, attributeSet, theme, xmlPullParser);
                            cVar.f18405b.add(bVar2);
                            if (bVar2.getPathName() != null) {
                                bVar.put(bVar2.getPathName(), bVar2);
                            }
                            gVar3.f18436a = bVar2.f18419d | gVar3.f18436a;
                            z10 = false;
                        } else if ("clip-path".equals(name)) {
                            a aVar = new a();
                            aVar.inflate(resources, attributeSet, theme, xmlPullParser);
                            cVar.f18405b.add(aVar);
                            if (aVar.getPathName() != null) {
                                bVar.put(aVar.getPathName(), aVar);
                            }
                            gVar3.f18436a = aVar.f18419d | gVar3.f18436a;
                        } else if ("group".equals(name)) {
                            c cVar2 = new c();
                            cVar2.inflate(resources, attributeSet, theme, xmlPullParser);
                            cVar.f18405b.add(cVar2);
                            arrayDeque.push(cVar2);
                            if (cVar2.getGroupName() != null) {
                                bVar.put(cVar2.getGroupName(), cVar2);
                            }
                            gVar3.f18436a = cVar2.f18414k | gVar3.f18436a;
                        }
                    } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                        arrayDeque.pop();
                    }
                    eventType = xmlPullParser.next();
                    i11 = 2;
                    i10 = 1;
                }
                if (!z10) {
                    this.f18386n = a(gVar.f18438c, gVar.f18439d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public i(g gVar) {
        this.f18389q = true;
        this.f18390r = new float[9];
        this.f18391s = new Matrix();
        this.f18392t = new Rect();
        this.f18385m = gVar;
        this.f18386n = a(gVar.f18438c, gVar.f18439d);
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class b extends e {

        /* renamed from: e, reason: collision with root package name */
        public n0.c f18393e;

        /* renamed from: f, reason: collision with root package name */
        public float f18394f;

        /* renamed from: g, reason: collision with root package name */
        public n0.c f18395g;

        /* renamed from: h, reason: collision with root package name */
        public float f18396h;

        /* renamed from: i, reason: collision with root package name */
        public float f18397i;

        /* renamed from: j, reason: collision with root package name */
        public float f18398j;

        /* renamed from: k, reason: collision with root package name */
        public float f18399k;

        /* renamed from: l, reason: collision with root package name */
        public float f18400l;

        /* renamed from: m, reason: collision with root package name */
        public Paint.Cap f18401m;

        /* renamed from: n, reason: collision with root package name */
        public Paint.Join f18402n;

        /* renamed from: o, reason: collision with root package name */
        public float f18403o;

        public b() {
            this.f18394f = 0.0f;
            this.f18396h = 1.0f;
            this.f18397i = 1.0f;
            this.f18398j = 0.0f;
            this.f18399k = 1.0f;
            this.f18400l = 0.0f;
            this.f18401m = Paint.Cap.BUTT;
            this.f18402n = Paint.Join.MITER;
            this.f18403o = 4.0f;
        }

        public float getFillAlpha() {
            return this.f18397i;
        }

        public int getFillColor() {
            return this.f18395g.getColor();
        }

        public float getStrokeAlpha() {
            return this.f18396h;
        }

        public int getStrokeColor() {
            return this.f18393e.getColor();
        }

        public float getStrokeWidth() {
            return this.f18394f;
        }

        public float getTrimPathEnd() {
            return this.f18399k;
        }

        public float getTrimPathOffset() {
            return this.f18400l;
        }

        public float getTrimPathStart() {
            return this.f18398j;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayObtainAttributes = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18357c);
            if (n0.i.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArrayObtainAttributes.getString(0);
                if (string != null) {
                    this.f18417b = string;
                }
                String string2 = typedArrayObtainAttributes.getString(2);
                if (string2 != null) {
                    this.f18416a = o0.d.createNodesFromPathData(string2);
                }
                this.f18395g = n0.i.getNamedComplexColor(typedArrayObtainAttributes, xmlPullParser, theme, "fillColor", 1, 0);
                this.f18397i = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "fillAlpha", 12, this.f18397i);
                int namedInt = n0.i.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "strokeLineCap", 8, -1);
                Paint.Cap cap = this.f18401m;
                if (namedInt == 0) {
                    cap = Paint.Cap.BUTT;
                } else if (namedInt == 1) {
                    cap = Paint.Cap.ROUND;
                } else if (namedInt == 2) {
                    cap = Paint.Cap.SQUARE;
                }
                this.f18401m = cap;
                int namedInt2 = n0.i.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "strokeLineJoin", 9, -1);
                Paint.Join join = this.f18402n;
                if (namedInt2 == 0) {
                    join = Paint.Join.MITER;
                } else if (namedInt2 == 1) {
                    join = Paint.Join.ROUND;
                } else if (namedInt2 == 2) {
                    join = Paint.Join.BEVEL;
                }
                this.f18402n = join;
                this.f18403o = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "strokeMiterLimit", 10, this.f18403o);
                this.f18393e = n0.i.getNamedComplexColor(typedArrayObtainAttributes, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f18396h = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "strokeAlpha", 11, this.f18396h);
                this.f18394f = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "strokeWidth", 4, this.f18394f);
                this.f18399k = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "trimPathEnd", 6, this.f18399k);
                this.f18400l = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "trimPathOffset", 7, this.f18400l);
                this.f18398j = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "trimPathStart", 5, this.f18398j);
                this.f18418c = n0.i.getNamedInt(typedArrayObtainAttributes, xmlPullParser, "fillType", 13, this.f18418c);
            }
            typedArrayObtainAttributes.recycle();
        }

        @Override // r2.i.d
        public boolean isStateful() {
            return this.f18395g.isStateful() || this.f18393e.isStateful();
        }

        @Override // r2.i.d
        public boolean onStateChanged(int[] iArr) {
            return this.f18393e.onStateChanged(iArr) | this.f18395g.onStateChanged(iArr);
        }

        public void setFillAlpha(float f10) {
            this.f18397i = f10;
        }

        public void setFillColor(int i10) {
            this.f18395g.setColor(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f18396h = f10;
        }

        public void setStrokeColor(int i10) {
            this.f18393e.setColor(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f18394f = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f18399k = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f18400l = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f18398j = f10;
        }

        public b(b bVar) {
            super(bVar);
            this.f18394f = 0.0f;
            this.f18396h = 1.0f;
            this.f18397i = 1.0f;
            this.f18398j = 0.0f;
            this.f18399k = 1.0f;
            this.f18400l = 0.0f;
            this.f18401m = Paint.Cap.BUTT;
            this.f18402n = Paint.Join.MITER;
            this.f18403o = 4.0f;
            bVar.getClass();
            this.f18393e = bVar.f18393e;
            this.f18394f = bVar.f18394f;
            this.f18396h = bVar.f18396h;
            this.f18395g = bVar.f18395g;
            this.f18418c = bVar.f18418c;
            this.f18397i = bVar.f18397i;
            this.f18398j = bVar.f18398j;
            this.f18399k = bVar.f18399k;
            this.f18400l = bVar.f18400l;
            this.f18401m = bVar.f18401m;
            this.f18402n = bVar.f18402n;
            this.f18403o = bVar.f18403o;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class c extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f18404a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<d> f18405b;

        /* renamed from: c, reason: collision with root package name */
        public float f18406c;

        /* renamed from: d, reason: collision with root package name */
        public float f18407d;

        /* renamed from: e, reason: collision with root package name */
        public float f18408e;

        /* renamed from: f, reason: collision with root package name */
        public float f18409f;

        /* renamed from: g, reason: collision with root package name */
        public float f18410g;

        /* renamed from: h, reason: collision with root package name */
        public float f18411h;

        /* renamed from: i, reason: collision with root package name */
        public float f18412i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f18413j;

        /* renamed from: k, reason: collision with root package name */
        public final int f18414k;

        /* renamed from: l, reason: collision with root package name */
        public String f18415l;

        public c() {
            this.f18404a = new Matrix();
            this.f18405b = new ArrayList<>();
            this.f18406c = 0.0f;
            this.f18407d = 0.0f;
            this.f18408e = 0.0f;
            this.f18409f = 1.0f;
            this.f18410g = 1.0f;
            this.f18411h = 0.0f;
            this.f18412i = 0.0f;
            this.f18413j = new Matrix();
            this.f18415l = null;
        }

        public final void a() {
            Matrix matrix = this.f18413j;
            matrix.reset();
            matrix.postTranslate(-this.f18407d, -this.f18408e);
            matrix.postScale(this.f18409f, this.f18410g);
            matrix.postRotate(this.f18406c, 0.0f, 0.0f);
            matrix.postTranslate(this.f18411h + this.f18407d, this.f18412i + this.f18408e);
        }

        public String getGroupName() {
            return this.f18415l;
        }

        public Matrix getLocalMatrix() {
            return this.f18413j;
        }

        public float getPivotX() {
            return this.f18407d;
        }

        public float getPivotY() {
            return this.f18408e;
        }

        public float getRotation() {
            return this.f18406c;
        }

        public float getScaleX() {
            return this.f18409f;
        }

        public float getScaleY() {
            return this.f18410g;
        }

        public float getTranslateX() {
            return this.f18411h;
        }

        public float getTranslateY() {
            return this.f18412i;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayObtainAttributes = n0.i.obtainAttributes(resources, theme, attributeSet, r2.a.f18356b);
            this.f18406c = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "rotation", 5, this.f18406c);
            this.f18407d = typedArrayObtainAttributes.getFloat(1, this.f18407d);
            this.f18408e = typedArrayObtainAttributes.getFloat(2, this.f18408e);
            this.f18409f = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "scaleX", 3, this.f18409f);
            this.f18410g = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "scaleY", 4, this.f18410g);
            this.f18411h = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "translateX", 6, this.f18411h);
            this.f18412i = n0.i.getNamedFloat(typedArrayObtainAttributes, xmlPullParser, "translateY", 7, this.f18412i);
            String string = typedArrayObtainAttributes.getString(0);
            if (string != null) {
                this.f18415l = string;
            }
            a();
            typedArrayObtainAttributes.recycle();
        }

        @Override // r2.i.d
        public boolean isStateful() {
            int i10 = 0;
            while (true) {
                ArrayList<d> arrayList = this.f18405b;
                if (i10 >= arrayList.size()) {
                    return false;
                }
                if (arrayList.get(i10).isStateful()) {
                    return true;
                }
                i10++;
            }
        }

        @Override // r2.i.d
        public boolean onStateChanged(int[] iArr) {
            int i10 = 0;
            boolean zOnStateChanged = false;
            while (true) {
                ArrayList<d> arrayList = this.f18405b;
                if (i10 >= arrayList.size()) {
                    return zOnStateChanged;
                }
                zOnStateChanged |= arrayList.get(i10).onStateChanged(iArr);
                i10++;
            }
        }

        public void setPivotX(float f10) {
            if (f10 != this.f18407d) {
                this.f18407d = f10;
                a();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f18408e) {
                this.f18408e = f10;
                a();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f18406c) {
                this.f18406c = f10;
                a();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f18409f) {
                this.f18409f = f10;
                a();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f18410g) {
                this.f18410g = f10;
                a();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f18411h) {
                this.f18411h = f10;
                a();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f18412i) {
                this.f18412i = f10;
                a();
            }
        }

        public c(c cVar, b0.b<String, Object> bVar) {
            e aVar;
            this.f18404a = new Matrix();
            this.f18405b = new ArrayList<>();
            this.f18406c = 0.0f;
            this.f18407d = 0.0f;
            this.f18408e = 0.0f;
            this.f18409f = 1.0f;
            this.f18410g = 1.0f;
            this.f18411h = 0.0f;
            this.f18412i = 0.0f;
            Matrix matrix = new Matrix();
            this.f18413j = matrix;
            this.f18415l = null;
            this.f18406c = cVar.f18406c;
            this.f18407d = cVar.f18407d;
            this.f18408e = cVar.f18408e;
            this.f18409f = cVar.f18409f;
            this.f18410g = cVar.f18410g;
            this.f18411h = cVar.f18411h;
            this.f18412i = cVar.f18412i;
            String str = cVar.f18415l;
            this.f18415l = str;
            this.f18414k = cVar.f18414k;
            if (str != null) {
                bVar.put(str, this);
            }
            matrix.set(cVar.f18413j);
            ArrayList<d> arrayList = cVar.f18405b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                d dVar = arrayList.get(i10);
                if (dVar instanceof c) {
                    this.f18405b.add(new c((c) dVar, bVar));
                } else {
                    if (dVar instanceof b) {
                        aVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        aVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f18405b.add(aVar);
                    String str2 = aVar.f18417b;
                    if (str2 != null) {
                        bVar.put(str2, aVar);
                    }
                }
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    public static class f {

        /* renamed from: p, reason: collision with root package name */
        public static final Matrix f18420p = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f18421a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f18422b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f18423c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f18424d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f18425e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f18426f;

        /* renamed from: g, reason: collision with root package name */
        public final c f18427g;

        /* renamed from: h, reason: collision with root package name */
        public float f18428h;

        /* renamed from: i, reason: collision with root package name */
        public float f18429i;

        /* renamed from: j, reason: collision with root package name */
        public float f18430j;

        /* renamed from: k, reason: collision with root package name */
        public float f18431k;

        /* renamed from: l, reason: collision with root package name */
        public int f18432l;

        /* renamed from: m, reason: collision with root package name */
        public String f18433m;

        /* renamed from: n, reason: collision with root package name */
        public Boolean f18434n;

        /* renamed from: o, reason: collision with root package name */
        public final b0.b<String, Object> f18435o;

        public f() {
            this.f18423c = new Matrix();
            this.f18428h = 0.0f;
            this.f18429i = 0.0f;
            this.f18430j = 0.0f;
            this.f18431k = 0.0f;
            this.f18432l = 255;
            this.f18433m = null;
            this.f18434n = null;
            this.f18435o = new b0.b<>();
            this.f18427g = new c();
            this.f18421a = new Path();
            this.f18422b = new Path();
        }

        public final void a(c cVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            int i12;
            float f10;
            cVar.f18404a.set(matrix);
            Matrix matrix2 = cVar.f18404a;
            matrix2.preConcat(cVar.f18413j);
            canvas.save();
            char c10 = 0;
            int i13 = 0;
            while (true) {
                ArrayList<d> arrayList = cVar.f18405b;
                if (i13 >= arrayList.size()) {
                    canvas.restore();
                    return;
                }
                d dVar = arrayList.get(i13);
                if (dVar instanceof c) {
                    a((c) dVar, matrix2, canvas, i10, i11, colorFilter);
                } else {
                    if (dVar instanceof e) {
                        e eVar = (e) dVar;
                        float f11 = i10 / this.f18430j;
                        float f12 = i11 / this.f18431k;
                        float fMin = Math.min(f11, f12);
                        Matrix matrix3 = this.f18423c;
                        matrix3.set(matrix2);
                        matrix3.postScale(f11, f12);
                        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float fHypot = (float) Math.hypot(fArr[c10], fArr[1]);
                        i12 = i13;
                        float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                        float f13 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                        float fMax = Math.max(fHypot, fHypot2);
                        float fAbs = fMax > 0.0f ? Math.abs(f13) / fMax : 0.0f;
                        if (fAbs != 0.0f) {
                            Path path = this.f18421a;
                            eVar.toPath(path);
                            Path path2 = this.f18422b;
                            path2.reset();
                            if (eVar.isClipPath()) {
                                path2.setFillType(eVar.f18418c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                path2.addPath(path, matrix3);
                                canvas.clipPath(path2);
                            } else {
                                b bVar = (b) eVar;
                                float f14 = bVar.f18398j;
                                if (f14 != 0.0f || bVar.f18399k != 1.0f) {
                                    float f15 = bVar.f18400l;
                                    float f16 = (f14 + f15) % 1.0f;
                                    float f17 = (bVar.f18399k + f15) % 1.0f;
                                    if (this.f18426f == null) {
                                        this.f18426f = new PathMeasure();
                                    }
                                    this.f18426f.setPath(path, false);
                                    float length = this.f18426f.getLength();
                                    float f18 = f16 * length;
                                    float f19 = f17 * length;
                                    path.reset();
                                    if (f18 > f19) {
                                        this.f18426f.getSegment(f18, length, path, true);
                                        f10 = 0.0f;
                                        this.f18426f.getSegment(0.0f, f19, path, true);
                                    } else {
                                        f10 = 0.0f;
                                        this.f18426f.getSegment(f18, f19, path, true);
                                    }
                                    path.rLineTo(f10, f10);
                                }
                                path2.addPath(path, matrix3);
                                if (bVar.f18395g.willDraw()) {
                                    n0.c cVar2 = bVar.f18395g;
                                    if (this.f18425e == null) {
                                        Paint paint = new Paint(1);
                                        this.f18425e = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    }
                                    Paint paint2 = this.f18425e;
                                    if (cVar2.isGradient()) {
                                        Shader shader = cVar2.getShader();
                                        shader.setLocalMatrix(matrix3);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(bVar.f18397i * 255.0f));
                                    } else {
                                        paint2.setShader(null);
                                        paint2.setAlpha(255);
                                        int color = cVar2.getColor();
                                        float f20 = bVar.f18397i;
                                        PorterDuff.Mode mode = i.f18384u;
                                        paint2.setColor((color & 16777215) | (((int) (Color.alpha(color) * f20)) << 24));
                                    }
                                    paint2.setColorFilter(colorFilter);
                                    path2.setFillType(bVar.f18418c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                    canvas.drawPath(path2, paint2);
                                }
                                if (bVar.f18393e.willDraw()) {
                                    n0.c cVar3 = bVar.f18393e;
                                    if (this.f18424d == null) {
                                        Paint paint3 = new Paint(1);
                                        this.f18424d = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    }
                                    Paint paint4 = this.f18424d;
                                    Paint.Join join = bVar.f18402n;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = bVar.f18401m;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(bVar.f18403o);
                                    if (cVar3.isGradient()) {
                                        Shader shader2 = cVar3.getShader();
                                        shader2.setLocalMatrix(matrix3);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(bVar.f18396h * 255.0f));
                                    } else {
                                        paint4.setShader(null);
                                        paint4.setAlpha(255);
                                        int color2 = cVar3.getColor();
                                        float f21 = bVar.f18396h;
                                        PorterDuff.Mode mode2 = i.f18384u;
                                        paint4.setColor((color2 & 16777215) | (((int) (Color.alpha(color2) * f21)) << 24));
                                    }
                                    paint4.setColorFilter(colorFilter);
                                    paint4.setStrokeWidth(bVar.f18394f * fAbs * fMin);
                                    canvas.drawPath(path2, paint4);
                                }
                            }
                        }
                    }
                    i13 = i12 + 1;
                    c10 = 0;
                }
                i12 = i13;
                i13 = i12 + 1;
                c10 = 0;
            }
        }

        public void draw(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            a(this.f18427g, f18420p, canvas, i10, i11, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f18432l;
        }

        public boolean isStateful() {
            if (this.f18434n == null) {
                this.f18434n = Boolean.valueOf(this.f18427g.isStateful());
            }
            return this.f18434n.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.f18427g.onStateChanged(iArr);
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f18432l = i10;
        }

        public f(f fVar) {
            this.f18423c = new Matrix();
            this.f18428h = 0.0f;
            this.f18429i = 0.0f;
            this.f18430j = 0.0f;
            this.f18431k = 0.0f;
            this.f18432l = 255;
            this.f18433m = null;
            this.f18434n = null;
            b0.b<String, Object> bVar = new b0.b<>();
            this.f18435o = bVar;
            this.f18427g = new c(fVar.f18427g, bVar);
            this.f18421a = new Path(fVar.f18421a);
            this.f18422b = new Path(fVar.f18422b);
            this.f18428h = fVar.f18428h;
            this.f18429i = fVar.f18429i;
            this.f18430j = fVar.f18430j;
            this.f18431k = fVar.f18431k;
            this.f18432l = fVar.f18432l;
            this.f18433m = fVar.f18433m;
            String str = fVar.f18433m;
            if (str != null) {
                bVar.put(str, this);
            }
            this.f18434n = fVar.f18434n;
        }
    }
}
