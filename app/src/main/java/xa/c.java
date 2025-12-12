package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: LineSpinner.java */
/* loaded from: classes2.dex */
public final class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.d[] f21672h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21673i = 8;

    /* compiled from: LineSpinner.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21674b;

        public a(int i10) {
            this.f21674b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c cVar = c.this;
            cVar.f21672h[this.f21674b].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            cVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21673i; i10++) {
            canvas.save();
            PointF pointF = this.f21681f;
            canvas.rotate(i10 * 45, pointF.x, pointF.y);
            this.f21672h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c);
        float f10 = fMin / 10.0f;
        int i10 = this.f21673i;
        this.f21672h = new wa.d[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f21672h[i11] = new wa.d();
            this.f21672h[i11].setColor(this.f21676a);
            this.f21672h[i11].setAlpha(126);
            this.f21672h[i11].setWidth(f10);
            wa.d dVar = this.f21672h[i11];
            PointF pointF = this.f21681f;
            dVar.setPoint1(new PointF(pointF.x, (pointF.y - (fMin / 2.0f)) + f10));
            this.f21672h[i11].setPoint2(new PointF(this.f21681f.x, (2.0f * f10) + this.f21672h[i11].getPoint1().y));
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21673i; i10++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i10 * 120);
            valueAnimatorOfInt.addUpdateListener(new a(i10));
            valueAnimatorOfInt.start();
        }
    }
}
