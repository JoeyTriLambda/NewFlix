package l5;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import l6.l;

/* compiled from: VorbisUtil.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: VorbisUtil.java */
    public static final class a {
        public a(int i10, int i11, long[] jArr, int i12, boolean z10) {
        }
    }

    /* compiled from: VorbisUtil.java */
    public static final class b {
        public b(String str, String[] strArr, int i10) {
        }
    }

    /* compiled from: VorbisUtil.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f15838a;

        public c(boolean z10, int i10, int i11, int i12) {
            this.f15838a = z10;
        }
    }

    /* compiled from: VorbisUtil.java */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f15839a;

        /* renamed from: b, reason: collision with root package name */
        public final long f15840b;

        /* renamed from: c, reason: collision with root package name */
        public final int f15841c;

        /* renamed from: d, reason: collision with root package name */
        public final int f15842d;

        /* renamed from: e, reason: collision with root package name */
        public final int f15843e;

        /* renamed from: f, reason: collision with root package name */
        public final byte[] f15844f;

        public d(long j10, int i10, long j11, int i11, int i12, int i13, int i14, int i15, boolean z10, byte[] bArr) {
            this.f15839a = i10;
            this.f15840b = j11;
            this.f15841c = i12;
            this.f15842d = i14;
            this.f15843e = i15;
            this.f15844f = bArr;
        }
    }

    public static int iLog(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static b readVorbisCommentHeader(l lVar) throws ParserException {
        verifyVorbisHeaderCapturePattern(3, lVar, false);
        String string = lVar.readString((int) lVar.readLittleEndianUnsignedInt());
        int length = string.length() + 11;
        long littleEndianUnsignedInt = lVar.readLittleEndianUnsignedInt();
        String[] strArr = new String[(int) littleEndianUnsignedInt];
        int length2 = length + 4;
        for (int i10 = 0; i10 < littleEndianUnsignedInt; i10++) {
            String string2 = lVar.readString((int) lVar.readLittleEndianUnsignedInt());
            strArr[i10] = string2;
            length2 = length2 + 4 + string2.length();
        }
        if ((lVar.readUnsignedByte() & 1) != 0) {
            return new b(string, strArr, length2 + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static d readVorbisIdentificationHeader(l lVar) throws ParserException {
        verifyVorbisHeaderCapturePattern(1, lVar, false);
        long littleEndianUnsignedInt = lVar.readLittleEndianUnsignedInt();
        int unsignedByte = lVar.readUnsignedByte();
        long littleEndianUnsignedInt2 = lVar.readLittleEndianUnsignedInt();
        int littleEndianInt = lVar.readLittleEndianInt();
        int littleEndianInt2 = lVar.readLittleEndianInt();
        int littleEndianInt3 = lVar.readLittleEndianInt();
        int unsignedByte2 = lVar.readUnsignedByte();
        return new d(littleEndianUnsignedInt, unsignedByte, littleEndianUnsignedInt2, littleEndianInt, littleEndianInt2, littleEndianInt3, (int) Math.pow(2.0d, unsignedByte2 & 15), (int) Math.pow(2.0d, (unsignedByte2 & 240) >> 4), (lVar.readUnsignedByte() & 1) > 0, Arrays.copyOf(lVar.f15881a, lVar.limit()));
    }

    public static c[] readVorbisModes(l lVar, int i10) throws ParserException {
        int i11 = 5;
        int i12 = 0;
        verifyVorbisHeaderCapturePattern(5, lVar, false);
        int unsignedByte = lVar.readUnsignedByte() + 1;
        i iVar = new i(lVar.f15881a);
        iVar.skipBits(lVar.getPosition() * 8);
        int i13 = 0;
        while (i13 < unsignedByte) {
            if (iVar.readBits(24) != 5653314) {
                throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + iVar.getPosition());
            }
            int bits = iVar.readBits(16);
            int bits2 = iVar.readBits(24);
            long[] jArr = new long[bits2];
            boolean bit = iVar.readBit();
            if (bit) {
                int bits3 = iVar.readBits(5) + 1;
                int i14 = 0;
                while (i14 < bits2) {
                    int bits4 = iVar.readBits(iLog(bits2 - i14));
                    for (int i15 = 0; i15 < bits4 && i14 < bits2; i15++) {
                        jArr[i14] = bits3;
                        i14++;
                    }
                    bits3++;
                }
            } else {
                boolean bit2 = iVar.readBit();
                while (i12 < bits2) {
                    if (!bit2) {
                        jArr[i12] = iVar.readBits(5) + 1;
                    } else if (iVar.readBit()) {
                        jArr[i12] = iVar.readBits(5) + 1;
                    } else {
                        jArr[i12] = 0;
                    }
                    i12++;
                }
            }
            int bits5 = iVar.readBits(4);
            if (bits5 > 2) {
                throw new ParserException(ac.c.f("lookup type greater than 2 not decodable: ", bits5));
            }
            if (bits5 == 1 || bits5 == 2) {
                iVar.skipBits(32);
                iVar.skipBits(32);
                int bits6 = iVar.readBits(4) + 1;
                iVar.skipBits(1);
                iVar.skipBits((int) ((bits5 == 1 ? bits != 0 ? (long) Math.floor(Math.pow(bits2, 1.0d / bits)) : 0L : bits2 * bits) * bits6));
            }
            new a(bits, bits2, jArr, bits5, bit);
            i13++;
            i12 = 0;
        }
        int bits7 = iVar.readBits(6) + 1;
        for (int i16 = 0; i16 < bits7; i16++) {
            if (iVar.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        int bits8 = iVar.readBits(6) + 1;
        int i17 = 0;
        while (true) {
            int i18 = 3;
            if (i17 >= bits8) {
                int bits9 = iVar.readBits(6) + 1;
                for (int i19 = 0; i19 < bits9; i19++) {
                    if (iVar.readBits(16) > 2) {
                        throw new ParserException("residueType greater than 2 is not decodable");
                    }
                    iVar.skipBits(24);
                    iVar.skipBits(24);
                    iVar.skipBits(24);
                    int bits10 = iVar.readBits(6) + 1;
                    int i20 = 8;
                    iVar.skipBits(8);
                    int[] iArr = new int[bits10];
                    for (int i21 = 0; i21 < bits10; i21++) {
                        iArr[i21] = ((iVar.readBit() ? iVar.readBits(5) : 0) * 8) + iVar.readBits(3);
                    }
                    int i22 = 0;
                    while (i22 < bits10) {
                        int i23 = 0;
                        while (i23 < i20) {
                            if ((iArr[i22] & (1 << i23)) != 0) {
                                iVar.skipBits(i20);
                            }
                            i23++;
                            i20 = 8;
                        }
                        i22++;
                        i20 = 8;
                    }
                }
                int bits11 = iVar.readBits(6) + 1;
                for (int i24 = 0; i24 < bits11; i24++) {
                    int bits12 = iVar.readBits(16);
                    if (bits12 != 0) {
                        Log.e("VorbisUtil", "mapping type other than 0 not supported: " + bits12);
                    } else {
                        int bits13 = iVar.readBit() ? iVar.readBits(4) + 1 : 1;
                        if (iVar.readBit()) {
                            int bits14 = iVar.readBits(8) + 1;
                            for (int i25 = 0; i25 < bits14; i25++) {
                                int i26 = i10 - 1;
                                iVar.skipBits(iLog(i26));
                                iVar.skipBits(iLog(i26));
                            }
                        }
                        if (iVar.readBits(2) != 0) {
                            throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                        }
                        if (bits13 > 1) {
                            for (int i27 = 0; i27 < i10; i27++) {
                                iVar.skipBits(4);
                            }
                        }
                        for (int i28 = 0; i28 < bits13; i28++) {
                            iVar.skipBits(8);
                            iVar.skipBits(8);
                            iVar.skipBits(8);
                        }
                    }
                }
                int bits15 = iVar.readBits(6) + 1;
                c[] cVarArr = new c[bits15];
                for (int i29 = 0; i29 < bits15; i29++) {
                    cVarArr[i29] = new c(iVar.readBit(), iVar.readBits(16), iVar.readBits(16), iVar.readBits(8));
                }
                if (iVar.readBit()) {
                    return cVarArr;
                }
                throw new ParserException("framing bit after modes not set as expected");
            }
            int bits16 = iVar.readBits(16);
            if (bits16 == 0) {
                int i30 = 8;
                iVar.skipBits(8);
                iVar.skipBits(16);
                iVar.skipBits(16);
                iVar.skipBits(6);
                iVar.skipBits(8);
                int bits17 = iVar.readBits(4) + 1;
                int i31 = 0;
                while (i31 < bits17) {
                    iVar.skipBits(i30);
                    i31++;
                    i30 = 8;
                }
            } else {
                if (bits16 != 1) {
                    throw new ParserException(ac.c.f("floor type greater than 1 not decodable: ", bits16));
                }
                int bits18 = iVar.readBits(i11);
                int[] iArr2 = new int[bits18];
                int i32 = -1;
                for (int i33 = 0; i33 < bits18; i33++) {
                    int bits19 = iVar.readBits(4);
                    iArr2[i33] = bits19;
                    if (bits19 > i32) {
                        i32 = bits19;
                    }
                }
                int i34 = i32 + 1;
                int[] iArr3 = new int[i34];
                int i35 = 0;
                while (i35 < i34) {
                    iArr3[i35] = iVar.readBits(i18) + 1;
                    int bits20 = iVar.readBits(2);
                    int i36 = 8;
                    if (bits20 > 0) {
                        iVar.skipBits(8);
                    }
                    int i37 = 0;
                    while (i37 < (1 << bits20)) {
                        iVar.skipBits(i36);
                        i37++;
                        i36 = 8;
                    }
                    i35++;
                    i18 = 3;
                }
                iVar.skipBits(2);
                int bits21 = iVar.readBits(4);
                int i38 = 0;
                int i39 = 0;
                for (int i40 = 0; i40 < bits18; i40++) {
                    i38 += iArr3[iArr2[i40]];
                    while (i39 < i38) {
                        iVar.skipBits(bits21);
                        i39++;
                    }
                }
            }
            i17++;
            i11 = 5;
        }
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i10, l lVar, boolean z10) throws ParserException {
        if (lVar.bytesLeft() < 7) {
            if (z10) {
                return false;
            }
            throw new ParserException("too short header: " + lVar.bytesLeft());
        }
        if (lVar.readUnsignedByte() != i10) {
            if (z10) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i10));
        }
        if (lVar.readUnsignedByte() == 118 && lVar.readUnsignedByte() == 111 && lVar.readUnsignedByte() == 114 && lVar.readUnsignedByte() == 98 && lVar.readUnsignedByte() == 105 && lVar.readUnsignedByte() == 115) {
            return true;
        }
        if (z10) {
            return false;
        }
        throw new ParserException("expected characters 'vorbis'");
    }
}
