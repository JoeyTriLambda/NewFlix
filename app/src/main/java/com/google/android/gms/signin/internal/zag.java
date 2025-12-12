package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<String> f8649b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f8650m;

    @SafeParcelable.Constructor
    public zag(@SafeParcelable.Param List<String> list, @SafeParcelable.Param String str) {
        this.f8649b = list;
        this.f8650m = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f8650m != null ? Status.f7069p : Status.f7073t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 1, this.f8649b, false);
        SafeParcelWriter.writeString(parcel, 2, this.f8650m, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
