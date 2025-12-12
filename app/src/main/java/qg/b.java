package qg;

import kg.t1;
import kg.z;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ThreadContextKt;
import pg.x;
import qf.c;
import sf.f;
import yf.p;
import zf.n;

/* compiled from: Undispatched.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final <R, T> void startCoroutineUndispatched(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar) {
        c cVarProbeCoroutineCreated = f.probeCoroutineCreated(cVar);
        try {
            CoroutineContext context = cVar.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Object objInvoke = ((p) n.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(r10, cVarProbeCoroutineCreated);
                if (objInvoke != rf.a.getCOROUTINE_SUSPENDED()) {
                    cVarProbeCoroutineCreated.resumeWith(Result.m59constructorimpl(objInvoke));
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        } catch (Throwable th2) {
            int i10 = Result.f15189m;
            cVarProbeCoroutineCreated.resumeWith(Result.m59constructorimpl(lf.f.createFailure(th2)));
        }
    }

    public static final <T, R> Object startUndispatchedOrReturn(x<? super T> xVar, R r10, p<? super R, ? super c<? super T>, ? extends Object> pVar) {
        Object zVar;
        try {
            zVar = ((p) n.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(r10, xVar);
        } catch (Throwable th2) {
            zVar = new z(th2, false, 2, null);
        }
        if (zVar == rf.a.getCOROUTINE_SUSPENDED()) {
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = xVar.makeCompletingOnce$kotlinx_coroutines_core(zVar);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == t1.f15154b) {
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof z) {
            throw ((z) objMakeCompletingOnce$kotlinx_coroutines_core).f15175a;
        }
        return t1.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
    }

    public static final <T, R> Object startUndispatchedOrReturnIgnoreTimeout(x<? super T> xVar, R r10, p<? super R, ? super c<? super T>, ? extends Object> pVar) throws Throwable {
        Object zVar;
        try {
            zVar = ((p) n.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(r10, xVar);
        } catch (Throwable th2) {
            zVar = new z(th2, false, 2, null);
        }
        if (zVar == rf.a.getCOROUTINE_SUSPENDED()) {
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        Object objMakeCompletingOnce$kotlinx_coroutines_core = xVar.makeCompletingOnce$kotlinx_coroutines_core(zVar);
        if (objMakeCompletingOnce$kotlinx_coroutines_core == t1.f15154b) {
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        if (objMakeCompletingOnce$kotlinx_coroutines_core instanceof z) {
            Throwable th3 = ((z) objMakeCompletingOnce$kotlinx_coroutines_core).f15175a;
            if (((th3 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th3).f15296b == xVar) ? false : true) {
                throw th3;
            }
            if (zVar instanceof z) {
                throw ((z) zVar).f15175a;
            }
        } else {
            zVar = t1.unboxState(objMakeCompletingOnce$kotlinx_coroutines_core);
        }
        return zVar;
    }
}
