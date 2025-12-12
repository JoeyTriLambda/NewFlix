package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zziq;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzax {

    /* renamed from: f, reason: collision with root package name */
    public static final zzax f7687f = new zzax((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a, reason: collision with root package name */
    public final int f7688a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7689b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f7690c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7691d;

    /* renamed from: e, reason: collision with root package name */
    public final EnumMap<zziq.zza, zzip> f7692e;

    public zzax() {
        throw null;
    }

    public zzax(Boolean bool, int i10, Boolean bool2, String str) {
        EnumMap<zziq.zza, zzip> enumMap = new EnumMap<>(zziq.zza.class);
        this.f7692e = enumMap;
        enumMap.put((EnumMap<zziq.zza, zzip>) zziq.zza.AD_USER_DATA, (zziq.zza) zziq.c(bool));
        this.f7688a = i10;
        this.f7689b = a();
        this.f7690c = bool2;
        this.f7691d = str;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f7688a);
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            sb2.append(":");
            sb2.append(zziq.a(this.f7692e.get(zzaVar)));
        }
        return sb2.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzax)) {
            return false;
        }
        zzax zzaxVar = (zzax) obj;
        if (this.f7689b.equalsIgnoreCase(zzaxVar.f7689b) && Objects.equals(this.f7690c, zzaxVar.f7690c)) {
            return Objects.equals(this.f7691d, zzaxVar.f7691d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f7690c;
        int i10 = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.f7691d;
        return ((str == null ? 17 : str.hashCode()) * 137) + (i10 * 29) + this.f7689b.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("source=");
        sb2.append(zziq.e(this.f7688a));
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            sb2.append(",");
            sb2.append(zzaVar.f8203b);
            sb2.append("=");
            zzip zzipVar = this.f7692e.get(zzaVar);
            if (zzipVar == null) {
                sb2.append("uninitialized");
            } else {
                int i10 = zzaw.f7686a[zzipVar.ordinal()];
                if (i10 == 1) {
                    sb2.append("uninitialized");
                } else if (i10 == 2) {
                    sb2.append(CookieSpecs.DEFAULT);
                } else if (i10 == 3) {
                    sb2.append("denied");
                } else if (i10 == 4) {
                    sb2.append("granted");
                }
            }
        }
        Boolean bool = this.f7690c;
        if (bool != null) {
            sb2.append(",isDmaRegion=");
            sb2.append(bool);
        }
        String str = this.f7691d;
        if (str != null) {
            sb2.append(",cpsDisplayStr=");
            sb2.append(str);
        }
        return sb2.toString();
    }

    public final int zza() {
        return this.f7688a;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        Iterator it = this.f7692e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int iOrdinal = ((zzip) entry.getValue()).ordinal();
            String str = iOrdinal != 2 ? iOrdinal != 3 ? null : "granted" : "denied";
            if (str != null) {
                bundle.putString(((zziq.zza) entry.getKey()).f8203b, str);
            }
        }
        Boolean bool = this.f7690c;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str2 = this.f7691d;
        if (str2 != null) {
            bundle.putString("cps_display_str", str2);
        }
        return bundle;
    }

    public final zzip zzc() {
        zzip zzipVar = this.f7692e.get(zziq.zza.AD_USER_DATA);
        return zzipVar == null ? zzip.UNINITIALIZED : zzipVar;
    }

    public final Boolean zzd() {
        return this.f7690c;
    }

    public final String zze() {
        return this.f7691d;
    }

    public final String zzf() {
        return this.f7689b;
    }

    public final boolean zzg() {
        Iterator<zzip> it = this.f7692e.values().iterator();
        while (it.hasNext()) {
            if (it.next() != zzip.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public static zzax zza(Bundle bundle, int i10) {
        if (bundle == null) {
            return new zzax((Boolean) null, i10, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zziq.zza.class);
        for (zziq.zza zzaVar : zzir.DMA.zza()) {
            enumMap.put((EnumMap) zzaVar, (zziq.zza) zziq.d(bundle.getString(zzaVar.f8203b)));
        }
        return new zzax((EnumMap<zziq.zza, zzip>) enumMap, i10, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public zzax(EnumMap<zziq.zza, zzip> enumMap, int i10, Boolean bool, String str) {
        EnumMap<zziq.zza, zzip> enumMap2 = new EnumMap<>(zziq.zza.class);
        this.f7692e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f7688a = i10;
        this.f7689b = a();
        this.f7690c = bool;
        this.f7691d = str;
    }

    public static zzax zza(String str) throws NumberFormatException {
        if (str != null && str.length() > 0) {
            String[] strArrSplit = str.split(":");
            int i10 = Integer.parseInt(strArrSplit[0]);
            EnumMap enumMap = new EnumMap(zziq.zza.class);
            zziq.zza[] zzaVarArrZza = zzir.DMA.zza();
            int length = zzaVarArrZza.length;
            int i11 = 1;
            int i12 = 0;
            while (i12 < length) {
                enumMap.put((EnumMap) zzaVarArrZza[i12], (zziq.zza) zziq.b(strArrSplit[i11].charAt(0)));
                i12++;
                i11++;
            }
            return new zzax((EnumMap<zziq.zza, zzip>) enumMap, i10, (Boolean) null, (String) null);
        }
        return f7687f;
    }

    public static Boolean zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i10 = zzaw.f7686a[zziq.d(bundle.getString("ad_personalization")).ordinal()];
        if (i10 == 3) {
            return Boolean.FALSE;
        }
        if (i10 != 4) {
            return null;
        }
        return Boolean.TRUE;
    }
}
