package c6;

/* compiled from: CeaUtil.java */
/* loaded from: classes.dex */
public final class g {
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void consume(long r12, l6.l r14, g5.m[] r15) {
        /*
        L0:
            int r0 = r14.bytesLeft()
            r1 = 1
            if (r0 <= r1) goto Laf
            r0 = 0
            r2 = 0
        L9:
            int r3 = r14.bytesLeft()
            r4 = 255(0xff, float:3.57E-43)
            r5 = -1
            if (r3 != 0) goto L14
            r3 = -1
            goto L1c
        L14:
            int r3 = r14.readUnsignedByte()
            int r2 = r2 + r3
            if (r3 == r4) goto L9
            r3 = r2
        L1c:
            r2 = 0
        L1d:
            int r6 = r14.bytesLeft()
            if (r6 != 0) goto L25
            r2 = -1
            goto L2c
        L25:
            int r6 = r14.readUnsignedByte()
            int r2 = r2 + r6
            if (r6 == r4) goto L1d
        L2c:
            if (r2 == r5) goto L9f
            int r4 = r14.bytesLeft()
            if (r2 <= r4) goto L36
            goto L9f
        L36:
            r4 = 3
            r5 = 4
            r6 = 8
            if (r3 != r5) goto L67
            if (r2 >= r6) goto L3f
            goto L67
        L3f:
            int r3 = r14.getPosition()
            int r5 = r14.readUnsignedByte()
            int r7 = r14.readUnsignedShort()
            int r8 = r14.readInt()
            int r9 = r14.readUnsignedByte()
            r14.setPosition(r3)
            r3 = 181(0xb5, float:2.54E-43)
            if (r5 != r3) goto L67
            r3 = 49
            if (r7 != r3) goto L67
            r3 = 1195456820(0x47413934, float:49465.203)
            if (r8 != r3) goto L67
            if (r9 != r4) goto L67
            r3 = 1
            goto L68
        L67:
            r3 = 0
        L68:
            if (r3 == 0) goto L9a
            r14.skipBytes(r6)
            int r3 = r14.readUnsignedByte()
            r3 = r3 & 31
            r14.skipBytes(r1)
            int r3 = r3 * 3
            int r1 = r14.getPosition()
            int r4 = r15.length
        L7d:
            if (r0 >= r4) goto L92
            r5 = r15[r0]
            r14.setPosition(r1)
            r5.sampleData(r14, r3)
            r8 = 1
            r10 = 0
            r11 = 0
            r6 = r12
            r9 = r3
            r5.sampleMetadata(r6, r8, r9, r10, r11)
            int r0 = r0 + 1
            goto L7d
        L92:
            int r3 = r3 + 10
            int r2 = r2 - r3
            r14.skipBytes(r2)
            goto L0
        L9a:
            r14.skipBytes(r2)
            goto L0
        L9f:
            java.lang.String r0 = "CeaUtil"
            java.lang.String r1 = "Skipping remainder of malformed SEI NAL unit."
            android.util.Log.w(r0, r1)
            int r0 = r14.limit()
            r14.setPosition(r0)
            goto L0
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.g.consume(long, l6.l, g5.m[]):void");
    }
}
