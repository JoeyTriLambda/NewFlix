package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.java */
/* loaded from: classes.dex */
public final class t extends f0.e.d.a.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19828a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19829b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19830c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19831d;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.java */
    public static final class a extends f0.e.d.a.c.AbstractC0275a {

        /* renamed from: a, reason: collision with root package name */
        public String f19832a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f19833b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f19834c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f19835d;

        @Override // t8.f0.e.d.a.c.AbstractC0275a
        public f0.e.d.a.c build() {
            String strB = this.f19832a == null ? " processName" : "";
            if (this.f19833b == null) {
                strB = strB.concat(" pid");
            }
            if (this.f19834c == null) {
                strB = ac.c.B(strB, " importance");
            }
            if (this.f19835d == null) {
                strB = ac.c.B(strB, " defaultProcess");
            }
            if (strB.isEmpty()) {
                return new t(this.f19832a, this.f19833b.intValue(), this.f19834c.intValue(), this.f19835d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.c.AbstractC0275a
        public f0.e.d.a.c.AbstractC0275a setDefaultProcess(boolean z10) {
            this.f19835d = Boolean.valueOf(z10);
            return this;
        }

        @Override // t8.f0.e.d.a.c.AbstractC0275a
        public f0.e.d.a.c.AbstractC0275a setImportance(int i10) {
            this.f19834c = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.a.c.AbstractC0275a
        public f0.e.d.a.c.AbstractC0275a setPid(int i10) {
            this.f19833b = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.a.c.AbstractC0275a
        public f0.e.d.a.c.AbstractC0275a setProcessName(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.f19832a = str;
            return this;
        }
    }

    public t(String str, int i10, int i11, boolean z10) {
        this.f19828a = str;
        this.f19829b = i10;
        this.f19830c = i11;
        this.f19831d = z10;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.c)) {
            return false;
        }
        f0.e.d.a.c cVar = (f0.e.d.a.c) obj;
        return this.f19828a.equals(cVar.getProcessName()) && this.f19829b == cVar.getPid() && this.f19830c == cVar.getImportance() && this.f19831d == cVar.isDefaultProcess();
    }

    @Override // t8.f0.e.d.a.c
    public int getImportance() {
        return this.f19830c;
    }

    @Override // t8.f0.e.d.a.c
    public int getPid() {
        return this.f19829b;
    }

    @Override // t8.f0.e.d.a.c
    public String getProcessName() {
        return this.f19828a;
    }

    public int hashCode() {
        return ((((((this.f19828a.hashCode() ^ 1000003) * 1000003) ^ this.f19829b) * 1000003) ^ this.f19830c) * 1000003) ^ (this.f19831d ? 1231 : 1237);
    }

    @Override // t8.f0.e.d.a.c
    public boolean isDefaultProcess() {
        return this.f19831d;
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f19828a + ", pid=" + this.f19829b + ", importance=" + this.f19830c + ", defaultProcess=" + this.f19831d + "}";
    }
}
