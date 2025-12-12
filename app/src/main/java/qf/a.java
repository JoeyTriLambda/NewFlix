package qf;

import kotlin.coroutines.CoroutineContext;
import yf.p;
import zf.i;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public abstract class a implements CoroutineContext.a {
    private final CoroutineContext.b<?> key;

    public a(CoroutineContext.b<?> bVar) {
        i.checkNotNullParameter(bVar, "key");
        this.key = bVar;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0180a.fold(this, r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0180a.get(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public CoroutineContext.b<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0180a.minusKey(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0180a.plus(this, coroutineContext);
    }
}
