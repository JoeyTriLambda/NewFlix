package u3;

import org.apache.commons.lang3.StringUtils;

/* compiled from: MutablePair.java */
/* loaded from: classes.dex */
public final class h<T> {

    /* renamed from: a, reason: collision with root package name */
    public T f19996a;

    /* renamed from: b, reason: collision with root package name */
    public T f19997b;

    public boolean equals(Object obj) {
        if (!(obj instanceof w0.d)) {
            return false;
        }
        w0.d dVar = (w0.d) obj;
        F f10 = dVar.f20843a;
        Object obj2 = this.f19996a;
        if (!(f10 == obj2 || (f10 != 0 && f10.equals(obj2)))) {
            return false;
        }
        Object obj3 = this.f19997b;
        S s10 = dVar.f20844b;
        return s10 == obj3 || (s10 != 0 && s10.equals(obj3));
    }

    public int hashCode() {
        T t10 = this.f19996a;
        int iHashCode = t10 == null ? 0 : t10.hashCode();
        T t11 = this.f19997b;
        return iHashCode ^ (t11 != null ? t11.hashCode() : 0);
    }

    public void set(T t10, T t11) {
        this.f19996a = t10;
        this.f19997b = t11;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f19996a) + StringUtils.SPACE + String.valueOf(this.f19997b) + "}";
    }
}
