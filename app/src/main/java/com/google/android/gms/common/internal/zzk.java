package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f7418b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final Feature[] f7419m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7420n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final ConnectionTelemetryConfiguration f7421o;

    @SafeParcelable.Constructor
    public zzk(@SafeParcelable.Param Bundle bundle, @SafeParcelable.Param Feature[] featureArr, @SafeParcelable.Param int i10, @SafeParcelable.Param ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.f7418b = bundle;
        this.f7419m = featureArr;
        this.f7420n = i10;
        this.f7421o = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f7418b, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f7419m, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f7420n);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f7421o, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzk() {
    }
}
