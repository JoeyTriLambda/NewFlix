package ad;

import android.os.Handler;

/* compiled from: StopWatch.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f629a;

    /* renamed from: b, reason: collision with root package name */
    public long f630b;

    /* compiled from: StopWatch.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            System.currentTimeMillis();
            e eVar = e.this;
            eVar.getClass();
            eVar.getClass();
            eVar.getClass();
            eVar.getClass();
        }
    }

    public e() {
        this(true);
    }

    public boolean isRunning() {
        return false;
    }

    public void stop() {
        if (isRunning()) {
            this.f629a.removeCallbacksAndMessages(null);
            this.f630b = (System.currentTimeMillis() - 0) + this.f630b;
        }
    }

    public e(boolean z10) {
        new a();
        this.f630b = 0L;
        if (z10) {
            this.f629a = new Handler();
        }
    }
}
