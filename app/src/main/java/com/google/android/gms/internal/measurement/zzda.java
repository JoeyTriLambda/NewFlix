package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* loaded from: classes.dex */
final class zzda implements zzcv {
    @Override // com.google.android.gms.internal.measurement.zzcv
    public final Runnable zza(Runnable runnable) {
        return runnable;
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final <V> Callable<V> zza(Callable<V> callable) {
        return callable;
    }
}
