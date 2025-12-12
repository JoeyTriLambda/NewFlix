package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: Radar.java */
/* loaded from: classes2.dex */
public final class g extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.d f21694h;

    /* renamed from: i, reason: collision with root package name */
    public float f21695i;

    /* compiled from: Radar.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            g gVar = g.this;
            gVar.f21695i = fFloatValue;
            gVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        canvas.save();
        float f10 = this.f21695i;
        PointF pointF = this.f21681f;
        canvas.rotate(f10, pointF.x, pointF.y);
        this.f21694h.draw(canvas);
        canvas.restore();
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c);
        wa.d dVar = new wa.d();
        this.f21694h = dVar;
        dVar.setPoint1(this.f21681f);
        this.f21694h.setPoint2(new PointF(0.0f, fMin / 2.0f));
        this.f21694h.setColor(this.f21676a);
        this.f21694h.setWidth(5.0f);
    }

    @Override // xa.d
    public void setUpAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 359.0f);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new a());
        valueAnimatorOfFloat.start();
    }
}
