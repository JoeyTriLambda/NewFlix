package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzuo implements zzuv {
    private final zzuv[] zza;

    public zzuo(zzuv... zzuvVarArr) {
        this.zza = zzuvVarArr;
    }

    @Override // com.google.android.gms.internal.cast.zzuv
    public final zzuu zzb(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            zzuv zzuvVar = this.zza[i10];
            if (zzuvVar.zzc(cls)) {
                return zzuvVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.cast.zzuv
    public final boolean zzc(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.zza[i10].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
