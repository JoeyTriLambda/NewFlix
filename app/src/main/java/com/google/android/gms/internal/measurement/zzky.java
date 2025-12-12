package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
public final class zzky<K, V> {
    public static <K, V> int zza(zzkx<K, V> zzkxVar, K k10, V v10) {
        return zzjj.zza(zzkxVar.zza, 1, k10) + zzjj.zza(zzkxVar.zzc, 2, v10);
    }

    public static <K, V> void zza(zzja zzjaVar, zzkx<K, V> zzkxVar, K k10, V v10) throws IOException {
        zzjj.zza(zzjaVar, zzkxVar.zza, 1, k10);
        zzjj.zza(zzjaVar, zzkxVar.zzc, 2, v10);
    }
}
