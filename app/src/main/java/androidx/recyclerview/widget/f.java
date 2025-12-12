package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.z f4154b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f4155m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f4156n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4157o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f4158p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ c f4159q;

    public f(c cVar, RecyclerView.z zVar, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
        this.f4159q = cVar;
        this.f4154b = zVar;
        this.f4155m = i10;
        this.f4156n = view;
        this.f4157o = i11;
        this.f4158p = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        int i10 = this.f4155m;
        View view = this.f4156n;
        if (i10 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f4157o != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f4158p.setListener(null);
        c cVar = this.f4159q;
        RecyclerView.z zVar = this.f4154b;
        cVar.dispatchMoveFinished(zVar);
        cVar.f4126p.remove(zVar);
        cVar.c();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f4159q.dispatchMoveStarting(this.f4154b);
    }
}
