package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzon implements g<zzom> {
    private static zzon zza = new zzon();
    private final g<zzom> zzb = Suppliers.ofInstance(new zzop());

    public static boolean zza() {
        return ((zzom) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzom) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzom) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzom) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzom) zza.get()).zze();
    }

    public static boolean zzf() {
        return ((zzom) zza.get()).zzf();
    }

    public static boolean zzg() {
        return ((zzom) zza.get()).zzg();
    }

    @Override // b8.g
    public final /* synthetic */ zzom get() {
        return this.zzb.get();
    }
}
