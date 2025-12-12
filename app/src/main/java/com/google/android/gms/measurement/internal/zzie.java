package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzon;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzie implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8169b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzhs f8170m;

    public zzie(zzhs zzhsVar, zzn zznVar) {
        this.f8169b = zznVar;
        this.f8170m = zzhsVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzhs zzhsVar = this.f8170m;
        zzhsVar.f8127a.J();
        zznd zzndVar = zzhsVar.f8127a;
        zzndVar.zzl().zzt();
        zzndVar.K();
        zzn zznVar = this.f8169b;
        Preconditions.checkNotEmpty(zznVar.f8526b);
        zziq zziqVarZza = zziq.zza(zznVar.G, (zzon.zza() && zzndVar.zze().zza(zzbh.M0)) ? zznVar.L : 100);
        String str = zznVar.f8526b;
        zziq zziqVarY = zzndVar.y(str);
        zzndVar.zzj().zzp().zza("Setting consent, package, consent", str, zziqVarZza);
        zzndVar.zzl().zzt();
        zzndVar.K();
        zzndVar.B.put(str, zziqVarZza);
        zzndVar.zzf().zza(str, zziqVarZza);
        if (zziqVarZza.zzc(zziqVarY)) {
            zzndVar.G(zznVar);
        }
        if (zzon.zza() && zzndVar.zze().zza(zzbh.M0)) {
            zzax zzaxVarZza = zzax.zza(zznVar.M);
            if (zzax.f7687f.equals(zzaxVarZza)) {
                return;
            }
            zzndVar.zzj().zzp().zza("Setting DMA consent. package, consent", str, zzaxVarZza);
            String str2 = zznVar.f8526b;
            zzndVar.zzl().zzt();
            zzndVar.K();
            boolean zZza = zzon.zza();
            HashMap map = zzndVar.C;
            if (!zZza || !zzndVar.zze().zza(zzbh.Q0)) {
                map.put(str2, zzaxVarZza);
                zzndVar.zzf().zza(str2, zzaxVarZza);
                return;
            }
            zzip zzipVarZzc = zzax.zza(zzndVar.b(str2), 100).zzc();
            map.put(str2, zzaxVarZza);
            zzndVar.zzf().zza(str2, zzaxVarZza);
            zzip zzipVarZzc2 = zzax.zza(zzndVar.b(str2), 100).zzc();
            zzndVar.zzl().zzt();
            zzndVar.K();
            if (zzipVarZzc == zzip.DENIED && zzipVarZzc2 == zzip.GRANTED) {
                zzndVar.zzj().zzp().zza("Generated _dcu event for", str2);
                Bundle bundle = new Bundle();
                if (zzndVar.zzf().zza(zzndVar.M(), str2, false, false, false, false, false, false).f7675f < zzndVar.zze().zzb(str2, zzbh.X)) {
                    bundle.putLong("_r", 1L);
                    zzndVar.zzj().zzp().zza("_dcu realtime event count", str2, Long.valueOf(zzndVar.zzf().zza(zzndVar.M(), str2, false, false, false, false, false, true).f7675f));
                }
                zzndVar.G.zza(str2, "_dcu", bundle);
            }
        }
    }
}
