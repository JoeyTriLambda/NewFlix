package com.google.android.gms.internal.cast;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzsd extends zzrw {
    final /* synthetic */ zzse zza;
    private final Callable zzb;

    public zzsd(zzse zzseVar, Callable callable) {
        this.zza = zzseVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.android.gms.internal.cast.zzrw
    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.android.gms.internal.cast.zzrw
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.cast.zzrw
    public final void zzc(Throwable th2) {
        this.zza.zzl(th2);
    }

    @Override // com.google.android.gms.internal.cast.zzrw
    public final void zzd(Object obj) {
        this.zza.zzk(obj);
    }

    @Override // com.google.android.gms.internal.cast.zzrw
    public final boolean zzf() {
        return this.zza.isDone();
    }
}
