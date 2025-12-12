package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzlq implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f8430b = true;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzn f8431m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f8432n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ zzbf f8433o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f8434p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zzla f8435q;

    public zzlq(zzla zzlaVar, zzn zznVar, boolean z10, zzbf zzbfVar, String str) {
        this.f8431m = zznVar;
        this.f8432n = z10;
        this.f8433o = zzbfVar;
        this.f8434p = str;
        this.f8435q = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        String str = this.f8434p;
        zzla zzlaVar = this.f8435q;
        zzfq zzfqVar = zzlaVar.f8386d;
        if (zzfqVar == null) {
            zzlaVar.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        boolean z10 = this.f8430b;
        zzbf zzbfVar = this.f8433o;
        zzn zznVar = this.f8431m;
        if (z10) {
            Preconditions.checkNotNull(zznVar);
            if (this.f8432n) {
                zzbfVar = null;
            }
            zzlaVar.a(zzfqVar, zzbfVar, zznVar);
        } else {
            try {
                if (TextUtils.isEmpty(str)) {
                    Preconditions.checkNotNull(zznVar);
                    zzfqVar.zza(zzbfVar, zznVar);
                } else {
                    zzfqVar.zza(zzbfVar, str, zzlaVar.zzj().zzx());
                }
            } catch (RemoteException e10) {
                zzlaVar.zzj().zzg().zza("Failed to send event to the service", e10);
            }
        }
        zzlaVar.zzam();
    }
}
