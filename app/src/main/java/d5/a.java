package d5;

import c5.i;
import cz.msebera.android.httpclient.HttpStatus;
import java.nio.ByteBuffer;
import l6.k;
import l6.l;

/* compiled from: Ac3Util.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10850a = {1, 2, 3, 6};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10851b = {48000, 44100, 32000};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f10852c = {24000, 22050, 16000};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f10853d = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f10854e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f10855f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, HttpStatus.SC_EXPECTATION_FAILED, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* compiled from: Ac3Util.java */
    /* renamed from: d5.a$a, reason: collision with other inner class name */
    public static final class C0125a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10856a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10857b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10858c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10859d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10860e;

        public C0125a(String str, int i10, int i11, int i12, int i13) {
            this.f10856a = str;
            this.f10858c = i10;
            this.f10857b = i11;
            this.f10859d = i12;
            this.f10860e = i13;
        }
    }

    public static int a(int i10, int i11) {
        int i12 = i11 / 2;
        if (i10 < 0 || i10 >= 3 || i11 < 0 || i12 >= 19) {
            return -1;
        }
        int i13 = f10851b[i10];
        if (i13 == 44100) {
            return ((i11 % 2) + f10855f[i12]) * 2;
        }
        int i14 = f10854e[i12];
        return i13 == 32000 ? i14 * 6 : i14 * 4;
    }

    public static int getAc3SyncframeAudioSampleCount() {
        return 1536;
    }

    public static i parseAc3AnnexFFormat(l lVar, String str, String str2, com.google.android.exoplayer2.drm.c cVar) {
        int i10 = f10851b[(lVar.readUnsignedByte() & 192) >> 6];
        int unsignedByte = lVar.readUnsignedByte();
        int i11 = f10853d[(unsignedByte & 56) >> 3];
        if ((unsignedByte & 4) != 0) {
            i11++;
        }
        return i.createAudioSampleFormat(str, "audio/ac3", null, -1, -1, i11, i10, null, cVar, 0, str2);
    }

    public static C0125a parseAc3SyncframeInfo(k kVar) {
        int i10;
        String str;
        int i11;
        int bits;
        int i12;
        int i13;
        int position = kVar.getPosition();
        kVar.skipBits(40);
        boolean z10 = kVar.readBits(5) == 16;
        kVar.setPosition(position);
        int[] iArr = f10851b;
        int i14 = 6;
        if (z10) {
            kVar.skipBits(21);
            int bits2 = (kVar.readBits(11) + 1) * 2;
            int bits3 = kVar.readBits(2);
            if (bits3 == 3) {
                i13 = f10852c[kVar.readBits(2)];
            } else {
                i14 = f10850a[kVar.readBits(2)];
                i13 = iArr[bits3];
            }
            bits = kVar.readBits(3);
            i10 = i13;
            i11 = bits2;
            str = "audio/eac3";
            i12 = i14 * 256;
        } else {
            kVar.skipBits(32);
            int bits4 = kVar.readBits(2);
            int iA = a(bits4, kVar.readBits(6));
            kVar.skipBits(8);
            int bits5 = kVar.readBits(3);
            if ((bits5 & 1) != 0 && bits5 != 1) {
                kVar.skipBits(2);
            }
            if ((bits5 & 4) != 0) {
                kVar.skipBits(2);
            }
            if (bits5 == 2) {
                kVar.skipBits(2);
            }
            i10 = iArr[bits4];
            str = "audio/ac3";
            i11 = iA;
            bits = bits5;
            i12 = 1536;
        }
        return new C0125a(str, f10853d[bits] + (kVar.readBit() ? 1 : 0), i10, i11, i12);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 5) {
            return -1;
        }
        byte b10 = bArr[4];
        return a((b10 & 192) >> 6, b10 & 63);
    }

    public static i parseEAc3AnnexFFormat(l lVar, String str, String str2, com.google.android.exoplayer2.drm.c cVar) {
        lVar.skipBytes(2);
        int i10 = f10851b[(lVar.readUnsignedByte() & 192) >> 6];
        int unsignedByte = lVar.readUnsignedByte();
        int i11 = f10853d[(unsignedByte & 14) >> 1];
        if ((unsignedByte & 1) != 0) {
            i11++;
        }
        return i.createAudioSampleFormat(str, "audio/eac3", null, -1, -1, i11, i10, null, cVar, 0, str2);
    }

    public static int parseEAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f10850a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
