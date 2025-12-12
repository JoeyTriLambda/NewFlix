package ye;

import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* compiled from: ObservableFromPublisher.java */
/* loaded from: classes2.dex */
public final class m0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final zh.a<? extends T> f22269b;

    /* compiled from: ObservableFromPublisher.java */
    public static final class a<T> implements ne.f<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22270b;

        /* renamed from: m, reason: collision with root package name */
        public zh.c f22271m;

        public a(ne.q<? super T> qVar) {
            this.f22270b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22271m.cancel();
            this.f22271m = SubscriptionHelper.f14534b;
        }

        @Override // zh.b
        public void onComplete() {
            this.f22270b.onComplete();
        }

        @Override // zh.b
        public void onError(Throwable th2) {
            this.f22270b.onError(th2);
        }

        @Override // zh.b
        public void onNext(T t10) {
            this.f22270b.onNext(t10);
        }

        @Override // zh.b
        public void onSubscribe(zh.c cVar) {
            if (SubscriptionHelper.validate(this.f22271m, cVar)) {
                this.f22271m = cVar;
                this.f22270b.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public m0(zh.a<? extends T> aVar) {
        this.f22269b = aVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        ((ne.e) this.f22269b).subscribe((zh.b) new a(qVar));
    }
}
