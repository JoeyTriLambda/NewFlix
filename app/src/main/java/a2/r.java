package a2;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: MediaRouterActiveScanThrottlingHelper.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f234a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f235b;

    /* renamed from: c, reason: collision with root package name */
    public long f236c;

    /* renamed from: d, reason: collision with root package name */
    public long f237d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f238e;

    public r(androidx.activity.d dVar) {
        this.f235b = dVar;
    }

    public boolean finalizeActiveScanAndScheduleSuppressActiveScanRunnable() {
        if (this.f238e) {
            long j10 = this.f236c;
            if (j10 > 0) {
                this.f234a.postDelayed(this.f235b, j10);
            }
        }
        return this.f238e;
    }

    public void requestActiveScan(boolean z10, long j10) {
        if (z10) {
            long j11 = this.f237d;
            if (j11 - j10 >= 30000) {
                return;
            }
            this.f236c = Math.max(this.f236c, (j10 + 30000) - j11);
            this.f238e = true;
        }
    }

    public void reset() {
        this.f236c = 0L;
        this.f238e = false;
        this.f237d = SystemClock.elapsedRealtime();
        this.f234a.removeCallbacks(this.f235b);
    }
}
