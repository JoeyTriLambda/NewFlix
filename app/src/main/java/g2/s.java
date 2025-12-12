package g2;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import r.x;

/* compiled from: TransactionExecutor.kt */
/* loaded from: classes.dex */
public final class s implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f12630b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayDeque<Runnable> f12631m;

    /* renamed from: n, reason: collision with root package name */
    public Runnable f12632n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f12633o;

    public s(Executor executor) {
        zf.i.checkNotNullParameter(executor, "executor");
        this.f12630b = executor;
        this.f12631m = new ArrayDeque<>();
        this.f12633o = new Object();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        zf.i.checkNotNullParameter(runnable, "command");
        synchronized (this.f12633o) {
            this.f12631m.offer(new x(runnable, this));
            if (this.f12632n == null) {
                scheduleNext();
            }
            lf.h hVar = lf.h.f16056a;
        }
    }

    public final void scheduleNext() {
        synchronized (this.f12633o) {
            Runnable runnablePoll = this.f12631m.poll();
            Runnable runnable = runnablePoll;
            this.f12632n = runnable;
            if (runnablePoll != null) {
                this.f12630b.execute(runnable);
            }
            lf.h hVar = lf.h.f16056a;
        }
    }
}
