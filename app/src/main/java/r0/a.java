package r0;

/* compiled from: MathUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static float clamp(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    public static int clamp(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }
}
