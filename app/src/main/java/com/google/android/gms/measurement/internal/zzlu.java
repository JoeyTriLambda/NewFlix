package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlu implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f8448b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8449m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f8450n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f8451o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ zzn f8452p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f8453q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ zzla f8454r;

    public zzlu(zzla zzlaVar, AtomicReference atomicReference, String str, String str2, String str3, zzn zznVar, boolean z10) {
        this.f8448b = atomicReference;
        this.f8449m = str;
        this.f8450n = str2;
        this.f8451o = str3;
        this.f8452p = zznVar;
        this.f8453q = z10;
        this.f8454r = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzla zzlaVar;
        zzfq zzfqVar;
        synchronized (this.f8448b) {
            try {
                try {
                    zzlaVar = this.f8454r;
                    zzfqVar = zzlaVar.f8386d;
                } finally {
                    this.f8448b.notify();
                }
            } catch (RemoteException e10) {
                this.f8454r.zzj().zzg().zza("(legacy) Failed to get user properties; remote exception", zzgb.zza(this.f8449m), this.f8450n, e10);
                this.f8448b.set(Collections.emptyList());
            }
            if (zzfqVar == null) {
                zzlaVar.zzj().zzg().zza("(legacy) Failed to get user properties; not connected to service", zzgb.zza(this.f8449m), this.f8450n, this.f8451o);
                this.f8448b.set(Collections.emptyList());
                return;
            }
            if (TextUtils.isEmpty(this.f8449m)) {
                Preconditions.checkNotNull(this.f8452p);
                this.f8448b.set(zzfqVar.zza(this.f8450n, this.f8451o, this.f8453q, this.f8452p));
            } else {
                this.f8448b.set(zzfqVar.zza(this.f8449m, this.f8450n, this.f8451o, this.f8453q));
            }
            this.f8454r.zzam();
            this.f8448b.notify();
        }
    }
}
