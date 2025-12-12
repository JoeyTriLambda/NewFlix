package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAll.java */
/* loaded from: classes2.dex */
public final class e<T> extends ye.a<T, Boolean> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22125m;

    /* compiled from: ObservableAll.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super Boolean> f22126b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22127m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22128n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22129o;

        public a(ne.q<? super Boolean> qVar, se.o<? super T> oVar) {
            this.f22126b = qVar;
            this.f22127m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22128n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22129o) {
                return;
            }
            this.f22129o = true;
            Boolean bool = Boolean.TRUE;
            ne.q<? super Boolean> qVar = this.f22126b;
            qVar.onNext(bool);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22129o) {
                ff.a.onError(th2);
            } else {
                this.f22129o = true;
                this.f22126b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22129o) {
                return;
            }
            try {
                if (this.f22127m.test(t10)) {
                    return;
                }
                this.f22129o = true;
                this.f22128n.dispose();
                Boolean bool = Boolean.FALSE;
                ne.q<? super Boolean> qVar = this.f22126b;
                qVar.onNext(bool);
                qVar.onComplete();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22128n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22128n, bVar)) {
                this.f22128n = bVar;
                this.f22126b.onSubscribe(this);
            }
        }
    }

    public e(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22125m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super Boolean> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22125m));
    }
}
