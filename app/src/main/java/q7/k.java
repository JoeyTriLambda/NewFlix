package q7;

/* compiled from: RoundedCornerTreatment.java */
/* loaded from: classes.dex */
public final class k extends d {

    /* renamed from: a, reason: collision with root package name */
    public final float f17967a = -1.0f;

    @Override // q7.d
    public void getCornerPath(o oVar, float f10, float f11, float f12) {
        oVar.reset(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        oVar.addArc(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }
}
