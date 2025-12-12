package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class l2 implements CoroutineContext.a, CoroutineContext.b<l2> {

    /* renamed from: b, reason: collision with root package name */
    public static final l2 f15121b = new l2();

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, yf.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) CoroutineContext.a.C0180a.fold(this, r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) CoroutineContext.a.C0180a.get(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return CoroutineContext.a.C0180a.minusKey(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.a.C0180a.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public CoroutineContext.b<?> getKey() {
        return this;
    }
}
