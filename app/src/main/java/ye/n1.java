package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkipWhile.java */
/* loaded from: classes2.dex */
public final class n1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22291m;

    /* compiled from: ObservableSkipWhile.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22292b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22293m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22294n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22295o;

        public a(ne.q<? super T> qVar, se.o<? super T> oVar) {
            this.f22292b = qVar;
            this.f22293m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22294n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22292b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22292b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10 = this.f22295o;
            ne.q<? super T> qVar = this.f22292b;
            if (z10) {
                qVar.onNext(t10);
                return;
            }
            try {
                if (this.f22293m.test(t10)) {
                    return;
                }
                this.f22295o = true;
                qVar.onNext(t10);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22294n.dispose();
                qVar.onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22294n, bVar)) {
                this.f22294n = bVar;
                this.f22292b.onSubscribe(this);
            }
        }
    }

    public n1(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22291m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22291m));
    }
}
