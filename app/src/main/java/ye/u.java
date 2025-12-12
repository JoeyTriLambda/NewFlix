package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableDematerialize.java */
/* loaded from: classes2.dex */
public final class u<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, ? extends ne.j<R>> f22414m;

    /* compiled from: ObservableDematerialize.java */
    public static final class a<T, R> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super R> f22415b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super T, ? extends ne.j<R>> f22416m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f22417n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22418o;

        public a(ne.q<? super R> qVar, se.n<? super T, ? extends ne.j<R>> nVar) {
            this.f22415b = qVar;
            this.f22416m = nVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22418o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22417n) {
                return;
            }
            this.f22417n = true;
            this.f22415b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22417n) {
                ff.a.onError(th2);
            } else {
                this.f22417n = true;
                this.f22415b.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22417n) {
                if (t10 instanceof ne.j) {
                    ne.j jVar = (ne.j) t10;
                    if (jVar.isOnError()) {
                        ff.a.onError(jVar.getError());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                ne.j jVar2 = (ne.j) ue.a.requireNonNull(this.f22416m.apply(t10), "The selector returned a null Notification");
                if (jVar2.isOnError()) {
                    this.f22418o.dispose();
                    onError(jVar2.getError());
                } else if (!jVar2.isOnComplete()) {
                    this.f22415b.onNext((Object) jVar2.getValue());
                } else {
                    this.f22418o.dispose();
                    onComplete();
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22418o.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22418o, bVar)) {
                this.f22418o = bVar;
                this.f22415b.onSubscribe(this);
            }
        }
    }

    public u(ne.o<T> oVar, se.n<? super T, ? extends ne.j<R>> nVar) {
        super(oVar);
        this.f22414m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super R> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22414m));
    }
}
