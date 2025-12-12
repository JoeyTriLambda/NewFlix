package androidx.work.impl.utils.futures;

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
public abstract class AbstractFuture<V> implements e8.c<V> {

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f4612o = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: p, reason: collision with root package name */
    public static final Logger f4613p = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: q, reason: collision with root package name */
    public static final a f4614q;

    /* renamed from: r, reason: collision with root package name */
    public static final Object f4615r;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f4616b;

    /* renamed from: m, reason: collision with root package name */
    public volatile c f4617m;

    /* renamed from: n, reason: collision with root package name */
    public volatile g f4618n;

    public static final class Failure {

        /* renamed from: b, reason: collision with root package name */
        public static final Failure f4619b = new Failure(new Throwable() { // from class: androidx.work.impl.utils.futures.AbstractFuture.Failure.1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f4620a;

        public Failure(Throwable th2) {
            boolean z10 = AbstractFuture.f4612o;
            th2.getClass();
            this.f4620a = th2;
        }
    }

    public static abstract class a {
        public abstract boolean a(AbstractFuture<?> abstractFuture, c cVar, c cVar2);

        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        public abstract boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2);

        public abstract void d(g gVar, g gVar2);

        public abstract void e(g gVar, Thread thread);
    }

    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f4621c;

        /* renamed from: d, reason: collision with root package name */
        public static final b f4622d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f4623a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f4624b;

        static {
            if (AbstractFuture.f4612o) {
                f4622d = null;
                f4621c = null;
            } else {
                f4622d = new b(false, null);
                f4621c = new b(true, null);
            }
        }

        public b(boolean z10, Throwable th2) {
            this.f4623a = z10;
            this.f4624b = th2;
        }
    }

    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f4625d = new c(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f4626a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f4627b;

        /* renamed from: c, reason: collision with root package name */
        public c f4628c;

        public c(Runnable runnable, Executor executor) {
            this.f4626a = runnable;
            this.f4627b = executor;
        }
    }

    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, Thread> f4629a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<g, g> f4630b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, g> f4631c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, c> f4632d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater<AbstractFuture, Object> f4633e;

