package io.reactivex.internal.operators.observable;

import ef.e;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;
import se.c;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFrom<T, U, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final c<? super T, ? super U, ? extends R> f14458m;

    /* renamed from: n, reason: collision with root package name */
    public final o<? extends U> f14459n;

    public static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements q<T>, b {
        private static final long serialVersionUID = -312246233408980075L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14460b;

        /* renamed from: m, reason: collision with root package name */
        public final c<? super T, ? super U, ? extends R> f14461m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicReference<b> f14462n = new AtomicReference<>();

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<b> f14463o = new AtomicReference<>();

        public WithLatestFromObserver(e eVar, c cVar) {
            this.f14460b = eVar;
            this.f14461m = cVar;
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14462n);
            DisposableHelper.dispose(this.f14463o);
        }

        @Override // ne.q
        public void onComplete() {
            DisposableHelper.dispose(this.f14463o);
            this.f14460b.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f14463o);
            this.f14460b.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            q<? super R> qVar = this.f14460b;
            U u10 = get();
            if (u10 != null) {
                try {
                    qVar.onNext((Object) ue.a.requireNonNull(this.f14461m.apply(t10, u10), "The combiner returned a null value"));
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    dispose();
                    qVar.onError(th2);
                }
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14462n, bVar);
        }

        public void otherError(Throwable th2) {
            DisposableHelper.dispose(this.f14462n);
            this.f14460b.onError(th2);
        }

        public boolean setOther(b bVar) {
            return DisposableHelper.setOnce(this.f14463o, bVar);
        }
    }

    public ObservableWithLatestFrom(o<T> oVar, c<? super T, ? super U, ? extends R> cVar, o<? extends U> oVar2) {
        super(oVar);
        this.f14458m = cVar;
        this.f14459n = oVar2;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        e eVar = new e(qVar);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(eVar, this.f14458m);
        eVar.onSubscribe(withLatestFromObserver);
        this.f14459n.subscribe(new a(withLatestFromObserver));
        this.f22058b.subscribe(withLatestFromObserver);
    }

    public final class a implements q<U> {

        /* renamed from: b, reason: collision with root package name */
        public final WithLatestFromObserver<T, U, R> f14464b;

        public a(WithLatestFromObserver withLatestFromObserver) {
            this.f14464b = withLatestFromObserver;
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14464b.otherError(th2);
        }

        @Override // ne.q
        public void onNext(U u10) {
            this.f14464b.lazySet(u10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            this.f14464b.setOther(bVar);
        }

        @Override // ne.q
        public void onComplete() {
        }
    }
}
