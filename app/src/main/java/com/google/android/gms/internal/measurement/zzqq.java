package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqq implements g<zzqt> {
    private static zzqq zza = new zzqq();
    private final g<zzqt> zzb = Suppliers.ofInstance(new zzqs());

    public static boolean zza() {
        return ((zzqt) zza.get()).zza();
    }

    public static boolean zzb() {
        return ((zzqt) zza.get()).zzb();
    }

    public static boolean zzc() {
        return ((zzqt) zza.get()).zzc();
    }

    @Override // b8.g
    public final /* synthetic */ zzqt get() {
        return this.zzb.get();
    }
}
