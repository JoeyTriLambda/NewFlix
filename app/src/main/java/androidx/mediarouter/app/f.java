package androidx.mediarouter.app;

import a2.n;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import java.util.Set;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class f implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3626b;

    public f(h hVar) {
        this.f3626b = hVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        h hVar = this.f3626b;
        hVar.R.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        Set<n.g> set = hVar.U;
        if (set == null || set.size() == 0) {
            hVar.g(true);
            return;
        }
        g gVar = new g(hVar);
        int firstVisiblePosition = hVar.R.getFirstVisiblePosition();
        boolean z10 = false;
        for (int i10 = 0; i10 < hVar.R.getChildCount(); i10++) {
            View childAt = hVar.R.getChildAt(i10);
            if (hVar.U.contains(hVar.S.getItem(firstVisiblePosition + i10))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(hVar.f3654v0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z10) {
                    alphaAnimation.setAnimationListener(gVar);
                    z10 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }
}
