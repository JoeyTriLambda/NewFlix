package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzlu {
    private static final zzlu zza = new zzlu();
    private final ConcurrentMap<Class<?>, zzly<?>> zzc = new ConcurrentHashMap();
    private final zzlx zzb = new zzku();

    private zzlu() {
    }

    public static zzlu zza() {
        return zza;
    }

    public final <T> zzly<T> zza(Class<T> cls) {
        zzjw.zza(cls, "messageType");
        zzly<T> zzlyVar = (zzly) this.zzc.get(cls);
        if (zzlyVar != null) {
            return zzlyVar;
        }
        zzly<T> zzlyVarZza = this.zzb.zza(cls);
        zzjw.zza(cls, "messageType");
        zzjw.zza(zzlyVarZza, "schema");
        zzly<T> zzlyVar2 = (zzly) this.zzc.putIfAbsent(cls, zzlyVarZza);
        return zzlyVar2 != null ? zzlyVar2 : zzlyVarZza;
    }

    public final <T> zzly<T> zza(T t10) {
        return zza((Class) t10.getClass());
    }
}
