package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzqj extends zztp implements zzuy {
    private static final zzqj zzb;
    private int zzd;
    private String zze = "";
    private zztx zzf = zztp.zzA();
    private zztx zzg = zztp.zzA();
    private boolean zzh;

    static {
        zzqj zzqjVar = new zzqj();
        zzb = zzqjVar;
        zztp.zzH(zzqj.class, zzqjVar);
    }

    private zzqj() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzoz.class, "zzg", zzok.class, "zzh"});
        }
        if (i11 == 3) {
            return new zzqj();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzqi(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
