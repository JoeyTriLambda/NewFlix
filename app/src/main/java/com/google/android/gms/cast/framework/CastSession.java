package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.zzbt;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class CastSession extends Session {

    /* renamed from: n, reason: collision with root package name */
    public static final Logger f6377n = new Logger("CastSession");

    /* renamed from: c, reason: collision with root package name */
    public final Context f6378c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f6379d;

    /* renamed from: e, reason: collision with root package name */
    public final zzam f6380e;

    /* renamed from: f, reason: collision with root package name */
    public final CastOptions f6381f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.zzbf f6382g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.gms.cast.framework.media.internal.zzv f6383h;

    /* renamed from: i, reason: collision with root package name */
    public com.google.android.gms.cast.zzr f6384i;

    /* renamed from: j, reason: collision with root package name */
    public RemoteMediaClient f6385j;

    /* renamed from: k, reason: collision with root package name */
    public CastDevice f6386k;

    /* renamed from: l, reason: collision with root package name */
    public Cast.ApplicationConnectionResult f6387l;

    /* renamed from: m, reason: collision with root package name */
    public zzs f6388m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastSession(Context context, String str, String str2, CastOptions castOptions, com.google.android.gms.internal.cast.zzbf zzbfVar, com.google.android.gms.cast.framework.media.internal.zzv zzvVar) {
        super(context, str, str2);
        int i10 = zzo.f6794a;
        this.f6379d = new HashSet();
        this.f6378c = context.getApplicationContext();
        this.f6381f = castOptions;
        this.f6382g = zzbfVar;
        this.f6383h = zzvVar;
        this.f6380e = com.google.android.gms.internal.cast.zzag.zzb(context, castOptions, zzn(), new zzw(this));
    }

    public static /* bridge */ /* synthetic */ void a(CastSession castSession, String str, Task task) {
        Logger logger = f6377n;
        if (castSession.f6380e == null) {
            return;
        }
        try {
            boolean zIsSuccessful = task.isSuccessful();
            zzam zzamVar = castSession.f6380e;
            if (zIsSuccessful) {
                Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                castSession.f6387l = applicationConnectionResult;
                if (applicationConnectionResult.getStatus() != null && applicationConnectionResult.getStatus().isSuccess()) {
                    logger.d("%s() -> success result", str);
                    RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new com.google.android.gms.cast.internal.zzaq(null));
                    castSession.f6385j = remoteMediaClient;
                    remoteMediaClient.zzs(castSession.f6384i);
                    castSession.f6385j.registerCallback(new zzr(castSession));
                    castSession.f6385j.zzq();
                    castSession.f6383h.zzh(castSession.f6385j, castSession.getCastDevice());
                    zzamVar.zzf((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                    return;
                }
                if (applicationConnectionResult.getStatus() != null) {
                    logger.d("%s() -> failure result", str);
                    zzamVar.zzg(applicationConnectionResult.getStatus().getStatusCode());
                    return;
                }
            } else {
                Exception exception = task.getException();
                if (exception instanceof ApiException) {
                    zzamVar.zzg(((ApiException) exception).getStatusCode());
                    return;
                }
            }
            zzamVar.zzg(2476);
        } catch (RemoteException e10) {
            logger.d(e10, "Unable to call %s on %s.", "methods", "zzam");
        }
    }

    public void addCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.f6379d.add(listener);
        }
    }

    public final void b(Bundle bundle) {
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.f6386k = fromBundle;
        if (fromBundle == null) {
            if (isResuming()) {
                notifyFailedToResumeSession(2153);
                return;
            } else {
                notifyFailedToStartSession(2151);
                return;
            }
        }
        com.google.android.gms.cast.zzr zzrVar = this.f6384i;
        if (zzrVar != null) {
            zzrVar.zzf();
            this.f6384i = null;
        }
        f6377n.d("Acquiring a connection to Google Play Services for %s", this.f6386k);
        CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.f6386k);
        Bundle bundle2 = new Bundle();
        CastOptions castOptions = this.f6381f;
        CastMediaOptions castMediaOptions = castOptions == null ? null : castOptions.getCastMediaOptions();
        NotificationOptions notificationOptions = castMediaOptions != null ? castMediaOptions.getNotificationOptions() : null;
        boolean z10 = castMediaOptions != null && castMediaOptions.zza();
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", notificationOptions != null);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z10);
        bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", this.f6382g.zzs());
        Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzy(this));
        builder.zzc(bundle2);
        com.google.android.gms.cast.zzr zzrVarZza = Cast.zza(this.f6378c, builder.build());
        zzrVarZza.zzk(new zzaa(this));
        this.f6384i = zzrVarZza;
        zzrVarZza.zze();
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void end(boolean z10) {
        zzam zzamVar = this.f6380e;
        if (zzamVar != null) {
            try {
                zzamVar.zze(z10, 0);
            } catch (RemoteException e10) {
                f6377n.d(e10, "Unable to call %s on %s.", "disconnectFromDevice", "zzam");
            }
            notifySessionEnded(0);
        }
    }

    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6386k;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.f6385j;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.f6385j;
        if (remoteMediaClient == null) {
            return 0L;
        }
        return remoteMediaClient.getStreamDuration() - this.f6385j.getApproximateStreamPosition();
    }

    public boolean isMute() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.f6384i;
        return zzrVar != null && zzrVar.zzl() && zzrVar.zzm();
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void onResuming(Bundle bundle) {
        this.f6386k = CastDevice.getFromBundle(bundle);
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void onStarting(Bundle bundle) {
        this.f6386k = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.f6379d.remove(listener);
        }
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void resume(Bundle bundle) {
        b(bundle);
    }

    public void setMute(final boolean z10) throws IllegalStateException, IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        com.google.android.gms.cast.zzr zzrVar = this.f6384i;
        if (zzrVar == null || !zzrVar.zzl()) {
            return;
        }
        final zzbt zzbtVar = (zzbt) zzrVar;
        zzbtVar.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.cast.zzbc
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) throws RemoteException {
                zzbt zzbtVar2 = zzbtVar;
                zzbtVar2.getClass();
                ((com.google.android.gms.cast.internal.zzag) ((com.google.android.gms.cast.internal.zzx) obj).getService()).zzn(z10, zzbtVar2.f6988u, zzbtVar2.f6989v);
                ((TaskCompletionSource) obj2).setResult(null);
            }
        }).setMethodKey(8412).build());
    }

    @Override // com.google.android.gms.cast.framework.Session
    public void start(Bundle bundle) {
        b(bundle);
    }

    public final void zzj(zzs zzsVar) {
        this.f6388m = zzsVar;
    }

    @Override // com.google.android.gms.cast.framework.Session
    public final void zzk(Bundle bundle) {
        CastDevice castDevice;
        CastDevice castDevice2;
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        if (fromBundle == null || fromBundle.equals(this.f6386k)) {
            return;
        }
        boolean z10 = !TextUtils.isEmpty(fromBundle.getFriendlyName()) && ((castDevice2 = this.f6386k) == null || !TextUtils.equals(castDevice2.getFriendlyName(), fromBundle.getFriendlyName()));
        this.f6386k = fromBundle;
        Logger logger = f6377n;
        Object[] objArr = new Object[2];
        objArr[0] = fromBundle;
        objArr[1] = true != z10 ? "unchanged" : "changed";
        logger.d("update to device (%s) with name %s", objArr);
        if (!z10 || (castDevice = this.f6386k) == null) {
            return;
        }
        com.google.android.gms.cast.framework.media.internal.zzv zzvVar = this.f6383h;
        if (zzvVar != null) {
            zzvVar.zzk(castDevice);
        }
        Iterator it = new HashSet(this.f6379d).iterator();
        while (it.hasNext()) {
            ((Cast.Listener) it.next()).onDeviceNameChanged();
        }
    }

    public final boolean zzl() {
        return this.f6382g.zzs();
    }
}
