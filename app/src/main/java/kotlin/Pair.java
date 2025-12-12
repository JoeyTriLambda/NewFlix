package kotlin;

import java.io.Serializable;
import zf.i;

/* compiled from: Tuples.kt */
/* loaded from: classes2.dex */
public final class Pair<A, B> implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final A f15187b;

    /* renamed from: m, reason: collision with root package name */
    public final B f15188m;

    public Pair(A a10, B b10) {
        this.f15187b = a10;
        this.f15188m = b10;
    }

    public final A component1() {
        return this.f15187b;
    }

    public final B component2() {
        return this.f15188m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return i.areEqual(this.f15187b, pair.f15187b) && i.areEqual(this.f15188m, pair.f15188m);
    }

    public final A getFirst() {
        return this.f15187b;
    }

    public final B getSecond() {
        return this.f15188m;
    }

    public int hashCode() {
        A a10 = this.f15187b;
        int iHashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f15188m;
        return iHashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public String toString() {
        return "(" + this.f15187b + ", " + this.f15188m + ')';
    }
}
