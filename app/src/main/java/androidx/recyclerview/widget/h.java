package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class h extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.d f4164b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4165m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f4166n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f4167o;

    public h(c cVar, c.d dVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f4167o = cVar;
        this.f4164b = dVar;
        this.f4165m = viewPropertyAnimator;
        this.f4166n = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4165m.setListener(null);
        View view = this.f4166n;
        view.setAlpha(1.0f);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        c.d dVar = this.f4164b;
        RecyclerView.z zVar = dVar.f4136b;
        c cVar = this.f4167o;
        cVar.dispatchChangeFinished(zVar, false);
        cVar.f4128r.remove(dVar.f4136b);
        cVar.c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4167o.dispatchChangeStarting(this.f4164b.f4136b, false);
    }
}
