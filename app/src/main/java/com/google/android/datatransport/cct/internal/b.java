package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* compiled from: AutoValue_ClientInfo.java */
/* loaded from: classes.dex */
public final class b extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f5660a;

    /* renamed from: b, reason: collision with root package name */
    public final p4.a f5661b;

    /* compiled from: AutoValue_ClientInfo.java */
    public static final class a extends ClientInfo.a {

        /* renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f5662a;

        /* renamed from: b, reason: collision with root package name */
        public p4.a f5663b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo build() {
            return new b(this.f5662a, this.f5663b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a setAndroidClientInfo(p4.a aVar) {
            this.f5663b = aVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a setClientType(ClientInfo.ClientType clientType) {
            this.f5662a = clientType;
            return this;
        }
    }

    public b(ClientInfo.ClientType clientType, p4.a aVar) {
        this.f5660a = clientType;
        this.f5661b = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f5660a;
        if (clientType != null ? clientType.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
            p4.a aVar = this.f5661b;
            if (aVar == null) {
                if (clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.getAndroidClientInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public p4.a getAndroidClientInfo() {
        return this.f5661b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType getClientType() {
        return this.f5660a;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f5660a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        p4.a aVar = this.f5661b;
        return (aVar != null ? aVar.hashCode() : 0) ^ iHashCode;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f5660a + ", androidClientInfo=" + this.f5661b + "}";
    }
}
