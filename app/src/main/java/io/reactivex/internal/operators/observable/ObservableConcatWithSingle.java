package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.q;
import ne.t;
import ne.u;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableConcatWithSingle<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final u<? extends T> f13846m;

    public static final class ConcatWithObserver<T> extends AtomicReference<b> implements q<T>, t<T>, b {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13847b;

        /* renamed from: m, reason: collision with root package name */
        public u<? extends T> f13848m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13849n;

        public ConcatWithObserver(q<? super T> qVar, u<? extends T> uVar) {
            this.f13847b = qVar;
            this.f13848m = uVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            this.f13849n = true;
            DisposableHelper.replace(this, null);
            u<? extends T> uVar = this.f13848m;
            this.f13848m = null;
            uVar.subscribe(this);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13847b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13847b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.f13849n) {
                return;
            }
            this.f13847b.onSubscribe(this);
        }

        @Override // ne.t
        public void onSuccess(T t10) {
            q<? super T> qVar = this.f13847b;
            qVar.onNext(t10);
            qVar.onComplete();
        }
    }

    public ObservableConcatWithSingle(k<T> kVar, u<? extends T> uVar) {
        super(kVar);
        this.f13846m = uVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new ConcatWithObserver(qVar, this.f13846m));
    }
}
