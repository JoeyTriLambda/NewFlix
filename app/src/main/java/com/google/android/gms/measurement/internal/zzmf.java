package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzmj;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmf<T extends Context & zzmj> {

    /* renamed from: a, reason: collision with root package name */
    public final T f8485a;

    public zzmf(T t10) {
        Preconditions.checkNotNull(t10);
        this.f8485a = t10;
    }

    public final zzgb a() {
        return zzho.zza(this.f8485a, null, null).zzj();
    }

    public final int zza(final Intent intent, int i10, final int i11) throws IllegalStateException {
        T t10 = this.f8485a;
        final zzgb zzgbVarZzj = zzho.zza(t10, null, null).zzj();
        if (intent == null) {
            zzgbVarZzj.zzu().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzgbVarZzj.zzp().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmh
                @Override // java.lang.Runnable
                public final void run() throws IllegalStateException {
                    zzmf zzmfVar = this.f8488b;
                    zzmj zzmjVar = zzmfVar.f8485a;
                    int i12 = i11;
                    if (zzmjVar.zza(i12)) {
                        zzgbVarZzj.zzp().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i12));
                        zzmfVar.a().zzp().zza("Completed wakeful intent.");
                        zzmjVar.zza(intent);
                    }
                }
            };
            zznd zzndVarZza = zznd.zza(t10);
            zzndVarZza.zzl().zzb(new zzmg(zzndVarZza, runnable));
        }
        return 2;
    }

    public final void zzb() throws IllegalStateException {
        zzho.zza(this.f8485a, null, null).zzj().zzp().zza("Local AppMeasurementService is shutting down");
    }

    public final boolean zzc(Intent intent) throws IllegalStateException {
        if (intent == null) {
            a().zzg().zza("onUnbind called with null intent");
            return true;
        }
        a().zzp().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final void zzb(Intent intent) throws IllegalStateException {
        if (intent == null) {
            a().zzg().zza("onRebind called with null intent");
        } else {
            a().zzp().zza("onRebind called. action", intent.getAction());
        }
    }

    public final IBinder zza(Intent intent) throws IllegalStateException {
        if (intent == null) {
            a().zzg().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzhs(zznd.zza(this.f8485a));
        }
        a().zzu().zza("onBind received unknown action", action);
        return null;
    }

    public final void zza() throws IllegalStateException {
        zzho.zza(this.f8485a, null, null).zzj().zzp().zza("Local AppMeasurementService is starting up");
    }

    @TargetApi(24)
    public final boolean zza(final JobParameters jobParameters) throws IllegalStateException {
        T t10 = this.f8485a;
        final zzgb zzgbVarZzj = zzho.zza(t10, null, null).zzj();
        String string = jobParameters.getExtras().getString("action");
        zzgbVarZzj.zzp().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzme
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException {
                zzmf zzmfVar = this.f8482b;
                zzmfVar.getClass();
                zzgbVarZzj.zzp().zza("AppMeasurementJobService processed last upload request.");
                zzmfVar.f8485a.zza(jobParameters, false);
            }
        };
        zznd zzndVarZza = zznd.zza(t10);
        zzndVarZza.zzl().zzb(new zzmg(zzndVarZza, runnable));
        return true;
    }
}
