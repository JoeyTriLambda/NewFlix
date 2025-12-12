package com.google.android.gms.internal.cast;

import ac.c;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzse extends zzrm implements RunnableFuture {
    private volatile zzrw zzb;

    public zzse(Callable callable) {
        this.zzb = new zzsd(this, callable);
    }

    public static zzse zzn(Runnable runnable, Object obj) {
        return new zzse(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzrw zzrwVar = this.zzb;
        if (zzrwVar != null) {
            zzrwVar.run();
        }
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final String zze() {
        zzrw zzrwVar = this.zzb;
        return zzrwVar != null ? c.k("task=[", zzrwVar.toString(), "]") : super.zze();
    }

    @Override // com.google.android.gms.internal.cast.zzrg
    public final void zzj() {
        zzrw zzrwVar;
        if (zzm() && (zzrwVar = this.zzb) != null) {
            zzrwVar.zze();
        }
        this.zzb = null;
    }
}
