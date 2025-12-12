package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpp extends zztp implements zzuy {
    private static final zzpp zzb;
    private int zzd;
    private long zze;
    private zztw zzf = zztp.zzz();
    private zztw zzg = zztp.zzz();

    static {
        zzpp zzppVar = new zzpp();
        zzb = zzppVar;
        zztp.zzH(zzpp.class, zzppVar);
    }

    private zzpp() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new zzpp();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpo(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
