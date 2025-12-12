package x2;

/* compiled from: WorkerWrapper.java */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e8.c f21423b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k0 f21424m;

    public i0(k0 k0Var, e8.c cVar) {
        this.f21424m = k0Var;
        this.f21423b = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        k0 k0Var = this.f21424m;
        if (k0Var.B.isCancelled()) {
            return;
        }
        try {
            this.f21423b.get();
            w2.g.get().debug(k0.D, "Starting work for " + k0Var.f21433p.f11428c);
            k0Var.B.setFuture(k0Var.f21434q.startWork());
        } catch (Throwable th2) {
            k0Var.B.setException(th2);
        }
    }
}
