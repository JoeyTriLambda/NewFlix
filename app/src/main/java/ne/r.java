package ne;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final long f16810a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: Scheduler.java */
    public static final class a implements qe.b, Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f16811b;

        /* renamed from: m, reason: collision with root package name */
        public final c f16812m;

        /* renamed from: n, reason: collision with root package name */
        public Thread f16813n;

        public a(Runnable runnable, c cVar) {
            this.f16811b = runnable;
            this.f16812m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            Thread thread = this.f16813n;
            Thread threadCurrentThread = Thread.currentThread();
            c cVar = this.f16812m;
            if (thread == threadCurrentThread && (cVar instanceof io.reactivex.internal.schedulers.a)) {
                ((io.reactivex.internal.schedulers.a) cVar).shutdown();
            } else {
                cVar.dispose();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16813n = Thread.currentThread();
            try {
                this.f16811b.run();
            } finally {
                dispose();
                this.f16813n = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    public static final class b implements qe.b, Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f16814b;

        /* renamed from: m, reason: collision with root package name */
        public final c f16815m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f16816n;

        public b(Runnable runnable, c cVar) {
            this.f16814b = runnable;
            this.f16815m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f16816n = true;
            this.f16815m.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f16816n) {
                return;
            }
            try {
                this.f16814b.run();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f16815m.dispose();
                throw ExceptionHelper.wrapOrThrow(th2);
            }
        }
    }

    /* compiled from: Scheduler.java */
    public static abstract class c implements qe.b {

        /* compiled from: Scheduler.java */
        public final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final Runnable f16817b;

            /* renamed from: m, reason: collision with root package name */
            public final SequentialDisposable f16818m;

            /* renamed from: n, reason: collision with root package name */
            public final long f16819n;

            /* renamed from: o, reason: collision with root package name */
            public long f16820o;

            /* renamed from: p, reason: collision with root package name */
            public long f16821p;

            /* renamed from: q, reason: collision with root package name */
            public long f16822q;

            public a(long j10, Runnable runnable, long j11, SequentialDisposable sequentialDisposable, long j12) {
                this.f16817b = runnable;
                this.f16818m = sequentialDisposable;
                this.f16819n = j12;
                this.f16821p = j11;
                this.f16822q = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j10;
                this.f16817b.run();
                SequentialDisposable sequentialDisposable = this.f16818m;
                if (sequentialDisposable.isDisposed()) {
                    return;
                }
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                c cVar = c.this;
                long jNow = cVar.now(timeUnit);
                long j11 = r.f16810a;
                long j12 = jNow + j11;
                long j13 = this.f16821p;
                long j14 = this.f16819n;
                if (j12 < j13 || jNow >= j13 + j14 + j11) {
                    j10 = jNow + j14;
                    long j15 = this.f16820o + 1;
                    this.f16820o = j15;
                    this.f16822q = j10 - (j14 * j15);
                } else {
                    long j16 = this.f16822q;
                    long j17 = this.f16820o + 1;
                    this.f16820o = j17;
                    j10 = (j17 * j14) + j16;
                }
                this.f16821p = jNow;
                sequentialDisposable.replace(cVar.schedule(this, j10 - jNow, timeUnit));
            }
        }

        public long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public qe.b schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit);

        public qe.b schedulePeriodically(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableOnSchedule = ff.a.onSchedule(runnable);
            long nanos = timeUnit.toNanos(j11);
            long jNow = now(TimeUnit.NANOSECONDS);
            qe.b bVarSchedule = schedule(new a(timeUnit.toNanos(j10) + jNow, runnableOnSchedule, jNow, sequentialDisposable2, nanos), j10, timeUnit);
            if (bVarSchedule == EmptyDisposable.INSTANCE) {
                return bVarSchedule;
            }
            sequentialDisposable.replace(bVarSchedule);
            return sequentialDisposable2;
        }
    }

    public abstract c createWorker();

    public long now(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public qe.b scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public qe.b schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c cVarCreateWorker = createWorker();
        b bVar = new b(ff.a.onSchedule(runnable), cVarCreateWorker);
        qe.b bVarSchedulePeriodically = cVarCreateWorker.schedulePeriodically(bVar, j10, j11, timeUnit);
        return bVarSchedulePeriodically == EmptyDisposable.INSTANCE ? bVarSchedulePeriodically : bVar;
    }

    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        c cVarCreateWorker = createWorker();
        a aVar = new a(ff.a.onSchedule(runnable), cVarCreateWorker);
        cVarCreateWorker.schedule(aVar, j10, timeUnit);
        return aVar;
    }
}
