package l6;

import com.unity3d.services.core.device.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: NalUnitUtil.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f15860a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f15861b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f15862c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static int[] f15863d = new int[10];

    /* compiled from: NalUnitUtil.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f15864a;

        /* renamed from: b, reason: collision with root package name */
        public final int f15865b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f15866c;

        public a(int i10, int i11, boolean z10) {
            this.f15864a = i10;
            this.f15865b = i11;
            this.f15866c = z10;
        }
    }

    /* compiled from: NalUnitUtil.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f15867a;

        /* renamed from: b, reason: collision with root package name */
        public final int f15868b;

        /* renamed from: c, reason: collision with root package name */
        public final int f15869c;

        /* renamed from: d, reason: collision with root package name */
        public final float f15870d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f15871e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f15872f;

        /* renamed from: g, reason: collision with root package name */
        public final int f15873g;

        /* renamed from: h, reason: collision with root package name */
        public final int f15874h;

        /* renamed from: i, reason: collision with root package name */
        public final int f15875i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f15876j;

        public b(int i10, int i11, int i12, float f10, boolean z10, boolean z11, int i13, int i14, int i15, boolean z12) {
            this.f15867a = i10;
            this.f15868b = i11;
            this.f15869c = i12;
            this.f15870d = f10;
            this.f15871e = z10;
            this.f15872f = z11;
            this.f15873g = i13;
            this.f15874h = i14;
            this.f15875i = i15;
            this.f15876j = z12;
        }
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            if (i12 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i13 = byteBuffer.get(i10) & 255;
            if (i11 == 3) {
                if (i13 == 1 && (byteBuffer.get(i12) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i10 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i13 == 0) {
                i11++;
            }
            if (i13 != 0) {
                i11 = 0;
            }
            i10 = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0095, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int findNalUnit(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            Method dump skipped, instructions count: 186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.j.findNalUnit(byte[], int, int, boolean[]):int");
    }

    public static int getH265NalUnitType(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i10) {
        return bArr[i10 + 3] & 31;
    }

    public static boolean isNalUnitSei(String str, byte b10) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b10 & 31) == 6) {
            return true;
        }
        return MimeTypes.VIDEO_H265.equals(str) && ((b10 & 126) >> 1) == 39;
    }

    public static a parsePpsNalUnit(byte[] bArr, int i10, int i11) {
        m mVar = new m(bArr, i10, i11);
        mVar.skipBits(8);
        int unsignedExpGolombCodedInt = mVar.readUnsignedExpGolombCodedInt();
        int unsignedExpGolombCodedInt2 = mVar.readUnsignedExpGolombCodedInt();
        mVar.skipBit();
        return new a(unsignedExpGolombCodedInt, unsignedExpGolombCodedInt2, mVar.readBit());
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static l6.j.b parseSpsNalUnit(byte[] r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.j.parseSpsNalUnit(byte[], int, int):l6.j$b");
    }

    public static int unescapeStream(byte[] bArr, int i10) {
        int i11;
        synchronized (f15862c) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10) {
                while (true) {
                    if (i12 >= i10 - 2) {
                        i12 = i10;
                        break;
                    }
                    if (bArr[i12] == 0 && bArr[i12 + 1] == 0 && bArr[i12 + 2] == 3) {
                        break;
                    }
                    i12++;
                }
                if (i12 < i10) {
                    int[] iArr = f15863d;
                    if (iArr.length <= i13) {
                        f15863d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f15863d[i13] = i12;
                    i12 += 3;
                    i13++;
                }
            }
            i11 = i10 - i13;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = f15863d[i16] - i15;
                System.arraycopy(bArr, i15, bArr, i14, i17);
                int i18 = i14 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i14 = i19 + 1;
                bArr[i19] = 0;
                i15 += i17 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i14, i11 - i14);
        }
        return i11;
    }
}
