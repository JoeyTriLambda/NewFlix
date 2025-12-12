package ah;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes2.dex */
public class a extends z {
    public static final C0010a Companion = new C0010a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    /* renamed from: ah.a$a, reason: collision with other inner class name */
    public static final class C0010a {
        public C0010a(zf.f fVar) {
        }

        public static final boolean access$cancelScheduledTimeout(C0010a c0010a, a aVar) {
            c0010a.getClass();
            synchronized (a.class) {
                if (!aVar.inQueue) {
                    return false;
                }
                aVar.inQueue = false;
                for (a aVar2 = a.head; aVar2 != null; aVar2 = aVar2.next) {
                    if (aVar2.next == aVar) {
                        aVar2.next = aVar.next;
                        aVar.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        public static final void access$scheduleTimeout(C0010a c0010a, a aVar, long j10, boolean z10) {
            c0010a.getClass();
            synchronized (a.class) {
                if (!(!aVar.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                aVar.inQueue = true;
                if (a.head == null) {
                    a.head = new a();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z10) {
                    aVar.timeoutAt = Math.min(j10, aVar.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    aVar.timeoutAt = j10 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    aVar.timeoutAt = aVar.deadlineNanoTime();
                }
                long jRemainingNanos = aVar.remainingNanos(jNanoTime);
                a aVar2 = a.head;
                zf.i.checkNotNull(aVar2);
                while (aVar2.next != null) {
                    a aVar3 = aVar2.next;
                    zf.i.checkNotNull(aVar3);
                    if (jRemainingNanos < aVar3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    aVar2 = aVar2.next;
                    zf.i.checkNotNull(aVar2);
                }
                aVar.next = aVar2.next;
                aVar2.next = aVar;
                if (aVar2 == a.head) {
                    a.class.notify();
                }
                lf.h hVar = lf.h.f16056a;
            }
        }

        public final a awaitTimeout$okio() throws InterruptedException {
            a aVar = a.head;
            zf.i.checkNotNull(aVar);
            a aVar2 = aVar.next;
            if (aVar2 == null) {
                long jNanoTime = System.nanoTime();
                a.class.wait(a.IDLE_TIMEOUT_MILLIS);
                a aVar3 = a.head;
                zf.i.checkNotNull(aVar3);
                if (aVar3.next != null || System.nanoTime() - jNanoTime < a.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return a.head;
            }
            long jRemainingNanos = aVar2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j10 = jRemainingNanos / 1000000;
                a.class.wait(j10, (int) (jRemainingNanos - (1000000 * j10)));
                return null;
            }
            a aVar4 = a.head;
            zf.i.checkNotNull(aVar4);
            aVar4.next = aVar2.next;
            aVar2.next = null;
            return aVar2;
        }
    }

    /* compiled from: AsyncTimeout.kt */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a aVarAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (a.class) {
                        aVarAwaitTimeout$okio = a.Companion.awaitTimeout$okio();
                        if (aVarAwaitTimeout$okio == a.head) {
                            a.head = null;
                            return;
                        }
                        lf.h hVar = lf.h.f16056a;
                    }
                    if (aVarAwaitTimeout$okio != null) {
                        aVarAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    public static final class c implements w {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ w f672m;

        public c(w wVar) {
            this.f672m = wVar;
        }

        @Override // ah.w, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            w wVar = this.f672m;
            a aVar = a.this;
            aVar.enter();
            try {
                wVar.close();
                lf.h hVar = lf.h.f16056a;
                if (aVar.exit()) {
                    throw aVar.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!aVar.exit()) {
                    throw e10;
                }
                throw aVar.access$newTimeoutException(e10);
            } finally {
                aVar.exit();
            }
        }

        @Override // ah.w, java.io.Flushable
        public void flush() throws IOException {
            w wVar = this.f672m;
            a aVar = a.this;
            aVar.enter();
            try {
                wVar.flush();
                lf.h hVar = lf.h.f16056a;
                if (aVar.exit()) {
                    throw aVar.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!aVar.exit()) {
                    throw e10;
                }
                throw aVar.access$newTimeoutException(e10);
            } finally {
                aVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f672m + ')';
        }

        @Override // ah.w
        public void write(ah.c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "source");
            d0.checkOffsetAndCount(cVar.size(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                u uVar = cVar.f676b;
                zf.i.checkNotNull(uVar);
                while (true) {
                    if (j11 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j11 += uVar.f725c - uVar.f724b;
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        uVar = uVar.f728f;
                        zf.i.checkNotNull(uVar);
                    }
                }
                w wVar = this.f672m;
                a aVar = a.this;
                aVar.enter();
                try {
                    wVar.write(cVar, j11);
                    lf.h hVar = lf.h.f16056a;
                    if (aVar.exit()) {
                        throw aVar.access$newTimeoutException(null);
                    }
                    j10 -= j11;
                } catch (IOException e10) {
                    if (!aVar.exit()) {
                        throw e10;
                    }
                    throw aVar.access$newTimeoutException(e10);
                } finally {
                    aVar.exit();
                }
            }
        }

        @Override // ah.w
        public a timeout() {
            return a.this;
        }
    }

    /* compiled from: AsyncTimeout.kt */
    public static final class d implements y {

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ y f674m;

        public d(y yVar) {
            this.f674m = yVar;
        }

        @Override // ah.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            y yVar = this.f674m;
            a aVar = a.this;
            aVar.enter();
            try {
                yVar.close();
                lf.h hVar = lf.h.f16056a;
                if (aVar.exit()) {
                    throw aVar.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!aVar.exit()) {
                    throw e10;
                }
                throw aVar.access$newTimeoutException(e10);
            } finally {
                aVar.exit();
            }
        }

        @Override // ah.y
        public long read(ah.c cVar, long j10) throws IOException {
            zf.i.checkNotNullParameter(cVar, "sink");
            y yVar = this.f674m;
            a aVar = a.this;
            aVar.enter();
            try {
                long j11 = yVar.read(cVar, j10);
                if (aVar.exit()) {
                    throw aVar.access$newTimeoutException(null);
                }
                return j11;
            } catch (IOException e10) {
                if (aVar.exit()) {
                    throw aVar.access$newTimeoutException(e10);
                }
                throw e10;
            } finally {
                aVar.exit();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f674m + ')';
        }

        @Override // ah.y
        public a timeout() {
            return a.this;
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            C0010a.access$scheduleTimeout(Companion, this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        return C0010a.access$cancelScheduledTimeout(Companion, this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final w sink(w wVar) {
        zf.i.checkNotNullParameter(wVar, "sink");
        return new c(wVar);
    }

    public final y source(y yVar) {
        zf.i.checkNotNullParameter(yVar, "source");
        return new d(yVar);
    }

    public final <T> T withTimeout(yf.a<? extends T> aVar) throws IOException {
        zf.i.checkNotNullParameter(aVar, "block");
        enter();
        try {
            try {
                T tInvoke = aVar.invoke();
                zf.h.finallyStart(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                zf.h.finallyEnd(1);
                return tInvoke;
            } catch (IOException e10) {
                if (exit()) {
                    throw access$newTimeoutException(e10);
                }
                throw e10;
            }
        } catch (Throwable th2) {
            zf.h.finallyStart(1);
            exit();
            zf.h.finallyEnd(1);
            throw th2;
        }
    }

    public void timedOut() {
    }
}
