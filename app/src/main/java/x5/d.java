package x5;

import l6.u;

/* compiled from: Descriptor.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f21581a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21582b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21583c;

    public d(String str, String str2, String str3) {
        this.f21581a = str;
        this.f21582b = str2;
        this.f21583c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return u.areEqual(this.f21581a, dVar.f21581a) && u.areEqual(this.f21582b, dVar.f21582b) && u.areEqual(this.f21583c, dVar.f21583c);
    }

    public int hashCode() {
        String str = this.f21581a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f21582b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f21583c;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }
}
