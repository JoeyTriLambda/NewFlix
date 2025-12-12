package o2;

import android.animation.ValueAnimator;
import o2.d;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f16953b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f16954m;

    public b(d dVar, d.a aVar) {
        this.f16954m = dVar;
        this.f16953b = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d dVar = this.f16954m;
        dVar.getClass();
        d.a aVar = this.f16953b;
        d.c(fFloatValue, aVar);
        dVar.a(fFloatValue, aVar, false);
        dVar.invalidateSelf();
    }
}
