package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f8646b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f8647m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final Intent f8648n;

    public zaa() {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f8647m == 0 ? Status.f7069p : Status.f7073t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f8646b);
        SafeParcelWriter.writeInt(parcel, 2, this.f8647m);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f8648n, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zaa(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param Intent intent) {
        this.f8646b = i10;
        this.f8647m = i11;
        this.f8648n = intent;
    }
}
