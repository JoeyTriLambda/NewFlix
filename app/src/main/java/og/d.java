package og;

import kotlin.coroutines.CoroutineContext;
import yf.p;

/* compiled from: SafeCollector.kt */
/* loaded from: classes2.dex */
public final class d implements CoroutineContext {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f17090b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f17091m;

    public d(Throwable th2, CoroutineContext coroutineContext) {
        this.f17090b = th2;
        this.f17091m = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) this.f17091m.fold(r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) this.f17091m.get(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return this.f17091m.minusKey(bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f17091m.plus(coroutineContext);
    }
}
