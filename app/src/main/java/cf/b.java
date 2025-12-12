package cf;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureHelper.java */
/* loaded from: classes2.dex */
public final class b {
    public static long add(AtomicLong atomicLong, long j10) {
        long j11;
        do {
            j11 = atomicLong.get();
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j11, addCap(j11, j10)));
        return j11;
    }

    public static long addCap(long j10, long j11) {
        long j12 = j10 + j11;
        if (j12 < 0) {
            return Long.MAX_VALUE;
        }
        return j12;
    }

    public static long produced(AtomicLong atomicLong, long j10) {
        long j11;
        long j12;
        do {
            j11 = atomicLong.get();
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j12 = j11 - j10;
            if (j12 < 0) {
                ff.a.onError(new IllegalStateException(ac.c.h("More produced than requested: ", j12)));
                j12 = 0;
            }
        } while (!atomicLong.compareAndSet(j11, j12));
        return j12;
    }
}
