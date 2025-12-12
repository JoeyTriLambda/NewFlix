package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.h;
import ne.i;
import ne.k;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableConcatWithMaybe<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final i<? extends T> f13842m;

    public static final class ConcatWithObserver<T> extends AtomicReference<b> implements q<T>, h<T>, b {
        private static final long serialVersionUID = -1953724749712440952L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13843b;

        /* renamed from: m, reason: collision with root package name */
        public i<? extends T> f13844m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f13845n;

        public ConcatWithObserver(q<? super T> qVar, i<? extends T> iVar) {
            this.f13843b = qVar;
            this.f13844m = iVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f13845n) {
                this.f13843b.onComplete();
                return;
            }
            this.f13845n = true;
            DisposableHelper.replace(this, null);
            i<? extends T> iVar = this.f13844m;
            this.f13844m = null;
            iVar.subscribe(this);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f13843b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f13843b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.f13845n) {
                return;
            }
            this.f13843b.onSubscribe(this);
        }

        @Override // ne.h
        public void onSuccess(T t10) {
            q<? super T> qVar = this.f13843b;
            qVar.onNext(t10);
            qVar.onComplete();
        }
    }

    public ObservableConcatWithMaybe(k<T> kVar, i<? extends T> iVar) {
        super(kVar);
        this.f13842m = iVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new ConcatWithObserver(qVar, this.f13842m));
    }
}
