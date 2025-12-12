package bf;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.r;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes2.dex */
public final class a extends r {

    /* renamed from: d, reason: collision with root package name */
    public static final b f4872d;

    /* renamed from: e, reason: collision with root package name */
    public static final RxThreadFactory f4873e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f4874f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f4875g;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f4876b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference<b> f4877c;

    /* compiled from: ComputationScheduler.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4883a;

        /* renamed from: b, reason: collision with root package name */
        public final c[] f4884b;

        /* renamed from: c, reason: collision with root package name */
        public long f4885c;

        public b(ThreadFactory threadFactory, int i10) {
            this.f4883a = i10;
            this.f4884b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f4884b[i11] = new c(threadFactory);
            }
        }

        public c getEventLoop() {
            int i10 = this.f4883a;
            if (i10 == 0) {
                return a.f4875g;
            }
            long j10 = this.f4885c;
            this.f4885c = 1 + j10;
            return this.f4884b[(int) (j10 % i10)];
        }

        public void shutdown() {
            for (c cVar : this.f4884b) {
                cVar.dispose();
            }
        }
    }

    /* compiled from: ComputationScheduler.java */
    public static final class c extends io.reactivex.internal.schedulers.a {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        int iIntValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (iIntValue > 0 && iIntValue <= iAvailableProcessors) {
            iAvailableProcessors = iIntValue;
        }
        f4874f = iAvailableProcessors;
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f4875g = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f4873e = rxThreadFactory;
        b bVar = new b(rxThreadFactory, 0);
        f4872d = bVar;
        bVar.shutdown();
    }

    public a() {
        this(f4873e);
    }

    @Override // ne.r
    public r.c createWorker() {
        return new C0058a(this.f4877c.get().getEventLoop());
    }

    @Override // ne.r
    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f4877c.get().getEventLoop().scheduleDirect(runnable, j10, timeUnit);
    }

    @Override // ne.r
    public qe.b schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f4877c.get().getEventLoop().schedulePeriodicallyDirect(runnable, j10, j11, timeUnit);
    }

    public void start() {
        boolean z10;
        b bVar = new b(this.f4876b, f4874f);
        AtomicReference<b> atomicReference = this.f4877c;
        while (true) {
            b bVar2 = f4872d;
            if (atomicReference.compareAndSet(bVar2, bVar)) {
                z10 = true;
                break;
            } else if (atomicReference.get() != bVar2) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return;
        }
        bVar.shutdown();
    }

    public a(ThreadFactory threadFactory) {
        this.f4876b = threadFactory;
        this.f4877c = new AtomicReference<>(f4872d);
        start();
    }

    /* compiled from: ComputationScheduler.java */
    /* renamed from: bf.a$a, reason: collision with other inner class name */
    public static final class C0058a extends r.c {

        /* renamed from: b, reason: collision with root package name */
        public final te.b f4878b;

        /* renamed from: m, reason: collision with root package name */
        public final qe.a f4879m;

        /* renamed from: n, reason: collision with root package name */
        public final te.b f4880n;

        /* renamed from: o, reason: collision with root package name */
        public final c f4881o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f4882p;

        public C0058a(c cVar) {
            this.f4881o = cVar;
            te.b bVar = new te.b();
            this.f4878b = bVar;
            qe.a aVar = new qe.a();
            this.f4879m = aVar;
            te.b bVar2 = new te.b();
            this.f4880n = bVar2;
            bVar2.add(bVar);
            bVar2.add(aVar);
        }

        @Override // qe.b
        public void dispose() {
            if (this.f4882p) {
                return;
            }
            this.f4882p = true;
            this.f4880n.dispose();
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable) {
            return this.f4882p ? EmptyDisposable.INSTANCE : this.f4881o.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.f4878b);
        }

        @Override // ne.r.c
        public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f4882p) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f4881o.scheduleActual(runnable, j10, timeUnit, this.f4879m);
        }
    }
}
