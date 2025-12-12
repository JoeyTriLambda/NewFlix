package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import ne.r;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableSubscribeOn<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final r f14274m;

    public static final class SubscribeOnObserver<T> extends AtomicReference<b> implements q<T>, b {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14275b;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<b> f14276m = new AtomicReference<>();

        public SubscribeOnObserver(q<? super T> qVar) {
            this.f14275b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14276m);
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            this.f14275b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14275b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14275b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14276m, bVar);
        }
    }

    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final SubscribeOnObserver<T> f14277b;

        public a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f14277b = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f22058b.subscribe(this.f14277b);
        }
    }

    public ObservableSubscribeOn(o<T> oVar, r rVar) {
        super(oVar);
        this.f14274m = rVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(qVar);
        qVar.onSubscribe(subscribeOnObserver);
        DisposableHelper.setOnce(subscribeOnObserver, this.f14274m.scheduleDirect(new a(subscribeOnObserver)));
    }
}
