package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, qe.b {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f14516m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public static final Object f14517n = new Object();

    /* renamed from: o, reason: collision with root package name */
    public static final Object f14518o = new Object();

    /* renamed from: p, reason: collision with root package name */
    public static final Object f14519p = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f14520b;

    public ScheduledRunnable(Runnable runnable, te.a aVar) {
        super(3);
        this.f14520b = runnable;
        lazySet(0, aVar);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // qe.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        while (true) {
            Object obj6 = get(1);
            obj = f14519p;
            if (obj6 == obj || obj6 == (obj4 = f14517n) || obj6 == (obj5 = f14518o)) {
                break;
            }
            boolean z10 = get(2) != Thread.currentThread();
            if (z10) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 != null) {
                    ((Future) obj6).cancel(z10);
                }
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = f14516m) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((te.a) obj2).delete(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        boolean zCompareAndSet;
        Object obj2;
        Object obj3;
        Object obj4 = f14518o;
        Object obj5 = f14517n;
        Object obj6 = f14516m;
        Object obj7 = f14519p;
        lazySet(2, Thread.currentThread());
        try {
            this.f14520b.run();
        } finally {
            try {
                lazySet(2, null);
                obj2 = get(0);
                if (obj2 != obj6) {
                    ((te.a) obj2).delete(this);
                }
                do {
                    obj3 = get(1);
                    if (obj3 != obj5) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj3, obj7));
            } catch (Throwable th2) {
                do {
                    if (obj == obj5 || obj == obj4) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        obj2 = get(0);
        if (obj2 != obj6 && compareAndSet(0, obj2, obj7) && obj2 != null) {
            ((te.a) obj2).delete(this);
        }
        do {
            obj3 = get(1);
            if (obj3 != obj5 || obj3 == obj4) {
                return;
            }
        } while (!compareAndSet(1, obj3, obj7));
    }

    public void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f14519p) {
                return;
            }
            if (obj == f14517n) {
                future.cancel(false);
                return;
            } else if (obj == f14518o) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
