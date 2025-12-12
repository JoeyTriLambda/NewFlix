package ye;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes2.dex */
public final class z<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.f<? super T> f22525m;

    /* renamed from: n, reason: collision with root package name */
    public final se.f<? super Throwable> f22526n;

    /* renamed from: o, reason: collision with root package name */
    public final se.a f22527o;

    /* renamed from: p, reason: collision with root package name */
    public final se.a f22528p;

    /* compiled from: ObservableDoOnEach.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22529b;

        /* renamed from: m, reason: collision with root package name */
        public final se.f<? super T> f22530m;

        /* renamed from: n, reason: collision with root package name */
        public final se.f<? super Throwable> f22531n;

        /* renamed from: o, reason: collision with root package name */
        public final se.a f22532o;

        /* renamed from: p, reason: collision with root package name */
        public final se.a f22533p;

        /* renamed from: q, reason: collision with root package name */
        public qe.b f22534q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f22535r;

        public a(ne.q<? super T> qVar, se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar, se.a aVar2) {
            this.f22529b = qVar;
            this.f22530m = fVar;
            this.f22531n = fVar2;
            this.f22532o = aVar;
            this.f22533p = aVar2;
        }

        @Override // qe.b
        public void dispose() {
            this.f22534q.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22535r) {
                return;
            }
            try {
                this.f22532o.run();
                this.f22535r = true;
                this.f22529b.onComplete();
                try {
                    this.f22533p.run();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    ff.a.onError(th2);
                }
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                onError(th3);
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22535r) {
                ff.a.onError(th2);
                return;
            }
            this.f22535r = true;
            try {
                this.f22531n.accept(th2);
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f22529b.onError(th2);
            try {
                this.f22533p.run();
            } catch (Throwable th4) {
                re.a.throwIfFatal(th4);
                ff.a.onError(th4);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22535r) {
                return;
            }
            try {
                this.f22530m.accept(t10);
                this.f22529b.onNext(t10);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                this.f22534q.dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22534q, bVar)) {
                this.f22534q = bVar;
                this.f22529b.onSubscribe(this);
            }
        }
    }

    public z(ne.o<T> oVar, se.f<? super T> fVar, se.f<? super Throwable> fVar2, se.a aVar, se.a aVar2) {
        super(oVar);
        this.f22525m = fVar;
        this.f22526n = fVar2;
        this.f22527o = aVar;
        this.f22528p = aVar2;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22525m, this.f22526n, this.f22527o, this.f22528p));
    }
}
