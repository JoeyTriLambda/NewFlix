package lg;

import kg.u0;
import kg.w1;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e;
import zf.f;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class d extends w1 implements kotlinx.coroutines.e {
    public /* synthetic */ d(f fVar) {
        this();
    }

    public u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return e.a.invokeOnTimeout(this, j10, runnable, coroutineContext);
    }

    public d() {
    }
}
