package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzi implements SessionManagerListener {
    final /* synthetic */ zzk zza;

    public zzi(zzk zzkVar) {
        this.zza = zzkVar;
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionEnded(Session session, int i10) {
        this.zza.zzi = (CastSession) session;
        zzk.zzm(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* synthetic */ void onSessionEnding(Session session) {
        this.zza.zzi = (CastSession) session;
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i10) {
        this.zza.zzi = (CastSession) session;
        zzk.zzm(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z10) {
        zzk.zza.d("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z10));
        this.zza.zzi = (CastSession) session;
        this.zza.zzs();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zzb(zzkVar.zzh, z10), 227);
        zzk zzkVar2 = this.zza;
        zzkVar2.zzh.zzc(zzkVar2.zzg);
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        zzk.zza.d("onSessionResuming with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        zzk zzkVar = this.zza;
        zzk.zzn(zzkVar, zzkVar.zzg, str);
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzkVar2 = this.zza;
        this.zza.zzb.zze(zzkVar2.zzd.zzc(zzkVar2.zzh), 226);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i10) {
        this.zza.zzi = (CastSession) session;
        zzk.zzm(this.zza, i10);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        zzk.zza.d("onSessionStarted with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        this.zza.zzs();
        zzk zzkVar = this.zza;
        zzkVar.zzh.zzf = str;
        this.zza.zzb.zze(zzkVar.zzd.zza(zzkVar.zzh), 222);
        zzk zzkVar2 = this.zza;
        zzkVar2.zzh.zzc(zzkVar2.zzg);
        this.zza.zzu();
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        zzk.zza.d("onSessionStarting", new Object[0]);
        this.zza.zzi = (CastSession) session;
        if (this.zza.zzh != null) {
            zzk.zza.w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzt();
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zzd(zzkVar.zzh), 221);
    }

    @Override // com.google.android.gms.cast.framework.SessionManagerListener
    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i10) {
        zzk.zza.d("onSessionSuspended with reason = %d", Integer.valueOf(i10));
        this.zza.zzi = (CastSession) session;
        this.zza.zzs();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzkVar = this.zza;
        this.zza.zzb.zze(zzkVar.zzd.zze(zzkVar.zzh, i10), 225);
        zzk zzkVar2 = this.zza;
        zzkVar2.zzh.zzc(zzkVar2.zzg);
        this.zza.zzr();
    }
}
