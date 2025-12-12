package com.google.android.gms.internal.cast;

import e8.c;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzrz extends zzrp implements ScheduledFuture {
    private final ScheduledFuture zza;

    public zzrz(c cVar, ScheduledFuture scheduledFuture) {
        super(cVar);
        this.zza = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.cast.zzro, java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        boolean zCancel = zzb().cancel(z10);
        if (zCancel) {
            this.zza.cancel(z10);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.zza.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zza.getDelay(timeUnit);
    }
}
