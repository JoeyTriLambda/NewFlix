package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableScan.java */
/* loaded from: classes2.dex */
public final class g1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.c<T, T, T> f22155m;

    /* compiled from: ObservableScan.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22156b;

        /* renamed from: m, reason: collision with root package name */
        public final se.c<T, T, T> f22157m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22158n;

        /* renamed from: o, reason: collision with root package name */
        public T f22159o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22160p;

        public a(ne.q<? super T> qVar, se.c<T, T, T> cVar) {
            this.f22156b = qVar;
            this.f22157m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22158n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22160p) {
                return;
            }
            this.f22160p = true;
            this.f22156b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22160p) {
                ff.a.onError(th2);
            } else {
                this.f22160p = true;
                this.f22156b.onError(th2);
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22160p) {
                return;
            }
            T t11 = this.f22159o;
            ne.q<? super T> qVar = this.f22156b;
            if (t11 == null) {
                this.f22159o = t10;
                qVar.onNext(t10);
                return;
            }
            try {
                ?? r42 = (T) ue.a.requireNonNull(this.f22157m.apply(t11, t10), "The value returned by the accumulator is null");
                this.f22159o = r42;
                qVar.onNext(r42);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22158n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22158n, bVar)) {
                this.f22158n = bVar;
                this.f22156b.onSubscribe(this);
            }
        }
    }

    public g1(ne.o<T> oVar, se.c<T, T, T> cVar) {
        super(oVar);
        this.f22155m = cVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22155m));
    }
}
