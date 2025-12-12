package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kg.i2;
import kg.u0;
import kg.y0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.f;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes2.dex */
public final class d extends f implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: s, reason: collision with root package name */
    public static final d f15363s;

    /* renamed from: t, reason: collision with root package name */
    public static final long f15364t;

    static {
        Long l10;
        d dVar = new d();
        f15363s = dVar;
        y0.incrementUseCount$default(dVar, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f15364t = timeUnit.toNanos(l10.longValue());
    }

    public final synchronized void b() {
        int i10 = debugStatus;
        if (i10 == 2 || i10 == 3) {
            debugStatus = 3;
            resetAll();
            zf.i.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override // kotlinx.coroutines.f
    public void enqueue(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.enqueue(runnable);
    }

    @Override // kotlinx.coroutines.g
    public Thread getThread() {
        Thread thread = _thread;
        if (thread == null) {
            synchronized (this) {
                thread = _thread;
                if (thread == null) {
                    thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                    _thread = thread;
                    thread.setDaemon(true);
                    thread.start();
                }
            }
        }
        return thread;
    }

    @Override // kotlinx.coroutines.f, kotlinx.coroutines.e
    public u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return scheduleInvokeOnTimeout(j10, runnable);
    }

    @Override // kotlinx.coroutines.g
    public void reschedule(long j10, f.c cVar) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        i2.f15113a.setEventLoop$kotlinx_coroutines_core(this);
        kg.c.getTimeSource();
        try {
            synchronized (this) {
                int i10 = debugStatus;
                if (i10 == 2 || i10 == 3) {
                    z10 = false;
                } else {
                    debugStatus = 1;
                    zf.i.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    notifyAll();
                    z10 = true;
                }
            }
            if (!z10) {
                _thread = null;
                b();
                kg.c.getTimeSource();
                if (isEmpty()) {
                    return;
                }
                getThread();
                return;
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jProcessNextEvent = processNextEvent();
                if (jProcessNextEvent == Long.MAX_VALUE) {
                    kg.c.getTimeSource();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f15364t + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        b();
                        kg.c.getTimeSource();
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    jProcessNextEvent = fg.h.coerceAtMost(jProcessNextEvent, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jProcessNextEvent > 0) {
                    int i11 = debugStatus;
                    if (i11 == 2 || i11 == 3) {
                        _thread = null;
                        b();
                        kg.c.getTimeSource();
                        if (isEmpty()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    kg.c.getTimeSource();
                    LockSupport.parkNanos(this, jProcessNextEvent);
                }
            }
        } catch (Throwable th2) {
            _thread = null;
            b();
            kg.c.getTimeSource();
            if (!isEmpty()) {
                getThread();
            }
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.f, kg.y0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
