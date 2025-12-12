package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoh implements g<zzog> {
    private static zzoh zza = new zzoh();
    private final g<zzog> zzb = Suppliers.ofInstance(new zzoj());

    public static boolean zza() {
        return ((zzog) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzog) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzog get() {
        return this.zzb.get();
    }
}
