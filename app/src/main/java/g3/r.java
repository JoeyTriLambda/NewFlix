package g3;

import x2.e0;

/* compiled from: StopWorkRunnable.java */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public static final String f12662o = w2.g.tagWithPrefix("StopWorkRunnable");

    /* renamed from: b, reason: collision with root package name */
    public final e0 f12663b;

    /* renamed from: m, reason: collision with root package name */
    public final x2.v f12664m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f12665n;

    public r(e0 e0Var, x2.v vVar, boolean z10) {
        this.f12663b = e0Var;
        this.f12664m = vVar;
        this.f12665n = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10 = this.f12665n;
        e0 e0Var = this.f12663b;
        x2.v vVar = this.f12664m;
        boolean zStopForegroundWork = z10 ? e0Var.getProcessor().stopForegroundWork(vVar) : e0Var.getProcessor().stopWork(vVar);
        w2.g.get().debug(f12662o, "StopWorkRunnable for " + vVar.getId().getWorkSpecId() + "; Processor.stopWork = " + zStopForegroundWork);
    }
}
