package bf;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes2.dex */
public final class b implements Callable<Void>, qe.b {

    /* renamed from: q, reason: collision with root package name */
    public static final FutureTask<Void> f4886q = new FutureTask<>(Functions.f13539b, null);

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f4887b;

    /* renamed from: o, reason: collision with root package name */
    public final ExecutorService f4890o;

    /* renamed from: p, reason: collision with root package name */
    public Thread f4891p;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference<Future<?>> f4889n = new AtomicReference<>();

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<Future<?>> f4888m = new AtomicReference<>();

    public b(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.f4887b = runnable;
        this.f4890o = scheduledExecutorService;
    }

    public final void a(Future<?> future) {
        boolean z10;
        do {
            AtomicReference<Future<?>> atomicReference = this.f4889n;
            Future<?> future2 = atomicReference.get();
            if (future2 == f4886q) {
                future.cancel(this.f4891p != Thread.currentThread());
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(future2, future)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != future2) {
                    break;
                }
            }
        } while (!z10);
    }

    @Override // qe.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.f4889n;
        FutureTask<Void> futureTask = f4886q;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.f4891p != Thread.currentThread());
        }
        Future<?> andSet2 = this.f4888m.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.f4891p != Thread.currentThread());
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f4891p = Thread.currentThread();
        try {
            this.f4887b.run();
            Future<?> futureSubmit = this.f4890o.submit(this);
            while (true) {
                AtomicReference<Future<?>> atomicReference = this.f4888m;
                Future<?> future = atomicReference.get();
                boolean z10 = true;
                if (future == f4886q) {
                    if (this.f4891p == Thread.currentThread()) {
                        z10 = false;
                    }
                    futureSubmit.cancel(z10);
                } else {
                    while (true) {
                        if (atomicReference.compareAndSet(future, futureSubmit)) {
                            break;
                        }
                        if (atomicReference.get() != future) {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        break;
                    }
                }
            }
            this.f4891p = null;
        } catch (Throwable th2) {
            this.f4891p = null;
            ff.a.onError(th2);
        }
        return null;
    }
}
