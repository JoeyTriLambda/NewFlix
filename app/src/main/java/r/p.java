package r;

import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.g0;
import r.n;
import x0.r0;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public final class p implements ContentFrameLayout.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f18322a;

    public p(n nVar) {
        this.f18322a = nVar;
    }

    public void onDetachedFromWindow() {
        androidx.appcompat.view.menu.e eVar;
        n nVar = this.f18322a;
        g0 g0Var = nVar.C;
        if (g0Var != null) {
            g0Var.dismissPopups();
        }
        if (nVar.H != null) {
            nVar.f18281w.getDecorView().removeCallbacks(nVar.I);
            if (nVar.H.isShowing()) {
                try {
                    nVar.H.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            nVar.H = null;
        }
        r0 r0Var = nVar.J;
        if (r0Var != null) {
            r0Var.cancel();
        }
        n.o panelState = nVar.getPanelState(0, false);
        if (panelState == null || (eVar = panelState.f18311h) == null) {
            return;
        }
        eVar.close();
    }

    public void onAttachedFromWindow() {
    }
}
