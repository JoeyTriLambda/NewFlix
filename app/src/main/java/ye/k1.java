package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes2.dex */
public final class k1<T> extends ne.s<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ne.o<? extends T> f22210a;

    /* renamed from: b, reason: collision with root package name */
    public final T f22211b;

    /* compiled from: ObservableSingleSingle.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final ne.t<? super T> f22212b;

        /* renamed from: m, reason: collision with root package name */
        public final T f22213m;

        /* renamed from: n, reason: collision with root package name */
        public qe.b f22214n;

        /* renamed from: o, reason: collision with root package name */
        public T f22215o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f22216p;

        public a(ne.t<? super T> tVar, T t10) {
            this.f22212b = tVar;
            this.f22213m = t10;
        }

        @Override // qe.b
        public void dispose() {
            this.f22214n.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f22216p) {
                return;
            }
            this.f22216p = true;
            T t10 = this.f22215o;
            this.f22215o = null;
            if (t10 == null) {
                t10 = this.f22213m;
            }
            ne.t<? super T> tVar = this.f22212b;
            if (t10 != null) {
                tVar.onSuccess(t10);
            } else {
                tVar.onError(new NoSuchElementException());
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f22216p) {
                ff.a.onError(th2);
            } else {
                this.f22216p = true;
                this.f22212b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f22216p) {
                return;
            }
            if (this.f22215o == null) {
                this.f22215o = t10;
                return;
            }
            this.f22216p = true;
            this.f22214n.dispose();
            this.f22212b.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22214n, bVar)) {
                this.f22214n = bVar;
                this.f22212b.onSubscribe(this);
            }
        }
    }

    public k1(ne.o<? extends T> oVar, T t10) {
        this.f22210a = oVar;
        this.f22211b = t10;
    }

    @Override // ne.s
    public void subscribeActual(ne.t<? super T> tVar) {
        this.f22210a.subscribe(new a(tVar, this.f22211b));
    }
}
