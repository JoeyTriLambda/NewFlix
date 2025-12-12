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
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzm();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final RootTelemetryConfiguration f7320b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7321m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f7322n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final int[] f7323o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7324p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final int[] f7325q;

    @SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@SafeParcelable.Param RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.Param boolean z10, @SafeParcelable.Param boolean z11, @SafeParcelable.Param int[] iArr, @SafeParcelable.Param int i10, @SafeParcelable.Param int[] iArr2) {
        this.f7320b = rootTelemetryConfiguration;
        this.f7321m = z10;
        this.f7322n = z11;
        this.f7323o = iArr;
        this.f7324p = i10;
        this.f7325q = iArr2;
    }

    @KeepForSdk
    public int getMaxMethodInvocationsLogged() {
        return this.f7324p;
    }

    @KeepForSdk
    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.f7323o;
    }

    @KeepForSdk
    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.f7325q;
    }

    @KeepForSdk
    public boolean getMethodInvocationTelemetryEnabled() {
        return this.f7321m;
    }

    @KeepForSdk
    public boolean getMethodTimingTelemetryEnabled() {
        return this.f7322n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f7320b, i10, false);
        SafeParcelWriter.writeBoolean(parcel, 2, getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean(parcel, 3, getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeIntArray(parcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
        SafeParcelWriter.writeInt(parcel, 5, getMaxMethodInvocationsLogged());
        SafeParcelWriter.writeIntArray(parcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final RootTelemetryConfiguration zza() {
        return this.f7320b;
    }
}
