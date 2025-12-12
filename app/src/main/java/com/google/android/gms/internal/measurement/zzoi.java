package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzoi implements g<zzol> {
    private static zzoi zza = new zzoi();
    private final g<zzol> zzb = Suppliers.ofInstance(new zzok());

    public static boolean zza() {
        return ((zzol) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzol) zza.get()).zzb();
    }

    @Override // b8.g
    public final /* synthetic */ zzol get() {
        return this.zzb.get();
    }
}
