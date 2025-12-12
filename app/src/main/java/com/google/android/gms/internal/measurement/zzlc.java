package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzlc implements zzkz {
    @Override // com.google.android.gms.internal.measurement.zzkz
    public final int zza(int i10, Object obj, Object obj2) {
        zzla zzlaVar = (zzla) obj;
        if (zzlaVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlaVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final Object zzb(Object obj) {
        return zzla.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final Object zzc(Object obj) {
        ((zzla) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final Map<?, ?> zzd(Object obj) {
        return (zzla) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final Map<?, ?> zze(Object obj) {
        return (zzla) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final boolean zzf(Object obj) {
        return !((zzla) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final zzkx<?, ?> zza(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzkz
    public final Object zza(Object obj, Object obj2) {
        zzla zzlaVarZzb = (zzla) obj;
        zzla zzlaVar = (zzla) obj2;
        if (!zzlaVar.isEmpty()) {
            if (!zzlaVarZzb.zzd()) {
                zzlaVarZzb = zzlaVarZzb.zzb();
            }
            zzlaVarZzb.zza(zzlaVar);
        }
        return zzlaVarZzb;
    }
}
