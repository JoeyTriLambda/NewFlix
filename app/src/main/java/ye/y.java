package ye;

/* compiled from: ObservableDoAfterNext.java */
/* loaded from: classes2.dex */
public final class y<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.f<? super T> f22513m;

    /* compiled from: ObservableDoAfterNext.java */
    public static final class a<T> extends we.a<T, T> {

        /* renamed from: q, reason: collision with root package name */
        public final se.f<? super T> f22514q;

        public a(ne.q<? super T> qVar, se.f<? super T> fVar) {
            super(qVar);
            this.f22514q = fVar;
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f21124b.onNext(t10);
            if (this.f21128p == 0) {
                try {
                    this.f22514q.accept(t10);
                } catch (Throwable th2) {
                    fail(th2);
                }
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            T tPoll = this.f21126n.poll();
            if (tPoll != null) {
                this.f22514q.accept(tPoll);
            }
            return tPoll;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public y(ne.o<T> oVar, se.f<? super T> fVar) {
        super(oVar);
        this.f22513m = fVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22513m));
    }
}
