package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableLastMaybe.java */
/* loaded from: classes2.dex */
public final class t0<T> extends ne.g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22403a;

    /* compiled from: ObservableLastMaybe.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.h<? super T> f22404b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22405m;

        /* renamed from: n, reason: collision with root package name */
        public T f22406n;

        public a(ne.h<? super T> hVar) {
            this.f22404b = hVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22405m.dispose();
            this.f22405m = DisposableHelper.f13533b;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22405m = DisposableHelper.f13533b;
            T t10 = this.f22406n;
            ne.h<? super T> hVar = this.f22404b;
            if (t10 == null) {
                hVar.onComplete();
            } else {
                this.f22406n = null;
                hVar.onSuccess(t10);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22405m = DisposableHelper.f13533b;
            this.f22406n = null;
            this.f22404b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22406n = t10;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22405m, bVar)) {
                this.f22405m = bVar;
                this.f22404b.onSubscribe(this);
            }
        }
    }

    public t0(ne.o<T> oVar) {
        this.f22403a = oVar;
    }

    @Override // ne.g
    public void subscribeActual(ne.h<? super T> hVar) {
        this.f22403a.subscribe(new a(hVar));
    }
}
