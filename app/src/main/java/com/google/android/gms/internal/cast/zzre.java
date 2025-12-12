package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzre extends zztp implements zzuy {
    private static final zzre zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        zzre zzreVar = new zzre();
        zzb = zzreVar;
        zztp.zzH(zzre.class, zzreVar);
    }

    private zzre() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzmo.zza(), "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzre();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzrd(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
