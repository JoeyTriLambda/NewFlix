package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
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
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzat f6932b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzat f6933m;

    @SafeParcelable.Constructor
    public zzav(@SafeParcelable.Param zzat zzatVar, @SafeParcelable.Param zzat zzatVar2) {
        this.f6932b = zzatVar;
        this.f6933m = zzatVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzavVar = (zzav) obj;
        return CastUtils.zze(this.f6932b, zzavVar.f6932b) && CastUtils.zze(this.f6933m, zzavVar.f6933m);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f6932b, this.f6933m);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f6932b, i10, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f6933m, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
