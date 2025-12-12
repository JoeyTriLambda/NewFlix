package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import ne.k;
import ne.q;
import ve.d;

/* compiled from: ObservableJust.java */
/* loaded from: classes2.dex */
public final class a<T> extends k<T> implements d<T> {

    /* renamed from: b, reason: collision with root package name */
    public final T f14497b;

    public a(T t10) {
        this.f14497b = t10;
    }

    @Override // ve.d, java.util.concurrent.Callable
    public T call() {
        return this.f14497b;
    }

    @Override // ne.k
    public void subscribeActual(q<? super T> qVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(qVar, this.f14497b);
        qVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
