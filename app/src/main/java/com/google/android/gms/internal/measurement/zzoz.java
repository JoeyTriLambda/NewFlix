package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoz implements g<zzoy> {
    private static zzoz zza = new zzoz();
    private final g<zzoy> zzb = Suppliers.ofInstance(new zzpb());

    public static boolean zza() {
        return ((zzoy) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzoy) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzoy get() {
        return this.zzb.get();
    }
}
