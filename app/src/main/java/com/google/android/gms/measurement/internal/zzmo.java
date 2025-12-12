package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzpa;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzmo {

    /* renamed from: a, reason: collision with root package name */
    public long f8506a;

    /* renamed from: b, reason: collision with root package name */
    public long f8507b;

    /* renamed from: c, reason: collision with root package name */
    public final zzmr f8508c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzmi f8509d;

    public zzmo(zzmi zzmiVar) {
        this.f8509d = zzmiVar;
        this.f8508c = new zzmr(this, zzmiVar.f8189a);
        long jElapsedRealtime = zzmiVar.zzb().elapsedRealtime();
        this.f8506a = jElapsedRealtime;
        this.f8507b = jElapsedRealtime;
    }

    public final boolean zza(boolean z10, boolean z11, long j10) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        zzmi zzmiVar = this.f8509d;
        zzmiVar.zzt();
        zzmiVar.zzu();
        if (!zzpa.zza() || !zzmiVar.zze().zza(zzbh.f7752m0) || zzmiVar.f8189a.zzac()) {
            zzmiVar.zzk().f8006q.zza(zzmiVar.zzb().currentTimeMillis());
        }
        long j11 = j10 - this.f8506a;
        if (!z10 && j11 < 1000) {
            zzmiVar.zzj().zzp().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j11));
            return false;
        }
        if (!z11) {
            j11 = j10 - this.f8507b;
            this.f8507b = j10;
        }
        zzmiVar.zzj().zzp().zza("Recording user engagement, ms", Long.valueOf(j11));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j11);
        zznt.zza(zzmiVar.zzn().zza(!zzmiVar.zze().zzv()), bundle, true);
        if (!z11) {
            zzmiVar.zzm().o("auto", "_e", bundle);
        }
        this.f8506a = j10;
        zzmr zzmrVar = this.f8508c;
        zzmrVar.a();
        zzmrVar.zza(DateUtils.MILLIS_PER_HOUR);
        return true;
    }
}
