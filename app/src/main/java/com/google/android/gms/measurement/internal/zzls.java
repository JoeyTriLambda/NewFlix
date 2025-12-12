package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzls implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8438b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8439m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8440n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f8441o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzn f8442p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zzla f8443q;

    public zzls(zzla zzlaVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar) {
        this.f8438b = atomicReference;
        this.f8439m = str;
        this.f8440n = str2;
        this.f8441o = str3;
        this.f8442p = zznVar;
        this.f8443q = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzla zzlaVar;
        zzfq zzfqVar;
        synchronized (this.f8438b) {
            try {
                try {
                    zzlaVar = this.f8443q;
                    zzfqVar = zzlaVar.f8386d;
                } catch (RemoteException e10) {
                    this.f8443q.zzj().zzg().zza("(legacy) Failed to get conditional properties; remote exception", zzgb.zza(this.f8439m), this.f8440n, e10);
                    this.f8438b.set(Collections.emptyList());
                }
                if (zzfqVar == null) {
                    zzlaVar.zzj().zzg().zza("(legacy) Failed to get conditional properties; not connected to service", zzgb.zza(this.f8439m), this.f8440n, this.f8441o);
                    this.f8438b.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f8439m)) {
                    Preconditions.checkNotNull(this.f8442p);
                    this.f8438b.set(zzfqVar.zza(this.f8440n, this.f8441o, this.f8442p));
                } else {
                    this.f8438b.set(zzfqVar.zza(this.f8439m, this.f8440n, this.f8441o));
                }
                this.f8443q.zzam();
                this.f8438b.notify();
            } finally {
                this.f8438b.notify();
            }
        }
    }
}
