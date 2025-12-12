package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.internal.ThreadContextKt;
import qf.d;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class h {
    public static final <T> k0<T> async(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar) {
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(g0Var, coroutineContext);
        l0 u1Var = coroutineStart.isLazy() ? new u1(coroutineContextNewCoroutineContext, pVar) : new l0(coroutineContextNewCoroutineContext, true);
        ((a) u1Var).start(coroutineStart, u1Var, pVar);
        return (k0<T>) u1Var;
    }

    public static /* synthetic */ k0 async$default(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f15239b;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return f.async(g0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final k1 launch(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p<? super g0, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(g0Var, coroutineContext);
        a v1Var = coroutineStart.isLazy() ? new v1(coroutineContextNewCoroutineContext, pVar) : new e2(coroutineContextNewCoroutineContext, true);
        v1Var.start(coroutineStart, v1Var, pVar);
        return v1Var;
    }

    public static /* synthetic */ k1 launch$default(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f15239b;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return f.launch(g0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar, qf.c<? super T> cVar) {
        Object result;
        CoroutineContext context = cVar.getContext();
        CoroutineContext coroutineContextNewCoroutineContext = CoroutineContextKt.newCoroutineContext(context, coroutineContext);
        n1.ensureActive(coroutineContextNewCoroutineContext);
        if (coroutineContextNewCoroutineContext == context) {
            pg.x xVar = new pg.x(coroutineContextNewCoroutineContext, cVar);
            result = qg.b.startUndispatchedOrReturn(xVar, xVar, pVar);
        } else {
            int i10 = qf.d.f18151l;
            d.b bVar = d.b.f18152b;
            if (zf.i.areEqual(coroutineContextNewCoroutineContext.get(bVar), context.get(bVar))) {
                k2 k2Var = new k2(coroutineContextNewCoroutineContext, cVar);
                CoroutineContext context2 = k2Var.getContext();
                Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context2, null);
                try {
                    Object objStartUndispatchedOrReturn = qg.b.startUndispatchedOrReturn(k2Var, k2Var, pVar);
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    result = objStartUndispatchedOrReturn;
                } catch (Throwable th2) {
                    ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    throw th2;
                }
            } else {
                o0 o0Var = new o0(coroutineContextNewCoroutineContext, cVar);
                qg.a.startCoroutineCancellable$default(pVar, o0Var, o0Var, null, 4, null);
                result = o0Var.getResult();
            }
        }
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }
}
