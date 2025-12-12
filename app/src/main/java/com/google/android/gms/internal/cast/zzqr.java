package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzqr extends zztp implements zzuy {
    private static final zzqr zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzna zzg;

    static {
        zzqr zzqrVar = new zzqr();
        zzb = zzqrVar;
        zztp.zzH(zzqr.class, zzqrVar);
    }

    private zzqr() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzlb.zza(), "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzqr();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqq(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
