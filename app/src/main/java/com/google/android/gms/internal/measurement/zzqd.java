package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqd implements g<zzqc> {
    private static zzqd zza = new zzqd();
    private final g<zzqc> zzb = Suppliers.ofInstance(new zzqf());

    public static boolean zza() {
        return ((zzqc) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqc) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzqc get() {
        return this.zzb.get();
    }
}
