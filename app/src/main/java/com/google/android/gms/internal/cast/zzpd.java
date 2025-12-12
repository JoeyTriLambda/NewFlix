package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpd extends zztp implements zzuy {
    private static final zzpd zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzoz zzg;

    static {
        zzpd zzpdVar = new zzpd();
        zzb = zzpdVar;
        zztp.zzH(zzpd.class, zzpdVar);
    }

    private zzpd() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzpd();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpc(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
