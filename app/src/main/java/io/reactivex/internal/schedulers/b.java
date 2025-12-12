package io.reactivex.internal.schedulers;

import bf.f;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.r;

/* compiled from: SingleScheduler.java */
/* loaded from: classes2.dex */
public final class b extends r {

    /* renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f14523c;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f14524b;

    /* compiled from: SingleScheduler.java */
    public static final class a extends r.c {

        /* renamed from: b, reason: collision with root package name */
        public final ScheduledExecutorService f14525b;

        /* renamed from: m, reason: collision with root package name */
        public final qe.a f14526m = new qe.a();

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f14527n;

        public a(ScheduledExecutorService scheduledExecutorService) {
            this.f14525b = scheduledExecutorService;
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14527n) {
                return;
            }
            this.f14527n = true;
            this.f14526m.dispose();
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            boolean z10 = this.f14527n;
            EmptyDisposable emptyDisposable = EmptyDisposable.INSTANCE;
            if (z10) {
                return emptyDisposable;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(ff.a.onSchedule(runnable), this.f14526m);
            this.f14526m.add(scheduledRunnable);
            try {
                scheduledRunnable.setFuture(j10 <= 0 ? this.f14525b.submit((Callable) scheduledRunnable) : this.f14525b.schedule((Callable) scheduledRunnable, j10, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e10) {
                dispose();
                ff.a.onError(e10);
                return emptyDisposable;
            }
        }
    }

    static {
        Executors.newScheduledThreadPool(0).shutdown();
        f14523c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public b() {
        this(f14523c);
    }

    @Override // ne.r
    public r.c createWorker() {
        return new a(this.f14524b.get());
    }

    @Override // ne.r
    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(ff.a.onSchedule(runnable));
        AtomicReference<ScheduledExecutorService> atomicReference = this.f14524b;
        try {
            scheduledDirectTask.setFuture(j10 <= 0 ? atomicReference.get().submit(scheduledDirectTask) : atomicReference.get().schedule(scheduledDirectTask, j10, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e10) {
            ff.a.onError(e10);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // ne.r
    public qe.b schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        Runnable runnableOnSchedule = ff.a.onSchedule(runnable);
        EmptyDisposable emptyDisposable = EmptyDisposable.INSTANCE;
        AtomicReference<ScheduledExecutorService> atomicReference = this.f14524b;
        if (j11 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableOnSchedule);
            try {
                scheduledDirectPeriodicTask.setFuture(atomicReference.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j10, j11, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e10) {
                ff.a.onError(e10);
                return emptyDisposable;
            }
        }
        ScheduledExecutorService scheduledExecutorService = atomicReference.get();
        bf.b bVar = new bf.b(runnableOnSchedule, scheduledExecutorService);
        try {
            bVar.a(j10 <= 0 ? scheduledExecutorService.submit(bVar) : scheduledExecutorService.schedule(bVar, j10, timeUnit));
            return bVar;
        } catch (RejectedExecutionException e11) {
            ff.a.onError(e11);
            return emptyDisposable;
        }
    }

    public b(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f14524b = atomicReference;
        atomicReference.lazySet(f.create(threadFactory));
    }
}
