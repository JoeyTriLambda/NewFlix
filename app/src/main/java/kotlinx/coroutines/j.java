package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Unconfined.kt */
/* loaded from: classes2.dex */
public final class j extends b {

    /* renamed from: m, reason: collision with root package name */
    public static final j f15573m = new j();

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        k kVar = (k) coroutineContext.get(k.f15574m);
        if (kVar == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        kVar.f15575b = true;
    }

    @Override // kotlinx.coroutines.b
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.b
    public b limitedParallelism(int i10) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.b
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
