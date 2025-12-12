package com.google.android.gms.internal.cast;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzwb extends zzvz {
    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* synthetic */ int zza(Object obj) {
        return ((zzwa) obj).zza();
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzwa) obj).zzb();
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* synthetic */ Object zzc(Object obj) {
        return ((zztp) obj).zzc;
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* bridge */ /* synthetic */ Object zzd(Object obj, Object obj2) {
        if (zzwa.zzc().equals(obj2)) {
            return obj;
        }
        if (zzwa.zzc().equals(obj)) {
            return zzwa.zze((zzwa) obj, (zzwa) obj2);
        }
        ((zzwa) obj).zzd((zzwa) obj2);
        return obj;
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final void zze(Object obj) {
        ((zztp) obj).zzc.zzf();
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        ((zztp) obj).zzc = (zzwa) obj2;
    }

    @Override // com.google.android.gms.internal.cast.zzvz
    public final /* synthetic */ void zzg(Object obj, zzwq zzwqVar) throws IOException {
    }
}
