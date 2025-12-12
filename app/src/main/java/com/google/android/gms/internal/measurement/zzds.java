package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
public class zzds {
    private static volatile zzds zzb;
    protected final Clock zza;
    private final String zzc;
    private final ExecutorService zzd;
    private final AppMeasurementSdk zze;
    private final List<Pair<com.google.android.gms.measurement.internal.zzix, zzd>> zzf;
    private int zzg;
    private boolean zzh;
    private String zzi;
    private volatile zzdd zzj;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    public static class zza extends zzdm {
        private final com.google.android.gms.measurement.internal.zziu zza;

        public zza(com.google.android.gms.measurement.internal.zziu zziuVar) {
            this.zza = zziuVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdj
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzdj
        public final void zza(String str, String str2, Bundle bundle, long j10) {
            this.zza.interceptEvent(str, str2, bundle, j10);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    public abstract class zzb implements Runnable {
        final long zza;
        final long zzb;
        private final boolean zzc;

        public zzb(zzds zzdsVar) {
            this(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (zzds.this.zzh) {
                zzb();
                return;
            }
            try {
                zza();
            } catch (Exception e10) {
                zzds.this.zza(e10, false, this.zzc);
                zzb();
            }
        }

        public abstract void zza() throws RemoteException;

        public zzb(boolean z10) {
            this.zza = zzds.this.zza.currentTimeMillis();
            this.zzb = zzds.this.zza.elapsedRealtime();
            this.zzc = z10;
        }

        public void zzb() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    public class zzc implements Application.ActivityLifecycleCallbacks {
        public zzc() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            zzds.this.zza(new zzfa(this, bundle, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            zzds.this.zza(new zzff(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            zzds.this.zza(new zzfb(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            zzds.this.zza(new zzfc(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            zzde zzdeVar = new zzde();
            zzds.this.zza(new zzfd(this, activity, zzdeVar));
            Bundle bundleZza = zzdeVar.zza(50L);
            if (bundleZza != null) {
                bundle.putAll(bundleZza);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            zzds.this.zza(new zzez(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            zzds.this.zza(new zzfe(this, activity));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
    public static class zzd extends zzdm {
        private final com.google.android.gms.measurement.internal.zzix zza;

        public zzd(com.google.android.gms.measurement.internal.zzix zzixVar) {
            this.zza = zzixVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzdj
        public final int zza() {
            return System.identityHashCode(this.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzdj
        public final void zza(String str, String str2, Bundle bundle, long j10) {
            this.zza.onEvent(str, str2, bundle, j10);
        }
    }

    private zzds(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !zzc(str2, str3)) {
            this.zzc = "FA";
        } else {
            this.zzc = str;
        }
        this.zza = DefaultClock.getInstance();
        this.zzd = zzcu.zza().zza(new zzee(this), zzcz.zza);
        this.zze = new AppMeasurementSdk(this);
        this.zzf = new ArrayList();
        if (!(!zzb(context) || zzk())) {
            this.zzi = null;
            this.zzh = true;
            Log.w(this.zzc, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (zzc(str2, str3)) {
            this.zzi = str2;
        } else {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzc, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzc, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        }
        zza(new zzdr(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzc, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzc());
        }
    }

    private final boolean zzk() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final String zzd() {
        return this.zzi;
    }

    public final String zze() {
        zzde zzdeVar = new zzde();
        zza(new zzes(this, zzdeVar));
        return zzdeVar.zzc(120000L);
    }

    public final String zzf() {
        zzde zzdeVar = new zzde();
        zza(new zzeh(this, zzdeVar));
        return zzdeVar.zzc(50L);
    }

    public final String zzg() {
        zzde zzdeVar = new zzde();
        zza(new zzem(this, zzdeVar));
        return zzdeVar.zzc(500L);
    }

    public final String zzh() {
        zzde zzdeVar = new zzde();
        zza(new zzej(this, zzdeVar));
        return zzdeVar.zzc(500L);
    }

    public final String zzi() {
        zzde zzdeVar = new zzde();
        zza(new zzei(this, zzdeVar));
        return zzdeVar.zzc(500L);
    }

    public final void zzj() {
        zza(new zzeb(this));
    }

    public final AppMeasurementSdk zzb() {
        return this.zze;
    }

    public final Long zzc() {
        zzde zzdeVar = new zzde();
        zza(new zzer(this, zzdeVar));
        return zzdeVar.zzb(120000L);
    }

    public final void zzd(Bundle bundle) {
        zza(new zzew(this, bundle));
    }

    public final void zzb(String str) {
        zza(new zzeg(this, str));
    }

    public final void zzd(String str) {
        zza(new zzdy(this, str));
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, null);
    }

    public final void zzb(Bundle bundle) {
        zza(new zzdz(this, bundle));
    }

    public final void zzc(String str) {
        zza(new zzef(this, str));
    }

    public final int zza(String str) {
        zzde zzdeVar = new zzde();
        zza(new zzep(this, str, zzdeVar));
        Integer num = (Integer) zzde.zza(zzdeVar.zza(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final void zzb(String str, String str2) {
        zza((String) null, str, (Object) str2, false);
    }

    public final void zzc(Bundle bundle) {
        zza(new zzec(this, bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str, String str2) {
        return (str2 == null || str == null || zzk()) ? false : true;
    }

    public final void zzb(com.google.android.gms.measurement.internal.zzix zzixVar) {
        Pair<com.google.android.gms.measurement.internal.zzix, zzd> pair;
        Preconditions.checkNotNull(zzixVar);
        synchronized (this.zzf) {
            int i10 = 0;
            while (true) {
                if (i10 >= this.zzf.size()) {
                    pair = null;
                    break;
                } else {
                    if (zzixVar.equals(this.zzf.get(i10).first)) {
                        pair = this.zzf.get(i10);
                        break;
                    }
                    i10++;
                }
            }
            if (pair == null) {
                Log.w(this.zzc, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzd zzdVar = (zzd) pair.second;
            if (this.zzj != null) {
                try {
                    this.zzj.unregisterOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzey(this, zzdVar));
        }
    }

    public final long zza() {
        zzde zzdeVar = new zzde();
        zza(new zzek(this, zzdeVar));
        Long lZzb = zzdeVar.zzb(500L);
        if (lZzb == null) {
            long jNextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i10 = this.zzg + 1;
            this.zzg = i10;
            return jNextLong + i10;
        }
        return lZzb.longValue();
    }

    public final Bundle zza(Bundle bundle, boolean z10) {
        zzde zzdeVar = new zzde();
        zza(new zzeq(this, bundle, zzdeVar));
        if (z10) {
            return zzdeVar.zza(5000L);
        }
        return null;
    }

    public final zzdd zza(Context context, boolean z10) {
        try {
            return zzdg.asInterface(DynamiteModule.load(context, DynamiteModule.f7568c, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e10) {
            zza((Exception) e10, true, false);
            return null;
        }
    }

    private static boolean zzb(Context context) {
        return new com.google.android.gms.measurement.internal.zzhi(context, com.google.android.gms.measurement.internal.zzhi.zza(context)).zza("google_app_id") != null;
    }

    public static zzds zza(Context context) {
        return zza(context, (String) null, (String) null, (String) null, (Bundle) null);
    }

    public static zzds zza(Context context, String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotNull(context);
        if (zzb == null) {
            synchronized (zzds.class) {
                if (zzb == null) {
                    zzb = new zzds(context, str, str2, str3, bundle);
                }
            }
        }
        return zzb;
    }

    public final Object zza(int i10) {
        zzde zzdeVar = new zzde();
        zza(new zzeu(this, zzdeVar, i10));
        return zzde.zza(zzdeVar.zza(15000L), Object.class);
    }

    public final List<Bundle> zza(String str, String str2) {
        zzde zzdeVar = new zzde();
        zza(new zzdv(this, str, str2, zzdeVar));
        List<Bundle> list = (List) zzde.zza(zzdeVar.zza(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z10) {
        zzde zzdeVar = new zzde();
        zza(new zzel(this, str, str2, z10, zzdeVar));
        Bundle bundleZza = zzdeVar.zza(5000L);
        if (bundleZza != null && bundleZza.size() != 0) {
            HashMap map = new HashMap(bundleZza.size());
            for (String str3 : bundleZza.keySet()) {
                Object obj = bundleZza.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    map.put(str3, obj);
                }
            }
            return map;
        }
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Exception exc, boolean z10, boolean z11) {
        this.zzh |= z10;
        if (z10) {
            Log.w(this.zzc, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z11) {
            zza(5, "Error with data collection. Data lost.", exc, (Object) null, (Object) null);
        }
        Log.w(this.zzc, "Error with data collection. Data lost.", exc);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(new zzdw(this, str, str2, bundle));
    }

    public final void zza(String str, Bundle bundle) {
        zza(null, str, bundle, false, true, null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j10) {
        zza(str, str2, bundle, true, false, Long.valueOf(j10));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z10, boolean z11, Long l10) {
        zza(new zzex(this, l10, str, str2, bundle, z10, z11));
    }

    public final void zza(int i10, String str, Object obj, Object obj2, Object obj3) {
        zza(new zzeo(this, false, 5, str, obj, null, null));
    }

    public final void zza(com.google.android.gms.measurement.internal.zzix zzixVar) {
        Preconditions.checkNotNull(zzixVar);
        synchronized (this.zzf) {
            for (int i10 = 0; i10 < this.zzf.size(); i10++) {
                if (zzixVar.equals(this.zzf.get(i10).first)) {
                    Log.w(this.zzc, "OnEventListener already registered.");
                    return;
                }
            }
            zzd zzdVar = new zzd(zzixVar);
            this.zzf.add(new Pair<>(zzixVar, zzdVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzdVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzc, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zza(new zzev(this, zzdVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzd.execute(zzbVar);
    }

    public final void zza(Bundle bundle) {
        zza(new zzdt(this, bundle));
    }

    public final void zza(Activity activity, String str, String str2) {
        zza(new zzdx(this, activity, str, str2));
    }

    public final void zza(boolean z10) {
        zza(new zzet(this, z10));
    }

    public final void zza(com.google.android.gms.measurement.internal.zziu zziuVar) {
        zza zzaVar = new zza(zziuVar);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzaVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzc, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zza(new zzen(this, zzaVar));
    }

    public final void zza(Boolean bool) {
        zza(new zzea(this, bool));
    }

    public final void zza(long j10) {
        zza(new zzed(this, j10));
    }

    public final void zza(String str, String str2, Object obj, boolean z10) {
        zza(new zzdu(this, str, str2, obj, z10));
    }
}
