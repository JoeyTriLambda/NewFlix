package t8;

import t8.f0;

/* compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
/* loaded from: classes.dex */
public final class e extends f0.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19681a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19682b;

    /* compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
    public static final class a extends f0.c.a {

        /* renamed from: a, reason: collision with root package name */
        public String f19683a;

        /* renamed from: b, reason: collision with root package name */
        public String f19684b;

        @Override // t8.f0.c.a
        public f0.c build() {
            String strConcat = this.f19683a == null ? " key" : "";
            if (this.f19684b == null) {
                strConcat = strConcat.concat(" value");
            }
            if (strConcat.isEmpty()) {
                return new e(this.f19683a, this.f19684b);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        }

        @Override // t8.f0.c.a
        public f0.c.a setKey(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.f19683a = str;
            return this;
        }

        @Override // t8.f0.c.a
        public f0.c.a setValue(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.f19684b = str;
            return this;
        }
    }

    public e(String str, String str2) {
        this.f19681a = str;
        this.f19682b = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.c)) {
            return false;
        }
        f0.c cVar = (f0.c) obj;
        return this.f19681a.equals(cVar.getKey()) && this.f19682b.equals(cVar.getValue());
    }

    @Override // t8.f0.c
    public String getKey() {
        return this.f19681a;
    }

    @Override // t8.f0.c
    public String getValue() {
        return this.f19682b;
    }

    public int hashCode() {
        return ((this.f19681a.hashCode() ^ 1000003) * 1000003) ^ this.f19682b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CustomAttribute{key=");
        sb2.append(this.f19681a);
        sb2.append(", value=");
        return ac.c.o(sb2, this.f19682b, "}");
    }
}
