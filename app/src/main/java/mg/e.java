package mg;

import kg.g0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import yf.l;
import yf.p;

/* compiled from: Produce.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final <E> i<E> produce(g0 g0Var, CoroutineContext coroutineContext, int i10, p<? super g<? super E>, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        return produce(g0Var, coroutineContext, i10, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    public static /* synthetic */ i produce$default(g0 g0Var, CoroutineContext coroutineContext, int i10, p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f15239b;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return produce(g0Var, coroutineContext, i10, pVar);
    }

    public static final <E> i<E> produce(g0 g0Var, CoroutineContext coroutineContext, int i10, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, l<? super Throwable, lf.h> lVar, p<? super g<? super E>, ? super qf.c<? super lf.h>, ? extends Object> pVar) {
        f fVar = new f(CoroutineContextKt.newCoroutineContext(g0Var, coroutineContext), c.Channel$default(i10, bufferOverflow, null, 4, null));
        if (lVar != null) {
            fVar.invokeOnCompletion(lVar);
        }
        fVar.start(coroutineStart, fVar, pVar);
        return fVar;
    }
}
