package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpl;
import cz.msebera.android.httpclient.client.config.CookieSpecs;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzae extends zzim {

    /* renamed from: b, reason: collision with root package name */
    public Boolean f7638b;

    /* renamed from: c, reason: collision with root package name */
    public String f7639c;

    /* renamed from: d, reason: collision with root package name */
    public zzag f7640d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f7641e;

    public zzae(zzho zzhoVar) {
        super(zzhoVar);
        this.f7640d = new zzag() { // from class: com.google.android.gms.measurement.internal.zzah
            @Override // com.google.android.gms.measurement.internal.zzag
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    public static long zzh() {
        return zzbh.f7735e.zza(null).longValue();
    }

    public static long zzm() {
        return zzbh.E.zza(null).longValue();
    }

    public final int a(String str, boolean z10) {
        if (!zzpl.zza() || !zze().zzf(null, zzbh.T0)) {
            return 100;
        }
        if (z10) {
            return zza(str, zzbh.S, 100, 500);
        }
        return 500;
    }

    public final int b(String str, boolean z10) {
        return Math.max(a(str, z10), 256);
    }

    public final Boolean c(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle bundleD = d();
        if (bundleD == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleD.containsKey(str)) {
            return Boolean.valueOf(bundleD.getBoolean(str));
        }
        return null;
    }

    public final Bundle d() throws IllegalStateException {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    public final double zza(String str, zzfo<Double> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).doubleValue();
        }
        String strZza = this.f7640d.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).doubleValue();
        }
        try {
            return zzfoVar.zza(Double.valueOf(Double.parseDouble(strZza))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).doubleValue();
        }
    }

    public final int zzb(String str) {
        return zza(str, zzbh.J, 25, 100);
    }

    public final int zzc(String str) {
        return zzb(str, zzbh.f7757p);
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

    public final int zzg() {
        return zzq().zza(201500000, true) ? 100 : 25;
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

    public final String zzn() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzo() {
        return zza("debug.deferred.deeplink", "");
    }

    public final String zzp() {
        return this.f7639c;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final boolean zzu() {
        Boolean boolC = c("google_analytics_adid_collection_enabled");
        return boolC == null || boolC.booleanValue();
    }

    public final boolean zzv() {
        Boolean boolC = c("google_analytics_automatic_screen_reporting_enabled");
        return boolC == null || boolC.booleanValue();
    }

    public final boolean zzw() {
        Boolean boolC = c("firebase_analytics_collection_deactivated");
        return boolC != null && boolC.booleanValue();
    }

    public final boolean zzx() {
        if (this.f7638b == null) {
            Boolean boolC = c("app_measurement_lite");
            this.f7638b = boolC;
            if (boolC == null) {
                this.f7638b = Boolean.FALSE;
            }
        }
        return this.f7638b.booleanValue() || !this.f8189a.zzag();
    }

    public final boolean zzy() {
        if (this.f7641e == null) {
            synchronized (this) {
                if (this.f7641e == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f7641e = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.f7641e == null) {
                        this.f7641e = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f7641e.booleanValue();
    }

    public final int zzb(String str, zzfo<Integer> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).intValue();
        }
        String strZza = this.f7640d.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).intValue();
        }
        try {
            return zzfoVar.zza(Integer.valueOf(Integer.parseInt(strZza))).intValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).intValue();
        }
    }

    public final long zzc(String str, zzfo<Long> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).longValue();
        }
        String strZza = this.f7640d.zza(str, zzfoVar.zza());
        if (TextUtils.isEmpty(strZza)) {
            return zzfoVar.zza(null).longValue();
        }
        try {
            return zzfoVar.zza(Long.valueOf(Long.parseLong(strZza))).longValue();
        } catch (NumberFormatException unused) {
            return zzfoVar.zza(null).longValue();
        }
    }

    public final String zzd(String str, zzfo<String> zzfoVar) {
        return str == null ? zzfoVar.zza(null) : zzfoVar.zza(this.f7640d.zza(str, zzfoVar.zza()));
    }

    public final zzip zze(String str) {
        Object obj;
        Preconditions.checkNotEmpty(str);
        Bundle bundleD = d();
        if (bundleD == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleD.get(str);
        }
        zzip zzipVar = zzip.UNINITIALIZED;
        if (obj == null) {
            return zzipVar;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzip.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzip.DENIED;
        }
        if (CookieSpecs.DEFAULT.equals(obj)) {
            return zzip.DEFAULT;
        }
        zzj().zzu().zza("Invalid manifest metadata for", str);
        return zzipVar;
    }

    public final boolean zzf(String str, zzfo<Boolean> zzfoVar) {
        if (str == null) {
            return zzfoVar.zza(null).booleanValue();
        }
        String strZza = this.f7640d.zza(str, zzfoVar.zza());
        return TextUtils.isEmpty(strZza) ? zzfoVar.zza(null).booleanValue() : zzfoVar.zza(Boolean.valueOf("1".equals(strZza))).booleanValue();
    }

    public final void zzi(String str) {
        this.f7639c = str;
    }

    public final boolean zzk(String str) {
        return "1".equals(this.f7640d.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzl(String str) {
        return "1".equals(this.f7640d.zza(str, "measurement.event_sampling_enabled"));
    }

    public final int zza(String str, zzfo<Integer> zzfoVar, int i10, int i11) {
        return Math.max(Math.min(zzb(str, zzfoVar), i11), i10);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final boolean zze(String str, zzfo<Boolean> zzfoVar) {
        return zzf(str, zzfoVar);
    }

    public final String zza(String str, String str2) throws IllegalStateException {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            zzj().zzg().zza("Could not find SystemProperties class", e10);
            return "";
        } catch (IllegalAccessException e11) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e11);
            return "";
        } catch (NoSuchMethodException e12) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e12);
            return "";
        } catch (InvocationTargetException e13) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e13);
            return "";
        }
    }

    public final boolean zza(zzfo<Boolean> zzfoVar) {
        return zzf(null, zzfoVar);
    }
}
