package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f6094b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6095m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f6096n;

    @SafeParcelable.Constructor
    public GoogleSignInOptionsExtensionParcelable(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param Bundle bundle) {
        this.f6094b = i10;
        this.f6095m = i11;
        this.f6096n = bundle;
    }

    @KeepForSdk
    public int getType() {
        return this.f6095m;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6094b);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeBundle(parcel, 3, this.f6096n, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
