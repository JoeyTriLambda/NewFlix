package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlc implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8393b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8394m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzn f8395n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ boolean f8396o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8397p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zzla f8398q;

    public zzlc(zzla zzlaVar, String str, String str2, zzn zznVar, boolean z10, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8393b = str;
        this.f8394m = str2;
        this.f8395n = zznVar;
        this.f8396o = z10;
        this.f8397p = zzdiVar;
        this.f8398q = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8395n;
        String str = this.f8393b;
        com.google.android.gms.internal.measurement.zzdi zzdiVar = this.f8397p;
        zzla zzlaVar = this.f8398q;
        Bundle bundle = new Bundle();
        try {
            zzfq zzfqVar = zzlaVar.f8386d;
            String str2 = this.f8394m;
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("Failed to get user properties; not connected to service", str, str2);
                return;
            }
            Preconditions.checkNotNull(zznVar);
            Bundle bundleZza = zznt.zza(zzfqVar.zza(str, str2, this.f8396o, zznVar));
            zzlaVar.zzam();
            zzlaVar.zzq().zza(zzdiVar, bundleZza);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to get user properties; remote exception", str, e10);
        } finally {
            zzlaVar.zzq().zza(zzdiVar, bundle);
        }
    }
}
