package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlh implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzn f8406b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f8407m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzno f8408n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzla f8409o;

    public zzlh(zzla zzlaVar, zzn zznVar, boolean z10, zzno zznoVar) {
        this.f8406b = zznVar;
        this.f8407m = z10;
        this.f8408n = zznoVar;
        this.f8409o = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzla zzlaVar = this.f8409o;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        zzn zznVar = this.f8406b;
        Preconditions.checkNotNull(zznVar);
        zzlaVar.a(zzfqVar, this.f8407m ? null : this.f8408n, zznVar);
        zzlaVar.zzam();
    }
}
