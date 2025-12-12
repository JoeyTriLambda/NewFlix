package h7;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f12944b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ float f12945m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ float f12946n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ float f12947o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ float f12948p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ float f12949q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ float f12950r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Matrix f12951s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.floatingactionbutton.d f12952t;

    public a(com.google.android.material.floatingactionbutton.d dVar, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
        this.f12952t = dVar;
        this.f12944b = f10;
        this.f12945m = f11;
        this.f12946n = f12;
        this.f12947o = f13;
        this.f12948p = f14;
        this.f12949q = f15;
        this.f12950r = f16;
        this.f12951s = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        com.google.android.material.floatingactionbutton.d dVar = this.f12952t;
        dVar.f9160q.setAlpha(p6.a.lerp(this.f12944b, this.f12945m, 0.0f, 0.2f, fFloatValue));
        FloatingActionButton floatingActionButton = dVar.f9160q;
        float f10 = this.f12946n;
        float f11 = this.f12947o;
        floatingActionButton.setScaleX(p6.a.lerp(f10, f11, fFloatValue));
        dVar.f9160q.setScaleY(p6.a.lerp(this.f12948p, f11, fFloatValue));
        float f12 = this.f12949q;
        float f13 = this.f12950r;
        dVar.f9154k = p6.a.lerp(f12, f13, fFloatValue);
        float fLerp = p6.a.lerp(f12, f13, fFloatValue);
        Matrix matrix = this.f12951s;
        dVar.a(fLerp, matrix);
        dVar.f9160q.setImageMatrix(matrix);
    }
}
