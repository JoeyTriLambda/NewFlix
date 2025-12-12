package n0;

import android.graphics.Color;

/* compiled from: CamColor.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f16400a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16401b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16402c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16403d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16404e;

    /* renamed from: f, reason: collision with root package name */
    public final float f16405f;

    public a(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f16400a = f10;
        this.f16401b = f11;
        this.f16402c = f12;
        this.f16403d = f13;
        this.f16404e = f14;
        this.f16405f = f15;
    }

    public static a a(int i10) {
        j jVar = j.f16437k;
        float fE = c8.i.e(Color.red(i10));
        float fE2 = c8.i.e(Color.green(i10));
        float fE3 = c8.i.e(Color.blue(i10));
        float[][] fArr = c8.i.f5254e;
        float[] fArr2 = fArr[0];
        float f10 = (fArr2[2] * fE3) + (fArr2[1] * fE2) + (fArr2[0] * fE);
        float[] fArr3 = fArr[1];
        float f11 = (fArr3[2] * fE3) + (fArr3[1] * fE2) + (fArr3[0] * fE);
        float[] fArr4 = fArr[2];
        float f12 = (fE3 * fArr4[2]) + (fE2 * fArr4[1]) + (fE * fArr4[0]);
        float[][] fArr5 = c8.i.f5251b;
        float[] fArr6 = fArr5[0];
        float f13 = (fArr6[2] * f12) + (fArr6[1] * f11) + (fArr6[0] * f10);
        float[] fArr7 = fArr5[1];
        float f14 = (fArr7[2] * f12) + (fArr7[1] * f11) + (fArr7[0] * f10);
        float[] fArr8 = fArr5[2];
        float f15 = (f12 * fArr8[2]) + (f11 * fArr8[1]) + (f10 * fArr8[0]);
        float[] fArr9 = jVar.f16444g;
        float f16 = fArr9[0] * f13;
        float f17 = fArr9[1] * f14;
        float f18 = fArr9[2] * f15;
        float fAbs = Math.abs(f16);
        float f19 = jVar.f16445h;
        float fPow = (float) Math.pow((fAbs * f19) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f17) * f19) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f18) * f19) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f16) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f17) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f18) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d10 = fSignum3;
        float f20 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d10)) / 11.0f;
        float f21 = ((float) ((fSignum + fSignum2) - (d10 * 2.0d))) / 9.0f;
        float f22 = fSignum2 * 20.0f;
        float f23 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f22)) / 20.0f;
        float f24 = (((fSignum * 40.0f) + f22) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f21, f20)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f25 = fAtan2;
        float f26 = (3.1415927f * f25) / 180.0f;
        float f27 = f24 * jVar.f16439b;
        float f28 = jVar.f16438a;
        double d11 = f27 / f28;
        float f29 = jVar.f16447j;
        float f30 = jVar.f16441d;
        float fPow4 = ((float) Math.pow(d11, f29 * f30)) * 100.0f;
        Math.sqrt(fPow4 / 100.0f);
        float f31 = f28 + 4.0f;
        float fSqrt = ((float) Math.sqrt(fPow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, jVar.f16443f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) f25) < 20.14d ? 360.0f + f25 : f25) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * jVar.f16442e) * jVar.f16440c) * ((float) Math.sqrt((f21 * f21) + (f20 * f20)))) / (f23 + 0.305f), 0.9d));
        float f32 = jVar.f16446i * fSqrt;
        Math.sqrt((r3 * f30) / f31);
        float f33 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((f32 * 0.0228f) + 1.0f)) * 43.85965f;
        double d12 = f26;
        return new a(f25, fSqrt, fPow4, f33, ((float) Math.cos(d12)) * fLog, fLog * ((float) Math.sin(d12)));
    }

    public static a b(float f10, float f11, float f12) {
        j jVar = j.f16437k;
        float f13 = jVar.f16441d;
        Math.sqrt(f10 / 100.0d);
        float f14 = jVar.f16438a + 4.0f;
        float f15 = jVar.f16446i * f11;
        Math.sqrt(((f11 / ((float) Math.sqrt(r1))) * jVar.f16441d) / f14);
        float f16 = (1.7f * f10) / ((0.007f * f10) + 1.0f);
        float fLog = ((float) Math.log((f15 * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f12) / 180.0f;
        return new a(f12, f11, f10, f16, fLog * ((float) Math.cos(d10)), fLog * ((float) Math.sin(d10)));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int toColor(float r24, float r25, float r26) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.a.toColor(float, float, float):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int c(n0.j r17) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.a.c(n0.j):int");
    }
}
