package xa;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.tuyenmonkey.mkloader.exception.InvalidNumberOfPulseException;

/* compiled from: Pulse.java */
/* loaded from: classes2.dex */
public final class f extends d {

    /* renamed from: h, reason: collision with root package name */
    public final wa.d[] f21687h;

    /* renamed from: i, reason: collision with root package name */
    public final int f21688i;

    /* renamed from: j, reason: collision with root package name */
    public float f21689j;

    /* renamed from: k, reason: collision with root package name */
    public float f21690k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f21691l;

    /* compiled from: Pulse.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f21692b;

        public a(int i10) {
            this.f21692b = i10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            f fVar = f.this;
            fVar.f21691l[this.f21692b] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            fVar.f21682g.reDraw();
        }
    }

    public f(int i10) throws InvalidNumberOfPulseException {
        if (i10 < 3 || i10 > 5) {
            throw new InvalidNumberOfPulseException();
        }
        this.f21688i = i10;
        this.f21687h = new wa.d[i10];
        this.f21691l = new float[i10];
    }

    @Override // xa.d
    public void draw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f21688i; i10++) {
            canvas.save();
            canvas.translate((this.f21689j + this.f21690k) * i10, 0.0f);
            float f10 = this.f21691l[i10];
            wa.d[] dVarArr = this.f21687h;
            canvas.scale(1.0f, f10, dVarArr[i10].getPoint1().x, this.f21681f.y);
            dVarArr[i10].draw(canvas);
            canvas.restore();
        }
    }

    @Override // xa.d
    public void initializeObjects() {
        int i10 = this.f21677b;
        int i11 = this.f21688i;
        float f10 = i10 / (i11 * 2);
        this.f21689j = f10;
        float f11 = f10 / 4.0f;
        this.f21690k = f11;
        float f12 = (f10 / 2.0f) + ((i10 - ((f11 * (i11 - 1)) + (i11 * f10))) / 2.0f);
        for (int i12 = 0; i12 < i11; i12++) {
            wa.d dVar = new wa.d();
            wa.d[] dVarArr = this.f21687h;
            dVarArr[i12] = dVar;
            dVarArr[i12].setColor(this.f21676a);
            dVarArr[i12].setWidth(this.f21689j);
            dVarArr[i12].setPoint1(new PointF(f12, this.f21681f.y - (this.f21678c / 4.0f)));
            dVarArr[i12].setPoint2(new PointF(f12, (this.f21678c / 4.0f) + this.f21681f.y));
        }
    }

    @Override // xa.d
    public void setUpAnimation() {
        for (int i10 = 0; i10 < this.f21688i; i10++) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.5f, 1.0f);
            valueAnimatorOfFloat.setDuration(1000L);
            valueAnimatorOfFloat.setStartDelay(i10 * 120);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.addUpdateListener(new a(i10));
            valueAnimatorOfFloat.start();
        }
    }
}
