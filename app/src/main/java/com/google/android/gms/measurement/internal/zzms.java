package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzms {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f8513a;

    /* renamed from: b, reason: collision with root package name */
    public long f8514b;

    public zzms(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.f8513a = clock;
    }

    public final void zza() {
        this.f8514b = 0L;
    }

    public final void zzb() {
        this.f8514b = this.f8513a.elapsedRealtime();
    }

    public final boolean zza(long j10) {
        return this.f8514b == 0 || this.f8513a.elapsedRealtime() - this.f8514b >= DateUtils.MILLIS_PER_HOUR;
    }
}
