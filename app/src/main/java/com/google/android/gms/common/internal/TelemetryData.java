package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7365b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public List<MethodInvocation> f7366m;

    @SafeParcelable.Constructor
    public TelemetryData(@SafeParcelable.Param int i10, @SafeParcelable.Param List<MethodInvocation> list) {
        this.f7365b = i10;
        this.f7366m = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7365b);
        SafeParcelWriter.writeTypedList(parcel, 2, this.f7366m, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zaa() {
        return this.f7365b;
    }

    public final List<MethodInvocation> zab() {
        return this.f7366m;
    }

    public final void zac(MethodInvocation methodInvocation) {
        if (this.f7366m == null) {
            this.f7366m = new ArrayList();
        }
        this.f7366m.add(methodInvocation);
    }
}
