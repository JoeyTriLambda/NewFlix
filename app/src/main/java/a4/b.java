package a4;

/* compiled from: GammaEvaluator.java */
/* loaded from: classes.dex */
public final class b {
    public static float a(float f10) {
        return f10 <= 0.04045f ? f10 / 12.92f : (float) Math.pow((f10 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static float b(float f10) {
        return f10 <= 0.0031308f ? f10 * 12.92f : (float) ((Math.pow(f10, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int evaluate(float f10, int i10, int i11) {
        if (i10 == i11) {
            return i10;
        }
        float f11 = ((i10 >> 24) & 255) / 255.0f;
        float f12 = ((i11 >> 24) & 255) / 255.0f;
        float fA = a(((i10 >> 16) & 255) / 255.0f);
        float fA2 = a(((i10 >> 8) & 255) / 255.0f);
        float fA3 = a((i10 & 255) / 255.0f);
        float fA4 = a(((i11 >> 16) & 255) / 255.0f);
        float fA5 = a(((i11 >> 8) & 255) / 255.0f);
        float fA6 = a((i11 & 255) / 255.0f);
        float fA7 = o1.a.a(f12, f11, f10, f11);
        float fA8 = o1.a.a(fA4, fA, f10, fA);
        float fA9 = o1.a.a(fA5, fA2, f10, fA2);
        float fA10 = o1.a.a(fA6, fA3, f10, fA3);
        float fB = b(fA8) * 255.0f;
        float fB2 = b(fA9) * 255.0f;
        return Math.round(b(fA10) * 255.0f) | (Math.round(fB) << 16) | (Math.round(fA7 * 255.0f) << 24) | (Math.round(fB2) << 8);
    }
}
