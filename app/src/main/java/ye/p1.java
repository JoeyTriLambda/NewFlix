package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;

/* compiled from: ObservableTake.java */
/* loaded from: classes2.dex */
public final class p1<T> extends ye.a<T, T> {

    /* renamed from: m, reason: collision with root package name */
    public final long f22319m;

    /* compiled from: ObservableTake.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22320b;

        /* renamed from: m, reason: collision with root package name */
        public boolean f22321m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22322n;

        /* renamed from: o, reason: collision with root package name */
        public long f22323o;

        public a(ne.q<? super T> qVar, long j10) {
            this.f22320b = qVar;
            this.f22323o = j10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22322n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22321m) {
                return;
            }
            this.f22321m = true;
            this.f22322n.dispose();
            this.f22320b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22321m) {
                ff.a.onError(th2);
                return;
            }
            this.f22321m = true;
            this.f22322n.dispose();
            this.f22320b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22321m) {
                return;
            }
            long j10 = this.f22323o;
            long j11 = j10 - 1;
            this.f22323o = j11;
            if (j10 > 0) {
                boolean z10 = j11 == 0;
                this.f22320b.onNext(t10);
                if (z10) {
                    onComplete();
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22322n, bVar)) {
                this.f22322n = bVar;
                long j10 = this.f22323o;
                ne.q<? super T> qVar = this.f22320b;
                if (j10 != 0) {
                    qVar.onSubscribe(this);
                    return;
                }
                this.f22321m = true;
                bVar.dispose();
                EmptyDisposable.complete(qVar);
            }
        }
    }

    public p1(ne.o<T> oVar, long j10) {
        super(oVar);
        this.f22319m = j10;
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar, this.f22319m));
    }
}
