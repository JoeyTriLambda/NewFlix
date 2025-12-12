package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzle implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8400b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8401m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Bundle f8402n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzla f8403o;

    public zzle(zzla zzlaVar, AtomicReference atomicReference, zzn zznVar, Bundle bundle) {
        this.f8400b = atomicReference;
        this.f8401m = zznVar;
        this.f8402n = bundle;
        this.f8403o = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzla zzlaVar;
        zzfq zzfqVar;
        synchronized (this.f8400b) {
            try {
                try {
                    zzlaVar = this.f8403o;
                    zzfqVar = zzlaVar.f8386d;
                } finally {
                    this.f8400b.notify();
                }
            } catch (RemoteException e10) {
                this.f8403o.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e10);
            }
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(this.f8401m);
            this.f8400b.set(zzfqVar.zza(this.f8401m, this.f8402n));
            this.f8403o.zzam();
            this.f8400b.notify();
        }
    }
}
