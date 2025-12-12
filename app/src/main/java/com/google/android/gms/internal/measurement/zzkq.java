package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzkq extends zzkl {
    private static <E> zzkc<E> zzc(Object obj, long j10) {
        return (zzkc) zzmz.zze(obj, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final <L> List<L> zza(Object obj, long j10) {
        zzkc zzkcVarZzc = zzc(obj, j10);
        if (zzkcVarZzc.zzc()) {
            return zzkcVarZzc;
        }
        int size = zzkcVarZzc.size();
        zzkc zzkcVarZza = zzkcVarZzc.zza(size == 0 ? 10 : size << 1);
        zzmz.zza(obj, j10, zzkcVarZza);
        return zzkcVarZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final void zzb(Object obj, long j10) {
        zzc(obj, j10).zzb();
    }

    private zzkq() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final <E> void zza(Object obj, Object obj2, long j10) {
        zzkc zzkcVarZzc = zzc(obj, j10);
        zzkc zzkcVarZzc2 = zzc(obj2, j10);
        int size = zzkcVarZzc.size();
        int size2 = zzkcVarZzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkcVarZzc.zzc()) {
                zzkcVarZzc = zzkcVarZzc.zza(size2 + size);
            }
            zzkcVarZzc.addAll(zzkcVarZzc2);
        }
        if (size > 0) {
            zzkcVarZzc2 = zzkcVarZzc;
        }
        zzmz.zza(obj, j10, zzkcVarZzc2);
    }
}
