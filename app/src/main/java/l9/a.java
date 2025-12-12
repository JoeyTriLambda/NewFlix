package l9;

import i9.i;
import java.util.concurrent.TimeUnit;

/* compiled from: RequestLimiter.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final long f15997d = TimeUnit.HOURS.toMillis(24);

    /* renamed from: e, reason: collision with root package name */
    public static final long f15998e = TimeUnit.MINUTES.toMillis(30);

    /* renamed from: a, reason: collision with root package name */
    public final i f15999a = i.getInstance();

    /* renamed from: b, reason: collision with root package name */
    public long f16000b;

    /* renamed from: c, reason: collision with root package name */
    public int f16001c;

    public final synchronized long a(int i10) {
        if (i10 == 429 || (i10 >= 500 && i10 < 600)) {
            return (long) Math.min(Math.pow(2.0d, this.f16001c) + this.f15999a.getRandomDelayForSyncPrevention(), f15998e);
        }
        return f15997d;
    }

    public final synchronized void b() {
        this.f16001c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isRequestAllowed() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f16001c     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L14
            i9.i r0 = r5.f15999a     // Catch: java.lang.Throwable -> L17
            long r0 = r0.currentTimeInMillis()     // Catch: java.lang.Throwable -> L17
            long r2 = r5.f16000b     // Catch: java.lang.Throwable -> L17
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            monitor-exit(r5)
            return r0
        L17:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l9.a.isRequestAllowed():boolean");
    }

    public synchronized void setNextRequestTime(int i10) {
        if ((i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404) {
            b();
        } else {
            this.f16001c++;
            this.f16000b = this.f15999a.currentTimeInMillis() + a(i10);
        }
    }
}
