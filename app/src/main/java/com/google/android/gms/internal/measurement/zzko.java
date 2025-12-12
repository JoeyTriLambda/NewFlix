package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzko extends zzkl {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private static <E> List<E> zzc(Object obj, long j10) {
        return (List) zzmz.zze(obj, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final <L> List<L> zza(Object obj, long j10) {
        return zza(obj, j10, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final void zzb(Object obj, long j10) {
        Object objUnmodifiableList;
        List list = (List) zzmz.zze(obj, j10);
        if (list instanceof zzkm) {
            objUnmodifiableList = ((zzkm) list).zzd();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzls) && (list instanceof zzkc)) {
                zzkc zzkcVar = (zzkc) list;
                if (zzkcVar.zzc()) {
                    zzkcVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzmz.zza(obj, j10, objUnmodifiableList);
    }

    private zzko() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j10, int i10) {
        zzkj zzkjVar;
        List<L> listZzc = zzc(obj, j10);
        if (listZzc.isEmpty()) {
            List<L> zzkjVar2 = listZzc instanceof zzkm ? new zzkj(i10) : ((listZzc instanceof zzls) && (listZzc instanceof zzkc)) ? ((zzkc) listZzc).zza(i10) : new ArrayList<>(i10);
            zzmz.zza(obj, j10, zzkjVar2);
            return zzkjVar2;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList = new ArrayList(listZzc.size() + i10);
            arrayList.addAll(listZzc);
            zzmz.zza(obj, j10, arrayList);
            zzkjVar = arrayList;
        } else {
            if (!(listZzc instanceof zzmy)) {
                if (!(listZzc instanceof zzls) || !(listZzc instanceof zzkc)) {
                    return listZzc;
                }
                zzkc zzkcVar = (zzkc) listZzc;
                if (zzkcVar.zzc()) {
                    return listZzc;
                }
                zzkc zzkcVarZza = zzkcVar.zza(listZzc.size() + i10);
                zzmz.zza(obj, j10, zzkcVarZza);
                return zzkcVarZza;
            }
            zzkj zzkjVar3 = new zzkj(listZzc.size() + i10);
            zzkjVar3.addAll((zzmy) listZzc);
            zzmz.zza(obj, j10, zzkjVar3);
            zzkjVar = zzkjVar3;
        }
        return zzkjVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final <E> void zza(Object obj, Object obj2, long j10) {
        List listZzc = zzc(obj2, j10);
        List listZza = zza(obj, j10, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzmz.zza(obj, j10, listZzc);
    }
}
