package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@SafeParcelable.Class
@Deprecated
/* loaded from: classes.dex */
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7405b;

    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param int i10) {
        this.f7405b = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7405b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
