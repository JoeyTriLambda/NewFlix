package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpr extends zztp implements zzuy {
    private static final zzpr zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    static {
        zzpr zzprVar = new zzpr();
        zzb = zzprVar;
        zztp.zzH(zzpr.class, zzprVar);
    }

    private zzpr() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007ဇ\u0006", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzju.zza(), "zzj", zzju.zza(), "zzk"});
        }
        if (i11 == 3) {
            return new zzpr();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpq(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
