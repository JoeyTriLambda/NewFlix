package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlr implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8436b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzla f8437m;

    public zzlr(zzla zzlaVar, zzn zznVar) {
        this.f8436b = zznVar;
        this.f8437m = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8436b;
        zzla zzlaVar = this.f8437m;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zznVar);
            zzfqVar.zze(zznVar);
            zzlaVar.zzam();
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send consent settings to the service", e10);
        }
    }
}
