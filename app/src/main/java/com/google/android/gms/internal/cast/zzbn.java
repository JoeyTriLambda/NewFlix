package com.google.android.gms.internal.cast;

import a2.n;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionTransferCallback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
@TargetApi(30)
/* loaded from: classes.dex */
public final class zzbn {
    private static final Logger zza = new Logger("SessionTransController");
    private final CastOptions zzb;
    private SessionManager zzg;
    private CallbackToFutureAdapter.a zzh;
    private SessionState zzi;
    private final Set zzc = Collections.synchronizedSet(new HashSet());
    private int zzf = 0;
    private final Handler zzd = new zzed(Looper.getMainLooper());
    private final Runnable zze = new Runnable() { // from class: com.google.android.gms.internal.cast.zzbj
        @Override // java.lang.Runnable
        public final void run() {
            zzbn.zze(this.zza);
        }
    };

    public zzbn(CastOptions castOptions) {
        this.zzb = castOptions;
    }

    public static /* synthetic */ void zze(zzbn zzbnVar) {
        zza.i("transfer with type = %d has timed out", Integer.valueOf(zzbnVar.zzf));
        zzbnVar.zzp(101);
    }

    public static /* synthetic */ void zzf(zzbn zzbnVar, SessionState sessionState) {
        zzbnVar.zzi = sessionState;
        CallbackToFutureAdapter.a aVar = zzbnVar.zzh;
        if (aVar != null) {
            aVar.set(null);
        }
    }

    public static /* bridge */ /* synthetic */ void zzg(zzbn zzbnVar) {
        int i10 = zzbnVar.zzf;
        if (i10 == 0) {
            zza.d("No need to notify transferred if the transfer type is unknown", new Object[0]);
            return;
        }
        SessionState sessionState = zzbnVar.zzi;
        if (sessionState == null) {
            zza.d("No need to notify with null sessionState", new Object[0]);
            return;
        }
        zza.d("notify transferred with type = %d, sessionState = %s", Integer.valueOf(i10), zzbnVar.zzi);
        Iterator it = new HashSet(zzbnVar.zzc).iterator();
        while (it.hasNext()) {
            ((SessionTransferCallback) it.next()).onTransferred(zzbnVar.zzf, sessionState);
        }
    }

    public static /* bridge */ /* synthetic */ void zzi(zzbn zzbnVar) {
        if (zzbnVar.zzi == null) {
            zza.d("skip restoring session state due to null SessionState", new Object[0]);
            return;
        }
        RemoteMediaClient remoteMediaClientZzo = zzbnVar.zzo();
        if (remoteMediaClientZzo == null) {
            zza.d("skip restoring session state due to null RemoteMediaClient", new Object[0]);
        } else {
            zza.d("resume SessionState to current session", new Object[0]);
            remoteMediaClientZzo.zzr(zzbnVar.zzi);
        }
    }

    private final RemoteMediaClient zzo() {
        SessionManager sessionManager = this.zzg;
        if (sessionManager == null) {
            zza.d("skip transferring as SessionManager is null", new Object[0]);
            return null;
        }
        CastSession currentCastSession = sessionManager.getCurrentCastSession();
        if (currentCastSession != null) {
            return currentCastSession.getRemoteMediaClient();
        }
        zza.d("skip transferring as CastSession is null", new Object[0]);
        return null;
    }

    private final void zzp(int i10) {
        CallbackToFutureAdapter.a aVar = this.zzh;
        if (aVar != null) {
            aVar.setCancelled();
        }
        zza.d("notify failed transfer with type = %d, reason = %d", Integer.valueOf(this.zzf), Integer.valueOf(i10));
        Iterator it = new HashSet(this.zzc).iterator();
        while (it.hasNext()) {
            ((SessionTransferCallback) it.next()).onTransferFailed(this.zzf, i10);
        }
        zzq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzq() {
        ((Handler) Preconditions.checkNotNull(this.zzd)).removeCallbacks((Runnable) Preconditions.checkNotNull(this.zze));
        this.zzf = 0;
        this.zzi = null;
    }

    public final void zzj(SessionManager sessionManager) {
        this.zzg = sessionManager;
        ((Handler) Preconditions.checkNotNull(this.zzd)).post(new Runnable() { // from class: com.google.android.gms.internal.cast.zzbk
            @Override // java.lang.Runnable
            public final void run() throws NullPointerException {
                zzbn zzbnVar = this.zza;
                ((SessionManager) Preconditions.checkNotNull(zzbnVar.zzg)).addSessionManagerListener(new zzbm(zzbnVar, null), CastSession.class);
            }
        });
    }

    public final /* synthetic */ void zzk(Exception exc) {
        zza.w(exc, "Fail to store SessionState", new Object[0]);
        zzp(100);
    }

    public final void zzl(n.g gVar, n.g gVar2, CallbackToFutureAdapter.a aVar) {
        int i10;
        if (new HashSet(this.zzc).isEmpty()) {
            zza.d("No need to prepare transfer without any callback", new Object[0]);
            aVar.set(null);
            return;
        }
        if (gVar.getPlaybackType() != 1) {
            zza.d("No need to prepare transfer when transferring from local", new Object[0]);
            aVar.set(null);
            return;
        }
        RemoteMediaClient remoteMediaClientZzo = zzo();
        if (remoteMediaClientZzo == null || !remoteMediaClientZzo.hasMediaSession()) {
            zza.d("No need to prepare transfer when there is no media session", new Object[0]);
            aVar.set(null);
            return;
        }
        Logger logger = zza;
        logger.d("Prepare route transfer for changing endpoint", new Object[0]);
        if (gVar2.getPlaybackType() == 0) {
            zzo.zzd(zzml.CAST_TRANSFER_TO_LOCAL_USED);
            i10 = 1;
        } else {
            i10 = CastDevice.getFromBundle(gVar2.getExtras()) == null ? 3 : 2;
        }
        this.zzf = i10;
        this.zzh = aVar;
        logger.d("notify transferring with type = %d", Integer.valueOf(i10));
        Iterator it = new HashSet(this.zzc).iterator();
        while (it.hasNext()) {
            ((SessionTransferCallback) it.next()).onTransferring(this.zzf);
        }
        this.zzi = null;
        remoteMediaClientZzo.zzk(null).addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.gms.internal.cast.zzbh
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                zzbn.zzf(this.zza, (SessionState) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.gms.internal.cast.zzbi
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                this.zza.zzk(exc);
            }
        });
        ((Handler) Preconditions.checkNotNull(this.zzd)).postDelayed((Runnable) Preconditions.checkNotNull(this.zze), 10000L);
    }

    public final void zzm(SessionTransferCallback sessionTransferCallback) {
        zza.d("register callback = %s", sessionTransferCallback);
        Preconditions.checkMainThread("Must be called from the main thread.");
        Preconditions.checkNotNull(sessionTransferCallback);
        this.zzc.add(sessionTransferCallback);
    }

    public final void zzn(SessionTransferCallback sessionTransferCallback) {
        zza.d("unregister callback = %s", sessionTransferCallback);
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sessionTransferCallback != null) {
            this.zzc.remove(sessionTransferCallback);
        }
    }
}
