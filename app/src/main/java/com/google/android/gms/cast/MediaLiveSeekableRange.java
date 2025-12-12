package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaLiveSeekableRange extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6212b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6213m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6214n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6215o;

    /* renamed from: p, reason: collision with root package name */
    public static final Logger f6211p = new Logger("MediaLiveSeekableRange");
    public static final Parcelable.Creator<MediaLiveSeekableRange> CREATOR = new zzbz();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public MediaLiveSeekableRange(@SafeParcelable.Param long j10, @SafeParcelable.Param long j11, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11) {
        this.f6212b = Math.max(j10, 0L);
        this.f6213m = Math.max(j11, 0L);
        this.f6214n = z10;
        this.f6215o = z11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaLiveSeekableRange)) {
            return false;
        }
        MediaLiveSeekableRange mediaLiveSeekableRange = (MediaLiveSeekableRange) obj;
        return this.f6212b == mediaLiveSeekableRange.f6212b && this.f6213m == mediaLiveSeekableRange.f6213m && this.f6214n == mediaLiveSeekableRange.f6214n && this.f6215o == mediaLiveSeekableRange.f6215o;
    }

    public long getEndTime() {
        return this.f6213m;
    }

    public long getStartTime() {
        return this.f6212b;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f6212b), Long.valueOf(this.f6213m), Boolean.valueOf(this.f6214n), Boolean.valueOf(this.f6215o));
    }

    public boolean isLiveDone() {
        return this.f6215o;
    }

    public boolean isMovingWindow() {
        return this.f6214n;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 2, getStartTime());
        SafeParcelWriter.writeLong(parcel, 3, getEndTime());
        SafeParcelWriter.writeBoolean(parcel, 4, isMovingWindow());
        SafeParcelWriter.writeBoolean(parcel, 5, isLiveDone());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
