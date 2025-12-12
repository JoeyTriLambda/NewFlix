package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqv implements g<zzqu> {
    private static zzqv zza = new zzqv();
    private final g<zzqu> zzb = Suppliers.ofInstance(new zzqx());

    public static boolean zza() {
        return ((zzqu) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqu) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzqu) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzqu) zza.get()).zzd();
    }

    @Override // b8.g
    public final /* synthetic */ zzqu get() {
        return this.zzb.get();
    }
}
