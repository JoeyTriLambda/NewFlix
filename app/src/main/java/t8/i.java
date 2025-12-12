package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
/* loaded from: classes.dex */
public final class i extends f0.e.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19721a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19722b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19723c;

    /* renamed from: d, reason: collision with root package name */
    public final f0.e.a.b f19724d = null;

    /* renamed from: e, reason: collision with root package name */
    public final String f19725e;

    /* renamed from: f, reason: collision with root package name */
    public final String f19726f;

    /* renamed from: g, reason: collision with root package name */
    public final String f19727g;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Application.java */
    public static final class a extends f0.e.a.AbstractC0263a {

        /* renamed from: a, reason: collision with root package name */
        public String f19728a;

        /* renamed from: b, reason: collision with root package name */
        public String f19729b;

        /* renamed from: c, reason: collision with root package name */
        public String f19730c;

        /* renamed from: d, reason: collision with root package name */
        public String f19731d;

        /* renamed from: e, reason: collision with root package name */
        public String f19732e;

        /* renamed from: f, reason: collision with root package name */
        public String f19733f;

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a build() {
            String strConcat = this.f19728a == null ? " identifier" : "";
            if (this.f19729b == null) {
                strConcat = strConcat.concat(" version");
            }
            if (strConcat.isEmpty()) {
                return new i(this.f19728a, this.f19729b, this.f19730c, this.f19731d, this.f19732e, this.f19733f);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setDevelopmentPlatform(String str) {
            this.f19732e = str;
            return this;
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setDevelopmentPlatformVersion(String str) {
            this.f19733f = str;
            return this;
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setDisplayVersion(String str) {
            this.f19730c = str;
            return this;
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setIdentifier(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f19728a = str;
            return this;
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setInstallationUuid(String str) {
            this.f19731d = str;
            return this;
        }

        @Override // t8.f0.e.a.AbstractC0263a
        public f0.e.a.AbstractC0263a setVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f19729b = str;
            return this;
        }
    }

    public i(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f19721a = str;
        this.f19722b = str2;
        this.f19723c = str3;
        this.f19725e = str4;
        this.f19726f = str5;
        this.f19727g = str6;
    }

    public boolean equals(Object obj) {
        String str;
        f0.e.a.b bVar;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.a)) {
            return false;
        }
        f0.e.a aVar = (f0.e.a) obj;
        if (this.f19721a.equals(aVar.getIdentifier()) && this.f19722b.equals(aVar.getVersion()) && ((str = this.f19723c) != null ? str.equals(aVar.getDisplayVersion()) : aVar.getDisplayVersion() == null) && ((bVar = this.f19724d) != null ? bVar.equals(aVar.getOrganization()) : aVar.getOrganization() == null) && ((str2 = this.f19725e) != null ? str2.equals(aVar.getInstallationUuid()) : aVar.getInstallationUuid() == null) && ((str3 = this.f19726f) != null ? str3.equals(aVar.getDevelopmentPlatform()) : aVar.getDevelopmentPlatform() == null)) {
            String str4 = this.f19727g;
            if (str4 == null) {
                if (aVar.getDevelopmentPlatformVersion() == null) {
                    return true;
                }
            } else if (str4.equals(aVar.getDevelopmentPlatformVersion())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.e.a
    public String getDevelopmentPlatform() {
        return this.f19726f;
    }

    @Override // t8.f0.e.a
    public String getDevelopmentPlatformVersion() {
        return this.f19727g;
    }

    @Override // t8.f0.e.a
    public String getDisplayVersion() {
        return this.f19723c;
    }

    @Override // t8.f0.e.a
    public String getIdentifier() {
        return this.f19721a;
    }

    @Override // t8.f0.e.a
    public String getInstallationUuid() {
        return this.f19725e;
    }

    @Override // t8.f0.e.a
    public f0.e.a.b getOrganization() {
        return this.f19724d;
    }

    @Override // t8.f0.e.a
    public String getVersion() {
        return this.f19722b;
    }

    public int hashCode() {
        int iHashCode = (((this.f19721a.hashCode() ^ 1000003) * 1000003) ^ this.f19722b.hashCode()) * 1000003;
        String str = this.f19723c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        f0.e.a.b bVar = this.f19724d;
        int iHashCode3 = (iHashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f19725e;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f19726f;
        int iHashCode5 = (iHashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f19727g;
        return iHashCode5 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Application{identifier=");
        sb2.append(this.f19721a);
        sb2.append(", version=");
        sb2.append(this.f19722b);
        sb2.append(", displayVersion=");
        sb2.append(this.f19723c);
        sb2.append(", organization=");
        sb2.append(this.f19724d);
        sb2.append(", installationUuid=");
        sb2.append(this.f19725e);
        sb2.append(", developmentPlatform=");
        sb2.append(this.f19726f);
        sb2.append(", developmentPlatformVersion=");
        return ac.c.o(sb2, this.f19727g, "}");
    }
}
