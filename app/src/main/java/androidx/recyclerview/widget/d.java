package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.z f4146b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4147m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f4148n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f4149o;

    public d(View view, ViewPropertyAnimator viewPropertyAnimator, c cVar, RecyclerView.z zVar) {
        this.f4149o = cVar;
        this.f4146b = zVar;
        this.f4147m = viewPropertyAnimator;
        this.f4148n = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4147m.setListener(null);
        this.f4148n.setAlpha(1.0f);
        c cVar = this.f4149o;
        RecyclerView.z zVar = this.f4146b;
        cVar.dispatchRemoveFinished(zVar);
        cVar.f4127q.remove(zVar);
        cVar.c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4149o.dispatchRemoveStarting(this.f4146b);
    }
}
