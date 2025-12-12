package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.q;
import qe.b;
import se.o;

/* loaded from: classes2.dex */
public final class ObservableRetryPredicate<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final o<? super Throwable> f14178m;

    /* renamed from: n, reason: collision with root package name */
    public final long f14179n;

    public static final class RepeatObserver<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14180b;

        /* renamed from: m, reason: collision with root package name */
        public final SequentialDisposable f14181m;

        /* renamed from: n, reason: collision with root package name */
        public final ne.o<? extends T> f14182n;

        /* renamed from: o, reason: collision with root package name */
        public final o<? super Throwable> f14183o;

        /* renamed from: p, reason: collision with root package name */
        public long f14184p;

        public RepeatObserver(q<? super T> qVar, long j10, o<? super Throwable> oVar, SequentialDisposable sequentialDisposable, ne.o<? extends T> oVar2) {
            this.f14180b = qVar;
            this.f14181m = sequentialDisposable;
            this.f14182n = oVar2;
            this.f14183o = oVar;
            this.f14184p = j10;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f14181m.isDisposed()) {
                    this.f14182n.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14180b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            long j10 = this.f14184p;
            if (j10 != Long.MAX_VALUE) {
                this.f14184p = j10 - 1;
            }
            q<? super T> qVar = this.f14180b;
            if (j10 == 0) {
                qVar.onError(th2);
                return;
            }
            try {
                if (this.f14183o.test(th2)) {
                    a();
                } else {
                    qVar.onError(th2);
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                qVar.onError(new CompositeException(th2, th3));
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14180b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14181m.replace(bVar);
        }
    }

    public ObservableRetryPredicate(k<T> kVar, long j10, o<? super Throwable> oVar) {
        super(kVar);
        this.f14178m = oVar;
        this.f14179n = j10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        qVar.onSubscribe(sequentialDisposable);
        new RepeatObserver(qVar, this.f14179n, this.f14178m, sequentialDisposable, this.f22058b).a();
    }
}
