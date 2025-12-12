package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzmv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmv> CREATOR = new zzmu();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8517b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8518m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f8519n;

    @SafeParcelable.Constructor
    public zzmv(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param long j10) {
        this.f8517b = str;
        this.f8518m = j10;
        this.f8519n = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f8517b, false);
        SafeParcelWriter.writeLong(parcel, 2, this.f8518m);
        SafeParcelWriter.writeInt(parcel, 3, this.f8519n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
