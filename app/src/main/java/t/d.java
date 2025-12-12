package t;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;

/* compiled from: DrawerArrowDrawable.java */
/* loaded from: classes.dex */
public final class d extends Drawable {

    /* renamed from: m, reason: collision with root package name */
    public static final float f19342m = (float) Math.toRadians(45.0d);

    /* renamed from: a, reason: collision with root package name */
    public final Paint f19343a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19344b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19345c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19346d;

    /* renamed from: e, reason: collision with root package name */
    public float f19347e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19348f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f19349g;

    /* renamed from: h, reason: collision with root package name */
    public final int f19350h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f19351i;

    /* renamed from: j, reason: collision with root package name */
    public float f19352j;

    /* renamed from: k, reason: collision with root package name */
    public float f19353k;

    /* renamed from: l, reason: collision with root package name */
    public final int f19354l;

    public d(Context context) {
        Paint paint = new Paint();
        this.f19343a = paint;
        this.f19349g = new Path();
        this.f19351i = false;
        this.f19354l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(typedArrayObtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f19350h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f19345c = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f19344b = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f19346d = typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        boolean z10 = false;
        int i10 = this.f19354l;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? p0.a.getLayoutDirection(this) == 0 : p0.a.getLayoutDirection(this) == 1))) {
            z10 = true;
        }
        float f10 = this.f19344b;
        float fSqrt = (float) Math.sqrt(f10 * f10 * 2.0f);
        float f11 = this.f19352j;
        float f12 = this.f19345c;
        float fA = o1.a.a(fSqrt, f12, f11, f12);
        float fA2 = o1.a.a(this.f19346d, f12, f11, f12);
        float fRound = Math.round(((this.f19353k - 0.0f) * f11) + 0.0f);
        float f13 = this.f19352j;
        float fA3 = o1.a.a(f19342m, 0.0f, f13, 0.0f);
        float f14 = z10 ? 0.0f : -180.0f;
        float fA4 = o1.a.a(z10 ? 180.0f : 0.0f, f14, f13, f14);
        double d10 = fA;
        double d11 = fA3;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(Math.sin(d11) * d10);
        Path path = this.f19349g;
        path.rewind();
        float f15 = this.f19347e;
        Paint paint = this.f19343a;
        float strokeWidth = paint.getStrokeWidth() + f15;
        float fA5 = o1.a.a(-this.f19353k, strokeWidth, this.f19352j, strokeWidth);
        float f16 = (-fA2) / 2.0f;
        path.moveTo(f16 + fRound, 0.0f);
        path.rLineTo(fA2 - (fRound * 2.0f), 0.0f);
        path.moveTo(f16, fA5);
        path.rLineTo(fRound2, fRound3);
        path.moveTo(f16, -fA5);
        path.rLineTo(fRound2, -fRound3);
        path.close();
        canvas.save();
        float strokeWidth2 = paint.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth2);
        canvas.translate(bounds.centerX(), (strokeWidth2 * 1.5f) + this.f19347e + ((((int) (fHeight - (2.0f * r7))) / 4) * 2));
        if (this.f19348f) {
            canvas.rotate(fA4 * (this.f19351i ^ z10 ? -1 : 1));
        } else if (z10) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f19350h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f19350h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Paint paint = this.f19343a;
        if (i10 != paint.getAlpha()) {
            paint.setAlpha(i10);
            invalidateSelf();
        }
    }

    public void setBarThickness(float f10) {
        Paint paint = this.f19343a;
        if (paint.getStrokeWidth() != f10) {
            paint.setStrokeWidth(f10);
            this.f19353k = (float) (Math.cos(f19342m) * (f10 / 2.0f));
            invalidateSelf();
        }
    }

    public void setColor(int i10) {
        Paint paint = this.f19343a;
        if (i10 != paint.getColor()) {
            paint.setColor(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f19343a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setGapSize(float f10) {
        if (f10 != this.f19347e) {
            this.f19347e = f10;
            invalidateSelf();
        }
    }

    public void setProgress(float f10) {
        if (this.f19352j != f10) {
            this.f19352j = f10;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z10) {
        if (this.f19348f != z10) {
            this.f19348f = z10;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z10) {
        if (this.f19351i != z10) {
            this.f19351i = z10;
            invalidateSelf();
        }
    }
}
