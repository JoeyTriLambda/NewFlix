package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpn extends zztp implements zzuy {
    private static final zzpn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;

    static {
        zzpn zzpnVar = new zzpn();
        zzb = zzpnVar;
        zztp.zzH(zzpn.class, zzpnVar);
    }

    private zzpn() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005᠌\u0004\u0006ဆ\u0005", new Object[]{"zzd", "zze", "zzf", zzjr.zza(), "zzg", "zzh", "zzi", zzie.zza(), "zzj"});
        }
        if (i11 == 3) {
            return new zzpn();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpm(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
