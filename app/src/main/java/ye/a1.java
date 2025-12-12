package ye;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* compiled from: ObservableOnErrorNext.java */
/* loaded from: classes2.dex */
public final class a1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super Throwable, ? extends ne.o<? extends T>> f22061m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f22062n;

    /* compiled from: ObservableOnErrorNext.java */
    public static final class a<T> implements ne.q<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22063b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super Throwable, ? extends ne.o<? extends T>> f22064m;

        /* renamed from: n, reason: collision with root package name */
        public final boolean f22065n;

        /* renamed from: o, reason: collision with root package name */
        public final SequentialDisposable f22066o = new SequentialDisposable();

        /* renamed from: p, reason: collision with root package name */
        public boolean f22067p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f22068q;

        public a(ne.q<? super T> qVar, se.n<? super Throwable, ? extends ne.o<? extends T>> nVar, boolean z10) {
            this.f22063b = qVar;
            this.f22064m = nVar;
            this.f22065n = z10;
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22068q) {
                return;
            }
            this.f22068q = true;
            this.f22067p = true;
            this.f22063b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            boolean z10 = this.f22067p;
            ne.q<? super T> qVar = this.f22063b;
            if (z10) {
                if (this.f22068q) {
                    ff.a.onError(th2);
                    return;
                } else {
                    qVar.onError(th2);
                    return;
                }
            }
            this.f22067p = true;
            if (this.f22065n && !(th2 instanceof Exception)) {
                qVar.onError(th2);
                return;
            }
            try {
                ne.o<? extends T> oVarApply = this.f22064m.apply(th2);
                if (oVarApply != null) {
                    oVarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th2);
                qVar.onError(nullPointerException);
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                qVar.onError(new CompositeException(th2, th3));
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22068q) {
                return;
            }
            this.f22063b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            this.f22066o.replace(bVar);
        }
    }

    public a1(ne.o<T> oVar, se.n<? super Throwable, ? extends ne.o<? extends T>> nVar, boolean z10) {
        super(oVar);
        this.f22061m = nVar;
        this.f22062n = z10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        a aVar = new a(qVar, this.f22061m, this.f22062n);
        qVar.onSubscribe(aVar.f22066o);
        this.f22058b.subscribe(aVar);
    }
}
