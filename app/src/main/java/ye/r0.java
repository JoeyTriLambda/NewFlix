package ye;

/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes2.dex */
public final class r0<T> extends ne.a implements ve.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22342a;

    public r0(ne.o<T> oVar) {
        this.f22342a = oVar;
    }

    @Override // ve.a
    public ne.k<T> fuseToObservable() {
        return ff.a.onAssembly(new q0(this.f22342a));
    }

    @Override // ne.a
    public void subscribeActual(ne.b bVar) {
        this.f22342a.subscribe(new a(bVar));
    }

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.b f22343b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22344m;

        public a(ne.b bVar) {
            this.f22343b = bVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22344m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22343b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22343b.onError(th2);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f22344m = bVar;
            this.f22343b.onSubscribe(this);
        }

        @Override // ne.q
        public void onNext(T t10) {
        }
    }
}
