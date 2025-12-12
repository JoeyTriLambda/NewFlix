package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoc implements g<zzof> {
    private static zzoc zza = new zzoc();
    private final g<zzof> zzb = Suppliers.ofInstance(new zzoe());

    public static boolean zza() {
        return ((zzof) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzof) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzof get() {
        return this.zzb.get();
    }
}
