package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7393b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7394m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7395n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    public final Scope[] f7396o;

    @SafeParcelable.Constructor
    public zax(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param Scope[] scopeArr) {
        this.f7393b = i10;
        this.f7394m = i11;
        this.f7395n = i12;
        this.f7396o = scopeArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7393b);
        SafeParcelWriter.writeInt(parcel, 2, this.f7394m);
        SafeParcelWriter.writeInt(parcel, 3, this.f7395n);
        SafeParcelWriter.writeTypedArray(parcel, 4, this.f7396o, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
