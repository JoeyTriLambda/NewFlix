package kg;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;

/* loaded from: classes2.dex */
public final class f {
    public static final <T> k0<T> async(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar) {
        return h.async(g0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final k1 launch(g0 g0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, yf.p<? super g0, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        return h.launch(g0Var, coroutineContext, coroutineStart, pVar);
    }

    public static final <T> T runBlocking(CoroutineContext coroutineContext, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) g.runBlocking(coroutineContext, pVar);
    }

    public static final <T> Object withContext(CoroutineContext coroutineContext, yf.p<? super g0, ? super qf.c<? super T>, ? extends Object> pVar, qf.c<? super T> cVar) {
        return h.withContext(coroutineContext, pVar, cVar);
    }
}
