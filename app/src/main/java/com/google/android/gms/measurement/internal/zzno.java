package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzno extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzno> CREATOR = new zznr();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f8588b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8589m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f8590n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final Long f8591o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8592p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8593q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final Double f8594r;

    public zzno(zznq zznqVar) {
        this(zznqVar.f8597c, zznqVar.f8596b, zznqVar.f8598d, zznqVar.f8599e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f8588b);
        SafeParcelWriter.writeString(parcel, 2, this.f8589m, false);
        SafeParcelWriter.writeLong(parcel, 3, this.f8590n);
        SafeParcelWriter.writeLongObject(parcel, 4, this.f8591o, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.f8592p, false);
        SafeParcelWriter.writeString(parcel, 7, this.f8593q, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.f8594r, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final Object zza() {
        Long l10 = this.f8591o;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f8594r;
        if (d10 != null) {
            return d10;
        }
        String str = this.f8592p;
        if (str != null) {
            return str;
        }
        return null;
    }

    public zzno(String str, String str2, long j10, Object obj) {
        Preconditions.checkNotEmpty(str);
        this.f8588b = 2;
        this.f8589m = str;
        this.f8590n = j10;
        this.f8593q = str2;
        if (obj == null) {
            this.f8591o = null;
            this.f8594r = null;
            this.f8592p = null;
            return;
        }
        if (obj instanceof Long) {
            this.f8591o = (Long) obj;
            this.f8594r = null;
            this.f8592p = null;
        } else if (obj instanceof String) {
            this.f8591o = null;
            this.f8594r = null;
            this.f8592p = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f8591o = null;
            this.f8594r = (Double) obj;
            this.f8592p = null;
        }
    }

    @SafeParcelable.Constructor
    public zzno(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param long j10, @SafeParcelable.Param Long l10, @SafeParcelable.Param Float f10, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param Double d10) {
        this.f8588b = i10;
        this.f8589m = str;
        this.f8590n = j10;
        this.f8591o = l10;
        if (i10 == 1) {
            this.f8594r = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f8594r = d10;
        }
        this.f8592p = str2;
        this.f8593q = str3;
    }
}
