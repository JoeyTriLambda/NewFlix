package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7476b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7477m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final FastJsonResponse.Field<?, ?> f7478n;

    @SafeParcelable.Constructor
    public zam(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param FastJsonResponse.Field<?, ?> field) {
        this.f7476b = i10;
        this.f7477m = str;
        this.f7478n = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7476b);
        SafeParcelWriter.writeString(parcel, 2, this.f7477m, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f7478n, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f7476b = 1;
        this.f7477m = str;
        this.f7478n = field;
    }
}
