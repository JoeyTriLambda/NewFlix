package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class zzba extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbc();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f7707b;

    @SafeParcelable.Constructor
    public zzba(@SafeParcelable.Param Bundle bundle) {
        this.f7707b = bundle;
    }

    public final Double a() {
        return Double.valueOf(this.f7707b.getDouble("value"));
    }

    public final String b(String str) {
        return this.f7707b.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbd(this);
    }

    public final String toString() {
        return this.f7707b.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.f7707b.size();
    }

    public final Bundle zzb() {
        return new Bundle(this.f7707b);
    }
}
