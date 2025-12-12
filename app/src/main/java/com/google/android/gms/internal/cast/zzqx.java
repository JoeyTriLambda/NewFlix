package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzqx extends zztp implements zzuy {
    private static final zzqx zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private long zzg;

    static {
        zzqx zzqxVar = new zzqx();
        zzb = zzqxVar;
        zztp.zzH(zzqx.class, zzqxVar);
    }

    private zzqx() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzd", "zze", zzmi.zza(), "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzqx();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqw(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
