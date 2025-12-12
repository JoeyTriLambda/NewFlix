package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzut {
    private static final zzus zza;
    private static final zzus zzb;

    static {
        zzus zzusVar;
        try {
            zzusVar = (zzus) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzusVar = null;
        }
        zza = zzusVar;
        zzb = new zzus();
    }

    public static zzus zza() {
        return zza;
    }

    public static zzus zzb() {
        return zzb;
    }
}
