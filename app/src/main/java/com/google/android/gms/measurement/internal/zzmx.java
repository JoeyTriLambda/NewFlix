package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmx extends zzmy {

    /* renamed from: d, reason: collision with root package name */
    public final AlarmManager f8521d;

    /* renamed from: e, reason: collision with root package name */
    public zzmw f8522e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f8523f;

    public zzmx(zznd zzndVar) {
        super(zzndVar);
        this.f8521d = (AlarmManager) zza().getSystemService("alarm");
    }

    public final int a() {
        if (this.f8523f == null) {
            this.f8523f = Integer.valueOf(("measurement" + zza().getPackageName()).hashCode());
        }
        return this.f8523f.intValue();
    }

    public final PendingIntent b() {
        Context contextZza = zza();
        return com.google.android.gms.internal.measurement.zzco.zza(contextZza, 0, new Intent().setClassName(contextZza, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzco.zza);
    }

    public final zzav c() {
        if (this.f8522e == null) {
            this.f8522e = new zzmw(this, this.f8525b.f8555l);
        }
        return this.f8522e;
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    public final boolean zzc() {
        JobScheduler jobScheduler;
        AlarmManager alarmManager = this.f8521d;
        if (alarmManager != null) {
            alarmManager.cancel(b());
        }
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) zza().getSystemService("jobscheduler")) == null) {
            return false;
        }
        jobScheduler.cancel(a());
        return false;
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

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
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

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final void zzu() {
        JobScheduler jobScheduler;
        zzak();
        zzj().zzp().zza("Unscheduling upload");
        AlarmManager alarmManager = this.f8521d;
        if (alarmManager != null) {
            alarmManager.cancel(b());
        }
        c().a();
        if (Build.VERSION.SDK_INT < 24 || (jobScheduler = (JobScheduler) zza().getSystemService("jobscheduler")) == null) {
            return;
        }
        jobScheduler.cancel(a());
    }

    public final void zza(long j10) {
        zzak();
        Context contextZza = zza();
        if (!zznt.q(contextZza)) {
            zzj().zzc().zza("Receiver not registered/enabled");
        }
        if (!zznt.B(contextZza)) {
            zzj().zzc().zza("Service not registered/enabled");
        }
        zzu();
        zzj().zzp().zza("Scheduling upload, millis", Long.valueOf(j10));
        long jElapsedRealtime = zzb().elapsedRealtime() + j10;
        if (j10 < Math.max(0L, zzbh.f7775y.zza(null).longValue()) && !c().zzc()) {
            c().zza(j10);
        }
        if (Build.VERSION.SDK_INT < 24) {
            AlarmManager alarmManager = this.f8521d;
            if (alarmManager != null) {
                alarmManager.setInexactRepeating(2, jElapsedRealtime, Math.max(zzbh.f7765t.zza(null).longValue(), j10), b());
                return;
            }
            return;
        }
        Context contextZza2 = zza();
        ComponentName componentName = new ComponentName(contextZza2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iA = a();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzcn.zza(contextZza2, new JobInfo.Builder(iA, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }
}
