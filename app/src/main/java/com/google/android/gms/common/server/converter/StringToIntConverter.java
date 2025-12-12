package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7447b;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap<String, Integer> f7448m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray<String> f7449n;

    @KeepForSdk
    public StringToIntConverter() {
        this.f7447b = 1;
        this.f7448m = new HashMap<>();
        this.f7449n = new SparseArray<>();
    }

    @KeepForSdk
    public StringToIntConverter add(String str, int i10) {
        this.f7448m.put(str, Integer.valueOf(i10));
        this.f7449n.put(i10, str);
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7447b);
        ArrayList arrayList = new ArrayList();
        HashMap<String, Integer> map = this.f7448m;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, map.get(str).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* bridge */ /* synthetic */ String zad(Integer num) {
        String str = this.f7449n.get(num.intValue());
        return (str == null && this.f7448m.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @SafeParcelable.Constructor
    public StringToIntConverter(@SafeParcelable.Param int i10, @SafeParcelable.Param ArrayList<zac> arrayList) {
        this.f7447b = i10;
        this.f7448m = new HashMap<>();
        this.f7449n = new SparseArray<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zac zacVar = arrayList.get(i11);
            add(zacVar.f7453m, zacVar.f7454n);
        }
    }
}
