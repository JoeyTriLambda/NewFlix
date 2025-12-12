package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpa implements g<zzpd> {
    private static zzpa zza = new zzpa();
    private final g<zzpd> zzb = Suppliers.ofInstance(new zzpc());

    public static boolean zza() {
        return ((zzpd) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpd) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzpd get() {
        return this.zzb.get();
    }
}
