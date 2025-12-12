package io.reactivex.internal.schedulers;

import bf.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ne.r;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes2.dex */
public class a extends r.c {

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f14521b;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f14522m;

    public a(ThreadFactory threadFactory) {
        this.f14521b = f.create(threadFactory);
    }

    @Override // qe.b
    public void dispose() {
        if (this.f14522m) {
            return;
        }
        this.f14522m = true;
        this.f14521b.shutdownNow();
    }

    @Override // ne.r.c
    public qe.b schedule(Runnable runnable) {
        return schedule(runnable, 0L, null);
    }

    public ScheduledRunnable scheduleActual(Runnable runnable, long j10, TimeUnit timeUnit, te.a aVar) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(ff.a.onSchedule(runnable), aVar);
        if (aVar != null && !aVar.add(scheduledRunnable)) {
            return scheduledRunnable;
        }
        ScheduledExecutorService scheduledExecutorService = this.f14521b;
        try {
            scheduledRunnable.setFuture(j10 <= 0 ? scheduledExecutorService.submit((Callable) scheduledRunnable) : scheduledExecutorService.schedule((Callable) scheduledRunnable, j10, timeUnit));
        } catch (RejectedExecutionException e10) {
            if (aVar != null) {
                aVar.remove(scheduledRunnable);
            }
            ff.a.onError(e10);
        }
        return scheduledRunnable;
    }

    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(ff.a.onSchedule(runnable));
        ScheduledExecutorService scheduledExecutorService = this.f14521b;
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? scheduledExecutorService.submit(scheduledDirectTask) : scheduledExecutorService.schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            ff.a.onError(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    public qe.b schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = ff.a.onSchedule(runnable);
        EmptyDisposable emptyDisposable = EmptyDisposable.INSTANCE;
        if (j11 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableOnSchedule);
            try {
                scheduledDirectPeriodicTask.setFuture(this.f14521b.scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e10) {
                ff.a.onError(e10);
                return emptyDisposable;
            }
        }
        ScheduledExecutorService scheduledExecutorService = this.f14521b;
        bf.b bVar = new bf.b(runnableOnSchedule, scheduledExecutorService);
        try {
            bVar.a(j10 <= 0 ? scheduledExecutorService.submit(bVar) : scheduledExecutorService.schedule(bVar, j10, timeUnit));
            return bVar;
        } catch (RejectedExecutionException e11) {
            ff.a.onError(e11);
            return emptyDisposable;
        }
    }

    public void shutdown() {
        if (this.f14522m) {
            return;
        }
        this.f14522m = true;
        this.f14521b.shutdown();
    }

    @Override // ne.r.c
    public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f14522m ? EmptyDisposable.INSTANCE : scheduleActual(runnable, j10, timeUnit, null);
    }
}
