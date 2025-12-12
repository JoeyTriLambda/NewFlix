package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
public class ImmediateSchedulingStrategy implements SchedulingStrategy {
    private final ExecutorService executor;

    public ImmediateSchedulingStrategy(CacheConfig cacheConfig) {
        this(new ThreadPoolExecutor(cacheConfig.getAsynchronousWorkersCore(), cacheConfig.getAsynchronousWorkersMax(), cacheConfig.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(cacheConfig.getRevalidationQueueSize())));
    }

    public void awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(j10, timeUnit);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.executor.shutdown();
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.SchedulingStrategy
    public void schedule(AsynchronousValidationRequest asynchronousValidationRequest) {
        Args.notNull(asynchronousValidationRequest, "AsynchronousValidationRequest");
        this.executor.execute(asynchronousValidationRequest);
    }

    public ImmediateSchedulingStrategy(ExecutorService executorService) {
        this.executor = executorService;
    }
}
