package b4;

/* compiled from: LottieValueCallback.java */
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final b<T> f4771a = new b<>();

    /* renamed from: b, reason: collision with root package name */
    public final T f4772b;

    public c(T t10) {
        this.f4772b = null;
        this.f4772b = t10;
    }

    public T getValue(b<T> bVar) {
        return this.f4772b;
    }

    public final T getValueInternal(float f10, float f11, T t10, T t11, float f12, float f13, float f14) {
        return getValue(this.f4771a.set(f10, f11, t10, t11, f12, f13, f14));
    }

    public final void setAnimation(s3.a<?, ?> aVar) {
    }
}
