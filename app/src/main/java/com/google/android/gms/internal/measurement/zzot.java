package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzot implements g<zzos> {
    private static zzot zza = new zzot();
    private final g<zzos> zzb = Suppliers.ofInstance(new zzov());

    public static boolean zza() {
        return ((zzos) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzos) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzos) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzos get() {
        return this.zzb.get();
    }
}
