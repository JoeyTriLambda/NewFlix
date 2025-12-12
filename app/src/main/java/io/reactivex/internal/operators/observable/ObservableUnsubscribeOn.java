package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableUnsubscribeOn<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final r f14392m;

    public static final class UnsubscribeObserver<T> extends AtomicBoolean implements q<T>, b {
        private static final long serialVersionUID = 1015244841293359600L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14393b;

        /* renamed from: m, reason: collision with root package name */
        public final r f14394m;

        /* renamed from: n, reason: collision with root package name */
        public b f14395n;

        public final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.f14395n.dispose();
            }
        }

        public UnsubscribeObserver(q<? super T> qVar, r rVar) {
            this.f14393b = qVar;
            this.f14394m = rVar;
        }

        @Override // qe.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f14394m.scheduleDirect(new a());
            }
        }

        @Override // ne.q
        public void onComplete() {
            if (get()) {
                return;
            }
            this.f14393b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (get()) {
                ff.a.onError(th2);
            } else {
                this.f14393b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (get()) {
                return;
            }
            this.f14393b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14395n, bVar)) {
                this.f14395n = bVar;
                this.f14393b.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(o<T> oVar, r rVar) {
        super(oVar);
        this.f14392m = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f22058b.subscribe(new UnsubscribeObserver(qVar, this.f14392m));
    }
}
