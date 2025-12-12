package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzou;
import java.math.BigDecimal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzaa extends zzab {

    /* renamed from: g, reason: collision with root package name */
    public final zzfh.zze f7619g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzs f7620h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzs zzsVar, String str, int i10, zzfh.zze zzeVar) {
        super(str, i10);
        this.f7620h = zzsVar;
        this.f7619g = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final int a() {
        return this.f7619g.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    public final boolean f() {
        return true;
    }

    public final boolean g(Long l10, Long l11, zzft.zzn zznVar, boolean z10) throws IllegalStateException {
        boolean zZza = zzou.zza();
        zzs zzsVar = this.f7620h;
        boolean z11 = zZza && zzsVar.zze().zzf(this.f7621a, zzbh.f7740g0);
        zzfh.zze zzeVar = this.f7619g;
        boolean zZzf = zzeVar.zzf();
        boolean zZzg = zzeVar.zzg();
        boolean zZzh = zzeVar.zzh();
        boolean z12 = zZzf || zZzg || zZzh;
        Boolean boolB = null;
        boolD = null;
        Boolean boolD = null;
        Boolean boolD2 = null;
        boolB = null;
        boolB = null;
        boolB = null;
        Boolean boolD3 = null;
        boolB = null;
        if (z10 && !z12) {
            zzsVar.zzj().zzp().zza("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f7622b), zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
            return true;
        }
        zzfh.zzc zzcVarZzb = zzeVar.zzb();
        boolean zZzf2 = zzcVarZzb.zzf();
        if (zznVar.zzk()) {
            if (zzcVarZzb.zzh()) {
                try {
                    boolD2 = zzab.d(new BigDecimal(zznVar.zzc()), zzcVarZzb.zzc(), 0.0d);
                } catch (NumberFormatException unused) {
                }
                boolB = zzab.b(boolD2, zZzf2);
            } else {
                zzsVar.zzj().zzu().zza("No number filter for long property. property", zzsVar.zzi().zzc(zznVar.zzg()));
            }
        } else if (zznVar.zzi()) {
            if (zzcVarZzb.zzh()) {
                double dZza = zznVar.zza();
                try {
                    boolD = zzab.d(new BigDecimal(dZza), zzcVarZzb.zzc(), Math.ulp(dZza));
                } catch (NumberFormatException unused2) {
                }
                boolB = zzab.b(boolD, zZzf2);
            } else {
                zzsVar.zzj().zzu().zza("No number filter for double property. property", zzsVar.zzi().zzc(zznVar.zzg()));
            }
        } else if (!zznVar.zzm()) {
            zzsVar.zzj().zzu().zza("User property has no value, property", zzsVar.zzi().zzc(zznVar.zzg()));
        } else if (zzcVarZzb.zzj()) {
            boolB = zzab.b(zzab.c(zznVar.zzh(), zzcVarZzb.zzd(), zzsVar.zzj()), zZzf2);
        } else if (!zzcVarZzb.zzh()) {
            zzsVar.zzj().zzu().zza("No string or number filter defined. property", zzsVar.zzi().zzc(zznVar.zzg()));
        } else if (zznm.E(zznVar.zzh())) {
            String strZzh = zznVar.zzh();
            zzfh.zzd zzdVarZzc = zzcVarZzb.zzc();
            if (zznm.E(strZzh)) {
                try {
                    boolD3 = zzab.d(new BigDecimal(strZzh), zzdVarZzc, 0.0d);
                } catch (NumberFormatException unused3) {
                }
            }
            boolB = zzab.b(boolD3, zZzf2);
        } else {
            zzsVar.zzj().zzu().zza("Invalid user property value for Numeric number filter. property, value", zzsVar.zzi().zzc(zznVar.zzg()), zznVar.zzh());
        }
        zzsVar.zzj().zzp().zza("Property filter result", boolB == null ? "null" : boolB);
        if (boolB == null) {
            return false;
        }
        this.f7623c = Boolean.TRUE;
        if (zZzh && !boolB.booleanValue()) {
            return true;
        }
        if (!z10 || zzeVar.zzf()) {
            this.f7624d = boolB;
        }
        if (boolB.booleanValue() && z12 && zznVar.zzl()) {
            long jZzd = zznVar.zzd();
            if (l10 != null) {
                jZzd = l10.longValue();
            }
            if (z11 && zzeVar.zzf() && !zzeVar.zzg() && l11 != null) {
                jZzd = l11.longValue();
            }
            if (zzeVar.zzg()) {
                this.f7626f = Long.valueOf(jZzd);
            } else {
                this.f7625e = Long.valueOf(jZzd);
            }
        }
        return true;
    }
}
