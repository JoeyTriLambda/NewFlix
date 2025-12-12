package og;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import pg.x;

/* compiled from: FlowCoroutine.kt */
/* loaded from: classes2.dex */
public final class e<T> extends x<T> {
    public e(CoroutineContext coroutineContext, qf.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // kg.r1
    public boolean childCancelled(Throwable th2) {
        if (th2 instanceof ChildCancelledException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th2);
    }
}
