package x2;

import android.os.Handler;
import android.os.Looper;

/* compiled from: DefaultRunnableScheduler.java */
/* loaded from: classes.dex */
public final class d implements w2.l {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f21391a = t0.g.createAsync(Looper.getMainLooper());

    public void cancel(Runnable runnable) {
        this.f21391a.removeCallbacks(runnable);
    }

    public void scheduleWithDelay(long j10, Runnable runnable) {
        this.f21391a.postDelayed(runnable, j10);
    }
}
