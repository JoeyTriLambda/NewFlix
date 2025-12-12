package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpx implements g<zzpw> {
    private static zzpx zza = new zzpx();
    private final g<zzpw> zzb = Suppliers.ofInstance(new zzpz());

    public static boolean zza() {
        return ((zzpw) zza.get()).zza();
    }

    @Override // b8.g
    public final /* synthetic */ zzpw get() {
        return this.zzb.get();
    }
}
