package q4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: SafeLoggingExecutor.java */
/* loaded from: classes.dex */
public final class m implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f17866b;

    /* compiled from: SafeLoggingExecutor.java */
    public static class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f17867b;

        public a(Runnable runnable) {
            this.f17867b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f17867b.run();
            } catch (Exception e10) {
                u4.a.e("Executor", "Background execution failure.", e10);
            }
        }
    }

    public m(ExecutorService executorService) {
        this.f17866b = executorService;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f17866b.execute(new a(runnable));
    }
}
