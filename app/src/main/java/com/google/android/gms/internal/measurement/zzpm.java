package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpm implements g<zzpp> {
    private static zzpm zza = new zzpm();
    private final g<zzpp> zzb = Suppliers.ofInstance(new zzpo());

    public static boolean zza() {
        return ((zzpp) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzpp) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzpp) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzpp get() {
        return this.zzb.get();
    }
}
