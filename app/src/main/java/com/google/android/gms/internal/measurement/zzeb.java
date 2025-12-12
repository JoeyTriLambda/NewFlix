package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzeb extends zzds.zzb {
    private final /* synthetic */ zzds zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeb(zzds zzdsVar) {
        super(zzdsVar);
        this.zzc = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zzc.zzj)).resetAnalyticsData(this.zza);
    }
}
