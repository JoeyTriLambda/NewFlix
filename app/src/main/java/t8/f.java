package t8;

import java.util.List;
import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* loaded from: classes.dex */
public final class f extends f0.d {

    /* renamed from: a, reason: collision with root package name */
    public final List<f0.d.b> f19688a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19689b;

    /* compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
    public static final class a extends f0.d.a {

        /* renamed from: a, reason: collision with root package name */
        public List<f0.d.b> f19690a;

        /* renamed from: b, reason: collision with root package name */
        public String f19691b;

        @Override // t8.f0.d.a
        public f0.d build() {
            String str = this.f19690a == null ? " files" : "";
            if (str.isEmpty()) {
                return new f(this.f19690a, this.f19691b);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // t8.f0.d.a
        public f0.d.a setFiles(List<f0.d.b> list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.f19690a = list;
            return this;
        }

        @Override // t8.f0.d.a
        public f0.d.a setOrgId(String str) {
            this.f19691b = str;
            return this;
        }
    }

    public f() {
        throw null;
    }

    public f(List list, String str) {
        this.f19688a = list;
        this.f19689b = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.d)) {
            return false;
        }
        f0.d dVar = (f0.d) obj;
        if (this.f19688a.equals(dVar.getFiles())) {
            String str = this.f19689b;
            if (str == null) {
                if (dVar.getOrgId() == null) {
                    return true;
                }
            } else if (str.equals(dVar.getOrgId())) {
                return true;
            }
        }
        return false;
    }

    @Override // t8.f0.d
    public List<f0.d.b> getFiles() {
        return this.f19688a;
    }

    @Override // t8.f0.d
    public String getOrgId() {
        return this.f19689b;
    }

    public int hashCode() {
        int iHashCode = (this.f19688a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19689b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FilesPayload{files=");
        sb2.append(this.f19688a);
        sb2.append(", orgId=");
        return ac.c.o(sb2, this.f19689b, "}");
    }
}
