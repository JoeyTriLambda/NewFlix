package kg;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class n1 {
    public static final x Job(k1 k1Var) {
        return p1.Job(k1Var);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        p1.cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(k1 k1Var, qf.c<? super lf.h> cVar) {
        return p1.cancelAndJoin(k1Var, cVar);
    }

    public static final void cancelFutureOnCancellation(l<?> lVar, Future<?> future) {
        o1.cancelFutureOnCancellation(lVar, future);
    }

    public static final u0 disposeOnCompletion(k1 k1Var, u0 u0Var) {
        return p1.disposeOnCompletion(k1Var, u0Var);
    }

    public static final void ensureActive(k1 k1Var) {
        p1.ensureActive(k1Var);
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        p1.ensureActive(coroutineContext);
    }
}
