package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzra extends zztp implements zzuy {
    private static final zztv zzb = new zzqy();
    private static final zzra zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzi;
    private long zzk;
    private zztu zzh = zztp.zzy();
    private zztx zzj = zztp.zzA();

    static {
        zzra zzraVar = new zzra();
        zzd = zzraVar;
        zztp.zzH(zzra.class, zzraVar);
    }

    private zzra() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzd, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ࠞ\u0005᠌\u0002\u0006\u001b\u0007ဂ\u0003", new Object[]{"zze", "zzf", zzmi.zza(), "zzg", zzin.zza(), "zzh", zzmf.zza(), "zzi", zzhv.zza(), "zzj", zzqx.class, "zzk"});
        }
        if (i11 == 3) {
            return new zzra();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqz(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}
