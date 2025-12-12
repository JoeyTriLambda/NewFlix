package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* loaded from: classes.dex */
public final class p extends f0.e.d.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19796a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19797b;

    /* renamed from: c, reason: collision with root package name */
    public final List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> f19798c;

    /* renamed from: d, reason: collision with root package name */
    public final f0.e.d.a.b.c f19799d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19800e;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
    public static final class a extends f0.e.d.a.b.c.AbstractC0268a {

        /* renamed from: a, reason: collision with root package name */
        public String f19801a;

        /* renamed from: b, reason: collision with root package name */
        public String f19802b;

        /* renamed from: c, reason: collision with root package name */
        public List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> f19803c;

        /* renamed from: d, reason: collision with root package name */
        public f0.e.d.a.b.c f19804d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f19805e;

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c build() {
            String strB = this.f19801a == null ? " type" : "";
            if (this.f19803c == null) {
                strB = strB.concat(" frames");
            }
            if (this.f19805e == null) {
                strB = ac.c.B(strB, " overflowCount");
            }
            if (strB.isEmpty()) {
                return new p(this.f19801a, this.f19802b, this.f19803c, this.f19804d, this.f19805e.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c.AbstractC0268a setCausedBy(f0.e.d.a.b.c cVar) {
            this.f19804d = cVar;
            return this;
        }

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c.AbstractC0268a setFrames(List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f19803c = list;
            return this;
        }

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c.AbstractC0268a setOverflowCount(int i10) {
            this.f19805e = Integer.valueOf(i10);
            return this;
        }

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c.AbstractC0268a setReason(String str) {
            this.f19802b = str;
            return this;
        }

        @Override // t8.f0.e.d.a.b.c.AbstractC0268a
        public f0.e.d.a.b.c.AbstractC0268a setType(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f19801a = str;
            return this;
        }
    }

    public p() {
        throw null;
    }

    public p(String str, String str2, List list, f0.e.d.a.b.c cVar, int i10) {
        this.f19796a = str;
        this.f19797b = str2;
        this.f19798c = list;
        this.f19799d = cVar;
        this.f19800e = i10;
    }

    public boolean equals(Object obj) {
        String str;
        f0.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.c)) {
            return false;
        }
        f0.e.d.a.b.c cVar2 = (f0.e.d.a.b.c) obj;
        return this.f19796a.equals(cVar2.getType()) && ((str = this.f19797b) != null ? str.equals(cVar2.getReason()) : cVar2.getReason() == null) && this.f19798c.equals(cVar2.getFrames()) && ((cVar = this.f19799d) != null ? cVar.equals(cVar2.getCausedBy()) : cVar2.getCausedBy() == null) && this.f19800e == cVar2.getOverflowCount();
    }

    @Override // t8.f0.e.d.a.b.c
    public f0.e.d.a.b.c getCausedBy() {
        return this.f19799d;
    }

    @Override // t8.f0.e.d.a.b.c
    public List<f0.e.d.a.b.AbstractC0271e.AbstractC0273b> getFrames() {
        return this.f19798c;
    }

    @Override // t8.f0.e.d.a.b.c
    public int getOverflowCount() {
        return this.f19800e;
    }

    @Override // t8.f0.e.d.a.b.c
    public String getReason() {
        return this.f19797b;
    }

    @Override // t8.f0.e.d.a.b.c
    public String getType() {
        return this.f19796a;
    }

    public int hashCode() {
        int iHashCode = (this.f19796a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19797b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f19798c.hashCode()) * 1000003;
        f0.e.d.a.b.c cVar = this.f19799d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f19800e;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Exception{type=");
        sb2.append(this.f19796a);
        sb2.append(", reason=");
        sb2.append(this.f19797b);
        sb2.append(", frames=");
        sb2.append(this.f19798c);
        sb2.append(", causedBy=");
        sb2.append(this.f19799d);
        sb2.append(", overflowCount=");
        return ac.c.m(sb2, this.f19800e, "}");
    }
}
