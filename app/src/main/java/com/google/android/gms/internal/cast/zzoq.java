package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzoq extends zztp implements zzuy {
    private static final zzoq zzb;
    private int zzd;
    private boolean zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private zzpn zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzoq zzoqVar = new zzoq();
        zzb = zzoqVar;
        zztp.zzH(zzoq.class, zzoqVar);
    }

    private zzoq() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005ဉ\u0004\u0006᠌\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", zzin.zza(), "zzg", zzit.zza(), "zzh", zzhg.zza(), "zzi", "zzj", zziq.zza(), "zzk"});
        }
        if (i11 == 3) {
            return new zzoq();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzop(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
