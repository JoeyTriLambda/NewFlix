package com.google.android.gms.ads.identifier;

import ac.c;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class AdvertisingIdClient {

    /* renamed from: a, reason: collision with root package name */
    public BlockingServiceConnection f6049a;

    /* renamed from: b, reason: collision with root package name */
    public zzf f6050b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6051c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6052d;

    /* renamed from: e, reason: collision with root package name */
    public zzb f6053e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f6054f;

    /* renamed from: g, reason: collision with root package name */
    public final long f6055g;

    /* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
    @KeepForSdkWithMembers
    public static final class Info {

        /* renamed from: a, reason: collision with root package name */
        public final String f6056a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6057b;

        @Deprecated
        public Info(String str, boolean z10) {
            this.f6056a = str;
            this.f6057b = z10;
        }

        public String getId() {
            return this.f6056a;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.f6057b;
        }

        public String toString() {
            String str = this.f6056a;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(this.f6057b);
            return sb2.toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    @VisibleForTesting
    public static void a(Info info, long j10, Throwable th2) {
        if (Math.random() <= 0.0d) {
            HashMap mapW = c.w("app_context", "1");
            if (info != null) {
                mapW.put("limit_ad_tracking", true != info.isLimitAdTrackingEnabled() ? "0" : "1");
                String id2 = info.getId();
                if (id2 != null) {
                    mapW.put("ad_id_size", Integer.toString(id2.length()));
                }
            }
            if (th2 != null) {
                mapW.put("error", th2.getClass().getName());
            }
            mapW.put("tag", "AdvertisingIdClient");
            mapW.put("time_spent", Long.toString(j10));
            new zza(mapW).start();
        }
    }

    @KeepForSdk
    public static Info getAdvertisingIdInfo(Context context) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info infoB = advertisingIdClient.b();
            a(infoB, SystemClock.elapsedRealtime() - jElapsedRealtime, null);
            return infoB;
        } finally {
        }
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException, IOException {
        boolean zZzd;
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, false, false);
        try {
            advertisingIdClient.zzb(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized (advertisingIdClient) {
                if (advertisingIdClient.f6051c) {
                    Preconditions.checkNotNull(advertisingIdClient.f6049a);
                    Preconditions.checkNotNull(advertisingIdClient.f6050b);
                    zZzd = advertisingIdClient.f6050b.zzd();
                } else {
                    synchronized (advertisingIdClient.f6052d) {
                        zzb zzbVar = advertisingIdClient.f6053e;
                        if (zzbVar == null || !zzbVar.f6062o) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        advertisingIdClient.zzb(false);
                        if (!advertisingIdClient.f6051c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                        Preconditions.checkNotNull(advertisingIdClient.f6049a);
                        Preconditions.checkNotNull(advertisingIdClient.f6050b);
                        try {
                            zZzd = advertisingIdClient.f6050b.zzd();
                        } catch (RemoteException e10) {
                            Log.i("AdvertisingIdClient", "GMS remote exception ", e10);
                            throw new IOException("Remote exception");
                        }
                    } catch (Exception e11) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e11);
                    }
                }
            }
            advertisingIdClient.c();
            return zZzd;
        } finally {
            advertisingIdClient.zza();
        }
    }

    public final Info b() throws IOException {
        Info info;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f6051c) {
                Preconditions.checkNotNull(this.f6049a);
                Preconditions.checkNotNull(this.f6050b);
                info = new Info(this.f6050b.zzc(), this.f6050b.zze(true));
            } else {
                synchronized (this.f6052d) {
                    zzb zzbVar = this.f6053e;
                    if (zzbVar == null || !zzbVar.f6062o) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.f6051c) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                    Preconditions.checkNotNull(this.f6049a);
                    Preconditions.checkNotNull(this.f6050b);
                    try {
                        info = new Info(this.f6050b.zzc(), this.f6050b.zze(true));
                    } catch (RemoteException e10) {
                        Log.i("AdvertisingIdClient", "GMS remote exception ", e10);
                        throw new IOException("Remote exception");
                    }
                } catch (Exception e11) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e11);
                }
            }
        }
        c();
        return info;
    }

    public final void c() {
        synchronized (this.f6052d) {
            zzb zzbVar = this.f6053e;
            if (zzbVar != null) {
                zzbVar.f6061n.countDown();
                try {
                    this.f6053e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j10 = this.f6055g;
            if (j10 > 0) {
                this.f6053e = new zzb(this, j10);
            }
        }
    }

    public final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @KeepForSdk
    public Info getInfo() throws IOException {
        return b();
    }

    @KeepForSdk
    public void start() throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        zzb(true);
    }

    public final void zza() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f6054f == null || this.f6049a == null) {
                return;
            }
            try {
                if (this.f6051c) {
                    ConnectionTracker.getInstance().unbindService(this.f6054f, this.f6049a);
                }
            } catch (Throwable th2) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th2);
            }
            this.f6051c = false;
            this.f6050b = null;
            this.f6049a = null;
        }
    }

    @VisibleForTesting
    public final void zzb(boolean z10) throws GooglePlayServicesRepairableException, IllegalStateException, GooglePlayServicesNotAvailableException, IOException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.f6051c) {
                zza();
            }
            Context context = this.f6054f;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12451000);
                if (iIsGooglePlayServicesAvailable != 0 && iIsGooglePlayServicesAvailable != 2) {
                    throw new IOException("Google Play services not available");
                }
                BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                        throw new IOException("Connection failure");
                    }
                    this.f6049a = blockingServiceConnection;
                    try {
                        this.f6050b = zze.zza(blockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                        this.f6051c = true;
                        if (z10) {
                            c();
                        }
                    } catch (InterruptedException unused) {
                        throw new IOException("Interrupted exception");
                    } catch (Throwable th2) {
                        throw new IOException(th2);
                    }
                } finally {
                    IOException iOException = new IOException(th2);
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new GooglePlayServicesNotAvailableException(9);
            }
        }
    }

    @VisibleForTesting
    public AdvertisingIdClient(Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        this.f6052d = new Object();
        Preconditions.checkNotNull(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f6054f = context;
        this.f6051c = false;
        this.f6055g = j10;
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z10) {
    }
}
