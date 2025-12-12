package ye;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* compiled from: ObservableDetach.java */
/* loaded from: classes2.dex */
public final class v<T> extends ye.a<T, T> {

    /* compiled from: ObservableDetach.java */
    public static final class a<T> implements ne.q<T>, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public ne.q<? super T> f22429b;

        /* renamed from: m, reason: collision with root package name */
        public qe.b f22430m;

        public a(ne.q<? super T> qVar) {
            this.f22429b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            qe.b bVar = this.f22430m;
            this.f22430m = EmptyComponent.f14538b;
            this.f22429b = EmptyComponent.asObserver();
            bVar.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            ne.q<? super T> qVar = this.f22429b;
            this.f22430m = EmptyComponent.f14538b;
            this.f22429b = EmptyComponent.asObserver();
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            ne.q<? super T> qVar = this.f22429b;
            this.f22430m = EmptyComponent.f14538b;
            this.f22429b = EmptyComponent.asObserver();
            qVar.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f22429b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            if (DisposableHelper.validate(this.f22430m, bVar)) {
                this.f22430m = bVar;
                this.f22429b.onSubscribe(this);
            }
        }
    }

    public v(ne.o<T> oVar) {
        super(oVar);
    }

    @Override // ne.k
    public void subscribeActual(ne.q<? super T> qVar) {
        this.f22058b.subscribe(new a(qVar));
    }
}
