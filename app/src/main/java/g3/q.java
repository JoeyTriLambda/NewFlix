package g3;

import androidx.work.WorkerParameters;
import x2.e0;

/* compiled from: StartWorkRunnable.java */
/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final e0 f12659b;

    /* renamed from: m, reason: collision with root package name */
    public final x2.v f12660m;

    /* renamed from: n, reason: collision with root package name */
    public final WorkerParameters.a f12661n;

    public q(e0 e0Var, x2.v vVar, WorkerParameters.a aVar) {
        this.f12659b = e0Var;
        this.f12660m = vVar;
        this.f12661n = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12659b.getProcessor().startWork(this.f12660m, this.f12661n);
    }
}
