package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzuj extends zzul {
    public /* synthetic */ zzuj(zzui zzuiVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.cast.zzul
    public final void zza(Object obj, long j10) {
        ((zztx) zzwj.zzf(obj, j10)).zzb();
    }

    @Override // com.google.android.gms.internal.cast.zzul
    public final void zzb(Object obj, Object obj2, long j10) {
        zztx zztxVarZzg = (zztx) zzwj.zzf(obj, j10);
        zztx zztxVar = (zztx) zzwj.zzf(obj2, j10);
        int size = zztxVarZzg.size();
        int size2 = zztxVar.size();
        if (size > 0 && size2 > 0) {
            if (!zztxVarZzg.zzc()) {
                zztxVarZzg = zztxVarZzg.zzg(size2 + size);
            }
            zztxVarZzg.addAll(zztxVar);
        }
        if (size > 0) {
            zztxVar = zztxVarZzg;
        }
        zzwj.zzs(obj, j10, zztxVar);
    }

    private zzuj() {
        super(null);
    }
}
