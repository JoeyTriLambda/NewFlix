package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7022b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    public final int f7023m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f7024n;

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param String str, @SafeParcelable.Param int i10, @SafeParcelable.Param long j10) {
        this.f7022b = str;
        this.f7023m = i10;
        this.f7024n = j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public String getName() {
        return this.f7022b;
    }

    @KeepForSdk
    public long getVersion() {
        long j10 = this.f7024n;
        return j10 == -1 ? this.f7023m : j10;
    }

    public final int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add(MediationMetaData.KEY_NAME, getName());
        stringHelper.add("version", Long.valueOf(getVersion()));
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.f7023m);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @KeepForSdk
    public Feature(String str, long j10) {
        this.f7022b = str;
        this.f7024n = j10;
        this.f7023m = -1;
    }
}
