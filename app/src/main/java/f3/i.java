package f3;

/* compiled from: SystemIdInfo.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f11409a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11410b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11411c;

    public i(String str, int i10, int i11) {
        zf.i.checkNotNullParameter(str, "workSpecId");
        this.f11409a = str;
        this.f11410b = i10;
        this.f11411c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return zf.i.areEqual(this.f11409a, iVar.f11409a) && this.f11410b == iVar.f11410b && this.f11411c == iVar.f11411c;
    }

    public final int getGeneration() {
        return this.f11410b;
    }

    public int hashCode() {
        return (((this.f11409a.hashCode() * 31) + this.f11410b) * 31) + this.f11411c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SystemIdInfo(workSpecId=");
        sb2.append(this.f11409a);
        sb2.append(", generation=");
        sb2.append(this.f11410b);
        sb2.append(", systemId=");
        return ac.c.l(sb2, this.f11411c, ')');
    }
}
