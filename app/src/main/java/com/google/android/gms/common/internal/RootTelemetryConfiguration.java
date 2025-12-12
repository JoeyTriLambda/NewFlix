package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzaj();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7358b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7359m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7360n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7361o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7362p;

    @SafeParcelable.Constructor
    public RootTelemetryConfiguration(@SafeParcelable.Param int i10, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12) {
        this.f7358b = i10;
        this.f7359m = z10;
        this.f7360n = z11;
        this.f7361o = i11;
        this.f7362p = i12;
    }

    @KeepForSdk
    public int getBatchPeriodMillis() {
        return this.f7361o;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsInBatch() {
        return this.f7362p;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.f7359m;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.f7360n;
    }

    @KeepForSdk
    public int getVersion() {
        return this.f7358b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getVersion());
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeInt(parcel, 4, getBatchPeriodMillis());
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsInBatch());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
