package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzdt extends zzds.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzds zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdt(zzds zzdsVar, Bundle bundle) {
        super(zzdsVar);
        this.zzc = bundle;
        this.zzd = zzdsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(this.zzd.zzj)).setConditionalUserProperty(this.zzc, this.zza);
    }
}
