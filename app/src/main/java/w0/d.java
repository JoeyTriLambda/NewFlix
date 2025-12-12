package w0;

import org.apache.commons.lang3.StringUtils;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public final class d<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f20843a;

    /* renamed from: b, reason: collision with root package name */
    public final S f20844b;

    public d(F f10, S s10) {
        this.f20843a = f10;
        this.f20844b = s10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.equals(dVar.f20843a, this.f20843a) && c.equals(dVar.f20844b, this.f20844b);
    }

    public int hashCode() {
        F f10 = this.f20843a;
        int iHashCode = f10 == null ? 0 : f10.hashCode();
        S s10 = this.f20844b;
        return (s10 != null ? s10.hashCode() : 0) ^ iHashCode;
    }

    public String toString() {
        return "Pair{" + this.f20843a + StringUtils.SPACE + this.f20844b + "}";
    }
}
