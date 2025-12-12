package j5;

import g5.j;
import j5.b;
import l6.l;
import l6.u;

/* compiled from: VbriSeeker.java */
/* loaded from: classes.dex */
public final class c implements b.a {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f14612a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f14613b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14614c;

    public c(long[] jArr, long[] jArr2, long j10) {
        this.f14612a = jArr;
        this.f14613b = jArr2;
        this.f14614c = j10;
    }

    public static c create(j jVar, l lVar, long j10, long j11) {
        int unsignedByte;
        lVar.skipBytes(10);
        int i10 = lVar.readInt();
        if (i10 <= 0) {
            return null;
        }
        int i11 = jVar.f12722d;
        long jScaleLargeTimestamp = u.scaleLargeTimestamp(i10, (i11 >= 32000 ? 1152 : 576) * 1000000, i11);
        int unsignedShort = lVar.readUnsignedShort();
        int unsignedShort2 = lVar.readUnsignedShort();
        int unsignedShort3 = lVar.readUnsignedShort();
        int i12 = 2;
        lVar.skipBytes(2);
        long j12 = j10 + jVar.f12721c;
        int i13 = unsignedShort + 1;
        long[] jArr = new long[i13];
        long[] jArr2 = new long[i13];
        jArr[0] = 0;
        jArr2[0] = j12;
        int i14 = 1;
        while (i14 < i13) {
            if (unsignedShort3 == 1) {
                unsignedByte = lVar.readUnsignedByte();
            } else if (unsignedShort3 == i12) {
                unsignedByte = lVar.readUnsignedShort();
            } else if (unsignedShort3 == 3) {
                unsignedByte = lVar.readUnsignedInt24();
            } else {
                if (unsignedShort3 != 4) {
                    return null;
                }
                unsignedByte = lVar.readUnsignedIntToInt();
            }
            int i15 = i13;
            j12 += unsignedByte * unsignedShort2;
            int i16 = unsignedShort2;
            int i17 = unsignedShort3;
            jArr[i14] = (i14 * jScaleLargeTimestamp) / unsignedShort;
            jArr2[i14] = j11 == -1 ? j12 : Math.min(j11, j12);
            i14++;
            i13 = i15;
            unsignedShort2 = i16;
            unsignedShort3 = i17;
            i12 = 2;
        }
        return new c(jArr, jArr2, jScaleLargeTimestamp);
    }

    @Override // g5.l
    public long getDurationUs() {
        return this.f14614c;
    }

    @Override // g5.l
    public long getPosition(long j10) {
        return this.f14613b[u.binarySearchFloor(this.f14612a, j10, true, true)];
    }

    @Override // j5.b.a
    public long getTimeUs(long j10) {
        return this.f14612a[u.binarySearchFloor(this.f14613b, j10, true, true)];
    }

    @Override // g5.l
    public boolean isSeekable() {
        return true;
    }
}
