package b2;

/* compiled from: Target.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f4737e;

    /* renamed from: f, reason: collision with root package name */
    public static final c f4738f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f4739g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f4740h;

    /* renamed from: i, reason: collision with root package name */
    public static final c f4741i;

    /* renamed from: j, reason: collision with root package name */
    public static final c f4742j;

    /* renamed from: a, reason: collision with root package name */
    public final float[] f4743a = {0.0f, 0.5f, 1.0f};

    /* renamed from: b, reason: collision with root package name */
    public final float[] f4744b = {0.0f, 0.5f, 1.0f};

    /* renamed from: c, reason: collision with root package name */
    public final float[] f4745c = {0.24f, 0.52f, 0.24f};

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4746d = true;

    static {
        c cVar = new c();
        f4737e = cVar;
        float[] fArr = cVar.f4744b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
        float[] fArr2 = cVar.f4743a;
        fArr2[0] = 0.35f;
        fArr2[1] = 1.0f;
        c cVar2 = new c();
        f4738f = cVar2;
        float[] fArr3 = cVar2.f4744b;
        fArr3[0] = 0.3f;
        fArr3[1] = 0.5f;
        fArr3[2] = 0.7f;
        float[] fArr4 = cVar2.f4743a;
        fArr4[0] = 0.35f;
        fArr4[1] = 1.0f;
        c cVar3 = new c();
        f4739g = cVar3;
        float[] fArr5 = cVar3.f4744b;
        fArr5[1] = 0.26f;
        fArr5[2] = 0.45f;
        float[] fArr6 = cVar3.f4743a;
        fArr6[0] = 0.35f;
        fArr6[1] = 1.0f;
        c cVar4 = new c();
        f4740h = cVar4;
        float[] fArr7 = cVar4.f4744b;
        fArr7[0] = 0.55f;
        fArr7[1] = 0.74f;
        float[] fArr8 = cVar4.f4743a;
        fArr8[1] = 0.3f;
        fArr8[2] = 0.4f;
        c cVar5 = new c();
        f4741i = cVar5;
        float[] fArr9 = cVar5.f4744b;
        fArr9[0] = 0.3f;
        fArr9[1] = 0.5f;
        fArr9[2] = 0.7f;
        float[] fArr10 = cVar5.f4743a;
        fArr10[1] = 0.3f;
        fArr10[2] = 0.4f;
        c cVar6 = new c();
        f4742j = cVar6;
        float[] fArr11 = cVar6.f4744b;
        fArr11[1] = 0.26f;
        fArr11[2] = 0.45f;
        float[] fArr12 = cVar6.f4743a;
        fArr12[1] = 0.3f;
        fArr12[2] = 0.4f;
    }

    public float getLightnessWeight() {
        return this.f4745c[1];
    }

    public float getMaximumLightness() {
        return this.f4744b[2];
    }

    public float getMaximumSaturation() {
        return this.f4743a[2];
    }

    public float getMinimumLightness() {
        return this.f4744b[0];
    }

    public float getMinimumSaturation() {
        return this.f4743a[0];
    }

    public float getPopulationWeight() {
        return this.f4745c[2];
    }

    public float getSaturationWeight() {
        return this.f4745c[0];
    }

    public float getTargetLightness() {
        return this.f4744b[1];
    }

    public float getTargetSaturation() {
        return this.f4743a[1];
    }

    public boolean isExclusive() {
        return this.f4746d;
    }
}
