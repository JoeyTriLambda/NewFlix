package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import se.f;
import ye.c1;

/* loaded from: classes2.dex */
public final class ObservablePublish<T> extends df.a<T> implements c1<T> {

    /* renamed from: b, reason: collision with root package name */
    public final o<T> f14066b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<a<T>> f14067m;

    /* renamed from: n, reason: collision with root package name */
    public final o<T> f14068n;

    public static final class InnerDisposable<T> extends AtomicReference<Object> implements qe.b {
        private static final long serialVersionUID = -1100270633763673112L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14069b;

        public InnerDisposable(q<? super T> qVar) {
            this.f14069b = qVar;
        }

        @Override // qe.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((a) andSet).a(this);
        }
    }

    public static final class a<T> implements q<T>, qe.b {

        /* renamed from: p, reason: collision with root package name */
        public static final InnerDisposable[] f14070p = new InnerDisposable[0];

        /* renamed from: q, reason: collision with root package name */
        public static final InnerDisposable[] f14071q = new InnerDisposable[0];

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference<a<T>> f14072b;

        /* renamed from: o, reason: collision with root package name */
        public final AtomicReference<qe.b> f14075o = new AtomicReference<>();

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<InnerDisposable<T>[]> f14073m = new AtomicReference<>(f14070p);

        /* renamed from: n, reason: collision with root package name */
        public final AtomicBoolean f14074n = new AtomicBoolean();

        public a(AtomicReference<a<T>> atomicReference) {
            this.f14072b = atomicReference;
        }

        public final void a(InnerDisposable<T> innerDisposable) {
            boolean z10;
            InnerDisposable<T>[] innerDisposableArr;
            do {
                AtomicReference<InnerDisposable<T>[]> atomicReference = this.f14073m;
                InnerDisposable<T>[] innerDisposableArr2 = atomicReference.get();
                int length = innerDisposableArr2.length;
                if (length == 0) {
                    return;
                }
                z10 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (innerDisposableArr2[i10].equals(innerDisposable)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr = f14070p;
                } else {
                    InnerDisposable<T>[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr2, 0, innerDisposableArr3, 0, i10);
                    System.arraycopy(innerDisposableArr2, i10 + 1, innerDisposableArr3, i10, (length - i10) - 1);
                    innerDisposableArr = innerDisposableArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerDisposableArr2, innerDisposableArr)) {
                        z10 = true;
                        break;
                    } else if (atomicReference.get() != innerDisposableArr2) {
                        break;
                    }
                }
            } while (!z10);
        }

        @Override // qe.b
        public void dispose() {
            AtomicReference<a<T>> atomicReference;
            AtomicReference<InnerDisposable<T>[]> atomicReference2 = this.f14073m;
            InnerDisposable<T>[] innerDisposableArr = f14071q;
            if (atomicReference2.getAndSet(innerDisposableArr) != innerDisposableArr) {
                do {
                    atomicReference = this.f14072b;
                    if (atomicReference.compareAndSet(this, null)) {
                        break;
                    }
                } while (atomicReference.get() == this);
                DisposableHelper.dispose(this.f14075o);
            }
        }

        public boolean isDisposed() {
            return this.f14073m.get() == f14071q;
        }

        @Override // ne.q
        public void onComplete() {
            AtomicReference<a<T>> atomicReference;
            do {
                atomicReference = this.f14072b;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            for (InnerDisposable<T> innerDisposable : this.f14073m.getAndSet(f14071q)) {
                innerDisposable.f14069b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            AtomicReference<a<T>> atomicReference;
            do {
                atomicReference = this.f14072b;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            InnerDisposable<T>[] andSet = this.f14073m.getAndSet(f14071q);
            if (andSet.length == 0) {
                ff.a.onError(th2);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.f14069b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            for (InnerDisposable<T> innerDisposable : this.f14073m.get()) {
                innerDisposable.f14069b.onNext(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(qe.b bVar) {
            DisposableHelper.setOnce(this.f14075o, bVar);
        }
    }

    public static final class b<T> implements o<T> {

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference<a<T>> f14076b;

        public b(AtomicReference<a<T>> atomicReference) {
            this.f14076b = atomicReference;
        }

        @Override // ne.o
        public void subscribe(q<? super T> qVar) {
            boolean z10;
            a<T> aVar;
            boolean z11;
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(qVar);
            qVar.onSubscribe(innerDisposable);
            while (true) {
                AtomicReference<a<T>> atomicReference = this.f14076b;
                a<T> aVar2 = atomicReference.get();
                boolean z12 = false;
                if (aVar2 == null || aVar2.isDisposed()) {
                    a<T> aVar3 = new a<>(atomicReference);
                    while (true) {
                        if (atomicReference.compareAndSet(aVar2, aVar3)) {
                            z10 = true;
                            break;
                        } else if (atomicReference.get() != aVar2) {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        aVar = aVar3;
                    } else {
                        continue;
                    }
                } else {
                    aVar = aVar2;
                }
                while (true) {
                    AtomicReference<InnerDisposable<T>[]> atomicReference2 = aVar.f14073m;
                    InnerDisposable<T>[] innerDisposableArr = atomicReference2.get();
                    if (innerDisposableArr == a.f14071q) {
                        break;
                    }
                    int length = innerDisposableArr.length;
                    InnerDisposable<T>[] innerDisposableArr2 = new InnerDisposable[length + 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                    innerDisposableArr2[length] = innerDisposable;
                    while (true) {
                        if (atomicReference2.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                            z11 = true;
                            break;
                        } else if (atomicReference2.get() != innerDisposableArr) {
                            z11 = false;
                            break;
                        }
                    }
                    if (z11) {
                        z12 = true;
                        break;
                    }
                }
                if (z12) {
                    break;
                }
            }
            if (innerDisposable.compareAndSet(null, aVar)) {
                return;
            }
            aVar.a(innerDisposable);
        }
    }

    public ObservablePublish(b bVar, o oVar, AtomicReference atomicReference) {
        this.f14068n = bVar;
        this.f14066b = oVar;
        this.f14067m = atomicReference;
    }

    public static <T> df.a<T> create(o<T> oVar) {
        AtomicReference atomicReference = new AtomicReference();
        return ff.a.onAssembly((df.a) new ObservablePublish(new b(atomicReference), oVar, atomicReference));
    }

    @Override // df.a
    public void connect(f<? super qe.b> fVar) {
        a<T> aVar;
        boolean z10;
        boolean z11;
        while (true) {
            AtomicReference<a<T>> atomicReference = this.f14067m;
            aVar = atomicReference.get();
            z10 = false;
            if (aVar != null && !aVar.isDisposed()) {
                break;
            }
            a<T> aVar2 = new a<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(aVar, aVar2)) {
                    z11 = true;
                    break;
                } else if (atomicReference.get() != aVar) {
                    z11 = false;
                    break;
                }
            }
            if (z11) {
                aVar = aVar2;
                break;
            }
        }
        if (!aVar.f14074n.get() && aVar.f14074n.compareAndSet(false, true)) {
            z10 = true;
        }
        try {
            fVar.accept(aVar);
            if (z10) {
                this.f14066b.subscribe(aVar);
            }
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // ye.c1
    public o<T> publishSource() {
        return this.f14066b;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        this.f14068n.subscribe(qVar);
    }
}
