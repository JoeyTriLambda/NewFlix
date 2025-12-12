package q7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.BitSet;
import q7.m;
import q7.o;

/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes.dex */
public class g extends Drawable implements p0.c, p {
    public static final Paint I;
    public final p7.a A;
    public final a B;
    public final m C;
    public PorterDuffColorFilter D;
    public PorterDuffColorFilter E;
    public int F;
    public final RectF G;
    public final boolean H;

    /* renamed from: b, reason: collision with root package name */
    public b f17928b;

    /* renamed from: m, reason: collision with root package name */
    public final o.f[] f17929m;

    /* renamed from: n, reason: collision with root package name */
    public final o.f[] f17930n;

    /* renamed from: o, reason: collision with root package name */
    public final BitSet f17931o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f17932p;

    /* renamed from: q, reason: collision with root package name */
    public final Matrix f17933q;

    /* renamed from: r, reason: collision with root package name */
    public final Path f17934r;

    /* renamed from: s, reason: collision with root package name */
    public final Path f17935s;

    /* renamed from: t, reason: collision with root package name */
    public final RectF f17936t;

    /* renamed from: u, reason: collision with root package name */
    public final RectF f17937u;

    /* renamed from: v, reason: collision with root package name */
    public final Region f17938v;

    /* renamed from: w, reason: collision with root package name */
    public final Region f17939w;

    /* renamed from: x, reason: collision with root package name */
    public l f17940x;

    /* renamed from: y, reason: collision with root package name */
    public final Paint f17941y;

    /* renamed from: z, reason: collision with root package name */
    public final Paint f17942z;

    /* compiled from: MaterialShapeDrawable.java */
    public class a implements m.b {
        public a() {
        }

        public void onCornerPathCreated(o oVar, Matrix matrix, int i10) {
            g gVar = g.this;
            BitSet bitSet = gVar.f17931o;
            oVar.getClass();
            bitSet.set(i10, false);
            oVar.a(oVar.f18012f);
            gVar.f17929m[i10] = new n(new ArrayList(oVar.f18014h), new Matrix(matrix));
        }

        public void onEdgePathCreated(o oVar, Matrix matrix, int i10) {
            g gVar = g.this;
            oVar.getClass();
            gVar.f17931o.set(i10 + 4, false);
            oVar.a(oVar.f18012f);
            gVar.f17930n[i10] = new n(new ArrayList(oVar.f18014h), new Matrix(matrix));
        }
    }

    static {
        Paint paint = new Paint(1);
        I = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g() {
        this(new l());
    }

    public static g createWithElevationOverlay(Context context, float f10, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(c7.a.getColor(context, R.attr.colorSurface, g.class.getSimpleName()));
        }
        g gVar = new g();
        gVar.initializeElevationOverlay(context);
        gVar.setFillColor(colorStateList);
        gVar.setElevation(f10);
        return gVar;
    }

