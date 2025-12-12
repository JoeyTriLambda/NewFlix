package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzou implements g<zzox> {
    private static zzou zza = new zzou();
    private final g<zzox> zzb = Suppliers.ofInstance(new zzow());

    public static boolean zza() {
        return ((zzox) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzox) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzox) zza.get()).zzc();
    }

    public static boolean zzd() {
        return ((zzox) zza.get()).zzd();
    }

    @Override // b8.g
    public final /* synthetic */ zzox get() {
        return this.zzb.get();
    }
}
