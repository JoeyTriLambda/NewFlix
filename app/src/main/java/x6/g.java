package x6;

/* compiled from: CarouselStrategy.java */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public float f21633a;

    /* renamed from: b, reason: collision with root package name */
    public float f21634b;

    public static float a(float f10, float f11, float f12) {
        return 1.0f - ((f10 - f12) / (f11 - f12));
    }

    public float getSmallItemSizeMax() {
        return this.f21634b;
    }

    public float getSmallItemSizeMin() {
        return this.f21633a;
    }
}
