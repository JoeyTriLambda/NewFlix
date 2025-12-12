package ye;

import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes2.dex */
public final class o1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final ne.o<? extends T> f22308m;

    /* compiled from: ObservableSwitchIfEmpty.java */
    public static final class a<T> implements ne.q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22309b;

        /* renamed from: m, reason: collision with root package name */
        public final ne.o<? extends T> f22310m;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22312o = true;

        /* renamed from: n, reason: collision with root package name */
        public final SequentialDisposable f22311n = new SequentialDisposable();

        public a(ne.o oVar, ne.q qVar) {
            this.f22309b = qVar;
            this.f22310m = oVar;
        }

        @Override // ne.q
        public void onComplete() {
            if (!this.f22312o) {
                this.f22309b.onComplete();
            } else {
                this.f22312o = false;
                this.f22310m.subscribe(this);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22309b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22312o) {
                this.f22312o = false;
            }
            this.f22309b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f22311n.update(bVar);
        }
    }

    public o1(ne.o<T> oVar, ne.o<? extends T> oVar2) {
        super(oVar);
        this.f22308m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        a aVar = new a(this.f22308m, qVar);
        qVar.onSubscribe(aVar.f22311n);
        this.f22058b.subscribe(aVar);
    }
}
