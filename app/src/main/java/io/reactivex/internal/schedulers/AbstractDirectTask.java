package io.reactivex.internal.schedulers;

import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements qe.b {

    /* renamed from: n, reason: collision with root package name */
    public static final FutureTask<Void> f14509n;

    /* renamed from: o, reason: collision with root package name */
    public static final FutureTask<Void> f14510o;
    private static final long serialVersionUID = 1811839108042568751L;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f14511b;

    /* renamed from: m, reason: collision with root package name */
    public Thread f14512m;

    static {
        Functions.p pVar = Functions.f13539b;
        f14509n = new FutureTask<>(pVar, null);
        f14510o = new FutureTask<>(pVar, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.f14511b = runnable;
    }

    @Override // qe.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f14509n || future == (futureTask = f14510o) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f14512m != Thread.currentThread());
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f14509n) {
                return;
            }
            if (future2 == f14510o) {
                future.cancel(this.f14512m != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
