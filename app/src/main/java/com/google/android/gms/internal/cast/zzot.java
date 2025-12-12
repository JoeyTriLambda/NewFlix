package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzot extends zztp implements zzuy {
    private static final zztv zzb = new zzor();
    private static final zzot zzd;
    private int zze;
    private boolean zzg;
    private boolean zzh;
    private zzra zzi;
    private boolean zzj;
    private long zzl;
    private long zzm;
    private String zzf = "";
    private zztu zzk = zztp.zzy();

    static {
        zzot zzotVar = new zzot();
        zzd = zzotVar;
        zztp.zzH(zzot.class, zzotVar);
    }

    private zzot() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzd, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဉ\u0003\u0004ဇ\u0004\u0005ࠬ\u0006ဇ\u0002\u0007ဂ\u0005\bဂ\u0006", new Object[]{"zze", "zzf", "zzg", "zzi", "zzj", "zzk", zzmf.zza(), "zzh", "zzl", "zzm"});
        }
        if (i11 == 3) {
            return new zzot();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzos(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzd;
    }
}
