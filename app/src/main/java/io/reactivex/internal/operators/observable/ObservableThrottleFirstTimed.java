package io.reactivex.internal.operators.observable;

import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableThrottleFirstTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14325m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14326n;

    /* renamed from: o, reason: collision with root package name */
    public final r f14327o;

    public static final class DebounceTimedObserver<T> extends AtomicReference<b> implements q<T>, b, Runnable {
        private static final long serialVersionUID = 786994795061867455L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14328b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14329m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14330n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f14331o;

        /* renamed from: p, reason: collision with root package name */
        public b f14332p;

        /* renamed from: q, reason: collision with root package name */
        public volatile boolean f14333q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f14334r;

        public DebounceTimedObserver(e eVar, long j10, TimeUnit timeUnit, r.c cVar) {
            this.f14328b = eVar;
            this.f14329m = j10;
            this.f14330n = timeUnit;
            this.f14331o = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f14332p.dispose();
            this.f14331o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14334r) {
                return;
            }
            this.f14334r = true;
            this.f14328b.onComplete();
            this.f14331o.dispose();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14334r) {
                ff.a.onError(th2);
                return;
            }
            this.f14334r = true;
            this.f14328b.onError(th2);
            this.f14331o.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14333q || this.f14334r) {
                return;
            }
            this.f14333q = true;
            this.f14328b.onNext(t10);
            b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            DisposableHelper.replace(this, this.f14331o.schedule(this, this.f14329m, this.f14330n));
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14332p, bVar)) {
                this.f14332p = bVar;
                this.f14328b.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14333q = false;
        }
    }

    public ObservableThrottleFirstTimed(o<T> oVar, long j10, TimeUnit timeUnit, r rVar) {
        super(oVar);
        this.f14325m = j10;
        this.f14326n = timeUnit;
        this.f14327o = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new DebounceTimedObserver(new e(qVar), this.f14325m, this.f14326n, this.f14327o.createWorker()));
    }
}
