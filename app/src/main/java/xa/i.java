package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: TwinFishesSpinner.java */
/* loaded from: classes2.dex */
public final class i extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.b[] f21706h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21707i = 10;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f21708j = new float[10];

    /* compiled from: TwinFishesSpinner.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21709b;

        public a(int i10) {
            this.f21709b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            i iVar = i.this;
            iVar.f21708j[this.f21709b] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            iVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21707i; i10++) {
            canvas.save();
            float f10 = this.f21708j[i10];
            PointF pointF = this.f21681f;
            canvas.rotate(f10, pointF.x, pointF.y);
            this.f21706h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c);
        float f10 = fMin / 10.0f;
        int i10 = this.f21707i;
        this.f21706h = new wa.b[i10];
        for (int i11 = 0; i11 < i10 / 2; i11++) {
            this.f21706h[i11] = new wa.b();
            this.f21706h[i11].setCenter(this.f21681f.x, f10);
            this.f21706h[i11].setColor(this.f21676a);
            this.f21706h[i11].setRadius(f10 - ((i11 * f10) / 6.0f));
        }
        for (int i12 = i10 / 2; i12 < i10; i12++) {
            this.f21706h[i12] = new wa.b();
            this.f21706h[i12].setCenter(this.f21681f.x, fMin - f10);
            this.f21706h[i12].setColor(this.f21676a);
            this.f21706h[i12].setRadius(f10 - (((i12 - 5) * f10) / 6.0f));
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        int i10 = 0;
        while (i10 < this.f21707i) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration(1700L);
            valueAnimatorOfFloat.setStartDelay((i10 >= 5 ? i10 - 5 : i10) * 100);
            valueAnimatorOfFloat.addUpdateListener(new a(i10));
            valueAnimatorOfFloat.start();
            i10++;
        }
    }
}
