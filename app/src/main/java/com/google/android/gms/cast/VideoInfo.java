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
public final class VideoInfo extends AbstractSafeParcelable {

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6330b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6331m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6332n;

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f6329o = new Logger("VideoInfo");
    public static final Parcelable.Creator<VideoInfo> CREATOR = new zzdu();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {
    }

    @SafeParcelable.Constructor
    public VideoInfo(@SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12) {
        this.f6330b = i10;
        this.f6331m = i11;
        this.f6332n = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoInfo)) {
            return false;
        }
        VideoInfo videoInfo = (VideoInfo) obj;
        return this.f6331m == videoInfo.getHeight() && this.f6330b == videoInfo.getWidth() && this.f6332n == videoInfo.getHdrType();
    }

    public int getHdrType() {
        return this.f6332n;
    }

    public int getHeight() {
        return this.f6331m;
    }

    public int getWidth() {
        return this.f6330b;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6331m), Integer.valueOf(this.f6330b), Integer.valueOf(this.f6332n));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getWidth());
        SafeParcelWriter.writeInt(parcel, 3, getHeight());
        SafeParcelWriter.writeInt(parcel, 4, getHdrType());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
