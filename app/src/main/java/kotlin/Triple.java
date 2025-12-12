package kotlin;

import java.io.Serializable;
import zf.i;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class Triple<A, B, C> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final A f15198b;

    /* renamed from: m, reason: collision with root package name */
    public final B f15199m;

    /* renamed from: n, reason: collision with root package name */
    public final C f15200n;

    public Triple(A a10, B b10, C c10) {
        this.f15198b = a10;
        this.f15199m = b10;
        this.f15200n = c10;
    }

    public final A component1() {
        return this.f15198b;
    }

    public final B component2() {
        return this.f15199m;
    }

    public final C component3() {
        return this.f15200n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return i.areEqual(this.f15198b, triple.f15198b) && i.areEqual(this.f15199m, triple.f15199m) && i.areEqual(this.f15200n, triple.f15200n);
    }

    public int hashCode() {
        A a10 = this.f15198b;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f15199m;
        int iHashCode2 = (iHashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.f15200n;
        return iHashCode2 + (c10 != null ? c10.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.f15198b + ", " + this.f15199m + ", " + this.f15200n + ')';
    }
}
