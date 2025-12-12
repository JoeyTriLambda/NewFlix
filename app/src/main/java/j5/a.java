package j5;

import j5.b;
import l6.u;

/* compiled from: ConstantBitrateSeeker.java */
/* loaded from: classes.dex */
public final class a implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f14593a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14594b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14595c;

    public a(long j10, int i10, long j11) {
        this.f14593a = j10;
        this.f14594b = i10;
        this.f14595c = j11 == -1 ? -9223372036854775807L : getTimeUs(j11);
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f14595c;
    }

    @Override // g5.l
    public long getPosition(long j10) {
        long j11 = this.f14595c;
        if (j11 == -9223372036854775807L) {
            return 0L;
        }
        return ((u.constrainValue(j10, 0L, j11) * this.f14594b) / 8000000) + this.f14593a;
    }

    @Override // j5.b.a
    public long getTimeUs(long j10) {
        return ((Math.max(0L, j10 - this.f14593a) * 1000000) * 8) / this.f14594b;
    }

    @Override // g5.l
    public boolean isSeekable() {
        return this.f14595c != -9223372036854775807L;
    }
}
