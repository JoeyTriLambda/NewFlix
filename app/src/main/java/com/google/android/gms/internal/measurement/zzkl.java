package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzkl {
    private static final zzkl zza = new zzko();
    private static final zzkl zzb = new zzkq();

    private zzkl() {
    }

    public static zzkl zza() {
        return zza;
    }

    public static zzkl zzb() {
        return zzb;
    }

    public abstract <L> List<L> zza(Object obj, long j10);

    public abstract <L> void zza(Object obj, Object obj2, long j10);

    public abstract void zzb(Object obj, long j10);
}
