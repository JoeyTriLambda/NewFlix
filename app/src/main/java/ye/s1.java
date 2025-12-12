package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeWhile.java */
/* loaded from: classes2.dex */
public final class s1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.o<? super T> f22391m;

    /* compiled from: ObservableTakeWhile.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22392b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22393m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22394n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22395o;

        public a(ne.q<? super T> qVar, se.o<? super T> oVar) {
            this.f22392b = qVar;
            this.f22393m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22394n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22395o) {
                return;
            }
            this.f22395o = true;
            this.f22392b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22395o) {
                ff.a.onError(th2);
            } else {
                this.f22395o = true;
                this.f22392b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22395o) {
                return;
            }
            try {
                boolean zTest = this.f22393m.test(t10);
                ne.q<? super T> qVar = this.f22392b;
                if (zTest) {
                    qVar.onNext(t10);
                    return;
                }
                this.f22395o = true;
                this.f22394n.dispose();
                qVar.onComplete();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22394n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22394n, bVar)) {
                this.f22394n = bVar;
                this.f22392b.onSubscribe(this);
            }
        }
    }

    public s1(ne.o<T> oVar, se.o<? super T> oVar2) {
        super(oVar);
        this.f22391m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22391m));
    }
}
