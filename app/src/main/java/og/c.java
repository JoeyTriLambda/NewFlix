package og;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;
import yf.p;
import zf.n;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final <T, V> Object withContextUndispatched(CoroutineContext coroutineContext, V v10, Object obj, p<? super V, ? super qf.c<? super T>, ? extends Object> pVar, qf.c<? super T> cVar) {
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            Object objInvoke = ((p) n.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(v10, new k(cVar, coroutineContext));
            ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            if (objInvoke == rf.a.getCOROUTINE_SUSPENDED()) {
                sf.f.probeCoroutineSuspended(cVar);
            }
            return objInvoke;
        } catch (Throwable th2) {
            ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
            throw th2;
        }
    }

    public static /* synthetic */ Object withContextUndispatched$default(CoroutineContext coroutineContext, Object obj, Object obj2, p pVar, qf.c cVar, int i10, Object obj3) {
        if ((i10 & 4) != 0) {
            obj2 = ThreadContextKt.threadContextElements(coroutineContext);
        }
        return withContextUndispatched(coroutineContext, obj, obj2, pVar, cVar);
    }
}
