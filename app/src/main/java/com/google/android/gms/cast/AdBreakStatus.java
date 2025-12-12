package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class AdBreakStatus extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6123b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6124m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6125n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6126o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6127p;

    /* renamed from: q, reason: collision with root package name */
    public static final Logger f6122q = new Logger("AdBreakStatus");
    public static final Parcelable.Creator<AdBreakStatus> CREATOR = new zzc();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public AdBreakStatus(@SafeParcelable.Param long j10, @SafeParcelable.Param long j11, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param long j12) {
        this.f6123b = j10;
        this.f6124m = j11;
        this.f6125n = str;
        this.f6126o = str2;
        this.f6127p = j12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdBreakStatus)) {
            return false;
        }
        AdBreakStatus adBreakStatus = (AdBreakStatus) obj;
        return this.f6123b == adBreakStatus.f6123b && this.f6124m == adBreakStatus.f6124m && CastUtils.zze(this.f6125n, adBreakStatus.f6125n) && CastUtils.zze(this.f6126o, adBreakStatus.f6126o) && this.f6127p == adBreakStatus.f6127p;
    }

    public String getBreakClipId() {
        return this.f6126o;
    }

    public String getBreakId() {
        return this.f6125n;
    }

    public long getCurrentBreakClipTimeInMs() {
        return this.f6124m;
    }

    public long getCurrentBreakTimeInMs() {
        return this.f6123b;
    }

    public long getWhenSkippableInMs() {
        return this.f6127p;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f6123b), Long.valueOf(this.f6124m), this.f6125n, this.f6126o, Long.valueOf(this.f6127p));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getCurrentBreakTimeInMs());
        SafeParcelWriter.writeLong(parcel, 3, getCurrentBreakClipTimeInMs());
        SafeParcelWriter.writeString(parcel, 4, getBreakId(), false);
        SafeParcelWriter.writeString(parcel, 5, getBreakClipId(), false);
        SafeParcelWriter.writeLong(parcel, 6, getWhenSkippableInMs());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
