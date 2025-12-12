package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzbm implements SessionManagerListener {
    final /* synthetic */ zzbn zza;

    public /* synthetic */ zzbm(zzbn zzbnVar, zzbl zzblVar) {
        this.zza = zzbnVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnded(Session session, int i10) {
        zzbn.zza.d("onSessionEnded with error = %d", Integer.valueOf(i10));
        zzbn.zzg(this.zza);
        zzbn zzbnVar = this.zza;
        if (zzbnVar.zzf == 2) {
            return;
        }
        zzbnVar.zzq();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnding(Session session) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i10) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z10) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i10) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        zzbn.zza.d("onSessionStarted with transferType = %d", Integer.valueOf(this.zza.zzf));
        if (this.zza.zzb.zzg()) {
            zzbn zzbnVar = this.zza;
            if (zzbnVar.zzf == 2) {
                zzbn.zzi(zzbnVar);
            }
        }
        this.zza.zzq();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i10) {
    }
}
