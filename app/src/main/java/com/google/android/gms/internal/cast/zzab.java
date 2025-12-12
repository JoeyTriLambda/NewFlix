package com.google.android.gms.internal.cast;

import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzab {
    final int zza;
    final long zzb = DefaultClock.getInstance().currentTimeMillis();
    private long zzc;

    public zzab(zzaa zzaaVar) {
        this.zza = zzaaVar.zza;
    }

    public final zzny zza() {
        zznx zznxVarZza = zzny.zza();
        zznxVarZza.zza((int) (this.zzb - this.zzc));
        int i10 = this.zza;
        zznxVarZza.zzb(i10 != 1 ? i10 != 2 ? i10 != 3 ? 1 : 4 : 3 : 2);
        return (zzny) zznxVarZza.zzq();
    }

    public final void zzb(long j10) {
        this.zzc = j10;
    }
}
