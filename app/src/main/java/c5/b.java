package c5;

import java.util.UUID;
import l6.u;

/* compiled from: C.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5031a;

    /* renamed from: b, reason: collision with root package name */
    public static final UUID f5032b;

    /* renamed from: c, reason: collision with root package name */
    public static final UUID f5033c;

    /* renamed from: d, reason: collision with root package name */
    public static final UUID f5034d;

    /* renamed from: e, reason: collision with root package name */
    public static final UUID f5035e;

    static {
        f5031a = u.f15907a < 23 ? 1020 : 6396;
        f5032b = new UUID(0L, 0L);
        f5033c = new UUID(1186680826959645954L, -5988876978535335093L);
        f5034d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f5035e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long msToUs(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 * 1000;
    }

    public static long usToMs(long j10) {
        return (j10 == -9223372036854775807L || j10 == Long.MIN_VALUE) ? j10 : j10 / 1000;
    }
}
