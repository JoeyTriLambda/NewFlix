package kg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.k1;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public class r1 implements k1, t, a2 {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15135b = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_state");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15136m = AtomicReferenceFieldUpdater.newUpdater(r1.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* compiled from: JobSupport.kt */
    public static final class a<T> extends m<T> {

        /* renamed from: t, reason: collision with root package name */
        public final r1 f15137t;

        public a(qf.c<? super T> cVar, r1 r1Var) {
            super(cVar, 1);
            this.f15137t = r1Var;
        }

        @Override // kg.m
        public Throwable getContinuationCancellationCause(k1 k1Var) {
            Throwable rootCause;
            Object state$kotlinx_coroutines_core = this.f15137t.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof c) || (rootCause = ((c) state$kotlinx_coroutines_core).getRootCause()) == null) ? state$kotlinx_coroutines_core instanceof z ? ((z) state$kotlinx_coroutines_core).f15175a : k1Var.getCancellationException() : rootCause;
        }

        @Override // kg.m
        public String nameString() {
            return "AwaitContinuation";
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class b extends q1 {

        /* renamed from: p, reason: collision with root package name */
        public final r1 f15138p;

        /* renamed from: q, reason: collision with root package name */
        public final c f15139q;

        /* renamed from: r, reason: collision with root package name */
        public final s f15140r;

        /* renamed from: s, reason: collision with root package name */
        public final Object f15141s;

        public b(r1 r1Var, c cVar, s sVar, Object obj) {
            this.f15138p = r1Var;
            this.f15139q = cVar;
            this.f15140r = sVar;
            this.f15141s = obj;
        }

        @Override // yf.l
        public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
            invoke2(th2);
            return lf.h.f16056a;
        }

        @Override // kg.b0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th2) {
            r1.access$continueCompleting(this.f15138p, this.f15139q, this.f15140r, this.f15141s);
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class c implements f1 {

        /* renamed from: m, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f15142m = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* renamed from: n, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f15143n = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* renamed from: o, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f15144o = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: b, reason: collision with root package name */
        public final x1 f15145b;

        public c(x1 x1Var, boolean z10, Throwable th2) {
            this.f15145b = x1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th2;
        }

        public final void addExceptionLocked(Throwable th2) {
            Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(th2);
                return;
            }
            if (th2 == rootCause) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15144o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                atomicReferenceFieldUpdater.set(this, th2);
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th2);
                    return;
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
            if (th2 == obj) {
                return;
            }
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(obj);
            arrayList.add(th2);
            atomicReferenceFieldUpdater.set(this, arrayList);
        }

        @Override // kg.f1
        public x1 getList() {
            return this.f15145b;
        }

        public final Throwable getRootCause() {
            return (Throwable) f15143n.get(this);
        }

        @Override // kg.f1
        public boolean isActive() {
            return getRootCause() == null;
        }

        public final boolean isCancelling() {
            return getRootCause() != null;
        }

        public final boolean isCompleting() {
            return f15142m.get(this) != 0;
        }

        public final boolean isSealed() {
            return f15144o.get(this) == t1.f15157e;
        }

        public final List<Throwable> sealLocked(Throwable th2) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15144o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                arrayList = (ArrayList) obj;
            }
            Throwable rootCause = getRootCause();
            if (rootCause != null) {
                arrayList.add(0, rootCause);
            }
            if (th2 != null && !zf.i.areEqual(th2, rootCause)) {
                arrayList.add(th2);
            }
            atomicReferenceFieldUpdater.set(this, t1.f15157e);
            return arrayList;
        }

        public final void setCompleting(boolean z10) {
            f15142m.set(this, z10 ? 1 : 0);
        }

        public final void setRootCause(Throwable th2) {
            f15143n.set(this, th2);
        }

        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + isCompleting() + ", rootCause=" + getRootCause() + ", exceptions=" + f15144o.get(this) + ", list=" + getList() + ']';
        }
    }

    public r1(boolean z10) {
        this._state = z10 ? t1.f15159g : t1.f15158f;
    }

    public static final void access$continueCompleting(r1 r1Var, c cVar, s sVar, Object obj) {
        r1Var.getClass();
        s sVarG = g(sVar);
        if (sVarG == null || !r1Var.l(cVar, sVarG, obj)) {
            r1Var.afterCompletion(r1Var.d(cVar, obj));
        }
    }

    public static s g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof s) {
                    return (s) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof x1) {
                    return null;
                }
            }
        }
    }

    public static String j(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.isCancelling()) {
                return "Cancelling";
            }
            if (cVar.isCompleting()) {
                return "Completing";
            }
        } else {
            if (!(obj instanceof f1)) {
                return obj instanceof z ? "Cancelled" : "Completed";
            }
            if (!((f1) obj).isActive()) {
                return "New";
            }
        }
        return "Active";
    }

    public static /* synthetic */ CancellationException toCancellationException$default(r1 r1Var, Throwable th2, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return r1Var.toCancellationException(th2, str);
    }

    public final boolean a(Throwable th2) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z10 = th2 instanceof CancellationException;
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == y1.f15173b) ? z10 : parentHandle$kotlinx_coroutines_core.childCancelled(th2) || z10;
    }

    @Override // kg.k1
    public final r attachChild(t tVar) {
        u0 u0VarInvokeOnCompletion$default = k1.a.invokeOnCompletion$default(this, true, false, new s(tVar), 2, null);
        zf.i.checkNotNull(u0VarInvokeOnCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (r) u0VarInvokeOnCompletion$default;
    }

    public final Object awaitInternal(qf.c<Object> cVar) throws Throwable {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof f1)) {
                if (state$kotlinx_coroutines_core instanceof z) {
                    throw ((z) state$kotlinx_coroutines_core).f15175a;
                }
                return t1.unboxState(state$kotlinx_coroutines_core);
            }
        } while (i(state$kotlinx_coroutines_core) < 0);
        a aVar = new a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), this);
        aVar.initCancellability();
        o.disposeOnCancellation(aVar, invokeOnCompletion(new b2(aVar)));
        Object result = aVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result;
    }

    public final void b(f1 f1Var, Object obj) throws Throwable {
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(y1.f15173b);
        }
        CompletionHandlerException completionHandlerException = null;
        z zVar = obj instanceof z ? (z) obj : null;
        Throwable th2 = zVar != null ? zVar.f15175a : null;
        if (f1Var instanceof q1) {
            try {
                ((q1) f1Var).invoke(th2);
                return;
            } catch (Throwable th3) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + f1Var + " for " + this, th3));
                return;
            }
        }
        x1 list = f1Var.getList();
        if (list != null) {
            Object next = list.getNext();
            zf.i.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !zf.i.areEqual(nextNode, list); nextNode = nextNode.getNextNode()) {
                if (nextNode instanceof q1) {
                    q1 q1Var = (q1) nextNode;
                    try {
                        q1Var.invoke(th2);
                    } catch (Throwable th4) {
                        if (completionHandlerException != null) {
                            lf.a.addSuppressed(completionHandlerException, th4);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + q1Var + " for " + this, th4);
                            lf.h hVar = lf.h.f16056a;
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
            }
        }
    }

    public final Throwable c(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th2 = (Throwable) obj;
            return th2 == null ? new JobCancellationException(cancellationExceptionMessage(), null, this) : th2;
        }
        zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((a2) obj).getChildJobCancellationCause();
    }

    @Override // kg.k1
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }

    public final boolean cancelCoroutine(Throwable th2) {
        return cancelImpl$kotlinx_coroutines_core(th2);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00d3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean cancelImpl$kotlinx_coroutines_core(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.r1.cancelImpl$kotlinx_coroutines_core(java.lang.Object):boolean");
    }

    public void cancelInternal(Throwable th2) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(th2);
    }

    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(Throwable th2) {
        if (th2 instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th2) && getHandlesException$kotlinx_coroutines_core();
    }

    public final Object d(c cVar, Object obj) throws Throwable {
        boolean zIsCancelling;
        Throwable thE;
        boolean z10;
        z zVar = obj instanceof z ? (z) obj : null;
        Throwable th2 = zVar != null ? zVar.f15175a : null;
        synchronized (cVar) {
            zIsCancelling = cVar.isCancelling();
            List<Throwable> listSealLocked = cVar.sealLocked(th2);
            thE = e(cVar, listSealLocked);
            z10 = true;
            if (thE != null && listSealLocked.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listSealLocked.size()));
                for (Throwable th3 : listSealLocked) {
                    if (th3 != thE && th3 != thE && !(th3 instanceof CancellationException) && setNewSetFromMap.add(th3)) {
                        lf.a.addSuppressed(thE, th3);
                    }
                }
            }
        }
        if (thE != null && thE != th2) {
            obj = new z(thE, false, 2, null);
        }
        if (thE != null) {
            if (!a(thE) && !handleJobException(thE)) {
                z10 = false;
            }
            if (z10) {
                zf.i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((z) obj).makeHandled();
            }
        }
        if (!zIsCancelling) {
            onCancelling(thE);
        }
        onCompletionInternal(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15135b;
        Object objBoxIncomplete = t1.boxIncomplete(obj);
        while (!atomicReferenceFieldUpdater.compareAndSet(this, cVar, objBoxIncomplete) && atomicReferenceFieldUpdater.get(this) == cVar) {
        }
        b(cVar, obj);
        return obj;
    }

    public final Throwable e(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.isCancelling()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th2 = (Throwable) next;
        if (th2 != null) {
            return th2;
        }
        Throwable th3 = list.get(0);
        if (th3 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th4 = (Throwable) next2;
                if (th4 != th3 && (th4 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th5 = (Throwable) obj;
            if (th5 != null) {
                return th5;
            }
        }
        return th3;
    }

    public final x1 f(f1 f1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        x1 list = f1Var.getList();
        if (list != null) {
            return list;
        }
        if (f1Var instanceof x0) {
            return new x1();
        }
        if (!(f1Var instanceof q1)) {
            throw new IllegalStateException(("State should have list: " + f1Var).toString());
        }
        q1 q1Var = (q1) f1Var;
        q1Var.addOneIfEmpty(new x1());
        LockFreeLinkedListNode nextNode = q1Var.getNextNode();
        do {
            atomicReferenceFieldUpdater = f15135b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, q1Var, nextNode)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == q1Var);
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, yf.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) k1.a.fold(this, r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) k1.a.get(this, bVar);
    }

    @Override // kg.k1
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof c)) {
            if (state$kotlinx_coroutines_core instanceof f1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (state$kotlinx_coroutines_core instanceof z) {
                return toCancellationException$default(this, ((z) state$kotlinx_coroutines_core).f15175a, null, 1, null);
            }
            return new JobCancellationException(i0.getClassSimpleName(this) + " has completed normally", null, this);
        }
        Throwable rootCause = ((c) state$kotlinx_coroutines_core).getRootCause();
        if (rootCause != null) {
            CancellationException cancellationException = toCancellationException(rootCause, i0.getClassSimpleName(this) + " is cancelling");
            if (cancellationException != null) {
                return cancellationException;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // kg.a2
    public CancellationException getChildJobCancellationCause() {
        CancellationException rootCause;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof c) {
            rootCause = ((c) state$kotlinx_coroutines_core).getRootCause();
        } else if (state$kotlinx_coroutines_core instanceof z) {
            rootCause = ((z) state$kotlinx_coroutines_core).f15175a;
        } else {
            if (state$kotlinx_coroutines_core instanceof f1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            rootCause = null;
        }
        CancellationException cancellationException = rootCause instanceof CancellationException ? rootCause : null;
        return cancellationException == null ? new JobCancellationException("Parent job is ".concat(j(state$kotlinx_coroutines_core)), rootCause, this) : cancellationException;
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() throws Throwable {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof f1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (state$kotlinx_coroutines_core instanceof z) {
            throw ((z) state$kotlinx_coroutines_core).f15175a;
        }
        return t1.unboxState(state$kotlinx_coroutines_core);
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public final CoroutineContext.b<?> getKey() {
        return k1.b.f15119b;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kg.k1
    public k1 getParent() {
        r parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            return parentHandle$kotlinx_coroutines_core.getParent();
        }
        return null;
    }

    public final r getParentHandle$kotlinx_coroutines_core() {
        return (r) f15136m.get(this);
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = f15135b.get(this);
            if (!(obj instanceof pg.u)) {
                return obj;
            }
            ((pg.u) obj).perform(this);
        }
    }

    public final void h(x1 x1Var, Throwable th2) throws Throwable {
        onCancelling(th2);
        Object next = x1Var.getNext();
        zf.i.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) next; !zf.i.areEqual(nextNode, x1Var); nextNode = nextNode.getNextNode()) {
            if (nextNode instanceof l1) {
                q1 q1Var = (q1) nextNode;
                try {
                    q1Var.invoke(th2);
                } catch (Throwable th3) {
                    if (completionHandlerException != null) {
                        lf.a.addSuppressed(completionHandlerException, th3);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + q1Var + " for " + this, th3);
                        lf.h hVar = lf.h.f16056a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        a(th2);
    }

    public boolean handleJobException(Throwable th2) {
        return false;
    }

    public final int i(Object obj) {
        boolean z10 = obj instanceof x0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15135b;
        boolean z11 = false;
        if (z10) {
            if (((x0) obj).isActive()) {
                return 0;
            }
            x0 x0Var = t1.f15159g;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj, x0Var)) {
                    z11 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            if (!z11) {
                return -1;
            }
            onStart();
            return 1;
        }
        if (!(obj instanceof e1)) {
            return 0;
        }
        x1 list = ((e1) obj).getList();
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, list)) {
                z11 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                break;
            }
        }
        if (!z11) {
            return -1;
        }
        onStart();
        return 1;
    }

    public final void initParentJob(k1 k1Var) {
        y1 y1Var = y1.f15173b;
        if (k1Var == null) {
            setParentHandle$kotlinx_coroutines_core(y1Var);
            return;
        }
        k1Var.start();
        r rVarAttachChild = k1Var.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(rVarAttachChild);
        if (isCompleted()) {
            rVarAttachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(y1Var);
        }
    }

    @Override // kg.k1
    public final u0 invokeOnCompletion(yf.l<? super Throwable, lf.h> lVar) {
        return invokeOnCompletion(false, true, lVar);
    }

    @Override // kg.k1
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof f1) && ((f1) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kg.k1
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof z) || ((state$kotlinx_coroutines_core instanceof c) && ((c) state$kotlinx_coroutines_core).isCancelling());
    }

    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof f1);
    }

    public boolean isScopedCoroutine() {
        return false;
    }

    @Override // kg.k1
    public final Object join(qf.c<? super lf.h> cVar) {
        boolean z10;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof f1)) {
                z10 = false;
                break;
            }
            if (i(state$kotlinx_coroutines_core) >= 0) {
                z10 = true;
                break;
            }
        }
        if (!z10) {
            n1.ensureActive(cVar.getContext());
            return lf.h.f16056a;
        }
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        o.disposeOnCancellation(mVar, invokeOnCompletion(new c2(mVar)));
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        if (result != rf.a.getCOROUTINE_SUSPENDED()) {
            result = lf.h.f16056a;
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : lf.h.f16056a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [T, java.lang.Throwable] */
    public final Object k(Object obj, Object obj2) throws Throwable {
        boolean z10;
        if (!(obj instanceof f1)) {
            return t1.f15153a;
        }
        boolean z11 = false;
        s sVarG = null;
        if (((obj instanceof x0) || (obj instanceof q1)) && !(obj instanceof s) && !(obj2 instanceof z)) {
            f1 f1Var = (f1) obj;
            Object objBoxIncomplete = t1.boxIncomplete(obj2);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15135b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, f1Var, objBoxIncomplete)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != f1Var) {
                    z10 = false;
                    break;
                }
            }
            if (z10) {
                onCancelling(null);
                onCompletionInternal(obj2);
                b(f1Var, obj2);
                z11 = true;
            }
            return z11 ? obj2 : t1.f15155c;
        }
        f1 f1Var2 = (f1) obj;
        x1 x1VarF = f(f1Var2);
        if (x1VarF == null) {
            return t1.f15155c;
        }
        c cVar = f1Var2 instanceof c ? (c) f1Var2 : null;
        if (cVar == null) {
            cVar = new c(x1VarF, false, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        synchronized (cVar) {
            if (cVar.isCompleting()) {
                return t1.f15153a;
            }
            cVar.setCompleting(true);
            if (cVar != f1Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15135b;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, f1Var2, cVar)) {
                        z11 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.get(this) != f1Var2) {
                        break;
                    }
                }
                if (!z11) {
                    return t1.f15155c;
                }
            }
            boolean zIsCancelling = cVar.isCancelling();
            z zVar = obj2 instanceof z ? (z) obj2 : null;
            if (zVar != null) {
                cVar.addExceptionLocked(zVar.f15175a);
            }
            ?? rootCause = Boolean.valueOf(zIsCancelling ^ true).booleanValue() ? cVar.getRootCause() : 0;
            ref$ObjectRef.f15262b = rootCause;
            lf.h hVar = lf.h.f16056a;
            if (rootCause != 0) {
                h(x1VarF, rootCause);
            }
            s sVar = f1Var2 instanceof s ? (s) f1Var2 : null;
            if (sVar == null) {
                x1 list = f1Var2.getList();
                if (list != null) {
                    sVarG = g(list);
                }
            } else {
                sVarG = sVar;
            }
            return (sVarG == null || !l(cVar, sVarG, obj2)) ? d(cVar, obj2) : t1.f15154b;
        }
    }

    public final boolean l(c cVar, s sVar, Object obj) {
        while (k1.a.invokeOnCompletion$default(sVar.f15146p, false, false, new b(this, cVar, sVar, obj), 1, null) == y1.f15173b) {
            sVar = g(sVar);
            if (sVar == null) {
                return false;
            }
        }
        return true;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object obj) throws Throwable {
        Object objK;
        do {
            objK = k(getState$kotlinx_coroutines_core(), obj);
            if (objK == t1.f15153a) {
                return false;
            }
            if (objK == t1.f15154b) {
                return true;
            }
        } while (objK == t1.f15155c);
        afterCompletion(objK);
        return true;
    }

    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object obj) throws Throwable {
        Object objK;
        do {
            objK = k(getState$kotlinx_coroutines_core(), obj);
            if (objK == t1.f15153a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                z zVar = obj instanceof z ? (z) obj : null;
                throw new IllegalStateException(str, zVar != null ? zVar.f15175a : null);
            }
        } while (objK == t1.f15155c);
        return objK;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return k1.a.minusKey(this, bVar);
    }

    public String nameString$kotlinx_coroutines_core() {
        return i0.getClassSimpleName(this);
    }

    @Override // kg.t
    public final void parentCancelled(a2 a2Var) throws Throwable {
        cancelImpl$kotlinx_coroutines_core(a2Var);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return k1.a.plus(this, coroutineContext);
    }

    public final void removeNode$kotlinx_coroutines_core(q1 q1Var) {
        boolean z10;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof q1)) {
                if (!(state$kotlinx_coroutines_core instanceof f1) || ((f1) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                q1Var.remove();
                return;
            }
            if (state$kotlinx_coroutines_core != q1Var) {
                return;
            }
            x0 x0Var = t1.f15159g;
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15135b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, x0Var)) {
                    z10 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != state$kotlinx_coroutines_core) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
    }

    public final void setParentHandle$kotlinx_coroutines_core(r rVar) {
        f15136m.set(this, rVar);
    }

    @Override // kg.k1
    public final boolean start() {
        int i10;
        do {
            i10 = i(getState$kotlinx_coroutines_core());
            if (i10 == 0) {
                return false;
            }
        } while (i10 != 1);
        return true;
    }

    public final CancellationException toCancellationException(Throwable th2, String str) {
        CancellationException jobCancellationException = th2 instanceof CancellationException ? (CancellationException) th2 : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            jobCancellationException = new JobCancellationException(str, th2, this);
        }
        return jobCancellationException;
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + j(getState$kotlinx_coroutines_core()) + '}';
    }

    public String toString() {
        return toDebugString() + '@' + i0.getHexAddress(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f0  */
    /* JADX WARN: Type inference failed for: r4v6, types: [kg.e1] */
    @Override // kg.k1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kg.u0 invokeOnCompletion(boolean r11, boolean r12, yf.l<? super java.lang.Throwable, lf.h> r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.r1.invokeOnCompletion(boolean, boolean, yf.l):kg.u0");
    }

    public void onStart() {
    }

    public void afterCompletion(Object obj) {
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable th2) throws Throwable {
        throw th2;
    }

    public void onCancelling(Throwable th2) {
    }

    public void onCompletionInternal(Object obj) {
    }
}
