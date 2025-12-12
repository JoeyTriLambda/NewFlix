package l6;

import android.util.Pair;

/* compiled from: CodecSpecificDataUtil.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f15846a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f15847b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f15848c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static int a(k kVar) {
        int bits = kVar.readBits(4);
        if (bits == 15) {
            return kVar.readBits(24);
        }
        a.checkArgument(bits < 13);
        return f15847b[bits];
    }

    public static byte[] buildAacAudioSpecificConfig(int i10, int i11, int i12) {
        return new byte[]{(byte) (((i10 << 3) & 248) | ((i11 >> 1) & 7)), (byte) (((i11 << 7) & 128) | ((i12 << 3) & 120))};
    }

    public static byte[] buildAacLcAudioSpecificConfig(int i10, int i11) {
        int i12 = -1;
        for (int i13 = 0; i13 < 13; i13++) {
            if (i10 == f15847b[i13]) {
                i12 = i13;
            }
        }
        int i14 = -1;
        for (int i15 = 0; i15 < 16; i15++) {
            if (i11 == f15848c[i15]) {
                i14 = i15;
            }
        }
        if (i10 == -1 || i14 == -1) {
            throw new IllegalArgumentException(ac.c.g("Invalid sample rate or number of channels: ", i10, ", ", i11));
        }
        return buildAacAudioSpecificConfig(2, i12, i14);
    }

    public static byte[] buildNalUnit(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11 + 4];
        System.arraycopy(f15846a, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i10, bArr2, 4, i11);
        return bArr2;
    }

    public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] bArr) {
        k kVar = new k(bArr);
        int bits = kVar.readBits(5);
        if (bits == 31) {
            bits = kVar.readBits(6) + 32;
        }
        int iA = a(kVar);
        int bits2 = kVar.readBits(4);
        if (bits == 5 || bits == 29) {
            iA = a(kVar);
            int bits3 = kVar.readBits(5);
            if (bits3 == 31) {
                bits3 = kVar.readBits(6) + 32;
            }
            if (bits3 == 22) {
                bits2 = kVar.readBits(4);
            }
        }
        int i10 = f15848c[bits2];
        a.checkArgument(i10 != -1);
        return Pair.create(Integer.valueOf(iA), Integer.valueOf(i10));
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x004c A[LOOP:1: B:17:0x0030->B:31:0x004c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0050 A[EDGE_INSN: B:45:0x0050->B:33:0x0050 BREAK  A[LOOP:1: B:17:0x0030->B:31:0x004c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[][] splitNalUnits(byte[] r11) {
        /*
            int r0 = r11.length
            r1 = 0
            int r0 = r0 - r1
            byte[] r2 = l6.c.f15846a
            r3 = 4
            r4 = 1
            if (r0 > r3) goto Lb
        L9:
            r0 = 0
            goto L1b
        Lb:
            r0 = 0
        Lc:
            if (r0 >= r3) goto L1a
            int r5 = r1 + r0
            r5 = r11[r5]
            r6 = r2[r0]
            if (r5 == r6) goto L17
            goto L9
        L17:
            int r0 = r0 + 1
            goto Lc
        L1a:
            r0 = 1
        L1b:
            if (r0 != 0) goto L1f
            r11 = 0
            return r11
        L1f:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r5 = 0
        L25:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0.add(r6)
            int r5 = r5 + r3
            int r6 = r11.length
            int r6 = r6 + (-4)
        L30:
            r7 = -1
            if (r5 > r6) goto L4f
            int r8 = r11.length
            int r8 = r8 - r5
            if (r8 > r3) goto L39
        L37:
            r8 = 0
            goto L49
        L39:
            r8 = 0
        L3a:
            if (r8 >= r3) goto L48
            int r9 = r5 + r8
            r9 = r11[r9]
            r10 = r2[r8]
            if (r9 == r10) goto L45
            goto L37
        L45:
            int r8 = r8 + 1
            goto L3a
        L48:
            r8 = 1
        L49:
            if (r8 == 0) goto L4c
            goto L50
        L4c:
            int r5 = r5 + 1
            goto L30
        L4f:
            r5 = -1
        L50:
            if (r5 != r7) goto L25
            int r2 = r0.size()
            byte[][] r2 = new byte[r2][]
            r3 = 0
        L59:
            int r4 = r0.size()
            if (r3 >= r4) goto L89
            java.lang.Object r4 = r0.get(r3)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r5 = r0.size()
            int r5 = r5 + r7
            if (r3 >= r5) goto L7d
            int r5 = r3 + 1
            java.lang.Object r5 = r0.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            goto L7e
        L7d:
            int r5 = r11.length
        L7e:
            int r5 = r5 - r4
            byte[] r6 = new byte[r5]
            java.lang.System.arraycopy(r11, r4, r6, r1, r5)
            r2[r3] = r6
            int r3 = r3 + 1
            goto L59
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.c.splitNalUnits(byte[]):byte[][]");
    }
}
