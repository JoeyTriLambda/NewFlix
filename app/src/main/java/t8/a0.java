package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* loaded from: classes.dex */
public final class a0 extends f0.e.f {

    /* renamed from: a, reason: collision with root package name */
    public final String f19615a;

    /* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
    public static final class a extends f0.e.f.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19616a;

        @Override // t8.f0.e.f.a
        public f0.e.f build() {
            String str = this.f19616a == null ? " identifier" : "";
            if (str.isEmpty()) {
                return new a0(this.f19616a);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // t8.f0.e.f.a
        public f0.e.f.a setIdentifier(String str) {
            if (str == null) {
                throw new NullPointerException("Null identifier");
            }
            this.f19616a = str;
            return this;
        }
    }

    public a0(String str) {
        this.f19615a = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.f) {
            return this.f19615a.equals(((f0.e.f) obj).getIdentifier());
        }
        return false;
    }

    @Override // t8.f0.e.f
    public String getIdentifier() {
        return this.f19615a;
    }

    public int hashCode() {
        return this.f19615a.hashCode() ^ 1000003;
    }

    public String toString() {
        return ac.c.o(new StringBuilder("User{identifier="), this.f19615a, "}");
    }
}
