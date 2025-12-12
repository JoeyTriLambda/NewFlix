package rg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class l extends kotlinx.coroutines.b {

    /* renamed from: m, reason: collision with root package name */
    public static final l f18969m = new l();

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        b.f18954n.dispatchWithContext$kotlinx_coroutines_core(runnable, k.f18968h, false);
    }

    @Override // kotlinx.coroutines.b
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        b.f18954n.dispatchWithContext$kotlinx_coroutines_core(runnable, k.f18968h, true);
    }

    @Override // kotlinx.coroutines.b
    public kotlinx.coroutines.b limitedParallelism(int i10) {
        pg.m.checkParallelism(i10);
        return i10 >= k.f18964d ? this : super.limitedParallelism(i10);
    }
}
