package com.google.android.gms.internal.cast;

import ac.c;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzfe implements zzfc {
    private static final zzfc zza = new zzfc() { // from class: com.google.android.gms.internal.cast.zzfd
        @Override // com.google.android.gms.internal.cast.zzfc
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzfc zzb;
    private Object zzc;

    public zzfe(zzfc zzfcVar) {
        this.zzb = zzfcVar;
    }

    public final String toString() {
        Object objK = this.zzb;
        if (objK == zza) {
            objK = c.k("<supplier that returned ", String.valueOf(this.zzc), ">");
        }
        return c.k("Suppliers.memoize(", String.valueOf(objK), ")");
    }

    @Override // com.google.android.gms.internal.cast.zzfc
    public final Object zza() {
        zzfc zzfcVar = this.zzb;
        zzfc zzfcVar2 = zza;
        if (zzfcVar != zzfcVar2) {
            synchronized (this) {
                if (this.zzb != zzfcVar2) {
                    Object objZza = this.zzb.zza();
                    this.zzc = objZza;
                    this.zzb = zzfcVar2;
                    return objZza;
                }
            }
        }
        return this.zzc;
    }
}
