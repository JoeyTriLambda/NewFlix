package kg;

import java.lang.reflect.InvocationTargetException;
import kg.e0;
import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes2.dex */
public final class f0 {
    public static final void handleCoroutineException(CoroutineContext coroutineContext, Throwable th2) {
        try {
            int i10 = e0.f15105h;
            e0 e0Var = (e0) coroutineContext.get(e0.b.f15106b);
            if (e0Var != null) {
                e0Var.handleException(coroutineContext, th2);
            } else {
                pg.h.handleUncaughtCoroutineException(coroutineContext, th2);
            }
        } catch (Throwable th3) {
            pg.h.handleUncaughtCoroutineException(coroutineContext, handlerException(th2, th3));
        }
    }

    public static final Throwable handlerException(Throwable th2, Throwable th3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th2 == th3) {
            return th2;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th3);
        lf.a.addSuppressed(runtimeException, th2);
        return runtimeException;
    }
}
