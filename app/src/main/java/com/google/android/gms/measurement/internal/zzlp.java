package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlp implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbf f8426b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8427m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8428n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzla f8429o;

    public zzlp(zzla zzlaVar, zzbf zzbfVar, String str, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8426b = zzbfVar;
        this.f8427m = str;
        this.f8428n = zzdiVar;
        this.f8429o = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        com.google.android.gms.internal.measurement.zzdi zzdiVar = this.f8428n;
        zzla zzlaVar = this.f8429o;
        try {
            zzfq zzfqVar = zzlaVar.f8386d;
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] bArrZza = zzfqVar.zza(this.f8426b, this.f8427m);
            zzlaVar.zzam();
            zzlaVar.zzq().zza(zzdiVar, bArrZza);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send event to the service to bundle", e10);
        } finally {
            zzlaVar.zzq().zza(zzdiVar, (byte[]) null);
        }
    }
}
