package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzmi extends zzg {

    /* renamed from: c, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.zzdc f8492c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8493d;

    /* renamed from: e, reason: collision with root package name */
    public final zzmq f8494e;

    /* renamed from: f, reason: collision with root package name */
    public final zzmo f8495f;

    /* renamed from: g, reason: collision with root package name */
    public final zzmn f8496g;

    public zzmi(zzho zzhoVar) {
        super(zzhoVar);
        this.f8493d = true;
        this.f8494e = new zzmq(this);
        this.f8495f = new zzmo(this);
        this.f8496g = new zzmn(this);
    }

    public final void a() {
        zzt();
        if (this.f8492c == null) {
            this.f8492c = new com.google.android.gms.internal.measurement.zzdc(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzfv zzg() {
        return super.zzg();
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

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zziy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzkv zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final boolean zzz() {
        return false;
    }

    public final boolean zza(boolean z10, boolean z11, long j10) {
        return this.f8495f.zza(z10, z11, j10);
    }
}
