package com.google.android.gms.internal.cast;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzvf {
    private static final zzvf zza = new zzvf();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzvj zzb = new zzup();

    private zzvf() {
    }

    public static zzvf zza() {
        return zza;
    }

    public final zzvi zzb(Class cls) {
        zzty.zzc(cls, "messageType");
        zzvi zzviVarZza = (zzvi) this.zzc.get(cls);
        if (zzviVarZza == null) {
            zzviVarZza = this.zzb.zza(cls);
            zzty.zzc(cls, "messageType");
            zzvi zzviVar = (zzvi) this.zzc.putIfAbsent(cls, zzviVarZza);
            if (zzviVar != null) {
                return zzviVar;
            }
        }
        return zzviVarZza;
    }
}
