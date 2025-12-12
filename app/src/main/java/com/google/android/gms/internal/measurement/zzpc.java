package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzpc implements zzpd {
    private static final zzhg<Boolean> zza;
    private static final zzhg<Boolean> zzb;
    private static final zzhg<Boolean> zzc;

    static {
        zzho zzhoVarZza = new zzho(zzhh.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zzhoVarZza.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zzhoVarZza.zza("measurement.client.sessions.check_on_startup", true);
        zzc = zzhoVarZza.zza("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzpd
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpd
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
