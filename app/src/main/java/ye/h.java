package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAnySingle.java */
/* loaded from: classes2.dex */
public final class h<T> extends ne.s<Boolean> implements ve.a<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22161a;

    /* renamed from: b, reason: collision with root package name */
    public final se.o<? super T> f22162b;

    /* compiled from: ObservableAnySingle.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super Boolean> f22163b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22164m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22165n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22166o;

        public a(ne.t<? super Boolean> tVar, se.o<? super T> oVar) {
            this.f22163b = tVar;
            this.f22164m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22165n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22166o) {
                return;
            }
            this.f22166o = true;
            this.f22163b.onSuccess(Boolean.FALSE);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22166o) {
                ff.a.onError(th2);
            } else {
                this.f22166o = true;
                this.f22163b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22166o) {
                return;
            }
            try {
                if (this.f22164m.test(t10)) {
                    this.f22166o = true;
                    this.f22165n.dispose();
                    this.f22163b.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22165n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22165n, bVar)) {
                this.f22165n = bVar;
                this.f22163b.onSubscribe(this);
            }
        }
    }

    public h(ne.o<T> oVar, se.o<? super T> oVar2) {
        this.f22161a = oVar;
        this.f22162b = oVar2;
    }

    @Override // ve.a
    public ne.k<Boolean> fuseToObservable() {
        return ff.a.onAssembly(new g(this.f22161a, this.f22162b));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super Boolean> tVar) {
        this.f22161a.subscribe(new a(tVar, this.f22162b));
    }
}
