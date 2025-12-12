package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzqp implements g<zzqo> {
    private static zzqp zza = new zzqp();
    private final g<zzqo> zzb = Suppliers.ofInstance(new zzqr());

    public static boolean zza() {
        return ((zzqo) zza.get()).zza();
    }

    @Override // b8.g
    public final /* synthetic */ zzqo get() {
        return this.zzb.get();
    }
}
