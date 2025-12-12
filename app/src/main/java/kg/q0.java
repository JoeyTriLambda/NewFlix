package kg;

import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes2.dex */
public final class q0 {
    public static final <T> void dispatch(p0<? super T> p0Var, int i10) {
        qf.c<? super T> delegate$kotlinx_coroutines_core = p0Var.getDelegate$kotlinx_coroutines_core();
        boolean z10 = i10 == 4;
        if (z10 || !(delegate$kotlinx_coroutines_core instanceof pg.i) || isCancellableMode(i10) != isCancellableMode(p0Var.f15131n)) {
            resume(p0Var, delegate$kotlinx_coroutines_core, z10);
            return;
        }
        kotlinx.coroutines.b bVar = ((pg.i) delegate$kotlinx_coroutines_core).f17701o;
        CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
        if (bVar.isDispatchNeeded(context)) {
            bVar.dispatch(context, p0Var);
            return;
        }
        y0 eventLoop$kotlinx_coroutines_core = i2.f15113a.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(p0Var);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            resume(p0Var, p0Var.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final boolean isCancellableMode(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean isReusableMode(int i10) {
        return i10 == 2;
    }

    public static final <T> void resume(p0<? super T> p0Var, qf.c<? super T> cVar, boolean z10) {
        Object successfulResult$kotlinx_coroutines_core;
        Object objTakeState$kotlinx_coroutines_core = p0Var.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = p0Var.getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            int i10 = Result.f15189m;
            successfulResult$kotlinx_coroutines_core = lf.f.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            int i11 = Result.f15189m;
            successfulResult$kotlinx_coroutines_core = p0Var.getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
        }
        Object objM59constructorimpl = Result.m59constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (!z10) {
            cVar.resumeWith(objM59constructorimpl);
            return;
        }
        zf.i.checkNotNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        pg.i iVar = (pg.i) cVar;
        qf.c<T> cVar2 = iVar.f17702p;
        CoroutineContext context = cVar2.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, iVar.f17704r);
        k2<?> k2VarUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.f15566a ? CoroutineContextKt.updateUndispatchedCompletion(cVar2, context, objUpdateThreadContext) : null;
        try {
            iVar.f17702p.resumeWith(objM59constructorimpl);
            lf.h hVar = lf.h.f16056a;
        } finally {
            if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }
}
