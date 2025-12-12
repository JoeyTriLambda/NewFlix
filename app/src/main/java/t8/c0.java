package t8;

import t8.g0;

/* compiled from: AutoValue_StaticSessionData_AppData.java */
/* loaded from: classes.dex */
public final class c0 extends g0.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19660a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19661b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19662c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19663d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19664e;

    /* renamed from: f, reason: collision with root package name */
    public final o8.d f19665f;

    public c0(String str, String str2, String str3, String str4, int i10, o8.d dVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f19660a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f19661b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f19662c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f19663d = str4;
        this.f19664e = i10;
        if (dVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f19665f = dVar;
    }

    @Override // t8.g0.a
    public String appIdentifier() {
        return this.f19660a;
    }

    @Override // t8.g0.a
    public int deliveryMechanism() {
        return this.f19664e;
    }

    @Override // t8.g0.a
    public o8.d developmentPlatformProvider() {
        return this.f19665f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0.a)) {
            return false;
        }
        g0.a aVar = (g0.a) obj;
        return this.f19660a.equals(aVar.appIdentifier()) && this.f19661b.equals(aVar.versionCode()) && this.f19662c.equals(aVar.versionName()) && this.f19663d.equals(aVar.installUuid()) && this.f19664e == aVar.deliveryMechanism() && this.f19665f.equals(aVar.developmentPlatformProvider());
    }

    public int hashCode() {
        return ((((((((((this.f19660a.hashCode() ^ 1000003) * 1000003) ^ this.f19661b.hashCode()) * 1000003) ^ this.f19662c.hashCode()) * 1000003) ^ this.f19663d.hashCode()) * 1000003) ^ this.f19664e) * 1000003) ^ this.f19665f.hashCode();
    }

    @Override // t8.g0.a
    public String installUuid() {
        return this.f19663d;
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f19660a + ", versionCode=" + this.f19661b + ", versionName=" + this.f19662c + ", installUuid=" + this.f19663d + ", deliveryMechanism=" + this.f19664e + ", developmentPlatformProvider=" + this.f19665f + "}";
    }

    @Override // t8.g0.a
    public String versionCode() {
        return this.f19661b;
    }

    @Override // t8.g0.a
    public String versionName() {
        return this.f19662c;
    }
}
