package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* loaded from: classes.dex */
public final class n extends f0.e.d.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final List<f0.e.d.a.b.AbstractC0271e> f19778a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.e.d.a.b.c f19779b;

    /* renamed from: c, reason: collision with root package name */
    public final f0.a f19780c;

    /* renamed from: d, reason: collision with root package name */
    public final f0.e.d.a.b.AbstractC0269d f19781d;

    /* renamed from: e, reason: collision with root package name */
    public final List<f0.e.d.a.b.AbstractC0265a> f19782e;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
    public static final class a extends f0.e.d.a.b.AbstractC0267b {

        /* renamed from: a, reason: collision with root package name */
        public List<f0.e.d.a.b.AbstractC0271e> f19783a;

        /* renamed from: b, reason: collision with root package name */
        public f0.e.d.a.b.c f19784b;

        /* renamed from: c, reason: collision with root package name */
        public f0.a f19785c;

        /* renamed from: d, reason: collision with root package name */
        public f0.e.d.a.b.AbstractC0269d f19786d;

        /* renamed from: e, reason: collision with root package name */
        public List<f0.e.d.a.b.AbstractC0265a> f19787e;

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b build() {
            String strConcat = this.f19786d == null ? " signal" : "";
            if (this.f19787e == null) {
                strConcat = strConcat.concat(" binaries");
            }
            if (strConcat.isEmpty()) {
                return new n(this.f19783a, this.f19784b, this.f19785c, this.f19786d, this.f19787e);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b.AbstractC0267b setAppExitInfo(f0.a aVar) {
            this.f19785c = aVar;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b.AbstractC0267b setBinaries(List<f0.e.d.a.b.AbstractC0265a> list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f19787e = list;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b.AbstractC0267b setException(f0.e.d.a.b.c cVar) {
            this.f19784b = cVar;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b.AbstractC0267b setSignal(f0.e.d.a.b.AbstractC0269d abstractC0269d) {
            if (abstractC0269d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f19786d = abstractC0269d;
            return this;
        }

        @Override // t8.f0.e.d.a.b.AbstractC0267b
        public f0.e.d.a.b.AbstractC0267b setThreads(List<f0.e.d.a.b.AbstractC0271e> list) {
            this.f19783a = list;
            return this;
        }
    }

    public n() {
        throw null;
    }

    public n(List list, f0.e.d.a.b.c cVar, f0.a aVar, f0.e.d.a.b.AbstractC0269d abstractC0269d, List list2) {
        this.f19778a = list;
        this.f19779b = cVar;
        this.f19780c = aVar;
        this.f19781d = abstractC0269d;
        this.f19782e = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b)) {
            return false;
        }
        f0.e.d.a.b bVar = (f0.e.d.a.b) obj;
        List<f0.e.d.a.b.AbstractC0271e> list = this.f19778a;
        if (list != null ? list.equals(bVar.getThreads()) : bVar.getThreads() == null) {
            f0.e.d.a.b.c cVar = this.f19779b;
            if (cVar != null ? cVar.equals(bVar.getException()) : bVar.getException() == null) {
                f0.a aVar = this.f19780c;
                if (aVar != null ? aVar.equals(bVar.getAppExitInfo()) : bVar.getAppExitInfo() == null) {
                    if (this.f19781d.equals(bVar.getSignal()) && this.f19782e.equals(bVar.getBinaries())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // t8.f0.e.d.a.b
    public f0.a getAppExitInfo() {
        return this.f19780c;
    }

    @Override // t8.f0.e.d.a.b
    public List<f0.e.d.a.b.AbstractC0265a> getBinaries() {
        return this.f19782e;
    }

    @Override // t8.f0.e.d.a.b
    public f0.e.d.a.b.c getException() {
        return this.f19779b;
    }

    @Override // t8.f0.e.d.a.b
    public f0.e.d.a.b.AbstractC0269d getSignal() {
        return this.f19781d;
    }

    @Override // t8.f0.e.d.a.b
    public List<f0.e.d.a.b.AbstractC0271e> getThreads() {
        return this.f19778a;
    }

    public int hashCode() {
        List<f0.e.d.a.b.AbstractC0271e> list = this.f19778a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        f0.e.d.a.b.c cVar = this.f19779b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        f0.a aVar = this.f19780c;
        return (((((aVar != null ? aVar.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f19781d.hashCode()) * 1000003) ^ this.f19782e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f19778a + ", exception=" + this.f19779b + ", appExitInfo=" + this.f19780c + ", signal=" + this.f19781d + ", binaries=" + this.f19782e + "}";
    }
}
