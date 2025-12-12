package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* compiled from: ObservableDistinct.java */
/* loaded from: classes2.dex */
public final class w<T, K> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, K> f22436m;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f22437n;

    /* compiled from: ObservableDistinct.java */
    public static final class a<T, K> extends we.a<T, T> {

        /* renamed from: q, reason: collision with root package name */
        public final Collection<? super K> f22438q;

        /* renamed from: r, reason: collision with root package name */
        public final se.n<? super T, K> f22439r;

        public a(ne.q<? super T> qVar, se.n<? super T, K> nVar, Collection<? super K> collection) {
            super(qVar);
            this.f22439r = nVar;
            this.f22438q = collection;
        }

        @Override // we.a, ve.f
        public void clear() {
            this.f22438q.clear();
            super.clear();
        }

        @Override // we.a, ne.q
        public void onComplete() {
            if (this.f21127o) {
                return;
            }
            this.f21127o = true;
            this.f22438q.clear();
            this.f21124b.onComplete();
        }

        @Override // we.a, ne.q
        public void onError(Throwable th2) {
            if (this.f21127o) {
                ff.a.onError(th2);
                return;
            }
            this.f21127o = true;
            this.f22438q.clear();
            this.f21124b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f21127o) {
                return;
            }
            int i10 = this.f21128p;
            ne.q<? super R> qVar = this.f21124b;
            if (i10 != 0) {
                qVar.onNext(null);
                return;
            }
            try {
                if (this.f22438q.add(ue.a.requireNonNull(this.f22439r.apply(t10), "The keySelector returned a null key"))) {
                    qVar.onNext(t10);
                }
            } catch (Throwable th2) {
                fail(th2);
            }
        }

        @Override // ve.f
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f21126n.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f22438q.add(ue.a.requireNonNull(this.f22439r.apply(tPoll), "The keySelector returned a null key")));
            return tPoll;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            return transitiveBoundaryFusion(i10);
        }
    }

    public w(ne.o<T> oVar, se.n<? super T, K> nVar, Callable<? extends Collection<? super K>> callable) {
        super(oVar);
        this.f22436m = nVar;
        this.f22437n = callable;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        try {
            this.f22058b.subscribe(new a(qVar, this.f22436m, (Collection) ue.a.requireNonNull(this.f22437n.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
