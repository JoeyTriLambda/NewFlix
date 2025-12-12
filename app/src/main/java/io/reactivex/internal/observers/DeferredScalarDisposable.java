package io.reactivex.internal.observers;

import ff.a;
import ne.q;

/* loaded from: classes2.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;

    /* renamed from: b, reason: collision with root package name */
    public final q<? super T> f13572b;

    /* renamed from: m, reason: collision with root package name */
    public T f13573m;

    public DeferredScalarDisposable(q<? super T> qVar) {
        this.f13572b = qVar;
    }

    @Override // ve.f
    public final void clear() {
        lazySet(32);
        this.f13573m = null;
    }

    public final void complete(T t10) {
        int i10 = get();
        if ((i10 & 54) != 0) {
            return;
        }
        q<? super T> qVar = this.f13572b;
        if (i10 == 8) {
            this.f13573m = t10;
            lazySet(16);
            qVar.onNext(null);
        } else {
            lazySet(2);
            qVar.onNext(t10);
        }
        if (get() != 4) {
            qVar.onComplete();
        }
    }

    @Override // qe.b
    public void dispose() {
        set(4);
        this.f13573m = null;
    }

    public final void error(Throwable th2) {
        if ((get() & 54) != 0) {
            a.onError(th2);
        } else {
            lazySet(2);
            this.f13572b.onError(th2);
        }
    }

    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // ve.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // ve.f
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t10 = this.f13573m;
        this.f13573m = null;
        lazySet(32);
        return t10;
    }

    @Override // ve.c
    public final int requestFusion(int i10) {
        if ((i10 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f13572b.onComplete();
    }
}
