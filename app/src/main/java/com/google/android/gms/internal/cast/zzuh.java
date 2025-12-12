package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzuh extends zzul {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public /* synthetic */ zzuh(zzug zzugVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.cast.zzul
    public final void zza(Object obj, long j10) {
        Object objUnmodifiableList;
        List list = (List) zzwj.zzf(obj, j10);
        if (list instanceof zzuf) {
            objUnmodifiableList = ((zzuf) list).zzd();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzve) && (list instanceof zztx)) {
                zztx zztxVar = (zztx) list;
                if (zztxVar.zzc()) {
                    zztxVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzwj.zzs(obj, j10, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzul
    public final void zzb(Object obj, Object obj2, long j10) {
        zzue zzueVar;
        List list = (List) zzwj.zzf(obj2, j10);
        int size = list.size();
        List listZzg = (List) zzwj.zzf(obj, j10);
        if (listZzg.isEmpty()) {
            listZzg = listZzg instanceof zzuf ? new zzue(size) : ((listZzg instanceof zzve) && (listZzg instanceof zztx)) ? ((zztx) listZzg).zzg(size) : new ArrayList(size);
            zzwj.zzs(obj, j10, listZzg);
        } else {
            if (zza.isAssignableFrom(listZzg.getClass())) {
                ArrayList arrayList = new ArrayList(listZzg.size() + size);
                arrayList.addAll(listZzg);
                zzwj.zzs(obj, j10, arrayList);
                zzueVar = arrayList;
            } else if (listZzg instanceof zzwe) {
                zzue zzueVar2 = new zzue(listZzg.size() + size);
                zzueVar2.addAll(zzueVar2.size(), (zzwe) listZzg);
                zzwj.zzs(obj, j10, zzueVar2);
                zzueVar = zzueVar2;
            } else if ((listZzg instanceof zzve) && (listZzg instanceof zztx)) {
                zztx zztxVar = (zztx) listZzg;
                if (!zztxVar.zzc()) {
                    listZzg = zztxVar.zzg(listZzg.size() + size);
                    zzwj.zzs(obj, j10, listZzg);
                }
            }
            listZzg = zzueVar;
        }
        int size2 = listZzg.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listZzg.addAll(list);
        }
        if (size2 > 0) {
            list = listZzg;
        }
        zzwj.zzs(obj, j10, list);
    }

    private zzuh() {
        super(null);
    }
}
