package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeUntilPredicate.java */
/* loaded from: classes2.dex */
public final class r1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22345m;

    /* compiled from: ObservableTakeUntilPredicate.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22346b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22347m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22348n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22349o;

        public a(ne.q<? super T> qVar, se.o<? super T> oVar) {
            this.f22346b = qVar;
            this.f22347m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22348n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22349o) {
                return;
            }
            this.f22349o = true;
            this.f22346b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22349o) {
                ff.a.onError(th2);
            } else {
                this.f22349o = true;
                this.f22346b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22349o) {
                return;
            }
            ne.q<? super T> qVar = this.f22346b;
            qVar.onNext(t10);
            try {
                if (this.f22347m.test(t10)) {
                    this.f22349o = true;
                    this.f22348n.dispose();
                    qVar.onComplete();
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22348n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22348n, bVar)) {
                this.f22348n = bVar;
                this.f22346b.onSubscribe(this);
            }
        }
    }

    public r1(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22345m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22345m));
    }
}
