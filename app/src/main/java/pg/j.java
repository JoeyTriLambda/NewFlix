package pg;

import java.util.concurrent.CancellationException;
import kg.i2;
import kg.k1;
import kg.k2;
import kg.y0;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f17709a = new b0("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f17710b = new b0("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void resumeCancellableWith(qf.c<? super T> cVar, Object obj, yf.l<? super Throwable, lf.h> lVar) {
        boolean z10;
        if (!(cVar instanceof i)) {
            cVar.resumeWith(obj);
            return;
        }
        i iVar = (i) cVar;
        Object state = kg.c0.toState(obj, lVar);
        kotlinx.coroutines.b bVar = iVar.f17701o;
        qf.c<T> cVar2 = iVar.f17702p;
        if (bVar.isDispatchNeeded(iVar.getContext())) {
            iVar.f17703q = state;
            iVar.f15131n = 1;
            iVar.f17701o.dispatch(iVar.getContext(), iVar);
            return;
        }
        y0 eventLoop$kotlinx_coroutines_core = i2.f15113a.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            iVar.f17703q = state;
            iVar.f15131n = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(iVar);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext context = iVar.getContext();
            int i10 = k1.f15118i;
            k1 k1Var = (k1) context.get(k1.b.f15119b);
            if (k1Var == null || k1Var.isActive()) {
                z10 = false;
            } else {
                CancellationException cancellationException = k1Var.getCancellationException();
                iVar.cancelCompletedResult$kotlinx_coroutines_core(state, cancellationException);
                int i11 = Result.f15189m;
                iVar.resumeWith(Result.m59constructorimpl(lf.f.createFailure(cancellationException)));
                z10 = true;
            }
            if (!z10) {
                Object obj2 = iVar.f17704r;
                CoroutineContext context2 = cVar2.getContext();
                Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context2, obj2);
                k2<?> k2VarUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.f15566a ? CoroutineContextKt.updateUndispatchedCompletion(cVar2, context2, objUpdateThreadContext) : null;
                try {
                    cVar2.resumeWith(obj);
                    lf.h hVar = lf.h.f16056a;
                    if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    }
                } catch (Throwable th2) {
                    if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                        ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
                    }
                    throw th2;
                }
            }
            while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void resumeCancellableWith$default(qf.c cVar, Object obj, yf.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        resumeCancellableWith(cVar, obj, lVar);
    }

    public static final boolean yieldUndispatched(i<? super lf.h> iVar) {
        lf.h hVar = lf.h.f16056a;
        y0 eventLoop$kotlinx_coroutines_core = i2.f15113a.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            iVar.f17703q = hVar;
            iVar.f15131n = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(iVar);
            return true;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            iVar.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
