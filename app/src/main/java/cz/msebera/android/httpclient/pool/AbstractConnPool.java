package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
/* loaded from: classes2.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private volatile int validateAfterInactivity;

    public AbstractConnPool(ConnFactory<T, C> connFactory, int i10, int i11) {
        this.connFactory = (ConnFactory) Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(i10, "Max per route value");
        this.maxTotal = Args.positive(i11, "Max total value");
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList<>();
        this.pending = new LinkedList<>();
        this.maxPerRoute = new HashMap();
    }

    private int getMax(T t10) {
        Integer num = this.maxPerRoute.get(t10);
        return num != null ? num.intValue() : this.defaultMaxPerRoute;
    }

    private RouteSpecificPool<T, C, E> getPool(final T t10) {
        RouteSpecificPool<T, C, E> routeSpecificPool = this.routeToPool.get(t10);
        if (routeSpecificPool != null) {
            return routeSpecificPool;
        }
        RouteSpecificPool<T, C, E> routeSpecificPool2 = (RouteSpecificPool<T, C, E>) new RouteSpecificPool<T, C, E>(t10) { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // cz.msebera.android.httpclient.pool.RouteSpecificPool
            public E createEntry(C c10) {
                return (E) AbstractConnPool.this.createEntry(t10, c10);
            }
        };
        this.routeToPool.put(t10, routeSpecificPool2);
        return routeSpecificPool2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public E getPoolEntryBlocking(T t10, Object obj, long j10, TimeUnit timeUnit, Future<E> future) throws InterruptedException, TimeoutException, IOException {
        E e10;
        Date date = j10 > 0 ? new Date(timeUnit.toMillis(j10) + System.currentTimeMillis()) : null;
        this.lock.lock();
        try {
            RouteSpecificPool pool = getPool(t10);
            while (true) {
                boolean zAwaitUntil = true;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while (true) {
                    e10 = (E) pool.getFree(obj);
                    if (e10 == null) {
                        break;
                    }
                    if (e10.isExpired(System.currentTimeMillis())) {
                        e10.close();
                    }
                    if (!e10.isClosed()) {
                        break;
                    }
                    this.available.remove(e10);
                    pool.free(e10, false);
                }
                if (e10 != null) {
                    this.available.remove(e10);
                    this.leased.add(e10);
                    onReuse(e10);
                    return e10;
                }
                int max = getMax(t10);
                int iMax = Math.max(0, (pool.getAllocatedCount() + 1) - max);
                if (iMax > 0) {
                    for (int i10 = 0; i10 < iMax; i10++) {
                        PoolEntry lastUsed = pool.getLastUsed();
                        if (lastUsed == null) {
                            break;
                        }
                        lastUsed.close();
                        this.available.remove(lastUsed);
                        pool.remove(lastUsed);
                    }
                }
                if (pool.getAllocatedCount() < max) {
                    int iMax2 = Math.max(this.maxTotal - this.leased.size(), 0);
                    if (iMax2 > 0) {
                        if (this.available.size() > iMax2 - 1 && !this.available.isEmpty()) {
                            E eRemoveLast = this.available.removeLast();
                            eRemoveLast.close();
                            getPool(eRemoveLast.getRoute()).remove(eRemoveLast);
                        }
                        E e11 = (E) pool.add(this.connFactory.create(t10));
                        this.leased.add(e11);
                        return e11;
                    }
                }
                try {
                    if (future.isCancelled()) {
                        throw new InterruptedException("Operation interrupted");
                    }
                    pool.queue(future);
                    this.pending.add(future);
                    if (date != null) {
                        zAwaitUntil = this.condition.awaitUntil(date);
                    } else {
                        this.condition.await();
                    }
                    if (future.isCancelled()) {
                        throw new InterruptedException("Operation interrupted");
                    }
                    if (!zAwaitUntil && date != null && date.getTime() <= System.currentTimeMillis()) {
                        throw new TimeoutException("Timeout waiting for connection");
                    }
                } finally {
                    pool.unqueue(future);
                    this.pending.remove(future);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> it = this.routeToPool.entrySet().iterator();
        while (it.hasNext()) {
            RouteSpecificPool<T, C, E> value = it.next().getValue();
            if (value.getPendingCount() + value.getAllocatedCount() == 0) {
                it.remove();
            }
        }
    }

    public void closeExpired() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.4
            @Override // cz.msebera.android.httpclient.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(jCurrentTimeMillis)) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeIdle(long j10, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long millis = timeUnit.toMillis(j10);
        if (millis < 0) {
            millis = 0;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis() - millis;
        enumAvailable(new PoolEntryCallback<T, C>() { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.3
            @Override // cz.msebera.android.httpclient.pool.PoolEntryCallback
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= jCurrentTimeMillis) {
                    poolEntry.close();
                }
            }
        });
    }

    public abstract E createEntry(T t10, C c10);

    public void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                E next = it.next();
                poolEntryCallback.process(next);
                if (next.isClosed()) {
                    getPool(next.getRoute()).remove(next);
                    it.remove();
                }
            }
            purgePoolMap();
        } finally {
            this.lock.unlock();
        }
    }

    public void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator<E> it = this.leased.iterator();
            while (it.hasNext()) {
                poolEntryCallback.process(it.next());
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            return this.defaultMaxPerRoute;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxPerRoute(T t10) {
        Args.notNull(t10, "Route");
        this.lock.lock();
        try {
            return getMax(t10);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        try {
            return this.maxTotal;
        } finally {
            this.lock.unlock();
        }
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        try {
            return new HashSet(this.routeToPool.keySet());
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getStats(T t10) {
        Args.notNull(t10, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> pool = getPool(t10);
            return new PoolStats(pool.getLeasedCount(), pool.getPendingCount(), pool.getAvailableCount(), getMax(t10));
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            return new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
        } finally {
            this.lock.unlock();
        }
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public Future<E> lease(final T t10, final Object obj, final FutureCallback<E> futureCallback) {
        Args.notNull(t10, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return (Future<E>) new Future<E>() { // from class: cz.msebera.android.httpclient.pool.AbstractConnPool.2
            private final AtomicBoolean cancelled = new AtomicBoolean(false);
            private final AtomicBoolean done = new AtomicBoolean(false);
            private final AtomicReference<E> entryRef = new AtomicReference<>(null);

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z10) {
                if (!this.cancelled.compareAndSet(false, true)) {
                    return false;
                }
                this.done.set(true);
                AbstractConnPool.this.lock.lock();
                try {
                    AbstractConnPool.this.condition.signalAll();
                    AbstractConnPool.this.lock.unlock();
                    FutureCallback futureCallback2 = futureCallback;
                    if (futureCallback2 != null) {
                        futureCallback2.cancelled();
                    }
                    return true;
                } catch (Throwable th2) {
                    AbstractConnPool.this.lock.unlock();
                    throw th2;
                }
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled.get();
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                return this.done.get();
            }

            @Override // java.util.concurrent.Future
            public E get() throws ExecutionException, InterruptedException {
                try {
                    return (E) get(0L, TimeUnit.MILLISECONDS);
                } catch (TimeoutException e10) {
                    throw new ExecutionException(e10);
                }
            }

            @Override // java.util.concurrent.Future
            public E get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
                E e10;
                E e11 = this.entryRef.get();
                if (e11 != null) {
                    return e11;
                }
                synchronized (this) {
                    while (true) {
                        try {
                            try {
                                e10 = (E) AbstractConnPool.this.getPoolEntryBlocking(t10, obj, j10, timeUnit, this);
                                if (AbstractConnPool.this.validateAfterInactivity <= 0 || e10.getUpdated() + AbstractConnPool.this.validateAfterInactivity > System.currentTimeMillis() || AbstractConnPool.this.validate(e10)) {
                                    break;
                                }
                                e10.close();
                                AbstractConnPool.this.release((AbstractConnPool) e10, false);
                            } catch (IOException e12) {
                                this.done.set(true);
                                FutureCallback futureCallback2 = futureCallback;
                                if (futureCallback2 != null) {
                                    futureCallback2.failed(e12);
                                }
                                throw new ExecutionException(e12);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    this.entryRef.set(e10);
                    this.done.set(true);
                    AbstractConnPool.this.onLease(e10);
                    FutureCallback futureCallback3 = futureCallback;
                    if (futureCallback3 != null) {
                        futureCallback3.completed(e10);
                    }
                }
                return e10;
            }
        };
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int i10) {
        Args.positive(i10, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = i10;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxPerRoute(T t10, int i10) {
        Args.notNull(t10, "Route");
        this.lock.lock();
        try {
            if (i10 > -1) {
                this.maxPerRoute.put(t10, Integer.valueOf(i10));
            } else {
                this.maxPerRoute.remove(t10);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int i10) {
        Args.positive(i10, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = i10;
        } finally {
            this.lock.unlock();
        }
    }

    public void setValidateAfterInactivity(int i10) {
        this.validateAfterInactivity = i10;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            Iterator<E> it = this.available.iterator();
            while (it.hasNext()) {
                it.next().close();
            }
            Iterator<E> it2 = this.leased.iterator();
            while (it2.hasNext()) {
                it2.next().close();
            }
            Iterator<RouteSpecificPool<T, C, E>> it3 = this.routeToPool.values().iterator();
            while (it3.hasNext()) {
                it3.next().shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        this.lock.lock();
        try {
            return "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";
        } finally {
            this.lock.unlock();
        }
    }

    public boolean validate(E e10) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public void release(E e10, boolean z10) {
        this.lock.lock();
        try {
            if (this.leased.remove(e10)) {
                RouteSpecificPool pool = getPool(e10.getRoute());
                pool.free(e10, z10);
                if (!z10 || this.isShutDown) {
                    e10.close();
                } else {
                    this.available.addFirst(e10);
                }
                onRelease(e10);
                Future<E> futureNextPending = pool.nextPending();
                if (futureNextPending != null) {
                    this.pending.remove(futureNextPending);
                } else {
                    futureNextPending = this.pending.poll();
                }
                if (futureNextPending != null) {
                    this.condition.signalAll();
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public Future<E> lease(T t10, Object obj) {
        return lease(t10, obj, null);
    }

    public void onLease(E e10) {
    }

    public void onRelease(E e10) {
    }

    public void onReuse(E e10) {
    }
}
