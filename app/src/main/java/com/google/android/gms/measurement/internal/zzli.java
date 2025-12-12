package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzli implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8410b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8411m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzla f8412n;

    public zzli(zzla zzlaVar, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8410b = zznVar;
        this.f8411m = zzdiVar;
        this.f8412n = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8410b;
        com.google.android.gms.internal.measurement.zzdi zzdiVar = this.f8411m;
        zzla zzlaVar = this.f8412n;
        try {
            if (!zzlaVar.zzk().e().zzj()) {
                zzlaVar.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                zzlaVar.zzm().h(null);
                zzlaVar.zzk().f7997h.zza(null);
                return;
            }
            zzfq zzfqVar = zzlaVar.f8386d;
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(zznVar);
            String strZzb = zzfqVar.zzb(zznVar);
            if (strZzb != null) {
                zzlaVar.zzm().h(strZzb);
                zzlaVar.zzk().f7997h.zza(strZzb);
            }
            zzlaVar.zzam();
            zzlaVar.zzq().zza(zzdiVar, strZzb);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to get app instance id", e10);
        } finally {
            zzlaVar.zzq().zza(zzdiVar, (String) null);
        }
    }
}
