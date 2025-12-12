package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlk implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzks f8416b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzla f8417m;

    public zzlk(zzla zzlaVar, zzks zzksVar) {
        this.f8416b = zzksVar;
        this.f8417m = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzla zzlaVar = this.f8417m;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzks zzksVar = this.f8416b;
            if (zzksVar == null) {
                zzfqVar.zza(0L, (String) null, (String) null, zzlaVar.zza().getPackageName());
            } else {
                zzfqVar.zza(zzksVar.f8353c, zzksVar.f8351a, zzksVar.f8352b, zzlaVar.zza().getPackageName());
            }
            zzlaVar.zzam();
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send current screen to the service", e10);
        }
    }
}
