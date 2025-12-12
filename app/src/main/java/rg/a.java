package rg;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import pg.c0;
import pg.e0;

/* compiled from: Dispatcher.kt */
/* loaded from: classes2.dex */
public final class a extends kotlinx.coroutines.h implements Executor {

    /* renamed from: m, reason: collision with root package name */
    public static final a f18952m = new a();

    /* renamed from: n, reason: collision with root package name */
    public static final kotlinx.coroutines.b f18953n = l.f18969m.limitedParallelism(e0.systemProp$default("kotlinx.coroutines.io.parallelism", fg.h.coerceAtLeast(64, c0.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null));

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        f18953n.dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.b
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        f18953n.dispatchYield(coroutineContext, runnable);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dispatch(EmptyCoroutineContext.f15239b, runnable);
    }

    @Override // kotlinx.coroutines.b
    public kotlinx.coroutines.b limitedParallelism(int i10) {
        return l.f18969m.limitedParallelism(i10);
    }

    @Override // kotlinx.coroutines.b
    public String toString() {
        return "Dispatchers.IO";
    }

    @Override // kotlinx.coroutines.h
    public Executor getExecutor() {
        return this;
    }
}
