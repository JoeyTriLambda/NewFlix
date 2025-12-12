package ye;

import ue.a;

/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes2.dex */
public final class x<T, K> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, K> f22460m;

    /* renamed from: n, reason: collision with root package name */
    public final se.d<? super K, ? super K> f22461n;

    /* compiled from: ObservableDistinctUntilChanged.java */
    public static final class a<T, K> extends we.a<T, T> {

        /* renamed from: q, reason: collision with root package name */
        public final se.n<? super T, K> f22462q;

        /* renamed from: r, reason: collision with root package name */
        public final se.d<? super K, ? super K> f22463r;

        /* renamed from: s, reason: collision with root package name */
        public K f22464s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f22465t;

        public a(ne.q<? super T> qVar, se.n<? super T, K> nVar, se.d<? super K, ? super K> dVar) {
            super(qVar);
            this.f22462q = nVar;
            this.f22463r = dVar;
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f21127o) {
                return;
            }
            int i10 = this.f21128p;
            ne.q<? super R> qVar = this.f21124b;
            if (i10 != 0) {
                qVar.onNext(t10);
                return;
            }
            try {
                K kApply = this.f22462q.apply(t10);
                if (this.f22465t) {
                    boolean zTest = ((a.C0288a) this.f22463r).test(this.f22464s, kApply);
                    this.f22464s = kApply;
                    if (zTest) {
                        return;
                    }
                } else {
                    this.f22465t = true;
                    this.f22464s = kApply;
                }
                qVar.onNext(t10);
            } catch (Throwable th2) {
                fail(th2);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f21126n.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f22462q.apply(tPoll);
                if (!this.f22465t) {
                    this.f22465t = true;
                    this.f22464s = kApply;
                    return tPoll;
                }
                if (!((a.C0288a) this.f22463r).test(this.f22464s, kApply)) {
                    this.f22464s = kApply;
                    return tPoll;
                }
                this.f22464s = kApply;
            }
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public x(ne.o<T> oVar, se.n<? super T, K> nVar, se.d<? super K, ? super K> dVar) {
        super(oVar);
        this.f22460m = nVar;
        this.f22461n = dVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22460m, this.f22461n));
    }
}
