package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlv implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8455b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8456m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzn f8457n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzdi f8458o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzla f8459p;

    public zzlv(zzla zzlaVar, String str, String str2, zzn zznVar, com.google.android.gms.internal.measurement.zzdi zzdiVar) {
        this.f8455b = str;
        this.f8456m = str2;
        this.f8457n = zznVar;
        this.f8458o = zzdiVar;
        this.f8459p = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8457n;
        String str = this.f8456m;
        String str2 = this.f8455b;
        com.google.android.gms.internal.measurement.zzdi zzdiVar = this.f8458o;
        zzla zzlaVar = this.f8459p;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzfq zzfqVar = zzlaVar.f8386d;
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("Failed to get conditional properties; not connected to service", str2, str);
                return;
            }
            Preconditions.checkNotNull(zznVar);
            ArrayList<Bundle> arrayListZzb = zznt.zzb(zzfqVar.zza(str2, str, zznVar));
            zzlaVar.zzam();
            zzlaVar.zzq().zza(zzdiVar, arrayListZzb);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to get conditional properties; remote exception", str2, str, e10);
        } finally {
            zzlaVar.zzq().zza(zzdiVar, arrayList);
        }
    }
}
