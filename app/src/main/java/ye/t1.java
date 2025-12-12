package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableTimeInterval.java */
/* loaded from: classes2.dex */
public final class t1<T> extends ye.a<T, gf.b<T>> {

    /* renamed from: m, reason: collision with root package name */
    public final ne.r f22407m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f22408n;

    /* compiled from: ObservableTimeInterval.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super gf.b<T>> f22409b;

        /* renamed from: m, reason: collision with root package name */
        public final TimeUnit f22410m;

        /* renamed from: n, reason: collision with root package name */
        public final ne.r f22411n;

        /* renamed from: o, reason: collision with root package name */
        public long f22412o;

        /* renamed from: p, reason: collision with root package name */
        public qe.b f22413p;

        public a(ne.q<? super gf.b<T>> qVar, TimeUnit timeUnit, ne.r rVar) {
            this.f22409b = qVar;
            this.f22411n = rVar;
            this.f22410m = timeUnit;
        }

        @Override // qe.b
        public void dispose() {
            this.f22413p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            this.f22409b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22409b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            ne.r rVar = this.f22411n;
            TimeUnit timeUnit = this.f22410m;
            long jNow = rVar.now(timeUnit);
            long j10 = this.f22412o;
            this.f22412o = jNow;
            this.f22409b.onNext(new gf.b(t10, jNow - j10, timeUnit));
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22413p, bVar)) {
                this.f22413p = bVar;
                this.f22412o = this.f22411n.now(this.f22410m);
                this.f22409b.onSubscribe(this);
            }
        }
    }

    public t1(ne.o<T> oVar, TimeUnit timeUnit, ne.r rVar) {
        super(oVar);
        this.f22407m = rVar;
        this.f22408n = timeUnit;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super gf.b<T>> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22408n, this.f22407m));
    }
}
