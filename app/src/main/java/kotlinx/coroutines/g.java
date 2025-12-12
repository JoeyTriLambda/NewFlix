package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kg.y0;
import kotlinx.coroutines.f;

/* compiled from: EventLoop.kt */
/* loaded from: classes2.dex */
public abstract class g extends y0 {
    public abstract Thread getThread();

    public void reschedule(long j10, f.c cVar) {
        d.f15363s.schedule(j10, cVar);
    }

    public final void unpark() {
        Thread thread = getThread();
        if (Thread.currentThread() != thread) {
            kg.c.getTimeSource();
            LockSupport.unpark(thread);
        }
    }
}
