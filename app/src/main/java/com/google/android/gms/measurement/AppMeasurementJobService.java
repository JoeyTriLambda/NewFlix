package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzmf;
import com.google.android.gms.measurement.internal.zzmj;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zzmj {

    /* renamed from: b, reason: collision with root package name */
    public zzmf<AppMeasurementJobService> f7606b;

    public final zzmf<AppMeasurementJobService> a() {
        if (this.f7606b == null) {
            this.f7606b = new zzmf<>(this);
        }
        return this.f7606b;
    }

    @Override // android.app.Service
    public final void onCreate() throws IllegalStateException {
        super.onCreate();
        a().zza();
    }

    @Override // android.app.Service
    public final void onDestroy() throws IllegalStateException {
        a().zzb();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) throws IllegalStateException {
        a().zzb(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return a().zza(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    public final void zza(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z10) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    public final boolean zza(int i10) {
        throw new UnsupportedOperationException();
    }
}
