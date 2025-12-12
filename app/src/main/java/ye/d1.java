package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes2.dex */
public final class d1<T> extends ne.g<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22118a;

    /* renamed from: b, reason: collision with root package name */
    public final se.c<T, T, T> f22119b;

    /* compiled from: ObservableReduceMaybe.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.h<? super T> f22120b;

        /* renamed from: m, reason: collision with root package name */
        public final se.c<T, T, T> f22121m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f22122n;

        /* renamed from: o, reason: collision with root package name */
        public T f22123o;

        /* renamed from: p, reason: collision with root package name */
        public qe.b f22124p;

        public a(ne.h<? super T> hVar, se.c<T, T, T> cVar) {
            this.f22120b = hVar;
            this.f22121m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22124p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22122n) {
                return;
            }
            this.f22122n = true;
            T t10 = this.f22123o;
            this.f22123o = null;
            ne.h<? super T> hVar = this.f22120b;
            if (t10 != null) {
                hVar.onSuccess(t10);
            } else {
                hVar.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22122n) {
                ff.a.onError(th2);
                return;
            }
            this.f22122n = true;
            this.f22123o = null;
            this.f22120b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22122n) {
                return;
            }
            T t11 = this.f22123o;
            if (t11 == null) {
                this.f22123o = t10;
                return;
            }
            try {
                this.f22123o = (T) ue.a.requireNonNull(this.f22121m.apply(t11, t10), "The reducer returned a null value");
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22124p.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22124p, bVar)) {
                this.f22124p = bVar;
                this.f22120b.onSubscribe(this);
            }
        }
    }

    public d1(ne.o<T> oVar, se.c<T, T, T> cVar) {
        this.f22118a = oVar;
        this.f22119b = cVar;
    }

    @Override // ne.g
    public void subscribeActual(ne.h<? super T> hVar) {
        this.f22118a.subscribe(new a(hVar, this.f22119b));
    }
}
