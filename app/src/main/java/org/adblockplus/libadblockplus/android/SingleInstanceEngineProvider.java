package org.adblockplus.libadblockplus.android;

import bi.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.adblockplus.libadblockplus.android.AdblockEngine;
import org.adblockplus.libadblockplus.android.AdblockEngineProvider;

/* loaded from: classes2.dex */
public class SingleInstanceEngineProvider implements AdblockEngineProvider {
    private AdblockEngine.Factory engineFactory;
    private AtomicReference<AdblockEngine> engineReference = new AtomicReference<>();
    private List<AdblockEngineProvider.EngineCreatedListener> engineCreatedListeners = new CopyOnWriteArrayList();
    private List<AdblockEngineProvider.BeforeEngineDisposedListener> beforeEngineDisposedListeners = new CopyOnWriteArrayList();
    private List<AdblockEngineProvider.EngineDisposedListener> engineDisposedListeners = new CopyOnWriteArrayList();
    private final ReentrantReadWriteLock engineLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock referenceCounterLock = new ReentrantReadWriteLock();
    private AtomicInteger referenceCounter = new AtomicInteger(0);
    private final Runnable retainTask = new Runnable() { // from class: org.adblockplus.libadblockplus.android.SingleInstanceEngineProvider.1
        @Override // java.lang.Runnable
        public void run() {
            a.w("Waiting for lock in " + Thread.currentThread(), new Object[0]);
            SingleInstanceEngineProvider.this.engineLock.writeLock().lock();
            try {
                SingleInstanceEngineProvider.this.createAdblock();
            } finally {
                SingleInstanceEngineProvider.this.engineLock.writeLock().unlock();
            }
        }
    };
    private final Runnable waitForTheTasksTask = new Runnable() { // from class: org.adblockplus.libadblockplus.android.SingleInstanceEngineProvider.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    private final Runnable releaseTask = new Runnable() { // from class: org.adblockplus.libadblockplus.android.SingleInstanceEngineProvider.3
        @Override // java.lang.Runnable
        public void run() {
            a.w("Waiting for lock in " + Thread.currentThread(), new Object[0]);
            SingleInstanceEngineProvider.this.engineLock.writeLock().lock();
            try {
                SingleInstanceEngineProvider.this.disposeAdblock();
            } finally {
                SingleInstanceEngineProvider.this.engineLock.writeLock().unlock();
            }
        }
    };
    private final ExecutorService executorService = createExecutorService();

    public static class ExecutorServiceShutdownHook extends Thread {
        private final ExecutorService executorService;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a.w("Shutting down executor service %s", this.executorService);
            this.executorService.shutdown();
        }

