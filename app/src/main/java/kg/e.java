package kg;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.kt */
/* loaded from: classes2.dex */
public final class e<T> extends a<T> {

    /* renamed from: o, reason: collision with root package name */
    public final Thread f15103o;

    /* renamed from: p, reason: collision with root package name */
    public final y0 f15104p;

    public e(CoroutineContext coroutineContext, Thread thread, y0 y0Var) {
        super(coroutineContext, true, true);
        this.f15103o = thread;
        this.f15104p = y0Var;
    }

    @Override // kg.r1
    public void afterCompletion(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f15103o;
        if (zf.i.areEqual(threadCurrentThread, thread)) {
            return;
        }
        c.getTimeSource();
        LockSupport.unpark(thread);
    }

    @Override // kg.r1
    public boolean isScopedCoroutine() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T joinBlocking() throws Throwable {
        c.getTimeSource();
        y0 y0Var = this.f15104p;
        if (y0Var != null) {
            try {
                y0.incrementUseCount$default(y0Var, false, 1, null);
            } catch (Throwable th2) {
                c.getTimeSource();
                throw th2;
            }
        }
        while (!Thread.interrupted()) {
            try {
                long jProcessNextEvent = y0Var != null ? y0Var.processNextEvent() : Long.MAX_VALUE;
                if (isCompleted()) {
                    c.getTimeSource();
                    T t10 = (T) t1.unboxState(getState$kotlinx_coroutines_core());
                    zVar = t10 instanceof z ? (z) t10 : null;
                    if (zVar == null) {
                        return t10;
                    }
                    throw zVar.f15175a;
                }
                c.getTimeSource();
                LockSupport.parkNanos(this, jProcessNextEvent);
            } finally {
                if (y0Var != null) {
                    y0.decrementUseCount$default(y0Var, false, 1, null);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cancelCoroutine(interruptedException);
        throw interruptedException;
    }
}
