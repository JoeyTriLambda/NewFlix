package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

/* compiled from: PhoneWave.java */
/* loaded from: classes2.dex */
public final class e extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.a[] f21683h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21684i = 3;

    /* compiled from: PhoneWave.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21685b;

        public a(int i10) {
            this.f21685b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            e eVar = e.this;
            eVar.f21683h[this.f21685b].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            eVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21684i; i10++) {
            this.f21683h[i10].draw(canvas);
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c) / 2.0f;
        int i10 = this.f21684i;
        this.f21683h = new wa.a[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            float f10 = ((i11 * fMin) / 4.0f) + (fMin / 4.0f);
            this.f21683h[i11] = new wa.a();
            this.f21683h[i11].setColor(this.f21676a);
            this.f21683h[i11].setAlpha(126);
            wa.a aVar = this.f21683h[i11];
            PointF pointF = this.f21681f;
            float f11 = pointF.x;
            float f12 = pointF.y;
            float f13 = fMin / 3.0f;
            aVar.setOval(new RectF(f11 - f10, (f12 - f10) + f13, f11 + f10, f12 + f10 + f13));
            this.f21683h[i11].setStartAngle(225.0f);
            this.f21683h[i11].setSweepAngle(90.0f);
            this.f21683h[i11].setStyle(Paint.Style.STROKE);
            this.f21683h[i11].setWidth(fMin / 10.0f);
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21684i; i10++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i10 * 120);
            valueAnimatorOfInt.addUpdateListener(new a(i10));
            valueAnimatorOfInt.start();
        }
    }
}
