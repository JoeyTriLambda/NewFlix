package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.o;
import ne.q;
import qe.b;
import se.f;
import te.c;

/* loaded from: classes2.dex */
public final class ObservablePublishAlt<T> extends df.a<T> implements c {

    /* renamed from: b, reason: collision with root package name */
    public final o<T> f14077b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<PublishConnection<T>> f14078m = new AtomicReference<>();

    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements b {
        private static final long serialVersionUID = 7463222674719692880L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14079b;

        public InnerDisposable(q<? super T> qVar, PublishConnection<T> publishConnection) {
            this.f14079b = qVar;
            lazySet(publishConnection);
        }

        @Override // qe.b
        public void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements q<T>, b {

        /* renamed from: p, reason: collision with root package name */
        public static final InnerDisposable[] f14080p = new InnerDisposable[0];

        /* renamed from: q, reason: collision with root package name */
        public static final InnerDisposable[] f14081q = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;

        /* renamed from: m, reason: collision with root package name */
        public final AtomicReference<PublishConnection<T>> f14083m;

        /* renamed from: o, reason: collision with root package name */
        public Throwable f14085o;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f14082b = new AtomicBoolean();

        /* renamed from: n, reason: collision with root package name */
        public final AtomicReference<b> f14084n = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.f14083m = atomicReference;
            lazySet(f14080p);
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == f14081q) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // qe.b
        public void dispose() {
            AtomicReference<PublishConnection<T>> atomicReference;
            getAndSet(f14081q);
            do {
                atomicReference = this.f14083m;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            DisposableHelper.dispose(this.f14084n);
        }

        public boolean isDisposed() {
            return get() == f14081q;
        }

        @Override // ne.q
        public void onComplete() {
            this.f14084n.lazySet(DisposableHelper.f13533b);
            for (InnerDisposable<T> innerDisposable : getAndSet(f14081q)) {
                innerDisposable.f14079b.onComplete();
            }
        }

        @Override // ne.q
        public void onError(Throwable th2) {
            this.f14085o = th2;
            this.f14084n.lazySet(DisposableHelper.f13533b);
            for (InnerDisposable<T> innerDisposable : getAndSet(f14081q)) {
                innerDisposable.f14079b.onError(th2);
            }
        }

        @Override // ne.q
        public void onNext(T t10) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.f14079b.onNext(t10);
            }
        }

        @Override // ne.q
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.f14084n, bVar);
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (innerDisposableArr[i10] == innerDisposable) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                innerDisposableArr2 = f14080p;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i10);
                    System.arraycopy(innerDisposableArr, i10 + 1, innerDisposableArr2, i10, (length - i10) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublishAlt(o<T> oVar) {
        this.f14077b = oVar;
    }

    @Override // df.a
    public void connect(f<? super b> fVar) {
        PublishConnection<T> publishConnection;
        boolean z10;
        boolean z11;
        while (true) {
            AtomicReference<PublishConnection<T>> atomicReference = this.f14078m;
            publishConnection = atomicReference.get();
            z10 = false;
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishConnection, publishConnection2)) {
                    z11 = true;
                    break;
                } else if (atomicReference.get() != publishConnection) {
                    z11 = false;
                    break;
                }
            }
            if (z11) {
                publishConnection = publishConnection2;
                break;
            }
        }
        if (!publishConnection.f14082b.get() && publishConnection.f14082b.compareAndSet(false, true)) {
            z10 = true;
        }
        try {
            fVar.accept(publishConnection);
            if (z10) {
                this.f14077b.subscribe(publishConnection);
            }
        } catch (Throwable th2) {
            re.a.throwIfFatal(th2);
            throw ExceptionHelper.wrapOrThrow(th2);
        }
    }

    @Override // te.c
    public void resetIf(b bVar) {
        AtomicReference<PublishConnection<T>> atomicReference = this.f14078m;
        PublishConnection<T> publishConnection = (PublishConnection) bVar;
        while (!atomicReference.compareAndSet(publishConnection, null) && atomicReference.get() == publishConnection) {
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        PublishConnection<T> publishConnection;
        boolean z10;
        while (true) {
            AtomicReference<PublishConnection<T>> atomicReference = this.f14078m;
            publishConnection = atomicReference.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishConnection, publishConnection2)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != publishConnection) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(qVar, publishConnection);
        qVar.onSubscribe(innerDisposable);
        if (publishConnection.add(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.remove(innerDisposable);
            }
        } else {
            Throwable th2 = publishConnection.f14085o;
            if (th2 != null) {
                qVar.onError(th2);
            } else {
                qVar.onComplete();
            }
        }
    }
}
