package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableDebounce.java */
/* loaded from: classes2.dex */
public final class q<T, U> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final se.n<? super T, ? extends ne.o<U>> f22324m;

    /* compiled from: ObservableDebounce.java */
    public static final class a<T, U> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22325b;

        /* renamed from: m, reason: collision with root package name */
        public final se.n<? super T, ? extends ne.o<U>> f22326m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22327n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<qe.b> f22328o = new AtomicReference<>();

        /* renamed from: p, reason: collision with root package name */
        public volatile long f22329p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f22330q;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: ye.q$a$a, reason: collision with other inner class name */
        public static final class C0324a<T, U> extends ef.c<U> {

            /* renamed from: m, reason: collision with root package name */
            public final a<T, U> f22331m;

            /* renamed from: n, reason: collision with root package name */
            public final long f22332n;

            /* renamed from: o, reason: collision with root package name */
            public final T f22333o;

            /* renamed from: p, reason: collision with root package name */
            public boolean f22334p;

            /* renamed from: q, reason: collision with root package name */
            public final AtomicBoolean f22335q = new AtomicBoolean();

            public C0324a(a<T, U> aVar, long j10, T t10) {
                this.f22331m = aVar;
                this.f22332n = j10;
                this.f22333o = t10;
            }

            public final void a() {
                if (this.f22335q.compareAndSet(false, true)) {
                    a<T, U> aVar = this.f22331m;
                    long j10 = this.f22332n;
                    T t10 = this.f22333o;
                    if (j10 == aVar.f22329p) {
                        aVar.f22325b.onNext(t10);
                    }
                }
            }

            @Override // ne.q
            public void onComplete() {
                if (this.f22334p) {
                    return;
                }
                this.f22334p = true;
                a();
            }

            @Override // ne.q
            public void onError(Throwable th2) {
                if (this.f22334p) {
                    ff.a.onError(th2);
                } else {
                    this.f22334p = true;
                    this.f22331m.onError(th2);
                }
            }

            @Override // ne.q
            public void onNext(U u10) {
                if (this.f22334p) {
                    return;
                }
                this.f22334p = true;
                dispose();
                a();
            }
        }

        public a(ef.e eVar, se.n nVar) {
            this.f22325b = eVar;
            this.f22326m = nVar;
        }

        @Override // qe.b
        public void dispose() {
            this.f22327n.dispose();
            DisposableHelper.dispose(this.f22328o);
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22330q) {
                return;
            }
            this.f22330q = true;
            AtomicReference<qe.b> atomicReference = this.f22328o;
            qe.b bVar = atomicReference.get();
            if (bVar != DisposableHelper.f13533b) {
                C0324a c0324a = (C0324a) bVar;
                if (c0324a != null) {
                    c0324a.a();
                }
                DisposableHelper.dispose(atomicReference);
                this.f22325b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f22328o);
            this.f22325b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10;
            if (this.f22330q) {
                return;
            }
            long j10 = this.f22329p + 1;
            this.f22329p = j10;
            qe.b bVar = this.f22328o.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                ne.o oVar = (ne.o) ue.a.requireNonNull(this.f22326m.apply(t10), "The ObservableSource supplied is null");
                C0324a c0324a = new C0324a(this, j10, t10);
                AtomicReference<qe.b> atomicReference = this.f22328o;
                while (true) {
                    if (atomicReference.compareAndSet(bVar, c0324a)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != bVar) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    oVar.subscribe(c0324a);
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                dispose();
                this.f22325b.onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22327n, bVar)) {
                this.f22327n = bVar;
                this.f22325b.onSubscribe(this);
            }
        }
    }

    public q(ne.o<T> oVar, se.n<? super T, ? extends ne.o<U>> nVar) {
        super(oVar);
        this.f22324m = nVar;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(new ef.e(qVar), this.f22324m));
    }
}
