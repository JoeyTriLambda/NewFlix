package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlo implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8424b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzla f8425m;

    public zzlo(zzla zzlaVar, zzn zznVar) {
        this.f8424b = zznVar;
        this.f8425m = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8424b;
        zzla zzlaVar = this.f8425m;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zznVar);
            zzfqVar.zzf(zznVar);
            zzlaVar.zzam();
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send measurementEnabled to the service", e10);
        }
    }
}
