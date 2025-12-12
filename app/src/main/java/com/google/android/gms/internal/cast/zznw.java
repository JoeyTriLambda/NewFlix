package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zznw extends zztp implements zzuy {
    private static final zznw zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznw zznwVar = new zznw();
        zzb = zznwVar;
        zztp.zzH(zznw.class, zznwVar);
    }

    private zznw() {
    }

    public static zznv zza() {
        return (zznv) zzb.zzv();
    }

    public static /* synthetic */ void zzd(zznw zznwVar, int i10) {
        zznwVar.zzd |= 2;
        zznwVar.zzf = i10;
    }

    public static /* synthetic */ void zze(zznw zznwVar, int i10) {
        zznwVar.zzd |= 4;
        zznwVar.zzg = i10;
    }

    public static /* synthetic */ void zzf(zznw zznwVar, int i10) {
        zznwVar.zzd |= 8;
        zznwVar.zzh = i10;
    }

    public static /* synthetic */ void zzg(zznw zznwVar, int i10) {
        zznwVar.zze = i10 - 1;
        zznwVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", zzlk.zza(), "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zznw();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznv(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
