package ad;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: Repeater.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f621a;

    /* renamed from: b, reason: collision with root package name */
    public int f622b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f623c;

    /* renamed from: d, reason: collision with root package name */
    public HandlerThread f624d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f625e;

    /* renamed from: f, reason: collision with root package name */
    public b f626f;

    /* renamed from: g, reason: collision with root package name */
    public final a f627g;

    /* compiled from: Repeater.java */
    public class a implements Runnable {
        public a() {
        }

        public void performPoll() {
            c cVar = c.this;
            cVar.f623c.postDelayed(cVar.f627g, cVar.f622b);
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = c.this.f626f;
            if (bVar != null) {
                bVar.onRepeat();
            }
            if (c.this.f621a) {
                performPoll();
            }
        }
    }

    /* compiled from: Repeater.java */
    public interface b {
        void onRepeat();
    }

    public c() {
        this(true);
    }

    public void setRepeatListener(b bVar) {
        this.f626f = bVar;
    }

    public void setRepeaterDelay(int i10) {
        this.f622b = i10;
    }

    public void start() {
        if (this.f621a) {
            return;
        }
        this.f621a = true;
        if (this.f625e) {
            HandlerThread handlerThread = new HandlerThread("ExoMedia_Repeater_HandlerThread");
            this.f624d = handlerThread;
            handlerThread.start();
            this.f623c = new Handler(this.f624d.getLooper());
        }
        this.f627g.performPoll();
    }

    public void stop() {
        HandlerThread handlerThread = this.f624d;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.f621a = false;
    }

    public c(boolean z10) {
        this.f621a = false;
        this.f622b = 33;
        this.f625e = false;
        this.f627g = new a();
        if (z10) {
            this.f623c = new Handler();
        } else {
            this.f625e = true;
        }
    }
}
