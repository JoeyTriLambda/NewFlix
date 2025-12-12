package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;

/* compiled from: Worm.java */
/* loaded from: classes2.dex */
public final class k extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.b[] f21716h;

    /* renamed from: j, reason: collision with root package name */
    public float f21718j;

    /* renamed from: i, reason: collision with root package name */
    public final int f21717i = 5;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f21719k = {-2, -1, 0, 1, 2};

    /* compiled from: Worm.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21720b;

        public a(int i10) {
            this.f21720b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k kVar = k.this;
            kVar.f21716h[this.f21720b].setCenter(kVar.f21681f.x, ((Float) valueAnimator.getAnimatedValue()).floatValue());
            kVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21717i; i10++) {
            canvas.save();
            canvas.translate(this.f21718j * 2.0f * this.f21719k[i10], 0.0f);
            this.f21716h[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        int i10 = this.f21717i;
        this.f21716h = new wa.b[i10];
        int i11 = this.f21677b;
        this.f21718j = (i11 / 10.0f) - (i11 / 100.0f);
        for (int i12 = 0; i12 < i10; i12++) {
            this.f21716h[i12] = new wa.b();
            this.f21716h[i12].setColor(this.f21676a);
            this.f21716h[i12].setRadius(this.f21718j);
            wa.b bVar = this.f21716h[i12];
            PointF pointF = this.f21681f;
            bVar.setCenter(pointF.x, pointF.y);
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21717i; i10++) {
            float f10 = this.f21681f.y;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, this.f21678c / 4.0f, (r4 * 3) / 4.0f, f10);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setStartDelay(i10 * 120);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new a(i10));
            valueAnimatorOfFloat.start();
        }
    }
}
