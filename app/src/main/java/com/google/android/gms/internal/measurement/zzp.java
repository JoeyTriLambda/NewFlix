package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzp extends zzal {
    private final /* synthetic */ zzo zzk;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzp(zzm zzmVar, String str, zzo zzoVar) {
        super(str);
        this.zzk = zzoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzaq zza(zzh zzhVar, List<zzaq> list) {
        zzg.zza("getValue", 2, list);
        zzaq zzaqVarZza = zzhVar.zza(list.get(0));
        zzaq zzaqVarZza2 = zzhVar.zza(list.get(1));
        String strZza = this.zzk.zza(zzaqVarZza.zzf());
        return strZza != null ? new zzas(strZza) : zzaqVarZza2;
    }
}
