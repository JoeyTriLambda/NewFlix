package ye;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes2.dex */
public final class b1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super Throwable, ? extends T> f22083m;

    /* compiled from: ObservableOnErrorReturn.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22084b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super Throwable, ? extends T> f22085m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22086n;

        public a(ne.q<? super T> qVar, se.n<? super Throwable, ? extends T> nVar) {
            this.f22084b = qVar;
            this.f22085m = nVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22086n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22084b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ne.q<? super T> qVar = this.f22084b;
            try {
                T tApply = this.f22085m.apply(th2);
                if (tApply != null) {
                    qVar.onNext(tApply);
                    qVar.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    qVar.onError(nullPointerException);
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                qVar.onError(new CompositeException(th2, th3));
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22084b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22086n, bVar)) {
                this.f22086n = bVar;
                this.f22084b.onSubscribe(this);
            }
        }
    }

    public b1(ne.o<T> oVar, se.n<? super Throwable, ? extends T> nVar) {
        super(oVar);
        this.f22083m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22083m));
    }
}
