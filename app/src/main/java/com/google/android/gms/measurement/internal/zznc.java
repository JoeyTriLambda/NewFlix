package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zznc implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznd f8543b;

    public zznc(zznd zzndVar, zznn zznnVar) {
        this.f8543b = zzndVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zznd zzndVar = this.f8543b;
        zzndVar.zzl().zzt();
        zzndVar.f8554k = new zzgv(zzndVar);
        zzan zzanVar = new zzan(zzndVar);
        zzanVar.zzal();
        zzndVar.f8546c = zzanVar;
        zzndVar.zze().f7640d = (zzag) Preconditions.checkNotNull(zzndVar.f8544a);
        zzmd zzmdVar = new zzmd(zzndVar);
        zzmdVar.zzal();
        zzndVar.f8552i = zzmdVar;
        zzs zzsVar = new zzs(zzndVar);
        zzsVar.zzal();
        zzndVar.f8549f = zzsVar;
        zzkq zzkqVar = new zzkq(zzndVar);
        zzkqVar.zzal();
        zzndVar.f8551h = zzkqVar;
        zzmx zzmxVar = new zzmx(zzndVar);
        zzmxVar.zzal();
        zzndVar.f8548e = zzmxVar;
        zzndVar.f8547d = new zzgl(zzndVar);
        if (zzndVar.f8561r != zzndVar.f8562s) {
            zzndVar.zzj().zzg().zza("Not all upload components initialized", Integer.valueOf(zzndVar.f8561r), Integer.valueOf(zzndVar.f8562s));
        }
        zzndVar.f8556m = true;
        zzndVar.zzv();
    }
}
