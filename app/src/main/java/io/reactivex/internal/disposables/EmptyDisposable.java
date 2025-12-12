package io.reactivex.internal.disposables;

import ne.q;
import ne.t;
import ve.b;

/* loaded from: classes2.dex */
public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public static void complete(q<?> qVar) {
        qVar.onSubscribe(INSTANCE);
        qVar.onComplete();
    }

    public static void error(Throwable th2, q<?> qVar) {
        qVar.onSubscribe(INSTANCE);
        qVar.onError(th2);
    }

    @Override // ve.f
    public boolean isEmpty() {
        return true;
    }

    @Override // ve.f
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // ve.f
    public Object poll() throws Exception {
        return null;
    }

    @Override // ve.c
    public int requestFusion(int i10) {
        return i10 & 2;
    }

    public static void complete(ne.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th2, ne.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th2);
    }

    public static void error(Throwable th2, t<?> tVar) {
        tVar.onSubscribe(INSTANCE);
        tVar.onError(th2);
    }

    @Override // ve.f
    public void clear() {
    }

    @Override // qe.b
    public void dispose() {
    }
}
