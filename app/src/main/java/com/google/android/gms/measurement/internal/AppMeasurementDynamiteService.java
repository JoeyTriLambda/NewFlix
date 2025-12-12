package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import b0.b;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzqv;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
@DynamiteApi
/* loaded from: classes.dex */
public class AppMeasurementDynamiteService extends com.google.android.gms.internal.measurement.zzdg {

    /* renamed from: a, reason: collision with root package name */
    public zzho f7610a = null;

    /* renamed from: b, reason: collision with root package name */
    public final b f7611b = new b();

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
    public class zza implements zziu {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.gms.internal.measurement.zzdj f7612a;

        public zza(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.f7612a = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zziu
        public final void interceptEvent(String str, String str2, Bundle bundle, long j10) throws IllegalStateException {
            try {
                this.f7612a.zza(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.f7610a;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event interceptor threw exception", e10);
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.6.1 */
    public class zzb implements zzix {

        /* renamed from: a, reason: collision with root package name */
        public final com.google.android.gms.internal.measurement.zzdj f7614a;

        public zzb(com.google.android.gms.internal.measurement.zzdj zzdjVar) {
            this.f7614a = zzdjVar;
        }

        @Override // com.google.android.gms.measurement.internal.zzix
        public final void onEvent(String str, String str2, Bundle bundle, long j10) throws IllegalStateException {
            try {
                this.f7614a.zza(str, str2, bundle, j10);
            } catch (RemoteException e10) {
                zzho zzhoVar = AppMeasurementDynamiteService.this.f7610a;
                if (zzhoVar != null) {
                    zzhoVar.zzj().zzu().zza("Event listener threw exception", e10);
                }
            }
        }
    }

    public final void b() {
        if (this.f7610a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void beginAdUnitExposure(String str, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zze().zza(str, j10);
    }

    public final void c(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) throws IllegalStateException {
        b();
        this.f7610a.zzt().zza(zzdiVar, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp().zza(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void clearMeasurementEnabled(long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp().zza((Boolean) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void endAdUnitExposure(String str, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zze().zzb(str, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void generateEventId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        long jZzm = this.f7610a.zzt().zzm();
        b();
        this.f7610a.zzt().zza(zzdiVar, jZzm);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzl().zzb(new zzh(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCachedAppInstanceId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        c(zzdiVar, this.f7610a.zzp().zzae());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getConditionalUserProperties(String str, String str2, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzl().zzb(new zzk(this, zzdiVar, str, str2));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenClass(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        c(zzdiVar, this.f7610a.zzp().zzaf());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getCurrentScreenName(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        c(zzdiVar, this.f7610a.zzp().zzag());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getGmpAppId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        c(zzdiVar, this.f7610a.zzp().zzah());
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getMaxUserProperties(String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp();
        Preconditions.checkNotEmpty(str);
        b();
        this.f7610a.zzt().zza(zzdiVar, 25);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getSessionId(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        zziy zziyVarZzp = this.f7610a.zzp();
        zziyVarZzp.zzl().zzb(new zzka(zziyVarZzp, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getTestFlag(com.google.android.gms.internal.measurement.zzdi zzdiVar, int i10) throws IllegalStateException, RemoteException {
        b();
        if (i10 == 0) {
            this.f7610a.zzt().zza(zzdiVar, this.f7610a.zzp().zzai());
            return;
        }
        if (i10 == 1) {
            this.f7610a.zzt().zza(zzdiVar, this.f7610a.zzp().zzad().longValue());
            return;
        }
        if (i10 != 2) {
            if (i10 == 3) {
                this.f7610a.zzt().zza(zzdiVar, this.f7610a.zzp().zzac().intValue());
                return;
            } else {
                if (i10 != 4) {
                    return;
                }
                this.f7610a.zzt().zza(zzdiVar, this.f7610a.zzp().zzaa().booleanValue());
                return;
            }
        }
        zznt zzntVarZzt = this.f7610a.zzt();
        double dDoubleValue = this.f7610a.zzp().zzab().doubleValue();
        Bundle bundle = new Bundle();
        bundle.putDouble("r", dDoubleValue);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            zzntVarZzt.f8189a.zzj().zzu().zza("Error returning double value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void getUserProperties(String str, String str2, boolean z10, com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzl().zzb(new zzi(this, zzdiVar, str, str2, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initForTests(Map map) throws RemoteException {
        b();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void initialize(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdq zzdqVar, long j10) throws IllegalStateException, RemoteException {
        zzho zzhoVar = this.f7610a;
        if (zzhoVar == null) {
            this.f7610a = zzho.zza((Context) Preconditions.checkNotNull((Context) ObjectWrapper.unwrap(iObjectWrapper)), zzdqVar, Long.valueOf(j10));
        } else {
            zzhoVar.zzj().zzu().zza("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void isDataCollectionEnabled(com.google.android.gms.internal.measurement.zzdi zzdiVar) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzl().zzb(new zzm(this, zzdiVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp().zza(str, str2, bundle, z10, z11, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logEventAndBundle(String str, String str2, Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws IllegalStateException, RemoteException {
        b();
        Preconditions.checkNotEmpty(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f7610a.zzl().zzb(new zzj(this, zzdiVar, new zzbf(str2, new zzba(bundle), "app", j10), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void logHealthData(int i10, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzj().zza(i10, true, false, str, iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper), iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2), iObjectWrapper3 != null ? ObjectWrapper.unwrap(iObjectWrapper3) : null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws IllegalStateException, RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        Bundle bundle = new Bundle();
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.f7610a.zzj().zzu().zza("Error returning bundle value to wrapper", e10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j10) throws RemoteException {
        b();
        zzkl zzklVar = this.f7610a.zzp().f8228c;
        if (zzklVar != null) {
            this.f7610a.zzp().zzak();
            zzklVar.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void performAction(Bundle bundle, com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) throws RemoteException {
        b();
        zzdiVar.zza(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void registerOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws IllegalStateException, RemoteException {
        zzix zzbVar;
        b();
        synchronized (this.f7611b) {
            zzbVar = (zzix) this.f7611b.get(Integer.valueOf(zzdjVar.zza()));
            if (zzbVar == null) {
                zzbVar = new zzb(zzdjVar);
                this.f7611b.put(Integer.valueOf(zzdjVar.zza()), zzbVar);
            }
        }
        this.f7610a.zzp().zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void resetAnalyticsData(long j10) throws IllegalStateException, RemoteException {
        b();
        zziy zziyVarZzp = this.f7610a.zzp();
        zziyVarZzp.h(null);
        zziyVarZzp.zzl().zzb(new zzjx(zziyVarZzp, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConditionalUserProperty(Bundle bundle, long j10) throws IllegalStateException, RemoteException {
        b();
        if (bundle == null) {
            this.f7610a.zzj().zzg().zza("Conditional user property must not be null");
        } else {
            this.f7610a.zzp().zza(bundle, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsent(final Bundle bundle, final long j10) throws IllegalStateException, RemoteException {
        b();
        final zziy zziyVarZzp = this.f7610a.zzp();
        zziyVarZzp.zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzje
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zziy zziyVar = zziyVarZzp;
                if (TextUtils.isEmpty(zziyVar.zzg().zzae())) {
                    zziyVar.b(bundle, 0, j10);
                } else {
                    zziyVar.zzj().zzv().zza("Using developer consent only; google app id found");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setConsentThirdParty(Bundle bundle, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp().b(bundle, -20, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzq().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDataCollectionEnabled(boolean z10) throws IllegalStateException, RemoteException {
        b();
        zziy zziyVarZzp = this.f7610a.zzp();
        zziyVarZzp.zzu();
        zziyVarZzp.zzl().zzb(new zzjm(zziyVarZzp, z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setDefaultEventParameters(Bundle bundle) throws IllegalStateException {
        b();
        final zziy zziyVarZzp = this.f7610a.zzp();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        zziyVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjf
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzkd zzkdVar;
                boolean z10;
                zziy zziyVar = zziyVarZzp;
                Bundle bundle3 = bundle2;
                if (bundle3 == null) {
                    zziyVar.zzk().f8015z.zza(new Bundle());
                    return;
                }
                Bundle bundleZza = zziyVar.zzk().f8015z.zza();
                Iterator<String> it = bundle3.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    zzkdVar = zziyVar.f8244s;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    Object obj = bundle3.get(next);
                    if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                        zziyVar.zzq();
                        if (zznt.s(obj)) {
                            zziyVar.zzq();
                            zznt.zza(zzkdVar, 27, (String) null, (String) null, 0);
                        }
                        zziyVar.zzj().zzv().zza("Invalid default event parameter type. Name, value", next, obj);
                    } else if (zznt.N(next)) {
                        zziyVar.zzj().zzv().zza("Invalid default event parameter name. Name", next);
                    } else if (obj == null) {
                        bundleZza.remove(next);
                    } else if (zziyVar.zzq().v("param", next, zziyVar.zze().a(null, false), obj)) {
                        zziyVar.zzq().k(bundleZza, next, obj);
                    }
                }
                zziyVar.zzq();
                int iZzg = zziyVar.zze().zzg();
                if (bundleZza.size() > iZzg) {
                    Iterator it2 = new TreeSet(bundleZza.keySet()).iterator();
                    int i10 = 0;
                    while (true) {
                        z10 = true;
                        if (!it2.hasNext()) {
                            break;
                        }
                        String str = (String) it2.next();
                        i10++;
                        if (i10 > iZzg) {
                            bundleZza.remove(str);
                        }
                    }
                } else {
                    z10 = false;
                }
                if (z10) {
                    zziyVar.zzq();
                    zznt.zza(zzkdVar, 26, (String) null, (String) null, 0);
                    zziyVar.zzj().zzv().zza("Too many default event parameters set. Discarding beyond event parameter limit");
                }
                zziyVar.zzk().f8015z.zza(bundleZza);
                zziyVar.zzo().zza(bundleZza);
            }
        });
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setEventInterceptor(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws IllegalStateException, RemoteException {
        b();
        zza zzaVar = new zza(zzdjVar);
        if (this.f7610a.zzl().zzg()) {
            this.f7610a.zzp().zza(zzaVar);
        } else {
            this.f7610a.zzl().zzb(new zzl(this, zzaVar));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setInstanceIdProvider(com.google.android.gms.internal.measurement.zzdo zzdoVar) throws RemoteException {
        b();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMeasurementEnabled(boolean z10, long j10) throws IllegalStateException, RemoteException {
        b();
        this.f7610a.zzp().zza(Boolean.valueOf(z10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setMinimumSessionDuration(long j10) throws RemoteException {
        b();
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSessionTimeoutDuration(long j10) throws IllegalStateException, RemoteException {
        b();
        zziy zziyVarZzp = this.f7610a.zzp();
        zziyVarZzp.zzl().zzb(new zzjo(zziyVarZzp, j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setSgtmDebugInfo(Intent intent) throws IllegalStateException, RemoteException {
        b();
        zziy zziyVarZzp = this.f7610a.zzp();
        if (zzqv.zza() && zziyVarZzp.zze().zzf(null, zzbh.f7768u0)) {
            Uri data = intent.getData();
            if (data == null) {
                zziyVarZzp.zzj().zzn().zza("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                zziyVarZzp.zzj().zzn().zza("Preview Mode was not enabled.");
                zziyVarZzp.zze().zzi(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zziyVarZzp.zzj().zzn().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zziyVarZzp.zze().zzi(queryParameter2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserId(final String str, long j10) throws IllegalStateException, RemoteException {
        b();
        final zziy zziyVarZzp = this.f7610a.zzp();
        if (str != null && TextUtils.isEmpty(str)) {
            zziyVarZzp.f8189a.zzj().zzu().zza("User ID must be non-empty or null");
        } else {
            zziyVarZzp.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjj
                @Override // java.lang.Runnable
                public final void run() {
                    zziy zziyVar = zziyVarZzp;
                    zzfv zzfvVarZzg = zziyVar.zzg();
                    String str2 = zzfvVarZzg.f7942p;
                    String str3 = str;
                    boolean z10 = (str2 == null || str2.equals(str3)) ? false : true;
                    zzfvVarZzg.f7942p = str3;
                    if (z10) {
                        zziyVar.zzg().zzag();
                    }
                }
            });
            zziyVarZzp.zza(null, "_id", str, true, j10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z10, long j10) throws IllegalStateException, SecurityException, RemoteException {
        b();
        this.f7610a.zzp().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzdd
    public void unregisterOnMeasurementEventListener(com.google.android.gms.internal.measurement.zzdj zzdjVar) throws IllegalStateException, RemoteException {
        zzix zzbVar;
        b();
        synchronized (this.f7611b) {
            zzbVar = (zzix) this.f7611b.remove(Integer.valueOf(zzdjVar.zza()));
        }
        if (zzbVar == null) {
            zzbVar = new zzb(zzdjVar);
        }
        this.f7610a.zzp().zzb(zzbVar);
    }
}
