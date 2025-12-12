package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import qf.d;

/* compiled from: Delay.kt */
/* loaded from: classes2.dex */
public final class m0 {
    public static final Object delay(long j10, qf.c<? super lf.h> cVar) {
        if (j10 <= 0) {
            return lf.h.f16056a;
        }
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        if (j10 < Long.MAX_VALUE) {
            getDelay(mVar.getContext()).scheduleResumeAfterDelay(j10, mVar);
        }
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : lf.h.f16056a;
    }

    public static final kotlinx.coroutines.e getDelay(CoroutineContext coroutineContext) {
        int i10 = qf.d.f18151l;
        CoroutineContext.a aVar = coroutineContext.get(d.b.f18152b);
        kotlinx.coroutines.e eVar = aVar instanceof kotlinx.coroutines.e ? (kotlinx.coroutines.e) aVar : null;
        return eVar == null ? j0.getDefaultDelay() : eVar;
    }
}
