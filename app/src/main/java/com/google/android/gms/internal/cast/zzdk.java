package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzdk extends zzdi {
    final /* synthetic */ zzdl zza;

    public zzdk(zzdl zzdlVar) {
        this.zza = zzdlVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdi, com.google.android.gms.internal.cast.zzds
    public final void zzd(int i10) throws RemoteException {
        zzdn.zza.d("onError: %d", Integer.valueOf(i10));
        zzdn.zzf(this.zza.zzc);
        this.zza.setResult((zzdl) new zzdm(Status.f7071r));
    }

    @Override // com.google.android.gms.internal.cast.zzdi, com.google.android.gms.internal.cast.zzds
    public final void zzf() throws RemoteException {
        zzdn.zza.d("onDisconnected", new Object[0]);
        zzdn.zzf(this.zza.zzc);
        this.zza.setResult((zzdl) new zzdm(Status.f7069p));
    }
}
