package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;

/* compiled from: ObservableZipIterable.java */
/* loaded from: classes2.dex */
public final class y1<T, U, V> extends ne.k<V> {

    /* renamed from: b, reason: collision with root package name */
    public final ne.k<? extends T> f22517b;

    /* renamed from: m, reason: collision with root package name */
    public final Iterable<U> f22518m;

    /* renamed from: n, reason: collision with root package name */
    public final se.c<? super T, ? super U, ? extends V> f22519n;

    /* compiled from: ObservableZipIterable.java */
    public static final class a<T, U, V> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super V> f22520b;

        /* renamed from: m, reason: collision with root package name */
        public final Iterator<U> f22521m;

        /* renamed from: n, reason: collision with root package name */
        public final se.c<? super T, ? super U, ? extends V> f22522n;

        /* renamed from: o, reason: collision with root package name */
        public qe.b f22523o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22524p;

        public a(ne.q<? super V> qVar, Iterator<U> it, se.c<? super T, ? super U, ? extends V> cVar) {
            this.f22520b = qVar;
            this.f22521m = it;
            this.f22522n = cVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22523o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22524p) {
                return;
            }
            this.f22524p = true;
            this.f22520b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22524p) {
                ff.a.onError(th2);
            } else {
                this.f22524p = true;
                this.f22520b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            ne.q<? super V> qVar = this.f22520b;
            Iterator<U> it = this.f22521m;
            if (this.f22524p) {
                return;
            }
            try {
                try {
                    qVar.onNext((Object) ue.a.requireNonNull(this.f22522n.apply(t10, ue.a.requireNonNull(it.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (it.hasNext()) {
                            return;
                        }
                        this.f22524p = true;
                        this.f22523o.dispose();
                        qVar.onComplete();
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        this.f22524p = true;
                        this.f22523o.dispose();
                        qVar.onError(th2);
                    }
                } catch (Throwable th3) {
                    re.a.throwIfFatal(th3);
                    this.f22524p = true;
                    this.f22523o.dispose();
                    qVar.onError(th3);
                }
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                this.f22524p = true;
                this.f22523o.dispose();
                qVar.onError(th4);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22523o, bVar)) {
                this.f22523o = bVar;
                this.f22520b.onSubscribe(this);
            }
        }
    }

    public y1(ne.k<? extends T> kVar, Iterable<U> iterable, se.c<? super T, ? super U, ? extends V> cVar) {
        this.f22517b = kVar;
        this.f22518m = iterable;
        this.f22519n = cVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super V> qVar) {
        try {
            Iterator it = (Iterator) ue.a.requireNonNull(this.f22518m.iterator(), "The iterator returned by other is null");
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.complete(qVar);
                } else {
                    this.f22517b.subscribe(new a(qVar, it, this.f22519n));
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                EmptyDisposable.error(th2, qVar);
            }
        } catch (Throwable th3) {
            re.a.throwIfFatal(th3);
            EmptyDisposable.error(th3, qVar);
        }
    }
}
