package k;

import zf.i;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f14699a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14700b;

    public b(long j10, String str) {
        i.checkNotNullParameter(str, "message");
        this.f14699a = j10;
        this.f14700b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14699a == bVar.f14699a && i.areEqual(this.f14700b, bVar.f14700b);
    }

    public final int hashCode() {
        long j10 = this.f14699a;
        return this.f14700b.hashCode() + (((int) (j10 ^ (j10 >>> 32))) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("DebugMessage(timestamp=");
        sb2.append(this.f14699a);
        sb2.append(", message=");
        return ac.c.n(sb2, this.f14700b, ')');
    }
}
