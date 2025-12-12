package fa;

import ac.c;
import zf.f;

/* compiled from: CurrentProxyStats.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f11529a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11530b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11531c;

    public a() {
        this(0L, 0, 0, 7, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11529a == aVar.f11529a && this.f11530b == aVar.f11530b && this.f11531c == aVar.f11531c;
    }

    public int hashCode() {
        long j10 = this.f11529a;
        return (((((int) (j10 ^ (j10 >>> 32))) * 31) + this.f11530b) * 31) + this.f11531c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CurrentProxyStats(upTime=");
        sb2.append(this.f11529a);
        sb2.append(", apiRequests=");
        sb2.append(this.f11530b);
        sb2.append(", errors=");
        return c.l(sb2, this.f11531c, ')');
    }

    public a(long j10, int i10, int i11) {
        this.f11529a = j10;
        this.f11530b = i10;
        this.f11531c = i11;
    }

    public /* synthetic */ a(long j10, int i10, int i11, int i12, f fVar) {
        this((i12 & 1) != 0 ? 0L : j10, (i12 & 2) != 0 ? 0 : i10, (i12 & 4) != 0 ? 0 : i11);
    }
}
