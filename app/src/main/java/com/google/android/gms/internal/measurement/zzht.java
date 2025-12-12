package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import b0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzht implements zzgy {
    private static final Map<String, zzht> zza = new b();
    private final SharedPreferences zzb;
    private final Runnable zzc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzd;
    private final Object zze;
    private volatile Map<String, ?> zzf;
    private final List<zzgw> zzg;

    private zzht(SharedPreferences sharedPreferences, Runnable runnable) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.measurement.zzhs
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.zza.zza(sharedPreferences2, str);
            }
        };
        this.zzd = onSharedPreferenceChangeListener;
        this.zze = new Object();
        this.zzg = new ArrayList();
        this.zzb = sharedPreferences;
        this.zzc = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    private static SharedPreferences zza(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return context.getSharedPreferences(str, 0);
            }
            if (zzgp.zza()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return context.getSharedPreferences(str.substring(12), 0);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static zzht zza(Context context, String str, Runnable runnable) {
        zzht zzhtVar;
        if (!((!zzgp.zza() || str.startsWith("direct_boot:")) ? true : zzgp.zzb(context))) {
            return null;
        }
        synchronized (zzht.class) {
            Map<String, zzht> map = zza;
            zzhtVar = map.get(str);
            if (zzhtVar == null) {
                zzhtVar = new zzht(zza(context, str), runnable);
                map.put(str, zzhtVar);
            }
        }
        return zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgy
    public final Object zza(String str) {
        Map<String, ?> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zzf = all;
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        map = all;
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th2;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public static synchronized void zza() {
        for (zzht zzhtVar : zza.values()) {
            zzhtVar.zzb.unregisterOnSharedPreferenceChangeListener(zzhtVar.zzd);
        }
        zza.clear();
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zze) {
            this.zzf = null;
            this.zzc.run();
        }
        synchronized (this) {
            Iterator<zzgw> it = this.zzg.iterator();
            while (it.hasNext()) {
                it.next().zza();
            }
        }
    }
}
