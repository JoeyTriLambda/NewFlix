package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
/* loaded from: classes.dex */
public final class z extends f0.e.AbstractC0278e {

    /* renamed from: a, reason: collision with root package name */
    public final int f19864a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19865b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19866c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19867d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_OperatingSystem.java */
    public static final class a extends f0.e.AbstractC0278e.a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f19868a;

        /* renamed from: b, reason: collision with root package name */
        public String f19869b;

        /* renamed from: c, reason: collision with root package name */
        public String f19870c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f19871d;

        @Override // t8.f0.e.AbstractC0278e.a
        public f0.e.AbstractC0278e build() {
            String strB = this.f19868a == null ? " platform" : "";
            if (this.f19869b == null) {
                strB = strB.concat(" version");
            }
            if (this.f19870c == null) {
                strB = ac.c.B(strB, " buildVersion");
            }
            if (this.f19871d == null) {
                strB = ac.c.B(strB, " jailbroken");
            }
            if (strB.isEmpty()) {
                return new z(this.f19868a.intValue(), this.f19869b, this.f19870c, this.f19871d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.AbstractC0278e.a
        public f0.e.AbstractC0278e.a setBuildVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildVersion");
            }
            this.f19870c = str;
            return this;
        }

        @Override // t8.f0.e.AbstractC0278e.a
        public f0.e.AbstractC0278e.a setJailbroken(boolean z10) {
            this.f19871d = Boolean.valueOf(z10);
            return this;
        }

        @Override // t8.f0.e.AbstractC0278e.a
        public f0.e.AbstractC0278e.a setPlatform(int i10) {
            this.f19868a = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.AbstractC0278e.a
        public f0.e.AbstractC0278e.a setVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null version");
            }
            this.f19869b = str;
            return this;
        }
    }

    public z(int i10, String str, String str2, boolean z10) {
        this.f19864a = i10;
        this.f19865b = str;
        this.f19866c = str2;
        this.f19867d = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.AbstractC0278e)) {
            return false;
        }
        f0.e.AbstractC0278e abstractC0278e = (f0.e.AbstractC0278e) obj;
        return this.f19864a == abstractC0278e.getPlatform() && this.f19865b.equals(abstractC0278e.getVersion()) && this.f19866c.equals(abstractC0278e.getBuildVersion()) && this.f19867d == abstractC0278e.isJailbroken();
    }

    @Override // t8.f0.e.AbstractC0278e
    public String getBuildVersion() {
        return this.f19866c;
    }

    @Override // t8.f0.e.AbstractC0278e
    public int getPlatform() {
        return this.f19864a;
    }

    @Override // t8.f0.e.AbstractC0278e
    public String getVersion() {
        return this.f19865b;
    }

    public int hashCode() {
        return ((((((this.f19864a ^ 1000003) * 1000003) ^ this.f19865b.hashCode()) * 1000003) ^ this.f19866c.hashCode()) * 1000003) ^ (this.f19867d ? 1231 : 1237);
    }

    @Override // t8.f0.e.AbstractC0278e
    public boolean isJailbroken() {
        return this.f19867d;
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f19864a + ", version=" + this.f19865b + ", buildVersion=" + this.f19866c + ", jailbroken=" + this.f19867d + "}";
    }
}
