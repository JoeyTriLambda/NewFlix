package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.d f4160b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4161m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f4162n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f4163o;

    public g(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4163o = cVar;
        this.f4160b = dVar;
        this.f4161m = viewPropertyAnimator;
        this.f4162n = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4161m.setListener(null);
        View view = this.f4162n;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c.d dVar = this.f4160b;
        RecyclerView.z zVar = dVar.f4135a;
        c cVar = this.f4163o;
        cVar.dispatchChangeFinished(zVar, true);
        cVar.f4128r.remove(dVar.f4135a);
        cVar.c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4163o.dispatchChangeStarting(this.f4160b.f4135a, true);
    }
}