        private ExecutorServiceShutdownHook(ExecutorService executorService) {
            a.w("Hooking on executor service %s", executorService);
            this.executorService = executorService;
        }
    }

    public SingleInstanceEngineProvider(AdblockEngine.Factory factory) {
        this.engineFactory = factory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAdblock() {
        a.d("Creating adblock engine ...", new Object[0]);
        AdblockEngine adblockEngineBuild = this.engineFactory.build();
        a.d("Engine created", new Object[0]);
        this.engineReference.set(adblockEngineBuild);
        Iterator<AdblockEngineProvider.EngineCreatedListener> it = this.engineCreatedListeners.iterator();
        while (it.hasNext()) {
            it.next().onAdblockEngineCreated(adblockEngineBuild);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disposeAdblock() {
        a.w("Disposing adblock engine", new Object[0]);
        Iterator<AdblockEngineProvider.BeforeEngineDisposedListener> it = this.beforeEngineDisposedListeners.iterator();
        while (it.hasNext()) {
            it.next().onBeforeAdblockEngineDispose();
        }
        this.engineReference.getAndSet(null).dispose();
        Iterator<AdblockEngineProvider.EngineDisposedListener> it2 = this.engineDisposedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onAdblockEngineDisposed();
        }
    }

    private Future scheduleTask(Runnable runnable) {
        return this.executorService.submit(runnable);
    }

    private void waitForTask(Future future) throws ExecutionException, InterruptedException, RuntimeException {
        try {
            future.get();
        } catch (Exception e10) {
            a.e(e10);
            throw new RuntimeException(e10);
        }
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void clearBeforeEngineDisposedListeners() {
        this.beforeEngineDisposedListeners.clear();
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void clearEngineCreatedListeners() {
        this.engineCreatedListeners.clear();
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void clearEngineDisposedListeners() {
        this.engineDisposedListeners.clear();
    }

    public ExecutorService createExecutorService() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Runtime.getRuntime().addShutdownHook(new ExecutorServiceShutdownHook(executorServiceNewSingleThreadExecutor));
        return executorServiceNewSingleThreadExecutor;
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public int getCounter() {
        this.referenceCounterLock.readLock().lock();
        try {
            return this.referenceCounter.get();
        } finally {
            this.referenceCounterLock.readLock().unlock();
        }
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public AdblockEngine getEngine() {
        return this.engineReference.get();
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public ReentrantReadWriteLock.ReadLock getReadEngineLock() {
        a.d("getReadEngineLock() called from " + Thread.currentThread(), new Object[0]);
        return this.engineLock.readLock();
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public boolean release() throws ExecutionException, InterruptedException, RuntimeException {
        this.referenceCounterLock.writeLock().lock();
        try {
            if (!(this.referenceCounter.decrementAndGet() == 0)) {
                return false;
            }
            Future futureScheduleTask = scheduleTask(this.releaseTask);
            this.referenceCounterLock.writeLock().unlock();
            waitForTask(futureScheduleTask);
            return true;
        } finally {
            this.referenceCounterLock.writeLock().unlock();
        }
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void removeBeforeEngineDisposedListener(AdblockEngineProvider.BeforeEngineDisposedListener beforeEngineDisposedListener) {
        this.beforeEngineDisposedListeners.remove(beforeEngineDisposedListener);
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void removeEngineCreatedListener(AdblockEngineProvider.EngineCreatedListener engineCreatedListener) {
        this.engineCreatedListeners.remove(engineCreatedListener);
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void removeEngineDisposedListener(AdblockEngineProvider.EngineDisposedListener engineDisposedListener) {
        this.engineDisposedListeners.remove(engineDisposedListener);
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public boolean retain(boolean z10) throws ExecutionException, InterruptedException, RuntimeException {
        this.referenceCounterLock.writeLock().lock();
        try {
            if (!(this.referenceCounter.getAndIncrement() == 0)) {
                return false;
            }
            Future futureScheduleTask = scheduleTask(this.retainTask);
            if (!z10) {
                waitForTask(futureScheduleTask);
            }
            return true;
        } finally {
            this.referenceCounterLock.writeLock().unlock();
        }
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public void waitForReady() throws ExecutionException, InterruptedException, RuntimeException {
        a.d("Waiting for ready in %s", Thread.currentThread());
        waitForTask(scheduleTask(this.waitForTheTasksTask));
        a.d("Ready", new Object[0]);
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public SingleInstanceEngineProvider addBeforeEngineDisposedListener(AdblockEngineProvider.BeforeEngineDisposedListener beforeEngineDisposedListener) {
        this.beforeEngineDisposedListeners.add(beforeEngineDisposedListener);
        return this;
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public SingleInstanceEngineProvider addEngineCreatedListener(AdblockEngineProvider.EngineCreatedListener engineCreatedListener) {
        this.engineCreatedListeners.add(engineCreatedListener);
        return this;
    }

    @Override // org.adblockplus.libadblockplus.android.AdblockEngineProvider
    public SingleInstanceEngineProvider addEngineDisposedListener(AdblockEngineProvider.EngineDisposedListener engineDisposedListener) {
        this.engineDisposedListeners.add(engineDisposedListener);
        return this;
    }
}
