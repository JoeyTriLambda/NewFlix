package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzil implements Comparator<zzij> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzij zzijVar, zzij zzijVar2) {
        zzij zzijVar3 = zzijVar;
        zzij zzijVar4 = zzijVar2;
        zzip zzipVar = (zzip) zzijVar3.iterator();
        zzip zzipVar2 = (zzip) zzijVar4.iterator();
        while (zzipVar.hasNext() && zzipVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzij.zza(zzipVar.zza())).compareTo(Integer.valueOf(zzij.zza(zzipVar2.zza())));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzijVar3.zzb()).compareTo(Integer.valueOf(zzijVar4.zzb()));
    }
}
