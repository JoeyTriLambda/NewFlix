package y2;

import f3.t;
import java.util.HashMap;
import w2.g;
import w2.l;
import x2.d;

/* compiled from: DelayedWorkTracker.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f21842d = g.tagWithPrefix("DelayedWorkTracker");

    /* renamed from: a, reason: collision with root package name */
    public final b f21843a;

    /* renamed from: b, reason: collision with root package name */
    public final l f21844b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f21845c = new HashMap();

    /* compiled from: DelayedWorkTracker.java */
    /* renamed from: y2.a$a, reason: collision with other inner class name */
    public class RunnableC0318a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f21846b;

        public RunnableC0318a(t tVar) {
            this.f21846b = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.get();
            String str = a.f21842d;
            StringBuilder sb2 = new StringBuilder("Scheduling work ");
            t tVar = this.f21846b;
            sb2.append(tVar.f11426a);
            gVar.debug(str, sb2.toString());
            a.this.f21843a.schedule(tVar);
        }
    }

    public a(b bVar, l lVar) {
        this.f21843a = bVar;
        this.f21844b = lVar;
    }

    public void schedule(t tVar) {
        HashMap map = this.f21845c;
        Runnable runnable = (Runnable) map.remove(tVar.f11426a);
        l lVar = this.f21844b;
        if (runnable != null) {
            ((d) lVar).cancel(runnable);
        }
        RunnableC0318a runnableC0318a = new RunnableC0318a(tVar);
        map.put(tVar.f11426a, runnableC0318a);
        d dVar = (d) lVar;
        dVar.scheduleWithDelay(tVar.calculateNextRunTime() - System.currentTimeMillis(), runnableC0318a);
    }

    public void unschedule(String str) {
        Runnable runnable = (Runnable) this.f21845c.remove(str);
        if (runnable != null) {
            ((d) this.f21844b).cancel(runnable);
        }
    }
}
