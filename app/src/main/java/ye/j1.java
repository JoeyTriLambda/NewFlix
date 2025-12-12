package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes2.dex */
public final class j1<T> extends ne.g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22194a;

    /* compiled from: ObservableSingleMaybe.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.h<? super T> f22195b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22196m;

        /* renamed from: n, reason: collision with root package name */
        public T f22197n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22198o;

        public a(ne.h<? super T> hVar) {
            this.f22195b = hVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22196m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22198o) {
                return;
            }
            this.f22198o = true;
            T t10 = this.f22197n;
            this.f22197n = null;
            ne.h<? super T> hVar = this.f22195b;
            if (t10 == null) {
                hVar.onComplete();
            } else {
                hVar.onSuccess(t10);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22198o) {
                ff.a.onError(th2);
            } else {
                this.f22198o = true;
                this.f22195b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22198o) {
                return;
            }
            if (this.f22197n == null) {
                this.f22197n = t10;
                return;
            }
            this.f22198o = true;
            this.f22196m.dispose();
            this.f22195b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22196m, bVar)) {
                this.f22196m = bVar;
                this.f22195b.onSubscribe(this);
            }
        }
    }

    public j1(ne.o<T> oVar) {
        this.f22194a = oVar;
    }

    @Override // ne.g
    public void subscribeActual(ne.h<? super T> hVar) {
        this.f22194a.subscribe(new a(hVar));
    }
}
