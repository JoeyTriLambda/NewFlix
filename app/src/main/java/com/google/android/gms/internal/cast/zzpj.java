package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzpj extends zztp implements zzuy {
    private static final zzpj zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzpj zzpjVar = new zzpj();
        zzb = zzpjVar;
        zztp.zzH(zzpj.class, zzpjVar);
    }

    private zzpj() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new zzpj();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzpi(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
