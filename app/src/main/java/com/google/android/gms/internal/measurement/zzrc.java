package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzrc implements g<zzrf> {
    private static zzrc zza = new zzrc();
    private final g<zzrf> zzb = Suppliers.ofInstance(new zzre());

    public static boolean zza() {
        return ((zzrf) zza.get()).zza();
    }

    @Override // b8.g
    public final /* synthetic */ zzrf get() {
        return this.zzb.get();
    }
}
