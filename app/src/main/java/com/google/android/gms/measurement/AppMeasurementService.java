package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzmf;
import com.google.android.gms.measurement.internal.zzmj;
import t1.a;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzmj {

    /* renamed from: b, reason: collision with root package name */
    public zzmf<AppMeasurementService> f7608b;

    public final zzmf<AppMeasurementService> a() {
        if (this.f7608b == null) {
            this.f7608b = new zzmf<>(this);
        }
        return this.f7608b;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return a().zza(intent);
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

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        return a().zza(intent, i10, i11);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return a().zzc(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    public final void zza(Intent intent) {
        a.completeWakefulIntent(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    public final void zza(JobParameters jobParameters, boolean z10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzmj
    public final boolean zza(int i10) {
        return stopSelfResult(i10);
    }
}
