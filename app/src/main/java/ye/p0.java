package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableHide.java */
/* loaded from: classes2.dex */
public final class p0<T> extends ye.a<T, T> {

    /* compiled from: ObservableHide.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22317b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22318m;

        public a(ne.q<? super T> qVar) {
            this.f22317b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22318m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22317b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22317b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22317b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22318m, bVar)) {
                this.f22318m = bVar;
                this.f22317b.onSubscribe(this);
            }
        }
    }

    public p0(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }
}
