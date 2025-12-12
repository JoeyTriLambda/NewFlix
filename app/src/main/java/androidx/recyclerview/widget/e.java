package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.z f4150b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f4151m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4152n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f4153o;

    public e(View view, ViewPropertyAnimator viewPropertyAnimator, c cVar, RecyclerView.z zVar) {
        this.f4153o = cVar;
        this.f4150b = zVar;
        this.f4151m = view;
        this.f4152n = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f4151m.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4152n.setListener(null);
        c cVar = this.f4153o;
        RecyclerView.z zVar = this.f4150b;
        cVar.dispatchAddFinished(zVar);
        cVar.f4125o.remove(zVar);
        cVar.c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4153o.dispatchAddStarting(this.f4150b);
    }
}
