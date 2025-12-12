package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAtSingle.java */
/* loaded from: classes2.dex */
public final class d0<T> extends ne.s<T> implements ve.a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22109a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22110b;

    /* renamed from: c, reason: collision with root package name */
    public final T f22111c;

    /* compiled from: ObservableElementAtSingle.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super T> f22112b;

        /* renamed from: m, reason: collision with root package name */
        public final long f22113m;

        /* renamed from: n, reason: collision with root package name */
        public final T f22114n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22115o;

        /* renamed from: p, reason: collision with root package name */
        public long f22116p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f22117q;

        public a(ne.t<? super T> tVar, long j10, T t10) {
            this.f22112b = tVar;
            this.f22113m = j10;
            this.f22114n = t10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22115o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22117q) {
                return;
            }
            this.f22117q = true;
            ne.t<? super T> tVar = this.f22112b;
            T t10 = this.f22114n;
            if (t10 != null) {
                tVar.onSuccess(t10);
            } else {
                tVar.onError(new NoSuchElementException());
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22117q) {
                ff.a.onError(th2);
            } else {
                this.f22117q = true;
                this.f22112b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22117q) {
                return;
            }
            long j10 = this.f22116p;
            if (j10 != this.f22113m) {
                this.f22116p = j10 + 1;
                return;
            }
            this.f22117q = true;
            this.f22115o.dispose();
            this.f22112b.onSuccess(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22115o, bVar)) {
                this.f22115o = bVar;
                this.f22112b.onSubscribe(this);
            }
        }
    }

    public d0(ne.o<T> oVar, long j10, T t10) {
        this.f22109a = oVar;
        this.f22110b = j10;
        this.f22111c = t10;
    }

    @Override // ve.a
    public ne.k<T> fuseToObservable() {
        return ff.a.onAssembly(new b0(this.f22109a, this.f22110b, this.f22111c, true));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super T> tVar) {
        this.f22109a.subscribe(new a(tVar, this.f22110b, this.f22111c));
    }
}
