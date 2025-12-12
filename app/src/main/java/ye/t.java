package ye;

import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes2.dex */
public final class t<T, U> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.o<? extends T> f22396b;

    /* renamed from: m, reason: collision with root package name */
    public final ne.o<U> f22397m;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    public final class a implements ne.q<U> {

        /* renamed from: b, reason: collision with root package name */
        public final SequentialDisposable f22398b;

        /* renamed from: m, reason: collision with root package name */
        public final ne.q<? super T> f22399m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f22400n;

        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: ye.t$a$a, reason: collision with other inner class name */
        public final class C0326a implements ne.q<T> {
            public C0326a() {
            }

            @Override // ne.q
            public void onComplete() {
                a.this.f22399m.onComplete();
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                a.this.f22399m.onError(th2);
            }

            @Override // ne.q
            public void onNext(T t10) {
                a.this.f22399m.onNext(t10);
            }

            @Override // ne.q
            public void onSubscribe(qe.b bVar) {
                a.this.f22398b.update(bVar);
            }
        }

        public a(SequentialDisposable sequentialDisposable, ne.q<? super T> qVar) {
            this.f22398b = sequentialDisposable;
            this.f22399m = qVar;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22400n) {
                return;
            }
            this.f22400n = true;
            t.this.f22396b.subscribe(new C0326a());
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22400n) {
                ff.a.onError(th2);
            } else {
                this.f22400n = true;
                this.f22399m.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(U u10) {
            onComplete();
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f22398b.update(bVar);
        }
    }

    public t(ne.o<? extends T> oVar, ne.o<U> oVar2) {
        this.f22396b = oVar;
        this.f22397m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        qVar.onSubscribe(sequentialDisposable);
        this.f22397m.subscribe(new a(sequentialDisposable, qVar));
    }
}
