package kg;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.k1;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletionHandlerException;

/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes2.dex */
public class m<T> extends p0<T> implements l<T>, sf.c, m2 {

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15122q = AtomicIntegerFieldUpdater.newUpdater(m.class, "_decisionAndIndex");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15123r = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state");

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15124s = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: o, reason: collision with root package name */
    public final qf.c<T> f15125o;

    /* renamed from: p, reason: collision with root package name */
    public final CoroutineContext f15126p;

    /* JADX WARN: Multi-variable type inference failed */
    public m(qf.c<? super T> cVar, int i10) {
        super(i10);
        this.f15125o = cVar;
        this.f15126p = cVar.getContext();
        this._decisionAndIndex = 536870911;
        this._state = d.f15099b;
    }

    public static void e(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public static Object g(z1 z1Var, Object obj, int i10, yf.l lVar, Object obj2) {
        if (obj instanceof z) {
            return obj;
        }
        if (!q0.isCancellableMode(i10) && obj2 == null) {
            return obj;
        }
        if (lVar == null && !(z1Var instanceof j) && obj2 == null) {
            return obj;
        }
        return new y(obj, z1Var instanceof j ? (j) z1Var : null, lVar, obj2, null, 16, null);
    }

    public final void a(pg.y<?> yVar, Throwable th2) {
        int i10 = f15122q.get(this) & 536870911;
        if (!(i10 != 536870911)) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken".toString());
        }
        try {
            yVar.onCancellation(i10, th2, getContext());
        } catch (Throwable th3) {
            f0.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void b(int i10) {
        boolean z10;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15122q;
            int i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            z10 = true;
            if (i12 != 0) {
                if (i12 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
                z10 = false;
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i11, (536870911 & i11) + 1073741824)) {
                break;
            }
        }
        if (z10) {
            return;
        }
        q0.dispatch(this, i10);
    }

    public final u0 c() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        CoroutineContext context = getContext();
        int i10 = k1.f15118i;
        k1 k1Var = (k1) context.get(k1.b.f15119b);
        if (k1Var == null) {
            return null;
        }
        u0 u0VarInvokeOnCompletion$default = k1.a.invokeOnCompletion$default(k1Var, true, false, new q(this), 2, null);
        do {
            atomicReferenceFieldUpdater = f15124s;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, u0VarInvokeOnCompletion$default)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return u0VarInvokeOnCompletion$default;
    }

