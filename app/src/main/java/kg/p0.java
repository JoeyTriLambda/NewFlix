package kg;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import kg.k1;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutinesInternalError;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes2.dex */
public abstract class p0<T> extends rg.g {

    /* renamed from: n, reason: collision with root package name */
    public int f15131n;

    public p0(int i10) {
        this.f15131n = i10;
    }

    public abstract qf.c<T> getDelegate$kotlinx_coroutines_core();

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar != null) {
            return zVar.f15175a;
        }
        return null;
    }

    public final void handleFatalException(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th2 == null && th3 == null) {
            return;
        }
        if (th2 != null && th3 != null) {
            lf.a.addSuppressed(th2, th3);
        }
        if (th2 == null) {
            th2 = th3;
        }
        zf.i.checkNotNull(th2);
        f0.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th2));
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objM59constructorimpl;
        k1 k1Var;
        Object objM59constructorimpl2;
        rg.h hVar = this.f18958m;
        try {
            qf.c<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            zf.i.checkNotNull(delegate$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            pg.i iVar = (pg.i) delegate$kotlinx_coroutines_core;
            qf.c<T> cVar = iVar.f17702p;
            Object obj = iVar.f17704r;
            CoroutineContext context = cVar.getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
            k2<?> k2VarUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.f15566a ? CoroutineContextKt.updateUndispatchedCompletion(cVar, context, objUpdateThreadContext) : null;
            try {
                CoroutineContext context2 = cVar.getContext();
                Object objTakeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core);
                if (exceptionalResult$kotlinx_coroutines_core == null && q0.isCancellableMode(this.f15131n)) {
                    int i10 = k1.f15118i;
                    k1Var = (k1) context2.get(k1.b.f15119b);
                } else {
                    k1Var = null;
                }
                if (k1Var != null && !k1Var.isActive()) {
                    CancellationException cancellationException = k1Var.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core, cancellationException);
                    int i11 = Result.f15189m;
                    cVar.resumeWith(Result.m59constructorimpl(lf.f.createFailure(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    int i12 = Result.f15189m;
                    cVar.resumeWith(Result.m59constructorimpl(lf.f.createFailure(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    int i13 = Result.f15189m;
                    cVar.resumeWith(Result.m59constructorimpl(getSuccessfulResult$kotlinx_coroutines_core(objTakeState$kotlinx_coroutines_core)));
                }
                lf.h hVar2 = lf.h.f16056a;
                if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                try {
                    hVar.afterTask();
                    objM59constructorimpl2 = Result.m59constructorimpl(lf.h.f16056a);
                } catch (Throwable th2) {
                    int i14 = Result.f15189m;
                    objM59constructorimpl2 = Result.m59constructorimpl(lf.f.createFailure(th2));
                }
                handleFatalException(null, Result.m61exceptionOrNullimpl(objM59constructorimpl2));
            } catch (Throwable th3) {
                if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
                }
                throw th3;
            }
        } catch (Throwable th4) {
            try {
                int i15 = Result.f15189m;
                hVar.afterTask();
                objM59constructorimpl = Result.m59constructorimpl(lf.h.f16056a);
            } catch (Throwable th5) {
                int i16 = Result.f15189m;
                objM59constructorimpl = Result.m59constructorimpl(lf.f.createFailure(th5));
            }
            handleFatalException(th4, Result.m61exceptionOrNullimpl(objM59constructorimpl));
        }
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
    }
}
