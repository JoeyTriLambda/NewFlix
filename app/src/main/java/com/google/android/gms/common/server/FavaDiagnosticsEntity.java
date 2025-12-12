package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7444b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7445m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7446n;

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param int i11) {
        this.f7444b = i10;
        this.f7445m = str;
        this.f7446n = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7444b);
        SafeParcelWriter.writeString(parcel, 2, this.f7445m, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7446n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
