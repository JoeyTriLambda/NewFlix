package x0;

import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f21304a;

    public r0(View view) {
        this.f21304a = new WeakReference<>(view);
    }

    public r0 alpha(float f10) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    public void cancel() {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long getDuration() {
        View view = this.f21304a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public r0 setDuration(long j10) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    public r0 setInterpolator(Interpolator interpolator) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public r0 setListener(s0 s0Var) {
        View view = this.f21304a.get();
        if (view != null) {
            if (s0Var != null) {
                view.animate().setListener(new q0(s0Var, view));
            } else {
                view.animate().setListener(null);
            }
        }
        return this;
    }

    public r0 setStartDelay(long j10) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    public r0 setUpdateListener(u0 u0Var) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().setUpdateListener(u0Var != null ? new p0(0, u0Var, view) : null);
        }
        return this;
    }

    public void start() {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public r0 translationY(float f10) {
        View view = this.f21304a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }
}
