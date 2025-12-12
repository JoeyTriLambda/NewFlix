package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.InstallationResponse;

/* compiled from: AutoValue_InstallationResponse.java */
/* loaded from: classes.dex */
public final class a extends InstallationResponse {

    /* renamed from: a, reason: collision with root package name */
    public final String f9844a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9845b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9846c;

    /* renamed from: d, reason: collision with root package name */
    public final TokenResult f9847d;

    /* renamed from: e, reason: collision with root package name */
    public final InstallationResponse.ResponseCode f9848e;

    /* compiled from: AutoValue_InstallationResponse.java */
    /* renamed from: com.google.firebase.installations.remote.a$a, reason: collision with other inner class name */
    public static final class C0102a extends InstallationResponse.a {

        /* renamed from: a, reason: collision with root package name */
        public String f9849a;

        /* renamed from: b, reason: collision with root package name */
        public String f9850b;

        /* renamed from: c, reason: collision with root package name */
        public String f9851c;

        /* renamed from: d, reason: collision with root package name */
        public TokenResult f9852d;

        /* renamed from: e, reason: collision with root package name */
        public InstallationResponse.ResponseCode f9853e;

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse build() {
            return new a(this.f9849a, this.f9850b, this.f9851c, this.f9852d, this.f9853e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a setAuthToken(TokenResult tokenResult) {
            this.f9852d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a setFid(String str) {
            this.f9850b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a setRefreshToken(String str) {
            this.f9851c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.f9853e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a setUri(String str) {
            this.f9849a = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.f9844a = str;
        this.f9845b = str2;
        this.f9846c = str3;
        this.f9847d = tokenResult;
        this.f9848e = responseCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f9844a;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.f9845b;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.f9846c;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.f9847d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f9848e;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public TokenResult getAuthToken() {
        return this.f9847d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getFid() {
        return this.f9845b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getRefreshToken() {
        return this.f9846c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public InstallationResponse.ResponseCode getResponseCode() {
        return this.f9848e;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public String getUri() {
        return this.f9844a;
    }

    public int hashCode() {
        String str = this.f9844a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f9845b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f9846c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f9847d;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f9848e;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ iHashCode4;
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f9844a + ", fid=" + this.f9845b + ", refreshToken=" + this.f9846c + ", authToken=" + this.f9847d + ", responseCode=" + this.f9848e + "}";
    }
}
