package rg;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public class e extends kotlinx.coroutines.h {

    /* renamed from: m, reason: collision with root package name */
    public final CoroutineScheduler f18956m;

    public e(int i10, int i11, long j10, String str) {
        this.f18956m = new CoroutineScheduler(i10, i11, j10, str);
    }

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.f18956m, runnable, null, false, 6, null);
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(Runnable runnable, h hVar, boolean z10) {
        this.f18956m.dispatch(runnable, hVar, z10);
    }

    @Override // kotlinx.coroutines.b
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.dispatch$default(this.f18956m, runnable, null, true, 2, null);
    }

    @Override // kotlinx.coroutines.h
    public Executor getExecutor() {
        return this.f18956m;
    }
}
