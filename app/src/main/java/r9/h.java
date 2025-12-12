package r9;

/* compiled from: SessionEvent.kt */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f18861a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18862b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18863c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18864d;

    public h(String str, int i10, int i11, boolean z10) {
        zf.i.checkNotNullParameter(str, "processName");
        this.f18861a = str;
        this.f18862b = i10;
        this.f18863c = i11;
        this.f18864d = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return zf.i.areEqual(this.f18861a, hVar.f18861a) && this.f18862b == hVar.f18862b && this.f18863c == hVar.f18863c && this.f18864d == hVar.f18864d;
    }

    public final int getImportance() {
        return this.f18863c;
    }

    public final int getPid() {
        return this.f18862b;
    }

    public final String getProcessName() {
        return this.f18861a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = ((((this.f18861a.hashCode() * 31) + this.f18862b) * 31) + this.f18863c) * 31;
        boolean z10 = this.f18864d;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return iHashCode + i10;
    }

    public final boolean isDefaultProcess() {
        return this.f18864d;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.f18861a + ", pid=" + this.f18862b + ", importance=" + this.f18863c + ", isDefaultProcess=" + this.f18864d + ')';
    }
}
