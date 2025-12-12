package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzhp implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zziw f8121b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ zzho f8122m;

    public zzhp(zzho zzhoVar, zziw zziwVar) {
        this.f8121b = zziwVar;
        this.f8122m = zzhoVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        zzho zzhoVar = this.f8122m;
        zzhoVar.zzl().zzt();
        zzaz zzazVar = new zzaz(zzhoVar);
        zzazVar.zzad();
        zzhoVar.f8116v = zzazVar;
        zziw zziwVar = this.f8121b;
        zzfv zzfvVar = new zzfv(zzhoVar, zziwVar.f8223f);
        zzfvVar.zzv();
        zzhoVar.f8117w = zzfvVar;
        zzfu zzfuVar = new zzfu(zzhoVar);
        zzfuVar.zzv();
        zzhoVar.f8114t = zzfuVar;
        zzla zzlaVar = new zzla(zzhoVar);
        zzlaVar.zzv();
        zzhoVar.f8115u = zzlaVar;
        zzhoVar.f8106l.zzae();
        zzhoVar.f8102h.zzae();
        zzhoVar.f8117w.zzw();
        zzhoVar.zzj().zzn().zza("App measurement initialized, version", 87000L);
        zzhoVar.zzj().zzn().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strA = zzfvVar.a();
        if (TextUtils.isEmpty(zzhoVar.f8096b)) {
            if (zzhoVar.zzt().J(strA, zzhoVar.f8101g.zzp())) {
                zzhoVar.zzj().zzn().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzhoVar.zzj().zzn().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strA);
            }
        }
        zzhoVar.zzj().zzc().zza("Debug-level message logging enabled");
        int i10 = zzhoVar.E;
        AtomicInteger atomicInteger = zzhoVar.G;
        if (i10 != atomicInteger.get()) {
            zzhoVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzhoVar.E), Integer.valueOf(atomicInteger.get()));
        }
        zzhoVar.f8118x = true;
        zzhoVar.zza(zziwVar.f8224g);
    }
}
