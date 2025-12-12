package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableTimeout<T, U, V> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final o<U> f14351m;

    /* renamed from: n, reason: collision with root package name */
    public final n<? super T, ? extends o<V>> f14352n;

    /* renamed from: o, reason: collision with root package name */
    public final o<? extends T> f14353o;

    public static final class TimeoutConsumer extends AtomicReference<b> implements q<Object>, b {
        private static final long serialVersionUID = 8708641127342403073L;

        /* renamed from: b, reason: collision with root package name */
        public final a f14354b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14355m;

        public TimeoutConsumer(long j10, a aVar) {
            this.f14355m = j10;
            this.f14354b = aVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f14354b.onTimeout(this.f14355m);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (obj == disposableHelper) {
                ff.a.onError(th2);
            } else {
                lazySet(disposableHelper);
                this.f14354b.onTimeoutError(this.f14355m, th2);
            }
        }

        @Override // ne.q
        public void onNext(Object obj) {
            b bVar = (b) get();
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar != disposableHelper) {
                bVar.dispose();
                lazySet(disposableHelper);
                this.f14354b.onTimeout(this.f14355m);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<b> implements q<T>, b, a {
        private static final long serialVersionUID = -7508389464265974549L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14356b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<?>> f14357m;

        /* renamed from: n, reason: collision with root package name */
        public final SequentialDisposable f14358n = new SequentialDisposable();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicLong f14359o = new AtomicLong();

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<b> f14360p = new AtomicReference<>();

        /* renamed from: q, reason: collision with root package name */
        public o<? extends T> f14361q;

        public TimeoutFallbackObserver(o oVar, q qVar, n nVar) {
            this.f14356b = qVar;
            this.f14357m = nVar;
            this.f14361q = oVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14360p);
            DisposableHelper.dispose(this);
            this.f14358n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14359o.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                SequentialDisposable sequentialDisposable = this.f14358n;
                sequentialDisposable.dispose();
                this.f14356b.onComplete();
                sequentialDisposable.dispose();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14359o.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                ff.a.onError(th2);
                return;
            }
            SequentialDisposable sequentialDisposable = this.f14358n;
            sequentialDisposable.dispose();
            this.f14356b.onError(th2);
            sequentialDisposable.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            AtomicLong atomicLong = this.f14359o;
            long j10 = atomicLong.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (atomicLong.compareAndSet(j10, j11)) {
                    SequentialDisposable sequentialDisposable = this.f14358n;
                    b bVar = sequentialDisposable.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    q<? super T> qVar = this.f14356b;
                    qVar.onNext(t10);
                    try {
                        o oVar = (o) ue.a.requireNonNull(this.f14357m.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (sequentialDisposable.replace(timeoutConsumer)) {
                            oVar.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f14360p.get().dispose();
                        atomicLong.getAndSet(Long.MAX_VALUE);
                        qVar.onError(th2);
                    }
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14360p, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j10) {
            if (this.f14359o.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f14360p);
                o<? extends T> oVar = this.f14361q;
                this.f14361q = null;
                oVar.subscribe(new ObservableTimeoutTimed.a(this.f14356b, this));
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j10, Throwable th2) {
            if (!this.f14359o.compareAndSet(j10, Long.MAX_VALUE)) {
                ff.a.onError(th2);
            } else {
                DisposableHelper.dispose(this);
                this.f14356b.onError(th2);
            }
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements q<T>, b, a {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14362b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<?>> f14363m;

        /* renamed from: n, reason: collision with root package name */
        public final SequentialDisposable f14364n = new SequentialDisposable();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<b> f14365o = new AtomicReference<>();

        public TimeoutObserver(q<? super T> qVar, n<? super T, ? extends o<?>> nVar) {
            this.f14362b = qVar;
            this.f14363m = nVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14365o);
            this.f14364n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14364n.dispose();
                this.f14362b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                ff.a.onError(th2);
            } else {
                this.f14364n.dispose();
                this.f14362b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    SequentialDisposable sequentialDisposable = this.f14364n;
                    b bVar = sequentialDisposable.get();
                    if (bVar != null) {
                        bVar.dispose();
                    }
                    q<? super T> qVar = this.f14362b;
                    qVar.onNext(t10);
                    try {
                        o oVar = (o) ue.a.requireNonNull(this.f14363m.apply(t10), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j11, this);
                        if (sequentialDisposable.replace(timeoutConsumer)) {
                            oVar.subscribe(timeoutConsumer);
                        }
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f14365o.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        qVar.onError(th2);
                    }
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14365o, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f14365o);
                this.f14362b.onError(new TimeoutException());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.a
        public void onTimeoutError(long j10, Throwable th2) {
            if (!compareAndSet(j10, Long.MAX_VALUE)) {
                ff.a.onError(th2);
            } else {
                DisposableHelper.dispose(this.f14365o);
                this.f14362b.onError(th2);
            }
        }
    }

    public interface a extends ObservableTimeoutTimed.b {
        void onTimeoutError(long j10, Throwable th2);
    }

    public ObservableTimeout(k<T> kVar, o<U> oVar, n<? super T, ? extends o<V>> nVar, o<? extends T> oVar2) {
        super(kVar);
        this.f14351m = oVar;
        this.f14352n = nVar;
        this.f14353o = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        o<T> oVar = this.f22058b;
        o<U> oVar2 = this.f14351m;
        n<? super T, ? extends o<V>> nVar = this.f14352n;
        o<? extends T> oVar3 = this.f14353o;
        if (oVar3 == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(qVar, nVar);
            qVar.onSubscribe(timeoutObserver);
            if (oVar2 != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, timeoutObserver);
                if (timeoutObserver.f14364n.replace(timeoutConsumer)) {
                    oVar2.subscribe(timeoutConsumer);
                }
            }
            oVar.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(oVar3, qVar, nVar);
        qVar.onSubscribe(timeoutFallbackObserver);
        if (oVar2 != null) {
            TimeoutConsumer timeoutConsumer2 = new TimeoutConsumer(0L, timeoutFallbackObserver);
            if (timeoutFallbackObserver.f14358n.replace(timeoutConsumer2)) {
                oVar2.subscribe(timeoutConsumer2);
            }
        }
        oVar.subscribe(timeoutFallbackObserver);
    }
}
