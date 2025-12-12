package i9;

import i9.f;

/* compiled from: AutoValue_InstallationTokenResult.java */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final String f13337a;

    /* renamed from: b, reason: collision with root package name */
    public final long f13338b;

    /* renamed from: c, reason: collision with root package name */
    public final long f13339c;

    /* compiled from: AutoValue_InstallationTokenResult.java */
    /* renamed from: i9.a$a, reason: collision with other inner class name */
    public static final class C0167a extends f.a {

        /* renamed from: a, reason: collision with root package name */
        public String f13340a;

        /* renamed from: b, reason: collision with root package name */
        public Long f13341b;

        /* renamed from: c, reason: collision with root package name */
        public Long f13342c;

        @Override // i9.f.a
        public f build() {
            String strB = this.f13340a == null ? " token" : "";
            if (this.f13341b == null) {
                strB = strB.concat(" tokenExpirationTimestamp");
            }
            if (this.f13342c == null) {
                strB = ac.c.B(strB, " tokenCreationTimestamp");
            }
            if (strB.isEmpty()) {
                return new a(this.f13340a, this.f13341b.longValue(), this.f13342c.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // i9.f.a
        public f.a setToken(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.f13340a = str;
            return this;
        }

        @Override // i9.f.a
        public f.a setTokenCreationTimestamp(long j10) {
            this.f13342c = Long.valueOf(j10);
            return this;
        }

        @Override // i9.f.a
        public f.a setTokenExpirationTimestamp(long j10) {
            this.f13341b = Long.valueOf(j10);
            return this;
        }
    }

    public a(String str, long j10, long j11) {
        this.f13337a = str;
        this.f13338b = j10;
        this.f13339c = j11;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f13337a.equals(fVar.getToken()) && this.f13338b == fVar.getTokenExpirationTimestamp() && this.f13339c == fVar.getTokenCreationTimestamp();
    }

    @Override // i9.f
    public String getToken() {
        return this.f13337a;
    }

    @Override // i9.f
    public long getTokenCreationTimestamp() {
        return this.f13339c;
    }

    @Override // i9.f
    public long getTokenExpirationTimestamp() {
        return this.f13338b;
    }

    public int hashCode() {
        int iHashCode = (this.f13337a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f13338b;
        long j11 = this.f13339c;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f13337a + ", tokenExpirationTimestamp=" + this.f13338b + ", tokenCreationTimestamp=" + this.f13339c + "}";
    }
}
