package pg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import pg.e;

/* compiled from: ConcurrentLinkedList.kt */
/* loaded from: classes2.dex */
public abstract class e<N extends e<N>> {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17694b = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_next");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17695m = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public e(N n6) {
        this._prev = n6;
    }

    public static final Object access$getNextOrClosed(e eVar) {
        eVar.getClass();
        return f17694b.get(eVar);
    }

    public final void cleanPrev() {
        f17695m.lazySet(this, null);
    }

    public final N getNext() {
        Object objAccess$getNextOrClosed = access$getNextOrClosed(this);
        if (objAccess$getNextOrClosed == d.f17692a) {
            return null;
        }
        return (N) objAccess$getNextOrClosed;
    }

    public final N getPrev() {
        return (N) f17695m.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        return getNext() == null;
    }

    public final boolean markAsClosed() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        b0 b0Var = d.f17692a;
        do {
            atomicReferenceFieldUpdater = f17694b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, b0Var)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }

    public final void remove() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z10;
        e next;
        if (isTail()) {
            return;
        }
        while (true) {
            e prev = getPrev();
            while (true) {
                atomicReferenceFieldUpdater = f17695m;
                if (prev == null || !prev.isRemoved()) {
                    break;
                } else {
                    prev = (e) atomicReferenceFieldUpdater.get(prev);
                }
            }
            e next2 = getNext();
            zf.i.checkNotNull(next2);
            while (next2.isRemoved() && (next = next2.getNext()) != null) {
                next2 = next;
            }
            do {
                Object obj = atomicReferenceFieldUpdater.get(next2);
                e eVar = ((e) obj) == null ? null : prev;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(next2, obj, eVar)) {
                        z10 = true;
                        break;
                    } else if (atomicReferenceFieldUpdater.get(next2) != obj) {
                        z10 = false;
                        break;
                    }
                }
            } while (!z10);
            if (prev != null) {
                f17694b.set(prev, next2);
            }
            if (!next2.isRemoved() || next2.isTail()) {
                if (prev == null || !prev.isRemoved()) {
                    return;
                }
            }
        }
    }

    public final boolean trySetNext(N n6) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = f17694b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, n6)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return false;
    }
}
