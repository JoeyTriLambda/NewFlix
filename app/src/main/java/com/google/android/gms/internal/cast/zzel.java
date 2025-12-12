package com.google.android.gms.internal.cast;

import android.os.Handler;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzel extends zzen {
    private final Handler zza;

    public zzel(Looper looper) {
        this.zza = new Handler(looper);
    }

    @Override // com.google.android.gms.internal.cast.zzen
    public final void zza(zzek zzekVar) {
        this.zza.postDelayed(zzekVar.zzc(), 0L);
    }
}
