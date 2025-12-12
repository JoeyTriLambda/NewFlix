package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlg implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8404b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzla f8405m;

    public zzlg(zzla zzlaVar, zzn zznVar) {
        this.f8404b = zznVar;
        this.f8405m = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8404b;
        zzla zzlaVar = this.f8405m;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zznVar);
            zzfqVar.zzd(zznVar);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to reset data on the service: remote exception", e10);
        }
        zzlaVar.zzam();
    }
}
