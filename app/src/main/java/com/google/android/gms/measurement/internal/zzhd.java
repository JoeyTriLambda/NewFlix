package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzhd implements com.google.android.gms.internal.measurement.zzv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgy f8066a;

    public zzhd(zzgy zzgyVar) {
        this.f8066a = zzgyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzv
    public final void zza(com.google.android.gms.internal.measurement.zzs zzsVar, String str, List<String> list, boolean z10, boolean z11) throws IllegalStateException {
        int i10 = zzhf.f8068a[zzsVar.ordinal()];
        zzgy zzgyVar = this.f8066a;
        zzgd zzgdVarZzn = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? zzgyVar.zzj().zzn() : zzgyVar.zzj().zzp() : z10 ? zzgyVar.zzj().zzw() : !z11 ? zzgyVar.zzj().zzv() : zzgyVar.zzj().zzu() : z10 ? zzgyVar.zzj().zzm() : !z11 ? zzgyVar.zzj().zzh() : zzgyVar.zzj().zzg() : zzgyVar.zzj().zzc();
        int size = list.size();
        if (size == 1) {
            zzgdVarZzn.zza(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzgdVarZzn.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzgdVarZzn.zza(str);
        } else {
            zzgdVarZzn.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
