package l6;

/* compiled from: TimestampAdjuster.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public long f15904a;

    /* renamed from: b, reason: collision with root package name */
    public long f15905b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f15906c = -9223372036854775807L;

    public r(long j10) {
        setFirstSampleTimestampUs(j10);
    }

    public static long ptsToUs(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long usToPts(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public long adjustSampleTimestamp(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f15906c != -9223372036854775807L) {
            this.f15906c = j10;
        } else {
            long j11 = this.f15904a;
            if (j11 != Long.MAX_VALUE) {
                this.f15905b = j11 - j10;
            }
            synchronized (this) {
                this.f15906c = j10;
                notifyAll();
            }
        }
        return j10 + this.f15905b;
    }

    public long adjustTsTimestamp(long j10) {
        if (j10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f15906c != -9223372036854775807L) {
            long jUsToPts = usToPts(this.f15906c);
            long j11 = (4294967296L + jUsToPts) / 8589934592L;
            long j12 = ((j11 - 1) * 8589934592L) + j10;
            long j13 = (j11 * 8589934592L) + j10;
            j10 = Math.abs(j12 - jUsToPts) < Math.abs(j13 - jUsToPts) ? j12 : j13;
        }
        return adjustSampleTimestamp(ptsToUs(j10));
    }

    public long getFirstSampleTimestampUs() {
        return this.f15904a;
    }

    public long getLastAdjustedTimestampUs() {
        if (this.f15906c != -9223372036854775807L) {
            return this.f15906c;
        }
        long j10 = this.f15904a;
        if (j10 != Long.MAX_VALUE) {
            return j10;
        }
        return -9223372036854775807L;
    }

    public long getTimestampOffsetUs() {
        if (this.f15904a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.f15906c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f15905b;
    }

    public void reset() {
        this.f15906c = -9223372036854775807L;
    }

    public synchronized void setFirstSampleTimestampUs(long j10) {
        a.checkState(this.f15906c == -9223372036854775807L);
        this.f15904a = j10;
    }

    public synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.f15906c == -9223372036854775807L) {
            wait();
        }
    }
}
