package kg;

import java.util.concurrent.CancellationException;
import kg.k1;
import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineScope.kt */
/* loaded from: classes2.dex */
public final class h0 {
    public static final g0 CoroutineScope(CoroutineContext coroutineContext) {
        int i10 = k1.f15118i;
        if (coroutineContext.get(k1.b.f15119b) == null) {
            coroutineContext = coroutineContext.plus(p1.Job$default(null, 1, null));
        }
        return new pg.f(coroutineContext);
    }

    public static final void cancel(g0 g0Var, CancellationException cancellationException) {
        CoroutineContext coroutineContext = g0Var.getCoroutineContext();
        int i10 = k1.f15118i;
        k1 k1Var = (k1) coroutineContext.get(k1.b.f15119b);
        if (k1Var != null) {
            k1Var.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + g0Var).toString());
        }
    }

    public static /* synthetic */ void cancel$default(g0 g0Var, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        cancel(g0Var, cancellationException);
    }

    public static final <R> Object coroutineScope(yf.p<? super g0, ? super qf.c<? super R>, ? extends Object> pVar, qf.c<? super R> cVar) {
        pg.x xVar = new pg.x(cVar.getContext(), cVar);
        Object objStartUndispatchedOrReturn = qg.b.startUndispatchedOrReturn(xVar, xVar, pVar);
        if (objStartUndispatchedOrReturn == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return objStartUndispatchedOrReturn;
    }

    public static final void ensureActive(g0 g0Var) {
        n1.ensureActive(g0Var.getCoroutineContext());
    }

    public static final boolean isActive(g0 g0Var) {
        CoroutineContext coroutineContext = g0Var.getCoroutineContext();
        int i10 = k1.f15118i;
        k1 k1Var = (k1) coroutineContext.get(k1.b.f15119b);
        if (k1Var != null) {
            return k1Var.isActive();
        }
        return true;
    }
}
