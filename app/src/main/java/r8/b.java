package r8;

import java.io.File;

/* compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* loaded from: classes.dex */
public final class b extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public final t8.f0 f18664a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18665b;

    /* renamed from: c, reason: collision with root package name */
    public final File f18666c;

    public b(t8.f0 f0Var, String str, File file) {
        if (f0Var == null) {
            throw new NullPointerException("Null report");
        }
        this.f18664a = f0Var;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.f18665b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.f18666c = file;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.f18664a.equals(a0Var.getReport()) && this.f18665b.equals(a0Var.getSessionId()) && this.f18666c.equals(a0Var.getReportFile());
    }

    @Override // r8.a0
    public t8.f0 getReport() {
        return this.f18664a;
    }

    @Override // r8.a0
    public File getReportFile() {
        return this.f18666c;
    }

    @Override // r8.a0
    public String getSessionId() {
        return this.f18665b;
    }

    public int hashCode() {
        return ((((this.f18664a.hashCode() ^ 1000003) * 1000003) ^ this.f18665b.hashCode()) * 1000003) ^ this.f18666c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f18664a + ", sessionId=" + this.f18665b + ", reportFile=" + this.f18666c + "}";
    }
}
