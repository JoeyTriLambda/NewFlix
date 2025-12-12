package kg;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public final class r0 implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.b f15134b;

    public r0(kotlinx.coroutines.b bVar) {
        this.f15134b = bVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f15239b;
        kotlinx.coroutines.b bVar = this.f15134b;
        if (bVar.isDispatchNeeded(emptyCoroutineContext)) {
            bVar.dispatch(emptyCoroutineContext, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f15134b.toString();
    }
}
