package com.unity3d.services.core.request;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CancelableThreadPoolExecutor extends ThreadPoolExecutor {
    private final List<Runnable> _activeRunnable;

    public CancelableThreadPoolExecutor(int i10, int i11, long j10, TimeUnit timeUnit, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        super(i10, i11, j10, timeUnit, linkedBlockingQueue);
        this._activeRunnable = new LinkedList();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public synchronized void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        this._activeRunnable.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public synchronized void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        this._activeRunnable.add(runnable);
    }

    public synchronized void cancel() {
        for (Runnable runnable : this._activeRunnable) {
            if (runnable instanceof WebRequestRunnable) {
                ((WebRequestRunnable) runnable).setCancelStatus(true);
            }
        }
    }
}
