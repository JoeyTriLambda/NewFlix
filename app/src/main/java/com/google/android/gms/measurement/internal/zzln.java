package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzln implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8421b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f8422m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzla f8423n;

    public zzln(zzla zzlaVar, zzn zznVar, Bundle bundle) {
        this.f8421b = zznVar;
        this.f8422m = bundle;
        this.f8423n = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzn zznVar = this.f8421b;
        zzla zzlaVar = this.f8423n;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zznVar);
            zzfqVar.zza(this.f8422m, zznVar);
        } catch (RemoteException e10) {
            zzlaVar.zzj().zzg().zza("Failed to send default event parameters to service", e10);
        }
    }
}
