package io.reactivex.subjects;

import ff.a;
import hf.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;

/* loaded from: classes2.dex */
public final class PublishSubject<T> extends b<T> {

    /* renamed from: n, reason: collision with root package name */
    public static final PublishDisposable[] f14556n = new PublishDisposable[0];

    /* renamed from: o, reason: collision with root package name */
    public static final PublishDisposable[] f14557o = new PublishDisposable[0];

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<PublishDisposable<T>[]> f14558b = new AtomicReference<>(f14557o);

    /* renamed from: m, reason: collision with root package name */
    public Throwable f14559m;

    public static final class PublishDisposable<T> extends AtomicBoolean implements qe.b {
        private static final long serialVersionUID = 3562861878281475070L;

        /* renamed from: b, reason: collision with root package name */
        public final q<? super T> f14560b;

        /* renamed from: m, reason: collision with root package name */
        public final PublishSubject<T> f14561m;

        public PublishDisposable(q<? super T> qVar, PublishSubject<T> publishSubject) {
            this.f14560b = qVar;
            this.f14561m = publishSubject;
        }

        @Override // qe.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f14561m.a(this);
            }
        }

        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.f14560b.onComplete();
        }

        public void onError(Throwable th2) {
            if (get()) {
                a.onError(th2);
            } else {
                this.f14560b.onError(th2);
            }
        }

        public void onNext(T t10) {
            if (get()) {
                return;
            }
            this.f14560b.onNext(t10);
        }
    }

    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>();
    }

    public final void a(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        boolean z10;
        do {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.f14558b;
            PublishDisposable<T>[] publishDisposableArr2 = atomicReference.get();
            if (publishDisposableArr2 == f14556n || publishDisposableArr2 == (publishDisposableArr = f14557o)) {
                return;
            }
            int length = publishDisposableArr2.length;
            z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                } else if (publishDisposableArr2[i10] == publishDisposable) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < 0) {
                return;
            }
            if (length != 1) {
                publishDisposableArr = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr2, 0, publishDisposableArr, 0, i10);
                System.arraycopy(publishDisposableArr2, i10 + 1, publishDisposableArr, i10, (length - i10) - 1);
            }
            while (true) {
                if (atomicReference.compareAndSet(publishDisposableArr2, publishDisposableArr)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != publishDisposableArr2) {
                    break;
                }
            }
        } while (!z10);
    }

    @Override // ne.q
    public void onComplete() {
        AtomicReference<PublishDisposable<T>[]> atomicReference = this.f14558b;
        PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
        PublishDisposable<T>[] publishDisposableArr2 = f14556n;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        PublishDisposable<T>[] andSet = atomicReference.getAndSet(publishDisposableArr2);
        for (PublishDisposable<T> publishDisposable : andSet) {
            publishDisposable.onComplete();
        }
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        ue.a.requireNonNull(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        AtomicReference<PublishDisposable<T>[]> atomicReference = this.f14558b;
        PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
        PublishDisposable<T>[] publishDisposableArr2 = f14556n;
        if (publishDisposableArr == publishDisposableArr2) {
            a.onError(th2);
            return;
        }
        this.f14559m = th2;
        PublishDisposable<T>[] andSet = atomicReference.getAndSet(publishDisposableArr2);
        for (PublishDisposable<T> publishDisposable : andSet) {
            publishDisposable.onError(th2);
        }
    }

    @Override // ne.q
    public void onNext(T t10) {
        ue.a.requireNonNull(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f14558b.get()) {
            publishDisposable.onNext(t10);
        }
    }

    @Override // ne.q
    public void onSubscribe(qe.b bVar) {
        if (this.f14558b.get() == f14556n) {
            bVar.dispose();
        }
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        boolean z10;
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(qVar, this);
        qVar.onSubscribe(publishDisposable);
        while (true) {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.f14558b;
            PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
            z10 = false;
            if (publishDisposableArr == f14556n) {
                break;
            }
            int length = publishDisposableArr.length;
            PublishDisposable<T>[] publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
            while (true) {
                if (atomicReference.compareAndSet(publishDisposableArr, publishDisposableArr2)) {
                    z10 = true;
                    break;
                } else if (atomicReference.get() != publishDisposableArr) {
                    break;
                }
            }
            if (z10) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            if (publishDisposable.isDisposed()) {
                a(publishDisposable);
            }
        } else {
            Throwable th2 = this.f14559m;
            if (th2 != null) {
                qVar.onError(th2);
            } else {
                qVar.onComplete();
            }
        }
    }
}
