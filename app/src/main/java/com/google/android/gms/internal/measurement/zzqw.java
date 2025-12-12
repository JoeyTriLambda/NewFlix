package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqw implements g<zzqz> {
    private static zzqw zza = new zzqw();
    private final g<zzqz> zzb = Suppliers.ofInstance(new zzqy());

    public static boolean zza() {
        return ((zzqz) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqz) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzqz) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzqz get() {
        return this.zzb.get();
    }
}
