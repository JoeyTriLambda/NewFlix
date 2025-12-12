package pe;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import ne.r;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes2.dex */
public final class b extends r {

    /* renamed from: b, reason: collision with root package name */
    public final Handler f17681b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17682c = false;

    /* compiled from: HandlerScheduler.java */
    public static final class a extends r.c {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f17683b;

        /* renamed from: m, reason: collision with root package name */
        public final boolean f17684m;

        /* renamed from: n, reason: collision with root package name */
        public volatile boolean f17685n;

        public a(Handler handler, boolean z10) {
            this.f17683b = handler;
            this.f17684m = z10;
        }

        @Override // qe.b
        public void dispose() {
            this.f17685n = true;
            this.f17683b.removeCallbacksAndMessages(this);
        }

        @Override // ne.r.c
        @SuppressLint({"NewApi"})
        public qe.b schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f17685n) {
                return io.reactivex.disposables.a.disposed();
            }
            Runnable runnableOnSchedule = ff.a.onSchedule(runnable);
            Handler handler = this.f17683b;
            RunnableC0225b runnableC0225b = new RunnableC0225b(handler, runnableOnSchedule);
            Message messageObtain = Message.obtain(handler, runnableC0225b);
            messageObtain.obj = this;
            if (this.f17684m) {
                messageObtain.setAsynchronous(true);
            }
            this.f17683b.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f17685n) {
                return runnableC0225b;
            }
            this.f17683b.removeCallbacks(runnableC0225b);
            return io.reactivex.disposables.a.disposed();
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: pe.b$b, reason: collision with other inner class name */
    public static final class RunnableC0225b implements Runnable, qe.b {

        /* renamed from: b, reason: collision with root package name */
        public final Handler f17686b;

        /* renamed from: m, reason: collision with root package name */
        public final Runnable f17687m;

        public RunnableC0225b(Handler handler, Runnable runnable) {
            this.f17686b = handler;
            this.f17687m = runnable;
        }

        @Override // qe.b
        public void dispose() {
            this.f17686b.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f17687m.run();
            } catch (Throwable th2) {
                ff.a.onError(th2);
            }
        }
    }

    public b(Handler handler) {
        this.f17681b = handler;
    }

    @Override // ne.r
    public r.c createWorker() {
        return new a(this.f17681b, this.f17682c);
    }

    @Override // ne.r
    @SuppressLint({"NewApi"})
    public qe.b scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        Runnable runnableOnSchedule = ff.a.onSchedule(runnable);
        Handler handler = this.f17681b;
        RunnableC0225b runnableC0225b = new RunnableC0225b(handler, runnableOnSchedule);
        Message messageObtain = Message.obtain(handler, runnableC0225b);
        if (this.f17682c) {
            messageObtain.setAsynchronous(true);
        }
        handler.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
        return runnableC0225b;
    }
}
