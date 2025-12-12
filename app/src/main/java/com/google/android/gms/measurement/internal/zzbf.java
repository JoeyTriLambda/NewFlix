package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzbf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbe();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7720b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzba f7721m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7722n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7723o;

    public zzbf(zzbf zzbfVar, long j10) {
        Preconditions.checkNotNull(zzbfVar);
        this.f7720b = zzbfVar.f7720b;
        this.f7721m = zzbfVar.f7721m;
        this.f7722n = zzbfVar.f7722n;
        this.f7723o = j10;
    }

    public final String toString() {
        return "origin=" + this.f7722n + ",name=" + this.f7720b + ",params=" + String.valueOf(this.f7721m);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f7720b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7721m, i10, false);
        SafeParcelWriter.writeString(parcel, 4, this.f7722n, false);
        SafeParcelWriter.writeLong(parcel, 5, this.f7723o);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzbf(@SafeParcelable.Param String str, @SafeParcelable.Param zzba zzbaVar, @SafeParcelable.Param String str2, @SafeParcelable.Param long j10) {
        this.f7720b = str;
        this.f7721m = zzbaVar;
        this.f7722n = str2;
        this.f7723o = j10;
    }
}
