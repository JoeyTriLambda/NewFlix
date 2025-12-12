package com.google.android.gms.cast;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzdn implements com.google.android.gms.cast.internal.zzas {
    @Override // com.google.android.gms.cast.internal.zzas
    public final void zza(String str, long j10, int i10, Object obj, long j11, long j12) {
        try {
            Status status = new Status(i10);
            if (true != (obj instanceof com.google.android.gms.cast.internal.zzap)) {
                obj = null;
            }
            if (obj != null) {
            }
            new zzdq(status);
            throw null;
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestCompleted", e10);
        }
    }

    @Override // com.google.android.gms.cast.internal.zzas
    public final void zzb(String str, long j10, long j11, long j12) {
        try {
            new zzdo(new Status(2103));
            throw null;
        } catch (IllegalStateException e10) {
            Log.e("RemoteMediaPlayer", "Result already set when calling onRequestReplaced", e10);
        }
    }
}
