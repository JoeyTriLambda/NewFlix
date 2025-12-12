package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Yield.kt */
/* loaded from: classes2.dex */
public final class n2 {
    public static final Object yield(qf.c<? super lf.h> cVar) {
        Object coroutine_suspended;
        CoroutineContext context = cVar.getContext();
        n1.ensureActive(context);
        qf.c cVarIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar);
        pg.i iVar = cVarIntercepted instanceof pg.i ? (pg.i) cVarIntercepted : null;
        if (iVar == null) {
            coroutine_suspended = lf.h.f16056a;
        } else {
            if (iVar.f17701o.isDispatchNeeded(context)) {
                iVar.dispatchYield$kotlinx_coroutines_core(context, lf.h.f16056a);
            } else {
                kotlinx.coroutines.k kVar = new kotlinx.coroutines.k();
                CoroutineContext coroutineContextPlus = context.plus(kVar);
                lf.h hVar = lf.h.f16056a;
                iVar.dispatchYield$kotlinx_coroutines_core(coroutineContextPlus, hVar);
                coroutine_suspended = (!kVar.f15575b || pg.j.yieldUndispatched(iVar)) ? rf.a.getCOROUTINE_SUSPENDED() : hVar;
            }
            coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        }
        if (coroutine_suspended == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return coroutine_suspended == rf.a.getCOROUTINE_SUSPENDED() ? coroutine_suspended : lf.h.f16056a;
    }
}
