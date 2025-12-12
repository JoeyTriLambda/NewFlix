package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7545b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7546m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7547n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7548o;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param String str, @SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param boolean z10) {
        this.f7545b = z10;
        this.f7546m = str;
        this.f7547n = zzy.a(i10) - 1;
        this.f7548o = zzd.a(i11) - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f7545b);
        SafeParcelWriter.writeString(parcel, 2, this.f7546m, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7547n);
        SafeParcelWriter.writeInt(parcel, 4, this.f7548o);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zza() {
        return this.f7546m;
    }

    public final boolean zzb() {
        return this.f7545b;
    }

    public final int zzc() {
        return zzd.a(this.f7548o);
    }

    public final int zzd() {
        return zzy.a(this.f7547n);
    }
}
