package bf;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.r;

/* compiled from: IoScheduler.java */
/* loaded from: classes2.dex */
public final class c extends r {

    /* renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f4892d;

    /* renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f4893e;

    /* renamed from: h, reason: collision with root package name */
    public static final C0059c f4896h;

    /* renamed from: i, reason: collision with root package name */
    public static final a f4897i;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f4898b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference<a> f4899c;

    /* renamed from: g, reason: collision with root package name */
    public static final TimeUnit f4895g = TimeUnit.SECONDS;

    /* renamed from: f, reason: collision with root package name */
    public static final long f4894f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* compiled from: IoScheduler.java */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final long f4900b;

        /* renamed from: m, reason: collision with root package name */
        public final ConcurrentLinkedQueue<C0059c> f4901m;

        /* renamed from: n, reason: collision with root package name */
        public final qe.a f4902n;

        /* renamed from: o, reason: collision with root package name */
        public final ScheduledExecutorService f4903o;

        /* renamed from: p, reason: collision with root package name */
        public final ScheduledFuture f4904p;

        /* renamed from: q, reason: collision with root package name */
        public final ThreadFactory f4905q;

        public a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f4900b = nanos;
            this.f4901m = new ConcurrentLinkedQueue<>();
            this.f4902n = new qe.a();
            this.f4905q = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, c.f4893e);
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            this.f4903o = scheduledExecutorServiceNewScheduledThreadPool;
            this.f4904p = scheduledFutureScheduleWithFixedDelay;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentLinkedQueue<C0059c> concurrentLinkedQueue = this.f4901m;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            long jNanoTime = System.nanoTime();
            Iterator<C0059c> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                C0059c next = it.next();
                if (next.getExpirationTime() > jNanoTime) {
                    return;
                }
                if (concurrentLinkedQueue.remove(next)) {
                    this.f4902n.remove(next);
                }
            }
        }
    }

    /* compiled from: IoScheduler.java */
    public static final class b extends r.c {

        /* renamed from: m, reason: collision with root package name */
        public final a f4907m;

        /* renamed from: n, reason: collision with root package name */
        public final C0059c f4908n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicBoolean f4909o = new AtomicBoolean();

        /* renamed from: b, reason: collision with root package name */
        public final qe.a f4906b = new qe.a();

        public b(a aVar) {
            C0059c c0059c;
            C0059c c0059c2;
            this.f4907m = aVar;
            qe.a aVar2 = aVar.f4902n;
            if (aVar2.isDisposed()) {
                c0059c2 = c.f4896h;
            } else {
                while (true) {
                    ConcurrentLinkedQueue<C0059c> concurrentLinkedQueue = aVar.f4901m;
                    if (concurrentLinkedQueue.isEmpty()) {
                        c0059c = new C0059c(aVar.f4905q);
                        aVar2.add(c0059c);
                        break;
                    } else {
                        c0059c = concurrentLinkedQueue.poll();
                        if (c0059c != null) {
                            break;
                        }
                    }
                }
                c0059c2 = c0059c;
            }
            this.f4908n = c0059c2;
        }

        @Override // qe.b
        public void dispose() {
            if (this.f4909o.compareAndSet(false, true)) {
                this.f4906b.dispose();
                a aVar = this.f4907m;
                aVar.getClass();
                long jNanoTime = System.nanoTime() + aVar.f4900b;
                C0059c c0059c = this.f4908n;
                c0059c.setExpirationTime(jNanoTime);
                aVar.f4901m.offer(c0059c);
            }
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f4906b.isDisposed() ? EmptyDisposable.INSTANCE : this.f4908n.scheduleActual(runnable, j10, timeUnit, this.f4906b);
        }
    }

    /* compiled from: IoScheduler.java */
    /* renamed from: bf.c$c, reason: collision with other inner class name */
    public static final class C0059c extends io.reactivex.internal.schedulers.a {

        /* renamed from: n, reason: collision with root package name */
        public long f4910n;

        public C0059c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f4910n = 0L;
        }

        public long getExpirationTime() {
            return this.f4910n;
        }

        public void setExpirationTime(long j10) {
            this.f4910n = j10;
        }
    }

    static {
        C0059c c0059c = new C0059c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f4896h = c0059c;
        c0059c.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f4892d = rxThreadFactory;
        f4893e = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        a aVar = new a(0L, null, rxThreadFactory);
        f4897i = aVar;
        aVar.f4902n.dispose();
        ScheduledFuture scheduledFuture = aVar.f4904p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = aVar.f4903o;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public c() {
        this(f4892d);
    }

    @Override // ne.r
    public r.c createWorker() {
        return new b(this.f4899c.get());
    }

    public void start() {
        boolean z10;
        a aVar = new a(f4894f, f4895g, this.f4898b);
        AtomicReference<a> atomicReference = this.f4899c;
        while (true) {
            a aVar2 = f4897i;
            if (atomicReference.compareAndSet(aVar2, aVar)) {
                z10 = true;
                break;
            } else if (atomicReference.get() != aVar2) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return;
        }
        aVar.f4902n.dispose();
        ScheduledFuture scheduledFuture = aVar.f4904p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledExecutorService scheduledExecutorService = aVar.f4903o;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
        }
    }

    public c(ThreadFactory threadFactory) {
        this.f4898b = threadFactory;
        this.f4899c = new AtomicReference<>(f4897i);
        start();
    }
}
