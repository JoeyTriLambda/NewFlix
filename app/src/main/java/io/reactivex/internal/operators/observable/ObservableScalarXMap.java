package io.reactivex.internal.operators.observable;

// REMOVED: Malware import
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import ne.k;
import ne.o;
import ne.q;
import se.n;
import ve.b;

/* loaded from: classes2.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements b<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14215b;

        /* renamed from: m, reason: collision with root package name */
        public final T f14216m;

        public ScalarDisposable(q<? super T> qVar, T t10) {
            this.f14215b = qVar;
            this.f14216m = t10;
        }

        @Override // ve.f
        public void clear() {
            lazySet(3);
        }

        @Override // qe.b
        public void dispose() {
            set(3);
        }

        @Override // ve.f
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // ve.f
        public boolean offer(T t10) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // ve.f
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f14216m;
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                T t10 = this.f14216m;
                q<? super T> qVar = this.f14215b;
                qVar.onNext(t10);
                if (get() == 2) {
                    lazySet(3);
                    qVar.onComplete();
                }
            }
        }
    }

    public static final class a<T, R> extends k<R> {

        /* renamed from: b, reason: collision with root package name */
        public final T f14217b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super T, ? extends o<? extends R>> f14218m;

        public a(T t10, n<? super T, ? extends o<? extends R>> nVar) {
            this.f14217b = t10;
            this.f14218m = nVar;
        }

        @Override // ne.k
        public void subscribeActual(q<? super R> qVar) {
            try {
                o oVar = (o) ue.a.requireNonNull(this.f14218m.apply(this.f14217b), "The mapper returned a null ObservableSource");
                if (!(oVar instanceof Callable)) {
                    oVar.subscribe(qVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) oVar).call();
                    if (objCall == null) {
                        EmptyDisposable.complete(qVar);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(qVar, objCall);
                    qVar.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    EmptyDisposable.error(th2, qVar);
                }
            } catch (Throwable th3) {
                EmptyDisposable.error(th3, qVar);
            }
        }
    }

    public static <T, U> k<U> scalarXMap(T t10, n<? super T, ? extends o<? extends U>> nVar) {
        return ff.a.onAssembly(new a(t10, nVar));
    }

    public static <T, R> boolean tryScalarXMapSubscribe(o<T> oVar, q<? super R> qVar, n<? super T, ? extends o<? extends R>> nVar) {
        if (!(oVar instanceof Callable)) {
            return false;
        }
        try {
            MProxy mProxy = (Object) ((Callable) oVar).call();
            if (mProxy == null) {
                EmptyDisposable.complete(qVar);
                return true;
            }
            try {
                o oVar2 = (o) ue.a.requireNonNull(nVar.apply(mProxy), "The mapper returned a null ObservableSource");
                if (oVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) oVar2).call();
                        if (objCall == null) {
                            EmptyDisposable.complete(qVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(qVar, objCall);
                        qVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        EmptyDisposable.error(th2, qVar);
                        return true;
                    }
                } else {
                    oVar2.subscribe(qVar);
                }
                return true;
            } catch (Throwable th3) {
                re.a.throwIfFatal(th3);
                EmptyDisposable.error(th3, qVar);
                return true;
            }
        } catch (Throwable th4) {
            re.a.throwIfFatal(th4);
            EmptyDisposable.error(th4, qVar);
            return true;
        }
    }
}
