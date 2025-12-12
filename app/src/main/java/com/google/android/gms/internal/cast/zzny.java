package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzny extends zztp implements zzuy {
    private static final zzny zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzny zznyVar = new zzny();
        zzb = zznyVar;
        zztp.zzH(zzny.class, zznyVar);
    }

    private zzny() {
    }

    public static zznx zza() {
        return (zznx) zzb.zzv();
    }

    public static /* synthetic */ void zzd(zzny zznyVar, int i10) {
        zznyVar.zzd |= 2;
        zznyVar.zzf = i10;
    }

    public static /* synthetic */ void zze(zzny zznyVar, int i10) {
        zznyVar.zze = i10 - 1;
        zznyVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001", new Object[]{"zzd", "zze", zzlt.zza(), "zzf"});
        }
        if (i11 == 3) {
            return new zzny();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznx(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
