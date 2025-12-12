package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzqk;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmq {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzmi f8511a;

    public zzmq(zzmi zzmiVar) {
        this.f8511a = zzmiVar;
    }

    public final void a() {
        zzmi zzmiVar = this.f8511a;
        zzmiVar.zzt();
        if (zzmiVar.zzk().a(zzmiVar.zzb().currentTimeMillis())) {
            zzmiVar.zzk().f8002m.zza(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzmiVar.zzj().zzp().zza("Detected application was in foreground");
                c(zzmiVar.zzb().currentTimeMillis());
            }
        }
    }

    public final void b(long j10, boolean z10) {
        zzmi zzmiVar = this.f8511a;
        zzmiVar.zzt();
        zzmiVar.a();
        if (zzmiVar.zzk().a(j10)) {
            zzmiVar.zzk().f8002m.zza(true);
            if (zzqk.zza() && zzmiVar.zze().zza(zzbh.f7762r0)) {
                zzmiVar.zzg().zzag();
            }
        }
        zzmiVar.zzk().f8006q.zza(j10);
        if (zzmiVar.zzk().f8002m.zza()) {
            c(j10);
        }
    }

    public final void c(long j10) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzmi zzmiVar = this.f8511a;
        zzmiVar.zzt();
        if (zzmiVar.f8189a.zzac()) {
            zzmiVar.zzk().f8006q.zza(j10);
            zzmiVar.zzj().zzp().zza("Session started, time", Long.valueOf(zzmiVar.zzb().elapsedRealtime()));
            Long lValueOf = Long.valueOf(j10 / 1000);
            zzmiVar.zzm().j("auto", "_sid", lValueOf, j10);
            zzmiVar.zzk().f8007r.zza(lValueOf.longValue());
            zzmiVar.zzk().f8002m.zza(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            zzmiVar.zzm().i("auto", "_s", bundle, j10);
            String strZza = zzmiVar.zzk().f8012w.zza();
            if (TextUtils.isEmpty(strZza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strZza);
            zzmiVar.zzm().i("auto", "_ssr", bundle2, j10);
        }
    }
}
