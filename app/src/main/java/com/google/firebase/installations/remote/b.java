package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* compiled from: AutoValue_TokenResult.java */
/* loaded from: classes.dex */
public final class b extends TokenResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f9854a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9855b;

    /* renamed from: c, reason: collision with root package name */
    public final TokenResult.ResponseCode f9856c;

    /* compiled from: AutoValue_TokenResult.java */
    public static final class a extends TokenResult.a {

        /* renamed from: a, reason: collision with root package name */
        public String f9857a;

        /* renamed from: b, reason: collision with root package name */
        public Long f9858b;

        /* renamed from: c, reason: collision with root package name */
        public TokenResult.ResponseCode f9859c;

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult build() {
            String str = this.f9858b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new b(this.f9857a, this.f9858b.longValue(), this.f9859c);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a setResponseCode(TokenResult.ResponseCode responseCode) {
            this.f9859c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a setToken(String str) {
            this.f9857a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a setTokenExpirationTimestamp(long j10) {
            this.f9858b = Long.valueOf(j10);
            return this;
        }
    }

    public b(String str, long j10, TokenResult.ResponseCode responseCode) {
        this.f9854a = str;
        this.f9855b = j10;
        this.f9856c = responseCode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f9854a;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.f9855b == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.f9856c;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public TokenResult.ResponseCode getResponseCode() {
        return this.f9856c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public String getToken() {
        return this.f9854a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public long getTokenExpirationTimestamp() {
        return this.f9855b;
    }

    public int hashCode() {
        String str = this.f9854a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j10 = this.f9855b;
        int i10 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) ((j10 >>> 32) ^ j10))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f9856c;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ i10;
    }

    public String toString() {
        return "TokenResult{token=" + this.f9854a + ", tokenExpirationTimestamp=" + this.f9855b + ", responseCode=" + this.f9856c + "}";
    }
}
