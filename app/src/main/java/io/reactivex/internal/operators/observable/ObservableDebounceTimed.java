package io.reactivex.internal.operators.observable;

import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableDebounceTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f13851m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f13852n;

    /* renamed from: o, reason: collision with root package name */
    public final r f13853o;

    public static final class DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
        private static final long serialVersionUID = 6812032969491025141L;

        /* renamed from: b, reason: collision with root package name */
        public final T f13854b;

        /* renamed from: m, reason: collision with root package name */
        public final long f13855m;

        /* renamed from: n, reason: collision with root package name */
        public final a<T> f13856n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicBoolean f13857o = new AtomicBoolean();

        public DebounceEmitter(T t10, long j10, a<T> aVar) {
            this.f13854b = t10;
            this.f13855m = j10;
            this.f13856n = aVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13857o.compareAndSet(false, true)) {
                a<T> aVar = this.f13856n;
                long j10 = this.f13855m;
                T t10 = this.f13854b;
                if (j10 == aVar.f13864r) {
                    aVar.f13858b.onNext(t10);
                    dispose();
                }
            }
        }

        public void setResource(b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    public static final class a<T> implements q<T>, b {

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13858b;

        /* renamed from: m, reason: collision with root package name */
        public final long f13859m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f13860n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f13861o;

        /* renamed from: p, reason: collision with root package name */
        public b f13862p;

        /* renamed from: q, reason: collision with root package name */
        public b f13863q;

        /* renamed from: r, reason: collision with root package name */
        public volatile long f13864r;

        /* renamed from: s, reason: collision with root package name */
        public boolean f13865s;

        public a(e eVar, long j10, TimeUnit timeUnit, r.c cVar) {
            this.f13858b = eVar;
            this.f13859m = j10;
            this.f13860n = timeUnit;
            this.f13861o = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f13862p.dispose();
            this.f13861o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f13865s) {
                return;
            }
            this.f13865s = true;
            b bVar = this.f13863q;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f13858b.onComplete();
            this.f13861o.dispose();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f13865s) {
                ff.a.onError(th2);
                return;
            }
            b bVar = this.f13863q;
            if (bVar != null) {
                bVar.dispose();
            }
            this.f13865s = true;
            this.f13858b.onError(th2);
            this.f13861o.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f13865s) {
                return;
            }
            long j10 = this.f13864r + 1;
            this.f13864r = j10;
            b bVar = this.f13863q;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t10, j10, this);
            this.f13863q = debounceEmitter;
            debounceEmitter.setResource(this.f13861o.schedule(debounceEmitter, this.f13859m, this.f13860n));
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f13862p, bVar)) {
                this.f13862p = bVar;
                this.f13858b.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(o<T> oVar, long j10, TimeUnit timeUnit, r rVar) {
        super(oVar);
        this.f13851m = j10;
        this.f13852n = timeUnit;
        this.f13853o = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new a(new e(qVar), this.f13851m, this.f13852n, this.f13853o.createWorker()));
    }
}
