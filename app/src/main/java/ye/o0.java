package ye;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* compiled from: ObservableGenerate.java */
/* loaded from: classes2.dex */
public final class o0<T, S> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<S> f22299b;

    /* renamed from: m, reason: collision with root package name */
    public final se.c<S, ne.d<T>, S> f22300m;

    /* renamed from: n, reason: collision with root package name */
    public final se.f<? super S> f22301n;

    /* compiled from: ObservableGenerate.java */
    public static final class a<T, S> implements ne.d<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22302b;

        /* renamed from: m, reason: collision with root package name */
        public final se.c<S, ? super ne.d<T>, S> f22303m;

        /* renamed from: n, reason: collision with root package name */
        public final se.f<? super S> f22304n;

        /* renamed from: o, reason: collision with root package name */
        public S f22305o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f22306p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f22307q;

        public a(ne.q<? super T> qVar, se.c<S, ? super ne.d<T>, S> cVar, se.f<? super S> fVar, S s10) {
            this.f22302b = qVar;
            this.f22303m = cVar;
            this.f22304n = fVar;
            this.f22305o = s10;
        }

        public final void a(S s10) {
            try {
                this.f22304n.accept(s10);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                ff.a.onError(th2);
            }
        }

        @Override // qe.b
        public void dispose() {
            this.f22306p = true;
        }

        public void onError(Throwable th2) {
            if (this.f22307q) {
                ff.a.onError(th2);
                return;
            }
            if (th2 == null) {
                th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f22307q = true;
            this.f22302b.onError(th2);
        }

        public void run() {
            S sApply = this.f22305o;
            if (this.f22306p) {
                this.f22305o = null;
                a(sApply);
                return;
            }
            se.c<S, ? super ne.d<T>, S> cVar = this.f22303m;
            while (!this.f22306p) {
                try {
                    sApply = cVar.apply(sApply, this);
                    if (this.f22307q) {
                        this.f22306p = true;
                        this.f22305o = null;
                        a(sApply);
                        return;
                    }
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    this.f22305o = null;
                    this.f22306p = true;
                    onError(th2);
                    a(sApply);
                    return;
                }
            }
            this.f22305o = null;
            a(sApply);
        }
    }

    public o0(Callable<S> callable, se.c<S, ne.d<T>, S> cVar, se.f<? super S> fVar) {
        this.f22299b = callable;
        this.f22300m = cVar;
        this.f22301n = fVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        try {
            a aVar = new a(qVar, this.f22300m, this.f22301n, this.f22299b.call());
            qVar.onSubscribe(aVar);
            aVar.run();
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            EmptyDisposable.error(th2, qVar);
        }
    }
}
