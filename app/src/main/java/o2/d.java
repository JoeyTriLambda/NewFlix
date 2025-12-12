package o2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import w0.h;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public final class d extends Drawable implements Animatable {

    /* renamed from: r, reason: collision with root package name */
    public static final LinearInterpolator f16957r = new LinearInterpolator();

    /* renamed from: s, reason: collision with root package name */
    public static final p1.b f16958s = new p1.b();

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f16959t = {-16777216};

    /* renamed from: b, reason: collision with root package name */
    public final a f16960b;

    /* renamed from: m, reason: collision with root package name */
    public float f16961m;

    /* renamed from: n, reason: collision with root package name */
    public final Resources f16962n;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f16963o;

    /* renamed from: p, reason: collision with root package name */
    public float f16964p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f16965q;

    /* compiled from: CircularProgressDrawable.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final RectF f16966a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f16967b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f16968c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f16969d;

        /* renamed from: e, reason: collision with root package name */
        public float f16970e;

        /* renamed from: f, reason: collision with root package name */
        public float f16971f;

        /* renamed from: g, reason: collision with root package name */
        public float f16972g;

        /* renamed from: h, reason: collision with root package name */
        public float f16973h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f16974i;

        /* renamed from: j, reason: collision with root package name */
        public int f16975j;

        /* renamed from: k, reason: collision with root package name */
        public float f16976k;

        /* renamed from: l, reason: collision with root package name */
        public float f16977l;

        /* renamed from: m, reason: collision with root package name */
        public float f16978m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f16979n;

        /* renamed from: o, reason: collision with root package name */
        public Path f16980o;

        /* renamed from: p, reason: collision with root package name */
        public float f16981p;

        /* renamed from: q, reason: collision with root package name */
        public float f16982q;

        /* renamed from: r, reason: collision with root package name */
        public int f16983r;

        /* renamed from: s, reason: collision with root package name */
        public int f16984s;

        /* renamed from: t, reason: collision with root package name */
        public int f16985t;

        /* renamed from: u, reason: collision with root package name */
        public int f16986u;

        public a() {
            Paint paint = new Paint();
            this.f16967b = paint;
            Paint paint2 = new Paint();
            this.f16968c = paint2;
            Paint paint3 = new Paint();
            this.f16969d = paint3;
            this.f16970e = 0.0f;
            this.f16971f = 0.0f;
            this.f16972g = 0.0f;
            this.f16973h = 5.0f;
            this.f16981p = 1.0f;
            this.f16985t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public final void a(int i10) {
            this.f16975j = i10;
            this.f16986u = this.f16974i[i10];
        }
    }

    public d(Context context) {
        this.f16962n = ((Context) h.checkNotNull(context)).getResources();
        a aVar = new a();
        this.f16960b = aVar;
        aVar.f16974i = f16959t;
        aVar.a(0);
        setStrokeWidth(2.5f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, aVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f16957r);
        valueAnimatorOfFloat.addListener(new c(this, aVar));
        this.f16963o = valueAnimatorOfFloat;
    }

    public static void c(float f10, a aVar) {
        if (f10 <= 0.75f) {
            aVar.f16986u = aVar.f16974i[aVar.f16975j];
            return;
        }
        float f11 = (f10 - 0.75f) / 0.25f;
        int[] iArr = aVar.f16974i;
        int i10 = aVar.f16975j;
        int i11 = iArr[i10];
        int i12 = iArr[(i10 + 1) % iArr.length];
        aVar.f16986u = ((((i11 >> 24) & 255) + ((int) ((((i12 >> 24) & 255) - r1) * f11))) << 24) | ((((i11 >> 16) & 255) + ((int) ((((i12 >> 16) & 255) - r3) * f11))) << 16) | ((((i11 >> 8) & 255) + ((int) ((((i12 >> 8) & 255) - r4) * f11))) << 8) | ((i11 & 255) + ((int) (f11 * ((i12 & 255) - r2))));
    }

    public final void a(float f10, a aVar, boolean z10) {
        float interpolation;
        float interpolation2;
        if (this.f16965q) {
            c(f10, aVar);
            float fFloor = (float) (Math.floor(aVar.f16978m / 0.8f) + 1.0d);
            float f11 = aVar.f16976k;
            float f12 = aVar.f16977l;
            aVar.f16970e = (((f12 - 0.01f) - f11) * f10) + f11;
            aVar.f16971f = f12;
            float f13 = aVar.f16978m;
            aVar.f16972g = o1.a.a(fFloor, f13, f10, f13);
            return;
        }
        if (f10 != 1.0f || z10) {
            float f14 = aVar.f16978m;
            p1.b bVar = f16958s;
            if (f10 < 0.5f) {
                interpolation = aVar.f16976k;
                interpolation2 = (bVar.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f15 = aVar.f16976k + 0.79f;
                interpolation = f15 - (((1.0f - bVar.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = f15;
            }
            float f16 = (0.20999998f * f10) + f14;
            float f17 = (f10 + this.f16964p) * 216.0f;
            aVar.f16970e = interpolation;
            aVar.f16971f = interpolation2;
            aVar.f16972g = f16;
            this.f16961m = f17;
        }
    }

    public final void b(float f10, float f11, float f12, float f13) {
        float f14 = this.f16962n.getDisplayMetrics().density;
        float f15 = f11 * f14;
        a aVar = this.f16960b;
        aVar.f16973h = f15;
        aVar.f16967b.setStrokeWidth(f15);
        aVar.f16982q = f10 * f14;
        aVar.a(0);
        aVar.f16983r = (int) (f12 * f14);
        aVar.f16984s = (int) (f13 * f14);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f16961m, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.f16960b;
        RectF rectF = aVar.f16966a;
        float f10 = aVar.f16982q;
        float fMin = (aVar.f16973h / 2.0f) + f10;
        if (f10 <= 0.0f) {
            fMin = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((aVar.f16983r * aVar.f16981p) / 2.0f, aVar.f16973h / 2.0f);
        }
        rectF.set(bounds.centerX() - fMin, bounds.centerY() - fMin, bounds.centerX() + fMin, bounds.centerY() + fMin);
        float f11 = aVar.f16970e;
        float f12 = aVar.f16972g;
        float f13 = (f11 + f12) * 360.0f;
        float f14 = ((aVar.f16971f + f12) * 360.0f) - f13;
        Paint paint = aVar.f16967b;
        paint.setColor(aVar.f16986u);
        paint.setAlpha(aVar.f16985t);
        float f15 = aVar.f16973h / 2.0f;
        rectF.inset(f15, f15);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.f16969d);
        float f16 = -f15;
        rectF.inset(f16, f16);
        canvas.drawArc(rectF, f13, f14, false, paint);
        if (aVar.f16979n) {
            Path path = aVar.f16980o;
            if (path == null) {
                Path path2 = new Path();
                aVar.f16980o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float fMin2 = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f17 = (aVar.f16983r * aVar.f16981p) / 2.0f;
            aVar.f16980o.moveTo(0.0f, 0.0f);
            aVar.f16980o.lineTo(aVar.f16983r * aVar.f16981p, 0.0f);
            Path path3 = aVar.f16980o;
            float f18 = aVar.f16983r;
            float f19 = aVar.f16981p;
            path3.lineTo((f18 * f19) / 2.0f, aVar.f16984s * f19);
            aVar.f16980o.offset((rectF.centerX() + fMin2) - f17, (aVar.f16973h / 2.0f) + rectF.centerY());
            aVar.f16980o.close();
            Paint paint2 = aVar.f16968c;
            paint2.setColor(aVar.f16986u);
            paint2.setAlpha(aVar.f16985t);
            canvas.save();
            canvas.rotate(f13 + f14, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.f16980o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f16960b.f16985t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f16963o.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f16960b.f16985t = i10;
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z10) {
        a aVar = this.f16960b;
        if (aVar.f16979n != z10) {
            aVar.f16979n = z10;
        }
        invalidateSelf();
    }

    public void setArrowScale(float f10) {
        a aVar = this.f16960b;
        if (f10 != aVar.f16981p) {
            aVar.f16981p = f10;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f16960b.f16967b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(int... iArr) {
        a aVar = this.f16960b;
        aVar.f16974i = iArr;
        aVar.a(0);
        aVar.a(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f10) {
        this.f16960b.f16972g = f10;
        invalidateSelf();
    }

    public void setStartEndTrim(float f10, float f11) {
        a aVar = this.f16960b;
        aVar.f16970e = f10;
        aVar.f16971f = f11;
        invalidateSelf();
    }

    public void setStrokeWidth(float f10) {
        a aVar = this.f16960b;
        aVar.f16973h = f10;
        aVar.f16967b.setStrokeWidth(f10);
        invalidateSelf();
    }

    public void setStyle(int i10) {
        if (i10 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f16963o.cancel();
        a aVar = this.f16960b;
        float f10 = aVar.f16970e;
        aVar.f16976k = f10;
        float f11 = aVar.f16971f;
        aVar.f16977l = f11;
        aVar.f16978m = aVar.f16972g;
        if (f11 != f10) {
            this.f16965q = true;
            this.f16963o.setDuration(666L);
            this.f16963o.start();
            return;
        }
        aVar.a(0);
        aVar.f16976k = 0.0f;
        aVar.f16977l = 0.0f;
        aVar.f16978m = 0.0f;
        aVar.f16970e = 0.0f;
        aVar.f16971f = 0.0f;
        aVar.f16972g = 0.0f;
        this.f16963o.setDuration(1332L);
        this.f16963o.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f16963o.cancel();
        this.f16961m = 0.0f;
        a aVar = this.f16960b;
        if (aVar.f16979n) {
            aVar.f16979n = false;
        }
        aVar.a(0);
        aVar.f16976k = 0.0f;
        aVar.f16977l = 0.0f;
        aVar.f16978m = 0.0f;
        aVar.f16970e = 0.0f;
        aVar.f16971f = 0.0f;
        aVar.f16972g = 0.0f;
        invalidateSelf();
    }
}
