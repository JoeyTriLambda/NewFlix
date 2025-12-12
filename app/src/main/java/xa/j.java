package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: Whirlpool.java */
/* loaded from: classes2.dex */
public final class j extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.a[] f21711h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21712i = 3;

    /* renamed from: j, reason: collision with root package name */
    public float[] f21713j;

    /* compiled from: Whirlpool.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21714b;

        public a(int i10) {
            this.f21714b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j jVar = j.this;
            jVar.f21713j[this.f21714b] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            jVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21712i; i10++) {
            canvas.save();
            float f10 = this.f21713j[i10];
            PointF pointF = this.f21681f;
            canvas.rotate(f10, pointF.x, pointF.y);
            this.f21711h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c) / 2.0f;
        int i10 = this.f21712i;
        this.f21711h = new wa.a[i10];
        this.f21713j = new float[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            float f10 = ((i11 * fMin) / 4.0f) + (fMin / 4.0f);
            this.f21711h[i11] = new wa.a();
            this.f21711h[i11].setColor(this.f21676a);
            wa.a aVar = this.f21711h[i11];
            PointF pointF = this.f21681f;
            float f11 = pointF.x;
            float f12 = pointF.y;
            aVar.setOval(new RectF(f11 - f10, f12 - f10, f11 + f10, f12 + f10));
            this.f21711h[i11].setStartAngle(i11 * 45);
            this.f21711h[i11].setSweepAngle(r4 + 90);
            this.f21711h[i11].setStyle(Paint.Style.STROKE);
            this.f21711h[i11].setWidth(fMin / 10.0f);
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = this.f21712i - 1; i10 >= 0; i10--) {
            float[] fArr = new float[2];
            fArr[0] = this.f21711h[i10].getStartAngle();
            fArr[1] = this.f21711h[i10].getStartAngle() + ((i10 % 2 == 0 ? -1 : 1) * 360);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration((i10 + 1) * 500);
            valueAnimatorOfFloat.addUpdateListener(new a(i10));
            valueAnimatorOfFloat.start();
        }
    }
}
