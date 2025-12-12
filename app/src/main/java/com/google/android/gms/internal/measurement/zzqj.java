package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqj implements g<zzqi> {
    private static zzqj zza = new zzqj();
    private final g<zzqi> zzb = Suppliers.ofInstance(new zzql());

    public static boolean zza() {
        return ((zzqi) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqi) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzqi get() {
        return this.zzb.get();
    }
}
