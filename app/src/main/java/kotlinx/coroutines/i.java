package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kg.b1;
import kg.d2;
import kg.l;
import kg.n1;
import kg.s0;
import kg.t0;
import kg.u0;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public final class i extends h implements e {

    /* renamed from: m, reason: collision with root package name */
    public final Executor f15556m;

    public i(Executor executor) {
        this.f15556m = executor;
        pg.c.removeFutureOnCancel(getExecutor());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = getExecutor();
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.b
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor executor = getExecutor();
            kg.c.getTimeSource();
            executor.execute(runnable);
        } catch (RejectedExecutionException e10) {
            kg.c.getTimeSource();
            n1.cancel(coroutineContext, b1.CancellationException("The task was rejected", e10));
            s0.getIO().dispatch(coroutineContext, runnable);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && ((i) obj).getExecutor() == getExecutor();
    }

    @Override // kotlinx.coroutines.h
    public Executor getExecutor() {
        return this.f15556m;
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }

    @Override // kotlinx.coroutines.e
    public u0 invokeOnTimeout(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                n1.cancel(coroutineContext, b1.CancellationException("The task was rejected", e10));
            }
        }
        return scheduledFutureSchedule != null ? new t0(scheduledFutureSchedule) : d.f15363s.invokeOnTimeout(j10, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.e
    public void scheduleResumeAfterDelay(long j10, l<? super lf.h> lVar) {
        Executor executor = getExecutor();
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            d2 d2Var = new d2(this, lVar);
            CoroutineContext context = lVar.getContext();
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(d2Var, j10, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e10) {
                n1.cancel(context, b1.CancellationException("The task was rejected", e10));
            }
        }
        if (scheduledFutureSchedule != null) {
            n1.cancelFutureOnCancellation(lVar, scheduledFutureSchedule);
        } else {
            d.f15363s.scheduleResumeAfterDelay(j10, lVar);
        }
    }

    @Override // kotlinx.coroutines.b
    public String toString() {
        return getExecutor().toString();
    }
}
