package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableAllSingle.java */
/* loaded from: classes2.dex */
public final class f<T> extends ne.s<Boolean> implements ve.a<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22138a;

    /* renamed from: b, reason: collision with root package name */
    public final se.o<? super T> f22139b;

    /* compiled from: ObservableAllSingle.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super Boolean> f22140b;

        /* renamed from: m, reason: collision with root package name */
        public final se.o<? super T> f22141m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22142n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22143o;

        public a(ne.t<? super Boolean> tVar, se.o<? super T> oVar) {
            this.f22140b = tVar;
            this.f22141m = oVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22142n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22143o) {
                return;
            }
            this.f22143o = true;
            this.f22140b.onSuccess(Boolean.TRUE);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22143o) {
                ff.a.onError(th2);
            } else {
                this.f22143o = true;
                this.f22140b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22143o) {
                return;
            }
            try {
                if (this.f22141m.test(t10)) {
                    return;
                }
                this.f22143o = true;
                this.f22142n.dispose();
                this.f22140b.onSuccess(Boolean.FALSE);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22142n.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22142n, bVar)) {
                this.f22142n = bVar;
                this.f22140b.onSubscribe(this);
            }
        }
    }

    public f(ne.o<T> oVar, se.o<? super T> oVar2) {
        this.f22138a = oVar;
        this.f22139b = oVar2;
    }

    @Override // ve.a
    public ne.k<Boolean> fuseToObservable() {
        return ff.a.onAssembly(new e(this.f22138a, this.f22139b));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super Boolean> tVar) {
        this.f22138a.subscribe(new a(tVar, this.f22139b));
    }
}
