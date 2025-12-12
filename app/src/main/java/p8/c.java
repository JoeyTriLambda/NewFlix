package p8;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: BlockingAnalyticsEventLogger.java */
/* loaded from: classes.dex */
public final class c implements b, a {

    /* renamed from: b, reason: collision with root package name */
    public final e f17638b;

    /* renamed from: m, reason: collision with root package name */
    public final int f17639m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeUnit f17640n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f17641o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public CountDownLatch f17642p;

    public c(e eVar, int i10, TimeUnit timeUnit) {
        this.f17638b = eVar;
        this.f17639m = i10;
        this.f17640n = timeUnit;
    }

    @Override // p8.a
    public void logEvent(String str, Bundle bundle) {
        synchronized (this.f17641o) {
            o8.e.getLogger().v("Logging event " + str + " to Firebase Analytics with params " + bundle);
            this.f17642p = new CountDownLatch(1);
            this.f17638b.logEvent(str, bundle);
            o8.e.getLogger().v("Awaiting app exception callback from Analytics...");
            try {
                if (this.f17642p.await(this.f17639m, this.f17640n)) {
                    o8.e.getLogger().v("App exception callback received from Analytics listener.");
                } else {
                    o8.e.getLogger().w("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            } catch (InterruptedException unused) {
                o8.e.getLogger().e("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.f17642p = null;
        }
    }

    @Override // p8.b
    public void onEvent(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f17642p;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
