package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import ne.q;
import qe.b;

/* loaded from: classes2.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<b> implements q<T>, b {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: b, reason: collision with root package name */
    public final q<? super T> f14495b;

    /* renamed from: m, reason: collision with root package name */
    public final AtomicReference<b> f14496m = new AtomicReference<>();

    public ObserverResourceWrapper(q<? super T> qVar) {
        this.f14495b = qVar;
    }

    @Override // qe.b
    public void dispose() {
        DisposableHelper.dispose(this.f14496m);
        DisposableHelper.dispose(this);
    }

    @Override // ne.q
    public void onComplete() {
        dispose();
        this.f14495b.onComplete();
    }

    @Override // ne.q
    public void onError(Throwable th2) {
        dispose();
        this.f14495b.onError(th2);
    }

    @Override // ne.q
    public void onNext(T t10) {
        this.f14495b.onNext(t10);
    }

    @Override // ne.q
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this.f14496m, bVar)) {
            this.f14495b.onSubscribe(this);
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
