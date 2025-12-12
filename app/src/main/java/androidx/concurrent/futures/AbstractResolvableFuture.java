package androidx.concurrent.futures;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V> implements e8.c<V> {

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f1594o = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: p, reason: collision with root package name */
    public static final Logger f1595p = Logger.getLogger(AbstractResolvableFuture.class.getName());

    /* renamed from: q, reason: collision with root package name */
    public static final a f1596q;

    /* renamed from: r, reason: collision with root package name */
    public static final Object f1597r;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f1598b;

    /* renamed from: m, reason: collision with root package name */
    public volatile c f1599m;

    /* renamed from: n, reason: collision with root package name */
    public volatile g f1600n;

    public static final class Failure {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1601a;

        static {
            new Failure(new Throwable() { // from class: androidx.concurrent.futures.AbstractResolvableFuture.Failure.1
                @Override // java.lang.Throwable
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            });
        }

        public Failure(Throwable th2) {
            boolean z10 = AbstractResolvableFuture.f1594o;
            th2.getClass();
            this.f1601a = th2;
        }
    }

    public static abstract class a {
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2);

        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f1602c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f1603d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1604a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f1605b;

        static {
            if (AbstractResolvableFuture.f1594o) {
                f1603d = null;
                f1602c = null;
            } else {
                f1603d = new b(false, null);
                f1602c = new b(true, null);
            }
        }

        public b(boolean z10, Throwable th2) {
            this.f1604a = z10;
            this.f1605b = th2;
        }
    }

    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f1606d = new c(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f1607a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f1608b;

        /* renamed from: c, reason: collision with root package name */
        public c f1609c;

        public c(Runnable runnable, Executor executor) {
            this.f1607a = runnable;
            this.f1608b = executor;
        }
    }

    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, Thread> f1610a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, g> f1611b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> f1612c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> f1613d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f1614e;

        public d(AtomicReferenceFieldUpdater<g, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<g, g> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            this.f1610a = atomicReferenceFieldUpdater;
            this.f1611b = atomicReferenceFieldUpdater2;
            this.f1612c = atomicReferenceFieldUpdater3;
            this.f1613d = atomicReferenceFieldUpdater4;
            this.f1614e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, c> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1613d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, cVar, cVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == cVar);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1614e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == obj);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            AtomicReferenceFieldUpdater<AbstractResolvableFuture, g> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f1612c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractResolvableFuture, gVar, gVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractResolvableFuture) == gVar);
            return false;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void d(g gVar, g gVar2) {
            this.f1611b.lazySet(gVar, gVar2);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void e(g gVar, Thread thread) {
            this.f1610a.lazySet(gVar, thread);
        }
    }

    public static final class e<V> implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    public static final class f extends a {
        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, c cVar, c cVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1599m != cVar) {
                    return false;
                }
                abstractResolvableFuture.f1599m = cVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1598b != obj) {
                    return false;
                }
                abstractResolvableFuture.f1598b = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, g gVar, g gVar2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1600n != gVar) {
                    return false;
                }
                abstractResolvableFuture.f1600n = gVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void d(g gVar, g gVar2) {
            gVar.f1617b = gVar2;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture.a
        public final void e(g gVar, Thread thread) {
            gVar.f1616a = thread;
        }
    }

    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        public static final g f1615c = new g(0);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f1616a;

        /* renamed from: b, reason: collision with root package name */
        public volatile g f1617b;

        public g(int i10) {
        }

        public g() {
            AbstractResolvableFuture.f1596q.e(this, Thread.currentThread());
        }
    }

    static {
        a fVar;
        try {
            fVar = new d(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, g.class, "n"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, c.class, "m"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.class, Object.class, "b"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f1596q = fVar;
        if (th != null) {
            f1595p.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1597r = new Object();
    }

    public static void b(AbstractResolvableFuture<?> abstractResolvableFuture) {
        g gVar;
        c cVar;
        do {
            gVar = abstractResolvableFuture.f1600n;
        } while (!f1596q.c(abstractResolvableFuture, gVar, g.f1615c));
        while (gVar != null) {
            Thread thread = gVar.f1616a;
            if (thread != null) {
                gVar.f1616a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f1617b;
        }
        abstractResolvableFuture.afterDone();
        do {
            cVar = abstractResolvableFuture.f1599m;
        } while (!f1596q.a(abstractResolvableFuture, cVar, c.f1606d));
        c cVar2 = null;
        while (cVar != null) {
            c cVar3 = cVar.f1609c;
            cVar.f1609c = cVar2;
            cVar2 = cVar;
            cVar = cVar3;
        }
        while (cVar2 != null) {
            c cVar4 = cVar2.f1609c;
            Runnable runnable = cVar2.f1607a;
            if (runnable instanceof e) {
                ((e) runnable).getClass();
                throw null;
            }
            c(runnable, cVar2.f1608b);
            cVar2 = cVar4;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f1595p.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public final void a(StringBuilder sb2) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                try {
                    v10 = get();
                    break;
                } catch (CancellationException unused) {
                    sb2.append("CANCELLED");
                    return;
                } catch (RuntimeException e10) {
                    sb2.append("UNKNOWN, cause=[");
                    sb2.append(e10.getClass());
                    sb2.append(" thrown from get()]");
                    return;
                } catch (ExecutionException e11) {
                    sb2.append("FAILURE, cause=[");
                    sb2.append(e11.getCause());
                    sb2.append("]");
                    return;
                }
            } catch (InterruptedException unused2) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        sb2.append("SUCCESS, result=[");
        sb2.append(v10 == this ? "this future" : String.valueOf(v10));
        sb2.append("]");
    }

    @Override // e8.c
    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        c cVar = this.f1599m;
        c cVar2 = c.f1606d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f1609c = cVar;
                if (f1596q.a(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f1599m;
                }
            } while (cVar != cVar2);
        }
        c(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f1598b;
        if ((obj == null) | (obj instanceof e)) {
            b bVar = f1594o ? new b(z10, new CancellationException("Future.cancel() was called.")) : z10 ? b.f1602c : b.f1603d;
            while (!f1596q.b(this, obj, bVar)) {
                obj = this.f1598b;
                if (!(obj instanceof e)) {
                }
            }
            if (z10) {
                interruptTask();
            }
            b(this);
            if (!(obj instanceof e)) {
                return true;
            }
            ((e) obj).getClass();
            throw null;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V d(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th2 = ((b) obj).f1605b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f1601a);
        }
        if (obj == f1597r) {
            return null;
        }
        return obj;
    }

    public final void e(g gVar) {
        gVar.f1616a = null;
        while (true) {
            g gVar2 = this.f1600n;
            if (gVar2 == g.f1615c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f1617b;
                if (gVar2.f1616a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f1617b = gVar4;
                    if (gVar3.f1616a == null) {
                        break;
                    }
                } else if (!f1596q.c(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00ad -> B:56:0x00b3). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(long r18, java.util.concurrent.TimeUnit r20) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f1598b instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof e)) & (this.f1598b != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object obj = this.f1598b;
        if (obj instanceof e) {
            StringBuilder sb2 = new StringBuilder("setFuture=[");
            ((e) obj).getClass();
            sb2.append("null");
            sb2.append("]");
            return sb2.toString();
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(V v10) {
        if (v10 == null) {
            v10 = (V) f1597r;
        }
        if (!f1596q.b(this, null, v10)) {
            return false;
        }
        b(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        th2.getClass();
        if (!f1596q.b(this, null, new Failure(th2))) {
            return false;
        }
        b(this);
        return true;
    }

    public String toString() {
        String strPendingToString;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            a(sb2);
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e10) {
                strPendingToString = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strPendingToString != null && !strPendingToString.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strPendingToString);
                sb2.append("]");
            } else if (isDone()) {
                a(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.f1598b;
        return (obj instanceof b) && ((b) obj).f1604a;
    }

    public void afterDone() {
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1598b;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return d(obj2);
            }
            g gVar = this.f1600n;
            g gVar2 = g.f1615c;
            if (gVar != gVar2) {
                g gVar3 = new g();
                do {
                    a aVar = f1596q;
                    aVar.d(gVar3, gVar);
                    if (aVar.c(this, gVar, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1598b;
                            } else {
                                e(gVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return d(obj);
                    }
                    gVar = this.f1600n;
                } while (gVar != gVar2);
            }
            return d(this.f1598b);
        }
        throw new InterruptedException();
    }
}
