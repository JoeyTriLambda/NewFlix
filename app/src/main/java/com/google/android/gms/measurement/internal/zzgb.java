package com.google.android.gms.measurement.internal;

import ac.c;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzoz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgb extends zzil {

    /* renamed from: c, reason: collision with root package name */
    public char f7955c;

    /* renamed from: d, reason: collision with root package name */
    public long f7956d;

    /* renamed from: e, reason: collision with root package name */
    public String f7957e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgd f7958f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgd f7959g;

    /* renamed from: h, reason: collision with root package name */
    public final zzgd f7960h;

    /* renamed from: i, reason: collision with root package name */
    public final zzgd f7961i;

    /* renamed from: j, reason: collision with root package name */
    public final zzgd f7962j;

    /* renamed from: k, reason: collision with root package name */
    public final zzgd f7963k;

    /* renamed from: l, reason: collision with root package name */
    public final zzgd f7964l;

    /* renamed from: m, reason: collision with root package name */
    public final zzgd f7965m;

    /* renamed from: n, reason: collision with root package name */
    public final zzgd f7966n;

    public zzgb(zzho zzhoVar) {
        super(zzhoVar);
        this.f7955c = (char) 0;
        this.f7956d = -1L;
        this.f7958f = new zzgd(this, 6, false, false);
        this.f7959g = new zzgd(this, 6, true, false);
        this.f7960h = new zzgd(this, 6, false, true);
        this.f7961i = new zzgd(this, 5, false, false);
        this.f7962j = new zzgd(this, 5, true, false);
        this.f7963k = new zzgd(this, 5, false, true);
        this.f7964l = new zzgd(this, 4, false, false);
        this.f7965m = new zzgd(this, 3, false, false);
        this.f7966n = new zzgd(this, 2, false, false);
    }

    public static String a(Object obj, boolean z10) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i10 = 0;
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l10.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (!(obj instanceof Throwable)) {
            return obj instanceof zzgc ? ((zzgc) obj).f7967a : z10 ? "-" : String.valueOf(obj);
        }
        Throwable th2 = (Throwable) obj;
        StringBuilder sb2 = new StringBuilder(z10 ? th2.getClass().getName() : th2.toString());
        String strC = c(zzho.class.getCanonicalName());
        StackTraceElement[] stackTrace = th2.getStackTrace();
        int length = stackTrace.length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i10];
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && c(className).equals(strC)) {
                sb2.append(": ");
                sb2.append(stackTraceElement);
                break;
            }
            i10++;
        }
        return sb2.toString();
    }

    public static String b(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strA = a(obj, z10);
        String strA2 = a(obj2, z10);
        String strA3 = a(obj3, z10);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strA)) {
            sb2.append(str2);
            sb2.append(strA);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strA2)) {
            str3 = str2;
        } else {
            sb2.append(str2);
            sb2.append(strA2);
        }
        if (!TextUtils.isEmpty(strA3)) {
            sb2.append(str3);
            sb2.append(strA3);
        }
        return sb2.toString();
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? (zzoz.zza() && zzbh.A0.zza(null).booleanValue()) ? "" : str : str.substring(0, iLastIndexOf);
    }

    public final String d() {
        String str;
        synchronized (this) {
            if (this.f7957e == null) {
                this.f7957e = this.f8189a.zzw() != null ? this.f8189a.zzw() : "FA";
            }
            Preconditions.checkNotNull(this.f7957e);
            str = this.f7957e;
        }
        return str;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final zzgd zzc() {
        return this.f7965m;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final zzgd zzg() {
        return this.f7958f;
    }

    public final zzgd zzh() {
        return this.f7960h;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    public final zzgd zzm() {
        return this.f7959g;
    }

    public final zzgd zzn() {
        return this.f7964l;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    public final boolean zzo() {
        return false;
    }

    public final zzgd zzp() {
        return this.f7966n;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final zzgd zzu() {
        return this.f7961i;
    }

    public final zzgd zzv() {
        return this.f7963k;
    }

    public final zzgd zzw() {
        return this.f7962j;
    }

    public final String zzx() {
        Pair<String, Long> pairZza;
        if (zzk().f7995f == null || (pairZza = zzk().f7995f.zza()) == null || pairZza == zzgm.A) {
            return null;
        }
        return c.C(String.valueOf(pairZza.second), ":", (String) pairZza.first);
    }

    public static Object zza(String str) {
        if (str == null) {
            return null;
        }
        return new zzgc(str);
    }

    public final void zza(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) throws IllegalStateException {
        if (!z10 && zza(i10)) {
            zza(i10, b(false, str, obj, obj2, obj3));
        }
        if (z11 || i10 < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzhh zzhhVar = this.f8189a.f8104j;
        if (zzhhVar == null) {
            zza(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzhhVar.f8188b) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i10 < 0) {
                i10 = 0;
            }
            zzhhVar.zzb(new zzga(this, i10 >= 9 ? 8 : i10, str, obj, obj2, obj3));
        }
    }

    public final void zza(int i10, String str) {
        Log.println(i10, d(), str);
    }

    public final boolean zza(int i10) {
        return Log.isLoggable(d(), i10);
    }
}
