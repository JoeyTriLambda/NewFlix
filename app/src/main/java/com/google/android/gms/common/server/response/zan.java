package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@ShowFirstParty
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7479b;

    /* renamed from: m, reason: collision with root package name */
    public final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f7480m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f7481n;

    @SafeParcelable.Constructor
    public zan(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param ArrayList arrayList) {
        this.f7479b = i10;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = new HashMap<>();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zal zalVar = (zal) arrayList.get(i11);
            String str2 = zalVar.f7474m;
            HashMap map2 = new HashMap();
            ArrayList<zam> arrayList2 = zalVar.f7475n;
            int size2 = ((ArrayList) Preconditions.checkNotNull(arrayList2)).size();
            for (int i12 = 0; i12 < size2; i12++) {
                zam zamVar = arrayList2.get(i12);
                map2.put(zamVar.f7477m, zamVar.f7478n);
            }
            map.put(str2, map2);
        }
        this.f7480m = map;
        this.f7481n = (String) Preconditions.checkNotNull(str);
        zad();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = this.f7480m;
        for (String str : map.keySet()) {
            sb2.append(str);
            sb2.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map2 = map.get(str);
            for (String str2 : map2.keySet()) {
                sb2.append("  ");
                sb2.append(str2);
                sb2.append(": ");
                sb2.append(map2.get(str2));
            }
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7479b);
        ArrayList arrayList = new ArrayList();
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = this.f7480m;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, map.get(str)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.f7481n, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final String zaa() {
        return this.f7481n;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zab(String str) {
        return this.f7480m.get(str);
    }

    public final void zad() {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> map = this.f7480m;
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            Map<String, FastJsonResponse.Field<?, ?>> map2 = map.get(it.next());
            Iterator<String> it2 = map2.keySet().iterator();
            while (it2.hasNext()) {
                map2.get(it2.next()).zai(this);
            }
        }
    }
}
