package ye;

/* compiled from: ObservableFilter.java */
/* loaded from: classes2.dex */
public final class g0<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22153m;

    /* compiled from: ObservableFilter.java */
    public static final class a<T> extends we.a<T, T> {

        /* renamed from: q, reason: collision with root package name */
        public final se.o<? super T> f22154q;

        public a(ne.q<? super T> qVar, se.o<? super T> oVar) {
            super(qVar);
            this.f22154q = oVar;
        }

        @Override // ne.q
        public void onNext(T t10) {
            int i10 = this.f21128p;
            ne.q<? super R> qVar = this.f21124b;
            if (i10 != 0) {
                qVar.onNext(null);
                return;
            }
            try {
                if (this.f22154q.test(t10)) {
                    qVar.onNext(t10);
                }
            } catch (Throwable th2) {
                fail(th2);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f21126n.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f22154q.test(tPoll));
            return tPoll;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public g0(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22153m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22153m));
    }
}
