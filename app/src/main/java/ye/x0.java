package ye;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.Callable;

/* compiled from: ObservableMapNotification.java */
/* loaded from: classes2.dex */
public final class x0<T, R> extends ye.a<T, ne.o<? extends R>> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, ? extends ne.o<? extends R>> f22466m;

    /* renamed from: n, reason: collision with root package name */
    public final se.n<? super Throwable, ? extends ne.o<? extends R>> f22467n;

    /* renamed from: o, reason: collision with root package name */
    public final Callable<? extends ne.o<? extends R>> f22468o;

    /* compiled from: ObservableMapNotification.java */
    public static final class a<T, R> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super ne.o<? extends R>> f22469b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super T, ? extends ne.o<? extends R>> f22470m;

        /* renamed from: n, reason: collision with root package name */
        public final se.n<? super Throwable, ? extends ne.o<? extends R>> f22471n;

        /* renamed from: o, reason: collision with root package name */
        public final Callable<? extends ne.o<? extends R>> f22472o;

        /* renamed from: p, reason: collision with root package name */
        public qe.b f22473p;

        public a(ne.q<? super ne.o<? extends R>> qVar, se.n<? super T, ? extends ne.o<? extends R>> nVar, se.n<? super Throwable, ? extends ne.o<? extends R>> nVar2, Callable<? extends ne.o<? extends R>> callable) {
            this.f22469b = qVar;
            this.f22470m = nVar;
            this.f22471n = nVar2;
            this.f22472o = callable;
        }

        @Override // qe.b
        public void dispose() {
            this.f22473p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            ne.q<? super ne.o<? extends R>> qVar = this.f22469b;
            try {
                qVar.onNext((ne.o) ue.a.requireNonNull(this.f22472o.call(), "The onComplete ObservableSource returned is null"));
                qVar.onComplete();
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                qVar.onError(th2);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ne.q<? super ne.o<? extends R>> qVar = this.f22469b;
            try {
                qVar.onNext((ne.o) ue.a.requireNonNull(this.f22471n.apply(th2), "The onError ObservableSource returned is null"));
                qVar.onComplete();
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                qVar.onError(new CompositeException(th2, th3));
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            ne.q<? super ne.o<? extends R>> qVar = this.f22469b;
            try {
                qVar.onNext((ne.o) ue.a.requireNonNull(this.f22470m.apply(t10), "The onNext ObservableSource returned is null"));
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                qVar.onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22473p, bVar)) {
                this.f22473p = bVar;
                this.f22469b.onSubscribe(this);
            }
        }
    }

    public x0(ne.o<T> oVar, se.n<? super T, ? extends ne.o<? extends R>> nVar, se.n<? super Throwable, ? extends ne.o<? extends R>> nVar2, Callable<? extends ne.o<? extends R>> callable) {
        super(oVar);
        this.f22466m = nVar;
        this.f22467n = nVar2;
        this.f22468o = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super ne.o<? extends R>> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22466m, this.f22467n, this.f22468o));
    }
}
