package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableCollect.java */
/* loaded from: classes2.dex */
public final class m<T, U> extends ye.a<T, U> {

    /* renamed from: m, reason: collision with root package name */
    public final Callable<? extends U> f22262m;

    /* renamed from: n, reason: collision with root package name */
    public final se.b<? super U, ? super T> f22263n;

    /* compiled from: ObservableCollect.java */
    public static final class a<T, U> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super U> f22264b;

        /* renamed from: m, reason: collision with root package name */
        public final se.b<? super U, ? super T> f22265m;

        /* renamed from: n, reason: collision with root package name */
        public final U f22266n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22267o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22268p;

        public a(ne.q<? super U> qVar, U u10, se.b<? super U, ? super T> bVar) {
            this.f22264b = qVar;
            this.f22265m = bVar;
            this.f22266n = u10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22267o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22268p) {
                return;
            }
            this.f22268p = true;
            U u10 = this.f22266n;
            ne.q<? super U> qVar = this.f22264b;
            qVar.onNext(u10);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22268p) {
                ff.a.onError(th2);
            } else {
                this.f22268p = true;
                this.f22264b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22268p) {
                return;
            }
            try {
                this.f22265m.accept(this.f22266n, t10);
            } catch (Throwable th2) {
                this.f22267o.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22267o, bVar)) {
                this.f22267o = bVar;
                this.f22264b.onSubscribe(this);
            }
        }
    }

    public m(ne.o<T> oVar, Callable<? extends U> callable, se.b<? super U, ? super T> bVar) {
        super(oVar);
        this.f22262m = callable;
        this.f22263n = bVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super U> qVar) {
        try {
            this.f22058b.subscribe(new a(qVar, ue.a.requireNonNull(this.f22262m.call(), "The initialSupplier returned a null value"), this.f22263n));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, qVar);
        }
    }
}
