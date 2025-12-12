package kotlinx.coroutines;

import kg.j0;
import kg.l;
import kg.u0;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Delay.kt */
/* loaded from: classes2.dex */
public interface e {

    /* compiled from: Delay.kt */
    public static final class a {
        public static u0 invokeOnTimeout(e eVar, long j10, Runnable runnable, CoroutineContext coroutineContext) {
            return j0.getDefaultDelay().invokeOnTimeout(j10, runnable, coroutineContext);
        }
    }

    u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext);

    void scheduleResumeAfterDelay(long j10, l<? super lf.h> lVar);
}
