package j7;

/* compiled from: MathUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static float dist(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f12 - f10, f13 - f11);
    }

    public static float distanceToFurthestCorner(float f10, float f11, float f12, float f13, float f14, float f15) {
        float fDist = dist(f10, f11, f12, f13);
        float fDist2 = dist(f10, f11, f14, f13);
        float fDist3 = dist(f10, f11, f14, f15);
        float fDist4 = dist(f10, f11, f12, f15);
        return (fDist <= fDist2 || fDist <= fDist3 || fDist <= fDist4) ? (fDist2 <= fDist3 || fDist2 <= fDist4) ? fDist3 > fDist4 ? fDist3 : fDist4 : fDist2 : fDist;
    }

    public static float lerp(float f10, float f11, float f12) {
        return (f12 * f11) + ((1.0f - f12) * f10);
    }
}
