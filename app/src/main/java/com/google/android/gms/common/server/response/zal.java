package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zap();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7473b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7474m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final ArrayList<zam> f7475n;

    @SafeParcelable.Constructor
    public zal(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param ArrayList<zam> arrayList) {
        this.f7473b = i10;
        this.f7474m = str;
        this.f7475n = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7473b);
        SafeParcelWriter.writeString(parcel, 2, this.f7474m, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.f7475n, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.f7473b = 1;
        this.f7474m = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, map.get(str2)));
            }
        }
        this.f7475n = arrayList;
    }
}
