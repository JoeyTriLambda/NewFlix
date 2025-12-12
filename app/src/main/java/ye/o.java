package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableCount.java */
/* loaded from: classes2.dex */
public final class o<T> extends ye.a<T, Long> {

    /* compiled from: ObservableCount.java */
    public static final class a implements ne.q<Object>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super Long> f22296b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22297m;

        /* renamed from: n, reason: collision with root package name */
        public long f22298n;

        public a(ne.q<? super Long> qVar) {
            this.f22296b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22297m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            Long lValueOf = Long.valueOf(this.f22298n);
            ne.q<? super Long> qVar = this.f22296b;
            qVar.onNext(lValueOf);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22296b.onError(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            this.f22298n++;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22297m, bVar)) {
                this.f22297m = bVar;
                this.f22296b.onSubscribe(this);
            }
        }
    }

    public o(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super Long> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }
}
