package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport.java */
/* loaded from: classes.dex */
public final class b extends f0 {

    /* renamed from: b, reason: collision with root package name */
    public final String f19617b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19618c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19619d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19620e;

    /* renamed from: f, reason: collision with root package name */
    public final String f19621f;

    /* renamed from: g, reason: collision with root package name */
    public final String f19622g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19623h;

    /* renamed from: i, reason: collision with root package name */
    public final String f19624i;

    /* renamed from: j, reason: collision with root package name */
    public final f0.e f19625j;

    /* renamed from: k, reason: collision with root package name */
    public final f0.d f19626k;

    /* renamed from: l, reason: collision with root package name */
    public final f0.a f19627l;

    /* compiled from: AutoValue_CrashlyticsReport.java */
    public static final class a extends f0.b {

        /* renamed from: a, reason: collision with root package name */
        public String f19628a;

        /* renamed from: b, reason: collision with root package name */
        public String f19629b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f19630c;

        /* renamed from: d, reason: collision with root package name */
        public String f19631d;

        /* renamed from: e, reason: collision with root package name */
        public String f19632e;

        /* renamed from: f, reason: collision with root package name */
        public String f19633f;

        /* renamed from: g, reason: collision with root package name */
        public String f19634g;

        /* renamed from: h, reason: collision with root package name */
        public String f19635h;

        /* renamed from: i, reason: collision with root package name */
        public f0.e f19636i;

        /* renamed from: j, reason: collision with root package name */
        public f0.d f19637j;

        /* renamed from: k, reason: collision with root package name */
        public f0.a f19638k;

        public a() {
        }

