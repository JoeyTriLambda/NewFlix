package io.reactivex.internal.operators.observable;

import cf.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableRetryWhen<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super k<Throwable>, ? extends o<?>> f14185m;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14186b;

        /* renamed from: o, reason: collision with root package name */
        public final hf.b<Throwable> f14189o;

        /* renamed from: r, reason: collision with root package name */
        public final o<T> f14192r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14193s;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicInteger f14187m = new AtomicInteger();

        /* renamed from: n, reason: collision with root package name */
        public final AtomicThrowable f14188n = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final RepeatWhenObserver<T>.InnerRepeatObserver f14190p = new InnerRepeatObserver();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<b> f14191q = new AtomicReference<>();

        public final class InnerRepeatObserver extends AtomicReference<b> implements q<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // ne.q
            public void onComplete() {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.f14191q);
                f.onComplete(repeatWhenObserver.f14186b, repeatWhenObserver, repeatWhenObserver.f14188n);
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.f14191q);
                f.onError(repeatWhenObserver.f14186b, th2, repeatWhenObserver, repeatWhenObserver.f14188n);
            }

            @Override // ne.q
            public void onNext(Object obj) {
                RepeatWhenObserver.this.a();
            }

            @Override // ne.q
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public RepeatWhenObserver(q<? super T> qVar, hf.b<Throwable> bVar, o<T> oVar) {
            this.f14186b = qVar;
            this.f14189o = bVar;
            this.f14192r = oVar;
        }

        public final void a() {
            if (this.f14187m.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f14193s) {
                        this.f14193s = true;
                        this.f14192r.subscribe(this);
                    }
                    if (this.f14187m.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14191q);
            DisposableHelper.dispose(this.f14190p);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f14191q.get());
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this.f14190p);
            f.onComplete(this.f14186b, this, this.f14188n);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.replace(this.f14191q, null);
            this.f14193s = false;
            this.f14189o.onNext(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            f.onNext(this.f14186b, t10, this, this.f14188n);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.replace(this.f14191q, bVar);
        }
    }

    public ObservableRetryWhen(o<T> oVar, n<? super k<Throwable>, ? extends o<?>> nVar) {
        super(oVar);
        this.f14185m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        hf.b<T> serialized = PublishSubject.create().toSerialized();
        try {
            o oVar = (o) ue.a.requireNonNull(this.f14185m.apply(serialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(qVar, serialized, this.f22058b);
            qVar.onSubscribe(repeatWhenObserver);
            oVar.subscribe(repeatWhenObserver.f14190p);
            repeatWhenObserver.a();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
