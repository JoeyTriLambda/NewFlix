package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class CastDevice extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new zzs();

    @SafeParcelable.Field
    public final String A;

    @SafeParcelable.Field
    public final boolean B;

    @SafeParcelable.Field
    public final com.google.android.gms.cast.internal.zzz C;

    @SafeParcelable.Field
    public final Integer D;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6146b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6147m;

    /* renamed from: n, reason: collision with root package name */
    public final InetAddress f6148n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6149o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6150p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6151q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6152r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6153s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6154t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6155u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6156v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6157w;

    /* renamed from: x, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f6158x;

    /* renamed from: y, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6159y;

    /* renamed from: z, reason: collision with root package name */
    @SafeParcelable.Field
    public final byte[] f6160z;

    @SafeParcelable.Constructor
    public CastDevice(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param String str5, @SafeParcelable.Param int i10, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param String str6, @SafeParcelable.Param String str7, @SafeParcelable.Param int i13, @SafeParcelable.Param String str8, @SafeParcelable.Param byte[] bArr, @SafeParcelable.Param String str9, @SafeParcelable.Param boolean z10, @SafeParcelable.Param com.google.android.gms.cast.internal.zzz zzzVar, @SafeParcelable.Param Integer num) {
        this.f6146b = str == null ? "" : str;
        String str10 = str2 == null ? "" : str2;
        this.f6147m = str10;
        if (!TextUtils.isEmpty(str10)) {
            try {
                this.f6148n = InetAddress.getByName(str10);
            } catch (UnknownHostException e10) {
                Log.i("CastDevice", "Unable to convert host address (" + this.f6147m + ") to ipaddress: " + e10.getMessage());
            }
        }
        this.f6149o = str3 == null ? "" : str3;
        this.f6150p = str4 == null ? "" : str4;
        this.f6151q = str5 == null ? "" : str5;
        this.f6152r = i10;
        this.f6153s = arrayList == null ? new ArrayList() : arrayList;
        this.f6154t = i11;
        this.f6155u = i12;
        this.f6156v = str6 != null ? str6 : "";
        this.f6157w = str7;
        this.f6158x = i13;
        this.f6159y = str8;
        this.f6160z = bArr;
        this.A = str9;
        this.B = z10;
        this.C = zzzVar;
        this.D = num;
    }

    public static CastDevice getFromBundle(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        String str = this.f6146b;
        if (str == null) {
            return castDevice.f6146b == null;
        }
        if (CastUtils.zze(str, castDevice.f6146b) && CastUtils.zze(this.f6148n, castDevice.f6148n) && CastUtils.zze(this.f6150p, castDevice.f6150p) && CastUtils.zze(this.f6149o, castDevice.f6149o)) {
            String str2 = castDevice.f6151q;
            String str3 = this.f6151q;
            if (CastUtils.zze(str3, str2)) {
                int i10 = castDevice.f6152r;
                int i11 = this.f6152r;
                if (i11 == i10 && CastUtils.zze(this.f6153s, castDevice.f6153s) && this.f6154t == castDevice.f6154t && this.f6155u == castDevice.f6155u && CastUtils.zze(this.f6156v, castDevice.f6156v) && CastUtils.zze(Integer.valueOf(this.f6158x), Integer.valueOf(castDevice.f6158x)) && CastUtils.zze(this.f6159y, castDevice.f6159y) && CastUtils.zze(this.f6157w, castDevice.f6157w) && CastUtils.zze(str3, castDevice.getDeviceVersion()) && i11 == castDevice.getServicePort()) {
                    byte[] bArr = castDevice.f6160z;
                    byte[] bArr2 = this.f6160z;
                    if (((bArr2 == null && bArr == null) || Arrays.equals(bArr2, bArr)) && CastUtils.zze(this.A, castDevice.A) && this.B == castDevice.B && CastUtils.zze(zzb(), castDevice.zzb())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getDeviceId() {
        String str = this.f6146b;
        return str.startsWith("__cast_nearby__") ? str.substring(16) : str;
    }

    public String getDeviceVersion() {
        return this.f6151q;
    }

    public String getFriendlyName() {
        return this.f6149o;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.f6153s);
    }

    public String getModelName() {
        return this.f6150p;
    }

    public int getServicePort() {
        return this.f6152r;
    }

    public boolean hasCapability(int i10) {
        return (this.f6154t & i10) == i10;
    }

    public int hashCode() {
        String str = this.f6146b;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public void putInBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
    }

    public String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[2];
        String str = this.f6149o;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            str = length <= 2 ? length == 2 ? "xx" : "x" : String.format(locale, "%c%d%c", Character.valueOf(str.charAt(0)), Integer.valueOf(length - 2), Character.valueOf(str.charAt(length - 1)));
        }
        objArr[0] = str;
        objArr[1] = this.f6146b;
        return String.format(locale, "\"%s\" (%s)", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f6146b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f6147m, false);
        SafeParcelWriter.writeString(parcel, 4, getFriendlyName(), false);
        SafeParcelWriter.writeString(parcel, 5, getModelName(), false);
        SafeParcelWriter.writeString(parcel, 6, getDeviceVersion(), false);
        SafeParcelWriter.writeInt(parcel, 7, getServicePort());
        SafeParcelWriter.writeTypedList(parcel, 8, getIcons(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.f6154t);
        SafeParcelWriter.writeInt(parcel, 10, this.f6155u);
        SafeParcelWriter.writeString(parcel, 11, this.f6156v, false);
        SafeParcelWriter.writeString(parcel, 12, this.f6157w, false);
        SafeParcelWriter.writeInt(parcel, 13, this.f6158x);
        SafeParcelWriter.writeString(parcel, 14, this.f6159y, false);
        SafeParcelWriter.writeByteArray(parcel, 15, this.f6160z, false);
        SafeParcelWriter.writeString(parcel, 16, this.A, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.B);
        SafeParcelWriter.writeParcelable(parcel, 18, zzb(), i10, false);
        SafeParcelWriter.writeIntegerObject(parcel, 19, this.D, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @ShowFirstParty
    public final int zza() {
        return this.f6154t;
    }

    public final com.google.android.gms.cast.internal.zzz zzb() {
        com.google.android.gms.cast.internal.zzz zzzVar = this.C;
        if (zzzVar == null) {
            return (hasCapability(32) || hasCapability(64)) ? com.google.android.gms.cast.internal.zzy.zza(1) : zzzVar;
        }
        return zzzVar;
    }

    @ShowFirstParty
    public final String zzc() {
        return this.f6157w;
    }
}
