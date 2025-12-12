package mf;

/* compiled from: IndexedValue.kt */
/* loaded from: classes2.dex */
public final class s<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f16310a;

    /* renamed from: b, reason: collision with root package name */
    public final T f16311b;

    public s(int i10, T t10) {
        this.f16310a = i10;
        this.f16311b = t10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f16310a == sVar.f16310a && zf.i.areEqual(this.f16311b, sVar.f16311b);
    }

    public final int getIndex() {
        return this.f16310a;
    }

    public final T getValue() {
        return this.f16311b;
    }

    public int hashCode() {
        int i10 = this.f16310a * 31;
        T t10 = this.f16311b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.f16310a + ", value=" + this.f16311b + ')';
    }
}
