package kg;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes2.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final pg.b0 f15095a = new pg.b0("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    public static final pg.b0 f15096b = new pg.b0("CLOSED_EMPTY");

    public static final long delayToNanos(long j10) {
        if (j10 <= 0) {
            return 0L;
        }
        if (j10 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j10;
    }
}
