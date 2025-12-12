package b3;

/* compiled from: NetworkState.kt */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4747a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4748b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4749c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4750d;

    public b(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f4747a = z10;
        this.f4748b = z11;
        this.f4749c = z12;
        this.f4750d = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f4747a == bVar.f4747a && this.f4748b == bVar.f4748b && this.f4749c == bVar.f4749c && this.f4750d == bVar.f4750d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        boolean z10 = this.f4747a;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = i10 * 31;
        boolean z11 = this.f4748b;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.f4749c;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.f4750d;
        return i15 + (z13 ? 1 : z13 ? 1 : 0);
    }

    public final boolean isConnected() {
        return this.f4747a;
    }

    public final boolean isMetered() {
        return this.f4749c;
    }

    public final boolean isNotRoaming() {
        return this.f4750d;
    }

    public final boolean isValidated() {
        return this.f4748b;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.f4747a + ", isValidated=" + this.f4748b + ", isMetered=" + this.f4749c + ", isNotRoaming=" + this.f4750d + ')';
    }
}
