package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableRepeat<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f14118m;

    public static final class RepeatObserver<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14119b;

        /* renamed from: m, reason: collision with root package name */
        public final SequentialDisposable f14120m;

        /* renamed from: n, reason: collision with root package name */
        public final o<? extends T> f14121n;

        /* renamed from: o, reason: collision with root package name */
        public long f14122o;

        public RepeatObserver(q<? super T> qVar, long j10, SequentialDisposable sequentialDisposable, o<? extends T> oVar) {
            this.f14119b = qVar;
            this.f14120m = sequentialDisposable;
            this.f14121n = oVar;
            this.f14122o = j10;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f14120m.isDisposed()) {
                    this.f14121n.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // ne.q
        public void onComplete() {
            long j10 = this.f14122o;
            if (j10 != Long.MAX_VALUE) {
                this.f14122o = j10 - 1;
            }
            if (j10 != 0) {
                a();
            } else {
                this.f14119b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14119b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14119b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14120m.replace(bVar);
        }
    }

    public ObservableRepeat(k<T> kVar, long j10) {
        super(kVar);
        this.f14118m = j10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        qVar.onSubscribe(sequentialDisposable);
        long j10 = this.f14118m;
        new RepeatObserver(qVar, j10 != Long.MAX_VALUE ? j10 - 1 : Long.MAX_VALUE, sequentialDisposable, this.f22058b).a();
    }
}
