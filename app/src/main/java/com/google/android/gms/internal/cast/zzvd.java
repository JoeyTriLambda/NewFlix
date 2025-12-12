package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzvd {
    private static final zzvc zza;
    private static final zzvc zzb;

    static {
        zzvc zzvcVar;
        try {
            zzvcVar = (zzvc) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzvcVar = null;
        }
        zza = zzvcVar;
        zzb = new zzvc();
    }

    public static zzvc zza() {
        return zza;
    }

    public static zzvc zzb() {
        return zzb;
    }
}
