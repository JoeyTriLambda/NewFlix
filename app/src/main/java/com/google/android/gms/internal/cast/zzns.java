package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzns extends zztp implements zzuy {
    private static final zzns zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;

    static {
        zzns zznsVar = new zzns();
        zzb = zznsVar;
        zztp.zzH(zzns.class, zznsVar);
    }

    private zzns() {
    }

    public static zznr zza() {
        return (zznr) zzb.zzv();
    }

    public static /* synthetic */ void zzd(zzns zznsVar, int i10) {
        zznsVar.zzd |= 2;
        zznsVar.zzf = i10;
    }

    public static /* synthetic */ void zze(zzns zznsVar, int i10) {
        zznsVar.zzd |= 4;
        zznsVar.zzg = i10;
    }

    public static /* synthetic */ void zzf(zzns zznsVar, boolean z10) {
        zznsVar.zzd |= 8;
        zznsVar.zzh = z10;
    }

    public static /* synthetic */ void zzg(zzns zznsVar, int i10) {
        zznsVar.zze = i10 - 1;
        zznsVar.zzd |= 1;
    }

    @Override // com.google.android.gms.internal.cast.zztp
    public final Object zzb(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zztp.zzE(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", zzlh.zza(), "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new zzns();
        }
        zzms zzmsVar = null;
        if (i11 == 4) {
            return new zznr(zzmsVar);
        }
        if (i11 != 5) {
            return null;
        }
        return zzb;
    }
}
