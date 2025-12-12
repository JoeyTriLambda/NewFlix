package bf;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ne.r;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes2.dex */
public final class g extends r {

    /* renamed from: b, reason: collision with root package name */
    public static final g f4917b = new g();

    /* compiled from: TrampolineScheduler.java */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f4918b;

        /* renamed from: m, reason: collision with root package name */
        public final c f4919m;

        /* renamed from: n, reason: collision with root package name */
        public final long f4920n;

        public a(Runnable runnable, c cVar, long j10) {
            this.f4918b = runnable;
            this.f4919m = cVar;
            this.f4920n = j10;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            if (this.f4919m.f4928o) {
                return;
            }
            long jNow = this.f4919m.now(TimeUnit.MILLISECONDS);
            long j10 = this.f4920n;
            if (j10 > jNow) {
                try {
                    Thread.sleep(j10 - jNow);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    ff.a.onError(e10);
                    return;
                }
            }
            if (this.f4919m.f4928o) {
                return;
            }
            this.f4918b.run();
        }
    }

    /* compiled from: TrampolineScheduler.java */
    public static final class b implements Comparable<b> {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f4921b;

        /* renamed from: m, reason: collision with root package name */
        public final long f4922m;

        /* renamed from: n, reason: collision with root package name */
        public final int f4923n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f4924o;

        public b(Runnable runnable, Long l10, int i10) {
            this.f4921b = runnable;
            this.f4922m = l10.longValue();
            this.f4923n = i10;
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            int iCompare = ue.a.compare(this.f4922m, bVar.f4922m);
            return iCompare == 0 ? ue.a.compare(this.f4923n, bVar.f4923n) : iCompare;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    public static final class c extends r.c {

        /* renamed from: b, reason: collision with root package name */
        public final PriorityBlockingQueue<b> f4925b = new PriorityBlockingQueue<>();

        /* renamed from: m, reason: collision with root package name */
        public final AtomicInteger f4926m = new AtomicInteger();

        /* renamed from: n, reason: collision with root package name */
        public final AtomicInteger f4927n = new AtomicInteger();

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f4928o;

        /* compiled from: TrampolineScheduler.java */
        public final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final b f4929b;

            public a(b bVar) {
                this.f4929b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4929b.f4924o = true;
                c.this.f4925b.remove(this.f4929b);
            }
        }

        public final qe.b a(Runnable runnable, long j10) {
            boolean z10 = this.f4928o;
            EmptyDisposable emptyDisposable = EmptyDisposable.INSTANCE;
            if (z10) {
                return emptyDisposable;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f4927n.incrementAndGet());
            this.f4925b.add(bVar);
            if (this.f4926m.getAndIncrement() != 0) {
                return io.reactivex.disposables.a.fromRunnable(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f4928o) {
                b bVarPoll = this.f4925b.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.f4926m.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return emptyDisposable;
                    }
                } else if (!bVarPoll.f4924o) {
                    bVarPoll.f4921b.run();
                }
            }
            this.f4925b.clear();
            return emptyDisposable;
        }

        @Override // qe.b
        public void dispose() {
            this.f4928o = true;
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable) {
            return a(runnable, now(TimeUnit.MILLISECONDS));
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j10) + now(TimeUnit.MILLISECONDS);
            return a(new a(runnable, this, millis), millis);
        }
    }

    public static g instance() {
        return f4917b;
    }

    @Override // ne.r
    public r.c createWorker() {
        return new c();
    }

    @Override // ne.r
    public qe.b scheduleDirect(Runnable runnable) {
        ff.a.onSchedule(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // ne.r
    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) throws InterruptedException {
        try {
            timeUnit.sleep(j10);
            ff.a.onSchedule(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            ff.a.onError(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}
