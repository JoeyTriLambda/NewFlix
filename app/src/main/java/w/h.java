package w;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import x0.r0;
import x0.s0;
import x0.t0;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f20835c;

    /* renamed from: d, reason: collision with root package name */
    public s0 f20836d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20837e;

    /* renamed from: b, reason: collision with root package name */
    public long f20834b = -1;

    /* renamed from: f, reason: collision with root package name */
    public final a f20838f = new a();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<r0> f20833a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    public class a extends t0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20839a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f20840b = 0;

        public a() {
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            int i10 = this.f20840b + 1;
            this.f20840b = i10;
            h hVar = h.this;
            if (i10 == hVar.f20833a.size()) {
                s0 s0Var = hVar.f20836d;
                if (s0Var != null) {
                    s0Var.onAnimationEnd(null);
                }
                this.f20840b = 0;
                this.f20839a = false;
                hVar.f20837e = false;
            }
        }

        @Override // x0.t0, x0.s0
        public void onAnimationStart(View view) {
            if (this.f20839a) {
                return;
            }
            this.f20839a = true;
            s0 s0Var = h.this.f20836d;
            if (s0Var != null) {
                s0Var.onAnimationStart(null);
            }
        }
    }

    public void cancel() {
        if (this.f20837e) {
            Iterator<r0> it = this.f20833a.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f20837e = false;
        }
    }

    public h play(r0 r0Var) {
        if (!this.f20837e) {
            this.f20833a.add(r0Var);
        }
        return this;
    }

    public h playSequentially(r0 r0Var, r0 r0Var2) {
        ArrayList<r0> arrayList = this.f20833a;
        arrayList.add(r0Var);
        r0Var2.setStartDelay(r0Var.getDuration());
        arrayList.add(r0Var2);
        return this;
    }

    public h setDuration(long j10) {
        if (!this.f20837e) {
            this.f20834b = j10;
        }
        return this;
    }

    public h setInterpolator(Interpolator interpolator) {
        if (!this.f20837e) {
            this.f20835c = interpolator;
        }
        return this;
    }

    public h setListener(s0 s0Var) {
        if (!this.f20837e) {
            this.f20836d = s0Var;
        }
        return this;
    }

    public void start() {
        if (this.f20837e) {
            return;
        }
        Iterator<r0> it = this.f20833a.iterator();
        while (it.hasNext()) {
            r0 next = it.next();
            long j10 = this.f20834b;
            if (j10 >= 0) {
                next.setDuration(j10);
            }
            Interpolator interpolator = this.f20835c;
            if (interpolator != null) {
                next.setInterpolator(interpolator);
            }
            if (this.f20836d != null) {
                next.setListener(this.f20838f);
            }
            next.start();
        }
        this.f20837e = true;
    }
}
