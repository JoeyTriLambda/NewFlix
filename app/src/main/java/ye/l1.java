package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkip.java */
/* loaded from: classes2.dex */
public final class l1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22258m;

    /* compiled from: ObservableSkip.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22259b;

        /* renamed from: m, reason: collision with root package name */
        public long f22260m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22261n;

        public a(ne.q<? super T> qVar, long j10) {
            this.f22259b = qVar;
            this.f22260m = j10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22261n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22259b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22259b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            long j10 = this.f22260m;
            if (j10 != 0) {
                this.f22260m = j10 - 1;
            } else {
                this.f22259b.onNext(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22261n, bVar)) {
                this.f22261n = bVar;
                this.f22259b.onSubscribe(this);
            }
        }
    }

    public l1(ne.o<T> oVar, long j10) {
        super(oVar);
        this.f22258m = j10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22258m));
    }
}
