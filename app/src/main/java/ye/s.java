package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import ne.r;

/* compiled from: ObservableDelay.java */
/* loaded from: classes2.dex */
public final class s<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22350m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f22351n;

    /* renamed from: o, reason: collision with root package name */
    public final ne.r f22352o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f22353p;

    /* compiled from: ObservableDelay.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22354b;

        /* renamed from: m, reason: collision with root package name */
        public final long f22355m;

        /* renamed from: n, reason: collision with root package name */
        public final TimeUnit f22356n;

        /* renamed from: o, reason: collision with root package name */
        public final r.c f22357o;

        /* renamed from: p, reason: collision with root package name */
        public final boolean f22358p;

        /* renamed from: q, reason: collision with root package name */
        public qe.b f22359q;

        /* compiled from: ObservableDelay.java */
        /* renamed from: ye.s$a$a, reason: collision with other inner class name */
        public final class RunnableC0325a implements Runnable {
            public RunnableC0325a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                try {
                    aVar.f22354b.onComplete();
                } finally {
                    aVar.f22357o.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        public final class b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final Throwable f22361b;

            public b(Throwable th2) {
                this.f22361b = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                try {
                    aVar.f22354b.onError(this.f22361b);
                } finally {
                    aVar.f22357o.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        public final class c implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final T f22363b;

            public c(T t10) {
                this.f22363b = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22354b.onNext(this.f22363b);
            }
        }

        public a(ne.q<? super T> qVar, long j10, TimeUnit timeUnit, r.c cVar, boolean z10) {
            this.f22354b = qVar;
            this.f22355m = j10;
            this.f22356n = timeUnit;
            this.f22357o = cVar;
            this.f22358p = z10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22359q.dispose();
            this.f22357o.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22357o.schedule(new RunnableC0325a(), this.f22355m, this.f22356n);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22357o.schedule(new b(th2), this.f22358p ? this.f22355m : 0L, this.f22356n);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22357o.schedule(new c(t10), this.f22355m, this.f22356n);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22359q, bVar)) {
                this.f22359q = bVar;
                this.f22354b.onSubscribe(this);
            }
        }
    }

    public s(ne.o<T> oVar, long j10, TimeUnit timeUnit, ne.r rVar, boolean z10) {
        super(oVar);
        this.f22350m = j10;
        this.f22351n = timeUnit;
        this.f22352o = rVar;
        this.f22353p = z10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(this.f22353p ? qVar : new ef.e(qVar), this.f22350m, this.f22351n, this.f22352o.createWorker(), this.f22353p));
    }
}
