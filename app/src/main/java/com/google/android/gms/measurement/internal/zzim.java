package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
class zzim implements zzio {

    /* renamed from: a, reason: collision with root package name */
    public final zzho f8189a;

    public zzim(zzho zzhoVar) {
        Preconditions.checkNotNull(zzhoVar);
        this.f8189a = zzhoVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public Context zza() {
        return this.f8189a.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public Clock zzb() {
        return this.f8189a.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzad zzd() {
        return this.f8189a.zzd();
    }

    public zzae zze() {
        return this.f8189a.zzf();
    }

    public zzaz zzf() {
        return this.f8189a.zzg();
    }

    public zzfw zzi() {
        return this.f8189a.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzgb zzj() {
        return this.f8189a.zzj();
    }

    public zzgm zzk() {
        return this.f8189a.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzio
    public zzhh zzl() {
        return this.f8189a.zzl();
    }

    public zznt zzq() {
        return this.f8189a.zzt();
    }

    public void zzr() {
        this.f8189a.zzl().zzr();
    }

    public void zzt() {
        this.f8189a.zzl().zzt();
    }
}
