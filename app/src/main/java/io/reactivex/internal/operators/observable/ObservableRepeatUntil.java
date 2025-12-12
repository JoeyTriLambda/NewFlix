package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.e;

/* loaded from: classes2.dex */
public final class ObservableRepeatUntil<T> extends ye.a<T, T> {

    public static final class RepeatUntilObserver<T> extends AtomicInteger implements q<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14123b;

        /* renamed from: m, reason: collision with root package name */
        public final SequentialDisposable f14124m;

        /* renamed from: n, reason: collision with root package name */
        public final o<? extends T> f14125n;

        public RepeatUntilObserver(q qVar, SequentialDisposable sequentialDisposable, o oVar) {
            this.f14123b = qVar;
            this.f14124m = sequentialDisposable;
            this.f14125n = oVar;
        }

        @Override // ne.q
        public void onComplete() {
            try {
                throw null;
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f14123b.onError(th2);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14123b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14123b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14124m.replace(bVar);
        }
    }

    public ObservableRepeatUntil(k<T> kVar, e eVar) {
        super(kVar);
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        qVar.onSubscribe(sequentialDisposable);
        RepeatUntilObserver repeatUntilObserver = new RepeatUntilObserver(qVar, sequentialDisposable, this.f22058b);
        if (repeatUntilObserver.getAndIncrement() == 0) {
            int iAddAndGet = 1;
            do {
                repeatUntilObserver.f14125n.subscribe(repeatUntilObserver);
                iAddAndGet = repeatUntilObserver.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }
}
