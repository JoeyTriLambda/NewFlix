package r8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes.dex */
public final class e0 {

    /* compiled from: ExecutorUtils.java */
    public class a implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18682b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ AtomicLong f18683m;

        /* compiled from: ExecutorUtils.java */
        /* renamed from: r8.e0$a$a, reason: collision with other inner class name */
        public class C0241a extends d {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f18684b;

            public C0241a(Runnable runnable) {
                this.f18684b = runnable;
            }

            @Override // r8.d
            public void onRun() {
                this.f18684b.run();
            }
        }

        public a(String str, AtomicLong atomicLong) {
            this.f18682b = str;
            this.f18683m = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = Executors.defaultThreadFactory().newThread(new C0241a(runnable));
            threadNewThread.setName(this.f18682b + this.f18683m.getAndIncrement());
            return threadNewThread;
        }
    }

    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getNamedThreadFactory(str), new ThreadPoolExecutor.DiscardPolicy()));
        Runtime.getRuntime().addShutdownHook(new Thread(new f0(str, executorServiceUnconfigurableExecutorService, TimeUnit.SECONDS), ac.c.j("Crashlytics Shutdown Hook for ", str)));
        return executorServiceUnconfigurableExecutorService;
    }

    public static ThreadFactory getNamedThreadFactory(String str) {
        return new a(str, new AtomicLong(1L));
    }
}
