package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f8653b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final ConnectionResult f8654m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final zav f8655n;

    @SafeParcelable.Constructor
    public zak(@SafeParcelable.Param int i10, @SafeParcelable.Param ConnectionResult connectionResult, @SafeParcelable.Param zav zavVar) {
        this.f8653b = i10;
        this.f8654m = connectionResult;
        this.f8655n = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f8653b);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f8654m, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f8655n, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final ConnectionResult zaa() {
        return this.f8654m;
    }

    public final zav zab() {
        return this.f8655n;
    }
}
