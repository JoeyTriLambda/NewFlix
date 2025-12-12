package b4;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public float f4773a;

    /* renamed from: b, reason: collision with root package name */
    public float f4774b;

    public d(float f10, float f11) {
        this.f4773a = f10;
        this.f4774b = f11;
    }

    public boolean equals(float f10, float f11) {
        return this.f4773a == f10 && this.f4774b == f11;
    }

    public float getScaleX() {
        return this.f4773a;
    }

    public float getScaleY() {
        return this.f4774b;
    }

    public void set(float f10, float f11) {
        this.f4773a = f10;
        this.f4774b = f11;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
