package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpf implements g<zzpe> {
    private static zzpf zza = new zzpf();
    private final g<zzpe> zzb = Suppliers.ofInstance(new zzph());

    public static boolean zza() {
        return ((zzpe) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpe) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpe) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzpe get() {
        return this.zzb.get();
    }
}
