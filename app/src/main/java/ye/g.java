package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAny.java */
/* loaded from: classes2.dex */
public final class g<T> extends ye.a<T, Boolean> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22148m;

    /* compiled from: ObservableAny.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super Boolean> f22149b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22150m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22151n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22152o;

        public a(ne.q<? super Boolean> qVar, se.o<? super T> oVar) {
            this.f22149b = qVar;
            this.f22150m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22151n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22152o) {
                return;
            }
            this.f22152o = true;
            Boolean bool = Boolean.FALSE;
            ne.q<? super Boolean> qVar = this.f22149b;
            qVar.onNext(bool);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22152o) {
                ff.a.onError(th2);
            } else {
                this.f22152o = true;
                this.f22149b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22152o) {
                return;
            }
            try {
                if (this.f22150m.test(t10)) {
                    this.f22152o = true;
                    this.f22151n.dispose();
                    Boolean bool = Boolean.TRUE;
                    ne.q<? super Boolean> qVar = this.f22149b;
                    qVar.onNext(bool);
                    qVar.onComplete();
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22151n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22151n, bVar)) {
                this.f22151n = bVar;
                this.f22149b.onSubscribe(this);
            }
        }
    }

    public g(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22148m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super Boolean> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22148m));
    }
}
