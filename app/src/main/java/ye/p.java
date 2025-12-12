package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableCountSingle.java */
/* loaded from: classes2.dex */
public final class p<T> extends ne.s<Long> implements ve.a<Long> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22313a;

    /* compiled from: ObservableCountSingle.java */
    public static final class a implements ne.q<Object>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super Long> f22314b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22315m;

        /* renamed from: n, reason: collision with root package name */
        public long f22316n;

        public a(ne.t<? super Long> tVar) {
            this.f22314b = tVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22315m.dispose();
            this.f22315m = DisposableHelper.f13533b;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22315m = DisposableHelper.f13533b;
            this.f22314b.onSuccess(Long.valueOf(this.f22316n));
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22315m = DisposableHelper.f13533b;
            this.f22314b.onError(th2);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            this.f22316n++;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22315m, bVar)) {
                this.f22315m = bVar;
                this.f22314b.onSubscribe(this);
            }
        }
    }

    public p(ne.o<T> oVar) {
        this.f22313a = oVar;
    }

    @Override // ve.a
    public ne.k<Long> fuseToObservable() {
        return ff.a.onAssembly(new o(this.f22313a));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super Long> tVar) {
        this.f22313a.subscribe(new a(tVar));
    }
}
