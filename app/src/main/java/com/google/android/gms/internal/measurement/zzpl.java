package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpl implements g<zzpk> {
    private static zzpl zza = new zzpl();
    private final g<zzpk> zzb = Suppliers.ofInstance(new zzpn());

    public static boolean zza() {
        return ((zzpk) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpk) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzpk get() {
        return this.zzb.get();
    }
}
