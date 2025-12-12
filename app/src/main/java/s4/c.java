package s4;

/* compiled from: InstanceFactory.java */
/* loaded from: classes.dex */
public final class c<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f19067a;

    public c(T t10) {
        this.f19067a = t10;
    }

    public static <T> b<T> create(T t10) {
        return new c(d.checkNotNull(t10, "instance cannot be null"));
    }

    @Override // jf.a
    public T get() {
        return this.f19067a;
    }
}
