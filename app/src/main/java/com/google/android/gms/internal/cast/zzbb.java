package com.google.android.gms.internal.cast;

import a2.n;
import android.os.Handler;
import android.os.Looper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import e8.c;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzbb implements n.d {
    private static final Logger zza = new Logger("MediaRouterOPTListener");
    private final zzbn zzb;
    private final Handler zzc = new zzed(Looper.getMainLooper());

    public zzbb(zzbn zzbnVar) {
        this.zzb = (zzbn) Preconditions.checkNotNull(zzbnVar);
    }

    @Override // a2.n.d
    public final c onPrepareTransfer(final n.g gVar, final n.g gVar2) {
        zza.d("Prepare transfer from Route(%s) to Route(%s)", gVar, gVar2);
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.b() { // from class: com.google.android.gms.internal.cast.zzaz
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
                return this.zza.zza(gVar, gVar2, aVar);
            }
        });
    }

    public final /* synthetic */ Object zza(final n.g gVar, final n.g gVar2, final CallbackToFutureAdapter.a aVar) throws Exception {
        return Boolean.valueOf(this.zzc.post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzba
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(gVar, gVar2, aVar);
            }
        }));
    }

    public final /* synthetic */ void zzb(n.g gVar, n.g gVar2, CallbackToFutureAdapter.a aVar) {
        this.zzb.zzl(gVar, gVar2, aVar);
    }
}
