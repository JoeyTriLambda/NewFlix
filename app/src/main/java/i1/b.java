package i1;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
public final class b<T> extends j<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f13102a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13103b;

    public b(T t10, int i10) {
        super(null);
        this.f13102a = t10;
        this.f13103b = i10;
    }

    public final void checkHashCode() {
        T t10 = this.f13102a;
        if (!((t10 != null ? t10.hashCode() : 0) == this.f13103b)) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }

    public final T getValue() {
        return this.f13102a;
    }
}
