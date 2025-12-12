package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableTakeLast<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final int f14298m;

    public static final class TakeLastObserver<T> extends ArrayDeque<T> implements q<T>, b {
        private static final long serialVersionUID = 7240042530241604978L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14299b;

        /* renamed from: m, reason: collision with root package name */
        public final int f14300m;

        /* renamed from: n, reason: collision with root package name */
        public b f14301n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f14302o;

        public TakeLastObserver(q<? super T> qVar, int i10) {
            this.f14299b = qVar;
            this.f14300m = i10;
        }

        @Override // qe.b
        public void dispose() {
            if (this.f14302o) {
                return;
            }
            this.f14302o = true;
            this.f14301n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            q<? super T> qVar = this.f14299b;
            while (!this.f14302o) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.f14302o) {
                        return;
                    }
                    qVar.onComplete();
                    return;
                }
                qVar.onNext(tPoll);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14299b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14300m == size()) {
                poll();
            }
            offer(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14301n, bVar)) {
                this.f14301n = bVar;
                this.f14299b.onSubscribe(this);
            }
        }
    }

    public ObservableTakeLast(o<T> oVar, int i10) {
        super(oVar);
        this.f14298m = i10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new TakeLastObserver(qVar, this.f14298m));
    }
}
