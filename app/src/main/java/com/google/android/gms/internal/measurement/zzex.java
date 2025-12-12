package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzex extends zzds.zzb {
    private final /* synthetic */ Long zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ Bundle zzf;
    private final /* synthetic */ boolean zzg;
    private final /* synthetic */ boolean zzh;
    private final /* synthetic */ zzds zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzex(zzds zzdsVar, Long l10, String str, String str2, Bundle bundle, boolean z10, boolean z11) {
        super(zzdsVar);
        this.zzc = l10;
        this.zzd = str;
        this.zze = str2;
        this.zzf = bundle;
        this.zzg = z10;
        this.zzh = z11;
        this.zzi = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        Long l10 = this.zzc;
        ((zzdd) Preconditions.checkNotNull(this.zzi.zzj)).logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l10 == null ? this.zza : l10.longValue());
    }
}
