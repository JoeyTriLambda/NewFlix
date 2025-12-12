package ye;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableSkipUntil.java */
/* loaded from: classes2.dex */
public final class m1<T, U> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final ne.o<U> f22272m;

    /* compiled from: ObservableSkipUntil.java */
    public final class a implements ne.q<U> {

        /* renamed from: b, reason: collision with root package name */
        public final ArrayCompositeDisposable f22273b;

        /* renamed from: m, reason: collision with root package name */
        public final b<T> f22274m;

        /* renamed from: n, reason: collision with root package name */
        public final ef.e<T> f22275n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22276o;

        public a(ArrayCompositeDisposable arrayCompositeDisposable, b bVar, ef.e eVar) {
            this.f22273b = arrayCompositeDisposable;
            this.f22274m = bVar;
            this.f22275n = eVar;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22274m.f22280o = true;
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22273b.dispose();
            this.f22275n.onError(th2);
        }

        @Override // ne.q
        public void onNext(U u10) {
            this.f22276o.dispose();
            this.f22274m.f22280o = true;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22276o, bVar)) {
                this.f22276o = bVar;
                this.f22273b.setResource(1, bVar);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    public static final class b<T> implements ne.q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22277b;

        /* renamed from: m, reason: collision with root package name */
        public final ArrayCompositeDisposable f22278m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22279n;

        /* renamed from: o, reason: collision with root package name */
        public volatile boolean f22280o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22281p;

        public b(ef.e eVar, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f22277b = eVar;
            this.f22278m = arrayCompositeDisposable;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22278m.dispose();
            this.f22277b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22278m.dispose();
            this.f22277b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22281p) {
                this.f22277b.onNext(t10);
            } else if (this.f22280o) {
                this.f22281p = true;
                this.f22277b.onNext(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22279n, bVar)) {
                this.f22279n = bVar;
                this.f22278m.setResource(0, bVar);
            }
        }
    }

    public m1(ne.o<T> oVar, ne.o<U> oVar2) {
        super(oVar);
        this.f22272m = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        ef.e eVar = new ef.e(qVar);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        eVar.onSubscribe(arrayCompositeDisposable);
        b bVar = new b(eVar, arrayCompositeDisposable);
        this.f22272m.subscribe(new a(arrayCompositeDisposable, bVar, eVar));
        this.f22058b.subscribe(bVar);
    }
}
