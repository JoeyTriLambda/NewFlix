package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zznq extends zztp implements zzuy {
    private static final zznq zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zznq zznqVar = new zznq();
        zzb = zznqVar;
        zztp.zzH(zznq.class, zznqVar);
    }

    private zznq() {
    }

    public static zznp zza() {
        return (zznp) zzb.zzv();
    }

    public static /* synthetic */ void zzd(zznq zznqVar, int i10) {
        zznqVar.zzd |= 2;
        zznqVar.zzf = i10;
    }

    public static /* synthetic */ void zze(zznq zznqVar, int i10) {
        zznqVar.zzd |= 4;
        zznqVar.zzg = i10;
    }

    public static /* synthetic */ void zzf(zznq zznqVar, int i10) {
        zznqVar.zzd |= 8;
        zznqVar.zzh = i10;
    }

    public static /* synthetic */ void zzg(zznq zznqVar, int i10) {
        zznqVar.zzd |= 16;
        zznqVar.zzi = i10;
    }

    public static /* synthetic */ void zzh(zznq zznqVar, int i10) {
        zznqVar.zze = i10 - 1;
        zznqVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzle.zza(), "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new zznq();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznp(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
