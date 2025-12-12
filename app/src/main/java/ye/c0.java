package ye;

import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes2.dex */
public final class c0<T> extends ne.g<T> implements ve.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22092a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22093b;

    /* compiled from: ObservableElementAtMaybe.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.h<? super T> f22094b;

        /* renamed from: m, reason: collision with root package name */
        public final long f22095m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22096n;

        /* renamed from: o, reason: collision with root package name */
        public long f22097o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22098p;

        public a(ne.h<? super T> hVar, long j10) {
            this.f22094b = hVar;
            this.f22095m = j10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22096n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22098p) {
                return;
            }
            this.f22098p = true;
            this.f22094b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22098p) {
                ff.a.onError(th2);
            } else {
                this.f22098p = true;
                this.f22094b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22098p) {
                return;
            }
            long j10 = this.f22097o;
            if (j10 != this.f22095m) {
                this.f22097o = j10 + 1;
                return;
            }
            this.f22098p = true;
            this.f22096n.dispose();
            this.f22094b.onSuccess(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22096n, bVar)) {
                this.f22096n = bVar;
                this.f22094b.onSubscribe(this);
            }
        }
    }

    public c0(ne.o<T> oVar, long j10) {
        this.f22092a = oVar;
        this.f22093b = j10;
    }

    @Override // ve.a
    public ne.k<T> fuseToObservable() {
        return ff.a.onAssembly(new b0(this.f22092a, this.f22093b, null, false));
    }

    @Override // ne.g
    public void subscribeActual(ne.h<? super T> hVar) {
        this.f22092a.subscribe(new a(hVar, this.f22093b));
    }
}
