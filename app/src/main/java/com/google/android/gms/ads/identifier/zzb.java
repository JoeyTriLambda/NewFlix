package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
@VisibleForTesting
/* loaded from: classes.dex */
final class zzb extends Thread {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<AdvertisingIdClient> f6059b;

    /* renamed from: m, reason: collision with root package name */
    public final long f6060m;

    /* renamed from: n, reason: collision with root package name */
    public final CountDownLatch f6061n = new CountDownLatch(1);

    /* renamed from: o, reason: collision with root package name */
    public boolean f6062o = false;

    public zzb(AdvertisingIdClient advertisingIdClient, long j10) {
        this.f6059b = new WeakReference<>(advertisingIdClient);
        this.f6060m = j10;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AdvertisingIdClient advertisingIdClient;
        WeakReference<AdvertisingIdClient> weakReference = this.f6059b;
        try {
            if (this.f6061n.await(this.f6060m, TimeUnit.MILLISECONDS) || (advertisingIdClient = weakReference.get()) == null) {
                return;
            }
            advertisingIdClient.zza();
            this.f6062o = true;
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = weakReference.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.zza();
                this.f6062o = true;
            }
        }
    }
}
