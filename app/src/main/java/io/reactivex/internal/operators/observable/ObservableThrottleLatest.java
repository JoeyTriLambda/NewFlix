package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableThrottleLatest<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14335m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14336n;

    /* renamed from: o, reason: collision with root package name */
    public final r f14337o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f14338p;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements q<T>, b, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14339b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14340m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14341n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f14342o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f14343p;

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<T> f14344q = new AtomicReference<>();

        /* renamed from: r, reason: collision with root package name */
        public b f14345r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14346s;

        /* renamed from: t, reason: collision with root package name */
        public Throwable f14347t;

        /* renamed from: u, reason: collision with root package name */
        public volatile boolean f14348u;

        /* renamed from: v, reason: collision with root package name */
        public volatile boolean f14349v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f14350w;

        public ThrottleLatestObserver(q<? super T> qVar, long j10, TimeUnit timeUnit, r.c cVar, boolean z10) {
            this.f14339b = qVar;
            this.f14340m = j10;
            this.f14341n = timeUnit;
            this.f14342o = cVar;
            this.f14343p = z10;
        }

        public final void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.f14344q;
            q<? super T> qVar = this.f14339b;
            int iAddAndGet = 1;
            while (!this.f14348u) {
                boolean z10 = this.f14346s;
                if (z10 && this.f14347t != null) {
                    atomicReference.lazySet(null);
                    qVar.onError(this.f14347t);
                    this.f14342o.dispose();
                    return;
                }
                boolean z11 = atomicReference.get() == null;
                if (z10) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z11 && this.f14343p) {
                        qVar.onNext(andSet);
                    }
                    qVar.onComplete();
                    this.f14342o.dispose();
                    return;
                }
                if (z11) {
                    if (this.f14349v) {
                        this.f14350w = false;
                        this.f14349v = false;
                    }
                } else if (!this.f14350w || this.f14349v) {
                    qVar.onNext(atomicReference.getAndSet(null));
                    this.f14349v = false;
                    this.f14350w = true;
                    this.f14342o.schedule(this, this.f14340m, this.f14341n);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // qe.b
        public void dispose() {
            this.f14348u = true;
            this.f14345r.dispose();
            this.f14342o.dispose();
            if (getAndIncrement() == 0) {
                this.f14344q.lazySet(null);
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14346s = true;
            a();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14347t = th2;
            this.f14346s = true;
            a();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14344q.set(t10);
            a();
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14345r, bVar)) {
                this.f14345r = bVar;
                this.f14339b.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14349v = true;
            a();
        }
    }

    public ObservableThrottleLatest(k<T> kVar, long j10, TimeUnit timeUnit, r rVar, boolean z10) {
        super(kVar);
        this.f14335m = j10;
        this.f14336n = timeUnit;
        this.f14337o = rVar;
        this.f14338p = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new ThrottleLatestObserver(qVar, this.f14335m, this.f14336n, this.f14337o.createWorker(), this.f14338p));
    }
}
