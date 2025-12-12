package com.google.firebase.installations.remote;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.b;

@AutoValue
/* loaded from: classes.dex */
public abstract class TokenResult {

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @AutoValue.Builder
    public static abstract class a {
        public abstract TokenResult build();

        public abstract a setResponseCode(ResponseCode responseCode);

        public abstract a setToken(String str);

        public abstract a setTokenExpirationTimestamp(long j10);
    }

    public static a builder() {
        return new b.a().setTokenExpirationTimestamp(0L);
    }

    public abstract ResponseCode getResponseCode();

    public abstract String getToken();

    public abstract long getTokenExpirationTimestamp();
}
