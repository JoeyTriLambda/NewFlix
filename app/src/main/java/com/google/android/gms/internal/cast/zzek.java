package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.view.Choreographer;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public abstract class zzek {
    private Runnable zza;
    private Choreographer.FrameCallback zzb;

    public abstract void zza(long j10);

    @TargetApi(16)
    public final Choreographer.FrameCallback zzb() {
        if (this.zzb == null) {
            this.zzb = new Choreographer.FrameCallback() { // from class: com.google.android.gms.internal.cast.zzei
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    this.zza.zza(j10);
                }
            };
        }
        return this.zzb;
    }

    public final Runnable zzc() {
        if (this.zza == null) {
            this.zza = new Runnable() { // from class: com.google.android.gms.internal.cast.zzej
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(System.nanoTime());
                }
            };
        }
        return this.zza;
    }
}
