package ye;

/* compiled from: ObservableIgnoreElements.java */
/* loaded from: classes2.dex */
public final class q0<T> extends ye.a<T, T> {
    public q0(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }

    /* compiled from: ObservableIgnoreElements.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22336b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22337m;

        public a(ne.q<? super T> qVar) {
            this.f22336b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22337m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22336b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22336b.onError(th2);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f22337m = bVar;
            this.f22336b.onSubscribe(this);
        }

        @Override // ne.q
        public void onNext(T t10) {
        }
    }
}
