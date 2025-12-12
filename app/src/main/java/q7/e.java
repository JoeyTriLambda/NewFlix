package q7;

/* compiled from: CutCornerTreatment.java */
/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: a, reason: collision with root package name */
    public final float f17927a = -1.0f;

    @Override // q7.d
    public void getCornerPath(o oVar, float f10, float f11, float f12) {
        oVar.reset(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double d10 = f12;
        double d11 = f11;
        oVar.lineTo((float) (Math.sin(Math.toRadians(f10)) * d10 * d11), (float) (Math.sin(Math.toRadians(90.0f - f10)) * d10 * d11));
    }
}
