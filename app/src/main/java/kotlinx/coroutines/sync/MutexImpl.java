package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.i0;
import kg.l;
import kg.m;
import kg.m2;
import kg.o;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.b;
import kotlinx.coroutines.sync.MutexImpl;
import lf.h;
import pg.b0;
import pg.y;
import qf.c;
import sf.f;
import tg.a;
import yf.q;

/* compiled from: Mutex.kt */
/* loaded from: classes2.dex */
public final class MutexImpl extends SemaphoreImpl implements a {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15607h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");
    private volatile Object owner;

    /* compiled from: Mutex.kt */
    public final class CancellableContinuationWithOwner implements l<h>, m2 {

        /* renamed from: b, reason: collision with root package name */
        public final m<h> f15608b;

        /* renamed from: m, reason: collision with root package name */
        public final Object f15609m;

        /* JADX WARN: Multi-variable type inference failed */
        public CancellableContinuationWithOwner(m<? super h> mVar, Object obj) {
            this.f15608b = mVar;
            this.f15609m = obj;
        }

        @Override // kg.l
        public boolean cancel(Throwable th2) {
            return this.f15608b.cancel(th2);
        }

        @Override // kg.l
        public void completeResume(Object obj) {
            this.f15608b.completeResume(obj);
        }

        @Override // qf.c
        public CoroutineContext getContext() {
            return this.f15608b.getContext();
        }

        @Override // kg.m2
        public void invokeOnCancellation(y<?> yVar, int i10) {
            this.f15608b.invokeOnCancellation(yVar, i10);
        }

        @Override // kg.l
        public /* bridge */ /* synthetic */ void resume(h hVar, yf.l lVar) {
            resume2(hVar, (yf.l<? super Throwable, h>) lVar);
        }

        @Override // kg.l
        public void resumeUndispatched(b bVar, h hVar) {
            this.f15608b.resumeUndispatched(bVar, hVar);
        }

        @Override // qf.c
        public void resumeWith(Object obj) {
            this.f15608b.resumeWith(obj);
        }

        @Override // kg.l
        public /* bridge */ /* synthetic */ Object tryResume(h hVar, Object obj, yf.l lVar) {
            return tryResume2(hVar, obj, (yf.l<? super Throwable, h>) lVar);
        }

        @Override // kg.l
        public void invokeOnCancellation(yf.l<? super Throwable, h> lVar) {
            this.f15608b.invokeOnCancellation(lVar);
        }

        /* renamed from: resume, reason: avoid collision after fix types in other method */
        public void resume2(h hVar, yf.l<? super Throwable, h> lVar) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.f15607h;
            Object obj = this.f15609m;
            final MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, obj);
            this.f15608b.resume(hVar, new yf.l<Throwable, h>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$resume$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                    invoke2(th2);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    mutexImpl.unlock(this.f15609m);
                }
            });
        }

        /* renamed from: tryResume, reason: avoid collision after fix types in other method */
        public Object tryResume2(h hVar, Object obj, yf.l<? super Throwable, h> lVar) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Object objTryResume = this.f15608b.tryResume(hVar, obj, new yf.l<Throwable, h>() { // from class: kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner$tryResume$token$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                    invoke2(th2);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.f15607h;
                    MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner = this;
                    Object obj2 = cancellableContinuationWithOwner.f15609m;
                    MutexImpl mutexImpl2 = mutexImpl;
                    atomicReferenceFieldUpdater.set(mutexImpl2, obj2);
                    mutexImpl2.unlock(cancellableContinuationWithOwner.f15609m);
                }
            });
            if (objTryResume != null) {
                MutexImpl.f15607h.set(mutexImpl, this.f15609m);
            }
            return objTryResume;
        }
    }

    public MutexImpl(boolean z10) {
        super(1, z10 ? 1 : 0);
        this.owner = z10 ? null : tg.b.f19916a;
        new q<sg.b<?>, Object, Object, yf.l<? super Throwable, ? extends h>>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1
            {
                super(3);
            }

            @Override // yf.q
            public final yf.l<Throwable, h> invoke(sg.b<?> bVar, final Object obj, Object obj2) {
                final MutexImpl mutexImpl = this.f15615b;
                return new yf.l<Throwable, h>() { // from class: kotlinx.coroutines.sync.MutexImpl$onSelectCancellationUnlockConstructor$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // yf.l
                    public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                        invoke2(th2);
                        return h.f16056a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th2) {
                        mutexImpl.unlock(obj);
                    }
                };
            }
        };
    }

    public boolean holdsLock(Object obj) {
        while (isLocked()) {
            Object obj2 = f15607h.get(this);
            if (obj2 != tg.b.f19916a) {
                return obj2 == obj;
            }
        }
        return false;
    }

    @Override // tg.a
    public boolean isLocked() {
        return getAvailablePermits() == 0;
    }

    @Override // tg.a
    public Object lock(Object obj, c<? super h> cVar) {
        if (tryLock(obj)) {
            return h.f16056a;
        }
        m orCreateCancellableContinuation = o.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar));
        try {
            acquire(new CancellableContinuationWithOwner(orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            if (result == rf.a.getCOROUTINE_SUSPENDED()) {
                f.probeCoroutineSuspended(cVar);
            }
            if (result != rf.a.getCOROUTINE_SUSPENDED()) {
                result = h.f16056a;
            }
            return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
        } catch (Throwable th2) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th2;
        }
    }

    public String toString() {
        return "Mutex@" + i0.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + f15607h.get(this) + ']';
    }

    public boolean tryLock(Object obj) {
        char c10;
        do {
            if (tryAcquire()) {
                f15607h.set(this, obj);
                c10 = 0;
                break;
            }
            if (obj == null) {
                break;
            }
            if (holdsLock(obj)) {
                c10 = 2;
                break;
            }
        } while (!isLocked());
        c10 = 1;
        if (c10 == 0) {
            return true;
        }
        if (c10 == 1) {
            return false;
        }
        if (c10 != 2) {
            throw new IllegalStateException("unexpected".toString());
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // tg.a
    public void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15607h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != tg.b.f19916a) {
                boolean z10 = false;
                if (!(obj2 == obj || obj == null)) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                b0 b0Var = tg.b.f19916a;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, b0Var)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (z10) {
                    release();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked".toString());
    }
}
