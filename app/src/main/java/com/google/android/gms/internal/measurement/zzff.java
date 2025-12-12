package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzds;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.6.1 */
/* loaded from: classes.dex */
final class zzff extends zzds.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzds.zzc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzds.zzc zzcVar, Activity activity) {
        super(zzds.this);
        this.zzc = activity;
        this.zzd = zzcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzds.zzb
    public final void zza() throws RemoteException {
        ((zzdd) Preconditions.checkNotNull(zzds.this.zzj)).onActivityDestroyed(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}
