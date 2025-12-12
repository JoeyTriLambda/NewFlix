package o2;

import android.animation.Animator;
import o2.d;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d.a f16955b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f16956m;

    public c(d dVar, d.a aVar) {
        this.f16956m = dVar;
        this.f16955b = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        d dVar = this.f16956m;
        d.a aVar = this.f16955b;
        dVar.a(1.0f, aVar, true);
        aVar.f16976k = aVar.f16970e;
        aVar.f16977l = aVar.f16971f;
        aVar.f16978m = aVar.f16972g;
        aVar.a((aVar.f16975j + 1) % aVar.f16974i.length);
        if (!dVar.f16965q) {
            dVar.f16964p += 1.0f;
            return;
        }
        dVar.f16965q = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (aVar.f16979n) {
            aVar.f16979n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f16956m.f16964p = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }
}
