package s6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;

/* compiled from: BottomAppBar.java */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: b, reason: collision with root package name */
    public boolean f19105b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f19106m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f19107n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f19108o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f19109p;

    public c(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i10, boolean z10) {
        this.f19109p = bottomAppBar;
        this.f19106m = actionMenuView;
        this.f19107n = i10;
        this.f19108o = z10;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f19105b = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f19105b) {
            return;
        }
        BottomAppBar bottomAppBar = this.f19109p;
        int i10 = bottomAppBar.f8819r0;
        boolean z10 = i10 != 0;
        bottomAppBar.replaceMenu(i10);
        bottomAppBar.y(this.f19106m, this.f19107n, this.f19108o, z10);
    }
}
