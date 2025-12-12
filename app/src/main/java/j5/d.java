package j5;

import g5.j;
import j5.b;
import l6.l;
import l6.u;

/* compiled from: XingSeeker.java */
/* loaded from: classes.dex */
public final class d implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final long f14615a;

    /* renamed from: b, reason: collision with root package name */
    public final long f14616b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14617c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f14618d;

    /* renamed from: e, reason: collision with root package name */
    public final long f14619e;

    /* renamed from: f, reason: collision with root package name */
    public final int f14620f;

    public d(long j10, long j11, long j12, long[] jArr, long j13, int i10) {
        this.f14615a = j10;
        this.f14616b = j11;
        this.f14617c = j12;
        this.f14618d = jArr;
        this.f14619e = j13;
        this.f14620f = i10;
    }

    public static d create(j jVar, l lVar, long j10, long j11) {
        int unsignedIntToInt;
        int i10 = jVar.f12725g;
        int i11 = jVar.f12722d;
        long j12 = j10 + jVar.f12721c;
        int i12 = lVar.readInt();
        if ((i12 & 1) != 1 || (unsignedIntToInt = lVar.readUnsignedIntToInt()) == 0) {
            return null;
        }
        long jScaleLargeTimestamp = u.scaleLargeTimestamp(unsignedIntToInt, i10 * 1000000, i11);
        if ((i12 & 6) != 6) {
            return new d(j12, jScaleLargeTimestamp, j11, null, 0L, 0);
        }
        long unsignedIntToInt2 = lVar.readUnsignedIntToInt();
        lVar.skipBytes(1);
        long[] jArr = new long[99];
        for (int i13 = 0; i13 < 99; i13++) {
            jArr[i13] = lVar.readUnsignedByte();
        }
        return new d(j12, jScaleLargeTimestamp, j11, jArr, unsignedIntToInt2, jVar.f12721c);
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f14616b;
    }

    @Override // g5.l
    public long getPosition(long j10) {
        boolean zIsSeekable = isSeekable();
        long j11 = this.f14615a;
        if (!zIsSeekable) {
            return j11;
        }
        float f10 = (j10 * 100.0f) / this.f14616b;
        if (f10 > 0.0f) {
            if (f10 >= 100.0f) {
                fA = 256.0f;
            } else {
                int i10 = (int) f10;
                long[] jArr = this.f14618d;
                fA = i10 != 0 ? jArr[i10 - 1] : 0.0f;
                fA = o1.a.a(f10, i10, (i10 < 99 ? jArr[i10] : 256.0f) - fA, fA);
            }
        }
        long j12 = this.f14619e;
        long jRound = Math.round(fA * 0.00390625d * j12) + j11;
        long j13 = this.f14617c;
        return Math.min(jRound, j13 != -1 ? j13 - 1 : ((j11 - this.f14620f) + j12) - 1);
    }

    @Override // j5.b.a
    public long getTimeUs(long j10) {
        if (!isSeekable()) {
            return 0L;
        }
        if (j10 < this.f14615a) {
            return 0L;
        }
        double d10 = ((j10 - r4) * 256.0d) / this.f14619e;
        long[] jArr = this.f14618d;
        int iBinarySearchFloor = u.binarySearchFloor(jArr, (long) d10, true, false) + 1;
        long j11 = (iBinarySearchFloor * this.f14616b) / 100;
        long j12 = iBinarySearchFloor == 0 ? 0L : jArr[iBinarySearchFloor - 1];
        return j11 + ((iBinarySearchFloor == 99 ? 256L : jArr[iBinarySearchFloor]) == j12 ? 0L : (long) (((d10 - j12) * (((r11 * (iBinarySearchFloor + 1)) / 100) - j11)) / (r15 - j12)));
    }

    @Override // g5.l
    public boolean isSeekable() {
        return this.f14618d != null;
    }
}
