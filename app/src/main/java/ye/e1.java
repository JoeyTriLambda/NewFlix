package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableReduceSeedSingle.java */
/* loaded from: classes2.dex */
public final class e1<T, R> extends ne.s<R> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22131a;

    /* renamed from: b, reason: collision with root package name */
    public final R f22132b;

    /* renamed from: c, reason: collision with root package name */
    public final se.c<R, ? super T, R> f22133c;

    /* compiled from: ObservableReduceSeedSingle.java */
    public static final class a<T, R> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super R> f22134b;

        /* renamed from: m, reason: collision with root package name */
        public final se.c<R, ? super T, R> f22135m;

        /* renamed from: n, reason: collision with root package name */
        public R f22136n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22137o;

        public a(ne.t<? super R> tVar, se.c<R, ? super T, R> cVar, R r10) {
            this.f22134b = tVar;
            this.f22136n = r10;
            this.f22135m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22137o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            R r10 = this.f22136n;
            if (r10 != null) {
                this.f22136n = null;
                this.f22134b.onSuccess(r10);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22136n == null) {
                ff.a.onError(th2);
            } else {
                this.f22136n = null;
                this.f22134b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            R r10 = this.f22136n;
            if (r10 != null) {
                try {
                    this.f22136n = (R) ue.a.requireNonNull(this.f22135m.apply(r10, t10), "The reducer returned a null value");
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f22137o.dispose();
                    onError(th2);
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22137o, bVar)) {
                this.f22137o = bVar;
                this.f22134b.onSubscribe(this);
            }
        }
    }

    public e1(ne.o<T> oVar, R r10, se.c<R, ? super T, R> cVar) {
        this.f22131a = oVar;
        this.f22132b = r10;
        this.f22133c = cVar;
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super R> tVar) {
        this.f22131a.subscribe(new a(tVar, this.f22133c, this.f22132b));
    }
}
