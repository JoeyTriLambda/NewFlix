package com.google.android.gms.cast;

import a2.n;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzed;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@TargetApi(19)
@Deprecated
/* loaded from: classes.dex */
public abstract class CastRemoteDisplayLocalService extends Service {

    /* renamed from: w, reason: collision with root package name */
    public static final Logger f6164w = new Logger("CastRDLocalService");

    /* renamed from: x, reason: collision with root package name */
    public static final Object f6165x = new Object();

    /* renamed from: y, reason: collision with root package name */
    public static final AtomicBoolean f6166y = new AtomicBoolean(false);

    /* renamed from: z, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static CastRemoteDisplayLocalService f6167z;

    /* renamed from: b, reason: collision with root package name */
    public String f6168b;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference f6169m;

    /* renamed from: n, reason: collision with root package name */
    public CastDevice f6170n;

    /* renamed from: o, reason: collision with root package name */
    public Context f6171o;

    /* renamed from: p, reason: collision with root package name */
    public ServiceConnection f6172p;

    /* renamed from: q, reason: collision with root package name */
    public zzed f6173q;

    /* renamed from: r, reason: collision with root package name */
    public n f6174r;

    /* renamed from: t, reason: collision with root package name */
    public CastRemoteDisplayClient f6176t;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6175s = false;

    /* renamed from: u, reason: collision with root package name */
    public final n.a f6177u = new zzag(this);

    /* renamed from: v, reason: collision with root package name */
    public final IBinder f6178v = new zzao(this);

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public interface Callbacks {
        void onRemoteDisplaySessionEnded(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onRemoteDisplaySessionError(Status status);
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static final class NotificationSettings {

        /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
        public static final class Builder {
        }

        private NotificationSettings() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Options {
    }

    public static void b() {
        Logger logger = f6164w;
        logger.d("Stopping Service", new Object[0]);
        f6166y.set(false);
        synchronized (f6165x) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = f6167z;
            if (castRemoteDisplayLocalService == null) {
                logger.e("Service is already being stopped", new Object[0]);
                return;
            }
            f6167z = null;
            if (castRemoteDisplayLocalService.f6173q != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    castRemoteDisplayLocalService.f6173q.post(new zzaj(castRemoteDisplayLocalService));
                } else {
                    castRemoteDisplayLocalService.c(false);
                }
            }
        }
    }

    public static void stopService() {
        b();
    }

    public final void a(String str) {
        f6164w.d("[Instance: %s] %s", this, str);
    }

    public final void c(boolean z10) {
        a("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if (!z10 && this.f6174r != null) {
            a("Setting default route");
            n nVar = this.f6174r;
            nVar.selectRoute(nVar.getDefaultRoute());
        }
        a("stopRemoteDisplaySession");
        a("stopRemoteDisplay");
        this.f6176t.stopRemoteDisplay().addOnCompleteListener(new zzan(this));
        Callbacks callbacks = (Callbacks) this.f6169m.get();
        if (callbacks != null) {
            callbacks.onRemoteDisplaySessionEnded(this);
        }
        onDismissPresentation();
        a("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
        if (this.f6174r != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            a("removeMediaRouterCallback");
            this.f6174r.removeCallback(this.f6177u);
        }
        Context context = this.f6171o;
        ServiceConnection serviceConnection = this.f6172p;
        if (context != null && serviceConnection != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context, serviceConnection);
            } catch (IllegalArgumentException unused) {
                a("No need to unbind service, already unbound");
            }
        }
        this.f6172p = null;
        this.f6171o = null;
        this.f6168b = null;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a("onBind");
        return this.f6178v;
    }

    @Override // android.app.Service
    public void onCreate() {
        a("onCreate");
        super.onCreate();
        zzed zzedVar = new zzed(getMainLooper());
        this.f6173q = zzedVar;
        zzedVar.postDelayed(new zzah(this), 100L);
        if (this.f6176t == null) {
            this.f6176t = CastRemoteDisplay.getClient(this);
        }
        if (PlatformVersion.isAtLeastO()) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            NotificationChannel notificationChannel = new NotificationChannel("cast_remote_display_local_service", getString(R.string.cast_notification_default_channel_name), 2);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public abstract void onDismissPresentation();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        a("onStartCommand");
        this.f6175s = true;
        return 2;
    }
}
