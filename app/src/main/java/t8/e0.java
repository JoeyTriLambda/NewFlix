package t8;

import t8.g0;

/* compiled from: AutoValue_StaticSessionData_OsData.java */
/* loaded from: classes.dex */
public final class e0 extends g0.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19685a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19686b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19687c;

    public e0(String str, String str2, boolean z10) {
        if (str == null) {
            throw new NullPointerException("Null osRelease");
        }
        this.f19685a = str;
        if (str2 == null) {
            throw new NullPointerException("Null osCodeName");
        }
        this.f19686b = str2;
        this.f19687c = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.c)) {
            return false;
        }
        g0.c cVar = (g0.c) obj;
        return this.f19685a.equals(cVar.osRelease()) && this.f19686b.equals(cVar.osCodeName()) && this.f19687c == cVar.isRooted();
    }

    public int hashCode() {
        return ((((this.f19685a.hashCode() ^ 1000003) * 1000003) ^ this.f19686b.hashCode()) * 1000003) ^ (this.f19687c ? 1231 : 1237);
    }

    @Override // t8.g0.c
    public boolean isRooted() {
        return this.f19687c;
    }

    @Override // t8.g0.c
    public String osCodeName() {
        return this.f19686b;
    }

    @Override // t8.g0.c
    public String osRelease() {
        return this.f19685a;
    }

    public String toString() {
        return "OsData{osRelease=" + this.f19685a + ", osCodeName=" + this.f19686b + ", isRooted=" + this.f19687c + "}";
    }
}
