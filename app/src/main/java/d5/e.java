package d5;

import cz.msebera.android.httpclient.HttpStatus;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: Sonic.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f10873a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10874b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10875c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10876d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10877e;

    /* renamed from: f, reason: collision with root package name */
    public final short[] f10878f;

    /* renamed from: g, reason: collision with root package name */
    public int f10879g;

    /* renamed from: h, reason: collision with root package name */
    public short[] f10880h;

    /* renamed from: i, reason: collision with root package name */
    public int f10881i;

    /* renamed from: j, reason: collision with root package name */
    public short[] f10882j;

    /* renamed from: k, reason: collision with root package name */
    public int f10883k;

    /* renamed from: l, reason: collision with root package name */
    public short[] f10884l;

    /* renamed from: q, reason: collision with root package name */
    public int f10889q;

    /* renamed from: r, reason: collision with root package name */
    public int f10890r;

    /* renamed from: s, reason: collision with root package name */
    public int f10891s;

    /* renamed from: t, reason: collision with root package name */
    public int f10892t;

    /* renamed from: v, reason: collision with root package name */
    public int f10894v;

    /* renamed from: w, reason: collision with root package name */
    public int f10895w;

    /* renamed from: x, reason: collision with root package name */
    public int f10896x;

    /* renamed from: m, reason: collision with root package name */
    public int f10885m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f10886n = 0;

    /* renamed from: u, reason: collision with root package name */
    public int f10893u = 0;

    /* renamed from: o, reason: collision with root package name */
    public float f10887o = 1.0f;

    /* renamed from: p, reason: collision with root package name */
    public float f10888p = 1.0f;

    public e(int i10, int i11) {
        this.f10873a = i10;
        this.f10874b = i11;
        this.f10875c = i10 / HttpStatus.SC_BAD_REQUEST;
        int i12 = i10 / 65;
        this.f10876d = i12;
        int i13 = i12 * 2;
        this.f10877e = i13;
        this.f10878f = new short[i13];
        this.f10879g = i13;
        this.f10880h = new short[i13 * i11];
        this.f10881i = i13;
        this.f10882j = new short[i13 * i11];
        this.f10883k = i13;
        this.f10884l = new short[i13 * i11];
    }

    public static void d(int i10, int i11, short[] sArr, int i12, short[] sArr2, int i13, short[] sArr3, int i14) {
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = (i12 * i11) + i15;
            int i17 = (i14 * i11) + i15;
            int i18 = (i13 * i11) + i15;
            for (int i19 = 0; i19 < i10; i19++) {
                sArr[i16] = (short) (((sArr3[i17] * i19) + ((i10 - i19) * sArr2[i18])) / i10);
                i16 += i11;
                i18 += i11;
                i17 += i11;
            }
        }
    }

    public final void a(short[] sArr, int i10, int i11) {
        int i12 = this.f10877e / i11;
        int i13 = this.f10874b;
        int i14 = i11 * i13;
        int i15 = i10 * i13;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                i17 += sArr[(i16 * i14) + i15 + i18];
            }
            this.f10878f[i16] = (short) (i17 / i14);
        }
    }

    public final void b(int i10) {
        int i11 = this.f10890r + i10;
        int i12 = this.f10881i;
        if (i11 > i12) {
            int i13 = (i12 / 2) + i10 + i12;
            this.f10881i = i13;
            this.f10882j = Arrays.copyOf(this.f10882j, i13 * this.f10874b);
        }
    }

    public final int c(short[] sArr, int i10, int i11, int i12) {
        int i13 = i10 * this.f10874b;
        int i14 = 255;
        int i15 = 1;
        int i16 = 0;
        int i17 = 0;
        while (i11 <= i12) {
            int iAbs = 0;
            for (int i18 = 0; i18 < i11; i18++) {
                iAbs += Math.abs(sArr[i13 + i18] - sArr[(i13 + i11) + i18]);
            }
            if (iAbs * i16 < i15 * i11) {
                i16 = i11;
                i15 = iAbs;
            }
            if (iAbs * i14 > i17 * i11) {
                i14 = i11;
                i17 = iAbs;
            }
            i11++;
        }
        this.f10895w = i15 / i16;
        this.f10896x = i17 / i14;
        return i16;
    }

    public final void e() {
        int i10;
        int i11;
        int iC;
        int i12;
        int i13;
        float f10;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19 = this.f10890r;
        float f11 = this.f10887o / this.f10888p;
        double d10 = f11;
        int i20 = this.f10873a;
        int i21 = this.f10874b;
        if (d10 > 1.00001d || d10 < 0.99999d) {
            int i22 = this.f10889q;
            int i23 = this.f10877e;
            if (i22 >= i23) {
                int i24 = 0;
                while (true) {
                    int i25 = this.f10892t;
                    if (i25 > 0) {
                        int iMin = Math.min(i23, i25);
                        short[] sArr = this.f10880h;
                        b(iMin);
                        System.arraycopy(sArr, i24 * i21, this.f10882j, this.f10890r * i21, i21 * iMin);
                        this.f10890r += iMin;
                        this.f10892t -= iMin;
                        i24 += iMin;
                        i11 = i19;
                        i10 = i20;
                    } else {
                        short[] sArr2 = this.f10880h;
                        int i26 = i20 > 4000 ? i20 / 4000 : 1;
                        int i27 = this.f10876d;
                        int i28 = this.f10875c;
                        if (i21 == 1 && i26 == 1) {
                            iC = c(sArr2, i24, i28, i27);
                            i11 = i19;
                            i10 = i20;
                        } else {
                            a(sArr2, i24, i26);
                            i10 = i20;
                            short[] sArr3 = this.f10878f;
                            i11 = i19;
                            int iC2 = c(sArr3, 0, i28 / i26, i27 / i26);
                            if (i26 != 1) {
                                int i29 = iC2 * i26;
                                int i30 = i26 * 4;
                                int i31 = i29 - i30;
                                int i32 = i29 + i30;
                                if (i31 >= i28) {
                                    i28 = i31;
                                }
                                if (i32 <= i27) {
                                    i27 = i32;
                                }
                                if (i21 == 1) {
                                    iC = c(sArr2, i24, i28, i27);
                                } else {
                                    a(sArr2, i24, 1);
                                    iC = c(sArr3, 0, i28, i27);
                                }
                            } else {
                                iC = iC2;
                            }
                        }
                        int i33 = this.f10895w;
                        int i34 = i33 != 0 && this.f10893u != 0 && this.f10896x <= i33 * 3 && i33 * 2 > this.f10894v * 3 ? this.f10893u : iC;
                        this.f10894v = i33;
                        this.f10893u = iC;
                        if (d10 > 1.0d) {
                            short[] sArr4 = this.f10880h;
                            if (f11 >= 2.0f) {
                                i13 = (int) (i34 / (f11 - 1.0f));
                            } else {
                                this.f10892t = (int) (((2.0f - f11) * i34) / (f11 - 1.0f));
                                i13 = i34;
                            }
                            b(i13);
                            int i35 = i24;
                            d(i13, this.f10874b, this.f10882j, this.f10890r, sArr4, i35, sArr4, i24 + i34);
                            this.f10890r += i13;
                            i24 = i34 + i13 + i35;
                        } else {
                            int i36 = i24;
                            short[] sArr5 = this.f10880h;
                            if (f11 < 0.5f) {
                                i12 = (int) ((i34 * f11) / (1.0f - f11));
                            } else {
                                this.f10892t = (int) ((((2.0f * f11) - 1.0f) * i34) / (1.0f - f11));
                                i12 = i34;
                            }
                            int i37 = i34 + i12;
                            b(i37);
                            System.arraycopy(sArr5, i36 * i21, this.f10882j, this.f10890r * i21, i21 * i34);
                            d(i12, this.f10874b, this.f10882j, this.f10890r + i34, sArr5, i36 + i34, sArr5, i36);
                            this.f10890r += i37;
                            i24 = i36 + i12;
                        }
                    }
                    if (i24 + i23 > i22) {
                        break;
                    }
                    i20 = i10;
                    i19 = i11;
                }
                int i38 = this.f10889q - i24;
                short[] sArr6 = this.f10880h;
                System.arraycopy(sArr6, i24 * i21, sArr6, 0, i21 * i38);
                this.f10889q = i38;
            }
            f10 = this.f10888p;
            if (f10 != 1.0f || this.f10890r == (i14 = i11)) {
            }
            int i39 = i10;
            int i40 = (int) (i39 / f10);
            while (true) {
                if (i40 <= 16384 && i39 <= 16384) {
                    break;
                }
                i40 /= 2;
                i39 /= 2;
            }
            int i41 = this.f10890r - i14;
            int i42 = this.f10891s + i41;
            int i43 = this.f10883k;
            if (i42 > i43) {
                int i44 = (i43 / 2) + i41 + i43;
                this.f10883k = i44;
                this.f10884l = Arrays.copyOf(this.f10884l, i44 * i21);
            }
            System.arraycopy(this.f10882j, i14 * i21, this.f10884l, this.f10891s * i21, i21 * i41);
            this.f10890r = i14;
            this.f10891s += i41;
            int i45 = 0;
            while (true) {
                i15 = this.f10891s;
                i16 = i15 - 1;
                if (i45 >= i16) {
                    break;
                }
                while (true) {
                    i17 = this.f10885m + 1;
                    int i46 = i17 * i40;
                    i18 = this.f10886n;
                    if (i46 <= i18 * i39) {
                        break;
                    }
                    b(1);
                    for (int i47 = 0; i47 < i21; i47++) {
                        short[] sArr7 = this.f10882j;
                        int i48 = (this.f10890r * i21) + i47;
                        short[] sArr8 = this.f10884l;
                        int i49 = (i45 * i21) + i47;
                        short s10 = sArr8[i49];
                        short s11 = sArr8[i49 + i21];
                        int i50 = this.f10886n * i39;
                        int i51 = this.f10885m;
                        int i52 = i51 * i40;
                        int i53 = (i51 + 1) * i40;
                        int i54 = i53 - i50;
                        int i55 = i53 - i52;
                        sArr7[i48] = (short) ((((i55 - i54) * s11) + (s10 * i54)) / i55);
                    }
                    this.f10886n++;
                    this.f10890r++;
                }
                this.f10885m = i17;
                if (i17 == i39) {
                    this.f10885m = 0;
                    l6.a.checkState(i18 == i40);
                    this.f10886n = 0;
                }
                i45++;
            }
            if (i16 == 0) {
                return;
            }
            short[] sArr9 = this.f10884l;
            System.arraycopy(sArr9, i16 * i21, sArr9, 0, (i15 - i16) * i21);
            this.f10891s -= i16;
            return;
        }
        short[] sArr10 = this.f10880h;
        int i56 = this.f10889q;
        b(i56);
        System.arraycopy(sArr10, 0 * i21, this.f10882j, this.f10890r * i21, i21 * i56);
        this.f10890r += i56;
        this.f10889q = 0;
        i11 = i19;
        i10 = i20;
        f10 = this.f10888p;
        if (f10 != 1.0f) {
        }
    }

    public void getOutput(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i10 = this.f10874b;
        int iMin = Math.min(iRemaining / i10, this.f10890r);
        shortBuffer.put(this.f10882j, 0, iMin * i10);
        int i11 = this.f10890r - iMin;
        this.f10890r = i11;
        short[] sArr = this.f10882j;
        System.arraycopy(sArr, iMin * i10, sArr, 0, i11 * i10);
    }

    public int getSamplesAvailable() {
        return this.f10890r;
    }

    public void queueEndOfStream() {
        int i10 = this.f10889q;
        float f10 = this.f10887o;
        float f11 = this.f10888p;
        int i11 = this.f10890r + ((int) ((((i10 / (f10 / f11)) + this.f10891s) / f11) + 0.5f));
        int i12 = this.f10877e * 2;
        int i13 = i12 + i10;
        int i14 = i10 + i13;
        int i15 = this.f10879g;
        int i16 = this.f10874b;
        if (i14 > i15) {
            int i17 = (i15 / 2) + i13 + i15;
            this.f10879g = i17;
            this.f10880h = Arrays.copyOf(this.f10880h, i17 * i16);
        }
        for (int i18 = 0; i18 < i12 * i16; i18++) {
            this.f10880h[(i16 * i10) + i18] = 0;
        }
        this.f10889q = i12 + this.f10889q;
        e();
        if (this.f10890r > i11) {
            this.f10890r = i11;
        }
        this.f10889q = 0;
        this.f10892t = 0;
        this.f10891s = 0;
    }

    public void queueInput(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i10 = this.f10874b;
        int i11 = iRemaining / i10;
        int i12 = i11 * i10 * 2;
        int i13 = this.f10889q + i11;
        int i14 = this.f10879g;
        if (i13 > i14) {
            int i15 = (i14 / 2) + i11 + i14;
            this.f10879g = i15;
            this.f10880h = Arrays.copyOf(this.f10880h, i15 * i10);
        }
        shortBuffer.get(this.f10880h, this.f10889q * i10, i12 / 2);
        this.f10889q += i11;
        e();
    }

    public void setPitch(float f10) {
        this.f10888p = f10;
    }

    public void setSpeed(float f10) {
        this.f10887o = f10;
    }
}
