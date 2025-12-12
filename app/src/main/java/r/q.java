package r;

import android.view.View;
import android.view.ViewGroup;
import x0.j0;
import x0.r0;
import x0.t0;

/* compiled from: AppCompatDelegateImpl.java */
/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f18323b;

    /* compiled from: AppCompatDelegateImpl.java */
    public class a extends t0 {
        public a() {
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            q qVar = q.this;
            qVar.f18323b.G.setAlpha(1.0f);
            qVar.f18323b.J.setListener(null);
            qVar.f18323b.J = null;
        }

        @Override // x0.t0, x0.s0
        public void onAnimationStart(View view) {
            q.this.f18323b.G.setVisibility(0);
        }
    }

    public q(n nVar) {
        this.f18323b = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewGroup viewGroup;
        n nVar = this.f18323b;
        nVar.H.showAtLocation(nVar.G, 55, 0, 0);
        r0 r0Var = nVar.J;
        if (r0Var != null) {
            r0Var.cancel();
        }
        if (!(nVar.L && (viewGroup = nVar.M) != null && j0.isLaidOut(viewGroup))) {
            nVar.G.setAlpha(1.0f);
            nVar.G.setVisibility(0);
        } else {
            nVar.G.setAlpha(0.0f);
            r0 r0VarAlpha = j0.animate(nVar.G).alpha(1.0f);
            nVar.J = r0VarAlpha;
            r0VarAlpha.setListener(new a());
        }
    }
}
