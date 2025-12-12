package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* loaded from: classes.dex */
public final class r extends f0.e.d.a.b.AbstractC0271e {

    /* renamed from: a, reason: collision with root package name */
    public final String f19812a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19813b;

    /* renamed from: c, reason: collision with root package name */
    public final List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> f19814c;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
    public static final class a extends f0.e.d.a.b.AbstractC0271e.AbstractC0272a {

        /* renamed from: a, reason: collision with root package name */
        public String f19815a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f19816b;

        /* renamed from: c, reason: collision with root package name */
        public List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> f19817c;

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0272a
        public f0.e.d.a.b.AbstractC0271e build() {
            String strB = this.f19815a == null ? " name" : "";
            if (this.f19816b == null) {
                strB = strB.concat(" importance");
            }
            if (this.f19817c == null) {
                strB = ac.c.B(strB, " frames");
            }
            if (strB.isEmpty()) {
                return new r(this.f19815a, this.f19816b.intValue(), this.f19817c);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0272a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0272a setFrames(List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f19817c = list;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0272a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0272a setImportance(int i10) {
            this.f19816b = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0271e.AbstractC0272a
        public f0.e.d.a.b.AbstractC0271e.AbstractC0272a setName(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f19815a = str;
            return this;
        }
    }

    public r() {
        throw null;
    }

    public r(String str, int i10, List list) {
        this.f19812a = str;
        this.f19813b = i10;
        this.f19814c = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0271e)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0271e abstractC0271e = (f0.e.d.a.b.AbstractC0271e) obj;
        return this.f19812a.equals(abstractC0271e.getName()) && this.f19813b == abstractC0271e.getImportance() && this.f19814c.equals(abstractC0271e.getFrames());
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e
    public List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> getFrames() {
        return this.f19814c;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e
    public int getImportance() {
        return this.f19813b;
    }

    @Override // t8.f0.e.d.a.b.AbstractC0271e
    public String getName() {
        return this.f19812a;
    }

    public int hashCode() {
        return ((((this.f19812a.hashCode() ^ 1000003) * 1000003) ^ this.f19813b) * 1000003) ^ this.f19814c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f19812a + ", importance=" + this.f19813b + ", frames=" + this.f19814c + "}";
    }
}
