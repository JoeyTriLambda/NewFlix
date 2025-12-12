package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableElementAt.java */
/* loaded from: classes2.dex */
public final class b0<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22073m;

    /* renamed from: n, reason: collision with root package name */
    public final T f22074n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f22075o;

    /* compiled from: ObservableElementAt.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22076b;

        /* renamed from: m, reason: collision with root package name */
        public final long f22077m;

        /* renamed from: n, reason: collision with root package name */
        public final T f22078n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f22079o;

        /* renamed from: p, reason: collision with root package name */
        public qe.b f22080p;

        /* renamed from: q, reason: collision with root package name */
        public long f22081q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f22082r;

        public a(ne.q<? super T> qVar, long j10, T t10, boolean z10) {
            this.f22076b = qVar;
            this.f22077m = j10;
            this.f22078n = t10;
            this.f22079o = z10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22080p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22082r) {
                return;
            }
            this.f22082r = true;
            ne.q<? super T> qVar = this.f22076b;
            T t10 = this.f22078n;
            if (t10 == null && this.f22079o) {
                qVar.onError(new NoSuchElementException());
                return;
            }
            if (t10 != null) {
                qVar.onNext(t10);
            }
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22082r) {
                ff.a.onError(th2);
            } else {
                this.f22082r = true;
                this.f22076b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22082r) {
                return;
            }
            long j10 = this.f22081q;
            if (j10 != this.f22077m) {
                this.f22081q = j10 + 1;
                return;
            }
            this.f22082r = true;
            this.f22080p.dispose();
            ne.q<? super T> qVar = this.f22076b;
            qVar.onNext(t10);
            qVar.onComplete();
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22080p, bVar)) {
                this.f22080p = bVar;
                this.f22076b.onSubscribe(this);
            }
        }
    }

    public b0(ne.o<T> oVar, long j10, T t10, boolean z10) {
        super(oVar);
        this.f22073m = j10;
        this.f22074n = t10;
        this.f22075o = z10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22073m, this.f22074n, this.f22075o));
    }
}
