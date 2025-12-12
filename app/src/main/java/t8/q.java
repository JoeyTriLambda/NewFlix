package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
/* loaded from: classes.dex */
public final class q extends f0.e.d.a.b.AbstractC0269d {

    /* renamed from: a, reason: collision with root package name */
    public final String f19806a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19807b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19808c;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.java */
    public static final class a extends f0.e.d.a.b.AbstractC0269d.AbstractC0270a {

        /* renamed from: a, reason: collision with root package name */
        public String f19809a;

        /* renamed from: b, reason: collision with root package name */
        public String f19810b;

        /* renamed from: c, reason: collision with root package name */
        public Long f19811c;

        @Override // t8.f0.e.d.a.b.AbstractC0269d.AbstractC0270a
        public f0.e.d.a.b.AbstractC0269d build() {
            String strB = this.f19809a == null ? " name" : "";
            if (this.f19810b == null) {
                strB = strB.concat(" code");
            }
            if (this.f19811c == null) {
                strB = ac.c.B(strB, " address");
            }
            if (strB.isEmpty()) {
                return new q(this.f19809a, this.f19810b, this.f19811c.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.b.AbstractC0269d.AbstractC0270a
        public f0.e.d.a.b.AbstractC0269d.AbstractC0270a setAddress(long j10) {
            this.f19811c = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0269d.AbstractC0270a
        public f0.e.d.a.b.AbstractC0269d.AbstractC0270a setCode(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f19810b = str;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0269d.AbstractC0270a
        public f0.e.d.a.b.AbstractC0269d.AbstractC0270a setName(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f19809a = str;
            return this;
        }
    }

    public q(String str, String str2, long j10) {
        this.f19806a = str;
        this.f19807b = str2;
        this.f19808c = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0269d)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0269d abstractC0269d = (f0.e.d.a.b.AbstractC0269d) obj;
        return this.f19806a.equals(abstractC0269d.getName()) && this.f19807b.equals(abstractC0269d.getCode()) && this.f19808c == abstractC0269d.getAddress();
    }

    @Override // t8.f0.e.d.a.b.AbstractC0269d
    public long getAddress() {
        return this.f19808c;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0269d
    public String getCode() {
        return this.f19807b;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0269d
    public String getName() {
        return this.f19806a;
    }

    public int hashCode() {
        int iHashCode = (((this.f19806a.hashCode() ^ 1000003) * 1000003) ^ this.f19807b.hashCode()) * 1000003;
        long j10 = this.f19808c;
        return iHashCode ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "Signal{name=" + this.f19806a + ", code=" + this.f19807b + ", address=" + this.f19808c + "}";
    }
}
