package pg;

import java.util.Iterator;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DiagnosticCoroutineContextException;
import kotlinx.coroutines.internal.ExceptionSuccessfullyProcessed;

/* compiled from: CoroutineExceptionHandlerImpl.common.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final void handleUncaughtCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        Iterator<kg.e0> it = g.getPlatformExceptionHandlers().iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th2);
            } catch (ExceptionSuccessfullyProcessed unused) {
                return;
            } catch (Throwable th3) {
                g.propagateExceptionFinalResort(kg.f0.handlerException(th2, th3));
            }
        }
        try {
            lf.a.addSuppressed(th2, new DiagnosticCoroutineContextException(coroutineContext));
        } catch (Throwable unused2) {
        }
        g.propagateExceptionFinalResort(th2);
    }
}
