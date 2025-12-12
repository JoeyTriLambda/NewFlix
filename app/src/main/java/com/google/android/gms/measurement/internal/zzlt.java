package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlt implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8444b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f8445m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzac f8446n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzla f8447o;

    public zzlt(zzla zzlaVar, zzn zznVar, boolean z10, zzac zzacVar, zzac zzacVar2) {
        this.f8444b = zznVar;
        this.f8445m = z10;
        this.f8446n = zzacVar;
        this.f8447o = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzla zzlaVar = this.f8447o;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        zzn zznVar = this.f8444b;
        Preconditions.checkNotNull(zznVar);
        zzlaVar.a(zzfqVar, this.f8445m ? null : this.f8446n, zznVar);
        zzlaVar.zzam();
    }
}
