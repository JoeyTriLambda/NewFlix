package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import ne.r;

/* loaded from: classes2.dex */
public final class ObservableTimeoutTimed<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14366m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f14367n;

    /* renamed from: o, reason: collision with root package name */
    public final r f14368o;

    /* renamed from: p, reason: collision with root package name */
    public final o<? extends T> f14369p;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<qe.b> implements q<T>, qe.b, b {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14370b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14371m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14372n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f14373o;

        /* renamed from: p, reason: collision with root package name */
        public final SequentialDisposable f14374p = new SequentialDisposable();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicLong f14375q = new AtomicLong();

        /* renamed from: r, reason: collision with root package name */
        public final AtomicReference<qe.b> f14376r = new AtomicReference<>();

        /* renamed from: s, reason: collision with root package name */
        public o<? extends T> f14377s;

        public TimeoutFallbackObserver(q<? super T> qVar, long j10, TimeUnit timeUnit, r.c cVar, o<? extends T> oVar) {
            this.f14370b = qVar;
            this.f14371m = j10;
            this.f14372n = timeUnit;
            this.f14373o = cVar;
            this.f14377s = oVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14376r);
            DisposableHelper.dispose(this);
            this.f14373o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14375q.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14374p.dispose();
                this.f14370b.onComplete();
                this.f14373o.dispose();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14375q.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                ff.a.onError(th2);
                return;
            }
            this.f14374p.dispose();
            this.f14370b.onError(th2);
            this.f14373o.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            AtomicLong atomicLong = this.f14375q;
            long j10 = atomicLong.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (atomicLong.compareAndSet(j10, j11)) {
                    SequentialDisposable sequentialDisposable = this.f14374p;
                    sequentialDisposable.get().dispose();
                    this.f14370b.onNext(t10);
                    sequentialDisposable.replace(this.f14373o.schedule(new c(j11, this), this.f14371m, this.f14372n));
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            DisposableHelper.setOnce(this.f14376r, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j10) {
            if (this.f14375q.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f14376r);
                o<? extends T> oVar = this.f14377s;
                this.f14377s = null;
                oVar.subscribe(new a(this.f14370b, this));
                this.f14373o.dispose();
            }
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements q<T>, qe.b, b {
        private static final long serialVersionUID = 3764492702657003550L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14378b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14379m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f14380n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f14381o;

        /* renamed from: p, reason: collision with root package name */
        public final SequentialDisposable f14382p = new SequentialDisposable();

        /* renamed from: q, reason: collision with root package name */
        public final AtomicReference<qe.b> f14383q = new AtomicReference<>();

        public TimeoutObserver(q<? super T> qVar, long j10, TimeUnit timeUnit, r.c cVar) {
            this.f14378b = qVar;
            this.f14379m = j10;
            this.f14380n = timeUnit;
            this.f14381o = cVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14383q);
            this.f14381o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f14382p.dispose();
                this.f14378b.onComplete();
                this.f14381o.dispose();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                ff.a.onError(th2);
                return;
            }
            this.f14382p.dispose();
            this.f14378b.onError(th2);
            this.f14381o.dispose();
        }

        @Override // ne.q
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    SequentialDisposable sequentialDisposable = this.f14382p;
                    sequentialDisposable.get().dispose();
                    this.f14378b.onNext(t10);
                    sequentialDisposable.replace(this.f14381o.schedule(new c(j11, this), this.f14379m, this.f14380n));
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            DisposableHelper.setOnce(this.f14383q, bVar);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void onTimeout(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.f14383q);
                this.f14378b.onError(new TimeoutException(ExceptionHelper.timeoutMessage(this.f14379m, this.f14380n)));
                this.f14381o.dispose();
            }
        }
    }

    public static final class a<T> implements q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14384b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<qe.b> f14385m;

        public a(q<? super T> qVar, AtomicReference<qe.b> atomicReference) {
            this.f14384b = qVar;
            this.f14385m = atomicReference;
        }

        @Override // ne.q
        public void onComplete() {
            this.f14384b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14384b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14384b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            DisposableHelper.replace(this.f14385m, bVar);
        }
    }

    public interface b {
        void onTimeout(long j10);
    }

    public static final class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final b f14386b;

        /* renamed from: m, reason: collision with root package name */
        public final long f14387m;

        public c(long j10, b bVar) {
            this.f14387m = j10;
            this.f14386b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14386b.onTimeout(this.f14387m);
        }
    }

    public ObservableTimeoutTimed(k<T> kVar, long j10, TimeUnit timeUnit, r rVar, o<? extends T> oVar) {
        super(kVar);
        this.f14366m = j10;
        this.f14367n = timeUnit;
        this.f14368o = rVar;
        this.f14369p = oVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        o<? extends T> oVar = this.f14369p;
        o<T> oVar2 = this.f22058b;
        r rVar = this.f14368o;
        if (oVar == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(qVar, this.f14366m, this.f14367n, rVar.createWorker());
            qVar.onSubscribe(timeoutObserver);
            timeoutObserver.f14382p.replace(timeoutObserver.f14381o.schedule(new c(0L, timeoutObserver), timeoutObserver.f14379m, timeoutObserver.f14380n));
            oVar2.subscribe(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(qVar, this.f14366m, this.f14367n, rVar.createWorker(), this.f14369p);
        qVar.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.f14374p.replace(timeoutFallbackObserver.f14373o.schedule(new c(0L, timeoutFallbackObserver), timeoutFallbackObserver.f14371m, timeoutFallbackObserver.f14372n));
        oVar2.subscribe(timeoutFallbackObserver);
    }
}
