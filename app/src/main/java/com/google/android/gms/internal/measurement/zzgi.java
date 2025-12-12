package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzgi {
    private static zzgh zza;

    public static synchronized zzgh zza() {
        if (zza == null) {
            zza(new zzgk());
        }
        return zza;
    }

    private static synchronized void zza(zzgh zzghVar) {
        if (zza == null) {
            zza = zzghVar;
        } else {
            throw new IllegalStateException("init() already called");
        }
    }
}
