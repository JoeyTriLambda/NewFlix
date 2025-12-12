package n0;

/* compiled from: ViewingConditions.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: k, reason: collision with root package name */
    public static final j f16437k;

    /* renamed from: a, reason: collision with root package name */
    public final float f16438a;

    /* renamed from: b, reason: collision with root package name */
    public final float f16439b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16440c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16441d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16442e;

    /* renamed from: f, reason: collision with root package name */
    public final float f16443f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f16444g;

    /* renamed from: h, reason: collision with root package name */
    public final float f16445h;

    /* renamed from: i, reason: collision with root package name */
    public final float f16446i;

    /* renamed from: j, reason: collision with root package name */
    public final float f16447j;

    static {
        float f10;
        float f11;
        float[] fArr = c8.i.f5253d;
        float fQ = (float) ((c8.i.q() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = c8.i.f5251b;
        float f12 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f13 = fArr3[0] * f12;
        float f14 = fArr[1];
        float f15 = (fArr3[1] * f14) + f13;
        float f16 = fArr[2];
        float f17 = (fArr3[2] * f16) + f15;
        float[] fArr4 = fArr2[1];
        float f18 = (fArr4[2] * f16) + (fArr4[1] * f14) + (fArr4[0] * f12);
        float[] fArr5 = fArr2[2];
        float f19 = (f16 * fArr5[2]) + (f14 * fArr5[1]) + (f12 * fArr5[0]);
        if (1.0f >= 0.9d) {
            f10 = 0.100000046f;
            f11 = 0.59f;
        } else {
            f10 = 0.12999998f;
            f11 = 0.525f;
        }
        float f20 = f10 + f11;
        float fExp = (1.0f - (((float) Math.exp(((-fQ) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d10 = fExp;
        if (d10 > 1.0d) {
            fExp = 1.0f;
        } else if (d10 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f17) * fExp) + 1.0f) - fExp, (((100.0f / f18) * fExp) + 1.0f) - fExp, (((100.0f / f19) * fExp) + 1.0f) - fExp};
        float f21 = 1.0f / ((5.0f * fQ) + 1.0f);
        float f22 = f21 * f21 * f21 * f21;
        float f23 = 1.0f - f22;
        float fCbrt = (0.1f * f23 * f23 * ((float) Math.cbrt(fQ * 5.0d))) + (f22 * fQ);
        float fQ2 = c8.i.q() / fArr[1];
        double d11 = fQ2;
        float fSqrt = ((float) Math.sqrt(d11)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d11, 0.2d));
        float fPow2 = (float) Math.pow(((fArr6[2] * fCbrt) * f19) / 100.0d, 0.42d);
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f17) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f18) / 100.0d, 0.42d), fPow2};
        float f24 = fArr7[0];
        float f25 = fArr7[1];
        f16437k = new j(fQ2, ((((400.0f * fPow2) / (fPow2 + 27.13f)) * 0.05f) + (((f24 * 400.0f) / (f24 + 27.13f)) * 2.0f) + ((f25 * 400.0f) / (f25 + 27.13f))) * fPow, fPow, fPow, f20, 1.0f, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public j(float f10, float f11, float f12, float f13, float f14, float f15, float[] fArr, float f16, float f17, float f18) {
        this.f16443f = f10;
        this.f16438a = f11;
        this.f16439b = f12;
        this.f16440c = f13;
        this.f16441d = f14;
        this.f16442e = f15;
        this.f16444g = fArr;
        this.f16445h = f16;
        this.f16446i = f17;
        this.f16447j = f18;
    }
}
