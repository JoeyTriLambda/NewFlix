package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@ShowFirstParty
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzat> CREATOR = new zzau();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final float f6929b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final float f6930m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final float f6931n;

    @SafeParcelable.Constructor
    public zzat(@SafeParcelable.Param float f10, @SafeParcelable.Param float f11, @SafeParcelable.Param float f12) {
        this.f6929b = f10;
        this.f6930m = f11;
        this.f6931n = f12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzat)) {
            return false;
        }
        zzat zzatVar = (zzat) obj;
        return this.f6929b == zzatVar.f6929b && this.f6930m == zzatVar.f6930m && this.f6931n == zzatVar.f6931n;
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f6929b), Float.valueOf(this.f6930m), Float.valueOf(this.f6931n));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.f6929b);
        SafeParcelWriter.writeFloat(parcel, 3, this.f6930m);
        SafeParcelWriter.writeFloat(parcel, 4, this.f6931n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
