package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* compiled from: AutoValue_NetworkConnectionInfo.java */
/* loaded from: classes.dex */
public final class c extends NetworkConnectionInfo {

    /* renamed from: a, reason: collision with root package name */
    public final NetworkConnectionInfo.NetworkType f5664a;

    /* renamed from: b, reason: collision with root package name */
    public final NetworkConnectionInfo.MobileSubtype f5665b;

    /* compiled from: AutoValue_NetworkConnectionInfo.java */
    public static final class a extends NetworkConnectionInfo.a {

        /* renamed from: a, reason: collision with root package name */
        public NetworkConnectionInfo.NetworkType f5666a;

        /* renamed from: b, reason: collision with root package name */
        public NetworkConnectionInfo.MobileSubtype f5667b;

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo build() {
            return new c(this.f5666a, this.f5667b);
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a setMobileSubtype(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f5667b = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.a
        public NetworkConnectionInfo.a setNetworkType(NetworkConnectionInfo.NetworkType networkType) {
            this.f5666a = networkType;
            return this;
        }
    }

    public c(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f5664a = networkType;
        this.f5665b = mobileSubtype;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f5664a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.getNetworkType()) : networkConnectionInfo.getNetworkType() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f5665b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.getMobileSubtype() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.getMobileSubtype())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        return this.f5665b;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.NetworkType getNetworkType() {
        return this.f5664a;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.f5664a;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f5665b;
        return (mobileSubtype != null ? mobileSubtype.hashCode() : 0) ^ iHashCode;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f5664a + ", mobileSubtype=" + this.f5665b + "}";
    }
}
