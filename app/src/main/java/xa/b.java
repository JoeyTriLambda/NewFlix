package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: FishSpinner.java */
/* loaded from: classes2.dex */
public final class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.b[] f21667h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21668i = 5;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f21669j = new float[5];

    /* compiled from: FishSpinner.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21670b;

        public a(int i10) {
            this.f21670b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b bVar = b.this;
            bVar.f21669j[this.f21670b] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            bVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21668i; i10++) {
            canvas.save();
            float f10 = this.f21669j[i10];
            PointF pointF = this.f21681f;
            canvas.rotate(f10, pointF.x, pointF.y);
            this.f21667h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c) / 10.0f;
        int i10 = this.f21668i;
        this.f21667h = new wa.b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f21667h[i11] = new wa.b();
            this.f21667h[i11].setCenter(this.f21681f.x, fMin);
            this.f21667h[i11].setColor(this.f21676a);
            this.f21667h[i11].setRadius(fMin - ((i11 * fMin) / 6.0f));
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21668i; i10++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration(1700L);
            valueAnimatorOfFloat.setStartDelay(i10 * 100);
            valueAnimatorOfFloat.addUpdateListener(new a(i10));
            valueAnimatorOfFloat.start();
        }
    }
}
