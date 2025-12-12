package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzoe extends zztp implements zzuy {
    private static final zzoe zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzoe zzoeVar = new zzoe();
        zzb = zzoeVar;
        zztp.zzH(zzoe.class, zzoeVar);
    }

    private zzoe() {
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzib.zza(), "zzf", zzhy.zza()});
        }
        if (i11 == 3) {
            return new zzoe();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zzod(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
