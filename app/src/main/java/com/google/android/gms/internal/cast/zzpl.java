package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpl extends zztp implements zzuy {
    private static final zzpl zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private int zzg;

    static {
        zzpl zzplVar = new zzpl();
        zzb = zzplVar;
        zztp.zzH(zzpl.class, zzplVar);
    }

    private zzpl() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzjo.zza(), "zzf", "zzg", zzhj.zza()});
        }
        if (i11 == 3) {
            return new zzpl();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpk(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
