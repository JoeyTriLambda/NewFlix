package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlj implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8413b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8414m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzla f8415n;

    public zzlj(zzla zzlaVar, AtomicReference atomicReference, zzn zznVar) {
        this.f8413b = atomicReference;
        this.f8414m = zznVar;
        this.f8415n = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8413b) {
            try {
                try {
                } catch (RemoteException e10) {
                    this.f8415n.zzj().zzg().zza("Failed to get app instance id", e10);
                }
                if (!this.f8415n.zzk().e().zzj()) {
                    this.f8415n.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                    this.f8415n.zzm().h(null);
                    this.f8415n.zzk().f7997h.zza(null);
                    this.f8413b.set(null);
                    return;
                }
                zzla zzlaVar = this.f8415n;
                zzfq zzfqVar = zzlaVar.f8386d;
                if (zzfqVar == null) {
                    zzlaVar.zzj().zzg().zza("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.f8414m);
                this.f8413b.set(zzfqVar.zzb(this.f8414m));
                String str = (String) this.f8413b.get();
                if (str != null) {
                    this.f8415n.zzm().h(str);
                    this.f8415n.zzk().f7997h.zza(str);
                }
                this.f8415n.zzam();
                this.f8413b.notify();
            } finally {
                this.f8413b.notify();
            }
        }
    }
}
