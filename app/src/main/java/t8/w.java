package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.java */
/* loaded from: classes.dex */
public final class w extends f0.e.d.AbstractC0277e {

    /* renamed from: a, reason: collision with root package name */
    public final f0.e.d.AbstractC0277e.b f19850a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19851b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19852c;

    /* renamed from: d, reason: collision with root package name */
    public final long f19853d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.java */
    public static final class a extends f0.e.d.AbstractC0277e.a {

        /* renamed from: a, reason: collision with root package name */
        public f0.e.d.AbstractC0277e.b f19854a;

        /* renamed from: b, reason: collision with root package name */
        public String f19855b;

        /* renamed from: c, reason: collision with root package name */
        public String f19856c;

        /* renamed from: d, reason: collision with root package name */
        public Long f19857d;

        @Override // t8.f0.e.d.AbstractC0277e.a
        public f0.e.d.AbstractC0277e build() {
            String strB = this.f19854a == null ? " rolloutVariant" : "";
            if (this.f19855b == null) {
                strB = strB.concat(" parameterKey");
            }
            if (this.f19856c == null) {
                strB = ac.c.B(strB, " parameterValue");
            }
            if (this.f19857d == null) {
                strB = ac.c.B(strB, " templateVersion");
            }
            if (strB.isEmpty()) {
                return new w(this.f19854a, this.f19855b, this.f19856c, this.f19857d.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.AbstractC0277e.a
        public f0.e.d.AbstractC0277e.a setParameterKey(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.f19855b = str;
            return this;
        }

        @Override // t8.f0.e.d.AbstractC0277e.a
        public f0.e.d.AbstractC0277e.a setParameterValue(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.f19856c = str;
            return this;
        }

        @Override // t8.f0.e.d.AbstractC0277e.a
        public f0.e.d.AbstractC0277e.a setRolloutVariant(f0.e.d.AbstractC0277e.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null rolloutVariant");
            }
            this.f19854a = bVar;
            return this;
        }

        @Override // t8.f0.e.d.AbstractC0277e.a
        public f0.e.d.AbstractC0277e.a setTemplateVersion(long j10) {
            this.f19857d = Long.valueOf(j10);
            return this;
        }
    }

    public w(f0.e.d.AbstractC0277e.b bVar, String str, String str2, long j10) {
        this.f19850a = bVar;
        this.f19851b = str;
        this.f19852c = str2;
        this.f19853d = j10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.AbstractC0277e)) {
            return false;
        }
        f0.e.d.AbstractC0277e abstractC0277e = (f0.e.d.AbstractC0277e) obj;
        return this.f19850a.equals(abstractC0277e.getRolloutVariant()) && this.f19851b.equals(abstractC0277e.getParameterKey()) && this.f19852c.equals(abstractC0277e.getParameterValue()) && this.f19853d == abstractC0277e.getTemplateVersion();
    }

    @Override // t8.f0.e.d.AbstractC0277e
    public String getParameterKey() {
        return this.f19851b;
    }

    @Override // t8.f0.e.d.AbstractC0277e
    public String getParameterValue() {
        return this.f19852c;
    }

    @Override // t8.f0.e.d.AbstractC0277e
    public f0.e.d.AbstractC0277e.b getRolloutVariant() {
        return this.f19850a;
    }

    @Override // t8.f0.e.d.AbstractC0277e
    public long getTemplateVersion() {
        return this.f19853d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f19850a.hashCode() ^ 1000003) * 1000003) ^ this.f19851b.hashCode()) * 1000003) ^ this.f19852c.hashCode()) * 1000003;
        long j10 = this.f19853d;
        return iHashCode ^ ((int) ((j10 >>> 32) ^ j10));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f19850a + ", parameterKey=" + this.f19851b + ", parameterValue=" + this.f19852c + ", templateVersion=" + this.f19853d + "}";
    }
}
