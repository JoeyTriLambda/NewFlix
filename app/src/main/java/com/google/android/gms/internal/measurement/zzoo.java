package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoo implements g<zzor> {
    private static zzoo zza = new zzoo();
    private final g<zzor> zzb = Suppliers.ofInstance(new zzoq());

    public static boolean zza() {
        return ((zzor) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzor) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzor) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzor get() {
        return this.zzb.get();
    }
}