        @Override // t8.f0.b
        public f0 build() {
            String strB = this.f19628a == null ? " sdkVersion" : "";
            if (this.f19629b == null) {
                strB = strB.concat(" gmpAppId");
            }
            if (this.f19630c == null) {
                strB = ac.c.B(strB, " platform");
            }
            if (this.f19631d == null) {
                strB = ac.c.B(strB, " installationUuid");
            }
            if (this.f19634g == null) {
                strB = ac.c.B(strB, " buildVersion");
            }
            if (this.f19635h == null) {
                strB = ac.c.B(strB, " displayVersion");
            }
            if (strB.isEmpty()) {
                return new b(this.f19628a, this.f19629b, this.f19630c.intValue(), this.f19631d, this.f19632e, this.f19633f, this.f19634g, this.f19635h, this.f19636i, this.f19637j, this.f19638k);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.b
        public f0.b setAppExitInfo(f0.a aVar) {
            this.f19638k = aVar;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setAppQualitySessionId(String str) {
            this.f19633f = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setBuildVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f19634g = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setDisplayVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null displayVersion");
            }
            this.f19635h = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setFirebaseInstallationId(String str) {
            this.f19632e = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setGmpAppId(String str) {
            if (str == null) {
                throw new NullPointerException("Null gmpAppId");
            }
            this.f19629b = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setInstallationUuid(String str) {
            if (str == null) {
                throw new NullPointerException("Null installationUuid");
            }
            this.f19631d = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setNdkPayload(f0.d dVar) {
            this.f19637j = dVar;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setPlatform(int i10) {
            this.f19630c = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.b
        public f0.b setSdkVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkVersion");
            }
            this.f19628a = str;
            return this;
        }

        @Override // t8.f0.b
        public f0.b setSession(f0.e eVar) {
            this.f19636i = eVar;
            return this;
        }

        public a(f0 f0Var) {
            this.f19628a = f0Var.getSdkVersion();
            this.f19629b = f0Var.getGmpAppId();
            this.f19630c = Integer.valueOf(f0Var.getPlatform());
            this.f19631d = f0Var.getInstallationUuid();
            this.f19632e = f0Var.getFirebaseInstallationId();
            this.f19633f = f0Var.getAppQualitySessionId();
            this.f19634g = f0Var.getBuildVersion();
            this.f19635h = f0Var.getDisplayVersion();
            this.f19636i = f0Var.getSession();
            this.f19637j = f0Var.getNdkPayload();
            this.f19638k = f0Var.getAppExitInfo();
        }
    }

    public b(String str, String str2, int i10, String str3, String str4, String str5, String str6, String str7, f0.e eVar, f0.d dVar, f0.a aVar) {
        this.f19617b = str;
        this.f19618c = str2;
        this.f19619d = i10;
        this.f19620e = str3;
        this.f19621f = str4;
        this.f19622g = str5;
        this.f19623h = str6;
        this.f19624i = str7;
        this.f19625j = eVar;
        this.f19626k = dVar;
        this.f19627l = aVar;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        f0.e eVar;
        f0.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (this.f19617b.equals(f0Var.getSdkVersion()) && this.f19618c.equals(f0Var.getGmpAppId()) && this.f19619d == f0Var.getPlatform() && this.f19620e.equals(f0Var.getInstallationUuid()) && ((str = this.f19621f) != null ? str.equals(f0Var.getFirebaseInstallationId()) : f0Var.getFirebaseInstallationId() == null) && ((str2 = this.f19622g) != null ? str2.equals(f0Var.getAppQualitySessionId()) : f0Var.getAppQualitySessionId() == null) && this.f19623h.equals(f0Var.getBuildVersion()) && this.f19624i.equals(f0Var.getDisplayVersion()) && ((eVar = this.f19625j) != null ? eVar.equals(f0Var.getSession()) : f0Var.getSession() == null) && ((dVar = this.f19626k) != null ? dVar.equals(f0Var.getNdkPayload()) : f0Var.getNdkPayload() == null)) {
            f0.a aVar = this.f19627l;
            if (aVar == null) {
                if (f0Var.getAppExitInfo() == null) {
                    return true;
                }
            } else if (aVar.equals(f0Var.getAppExitInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0
    public f0.a getAppExitInfo() {
        return this.f19627l;
    }

    @Override // t8.f0
    public String getAppQualitySessionId() {
        return this.f19622g;
    }

    @Override // t8.f0
    public String getBuildVersion() {
        return this.f19623h;
    }

    @Override // t8.f0
    public String getDisplayVersion() {
        return this.f19624i;
    }

    @Override // t8.f0
    public String getFirebaseInstallationId() {
        return this.f19621f;
    }

    @Override // t8.f0
    public String getGmpAppId() {
        return this.f19618c;
    }

    @Override // t8.f0
    public String getInstallationUuid() {
        return this.f19620e;
    }

    @Override // t8.f0
    public f0.d getNdkPayload() {
        return this.f19626k;
    }

    @Override // t8.f0
    public int getPlatform() {
        return this.f19619d;
    }

    @Override // t8.f0
    public String getSdkVersion() {
        return this.f19617b;
    }

    @Override // t8.f0
    public f0.e getSession() {
        return this.f19625j;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f19617b.hashCode() ^ 1000003) * 1000003) ^ this.f19618c.hashCode()) * 1000003) ^ this.f19619d) * 1000003) ^ this.f19620e.hashCode()) * 1000003;
        String str = this.f19621f;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f19622g;
        int iHashCode3 = (((((iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ this.f19623h.hashCode()) * 1000003) ^ this.f19624i.hashCode()) * 1000003;
        f0.e eVar = this.f19625j;
        int iHashCode4 = (iHashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        f0.d dVar = this.f19626k;
        int iHashCode5 = (iHashCode4 ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        f0.a aVar = this.f19627l;
        return iHashCode5 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    @Override // t8.f0
    public f0.b toBuilder() {
        return new a(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f19617b + ", gmpAppId=" + this.f19618c + ", platform=" + this.f19619d + ", installationUuid=" + this.f19620e + ", firebaseInstallationId=" + this.f19621f + ", appQualitySessionId=" + this.f19622g + ", buildVersion=" + this.f19623h + ", displayVersion=" + this.f19624i + ", session=" + this.f19625j + ", ndkPayload=" + this.f19626k + ", appExitInfo=" + this.f19627l + "}";
    }
}
