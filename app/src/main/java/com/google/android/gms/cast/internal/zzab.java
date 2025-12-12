package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final double f6809b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6810m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6811n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final ApplicationMetadata f6812o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6813p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final zzav f6814q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final double f6815r;

    public zzab() {
        this(Double.NaN, false, -1, null, -1, null, Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzab)) {
            return false;
        }
        zzab zzabVar = (zzab) obj;
        if (this.f6809b == zzabVar.f6809b && this.f6810m == zzabVar.f6810m && this.f6811n == zzabVar.f6811n && CastUtils.zze(this.f6812o, zzabVar.f6812o) && this.f6813p == zzabVar.f6813p) {
            zzav zzavVar = this.f6814q;
            if (CastUtils.zze(zzavVar, zzavVar) && this.f6815r == zzabVar.f6815r) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Double.valueOf(this.f6809b), Boolean.valueOf(this.f6810m), Integer.valueOf(this.f6811n), this.f6812o, Integer.valueOf(this.f6813p), this.f6814q, Double.valueOf(this.f6815r));
    }

    public final String toString() {
        return String.format(Locale.ROOT, "volume=%f", Double.valueOf(this.f6809b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 2, this.f6809b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f6810m);
        SafeParcelWriter.writeInt(parcel, 4, this.f6811n);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f6812o, i10, false);
        SafeParcelWriter.writeInt(parcel, 6, this.f6813p);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f6814q, i10, false);
        SafeParcelWriter.writeDouble(parcel, 8, this.f6815r);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final double zza() {
        return this.f6815r;
    }

    public final double zzb() {
        return this.f6809b;
    }

    public final int zzc() {
        return this.f6811n;
    }

    public final int zzd() {
        return this.f6813p;
    }

    public final ApplicationMetadata zze() {
        return this.f6812o;
    }

    public final zzav zzf() {
        return this.f6814q;
    }

    public final boolean zzg() {
        return this.f6810m;
    }

    @SafeParcelable.Constructor
    public zzab(@SafeParcelable.Param double d10, @SafeParcelable.Param boolean z10, @SafeParcelable.Param int i10, @SafeParcelable.Param ApplicationMetadata applicationMetadata, @SafeParcelable.Param int i11, @SafeParcelable.Param zzav zzavVar, @SafeParcelable.Param double d11) {
        this.f6809b = d10;
        this.f6810m = z10;
        this.f6811n = i10;
        this.f6812o = applicationMetadata;
        this.f6813p = i11;
        this.f6814q = zzavVar;
        this.f6815r = d11;
    }
}
