package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* loaded from: classes.dex */
public final class s extends f0.e.d.a.b.AbstractC0271e.AbstractC0273b {

    /* renamed from: a, reason: collision with root package name */
    public final long f19818a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19819b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19820c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19821d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19822e;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
    public static final class a extends f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19823a;

        /* renamed from: b, reason: collision with root package name */
        public String f19824b;

        /* renamed from: c, reason: collision with root package name */
        public String f19825c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19826d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f19827e;

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b build() {
            String strB = this.f19823a == null ? " pc" : "";
            if (this.f19824b == null) {
                strB = strB.concat(" symbol");
            }
            if (this.f19826d == null) {
                strB = ac.c.B(strB, " offset");
            }
            if (this.f19827e == null) {
                strB = ac.c.B(strB, " importance");
            }
            if (strB.isEmpty()) {
                return new s(this.f19823a.longValue(), this.f19824b, this.f19825c, this.f19826d.longValue(), this.f19827e.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a setFile(String str) {
            this.f19825c = str;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a setImportance(int i10) {
            this.f19827e = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a setOffset(long j10) {
            this.f19826d = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a setPc(long j10) {
            this.f19823a = Long.valueOf(j10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0273b.AbstractC0274a setSymbol(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f19824b = str;
            return this;
        }
    }

    public s(long j10, String str, String str2, long j11, int i10) {
        this.f19818a = j10;
        this.f19819b = str;
        this.f19820c = str2;
        this.f19821d = j11;
        this.f19822e = i10;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0271e.AbstractC0273b)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0271e.AbstractC0273b abstractC0273b = (f0.e.d.a.b.AbstractC0271e.AbstractC0273b) obj;
        return this.f19818a == abstractC0273b.getPc() && this.f19819b.equals(abstractC0273b.getSymbol()) && ((str = this.f19820c) != null ? str.equals(abstractC0273b.getFile()) : abstractC0273b.getFile() == null) && this.f19821d == abstractC0273b.getOffset() && this.f19822e == abstractC0273b.getImportance();
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b
    public String getFile() {
        return this.f19820c;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b
    public int getImportance() {
        return this.f19822e;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b
    public long getOffset() {
        return this.f19821d;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b
    public long getPc() {
        return this.f19818a;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0273b
    public String getSymbol() {
        return this.f19819b;
    }

    public int hashCode() {
        long j10 = this.f19818a;
        int iHashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f19819b.hashCode()) * 1000003;
        String str = this.f19820c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f19821d;
        return this.f19822e ^ ((iHashCode2 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Frame{pc=");
        sb2.append(this.f19818a);
        sb2.append(", symbol=");
        sb2.append(this.f19819b);
        sb2.append(", file=");
        sb2.append(this.f19820c);
        sb2.append(", offset=");
        sb2.append(this.f19821d);
        sb2.append(", importance=");
        return ac.c.m(sb2, this.f19822e, "}");
    }
}