    public final void a(RectF rectF, Path path) {
        calculatePathForSize(rectF, path);
        if (this.f17928b.f17952i != 1.0f) {
            Matrix matrix = this.f17933q;
            matrix.reset();
            float f10 = this.f17928b.f17952i;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.G, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.PorterDuffColorFilter b(android.content.res.ColorStateList r2, android.graphics.PorterDuff.Mode r3, android.graphics.Paint r4, boolean r5) {
        /*
            r1 = this;
            if (r2 == 0) goto L1c
            if (r3 != 0) goto L5
            goto L1c
        L5:
            int[] r4 = r1.getState()
            r0 = 0
            int r2 = r2.getColorForState(r4, r0)
            if (r5 == 0) goto L14
            int r2 = r1.compositeElevationOverlayIfNeeded(r2)
        L14:
            r1.F = r2
            android.graphics.PorterDuffColorFilter r4 = new android.graphics.PorterDuffColorFilter
            r4.<init>(r2, r3)
            goto L34
        L1c:
            if (r5 == 0) goto L32
            int r2 = r4.getColor()
            int r3 = r1.compositeElevationOverlayIfNeeded(r2)
            r1.F = r3
            if (r3 == r2) goto L32
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r4)
            goto L33
        L32:
            r2 = 0
        L33:
            r4 = r2
        L34:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.g.b(android.content.res.ColorStateList, android.graphics.PorterDuff$Mode, android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    public final void c(Canvas canvas) {
        if (this.f17931o.cardinality() > 0) {
            Log.w("g", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i10 = this.f17928b.f17961r;
        Path path = this.f17934r;
        p7.a aVar = this.A;
        if (i10 != 0) {
            canvas.drawPath(path, aVar.getShadowPaint());
        }
        for (int i11 = 0; i11 < 4; i11++) {
            this.f17929m[i11].draw(aVar, this.f17928b.f17960q, canvas);
            this.f17930n[i11].draw(aVar, this.f17928b.f17960q, canvas);
        }
        if (this.H) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(path, I);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    public final void calculatePathForSize(RectF rectF, Path path) {
        m mVar = this.C;
        b bVar = this.f17928b;
        mVar.calculatePath(bVar.f17944a, bVar.f17953j, rectF, this.B, path);
    }

    public int compositeElevationOverlayIfNeeded(int i10) {
        float parentAbsoluteElevation = getParentAbsoluteElevation() + getZ();
        f7.a aVar = this.f17928b.f17945b;
        return aVar != null ? aVar.compositeOverlayIfNeeded(i10, parentAbsoluteElevation) : i10;
    }

    public final void d(Canvas canvas, Paint paint, Path path, l lVar, RectF rectF) {
        if (!lVar.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = lVar.getTopRightCornerSize().getCornerSize(rectF) * this.f17928b.f17953j;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint = this.f17941y;
        paint.setColorFilter(this.D);
        int alpha = paint.getAlpha();
        int i10 = this.f17928b.f17955l;
        paint.setAlpha(((i10 + (i10 >>> 7)) * alpha) >>> 8);
        Paint paint2 = this.f17942z;
        paint2.setColorFilter(this.E);
        paint2.setStrokeWidth(this.f17928b.f17954k);
        int alpha2 = paint2.getAlpha();
        int i11 = this.f17928b.f17955l;
        paint2.setAlpha(((i11 + (i11 >>> 7)) * alpha2) >>> 8);
        boolean z10 = this.f17932p;
        Path path = this.f17934r;
        boolean z11 = false;
        if (z10) {
            Paint.Style style = this.f17928b.f17964u;
            l lVarWithTransformedCornerSizes = getShapeAppearanceModel().withTransformedCornerSizes(new h(-((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && (paint2.getStrokeWidth() > 0.0f ? 1 : (paint2.getStrokeWidth() == 0.0f ? 0 : -1)) > 0 ? paint2.getStrokeWidth() / 2.0f : 0.0f)));
            this.f17940x = lVarWithTransformedCornerSizes;
            float f10 = this.f17928b.f17953j;
            RectF rectF = this.f17937u;
            rectF.set(getBoundsAsRectF());
            Paint.Style style2 = this.f17928b.f17964u;
            float strokeWidth = (style2 == Paint.Style.FILL_AND_STROKE || style2 == Paint.Style.STROKE) && (paint2.getStrokeWidth() > 0.0f ? 1 : (paint2.getStrokeWidth() == 0.0f ? 0 : -1)) > 0 ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.C.calculatePath(lVarWithTransformedCornerSizes, f10, rectF, this.f17935s);
            a(getBoundsAsRectF(), path);
            this.f17932p = false;
        }
        b bVar = this.f17928b;
        int i12 = bVar.f17959p;
        if (i12 != 1 && bVar.f17960q > 0 && (i12 == 2 || requiresCompatShadow())) {
            canvas.save();
            canvas.translate(getShadowOffsetX(), getShadowOffsetY());
            if (this.H) {
                RectF rectF2 = this.G;
                int iWidth = (int) (rectF2.width() - getBounds().width());
                int iHeight = (int) (rectF2.height() - getBounds().height());
                if (iWidth < 0 || iHeight < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.f17928b.f17960q * 2) + ((int) rectF2.width()) + iWidth, (this.f17928b.f17960q * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                float f11 = (getBounds().left - this.f17928b.f17960q) - iWidth;
                float f12 = (getBounds().top - this.f17928b.f17960q) - iHeight;
                canvas2.translate(-f11, -f12);
                c(canvas2);
                canvas.drawBitmap(bitmapCreateBitmap, f11, f12, (Paint) null);
                bitmapCreateBitmap.recycle();
                canvas.restore();
            } else {
                c(canvas);
                canvas.restore();
            }
        }
        b bVar2 = this.f17928b;
        Paint.Style style3 = bVar2.f17964u;
        if (style3 == Paint.Style.FILL_AND_STROKE || style3 == Paint.Style.FILL) {
            d(canvas, paint, path, bVar2.f17944a, getBoundsAsRectF());
        }
        Paint.Style style4 = this.f17928b.f17964u;
        if ((style4 == Paint.Style.FILL_AND_STROKE || style4 == Paint.Style.STROKE) && paint2.getStrokeWidth() > 0.0f) {
            z11 = true;
        }
        if (z11) {
            drawStrokeShape(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public void drawShape(Canvas canvas, Paint paint, Path path, RectF rectF) {
        d(canvas, paint, path, this.f17928b.f17944a, rectF);
    }

    public void drawStrokeShape(Canvas canvas) {
        Paint paint = this.f17942z;
        Path path = this.f17935s;
        l lVar = this.f17940x;
        RectF rectF = this.f17937u;
        rectF.set(getBoundsAsRectF());
        Paint.Style style = this.f17928b.f17964u;
        float strokeWidth = (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && (paint.getStrokeWidth() > 0.0f ? 1 : (paint.getStrokeWidth() == 0.0f ? 0 : -1)) > 0 ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        d(canvas, paint, path, lVar, rectF);
    }

    public final boolean e(int[] iArr) {
        boolean z10;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f17928b.f17946c == null || color2 == (colorForState2 = this.f17928b.f17946c.getColorForState(iArr, (color2 = (paint2 = this.f17941y).getColor())))) {
            z10 = false;
        } else {
            paint2.setColor(colorForState2);
            z10 = true;
        }
        if (this.f17928b.f17947d == null || color == (colorForState = this.f17928b.f17947d.getColorForState(iArr, (color = (paint = this.f17942z).getColor())))) {
            return z10;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean f() {
        PorterDuffColorFilter porterDuffColorFilter = this.D;
        PorterDuffColorFilter porterDuffColorFilter2 = this.E;
        b bVar = this.f17928b;
        this.D = b(bVar.f17949f, bVar.f17950g, this.f17941y, true);
        b bVar2 = this.f17928b;
        this.E = b(bVar2.f17948e, bVar2.f17950g, this.f17942z, false);
        b bVar3 = this.f17928b;
        if (bVar3.f17963t) {
            this.A.setShadowColor(bVar3.f17949f.getColorForState(getState(), 0));
        }
        return (w0.c.equals(porterDuffColorFilter, this.D) && w0.c.equals(porterDuffColorFilter2, this.E)) ? false : true;
    }

    public final void g() {
        float z10 = getZ();
        this.f17928b.f17960q = (int) Math.ceil(0.75f * z10);
        this.f17928b.f17961r = (int) Math.ceil(z10 * 0.25f);
        f();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17928b.f17955l;
    }

    public RectF getBoundsAsRectF() {
        RectF rectF = this.f17936t;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f17928b;
    }

    public float getElevation() {
        return this.f17928b.f17957n;
    }

    public ColorStateList getFillColor() {
        return this.f17928b.f17946c;
    }

    public float getInterpolation() {
        return this.f17928b.f17953j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.f17928b.f17959p == 2) {
            return;
        }
        if (isRoundRect()) {
            outline.setRoundRect(getBounds(), getTopLeftCornerResolvedSize() * this.f17928b.f17953j);
        } else {
            RectF boundsAsRectF = getBoundsAsRectF();
            Path path = this.f17934r;
            a(boundsAsRectF, path);
            e7.a.setOutlineToPath(outline, path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f17928b.f17951h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public float getParentAbsoluteElevation() {
        return this.f17928b.f17956m;
    }

    public int getResolvedTintColor() {
        return this.F;
    }

    public int getShadowOffsetX() {
        b bVar = this.f17928b;
        return (int) (Math.sin(Math.toRadians(bVar.f17962s)) * bVar.f17961r);
    }

    public int getShadowOffsetY() {
        b bVar = this.f17928b;
        return (int) (Math.cos(Math.toRadians(bVar.f17962s)) * bVar.f17961r);
    }

    public l getShapeAppearanceModel() {
        return this.f17928b.f17944a;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.f17928b.f17944a.getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.f17928b.f17944a.getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.f17928b.f17958o;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f17938v;
        region.set(bounds);
        RectF boundsAsRectF = getBoundsAsRectF();
        Path path = this.f17934r;
        a(boundsAsRectF, path);
        Region region2 = this.f17939w;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public float getZ() {
        return getTranslationZ() + getElevation();
    }

    public void initializeElevationOverlay(Context context) {
        this.f17928b.f17945b = new f7.a(context);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f17932p = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        f7.a aVar = this.f17928b.f17945b;
        return aVar != null && aVar.isThemeElevationOverlayEnabled();
    }

    public boolean isRoundRect() {
        return this.f17928b.f17944a.isRoundRect(getBoundsAsRectF());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f17928b.f17949f) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f17928b.f17948e) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f17928b.f17947d) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f17928b.f17946c) != null && colorStateList4.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f17928b = new b(this.f17928b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f17932p = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, i7.p.b
    public boolean onStateChange(int[] iArr) {
        boolean z10 = e(iArr) || f();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public boolean requiresCompatShadow() {
        return (isRoundRect() || this.f17934r.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        b bVar = this.f17928b;
        if (bVar.f17955l != i10) {
            bVar.f17955l = i10;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17928b.getClass();
        super.invalidateSelf();
    }

    public void setCornerSize(float f10) {
        setShapeAppearanceModel(this.f17928b.f17944a.withCornerSize(f10));
    }

    public void setElevation(float f10) {
        b bVar = this.f17928b;
        if (bVar.f17957n != f10) {
            bVar.f17957n = f10;
            g();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        b bVar = this.f17928b;
        if (bVar.f17946c != colorStateList) {
            bVar.f17946c = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f10) {
        b bVar = this.f17928b;
        if (bVar.f17953j != f10) {
            bVar.f17953j = f10;
            this.f17932p = true;
            invalidateSelf();
        }
    }

    public void setPadding(int i10, int i11, int i12, int i13) {
        b bVar = this.f17928b;
        if (bVar.f17951h == null) {
            bVar.f17951h = new Rect();
        }
        this.f17928b.f17951h.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public void setParentAbsoluteElevation(float f10) {
        b bVar = this.f17928b;
        if (bVar.f17956m != f10) {
            bVar.f17956m = f10;
            g();
        }
    }

    @Override // q7.p
    public void setShapeAppearanceModel(l lVar) {
        this.f17928b.f17944a = lVar;
        invalidateSelf();
    }

    public void setStroke(float f10, int i10) {
        setStrokeWidth(f10);
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        b bVar = this.f17928b;
        if (bVar.f17947d != colorStateList) {
            bVar.f17947d = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeWidth(float f10) {
        this.f17928b.f17954k = f10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f17928b.f17949f = colorStateList;
        f();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f17928b;
        if (bVar.f17950g != mode) {
            bVar.f17950g = mode;
            f();
            super.invalidateSelf();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(l.builder(context, attributeSet, i10, i11).build());
    }

    public void setCornerSize(c cVar) {
        setShapeAppearanceModel(this.f17928b.f17944a.withCornerSize(cVar));
    }

    public g(l lVar) {
        this(new b(lVar, null));
    }

    public void setStroke(float f10, ColorStateList colorStateList) {
        setStrokeWidth(f10);
        setStrokeColor(colorStateList);
    }

    public g(b bVar) {
        m mVar;
        this.f17929m = new o.f[4];
        this.f17930n = new o.f[4];
        this.f17931o = new BitSet(8);
        this.f17933q = new Matrix();
        this.f17934r = new Path();
        this.f17935s = new Path();
        this.f17936t = new RectF();
        this.f17937u = new RectF();
        this.f17938v = new Region();
        this.f17939w = new Region();
        Paint paint = new Paint(1);
        this.f17941y = paint;
        Paint paint2 = new Paint(1);
        this.f17942z = paint2;
        this.A = new p7.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mVar = m.getInstance();
        } else {
            mVar = new m();
        }
        this.C = mVar;
        this.G = new RectF();
        this.H = true;
        this.f17928b = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        f();
        e(getState());
        this.B = new a();
    }

    /* compiled from: MaterialShapeDrawable.java */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public l f17944a;

        /* renamed from: b, reason: collision with root package name */
        public f7.a f17945b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f17946c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f17947d;

        /* renamed from: e, reason: collision with root package name */
        public final ColorStateList f17948e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f17949f;

        /* renamed from: g, reason: collision with root package name */
        public PorterDuff.Mode f17950g;

        /* renamed from: h, reason: collision with root package name */
        public Rect f17951h;

        /* renamed from: i, reason: collision with root package name */
        public final float f17952i;

        /* renamed from: j, reason: collision with root package name */
        public float f17953j;

        /* renamed from: k, reason: collision with root package name */
        public float f17954k;

        /* renamed from: l, reason: collision with root package name */
        public int f17955l;

        /* renamed from: m, reason: collision with root package name */
        public float f17956m;

        /* renamed from: n, reason: collision with root package name */
        public float f17957n;

        /* renamed from: o, reason: collision with root package name */
        public final float f17958o;

        /* renamed from: p, reason: collision with root package name */
        public final int f17959p;

        /* renamed from: q, reason: collision with root package name */
        public int f17960q;

        /* renamed from: r, reason: collision with root package name */
        public int f17961r;

        /* renamed from: s, reason: collision with root package name */
        public int f17962s;

        /* renamed from: t, reason: collision with root package name */
        public final boolean f17963t;

        /* renamed from: u, reason: collision with root package name */
        public final Paint.Style f17964u;

        public b(l lVar, f7.a aVar) {
            this.f17946c = null;
            this.f17947d = null;
            this.f17948e = null;
            this.f17949f = null;
            this.f17950g = PorterDuff.Mode.SRC_IN;
            this.f17951h = null;
            this.f17952i = 1.0f;
            this.f17953j = 1.0f;
            this.f17955l = 255;
            this.f17956m = 0.0f;
            this.f17957n = 0.0f;
            this.f17958o = 0.0f;
            this.f17959p = 0;
            this.f17960q = 0;
            this.f17961r = 0;
            this.f17962s = 0;
            this.f17963t = false;
            this.f17964u = Paint.Style.FILL_AND_STROKE;
            this.f17944a = lVar;
            this.f17945b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f17932p = true;
            return gVar;
        }

        public b(b bVar) {
            this.f17946c = null;
            this.f17947d = null;
            this.f17948e = null;
            this.f17949f = null;
            this.f17950g = PorterDuff.Mode.SRC_IN;
            this.f17951h = null;
            this.f17952i = 1.0f;
            this.f17953j = 1.0f;
            this.f17955l = 255;
            this.f17956m = 0.0f;
            this.f17957n = 0.0f;
            this.f17958o = 0.0f;
            this.f17959p = 0;
            this.f17960q = 0;
            this.f17961r = 0;
            this.f17962s = 0;
            this.f17963t = false;
            this.f17964u = Paint.Style.FILL_AND_STROKE;
            this.f17944a = bVar.f17944a;
            this.f17945b = bVar.f17945b;
            this.f17954k = bVar.f17954k;
            this.f17946c = bVar.f17946c;
            this.f17947d = bVar.f17947d;
            this.f17950g = bVar.f17950g;
            this.f17949f = bVar.f17949f;
            this.f17955l = bVar.f17955l;
            this.f17952i = bVar.f17952i;
            this.f17961r = bVar.f17961r;
            this.f17959p = bVar.f17959p;
            this.f17963t = bVar.f17963t;
            this.f17953j = bVar.f17953j;
            this.f17956m = bVar.f17956m;
            this.f17957n = bVar.f17957n;
            this.f17958o = bVar.f17958o;
            this.f17960q = bVar.f17960q;
            this.f17962s = bVar.f17962s;
            this.f17948e = bVar.f17948e;
            this.f17964u = bVar.f17964u;
            if (bVar.f17951h != null) {
                this.f17951h = new Rect(bVar.f17951h);
            }
        }
    }
}
