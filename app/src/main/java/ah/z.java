package ah;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout.kt */
/* loaded from: classes2.dex */
public class z {
    public static final b Companion = new b(null);
    public static final z NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* compiled from: Timeout.kt */
    public static final class b {
        public b(zf.f fVar) {
        }

        public final long minTimeout(long j10, long j11) {
            return (j10 != 0 && (j11 == 0 || j10 < j11)) ? j10 : j11;
        }
    }

    public z clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public z clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final z deadline(long j10, TimeUnit timeUnit) {
        zf.i.checkNotNullParameter(timeUnit, "unit");
        if (j10 > 0) {
            return deadlineNanoTime(timeUnit.toNanos(j10) + System.nanoTime());
        }
        throw new IllegalArgumentException(zf.i.stringPlus("duration <= 0: ", Long.valueOf(j10)).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(z zVar, yf.a<? extends T> aVar) {
        zf.i.checkNotNullParameter(zVar, "other");
        zf.i.checkNotNullParameter(aVar, "block");
        long jTimeoutNanos = timeoutNanos();
        long jMinTimeout = Companion.minTimeout(zVar.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jMinTimeout, timeUnit);
        if (!hasDeadline()) {
            if (zVar.hasDeadline()) {
                deadlineNanoTime(zVar.deadlineNanoTime());
            }
            try {
                T tInvoke = aVar.invoke();
                zf.h.finallyStart(1);
                timeout(jTimeoutNanos, timeUnit);
                if (zVar.hasDeadline()) {
                    clearDeadline();
                }
                zf.h.finallyEnd(1);
                return tInvoke;
            } catch (Throwable th2) {
                zf.h.finallyStart(1);
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (zVar.hasDeadline()) {
                    clearDeadline();
                }
                zf.h.finallyEnd(1);
                throw th2;
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (zVar.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), zVar.deadlineNanoTime()));
        }
        try {
            T tInvoke2 = aVar.invoke();
            zf.h.finallyStart(1);
            timeout(jTimeoutNanos, timeUnit);
            if (zVar.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            zf.h.finallyEnd(1);
            return tInvoke2;
        } catch (Throwable th3) {
            zf.h.finallyStart(1);
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (zVar.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            zf.h.finallyEnd(1);
            throw th3;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public z timeout(long j10, TimeUnit timeUnit) {
        zf.i.checkNotNullParameter(timeUnit, "unit");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(zf.i.stringPlus("timeout < 0: ", Long.valueOf(j10)).toString());
        }
        this.timeoutNanos = timeUnit.toNanos(j10);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        zf.i.checkNotNullParameter(obj, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j10 = jTimeoutNanos / 1000000;
                Long.signum(j10);
                obj.wait(j10, (int) (jTimeoutNanos - (1000000 * j10)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public z deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }

    /* compiled from: Timeout.kt */
    public static final class a extends z {
        @Override // ah.z
        public z timeout(long j10, TimeUnit timeUnit) {
            zf.i.checkNotNullParameter(timeUnit, "unit");
            return this;
        }

        @Override // ah.z
        public void throwIfReached() {
        }

        @Override // ah.z
        public z deadlineNanoTime(long j10) {
            return this;
        }
    }
}
