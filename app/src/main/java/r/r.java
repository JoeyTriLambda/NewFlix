package r;

import android.view.View;
import x0.j0;
import x0.t0;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public final class r extends t0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f18325a;

    public r(n nVar) {
        this.f18325a = nVar;
    }

    @Override // x0.s0
    public void onAnimationEnd(View view) {
        n nVar = this.f18325a;
        nVar.G.setAlpha(1.0f);
        nVar.J.setListener(null);
        nVar.J = null;
    }

    @Override // x0.t0, x0.s0
    public void onAnimationStart(View view) {
        n nVar = this.f18325a;
        nVar.G.setVisibility(0);
        if (nVar.G.getParent() instanceof View) {
            j0.requestApplyInsets((View) nVar.G.getParent());
        }
    }
}
