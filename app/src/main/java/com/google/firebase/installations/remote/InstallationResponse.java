package com.google.firebase.installations.remote;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.a;

@AutoValue
/* loaded from: classes.dex */
public abstract class InstallationResponse {

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    @AutoValue.Builder
    public static abstract class a {
        public abstract InstallationResponse build();

        public abstract a setAuthToken(TokenResult tokenResult);

        public abstract a setFid(String str);

        public abstract a setRefreshToken(String str);

        public abstract a setResponseCode(ResponseCode responseCode);

        public abstract a setUri(String str);
    }

    public static a builder() {
        return new a.C0102a();
    }

    public abstract TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract ResponseCode getResponseCode();

    public abstract String getUri();
}
