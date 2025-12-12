package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqk implements g<zzqn> {
    private static zzqk zza = new zzqk();
    private final g<zzqn> zzb = Suppliers.ofInstance(new zzqm());

    public static boolean zza() {
        return ((zzqn) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqn) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzqn) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzqn) zza.get()).zzd();
    }

    @Override // b8.g
    public final /* synthetic */ zzqn get() {
        return this.zzb.get();
    }
}