        public d(AtomicReferenceFieldUpdater<g, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<g, g> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, g> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, c> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            this.f4629a = atomicReferenceFieldUpdater;
            this.f4630b = atomicReferenceFieldUpdater2;
            this.f4631c = atomicReferenceFieldUpdater3;
            this.f4632d = atomicReferenceFieldUpdater4;
            this.f4633e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean a(AbstractFuture<?> abstractFuture, c cVar, c cVar2) {
            AtomicReferenceFieldUpdater<AbstractFuture, c> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f4632d;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, cVar, cVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == cVar);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f4633e;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == obj);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2) {
            AtomicReferenceFieldUpdater<AbstractFuture, g> atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = this.f4631c;
                if (atomicReferenceFieldUpdater.compareAndSet(abstractFuture, gVar, gVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(abstractFuture) == gVar);
            return false;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final void d(g gVar, g gVar2) {
            this.f4630b.lazySet(gVar, gVar2);
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final void e(g gVar, Thread thread) {
            this.f4629a.lazySet(gVar, thread);
        }
    }

    public static final class e<V> implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final AbstractFuture<V> f4634b;

        /* renamed from: m, reason: collision with root package name */
        public final e8.c<? extends V> f4635m;

        public e(AbstractFuture<V> abstractFuture, e8.c<? extends V> cVar) {
            this.f4634b = abstractFuture;
            this.f4635m = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4634b.f4616b != this) {
                return;
            }
            if (AbstractFuture.f4614q.b(this.f4634b, this, AbstractFuture.e(this.f4635m))) {
                AbstractFuture.b(this.f4634b);
            }
        }
    }

    public static final class f extends a {
        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean a(AbstractFuture<?> abstractFuture, c cVar, c cVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f4617m != cVar) {
                    return false;
                }
                abstractFuture.f4617m = cVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f4616b != obj) {
                    return false;
                }
                abstractFuture.f4616b = obj2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final boolean c(AbstractFuture<?> abstractFuture, g gVar, g gVar2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f4618n != gVar) {
                    return false;
                }
                abstractFuture.f4618n = gVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final void d(g gVar, g gVar2) {
            gVar.f4638b = gVar2;
        }

        @Override // androidx.work.impl.utils.futures.AbstractFuture.a
        public final void e(g gVar, Thread thread) {
            gVar.f4637a = thread;
        }
    }

    public static final class g {

        /* renamed from: c, reason: collision with root package name */
        public static final g f4636c = new g(0);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f4637a;

        /* renamed from: b, reason: collision with root package name */
        public volatile g f4638b;

        public g(int i10) {
        }

        public g() {
            AbstractFuture.f4614q.e(this, Thread.currentThread());
        }
    }

    static {
        a fVar;
        try {
            fVar = new d(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, g.class, "n"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, c.class, "m"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "b"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            fVar = new f();
        }
        f4614q = fVar;
        if (th != null) {
            f4613p.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f4615r = new Object();
    }

    public static void b(AbstractFuture<?> abstractFuture) {
        c cVar;
        c cVar2;
        c cVar3 = null;
        while (true) {
            g gVar = abstractFuture.f4618n;
            if (f4614q.c(abstractFuture, gVar, g.f4636c)) {
                while (gVar != null) {
                    Thread thread = gVar.f4637a;
                    if (thread != null) {
                        gVar.f4637a = null;
                        LockSupport.unpark(thread);
                    }
                    gVar = gVar.f4638b;
                }
                abstractFuture.afterDone();
                do {
                    cVar = abstractFuture.f4617m;
                } while (!f4614q.a(abstractFuture, cVar, c.f4625d));
                while (true) {
                    cVar2 = cVar3;
                    cVar3 = cVar;
                    if (cVar3 == null) {
                        break;
                    }
                    cVar = cVar3.f4628c;
                    cVar3.f4628c = cVar2;
                }
                while (cVar2 != null) {
                    cVar3 = cVar2.f4628c;
                    Runnable runnable = cVar2.f4626a;
                    if (runnable instanceof e) {
                        e eVar = (e) runnable;
                        abstractFuture = eVar.f4634b;
                        if (abstractFuture.f4616b == eVar) {
                            if (f4614q.b(abstractFuture, eVar, e(eVar.f4635m))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        c(runnable, cVar2.f4627b);
                    }
                    cVar2 = cVar3;
                }
                return;
            }
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f4613p.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object e(e8.c<?> cVar) {
        Object obj;
        if (cVar instanceof AbstractFuture) {
            Object obj2 = ((AbstractFuture) cVar).f4616b;
            if (!(obj2 instanceof b)) {
                return obj2;
            }
            b bVar = (b) obj2;
            return bVar.f4623a ? bVar.f4624b != null ? new b(false, bVar.f4624b) : b.f4622d : obj2;
        }
        boolean zIsCancelled = cVar.isCancelled();
        if ((!f4612o) && zIsCancelled) {
            return b.f4622d;
        }
        boolean z10 = false;
        while (true) {
            try {
                try {
                    obj = cVar.get();
                    break;
                } catch (CancellationException e10) {
                    if (zIsCancelled) {
                        return new b(false, e10);
                    }
                    return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + cVar, e10));
                } catch (ExecutionException e11) {
                    return new Failure(e11.getCause());
                } catch (Throwable th2) {
                    return new Failure(th2);
                }
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th3) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th3;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj == null ? f4615r : obj;
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
        c cVar = this.f4617m;
        c cVar2 = c.f4625d;
        if (cVar != cVar2) {
            c cVar3 = new c(runnable, executor);
            do {
                cVar3.f4628c = cVar;
                if (f4614q.a(this, cVar, cVar3)) {
                    return;
                } else {
                    cVar = this.f4617m;
                }
            } while (cVar != cVar2);
        }
        c(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f4616b;
        if (!(obj == null) && !(obj instanceof e)) {
            return false;
        }
        b bVar = f4612o ? new b(z10, new CancellationException("Future.cancel() was called.")) : z10 ? b.f4621c : b.f4622d;
        boolean z11 = false;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f4614q.b(abstractFuture, obj, bVar)) {
                if (z10) {
                    abstractFuture.interruptTask();
                }
                b(abstractFuture);
                if (!(obj instanceof e)) {
                    return true;
                }
                e8.c<? extends V> cVar = ((e) obj).f4635m;
                if (!(cVar instanceof AbstractFuture)) {
                    cVar.cancel(z10);
                    return true;
                }
                abstractFuture = (AbstractFuture) cVar;
                obj = abstractFuture.f4616b;
                if (!(obj == null) && !(obj instanceof e)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = abstractFuture.f4616b;
                if (!(obj instanceof e)) {
                    return z11;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V d(Object obj) throws ExecutionException {
        if (obj instanceof b) {
            Throwable th2 = ((b) obj).f4624b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th2);
            throw cancellationException;
        }
        if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f4620a);
        }
        if (obj == f4615r) {
            return null;
        }
        return obj;
    }

    public final void f(g gVar) {
        gVar.f4637a = null;
        while (true) {
            g gVar2 = this.f4618n;
            if (gVar2 == g.f4636c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f4638b;
                if (gVar2.f4637a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f4638b = gVar4;
                    if (gVar3.f4637a == null) {
                        break;
                    }
                } else if (!f4614q.c(this, gVar2, gVar4)) {
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.futures.AbstractFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4616b instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof e)) & (this.f4616b != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object obj = this.f4616b;
        if (obj instanceof e) {
            StringBuilder sb2 = new StringBuilder("setFuture=[");
            e8.c<? extends V> cVar = ((e) obj).f4635m;
            return ac.c.o(sb2, cVar == this ? "this future" : String.valueOf(cVar), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(V v10) {
        if (v10 == null) {
            v10 = (V) f4615r;
        }
        if (!f4614q.b(this, null, v10)) {
            return false;
        }
        b(this);
        return true;
    }

    public boolean setException(Throwable th2) {
        th2.getClass();
        if (!f4614q.b(this, null, new Failure(th2))) {
            return false;
        }
        b(this);
        return true;
    }

    public boolean setFuture(e8.c<? extends V> cVar) {
        Failure failure;
        cVar.getClass();
        Object obj = this.f4616b;
        if (obj == null) {
            if (cVar.isDone()) {
                if (!f4614q.b(this, null, e(cVar))) {
                    return false;
                }
                b(this);
                return true;
            }
            e eVar = new e(this, cVar);
            if (f4614q.b(this, null, eVar)) {
                try {
                    cVar.addListener(eVar, DirectExecutor.f4639b);
                } catch (Throwable th2) {
                    try {
                        failure = new Failure(th2);
                    } catch (Throwable unused) {
                        failure = Failure.f4619b;
                    }
                    f4614q.b(this, eVar, failure);
                }
                return true;
            }
            obj = this.f4616b;
        }
        if (obj instanceof b) {
            cVar.cancel(((b) obj).f4623a);
        }
        return false;
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

    public void afterDone() {
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f4616b;
            if ((obj2 != null) & (!(obj2 instanceof e))) {
                return d(obj2);
            }
            g gVar = this.f4618n;
            g gVar2 = g.f4636c;
            if (gVar != gVar2) {
                g gVar3 = new g();
                do {
                    a aVar = f4614q;
                    aVar.d(gVar3, gVar);
                    if (aVar.c(this, gVar, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f4616b;
                            } else {
                                f(gVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof e))));
                        return d(obj);
                    }
                    gVar = this.f4618n;
                } while (gVar != gVar2);
            }
            return d(this.f4616b);
        }
        throw new InterruptedException();
    }
}
