package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzkv implements zzld {
    private zzld[] zza;

    public zzkv(zzld... zzldVarArr) {
        this.zza = zzldVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final zzle zza(Class<?> cls) {
        for (zzld zzldVar : this.zza) {
            if (zzldVar.zzb(cls)) {
                return zzldVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzld
    public final boolean zzb(Class<?> cls) {
        for (zzld zzldVar : this.zza) {
            if (zzldVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
