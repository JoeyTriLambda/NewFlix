package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdp extends zzdu {
    final /* synthetic */ zzdv zza;
    final /* synthetic */ zzdq zzb;

    public zzdp(zzdq zzdqVar, zzdv zzdvVar) {
        this.zzb = zzdqVar;
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdv
    public final void zzb(int i10) throws RemoteException {
        zzdq.zze.d("onRemoteDisplayEnded", new Object[0]);
        zzdv zzdvVar = this.zza;
        if (zzdvVar != null) {
            zzdvVar.zzb(i10);
        }
        zzdq zzdqVar = this.zzb;
        if (zzdqVar.zzf != null) {
            zzdqVar.zzf.onRemoteDisplayEnded(new Status(i10));
        }
    }
}