    public final void callCancelHandler(j jVar, Throwable th2) {
        try {
            jVar.invoke(th2);
        } catch (Throwable th3) {
            f0.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th3));
        }
    }

    public final void callOnCancellation(yf.l<? super Throwable, lf.h> lVar, Throwable th2) {
        try {
            lVar.invoke(th2);
        } catch (Throwable th3) {
            f0.handleCoroutineException(getContext(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th3));
        }
    }

    @Override // kg.l
    public boolean cancel(Throwable th2) {
        Object obj;
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
            obj = atomicReferenceFieldUpdater.get(this);
            z10 = false;
            if (!(obj instanceof z1)) {
                return false;
            }
            p pVar = new p(this, th2, (obj instanceof j) || (obj instanceof pg.y));
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, pVar)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
        } while (!z10);
        z1 z1Var = (z1) obj;
        if (z1Var instanceof j) {
            callCancelHandler((j) obj, th2);
        } else if (z1Var instanceof pg.y) {
            a((pg.y) obj, th2);
        }
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        b(this.f15131n);
        return true;
    }

    @Override // kg.p0
    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof z1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof z) {
                return;
            }
            boolean z10 = false;
            if (obj2 instanceof y) {
                y yVar = (y) obj2;
                if (!(!yVar.getCancelled())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                y yVarCopy$default = y.copy$default(yVar, null, null, null, null, th2, 15, null);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, yVarCopy$default)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (z10) {
                    yVar.invokeHandlers(this, th2);
                    return;
                }
            } else {
                y yVar2 = new y(obj2, null, null, null, th2, 14, null);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, yVar2)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (z10) {
                    return;
                }
            }
        }
    }

    @Override // kg.l
    public void completeResume(Object obj) {
        b(this.f15131n);
    }

    public final void d(Object obj) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z10 = true;
            if (obj2 instanceof d) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, obj)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                if (obj2 instanceof j ? true : obj2 instanceof pg.y) {
                    e(obj, obj2);
                    throw null;
                }
                boolean z11 = obj2 instanceof z;
                if (z11) {
                    z zVar = (z) obj2;
                    if (!zVar.makeHandled()) {
                        e(obj, obj2);
                        throw null;
                    }
                    if (obj2 instanceof p) {
                        if (!z11) {
                            zVar = null;
                        }
                        Throwable th2 = zVar != null ? zVar.f15175a : null;
                        if (obj instanceof j) {
                            callCancelHandler((j) obj, th2);
                            return;
                        } else {
                            zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                            a((pg.y) obj, th2);
                            return;
                        }
                    }
                    return;
                }
                if (obj2 instanceof y) {
                    y yVar = (y) obj2;
                    if (yVar.f15166b != null) {
                        e(obj, obj2);
                        throw null;
                    }
                    if (obj instanceof pg.y) {
                        return;
                    }
                    zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    j jVar = (j) obj;
                    if (yVar.getCancelled()) {
                        callCancelHandler(jVar, yVar.f15169e);
                        return;
                    }
                    y yVarCopy$default = y.copy$default(yVar, null, jVar, null, null, null, 29, null);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, yVarCopy$default)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        return;
                    }
                } else {
                    if (obj instanceof pg.y) {
                        return;
                    }
                    zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    y yVar2 = new y(obj2, (j) obj, null, null, null, 28, null);
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, yVar2)) {
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            z10 = false;
                            break;
                        }
                    }
                    if (z10) {
                        return;
                    }
                }
            }
        }
    }

    public final void detachChild$kotlinx_coroutines_core() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15124s;
        u0 u0Var = (u0) atomicReferenceFieldUpdater.get(this);
        if (u0Var == null) {
            return;
        }
        u0Var.dispose();
        atomicReferenceFieldUpdater.set(this, y1.f15173b);
    }

    public final void f(Object obj, int i10, yf.l<? super Throwable, lf.h> lVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof z1)) {
                if (obj2 instanceof p) {
                    p pVar = (p) obj2;
                    if (pVar.makeResumed()) {
                        if (lVar != null) {
                            callOnCancellation(lVar, pVar.f15175a);
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            Object objG = g((z1) obj2, obj, i10, lVar, null);
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objG)) {
                    z10 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        b(i10);
    }

    @Override // sf.c
    public sf.c getCallerFrame() {
        qf.c<T> cVar = this.f15125o;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    @Override // qf.c
    public CoroutineContext getContext() {
        return this.f15126p;
    }

    public Throwable getContinuationCancellationCause(k1 k1Var) {
        return k1Var.getCancellationException();
    }

    @Override // kg.p0
    public final qf.c<T> getDelegate$kotlinx_coroutines_core() {
        return this.f15125o;
    }

    @Override // kg.p0
    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            return exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    public final Object getResult() {
        boolean z10;
        k1 k1Var;
        boolean zIsReusable = isReusable();
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15122q;
            int i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
                z10 = false;
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, i10, (536870911 & i10) + 536870912)) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            if (((u0) f15124s.get(this)) == null) {
                c();
            }
            if (zIsReusable) {
                releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            }
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        if (zIsReusable) {
            releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof z) {
            throw ((z) state$kotlinx_coroutines_core).f15175a;
        }
        if (!q0.isCancellableMode(this.f15131n) || (k1Var = (k1) getContext().get(k1.b.f15119b)) == null || k1Var.isActive()) {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
        CancellationException cancellationException = k1Var.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
        throw cancellationException;
    }

    public final Object getState$kotlinx_coroutines_core() {
        return f15123r.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kg.p0
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj instanceof y ? (T) ((y) obj).f15165a : obj;
    }

    public void initCancellability() {
        u0 u0VarC = c();
        if (u0VarC != null && isCompleted()) {
            u0VarC.dispose();
            f15124s.set(this, y1.f15173b);
        }
    }

    @Override // kg.m2
    public void invokeOnCancellation(pg.y<?> yVar, int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f15122q;
            i11 = atomicIntegerFieldUpdater.get(this);
            if (!((i11 & 536870911) == 536870911)) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once".toString());
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        d(yVar);
    }

    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof z1);
    }

    public final boolean isReusable() {
        if (q0.isReusableMode(this.f15131n)) {
            qf.c<T> cVar = this.f15125o;
            zf.i.checkNotNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((pg.i) cVar).isReusable()) {
                return true;
            }
        }
        return false;
    }

    public String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(Throwable th2) {
        boolean zPostponeCancellation;
        if (isReusable()) {
            qf.c<T> cVar = this.f15125o;
            zf.i.checkNotNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            zPostponeCancellation = ((pg.i) cVar).postponeCancellation(th2);
        } else {
            zPostponeCancellation = false;
        }
        if (zPostponeCancellation) {
            return;
        }
        cancel(th2);
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    public final void releaseClaimedReusableContinuation$kotlinx_coroutines_core() {
        Throwable thTryReleaseClaimedContinuation;
        qf.c<T> cVar = this.f15125o;
        pg.i iVar = cVar instanceof pg.i ? (pg.i) cVar : null;
        if (iVar == null || (thTryReleaseClaimedContinuation = iVar.tryReleaseClaimedContinuation(this)) == null) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
        cancel(thTryReleaseClaimedContinuation);
    }

    public final boolean resetStateReusable() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof y) && ((y) obj).f15168d != null) {
            detachChild$kotlinx_coroutines_core();
            return false;
        }
        f15122q.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, d.f15099b);
        return true;
    }

    @Override // kg.l
    public void resume(T t10, yf.l<? super Throwable, lf.h> lVar) {
        f(t10, this.f15131n, lVar);
    }

    @Override // kg.l
    public void resumeUndispatched(kotlinx.coroutines.b bVar, T t10) {
        qf.c<T> cVar = this.f15125o;
        pg.i iVar = cVar instanceof pg.i ? (pg.i) cVar : null;
        f(t10, (iVar != null ? iVar.f17701o : null) == bVar ? 4 : this.f15131n, null);
    }

    @Override // qf.c
    public void resumeWith(Object obj) {
        f(c0.toState(obj, this), this.f15131n, null);
    }

    @Override // kg.p0
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(nameString());
        sb2.append('(');
        sb2.append(i0.toDebugString(this.f15125o));
        sb2.append("){");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        sb2.append(state$kotlinx_coroutines_core instanceof z1 ? "Active" : state$kotlinx_coroutines_core instanceof p ? "Cancelled" : "Completed");
        sb2.append("}@");
        sb2.append(i0.getHexAddress(this));
        return sb2.toString();
    }

    @Override // kg.l
    public Object tryResume(T t10, Object obj, yf.l<? super Throwable, lf.h> lVar) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15123r;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof z1)) {
                if ((obj2 instanceof y) && obj != null && ((y) obj2).f15168d == obj) {
                    return n.f15128a;
                }
                return null;
            }
            Object objG = g((z1) obj2, t10, this.f15131n, lVar, obj);
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, objG)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        if (!isReusable()) {
            detachChild$kotlinx_coroutines_core();
        }
        return n.f15128a;
    }

    @Override // kg.l
    public void invokeOnCancellation(yf.l<? super Throwable, lf.h> lVar) {
        d(lVar instanceof j ? (j) lVar : new h1(lVar));
    }
}
