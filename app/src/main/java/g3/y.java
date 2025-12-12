package g3;

import java.util.HashMap;

/* compiled from: WorkTimer.java */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name */
    public static final String f12686e = w2.g.tagWithPrefix("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final w2.l f12687a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12688b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f12689c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f12690d = new Object();

    /* compiled from: WorkTimer.java */
    public interface a {
        void onTimeLimitExceeded(f3.m mVar);
    }

    /* compiled from: WorkTimer.java */
    public static class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final y f12691b;

        /* renamed from: m, reason: collision with root package name */
        public final f3.m f12692m;

        public b(y yVar, f3.m mVar) {
            this.f12691b = yVar;
            this.f12692m = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f12691b.f12690d) {
                if (((b) this.f12691b.f12688b.remove(this.f12692m)) != null) {
                    a aVar = (a) this.f12691b.f12689c.remove(this.f12692m);
                    if (aVar != null) {
                        aVar.onTimeLimitExceeded(this.f12692m);
                    }
                } else {
                    w2.g.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f12692m));
                }
            }
        }
    }

    public y(w2.l lVar) {
        this.f12687a = lVar;
    }

    public void startTimer(f3.m mVar, long j10, a aVar) {
        synchronized (this.f12690d) {
            w2.g.get().debug(f12686e, "Starting timer for " + mVar);
            stopTimer(mVar);
            b bVar = new b(this, mVar);
            this.f12688b.put(mVar, bVar);
            this.f12689c.put(mVar, aVar);
            ((x2.d) this.f12687a).scheduleWithDelay(j10, bVar);
        }
    }

    public void stopTimer(f3.m mVar) {
        synchronized (this.f12690d) {
            if (((b) this.f12688b.remove(mVar)) != null) {
                w2.g.get().debug(f12686e, "Stopping timer for " + mVar);
                this.f12689c.remove(mVar);
            }
        }
    }
}
