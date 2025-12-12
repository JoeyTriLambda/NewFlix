package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zat;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new zaj();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f8651b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final zat f8652m;

    @SafeParcelable.Constructor
    public zai(@SafeParcelable.Param int i10, @SafeParcelable.Param zat zatVar) {
        this.f8651b = i10;
        this.f8652m = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f8651b);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f8652m, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
