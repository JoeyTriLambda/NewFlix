package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* loaded from: classes.dex */
public final class v extends f0.e.d.AbstractC0276d {

    /* renamed from: a, reason: collision with root package name */
    public final String f19848a;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
    public static final class a extends f0.e.d.AbstractC0276d.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19849a;

        @Override // t8.f0.e.d.AbstractC0276d.a
        public f0.e.d.AbstractC0276d build() {
            String str = this.f19849a == null ? " content" : "";
            if (str.isEmpty()) {
                return new v(this.f19849a);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // t8.f0.e.d.AbstractC0276d.a
        public f0.e.d.AbstractC0276d.a setContent(String str) {
            if (str == null) {
                throw new NullPointerException("Null content");
            }
            this.f19849a = str;
            return this;
        }
    }

    public v(String str) {
        this.f19848a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.AbstractC0276d) {
            return this.f19848a.equals(((f0.e.d.AbstractC0276d) obj).getContent());
        }
        return false;
    }

    @Override // t8.f0.e.d.AbstractC0276d
    public String getContent() {
        return this.f19848a;
    }

    public int hashCode() {
        return this.f19848a.hashCode() ^ 1000003;
    }

    public String toString() {
        return ac.c.o(new StringBuilder("Log{content="), this.f19848a, "}");
    }
}
