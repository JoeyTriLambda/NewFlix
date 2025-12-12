package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpg implements g<zzpj> {
    private static zzpg zza = new zzpg();
    private final g<zzpj> zzb = Suppliers.ofInstance(new zzpi());

    public static boolean zza() {
        return ((zzpj) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpj) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzpj get() {
        return this.zzb.get();
    }
}
