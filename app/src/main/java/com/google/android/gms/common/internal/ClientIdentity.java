package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new zaa();

    /* renamed from: b, reason: collision with root package name */
    @KeepForSdk
    @SafeParcelable.Field
    public final int f7305b;

    /* renamed from: m, reason: collision with root package name */
    @KeepForSdk
    @SafeParcelable.Field
    public final String f7306m;

    @SafeParcelable.Constructor
    public ClientIdentity(@SafeParcelable.Param int i10, @SafeParcelable.Param String str) {
        this.f7305b = i10;
        this.f7306m = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f7305b == this.f7305b && Objects.equal(clientIdentity.f7306m, this.f7306m);
    }

    public final int hashCode() {
        return this.f7305b;
    }

    public final String toString() {
        String str = this.f7306m;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 12);
        sb2.append(this.f7305b);
        sb2.append(":");
        sb2.append(str);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7305b);
        SafeParcelWriter.writeString(parcel, 2, this.f7306m, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
