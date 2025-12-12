package rg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: WorkQueue.kt */
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f18970b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f18971c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f18972d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f18973e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray<g> f18974a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final g a(g gVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f18971c;
        if (atomicIntegerFieldUpdater.get(this) - f18972d.get(this) == 127) {
            return gVar;
        }
        if (gVar.f18958m.getTaskMode() == 1) {
            f18973e.incrementAndGet(this);
        }
        int i10 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray<g> atomicReferenceArray = this.f18974a;
            if (atomicReferenceArray.get(i10) == null) {
                atomicReferenceArray.lazySet(i10, gVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final g add(g gVar, boolean z10) {
        if (z10) {
            return a(gVar);
        }
        g gVar2 = (g) f18970b.getAndSet(this, gVar);
        if (gVar2 == null) {
            return null;
        }
        return a(gVar2);
    }

    public final g b() {
        g andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f18972d;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 - f18971c.get(this) == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 + 1) && (andSet = this.f18974a.getAndSet(i11, null)) != null) {
                if (andSet.f18958m.getTaskMode() == 1) {
                    f18973e.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final g c(int i10, boolean z10) {
        int i11 = i10 & 127;
        AtomicReferenceArray<g> atomicReferenceArray = this.f18974a;
        g gVar = atomicReferenceArray.get(i11);
        if (gVar != null) {
            boolean z11 = false;
            if ((gVar.f18958m.getTaskMode() == 1) == z10) {
                while (true) {
                    if (atomicReferenceArray.compareAndSet(i11, gVar, null)) {
                        z11 = true;
                        break;
                    }
                    if (atomicReferenceArray.get(i11) != gVar) {
                        break;
                    }
                }
                if (z11) {
                    if (z10) {
                        f18973e.decrementAndGet(this);
                    }
                    return gVar;
                }
            }
        }
        return null;
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object obj = f18970b.get(this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f18972d;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f18971c;
        return obj != null ? (atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this)) + 1 : atomicIntegerFieldUpdater2.get(this) - atomicIntegerFieldUpdater.get(this);
    }

    public final void offloadAllWorkTo(c cVar) {
        boolean z10;
        g gVar = (g) f18970b.getAndSet(this, null);
        if (gVar != null) {
            cVar.addLast(gVar);
        }
        do {
            g gVarB = b();
            if (gVarB == null) {
                z10 = false;
            } else {
                cVar.addLast(gVarB);
                z10 = true;
            }
        } while (z10);
    }

    public final g poll() {
        g gVar = (g) f18970b.getAndSet(this, null);
        return gVar == null ? b() : gVar;
    }

    public final g pollBlocking() {
        g gVar;
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18970b;
            gVar = (g) atomicReferenceFieldUpdater.get(this);
            z10 = true;
            if (gVar != null) {
                if (gVar.f18958m.getTaskMode() == 1) {
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, gVar, null)) {
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != gVar) {
                            z10 = false;
                            break;
                        }
                    }
                }
            }
            int i10 = f18972d.get(this);
            int i11 = f18971c.get(this);
            while (i10 != i11 && f18973e.get(this) != 0) {
                i11--;
                g gVarC = c(i11, true);
                if (gVarC != null) {
                    return gVarC;
                }
            }
            return null;
        } while (!z10);
        return gVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [rg.g] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [rg.g] */
    /* JADX WARN: Type inference failed for: r6v4, types: [T, java.lang.Object, rg.g] */
    public final long trySteal(int i10, Ref$ObjectRef<g> ref$ObjectRef) {
        T tC;
        ?? r62;
        boolean z10;
        if (i10 == 3) {
            tC = b();
        } else {
            int i11 = f18972d.get(this);
            int i12 = f18971c.get(this);
            boolean z11 = i10 == 1;
            while (i11 != i12 && (!z11 || f18973e.get(this) != 0)) {
                int i13 = i11 + 1;
                tC = c(i11, z11);
                if (tC != 0) {
                    break;
                }
                i11 = i13;
            }
            tC = 0;
        }
        if (tC != 0) {
            ref$ObjectRef.f15262b = tC;
            return -1L;
        }
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f18970b;
            r62 = (g) atomicReferenceFieldUpdater.get(this);
            if (r62 != 0) {
                if (((r62.f18958m.getTaskMode() == 1 ? 1 : 2) & i10) != 0) {
                    long jNanoTime = k.f18966f.nanoTime() - r62.f18957b;
                    long j10 = k.f18962b;
                    if (jNanoTime < j10) {
                        return j10 - jNanoTime;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, r62, null)) {
                            z10 = true;
                            break;
                        }
                        if (atomicReferenceFieldUpdater.get(this) != r62) {
                            z10 = false;
                            break;
                        }
                    }
                }
            }
            return -2L;
        } while (!z10);
        ref$ObjectRef.f15262b = r62;
        return -1L;
    }
}
