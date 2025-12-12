package x2;

import android.annotation.SuppressLint;
import androidx.work.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* compiled from: WorkerWrapper.java */
/* loaded from: classes.dex */
public final class j0 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21426b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k0 f21427m;

    public j0(k0 k0Var, String str) {
        this.f21427m = k0Var;
        this.f21426b = str;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"SyntheticAccessor"})
    public void run() {
        String str = this.f21426b;
        k0 k0Var = this.f21427m;
        try {
            try {
                c.a aVar = k0Var.B.get();
                if (aVar == null) {
                    w2.g.get().error(k0.D, k0Var.f21433p.f11428c + " returned a null result. Treating it as a failure.");
                } else {
                    w2.g.get().debug(k0.D, k0Var.f21433p.f11428c + " returned a " + aVar + ".");
                    k0Var.f21436s = aVar;
                }
            } catch (InterruptedException e10) {
                e = e10;
                w2.g.get().error(k0.D, str + " failed because it threw an exception/error", e);
            } catch (CancellationException e11) {
                w2.g.get().info(k0.D, str + " was cancelled", e11);
            } catch (ExecutionException e12) {
                e = e12;
                w2.g.get().error(k0.D, str + " failed because it threw an exception/error", e);
            }
        } finally {
            k0Var.b();
        }
    }
}
