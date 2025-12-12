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
public final class ObservableRepeatWhen<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final n<? super k<Object>, ? extends o<?>> f14126m;

    public static final class RepeatWhenObserver<T> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 802743776666017014L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14127b;

        /* renamed from: o, reason: collision with root package name */
        public final hf.b<Object> f14130o;

        /* renamed from: r, reason: collision with root package name */
        public final o<T> f14133r;

        /* renamed from: s, reason: collision with root package name */
        public volatile boolean f14134s;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicInteger f14128m = new AtomicInteger();

        /* renamed from: n, reason: collision with root package name */
        public final AtomicThrowable f14129n = new AtomicThrowable();

        /* renamed from: p, reason: collision with root package name */
        public final RepeatWhenObserver<T>.InnerRepeatObserver f14131p = new InnerRepeatObserver();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<b> f14132q = new AtomicReference<>();

        public final class InnerRepeatObserver extends AtomicReference<b> implements q<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            public InnerRepeatObserver() {
            }

            @Override // ne.q
            public void onComplete() {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.f14132q);
                f.onComplete(repeatWhenObserver.f14127b, repeatWhenObserver, repeatWhenObserver.f14129n);
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.f14132q);
                f.onError(repeatWhenObserver.f14127b, th2, repeatWhenObserver, repeatWhenObserver.f14129n);
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

        public RepeatWhenObserver(q<? super T> qVar, hf.b<Object> bVar, o<T> oVar) {
            this.f14127b = qVar;
            this.f14130o = bVar;
            this.f14133r = oVar;
        }

        public final void a() {
            if (this.f14128m.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.f14134s) {
                        this.f14134s = true;
                        this.f14133r.subscribe(this);
                    }
                    if (this.f14128m.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14132q);
            DisposableHelper.dispose(this.f14131p);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f14132q.get());
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.replace(this.f14132q, null);
            this.f14134s = false;
            this.f14130o.onNext(0);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14131p);
            f.onError(this.f14127b, th2, this, this.f14129n);
        }

        @Override // ne.q
        public void onNext(T t10) {
            f.onNext(this.f14127b, t10, this, this.f14129n);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14132q, bVar);
        }
    }

    public ObservableRepeatWhen(o<T> oVar, n<? super k<Object>, ? extends o<?>> nVar) {
        super(oVar);
        this.f14126m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        hf.b<T> serialized = PublishSubject.create().toSerialized();
        try {
            o oVar = (o) ue.a.requireNonNull(this.f14126m.apply(serialized), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(qVar, serialized, this.f22058b);
            qVar.onSubscribe(repeatWhenObserver);
            oVar.subscribe(repeatWhenObserver.f14131p);
            repeatWhenObserver.a();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
