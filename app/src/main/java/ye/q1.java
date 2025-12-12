package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableTakeLastOne.java */
/* loaded from: classes2.dex */
public final class q1<T> extends ye.a<T, T> {

    /* compiled from: ObservableTakeLastOne.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22338b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22339m;

        /* renamed from: n, reason: collision with root package name */
        public T f22340n;

        public a(ne.q<? super T> qVar) {
            this.f22338b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22340n = null;
            this.f22339m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            T t10 = this.f22340n;
            ne.q<? super T> qVar = this.f22338b;
            if (t10 != null) {
                this.f22340n = null;
                qVar.onNext(t10);
            }
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22340n = null;
            this.f22338b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22340n = t10;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22339m, bVar)) {
                this.f22339m = bVar;
                this.f22338b.onSubscribe(this);
            }
        }
    }

    public q1(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }
}
