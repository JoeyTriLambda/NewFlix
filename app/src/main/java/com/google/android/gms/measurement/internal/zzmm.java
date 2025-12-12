package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzqe;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmm implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final long f8501b;

    /* renamed from: m, reason: collision with root package name */
    public final long f8502m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ zzmn f8503n;

    public zzmm(zzmn zzmnVar, long j10, long j11) {
        this.f8503n = zzmnVar;
        this.f8501b = j10;
        this.f8502m = j11;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        this.f8503n.f8505b.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzmp
            @Override // java.lang.Runnable
            public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                zzmm zzmmVar = this.f8510b;
                zzmn zzmnVar = zzmmVar.f8503n;
                long j10 = zzmmVar.f8501b;
                zzmnVar.f8505b.zzt();
                zzmi zzmiVar = zzmnVar.f8505b;
                zzmiVar.zzj().zzc().zza("Application going to the background");
                zzmiVar.zzk().f8009t.zza(true);
                zzmiVar.zzt();
                zzmiVar.f8493d = true;
                if (!zzmiVar.zze().zzv()) {
                    zzmiVar.f8495f.f8508c.a();
                    zzmiVar.zza(false, false, zzmmVar.f8502m);
                }
                if (zzqe.zza() && zzmiVar.zze().zza(zzbh.D0)) {
                    zzmiVar.zzj().zzn().zza("Application backgrounded at: timestamp_millis", Long.valueOf(j10));
                } else {
                    zzmiVar.zzm().i("auto", "_ab", new Bundle(), j10);
                }
            }
        });
    }
}
