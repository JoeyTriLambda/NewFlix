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
public final class zzbu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbv();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6994b;

    public zzbu() {
        this.f6994b = 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zzbu) && this.f6994b == ((zzbu) obj).f6994b;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6994b));
    }

    public final String toString() {
        int i10 = this.f6994b;
        return String.format("joinOptions(connectionType=%s)", i10 != 0 ? i10 != 2 ? "UNKNOWN" : "INVISIBLE" : "STRONG");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f6994b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzbu(@SafeParcelable.Param int i10) {
        this.f6994b = i10;
    }
}
