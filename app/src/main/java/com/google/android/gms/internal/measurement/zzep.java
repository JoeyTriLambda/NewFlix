package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzep extends zzds.zzb {
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzde zzd;
    private final /* synthetic */ zzds zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzep(zzds zzdsVar, String str, zzde zzdeVar) {
        super(zzdsVar);
        this.zzc = str;
        this.zzd = zzdeVar;
        this.zze = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zze.zzj)).getMaxUserProperties(this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zzb() {
        this.zzd.zza((Bundle) null);
    }
}
