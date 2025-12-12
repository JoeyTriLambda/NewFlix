package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.java */
/* loaded from: classes.dex */
public final class d extends f0.a.AbstractC0261a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19666a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19667b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19668c;

    /* compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.java */
    public static final class a extends f0.a.AbstractC0261a.AbstractC0262a {

        /* renamed from: a, reason: collision with root package name */
        public String f19669a;

        /* renamed from: b, reason: collision with root package name */
        public String f19670b;

        /* renamed from: c, reason: collision with root package name */
        public String f19671c;

        @Override // t8.f0.a.AbstractC0261a.AbstractC0262a
        public f0.a.AbstractC0261a build() {
            String strB = this.f19669a == null ? " arch" : "";
            if (this.f19670b == null) {
                strB = strB.concat(" libraryName");
            }
            if (this.f19671c == null) {
                strB = ac.c.B(strB, " buildId");
            }
            if (strB.isEmpty()) {
                return new d(this.f19669a, this.f19670b, this.f19671c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.a.AbstractC0261a.AbstractC0262a
        public f0.a.AbstractC0261a.AbstractC0262a setArch(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.f19669a = str;
            return this;
        }

        @Override // t8.f0.a.AbstractC0261a.AbstractC0262a
        public f0.a.AbstractC0261a.AbstractC0262a setBuildId(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f19671c = str;
            return this;
        }

        @Override // t8.f0.a.AbstractC0261a.AbstractC0262a
        public f0.a.AbstractC0261a.AbstractC0262a setLibraryName(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f19670b = str;
            return this;
        }
    }

    public d(String str, String str2, String str3) {
        this.f19666a = str;
        this.f19667b = str2;
        this.f19668c = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.a.AbstractC0261a)) {
            return false;
        }
        f0.a.AbstractC0261a abstractC0261a = (f0.a.AbstractC0261a) obj;
        return this.f19666a.equals(abstractC0261a.getArch()) && this.f19667b.equals(abstractC0261a.getLibraryName()) && this.f19668c.equals(abstractC0261a.getBuildId());
    }

    @Override // t8.f0.a.AbstractC0261a
    public String getArch() {
        return this.f19666a;
    }

    @Override // t8.f0.a.AbstractC0261a
    public String getBuildId() {
        return this.f19668c;
    }

    @Override // t8.f0.a.AbstractC0261a
    public String getLibraryName() {
        return this.f19667b;
    }

    public int hashCode() {
        return ((((this.f19666a.hashCode() ^ 1000003) * 1000003) ^ this.f19667b.hashCode()) * 1000003) ^ this.f19668c.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BuildIdMappingForArch{arch=");
        sb2.append(this.f19666a);
        sb2.append(", libraryName=");
        sb2.append(this.f19667b);
        sb2.append(", buildId=");
        return ac.c.o(sb2, this.f19668c, "}");
    }
}
