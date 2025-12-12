package g5;

import cz.msebera.android.httpclient.HttpStatus;

/* compiled from: MpegAudioHeader.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f12712h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f12713i = {44100, 48000, 32000};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f12714j = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, 448};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f12715k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f12716l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f12717m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f12718n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};

    /* renamed from: a, reason: collision with root package name */
    public int f12719a;

    /* renamed from: b, reason: collision with root package name */
    public String f12720b;

    /* renamed from: c, reason: collision with root package name */
    public int f12721c;

    /* renamed from: d, reason: collision with root package name */
    public int f12722d;

    /* renamed from: e, reason: collision with root package name */
    public int f12723e;

    /* renamed from: f, reason: collision with root package name */
    public int f12724f;

    /* renamed from: g, reason: collision with root package name */
    public int f12725g;

    public static int getFrameSize(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if ((i10 & (-2097152)) != -2097152 || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return -1;
        }
        int i15 = f12713i[i14];
        if (i11 == 2) {
            i15 /= 2;
        } else if (i11 == 0) {
            i15 /= 4;
        }
        int i16 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            return ((((i11 == 3 ? f12714j[i13 - 1] : f12715k[i13 - 1]) * 12000) / i15) + i16) * 4;
        }
        int i17 = i11 == 3 ? i12 == 2 ? f12716l[i13 - 1] : f12717m[i13 - 1] : f12718n[i13 - 1];
        if (i11 == 3) {
            return ac.c.a(i17, 144000, i15, i16);
        }
        return ac.c.a(i12 == 1 ? 72000 : 144000, i17, i15, i16);
    }

    public static boolean populateHeader(int i10, j jVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int iA;
        int i16;
        if ((i10 & (-2097152)) != -2097152 || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return false;
        }
        int i17 = f12713i[i14];
        if (i11 == 2) {
            i17 /= 2;
        } else if (i11 == 0) {
            i17 /= 4;
        }
        int i18 = (i10 >>> 9) & 1;
        if (i12 == 3) {
            i15 = i11 == 3 ? f12714j[i13 - 1] : f12715k[i13 - 1];
            iA = (((i15 * 12000) / i17) + i18) * 4;
            i16 = 384;
        } else {
            if (i11 == 3) {
                i15 = i12 == 2 ? f12716l[i13 - 1] : f12717m[i13 - 1];
                iA = ac.c.a(i15, 144000, i17, i18);
                i16 = 1152;
            } else {
                i15 = f12718n[i13 - 1];
                int i19 = i12 == 1 ? 576 : 1152;
                iA = ac.c.a(i12 == 1 ? 72000 : 144000, i15, i17, i18);
                i16 = i19;
            }
        }
        String str = f12712h[3 - i12];
        int i20 = ((i10 >> 6) & 3) == 3 ? 1 : 2;
        jVar.f12719a = i11;
        jVar.f12720b = str;
        jVar.f12721c = iA;
        jVar.f12722d = i17;
        jVar.f12723e = i20;
        jVar.f12724f = i15 * 1000;
        jVar.f12725g = i16;
        return true;
    }
}
