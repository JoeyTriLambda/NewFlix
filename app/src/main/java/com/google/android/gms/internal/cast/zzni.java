package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzni extends zztp implements zzuy {
    private static final zzni zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzni zzniVar = new zzni();
        zzb = zzniVar;
        zztp.zzH(zzni.class, zzniVar);
    }

    private zzni() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001\u0003᠌\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzji.zza(), "zzh"});
        }
        if (i11 == 3) {
            return new zzni();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznh(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
