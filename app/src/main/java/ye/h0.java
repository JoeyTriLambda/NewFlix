package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

/* compiled from: ObservableFlattenIterable.java */
/* loaded from: classes2.dex */
public final class h0<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, ? extends Iterable<? extends R>> f22167m;

    /* compiled from: ObservableFlattenIterable.java */
    public static final class a<T, R> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super R> f22168b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super T, ? extends Iterable<? extends R>> f22169m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22170n;

        public a(ne.q<? super R> qVar, se.n<? super T, ? extends Iterable<? extends R>> nVar) {
            this.f22168b = qVar;
            this.f22169m = nVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22170n.dispose();
            this.f22170n = DisposableHelper.f13533b;
        }

        @Override // ne.q
        public void onComplete() {
            qe.b bVar = this.f22170n;
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar == disposableHelper) {
                return;
            }
            this.f22170n = disposableHelper;
            this.f22168b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            qe.b bVar = this.f22170n;
            DisposableHelper disposableHelper = DisposableHelper.f13533b;
            if (bVar == disposableHelper) {
                ff.a.onError(th2);
            } else {
                this.f22170n = disposableHelper;
                this.f22168b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22170n == DisposableHelper.f13533b) {
                return;
            }
            try {
                Iterator<? extends R> it = this.f22169m.apply(t10).iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            this.f22168b.onNext(ue.a.requireNonNull(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th2) {
                            re.a.throwIfFatal(th2);
                            this.f22170n.dispose();
                            onError(th2);
                            return;
                        }
                    } catch (Throwable th3) {
                        re.a.throwIfFatal(th3);
                        this.f22170n.dispose();
                        onError(th3);
                        return;
                    }
                }
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                this.f22170n.dispose();
                onError(th4);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22170n, bVar)) {
                this.f22170n = bVar;
                this.f22168b.onSubscribe(this);
            }
        }
    }

    public h0(ne.o<T> oVar, se.n<? super T, ? extends Iterable<? extends R>> nVar) {
        super(oVar);
        this.f22167m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super R> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22167m));
    }
}
