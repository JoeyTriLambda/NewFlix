package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpr implements g<zzpq> {
    private static zzpr zza = new zzpr();
    private final g<zzpq> zzb = Suppliers.ofInstance(new zzpt());

    public static boolean zza() {
        return ((zzpq) zza.get()).zza();
    }

    @Override // b8.g
    public final /* synthetic */ zzpq get() {
        return this.zzb.get();
    }
}
