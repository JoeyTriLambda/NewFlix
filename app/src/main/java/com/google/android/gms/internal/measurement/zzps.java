package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzps implements g<zzpv> {
    private static zzps zza = new zzps();
    private final g<zzpv> zzb = Suppliers.ofInstance(new zzpu());

    public static double zza() {
        return ((zzpv) zza.get()).zza();
    }

    public static long zzb() {
        return ((zzpv) zza.get()).zzb();
    }

    public static long zzc() {
        return ((zzpv) zza.get()).zzc();
    }

    public static String zzd() {
        return ((zzpv) zza.get()).zzd();
    }

    public static boolean zze() {
        return ((zzpv) zza.get()).zze();
    }

    @Override // b8.g
    public final /* synthetic */ zzpv get() {
        return this.zzb.get();
    }
}
