package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.c;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableConcatWithCompletable<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final c f13838m;

    public static final class ConcatWithObserver<T> extends AtomicReference<b> implements q<T>, ne.b, b {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13839b;

        /* renamed from: m, reason: collision with root package name */
        public c f13840m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13841n;

        public ConcatWithObserver(q<? super T> qVar, c cVar) {
            this.f13839b = qVar;
            this.f13840m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f13841n) {
                this.f13839b.onComplete();
                return;
            }
            this.f13841n = true;
            DisposableHelper.replace(this, null);
            c cVar = this.f13840m;
            this.f13840m = null;
            cVar.subscribe(this);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13839b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13839b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.f13841n) {
                return;
            }
            this.f13839b.onSubscribe(this);
        }
    }

    public ObservableConcatWithCompletable(k<T> kVar, c cVar) {
        super(kVar);
        this.f13838m = cVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new ConcatWithObserver(qVar, this.f13838m));
    }
}
