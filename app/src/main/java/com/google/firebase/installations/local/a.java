package com.google.firebase.installations.local;

import ac.c;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.b;

/* compiled from: AutoValue_PersistedInstallationEntry.java */
/* loaded from: classes.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    public final String f9823a;

    /* renamed from: b, reason: collision with root package name */
    public final PersistedInstallation.RegistrationStatus f9824b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9825c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9826d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9827e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9828f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9829g;

    /* compiled from: AutoValue_PersistedInstallationEntry.java */
    /* renamed from: com.google.firebase.installations.local.a$a, reason: collision with other inner class name */
    public static final class C0101a extends b.a {

        /* renamed from: a, reason: collision with root package name */
        public String f9830a;

        /* renamed from: b, reason: collision with root package name */
        public PersistedInstallation.RegistrationStatus f9831b;

        /* renamed from: c, reason: collision with root package name */
        public String f9832c;

        /* renamed from: d, reason: collision with root package name */
        public String f9833d;

        /* renamed from: e, reason: collision with root package name */
        public Long f9834e;

        /* renamed from: f, reason: collision with root package name */
        public Long f9835f;

        /* renamed from: g, reason: collision with root package name */
        public String f9836g;

        public C0101a() {
        }

        @Override // com.google.firebase.installations.local.b.a
        public b build() {
            String strB = this.f9831b == null ? " registrationStatus" : "";
            if (this.f9834e == null) {
                strB = strB.concat(" expiresInSecs");
            }
            if (this.f9835f == null) {
                strB = c.B(strB, " tokenCreationEpochInSecs");
            }
            if (strB.isEmpty()) {
                return new a(this.f9830a, this.f9831b, this.f9832c, this.f9833d, this.f9834e.longValue(), this.f9835f.longValue(), this.f9836g);
            }
            throw new IllegalStateException("Missing required properties:".concat(strB));
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setAuthToken(String str) {
            this.f9832c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setExpiresInSecs(long j10) {
            this.f9834e = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setFirebaseInstallationId(String str) {
            this.f9830a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setFisError(String str) {
            this.f9836g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setRefreshToken(String str) {
            this.f9833d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f9831b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public b.a setTokenCreationEpochInSecs(long j10) {
            this.f9835f = Long.valueOf(j10);
            return this;
        }

        public C0101a(b bVar) {
            this.f9830a = bVar.getFirebaseInstallationId();
            this.f9831b = bVar.getRegistrationStatus();
            this.f9832c = bVar.getAuthToken();
            this.f9833d = bVar.getRefreshToken();
            this.f9834e = Long.valueOf(bVar.getExpiresInSecs());
            this.f9835f = Long.valueOf(bVar.getTokenCreationEpochInSecs());
            this.f9836g = bVar.getFisError();
        }
    }

    public a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j10, long j11, String str4) {
        this.f9823a = str;
        this.f9824b = registrationStatus;
        this.f9825c = str2;
        this.f9826d = str3;
        this.f9827e = j10;
        this.f9828f = j11;
        this.f9829g = str4;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str3 = this.f9823a;
        if (str3 != null ? str3.equals(bVar.getFirebaseInstallationId()) : bVar.getFirebaseInstallationId() == null) {
            if (this.f9824b.equals(bVar.getRegistrationStatus()) && ((str = this.f9825c) != null ? str.equals(bVar.getAuthToken()) : bVar.getAuthToken() == null) && ((str2 = this.f9826d) != null ? str2.equals(bVar.getRefreshToken()) : bVar.getRefreshToken() == null) && this.f9827e == bVar.getExpiresInSecs() && this.f9828f == bVar.getTokenCreationEpochInSecs()) {
                String str4 = this.f9829g;
                if (str4 == null) {
                    if (bVar.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(bVar.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.b
    public String getAuthToken() {
        return this.f9825c;
    }

    @Override // com.google.firebase.installations.local.b
    public long getExpiresInSecs() {
        return this.f9827e;
    }

    @Override // com.google.firebase.installations.local.b
    public String getFirebaseInstallationId() {
        return this.f9823a;
    }

    @Override // com.google.firebase.installations.local.b
    public String getFisError() {
        return this.f9829g;
    }

    @Override // com.google.firebase.installations.local.b
    public String getRefreshToken() {
        return this.f9826d;
    }

    @Override // com.google.firebase.installations.local.b
    public PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.f9824b;
    }

    @Override // com.google.firebase.installations.local.b
    public long getTokenCreationEpochInSecs() {
        return this.f9828f;
    }

    public int hashCode() {
        String str = this.f9823a;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f9824b.hashCode()) * 1000003;
        String str2 = this.f9825c;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f9826d;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j10 = this.f9827e;
        int i10 = (iHashCode3 ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f9828f;
        int i11 = (i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f9829g;
        return (str4 != null ? str4.hashCode() : 0) ^ i11;
    }

    @Override // com.google.firebase.installations.local.b
    public b.a toBuilder() {
        return new C0101a(this);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PersistedInstallationEntry{firebaseInstallationId=");
        sb2.append(this.f9823a);
        sb2.append(", registrationStatus=");
        sb2.append(this.f9824b);
        sb2.append(", authToken=");
        sb2.append(this.f9825c);
        sb2.append(", refreshToken=");
        sb2.append(this.f9826d);
        sb2.append(", expiresInSecs=");
        sb2.append(this.f9827e);
        sb2.append(", tokenCreationEpochInSecs=");
        sb2.append(this.f9828f);
        sb2.append(", fisError=");
        return c.o(sb2, this.f9829g, "}");
    }
}
