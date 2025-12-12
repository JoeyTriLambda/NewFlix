package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableToList.java */
/* loaded from: classes2.dex */
public final class u1<T, U extends Collection<? super T>> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final Callable<U> f22425m;

    /* compiled from: ObservableToList.java */
    public static final class a<T, U extends Collection<? super T>> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super U> f22426b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22427m;

        /* renamed from: n, reason: collision with root package name */
        public U f22428n;

        public a(ne.q<? super U> qVar, U u10) {
            this.f22426b = qVar;
            this.f22428n = u10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22427m.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            U u10 = this.f22428n;
            this.f22428n = null;
            ne.q<? super U> qVar = this.f22426b;
            qVar.onNext(u10);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22428n = null;
            this.f22426b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22428n.add(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22427m, bVar)) {
                this.f22427m = bVar;
                this.f22426b.onSubscribe(this);
            }
        }
    }

    public u1(ne.o<T> oVar, int i10) {
        super(oVar);
        this.f22425m = Functions.createArrayList(i10);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        try {
            this.f22058b.subscribe(new a(qVar, (Collection) ue.a.requireNonNull(this.f22425m.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }

    public u1(ne.o<T> oVar, Callable<U> callable) {
        super(oVar);
        this.f22425m = callable;
    }
}
