package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToListSingle.java */
/* loaded from: classes2.dex */
public final class v1<T, U extends Collection<? super T>> extends ne.s<U> implements ve.a<U> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22431a;

    /* renamed from: b, reason: collision with root package name */
    public final Callable<U> f22432b;

    /* compiled from: ObservableToListSingle.java */
    public static final class a<T, U extends Collection<? super T>> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super U> f22433b;

        /* renamed from: m, reason: collision with root package name */
        public U f22434m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22435n;

        public a(ne.t<? super U> tVar, U u10) {
            this.f22433b = tVar;
            this.f22434m = u10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22435n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            U u10 = this.f22434m;
            this.f22434m = null;
            this.f22433b.onSuccess(u10);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22434m = null;
            this.f22433b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22434m.add(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22435n, bVar)) {
                this.f22435n = bVar;
                this.f22433b.onSubscribe(this);
            }
        }
    }

    public v1(ne.o<T> oVar, int i10) {
        this.f22431a = oVar;
        this.f22432b = Functions.createArrayList(i10);
    }

    @Override // ve.a
    public ne.k<U> fuseToObservable() {
        return ff.a.onAssembly(new u1(this.f22431a, this.f22432b));
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super U> tVar) {
        try {
            this.f22431a.subscribe(new a(tVar, (Collection) ue.a.requireNonNull(this.f22432b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, tVar);
        }
    }

    public v1(ne.o<T> oVar, Callable<U> callable) {
        this.f22431a = oVar;
        this.f22432b = callable;
    }
}
