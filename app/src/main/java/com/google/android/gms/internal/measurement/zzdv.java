package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzdv extends zzds.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzde zze;
    private final /* synthetic */ zzds zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdv(zzds zzdsVar, String str, String str2, zzde zzdeVar) {
        super(zzdsVar);
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzdeVar;
        this.zzf = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zzf.zzj)).getConditionalUserProperties(this.zzc, this.zzd, this.zze);
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zzb() {
        this.zze.zza((Bundle) null);
    }
}
