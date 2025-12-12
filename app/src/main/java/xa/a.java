package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: ClassicSpinner.java */
/* loaded from: classes2.dex */
public final class a extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.b[] f21663h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21664i = 8;

    /* compiled from: ClassicSpinner.java */
    /* renamed from: xa.a$a, reason: collision with other inner class name */
    public class C0314a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21665b;

        public C0314a(int i10) {
            this.f21665b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a aVar = a.this;
            aVar.f21663h[this.f21665b].setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
            aVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21664i; i10++) {
            canvas.save();
            PointF pointF = this.f21681f;
            canvas.rotate(i10 * 45, pointF.x, pointF.y);
            this.f21663h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c) / 10.0f;
        int i10 = this.f21664i;
        this.f21663h = new wa.b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f21663h[i11] = new wa.b();
            this.f21663h[i11].setCenter(this.f21681f.x, fMin);
            this.f21663h[i11].setColor(this.f21676a);
            this.f21663h[i11].setAlpha(126);
            this.f21663h[i11].setRadius(fMin);
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21664i; i10++) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(126, 255, 126);
            valueAnimatorOfInt.setRepeatCount(-1);
            valueAnimatorOfInt.setDuration(1000L);
            valueAnimatorOfInt.setStartDelay(i10 * 120);
            valueAnimatorOfInt.addUpdateListener(new C0314a(i10));
            valueAnimatorOfInt.start();
        }
    }
}
