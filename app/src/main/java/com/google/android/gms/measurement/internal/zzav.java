package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
abstract class zzav {

    /* renamed from: d, reason: collision with root package name */
    public static volatile com.google.android.gms.internal.measurement.zzdc f7682d;

    /* renamed from: a, reason: collision with root package name */
    public final zzio f7683a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f7684b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f7685c;

    public zzav(zzio zzioVar) {
        Preconditions.checkNotNull(zzioVar);
        this.f7683a = zzioVar;
        this.f7684b = new zzau(this, zzioVar);
    }

    public final void a() {
        this.f7685c = 0L;
        b().removeCallbacks(this.f7684b);
    }

    public final Handler b() {
        com.google.android.gms.internal.measurement.zzdc zzdcVar;
        if (f7682d != null) {
            return f7682d;
        }
        synchronized (zzav.class) {
            if (f7682d == null) {
                f7682d = new com.google.android.gms.internal.measurement.zzdc(this.f7683a.zza().getMainLooper());
            }
            zzdcVar = f7682d;
        }
        return zzdcVar;
    }

    public final void zza(long j10) {
        a();
        if (j10 >= 0) {
            this.f7685c = this.f7683a.zzb().currentTimeMillis();
            if (b().postDelayed(this.f7684b, j10)) {
                return;
            }
            this.f7683a.zzj().zzg().zza("Failed to schedule delayed post. time", Long.valueOf(j10));
        }
    }

    public abstract void zzb();

    public final boolean zzc() {
        return this.f7685c != 0;
    }
}
