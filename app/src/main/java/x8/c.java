package x8;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import n4.e;
import n4.g;
import q4.q;
import r.x;
import r8.a0;
import r8.l0;
import r8.p0;
import t8.f0;
import y8.d;

/* compiled from: ReportQueue.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final double f21649a;

    /* renamed from: b, reason: collision with root package name */
    public final double f21650b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21651c;

    /* renamed from: d, reason: collision with root package name */
    public final long f21652d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21653e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayBlockingQueue f21654f;

    /* renamed from: g, reason: collision with root package name */
    public final ThreadPoolExecutor f21655g;

    /* renamed from: h, reason: collision with root package name */
    public final e<f0> f21656h;

    /* renamed from: i, reason: collision with root package name */
    public final l0 f21657i;

    /* renamed from: j, reason: collision with root package name */
    public int f21658j;

    /* renamed from: k, reason: collision with root package name */
    public long f21659k;

    /* compiled from: ReportQueue.java */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final a0 f21660b;

        /* renamed from: m, reason: collision with root package name */
        public final TaskCompletionSource<a0> f21661m;

        public a(a0 a0Var, TaskCompletionSource taskCompletionSource) {
            this.f21660b = a0Var;
            this.f21661m = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            c cVar = c.this;
            a0 a0Var = this.f21660b;
            cVar.b(a0Var, this.f21661m);
            cVar.f21657i.resetDroppedOnDemandExceptions();
            double dMin = Math.min(3600000.0d, Math.pow(cVar.f21650b, cVar.a()) * (60000.0d / cVar.f21649a));
            o8.e.getLogger().d("Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dMin / 1000.0d)) + " s for report: " + a0Var.getSessionId());
            try {
                Thread.sleep((long) dMin);
            } catch (InterruptedException unused) {
            }
        }
    }

    public c(e<f0> eVar, d dVar, l0 l0Var) {
        double d10 = dVar.f22025d;
        this.f21649a = d10;
        this.f21650b = dVar.f22026e;
        this.f21651c = dVar.f22027f * 1000;
        this.f21656h = eVar;
        this.f21657i = l0Var;
        this.f21652d = SystemClock.elapsedRealtime();
        int i10 = (int) d10;
        this.f21653e = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.f21654f = arrayBlockingQueue;
        this.f21655g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f21658j = 0;
        this.f21659k = 0L;
    }

    public final int a() {
        if (this.f21659k == 0) {
            this.f21659k = System.currentTimeMillis();
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f21659k) / this.f21651c);
        int iMin = this.f21654f.size() == this.f21653e ? Math.min(100, this.f21658j + iCurrentTimeMillis) : Math.max(0, this.f21658j - iCurrentTimeMillis);
        if (this.f21658j != iMin) {
            this.f21658j = iMin;
            this.f21659k = System.currentTimeMillis();
        }
        return iMin;
    }

    public final void b(final a0 a0Var, final TaskCompletionSource<a0> taskCompletionSource) {
        o8.e.getLogger().d("Sending report through Google DataTransport: " + a0Var.getSessionId());
        final boolean z10 = SystemClock.elapsedRealtime() - this.f21652d < 2000;
        ((q) this.f21656h).schedule(n4.c.ofUrgent(a0Var.getReport()), new g() { // from class: x8.b
            @Override // n4.g
            public final void onSchedule(Exception exc) {
                c cVar = this.f21645b;
                cVar.getClass();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (exc != null) {
                    taskCompletionSource2.trySetException(exc);
                    return;
                }
                if (z10) {
                    cVar.flushScheduledReportsIfAble();
                }
                taskCompletionSource2.trySetResult(a0Var);
            }
        });
    }

    @SuppressLint({"DiscouragedApi", "ThreadPoolCreation"})
    public void flushScheduledReportsIfAble() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new x(17, this, countDownLatch)).start();
        p0.awaitUninterruptibly(countDownLatch, 2L, TimeUnit.SECONDS);
    }
}
