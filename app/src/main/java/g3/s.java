package g3;

import java.util.concurrent.Executor;

/* compiled from: SynchronousExecutor.java */
/* loaded from: classes.dex */
public final class s implements Executor {
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
