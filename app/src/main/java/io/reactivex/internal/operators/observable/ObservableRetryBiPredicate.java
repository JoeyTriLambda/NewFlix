package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.d;
import ue.a;

/* loaded from: classes2.dex */
public final class ObservableRetryBiPredicate<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final d<? super Integer, ? super Throwable> f14172m;

    public static final class RetryBiObserver<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14173b;

        /* renamed from: m, reason: collision with root package name */
        public final SequentialDisposable f14174m;

        /* renamed from: n, reason: collision with root package name */
        public final o<? extends T> f14175n;

        /* renamed from: o, reason: collision with root package name */
        public final d<? super Integer, ? super Throwable> f14176o;

        /* renamed from: p, reason: collision with root package name */
        public int f14177p;

        public RetryBiObserver(q<? super T> qVar, d<? super Integer, ? super Throwable> dVar, SequentialDisposable sequentialDisposable, o<? extends T> oVar) {
            this.f14173b = qVar;
            this.f14174m = sequentialDisposable;
            this.f14175n = oVar;
            this.f14176o = dVar;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f14174m.isDisposed()) {
                    this.f14175n.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            this.f14173b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            q<? super T> qVar = this.f14173b;
            try {
                d<? super Integer, ? super Throwable> dVar = this.f14176o;
                int i10 = this.f14177p + 1;
                this.f14177p = i10;
                if (((a.C0288a) dVar).test(Integer.valueOf(i10), th2)) {
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
            this.f14173b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14174m.replace(bVar);
        }
    }

    public ObservableRetryBiPredicate(k<T> kVar, d<? super Integer, ? super Throwable> dVar) {
        super(kVar);
        this.f14172m = dVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        qVar.onSubscribe(sequentialDisposable);
        new RetryBiObserver(qVar, this.f14172m, sequentialDisposable, this.f22058b).a();
    }
}
