package io.reactivex.internal.operators.observable;

import cf.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import ne.o;
import ne.q;
import qe.b;
import se.n;
import ye.w0;

/* loaded from: classes2.dex */
public final class ObservableWithLatestFromMany<T, R> extends ye.a<T, R> {

    /* renamed from: m, reason: collision with root package name */
    public final o<?>[] f14465m;

    /* renamed from: n, reason: collision with root package name */
    public final Iterable<? extends o<?>> f14466n;

    /* renamed from: o, reason: collision with root package name */
    public final n<? super Object[], R> f14467o;

    public static final class WithLatestFromObserver<T, R> extends AtomicInteger implements q<T>, b {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super R> f14468b;

        /* renamed from: m, reason: collision with root package name */
        public final n<? super Object[], R> f14469m;

        /* renamed from: n, reason: collision with root package name */
        public final WithLatestInnerObserver[] f14470n;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReferenceArray<Object> f14471o;

        /* renamed from: p, reason: collision with root package name */
        public final AtomicReference<b> f14472p;

        /* renamed from: q, reason: collision with root package name */
        public final AtomicThrowable f14473q;

        /* renamed from: r, reason: collision with root package name */
        public volatile boolean f14474r;

        public WithLatestFromObserver(q<? super R> qVar, n<? super Object[], R> nVar, int i10) {
            this.f14468b = qVar;
            this.f14469m = nVar;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                withLatestInnerObserverArr[i11] = new WithLatestInnerObserver(this, i11);
            }
            this.f14470n = withLatestInnerObserverArr;
            this.f14471o = new AtomicReferenceArray<>(i10);
            this.f14472p = new AtomicReference<>();
            this.f14473q = new AtomicThrowable();
        }

        public final void a(int i10) {
            int i11 = 0;
            while (true) {
                WithLatestInnerObserver[] withLatestInnerObserverArr = this.f14470n;
                if (i11 >= withLatestInnerObserverArr.length) {
                    return;
                }
                if (i11 != i10) {
                    withLatestInnerObserverArr[i11].dispose();
                }
                i11++;
            }
        }

        @Override // qe.b
        public void dispose() {
            DisposableHelper.dispose(this.f14472p);
            for (WithLatestInnerObserver withLatestInnerObserver : this.f14470n) {
                withLatestInnerObserver.dispose();
            }
        }

        @Override // ne.q
        public void onComplete() {
            if (this.f14474r) {
                return;
            }
            this.f14474r = true;
            a(-1);
            f.onComplete(this.f14468b, this, this.f14473q);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            if (this.f14474r) {
                ff.a.onError(th2);
                return;
            }
            this.f14474r = true;
            a(-1);
            f.onError(this.f14468b, th2, this, this.f14473q);
        }

        @Override // ne.q
        public void onNext(T t10) {
            if (this.f14474r) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.f14471o;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i10 = 0;
            objArr[0] = t10;
            while (i10 < length) {
                Object obj = atomicReferenceArray.get(i10);
                if (obj == null) {
                    return;
                }
                i10++;
                objArr[i10] = obj;
            }
            try {
                f.onNext(this.f14468b, ue.a.requireNonNull(this.f14469m.apply(objArr), "combiner returned a null value"), this, this.f14473q);
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                dispose();
                onError(th2);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14472p, bVar);
        }
    }

    public static final class WithLatestInnerObserver extends AtomicReference<b> implements q<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* renamed from: b, reason: collision with root package name */
        public final WithLatestFromObserver<?, ?> f14475b;

        /* renamed from: m, reason: collision with root package name */
        public final int f14476m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f14477n;

        public WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i10) {
            this.f14475b = withLatestFromObserver;
            this.f14476m = i10;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            WithLatestFromObserver<?, ?> withLatestFromObserver = this.f14475b;
            int i10 = this.f14476m;
            if (this.f14477n) {
                withLatestFromObserver.getClass();
                return;
            }
            withLatestFromObserver.f14474r = true;
            withLatestFromObserver.a(i10);
            f.onComplete(withLatestFromObserver.f14468b, withLatestFromObserver, withLatestFromObserver.f14473q);
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            WithLatestFromObserver<?, ?> withLatestFromObserver = this.f14475b;
            int i10 = this.f14476m;
            withLatestFromObserver.f14474r = true;
            DisposableHelper.dispose(withLatestFromObserver.f14472p);
            withLatestFromObserver.a(i10);
            f.onError(withLatestFromObserver.f14468b, th2, withLatestFromObserver, withLatestFromObserver.f14473q);
        }

        @Override // ne.q
        public void onNext(Object obj) {
            if (!this.f14477n) {
                this.f14477n = true;
            }
            this.f14475b.f14471o.set(this.f14476m, obj);
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public final class a implements n<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // se.n
        public R apply(T t10) throws Exception {
            return (R) ue.a.requireNonNull(ObservableWithLatestFromMany.this.f14467o.apply(new Object[]{t10}), "The combiner returned a null value");
        }
    }

    public ObservableWithLatestFromMany(o<T> oVar, o<?>[] oVarArr, n<? super Object[], R> nVar) {
        super(oVar);
        this.f14465m = oVarArr;
        this.f14466n = null;
        this.f14467o = nVar;
    }

    @Override // ne.k
    public void subscribeActual(q<? super R> qVar) {
        int length;
        o<?>[] oVarArr = this.f14465m;
        if (oVarArr == null) {
            oVarArr = new o[8];
            try {
                length = 0;
                for (o<?> oVar : this.f14466n) {
                    if (length == oVarArr.length) {
                        oVarArr = (o[]) Arrays.copyOf(oVarArr, (length >> 1) + length);
                    }
                    int i10 = length + 1;
                    oVarArr[length] = oVar;
                    length = i10;
                }
            } catch (Throwable th2) {
                re.a.throwIfFatal(th2);
                EmptyDisposable.error(th2, qVar);
                return;
            }
        } else {
            length = oVarArr.length;
        }
        if (length == 0) {
            new w0(this.f22058b, new a()).subscribeActual(qVar);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(qVar, this.f14467o, length);
        qVar.onSubscribe(withLatestFromObserver);
        WithLatestInnerObserver[] withLatestInnerObserverArr = withLatestFromObserver.f14470n;
        AtomicReference<b> atomicReference = withLatestFromObserver.f14472p;
        for (int i11 = 0; i11 < length && !DisposableHelper.isDisposed(atomicReference.get()) && !withLatestFromObserver.f14474r; i11++) {
            oVarArr[i11].subscribe(withLatestInnerObserverArr[i11]);
        }
        this.f22058b.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(o<T> oVar, Iterable<? extends o<?>> iterable, n<? super Object[], R> nVar) {
        super(oVar);
        this.f14465m = null;
        this.f14466n = iterable;
        this.f14467o = nVar;
    }
}
