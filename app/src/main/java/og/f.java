package og;

import kg.g0;
import yf.p;

/* compiled from: FlowCoroutine.kt */
/* loaded from: classes2.dex */
public final class f {
    public static final <R> Object flowScope(p<? super g0, ? super qf.c<? super R>, ? extends Object> pVar, qf.c<? super R> cVar) {
        e eVar = new e(cVar.getContext(), cVar);
        Object objStartUndispatchedOrReturn = qg.b.startUndispatchedOrReturn(eVar, eVar, pVar);
        if (objStartUndispatchedOrReturn == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return objStartUndispatchedOrReturn;
    }
}
