package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public class CredentialsData extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<CredentialsData> CREATOR = new zzas();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6179b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6180m;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public CredentialsData(@SafeParcelable.Param String str, @SafeParcelable.Param String str2) {
        this.f6179b = str;
        this.f6180m = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredentialsData)) {
            return false;
        }
        CredentialsData credentialsData = (CredentialsData) obj;
        return Objects.equal(this.f6179b, credentialsData.f6179b) && Objects.equal(this.f6180m, credentialsData.f6180m);
    }

    public String getCredentials() {
        return this.f6179b;
    }

    public String getCredentialsType() {
        return this.f6180m;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6179b, this.f6180m);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCredentials(), false);
        SafeParcelWriter.writeString(parcel, 2, getCredentialsType(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
