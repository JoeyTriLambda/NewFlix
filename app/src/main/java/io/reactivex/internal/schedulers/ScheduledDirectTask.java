package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        FutureTask<Void> futureTask = AbstractDirectTask.f14509n;
        this.f14512m = Thread.currentThread();
        try {
            this.f14511b.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.f14512m = null;
        }
    }
}
