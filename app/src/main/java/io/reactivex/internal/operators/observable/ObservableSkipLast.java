package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableSkipLast<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final int f14255m;

    public static final class SkipLastObserver<T> extends ArrayDeque<T> implements q<T>, b {
        private static final long serialVersionUID = -3807491841935125653L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14256b;

        /* renamed from: m, reason: collision with root package name */
        public final int f14257m;

        /* renamed from: n, reason: collision with root package name */
        public b f14258n;

        public SkipLastObserver(q<? super T> qVar, int i10) {
            super(i10);
            this.f14256b = qVar;
            this.f14257m = i10;
        }

        @Override // qe.b
        public void dispose() {
            this.f14258n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f14256b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14256b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14257m == size()) {
                this.f14256b.onNext(poll());
            }
            offer(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14258n, bVar)) {
                this.f14258n = bVar;
                this.f14256b.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLast(o<T> oVar, int i10) {
        super(oVar);
        this.f14255m = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new SkipLastObserver(qVar, this.f14255m));
    }
}
