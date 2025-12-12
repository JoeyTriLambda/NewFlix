package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpz extends zztp implements zzuy {
    private static final zzpz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzpz zzpzVar = new zzpz();
        zzb = zzpzVar;
        zztp.zzH(zzpz.class, zzpzVar);
    }

    private zzpz() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", zzka.zza(), "zzg"});
        }
        if (i11 == 3) {
            return new zzpz();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpy(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
