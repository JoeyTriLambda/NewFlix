package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zznm extends zztp implements zzuy {
    private static final zznm zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        zznm zznmVar = new zznm();
        zzb = zznmVar;
        zztp.zzH(zznm.class, zznmVar);
    }

    private zznm() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzkj.zza(), "zzf", zzkd.zza(), "zzg", zzkg.zza(), "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zznm();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznl(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
