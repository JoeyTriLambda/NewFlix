package m6;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.WindowManager;

/* compiled from: VideoFrameReleaseTimeHelper.java */
@TargetApi(16)
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final a f16159a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16160b;

    /* renamed from: c, reason: collision with root package name */
    public final long f16161c;

    /* renamed from: d, reason: collision with root package name */
    public final long f16162d;

    /* renamed from: e, reason: collision with root package name */
    public long f16163e;

    /* renamed from: f, reason: collision with root package name */
    public long f16164f;

    /* renamed from: g, reason: collision with root package name */
    public long f16165g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16166h;

    /* renamed from: i, reason: collision with root package name */
    public long f16167i;

    /* renamed from: j, reason: collision with root package name */
    public long f16168j;

    /* renamed from: k, reason: collision with root package name */
    public long f16169k;

    /* compiled from: VideoFrameReleaseTimeHelper.java */
    public static final class a implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: p, reason: collision with root package name */
        public static final a f16170p = new a();

        /* renamed from: b, reason: collision with root package name */
        public volatile long f16171b;

        /* renamed from: m, reason: collision with root package name */
        public final Handler f16172m;

        /* renamed from: n, reason: collision with root package name */
        public Choreographer f16173n;

        /* renamed from: o, reason: collision with root package name */
        public int f16174o;

        public a() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper(), this);
            this.f16172m = handler;
            handler.sendEmptyMessage(0);
        }

        public static a getInstance() {
            return f16170p;
        }

        public void addObserver() {
            this.f16172m.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            this.f16171b = j10;
            this.f16173n.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                this.f16173n = Choreographer.getInstance();
                return true;
            }
            if (i10 == 1) {
                int i11 = this.f16174o + 1;
                this.f16174o = i11;
                if (i11 == 1) {
                    this.f16173n.postFrameCallback(this);
                }
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            int i12 = this.f16174o - 1;
            this.f16174o = i12;
            if (i12 == 0) {
                this.f16173n.removeFrameCallback(this);
                this.f16171b = 0L;
            }
            return true;
        }

        public void removeObserver() {
            this.f16172m.sendEmptyMessage(2);
        }
    }

    public f(Context context) {
        double refreshRate = ((WindowManager) context.getSystemService("window")).getDefaultDisplay() != null ? r6.getDefaultDisplay().getRefreshRate() : -1.0d;
        boolean z10 = refreshRate != -1.0d;
        this.f16160b = z10;
        if (!z10) {
            this.f16159a = null;
            this.f16161c = -1L;
            this.f16162d = -1L;
        } else {
            this.f16159a = a.getInstance();
            long j10 = (long) (1.0E9d / refreshRate);
            this.f16161c = j10;
            this.f16162d = (j10 * 80) / 100;
        }
    }

    public long adjustReleaseTime(long j10, long j11) {
        long j12;
        long j13;
        long j14;
        long j15 = 1000 * j10;
        if (this.f16166h) {
            if (j10 != this.f16163e) {
                this.f16169k++;
                this.f16164f = this.f16165g;
            }
            long j16 = this.f16169k;
            if (j16 >= 6) {
                long j17 = this.f16168j;
                long j18 = this.f16164f + ((j15 - j17) / j16);
                if (Math.abs((j11 - this.f16167i) - (j18 - j17)) > 20000000) {
                    this.f16166h = false;
                } else {
                    j12 = (this.f16167i + j18) - this.f16168j;
                    j13 = j18;
                }
            } else {
                if (Math.abs((j11 - this.f16167i) - (j15 - this.f16168j)) > 20000000) {
                    this.f16166h = false;
                }
            }
            j12 = j11;
            j13 = j15;
        } else {
            j12 = j11;
            j13 = j15;
        }
        if (!this.f16166h) {
            this.f16168j = j15;
            this.f16167i = j11;
            this.f16169k = 0L;
            this.f16166h = true;
            onSynced();
        }
        this.f16163e = j10;
        this.f16165g = j13;
        a aVar = this.f16159a;
        if (aVar == null || aVar.f16171b == 0) {
            return j12;
        }
        long j19 = this.f16159a.f16171b;
        long j20 = this.f16161c;
        long j21 = (((j12 - j19) / j20) * j20) + j19;
        if (j12 <= j21) {
            j14 = j21 - j20;
        } else {
            j14 = j21;
            j21 = j20 + j21;
        }
        if (j21 - j12 >= j12 - j14) {
            j21 = j14;
        }
        return j21 - this.f16162d;
    }

    public void disable() {
        if (this.f16160b) {
            this.f16159a.removeObserver();
        }
    }

    public void enable() {
        this.f16166h = false;
        if (this.f16160b) {
            this.f16159a.addObserver();
        }
    }

    public void onSynced() {
    }
}
