package pg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.i2;
import kg.p0;
import kg.y0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedContinuation.kt */
/* loaded from: classes2.dex */
public final class i<T> extends p0<T> implements sf.c, qf.c<T> {

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17700s = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: o, reason: collision with root package name */
    public final kotlinx.coroutines.b f17701o;

    /* renamed from: p, reason: collision with root package name */
    public final qf.c<T> f17702p;

    /* renamed from: q, reason: collision with root package name */
    public Object f17703q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f17704r;

    /* JADX WARN: Multi-variable type inference failed */
    public i(kotlinx.coroutines.b bVar, qf.c<? super T> cVar) {
        super(-1);
        this.f17701o = bVar;
        this.f17702p = cVar;
        this.f17703q = j.f17709a;
        this.f17704r = ThreadContextKt.threadContextElements(getContext());
    }

    public final void awaitReusability() {
        while (f17700s.get(this) == j.f17710b) {
        }
    }

    @Override // kg.p0
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
        if (obj instanceof kg.a0) {
            ((kg.a0) obj).f15094b.invoke(th2);
        }
    }

    public final kg.m<T> claimReusableCancellableContinuation() {
        boolean z10;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17700s;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, j.f17710b);
                return null;
            }
            if (obj instanceof kg.m) {
                b0 b0Var = j.f17710b;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, b0Var)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    return (kg.m) obj;
                }
            } else if (obj != j.f17710b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(CoroutineContext coroutineContext, T t10) {
        this.f17703q = t10;
        this.f15131n = 1;
        this.f17701o.dispatchYield(coroutineContext, this);
    }

    @Override // sf.c
    public sf.c getCallerFrame() {
        qf.c<T> cVar = this.f17702p;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    @Override // qf.c
    public CoroutineContext getContext() {
        return this.f17702p.getContext();
    }

    public final boolean isReusable() {
        return f17700s.get(this) != null;
    }

    public final boolean postponeCancellation(Throwable th2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17700s;
            Object obj = atomicReferenceFieldUpdater.get(this);
            b0 b0Var = j.f17710b;
            boolean z10 = false;
            boolean z11 = true;
            if (zf.i.areEqual(obj, b0Var)) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, th2)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                        break;
                    }
                }
                if (z10) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z11 = false;
                        break;
                    }
                }
                if (z11) {
                    return false;
                }
            }
        }
    }

    public final void release() {
        awaitReusability();
        Object obj = f17700s.get(this);
        kg.m mVar = obj instanceof kg.m ? (kg.m) obj : null;
        if (mVar != null) {
            mVar.detachChild$kotlinx_coroutines_core();
        }
    }

    @Override // qf.c
    public void resumeWith(Object obj) {
        qf.c<T> cVar = this.f17702p;
        CoroutineContext context = cVar.getContext();
        Object state$default = kg.c0.toState$default(obj, null, 1, null);
        kotlinx.coroutines.b bVar = this.f17701o;
        if (bVar.isDispatchNeeded(context)) {
            this.f17703q = state$default;
            this.f15131n = 0;
            bVar.dispatch(context, this);
            return;
        }
        y0 eventLoop$kotlinx_coroutines_core = i2.f15113a.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            this.f17703q = state$default;
            this.f15131n = 0;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(this);
            return;
        }
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context2, this.f17704r);
            try {
                cVar.resumeWith(obj);
                lf.h hVar = lf.h.f16056a;
                while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent()) {
                }
            } finally {
                ThreadContextKt.restoreThreadContext(context2, objUpdateThreadContext);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // kg.p0
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this.f17703q;
        this.f17703q = j.f17709a;
        return obj;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f17701o + ", " + kg.i0.toDebugString(this.f17702p) + ']';
    }

    public final Throwable tryReleaseClaimedContinuation(kg.l<?> lVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17700s;
            Object obj = atomicReferenceFieldUpdater.get(this);
            b0 b0Var = j.f17710b;
            z10 = false;
            if (obj != b0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z10) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, lVar)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                    break;
                }
            }
        } while (!z10);
        return null;
    }

    @Override // kg.p0
    public qf.c<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }
}
