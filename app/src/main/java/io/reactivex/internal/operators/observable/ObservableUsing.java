package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import ne.k;
import ne.o;
import ne.q;
import qe.b;
import se.f;
import se.n;

/* loaded from: classes2.dex */
public final class ObservableUsing<T, D> extends k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final Callable<? extends D> f14397b;

    /* renamed from: m, reason: collision with root package name */
    public final n<? super D, ? extends o<? extends T>> f14398m;

    /* renamed from: n, reason: collision with root package name */
    public final f<? super D> f14399n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f14400o;

    public static final class UsingObserver<T, D> extends AtomicBoolean implements q<T>, b {
        private static final long serialVersionUID = 5904473792286235046L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14401b;

        /* renamed from: m, reason: collision with root package name */
        public final D f14402m;

        /* renamed from: n, reason: collision with root package name */
        public final f<? super D> f14403n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f14404o;

        /* renamed from: p, reason: collision with root package name */
        public b f14405p;

        public UsingObserver(q<? super T> qVar, D d10, f<? super D> fVar, boolean z10) {
            this.f14401b = qVar;
            this.f14402m = d10;
            this.f14403n = fVar;
            this.f14404o = z10;
        }

        public final void a() {
            if (compareAndSet(false, true)) {
                try {
                    this.f14403n.accept(this.f14402m);
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    ff.a.onError(th2);
                }
            }
        }

        @Override // qe.b
        public void dispose() {
            a();
            this.f14405p.dispose();
        }

        @Override // ne.q
        public void onComplete() {
            boolean z10 = this.f14404o;
            q<? super T> qVar = this.f14401b;
            if (!z10) {
                qVar.onComplete();
                this.f14405p.dispose();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f14403n.accept(this.f14402m);
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    qVar.onError(th2);
                    return;
                }
            }
            this.f14405p.dispose();
            qVar.onComplete();
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            boolean z10 = this.f14404o;
            q<? super T> qVar = this.f14401b;
            if (!z10) {
                qVar.onError(th2);
                this.f14405p.dispose();
                a();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f14403n.accept(this.f14402m);
                } catch (Throwable th3) {
                    re.a.throwIfFatal(th3);
                    th2 = new CompositeException(th2, th3);
                }
            }
            this.f14405p.dispose();
            qVar.onError(th2);
        }

        @Override // ne.q
        public void onNext(T t10) {
            this.f14401b.onNext(t10);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f14405p, bVar)) {
                this.f14405p = bVar;
                this.f14401b.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, n<? super D, ? extends o<? extends T>> nVar, f<? super D> fVar, boolean z10) {
        this.f14397b = callable;
        this.f14398m = nVar;
        this.f14399n = fVar;
        this.f14400o = z10;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        f<? super D> fVar = this.f14399n;
        try {
            D dCall = this.f14397b.call();
            try {
                ((o) ue.a.requireNonNull(this.f14398m.apply(dCall), "The sourceSupplier returned a null ObservableSource")).subscribe(new UsingObserver(qVar, dCall, fVar, this.f14400o));
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                try {
                    fVar.accept(dCall);
                    EmptyDisposable.error(th2, qVar);
                } catch (Throwable th3) {
                    re.a.throwIfFatal(th3);
                    EmptyDisposable.error(new CompositeException(th2, th3), qVar);
                }
            }
        } catch (Throwable th4) {
            re.a.throwIfFatal(th4);
            EmptyDisposable.error(th4, qVar);
        }
    }
}
