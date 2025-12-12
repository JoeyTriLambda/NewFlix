package kg;

import java.util.concurrent.CancellationException;
import kg.k1;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class p1 {
    public static final x Job(k1 k1Var) {
        return new m1(k1Var);
    }

    public static /* synthetic */ x Job$default(k1 k1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k1Var = null;
        }
        return n1.Job(k1Var);
    }

    public static final void cancel(CoroutineContext coroutineContext, CancellationException cancellationException) {
        int i10 = k1.f15118i;
        k1 k1Var = (k1) coroutineContext.get(k1.b.f15119b);
        if (k1Var != null) {
            k1Var.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void cancel$default(CoroutineContext coroutineContext, CancellationException cancellationException, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cancellationException = null;
        }
        n1.cancel(coroutineContext, cancellationException);
    }

    public static final Object cancelAndJoin(k1 k1Var, qf.c<? super lf.h> cVar) {
        k1.a.cancel$default(k1Var, null, 1, null);
        Object objJoin = k1Var.join(cVar);
        return objJoin == rf.a.getCOROUTINE_SUSPENDED() ? objJoin : lf.h.f16056a;
    }

    public static final u0 disposeOnCompletion(k1 k1Var, u0 u0Var) {
        return k1Var.invokeOnCompletion(new w0(u0Var));
    }

    public static final void ensureActive(k1 k1Var) {
        if (!k1Var.isActive()) {
            throw k1Var.getCancellationException();
        }
    }

    public static final void ensureActive(CoroutineContext coroutineContext) {
        int i10 = k1.f15118i;
        k1 k1Var = (k1) coroutineContext.get(k1.b.f15119b);
        if (k1Var != null) {
            n1.ensureActive(k1Var);
        }
    }
}
