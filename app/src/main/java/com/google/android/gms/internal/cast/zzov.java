package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzov extends zztp implements zzuy {
    private static final zzov zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zztu zzg = zztp.zzy();
    private zztu zzh = zztp.zzy();
    private zztx zzi = zztp.zzA();
    private zztx zzj = zztp.zzA();
    private int zzk;

    static {
        zzov zzovVar = new zzov();
        zzb = zzovVar;
        zztp.zzH(zzov.class, zzovVar);
    }

    private zzov() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001င\u0000\u0002᠌\u0001\u0003\u0016\u0004\u0016\u0005\u001a\u0006\u001a\u0007᠌\u0002", new Object[]{"zzd", "zze", "zzf", zziz.zza(), "zzg", "zzh", "zzi", "zzj", "zzk", zzin.zza()});
        }
        if (i11 == 3) {
            return new zzov();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzou(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
