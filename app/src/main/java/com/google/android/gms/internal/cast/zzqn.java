package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzqn extends zztp implements zzuy {
    private static final zzqn zzb;
    private int zzd;
    private long zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;

    static {
        zzqn zzqnVar = new zzqn();
        zzb = zzqnVar;
        zztp.zzH(zzqn.class, zzqnVar);
    }

    private zzqn() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzqn();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqm(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
