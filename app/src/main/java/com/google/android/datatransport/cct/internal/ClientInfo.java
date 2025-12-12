package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.b;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ClientInfo {

    public enum ClientType {
        /* JADX INFO: Fake field, exist only in values array */
        UNKNOWN,
        ANDROID_FIREBASE
    }

    @AutoValue.Builder
    public static abstract class a {
        public abstract ClientInfo build();

        public abstract a setAndroidClientInfo(p4.a aVar);

        public abstract a setClientType(ClientType clientType);
    }

    public static a builder() {
        return new b.a();
    }

    public abstract p4.a getAndroidClientInfo();

    public abstract ClientType getClientType();
}
