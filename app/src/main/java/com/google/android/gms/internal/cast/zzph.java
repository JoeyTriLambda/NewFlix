package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzph extends zztp implements zzuy {
    private static final zzph zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zzph zzphVar = new zzph();
        zzb = zzphVar;
        zztp.zzH(zzph.class, zzphVar);
    }

    private zzph() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᴌ\u0000\u0002င\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzjl.zza(), "zzf", "zzg", zzmr.zza()});
        }
        if (i11 == 3) {
            return new zzph();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpg(zzmsVar);
        }
        if (i11 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
