package ye;

/* compiled from: ObservableMap.java */
/* loaded from: classes2.dex */
public final class w0<T, U> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, ? extends U> f22440m;

    /* compiled from: ObservableMap.java */
    public static final class a<T, U> extends we.a<T, U> {

        /* renamed from: q, reason: collision with root package name */
        public final se.n<? super T, ? extends U> f22441q;

        public a(ne.q<? super U> qVar, se.n<? super T, ? extends U> nVar) {
            super(qVar);
            this.f22441q = nVar;
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f21127o) {
                return;
            }
            int i10 = this.f21128p;
            ne.q<? super R> qVar = this.f21124b;
            if (i10 != 0) {
                qVar.onNext(null);
                return;
            }
            try {
                qVar.onNext(ue.a.requireNonNull(this.f22441q.apply(t10), "The mapper function returned a null value."));
            } catch (Throwable th2) {
                fail(th2);
            }
        }

        @Override // ve.f
        public U poll() throws Exception {
            T tPoll = this.f21126n.poll();
            if (tPoll != null) {
                return (U) ue.a.requireNonNull(this.f22441q.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public w0(ne.o<T> oVar, se.n<? super T, ? extends U> nVar) {
        super(oVar);
        this.f22440m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22440m));
    }
}
