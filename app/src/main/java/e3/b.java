package e3;

import f3.t;
import f3.w;

/* compiled from: SystemForegroundDispatcher.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f11130b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ androidx.work.impl.foreground.a f11131m;

    public b(androidx.work.impl.foreground.a aVar, String str) {
        this.f11131m = aVar;
        this.f11130b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        t runningWorkSpec = this.f11131m.f4596b.getProcessor().getRunningWorkSpec(this.f11130b);
        if (runningWorkSpec == null || !runningWorkSpec.hasConstraints()) {
            return;
        }
        synchronized (this.f11131m.f4598n) {
            this.f11131m.f4601q.put(w.generationalId(runningWorkSpec), runningWorkSpec);
            this.f11131m.f4602r.add(runningWorkSpec);
            androidx.work.impl.foreground.a aVar = this.f11131m;
            aVar.f4603s.replace(aVar.f4602r);
        }
    }
}
