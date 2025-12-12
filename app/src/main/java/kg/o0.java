package kg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public final class o0<T> extends pg.x<T> {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15129p = AtomicIntegerFieldUpdater.newUpdater(o0.class, "_decision");
    private volatile int _decision;

    public o0(CoroutineContext coroutineContext, qf.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // pg.x, kg.r1
    public void afterCompletion(Object obj) {
        afterResume(obj);
    }

    @Override // pg.x, kg.a
    public void afterResume(Object obj) {
        boolean z10;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15129p;
            int i10 = atomicIntegerFieldUpdater.get(this);
            z10 = false;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("Already resumed".toString());
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 2)) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            return;
        }
        qf.c<T> cVar = this.f17732o;
        pg.j.resumeCancellableWith$default(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), c0.recoverResult(obj, cVar), null, 2, null);
    }

    public final Object getResult() {
        boolean z10;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15129p;
            int i10 = atomicIntegerFieldUpdater.get(this);
            z10 = false;
            if (i10 != 0) {
                if (i10 != 2) {
                    throw new IllegalStateException("Already suspended".toString());
                }
            } else if (atomicIntegerFieldUpdater.compareAndSet(this, 0, 1)) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            return rf.a.getCOROUTINE_SUSPENDED();
        }
        Object objUnboxState = t1.unboxState(getState$kotlinx_coroutines_core());
        if (objUnboxState instanceof z) {
            throw ((z) objUnboxState).f15175a;
        }
        return objUnboxState;
    }
}
