package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zznw implements g<zznz> {
    private static zznw zza = new zznw();
    private final g<zznz> zzb = Suppliers.ofInstance(new zzny());

    public static boolean zza() {
        return ((zznz) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zznz) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zznz) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zznz get() {
        return this.zzb.get();
    }
}
