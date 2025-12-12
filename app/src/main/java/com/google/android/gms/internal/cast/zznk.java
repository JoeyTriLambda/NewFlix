package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zznk extends zztp implements zzuy {
    private static final zznk zzb;
    private int zzd;
    private int zze;

    static {
        zznk zznkVar = new zznk();
        zzb = zznkVar;
        zztp.zzH(zznk.class, zznkVar);
    }

    private zznk() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzhm.zza()});
        }
        if (i11 == 3) {
            return new zznk();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznj(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
