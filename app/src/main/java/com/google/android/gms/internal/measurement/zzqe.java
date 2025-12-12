package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqe implements g<zzqh> {
    private static zzqe zza = new zzqe();
    private final g<zzqh> zzb = Suppliers.ofInstance(new zzqg());

    public static boolean zza() {
        return ((zzqh) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqh) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzqh get() {
        return this.zzb.get();
    }
}
