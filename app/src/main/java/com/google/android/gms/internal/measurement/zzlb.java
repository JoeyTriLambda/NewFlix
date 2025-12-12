package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzlb {
    private static final zzkz zza = zzc();
    private static final zzkz zzb = new zzlc();

    public static zzkz zza() {
        return zza;
    }

    public static zzkz zzb() {
        return zzb;
    }

    private static zzkz zzc() {
        try {
            return (zzkz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
