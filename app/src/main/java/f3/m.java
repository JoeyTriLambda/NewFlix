package f3;

/* compiled from: WorkSpec.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f11416a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11417b;

    public m(String str, int i10) {
        zf.i.checkNotNullParameter(str, "workSpecId");
        this.f11416a = str;
        this.f11417b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return zf.i.areEqual(this.f11416a, mVar.f11416a) && this.f11417b == mVar.f11417b;
    }

    public final int getGeneration() {
        return this.f11417b;
    }

    public final String getWorkSpecId() {
        return this.f11416a;
    }

    public int hashCode() {
        return (this.f11416a.hashCode() * 31) + this.f11417b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb2.append(this.f11416a);
        sb2.append(", generation=");
        return ac.c.l(sb2, this.f11417b, ')');
    }
}
