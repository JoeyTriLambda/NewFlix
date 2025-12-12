package r8;

import r8.i0;

/* compiled from: AutoValue_InstallIdProvider_InstallIds.java */
/* loaded from: classes.dex */
public final class c extends i0.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f18672a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18673b;

    public c(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.f18672a = str;
        this.f18673b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i0.a)) {
            return false;
        }
        i0.a aVar = (i0.a) obj;
        if (this.f18672a.equals(aVar.getCrashlyticsInstallId())) {
            String str = this.f18673b;
            if (str == null) {
                if (aVar.getFirebaseInstallationId() == null) {
                    return true;
                }
            } else if (str.equals(aVar.getFirebaseInstallationId())) {
                return true;
            }
        }
        return false;
    }

    @Override // r8.i0.a
    public String getCrashlyticsInstallId() {
        return this.f18672a;
    }

    @Override // r8.i0.a
    public String getFirebaseInstallationId() {
        return this.f18673b;
    }

    public int hashCode() {
        int iHashCode = (this.f18672a.hashCode() ^ 1000003) * 1000003;
        String str = this.f18673b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("InstallIds{crashlyticsInstallId=");
        sb2.append(this.f18672a);
        sb2.append(", firebaseInstallationId=");
        return ac.c.o(sb2, this.f18673b, "}");
    }
}
