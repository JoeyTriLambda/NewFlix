package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
/* loaded from: classes.dex */
public final class o extends f0.e.d.a.b.AbstractC0265a {

    /* renamed from: a, reason: collision with root package name */
    public final long f19788a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19789b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19790c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19791d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.java */
    public static final class a extends f0.e.d.a.b.AbstractC0265a.AbstractC0266a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19792a;

        /* renamed from: b, reason: collision with root package name */
        public Long f19793b;

        /* renamed from: c, reason: collision with root package name */
        public String f19794c;

        /* renamed from: d, reason: collision with root package name */
        public String f19795d;

        @Override // t8.f0.e.d.a.b.AbstractC0265a.AbstractC0266a
        public f0.e.d.a.b.AbstractC0265a build() {
            String strB = this.f19792a == null ? " baseAddress" : "";
            if (this.f19793b == null) {
                strB = strB.concat(" size");
            }
            if (this.f19794c == null) {
                strB = ac.c.B(strB, " name");
            }
            if (strB.isEmpty()) {
                return new o(this.f19792a.longValue(), this.f19793b.longValue(), this.f19794c, this.f19795d);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.b.AbstractC0265a.AbstractC0266a
        public f0.e.d.a.b.AbstractC0265a.AbstractC0266a setBaseAddress(long j10) {
            this.f19792a = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0265a.AbstractC0266a
        public f0.e.d.a.b.AbstractC0265a.AbstractC0266a setName(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f19794c = str;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0265a.AbstractC0266a
        public f0.e.d.a.b.AbstractC0265a.AbstractC0266a setSize(long j10) {
            this.f19793b = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0265a.AbstractC0266a
        public f0.e.d.a.b.AbstractC0265a.AbstractC0266a setUuid(String str) {
            this.f19795d = str;
            return this;
        }
    }

    public o(long j10, long j11, String str, String str2) {
        this.f19788a = j10;
        this.f19789b = j11;
        this.f19790c = str;
        this.f19791d = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0265a)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0265a abstractC0265a = (f0.e.d.a.b.AbstractC0265a) obj;
        if (this.f19788a == abstractC0265a.getBaseAddress() && this.f19789b == abstractC0265a.getSize() && this.f19790c.equals(abstractC0265a.getName())) {
            String str = this.f19791d;
            if (str == null) {
                if (abstractC0265a.getUuid() == null) {
                    return true;
                }
            } else if (str.equals(abstractC0265a.getUuid())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0265a
    public long getBaseAddress() {
        return this.f19788a;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0265a
    public String getName() {
        return this.f19790c;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0265a
    public long getSize() {
        return this.f19789b;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0265a
    public String getUuid() {
        return this.f19791d;
    }

    public int hashCode() {
        long j10 = this.f19788a;
        long j11 = this.f19789b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003) ^ this.f19790c.hashCode()) * 1000003;
        String str = this.f19791d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BinaryImage{baseAddress=");
        sb2.append(this.f19788a);
        sb2.append(", size=");
        sb2.append(this.f19789b);
        sb2.append(", name=");
        sb2.append(this.f19790c);
        sb2.append(", uuid=");
        return ac.c.o(sb2, this.f19791d, "}");
    }
}
