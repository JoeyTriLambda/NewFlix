package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7452b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7453m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7454n;

    @SafeParcelable.Constructor
    public zac(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param int i11) {
        this.f7452b = i10;
        this.f7453m = str;
        this.f7454n = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7452b);
        SafeParcelWriter.writeString(parcel, 2, this.f7453m, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7454n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zac(String str, int i10) {
        this.f7452b = 1;
        this.f7453m = str;
        this.f7454n = i10;
    }
}
