package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzqh extends zztp implements zzuy {
    private static final zzqh zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private zztx zzg = zztp.zzA();

    static {
        zzqh zzqhVar = new zzqh();
        zzb = zzqhVar;
        zztp.zzH(zzqh.class, zzqhVar);
    }

    private zzqh() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzqj.class});
        }
        if (i11 == 3) {
            return new zzqh();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqg(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
