package xa;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/* compiled from: Sharingan.java */
/* loaded from: classes2.dex */
public final class h extends d {

    /* renamed from: h, reason: collision with root package name */
    public wa.b f21697h;

    /* renamed from: i, reason: collision with root package name */
    public wa.b f21698i;

    /* renamed from: j, reason: collision with root package name */
    public wa.b[] f21699j;

    /* renamed from: k, reason: collision with root package name */
    public final int f21700k = 3;

    /* renamed from: l, reason: collision with root package name */
    public float f21701l;

    /* renamed from: m, reason: collision with root package name */
    public float f21702m;

    /* renamed from: n, reason: collision with root package name */
    public float f21703n;

    /* compiled from: Sharingan.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            h hVar = h.this;
            hVar.f21701l = fFloatValue;
            hVar.f21682g.reDraw();
        }
    }

    /* compiled from: Sharingan.java */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            h hVar = h.this;
            hVar.f21702m = fFloatValue;
            hVar.f21682g.reDraw();
        }
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        canvas.save();
        float f10 = this.f21702m;
        PointF pointF = this.f21681f;
        canvas.scale(f10, f10, pointF.x, pointF.y);
        float f11 = this.f21701l;
        PointF pointF2 = this.f21681f;
        canvas.rotate(f11, pointF2.x, pointF2.y);
        this.f21697h.draw(canvas);
        this.f21698i.draw(canvas);
        for (int i10 = 0; i10 < this.f21700k; i10++) {
            canvas.save();
            PointF pointF3 = this.f21681f;
            canvas.rotate(i10 * 120, pointF3.x, pointF3.y);
            this.f21699j[i10].draw(canvas);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // xa.d
    public void initializeObjects() {
        float fMin = Math.min(this.f21677b, this.f21678c) / 2.0f;
        this.f21703n = fMin / 1.5f;
        wa.b bVar = new wa.b();
        this.f21697h = bVar;
        PointF pointF = this.f21681f;
        bVar.setCenter(pointF.x, pointF.y);
        this.f21697h.setColor(this.f21676a);
        this.f21697h.setRadius(fMin / 4.0f);
        wa.b bVar2 = new wa.b();
        this.f21698i = bVar2;
        PointF pointF2 = this.f21681f;
        bVar2.setCenter(pointF2.x, pointF2.y);
        this.f21698i.setColor(this.f21676a);
        this.f21698i.setRadius(this.f21703n);
        this.f21698i.setStyle(Paint.Style.STROKE);
        this.f21698i.setWidth(fMin / 20.0f);
        int i10 = this.f21700k;
        this.f21699j = new wa.b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f21699j[i11] = new wa.b();
            wa.b bVar3 = this.f21699j[i11];
            PointF pointF3 = this.f21681f;
            bVar3.setCenter(pointF3.x, pointF3.y - this.f21703n);
            this.f21699j[i11].setColor(this.f21676a);
            this.f21699j[i11].setRadius(fMin / 6.0f);
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        valueAnimatorOfFloat.setDuration(1500L);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.addUpdateListener(new a());
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f, 1.0f);
        valueAnimatorOfFloat2.setDuration(1000L);
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.addUpdateListener(new b());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.start();
    }
}
