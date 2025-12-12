package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import ne.k;
import ne.o;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObservableAmb<T> extends k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final o<? extends T>[] f13711b;

    /* renamed from: m, reason: collision with root package name */
    public final Iterable<? extends o<? extends T>> f13712m;

    public static final class AmbInnerObserver<T> extends AtomicReference<b> implements q<T> {
        private static final long serialVersionUID = -1185974347409665484L;

        /* renamed from: b, reason: collision with root package name */
        public final a<T> f13713b;

        /* renamed from: m, reason: collision with root package name */
        public final int f13714m;

        /* renamed from: n, reason: collision with root package name */
        public final q<? super T> f13715n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f13716o;

        public AmbInnerObserver(a<T> aVar, int i10, q<? super T> qVar) {
            this.f13713b = aVar;
            this.f13714m = i10;
            this.f13715n = qVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // ne.q
        public void onComplete() {
            boolean z10 = this.f13716o;
            q<? super T> qVar = this.f13715n;
            if (z10) {
                qVar.onComplete();
            } else if (this.f13713b.win(this.f13714m)) {
                this.f13716o = true;
                qVar.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            boolean z10 = this.f13716o;
            q<? super T> qVar = this.f13715n;
            if (z10) {
                qVar.onError(th2);
            } else if (!this.f13713b.win(this.f13714m)) {
                ff.a.onError(th2);
            } else {
                this.f13716o = true;
                qVar.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            boolean z10 = this.f13716o;
            q<? super T> qVar = this.f13715n;
            if (z10) {
                qVar.onNext(t10);
            } else if (!this.f13713b.win(this.f13714m)) {
                get().dispose();
            } else {
                this.f13716o = true;
                qVar.onNext(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class a<T> implements b {

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f13717b;

        /* renamed from: m, reason: collision with root package name */
        public final AmbInnerObserver<T>[] f13718m;

        /* renamed from: n, reason: collision with root package name */
        public final AtomicInteger f13719n = new AtomicInteger();

        public a(q<? super T> qVar, int i10) {
            this.f13717b = qVar;
            this.f13718m = new AmbInnerObserver[i10];
        }

        @Override // qe.b
        public void dispose() {
            AtomicInteger atomicInteger = this.f13719n;
            if (atomicInteger.get() != -1) {
                atomicInteger.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.f13718m) {
                    ambInnerObserver.dispose();
                }
            }
        }

        public void subscribe(o<? extends T>[] oVarArr) {
            q<? super T> qVar;
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f13718m;
            int length = ambInnerObserverArr.length;
            int i10 = 0;
            while (true) {
                qVar = this.f13717b;
                if (i10 >= length) {
                    break;
                }
                int i11 = i10 + 1;
                ambInnerObserverArr[i10] = new AmbInnerObserver<>(this, i11, qVar);
                i10 = i11;
            }
            AtomicInteger atomicInteger = this.f13719n;
            atomicInteger.lazySet(0);
            qVar.onSubscribe(this);
            for (int i12 = 0; i12 < length && atomicInteger.get() == 0; i12++) {
                oVarArr[i12].subscribe(ambInnerObserverArr[i12]);
            }
        }

        public boolean win(int i10) {
            AtomicInteger atomicInteger = this.f13719n;
            int i11 = atomicInteger.get();
            int i12 = 0;
            if (i11 != 0) {
                return i11 == i10;
            }
            if (!atomicInteger.compareAndSet(0, i10)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f13718m;
            int length = ambInnerObserverArr.length;
            while (i12 < length) {
                int i13 = i12 + 1;
                if (i13 != i10) {
                    ambInnerObserverArr[i12].dispose();
                }
                i12 = i13;
            }
            return true;
        }
    }

    public ObservableAmb(o<? extends T>[] oVarArr, Iterable<? extends o<? extends T>> iterable) {
        this.f13711b = oVarArr;
        this.f13712m = iterable;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        int length;
        o<? extends T>[] oVarArr = this.f13711b;
        if (oVarArr == null) {
            oVarArr = new o[8];
            try {
                length = 0;
                for (o<? extends T> oVar : this.f13712m) {
                    if (oVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), qVar);
                        return;
                    }
                    if (length == oVarArr.length) {
                        o<? extends T>[] oVarArr2 = new o[(length >> 2) + length];
                        System.arraycopy(oVarArr, 0, oVarArr2, 0, length);
                        oVarArr = oVarArr2;
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
            EmptyDisposable.complete(qVar);
        } else if (length == 1) {
            oVarArr[0].subscribe(qVar);
        } else {
            new a(qVar, length).subscribe(oVarArr);
        }
    }
}
