package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableScanSeed.java */
/* loaded from: classes2.dex */
public final class h1<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final se.c<R, ? super T, R> f22171m;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<R> f22172n;

    /* compiled from: ObservableScanSeed.java */
    public static final class a<T, R> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super R> f22173b;

        /* renamed from: m, reason: collision with root package name */
        public final se.c<R, ? super T, R> f22174m;

        /* renamed from: n, reason: collision with root package name */
        public R f22175n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22176o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22177p;

        public a(ne.q<? super R> qVar, se.c<R, ? super T, R> cVar, R r10) {
            this.f22173b = qVar;
            this.f22174m = cVar;
            this.f22175n = r10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22176o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22177p) {
                return;
            }
            this.f22177p = true;
            this.f22173b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22177p) {
                ff.a.onError(th2);
            } else {
                this.f22177p = true;
                this.f22173b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22177p) {
                return;
            }
            try {
                R r10 = (R) ue.a.requireNonNull(this.f22174m.apply(this.f22175n, t10), "The accumulator returned a null value");
                this.f22175n = r10;
                this.f22173b.onNext(r10);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22176o.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22176o, bVar)) {
                this.f22176o = bVar;
                ne.q<? super R> qVar = this.f22173b;
                qVar.onSubscribe(this);
                qVar.onNext(this.f22175n);
            }
        }
    }

    public h1(ne.o<T> oVar, Callable<R> callable, se.c<R, ? super T, R> cVar) {
        super(oVar);
        this.f22171m = cVar;
        this.f22172n = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super R> qVar) {
        try {
            this.f22058b.subscribe(new a(qVar, this.f22171m, ue.a.requireNonNull(this.f22172n.call(), "The seed supplied is null")));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
