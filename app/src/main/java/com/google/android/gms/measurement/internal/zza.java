package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import b0.b;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zza extends zzd {

    /* renamed from: b, reason: collision with root package name */
    public final b f7616b;

    /* renamed from: c, reason: collision with root package name */
    public final b f7617c;

    /* renamed from: d, reason: collision with root package name */
    public long f7618d;

    public zza(zzho zzhoVar) {
        super(zzhoVar);
        this.f7617c = new b();
        this.f7616b = new b();
    }

    public final void a(long j10, zzks zzksVar) {
        if (zzksVar == null) {
            zzj().zzp().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().zzp().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j10);
        zznt.zza(zzksVar, bundle, true);
        zzm().o("am", "_xa", bundle);
    }

    public final void b(String str, long j10, zzks zzksVar) {
        if (zzksVar == null) {
            zzj().zzp().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j10 < 1000) {
            zzj().zzp().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j10));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j10);
        zznt.zza(zzksVar, bundle, true);
        zzm().o("am", "_xu", bundle);
    }

    public final void c(long j10) {
        b bVar = this.f7616b;
        Iterator it = bVar.keySet().iterator();
        while (it.hasNext()) {
            bVar.put((String) it.next(), Long.valueOf(j10));
        }
        if (bVar.isEmpty()) {
            return;
        }
        this.f7618d = j10;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
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

    public final void zza(String str, long j10) throws IllegalStateException {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb(new zzc(this, str, j10));
        }
    }

    public final void zzb(String str, long j10) throws IllegalStateException {
        if (str == null || str.length() == 0) {
            zzj().zzg().zza("Ad unit id must be a non-empty string");
        } else {
            zzl().zzb(new zzb(this, str, j10));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(long j10) {
        zzks zzksVarZza = zzn().zza(false);
        b bVar = this.f7616b;
        for (K k10 : bVar.keySet()) {
            b(k10, j10 - ((Long) bVar.get(k10)).longValue(), zzksVarZza);
        }
        if (!bVar.isEmpty()) {
            a(j10 - this.f7618d, zzksVarZza);
        }
        c(j10);
    }
}
