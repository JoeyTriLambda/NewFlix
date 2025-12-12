package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzrb implements g<zzra> {
    private static zzrb zza = new zzrb();
    private final g<zzra> zzb = Suppliers.ofInstance(new zzrd());

    public static boolean zza() {
        return ((zzra) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzra) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzra get() {
        return this.zzb.get();
    }
}
