package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzfd extends zzds.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzde zzd;
    private final /* synthetic */ zzds.zzc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfd(zzds.zzc zzcVar, Activity activity, zzde zzdeVar) {
        super(zzds.this);
        this.zzc = activity;
        this.zzd = zzdeVar;
        this.zze = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(zzds.this.zzj)).onActivitySaveInstanceState(ObjectWrapper.wrap(this.zzc), this.zzd, this.zzb);
    }
}
