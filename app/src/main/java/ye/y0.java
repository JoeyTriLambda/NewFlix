package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableMaterialize.java */
/* loaded from: classes2.dex */
public final class y0<T> extends ye.a<T, ne.j<T>> {

    /* compiled from: ObservableMaterialize.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super ne.j<T>> f22515b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22516m;

        public a(ne.q<? super ne.j<T>> qVar) {
            this.f22515b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22516m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            ne.j jVarCreateOnComplete = ne.j.createOnComplete();
            ne.q<? super ne.j<T>> qVar = this.f22515b;
            qVar.onNext(jVarCreateOnComplete);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ne.j jVarCreateOnError = ne.j.createOnError(th2);
            ne.q<? super ne.j<T>> qVar = this.f22515b;
            qVar.onNext(jVarCreateOnError);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22515b.onNext(ne.j.createOnNext(t10));
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22516m, bVar)) {
                this.f22516m = bVar;
                this.f22515b.onSubscribe(this);
            }
        }
    }

    public y0(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super ne.j<T>> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }
}
