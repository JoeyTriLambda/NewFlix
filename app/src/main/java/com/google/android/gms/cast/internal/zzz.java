package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6913b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6914m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6915n;

    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param int i10, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        this.f6913b = i10;
        this.f6914m = z10;
        this.f6915n = z11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzz)) {
            return false;
        }
        zzz zzzVar = (zzz) obj;
        return this.f6913b == zzzVar.f6913b && this.f6914m == zzzVar.f6914m && this.f6915n == zzzVar.f6915n;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6913b), Boolean.valueOf(this.f6914m), Boolean.valueOf(this.f6915n));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f6913b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f6914m);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f6915n);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
