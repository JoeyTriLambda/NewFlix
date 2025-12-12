package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzll implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8418b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzla f8419m;

    public zzll(zzla zzlaVar, zzn zznVar) {
        this.f8418b = zznVar;
        this.f8419m = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8418b;
        zzla zzlaVar = this.f8419m;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(zznVar);
            zzfqVar.zzc(zznVar);
            zzlaVar.zzh().zzac();
            zzlaVar.a(zzfqVar, null, zznVar);
            zzlaVar.zzam();
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send app launch to the service", e10);
        }
    }
}
