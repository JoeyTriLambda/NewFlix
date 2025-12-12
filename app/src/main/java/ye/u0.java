package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableLastSingle.java */
/* loaded from: classes2.dex */
public final class u0<T> extends ne.s<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<T> f22419a;

    /* renamed from: b, reason: collision with root package name */
    public final T f22420b;

    /* compiled from: ObservableLastSingle.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super T> f22421b;

        /* renamed from: m, reason: collision with root package name */
        public final T f22422m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22423n;

        /* renamed from: o, reason: collision with root package name */
        public T f22424o;

        public a(ne.t<? super T> tVar, T t10) {
            this.f22421b = tVar;
            this.f22422m = t10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22423n.dispose();
            this.f22423n = DisposableHelper.f13533b;
        }

        @Override // ne.q
        public void onComplete() {
            this.f22423n = DisposableHelper.f13533b;
            T t10 = this.f22424o;
            ne.t<? super T> tVar = this.f22421b;
            if (t10 != null) {
                this.f22424o = null;
                tVar.onSuccess(t10);
                return;
            }
            T t11 = this.f22422m;
            if (t11 != null) {
                tVar.onSuccess(t11);
            } else {
                tVar.onError(new NoSuchElementException());
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f22423n = DisposableHelper.f13533b;
            this.f22424o = null;
            this.f22421b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22424o = t10;
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22423n, bVar)) {
                this.f22423n = bVar;
                this.f22421b.onSubscribe(this);
            }
        }
    }

    public u0(ne.o<T> oVar, T t10) {
        this.f22419a = oVar;
        this.f22420b = t10;
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super T> tVar) {
        this.f22419a.subscribe(new a(tVar, this.f22420b));
    }
}
