package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.java */
/* loaded from: classes.dex */
public final class x extends f0.e.d.AbstractC0277e.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f19858a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19859b;

    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.java */
    public static final class a extends f0.e.d.AbstractC0277e.b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19860a;

        /* renamed from: b, reason: collision with root package name */
        public String f19861b;

        @Override // t8.f0.e.d.AbstractC0277e.b.a
        public f0.e.d.AbstractC0277e.b build() {
            String strConcat = this.f19860a == null ? " rolloutId" : "";
            if (this.f19861b == null) {
                strConcat = strConcat.concat(" variantId");
            }
            if (strConcat.isEmpty()) {
                return new x(this.f19860a, this.f19861b);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.e.d.AbstractC0277e.b.a
        public f0.e.d.AbstractC0277e.b.a setRolloutId(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.f19860a = str;
            return this;
        }

        @Override // t8.f0.e.d.AbstractC0277e.b.a
        public f0.e.d.AbstractC0277e.b.a setVariantId(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.f19861b = str;
            return this;
        }
    }

    public x(String str, String str2) {
        this.f19858a = str;
        this.f19859b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.AbstractC0277e.b)) {
            return false;
        }
        f0.e.d.AbstractC0277e.b bVar = (f0.e.d.AbstractC0277e.b) obj;
        return this.f19858a.equals(bVar.getRolloutId()) && this.f19859b.equals(bVar.getVariantId());
    }

    @Override // t8.f0.e.d.AbstractC0277e.b
    public String getRolloutId() {
        return this.f19858a;
    }

    @Override // t8.f0.e.d.AbstractC0277e.b
    public String getVariantId() {
        return this.f19859b;
    }

    public int hashCode() {
        return ((this.f19858a.hashCode() ^ 1000003) * 1000003) ^ this.f19859b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("RolloutVariant{rolloutId=");
        sb2.append(this.f19858a);
        sb2.append(", variantId=");
        return ac.c.o(sb2, this.f19859b, "}");
    }
}
