package ng;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import pg.b0;

/* compiled from: StateFlow.kt */
/* loaded from: classes2.dex */
public final class m extends og.b<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f16833a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_state");
    private volatile Object _state;

    public final Object awaitPending(qf.c<? super lf.h> cVar) {
        boolean z10 = true;
        kg.m mVar = new kg.m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16833a;
        b0 b0Var = l.f16831a;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, mVar)) {
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            int i10 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(lf.h.f16056a));
        }
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : lf.h.f16056a;
    }

    public final void makePending() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16833a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null || obj == l.f16832b) {
                return;
            }
            boolean z10 = false;
            if (obj == l.f16831a) {
                b0 b0Var = l.f16832b;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, b0Var)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                b0 b0Var2 = l.f16831a;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, b0Var2)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (z10) {
                    int i10 = Result.f15189m;
                    ((kg.m) obj).resumeWith(Result.m59constructorimpl(lf.h.f16056a));
                    return;
                }
            }
        }
    }

    public final boolean takePending() {
        Object andSet = f16833a.getAndSet(this, l.f16831a);
        zf.i.checkNotNull(andSet);
        return andSet == l.f16832b;
    }

    @Override // og.b
    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16833a;
        if (atomicReferenceFieldUpdater.get(this) != null) {
            return false;
        }
        atomicReferenceFieldUpdater.set(this, l.f16831a);
        return true;
    }

    @Override // og.b
    public qf.c<lf.h>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        f16833a.set(this, null);
        return c8.i.f5255f;
    }
}
