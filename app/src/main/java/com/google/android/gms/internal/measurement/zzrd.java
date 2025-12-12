package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzrd implements zzra {
    private static final zzhg<Boolean> zza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza().zza("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzra
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzra
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
