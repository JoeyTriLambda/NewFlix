package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollectSingle.java */
/* loaded from: classes2.dex */
public final class n<T, U> extends ne.s<U> implements ve.a<U> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22282a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable<? extends U> f22283b;

    /* renamed from: c, reason: collision with root package name */
    public final se.b<? super U, ? super T> f22284c;

    /* compiled from: ObservableCollectSingle.java */
    public static final class a<T, U> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super U> f22285b;

        /* renamed from: m, reason: collision with root package name */
        public final se.b<? super U, ? super T> f22286m;

        /* renamed from: n, reason: collision with root package name */
        public final U f22287n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22288o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22289p;

        public a(ne.t<? super U> tVar, U u10, se.b<? super U, ? super T> bVar) {
            this.f22285b = tVar;
            this.f22286m = bVar;
            this.f22287n = u10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22288o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22289p) {
                return;
            }
            this.f22289p = true;
            this.f22285b.onSuccess(this.f22287n);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22289p) {
                ff.a.onError(th2);
            } else {
                this.f22289p = true;
                this.f22285b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22289p) {
                return;
            }
            try {
                this.f22286m.accept(this.f22287n, t10);
            } catch (Throwable th2) {
                this.f22288o.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22288o, bVar)) {
                this.f22288o = bVar;
                this.f22285b.onSubscribe(this);
            }
        }
    }

    public n(ne.o<T> oVar, Callable<? extends U> callable, se.b<? super U, ? super T> bVar) {
        this.f22282a = oVar;
        this.f22283b = callable;
        this.f22284c = bVar;
    }

    @Override // ve.a
    public ne.k<U> fuseToObservable() {
        return ff.a.onAssembly(new m(this.f22282a, this.f22283b, this.f22284c));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super U> tVar) {
        try {
            this.f22282a.subscribe(new a(tVar, ue.a.requireNonNull(this.f22283b.call(), "The initialSupplier returned a null value"), this.f22284c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, tVar);
        }
    }
}
