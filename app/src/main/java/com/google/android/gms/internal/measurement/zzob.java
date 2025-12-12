package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzob implements g<zzoa> {
    private static zzob zza = new zzob();
    private final g<zzoa> zzb = Suppliers.ofInstance(new zzod());

    public static long zza() {
        return ((zzoa) zza.get()).zza();
    }

    @Override // b8.g
    public final /* synthetic */ zzoa get() {
        return this.zzb.get();
    }
}
