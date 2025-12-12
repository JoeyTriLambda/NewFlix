package pg;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes2.dex */
public class o<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17720a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_cur");
    private volatile Object _cur;

    public o(boolean z10) {
        this._cur = new p(8, z10);
    }

    public final boolean addLast(E e10) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17720a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            int iAddLast = pVar.addLast(e10);
            if (iAddLast == 0) {
                return true;
            }
            if (iAddLast == 1) {
                p<E> next = pVar.next();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, pVar, next) && atomicReferenceFieldUpdater.get(this) == pVar) {
                }
            } else if (iAddLast == 2) {
                return false;
            }
        }
    }

    public final void close() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17720a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            if (pVar.close()) {
                return;
            }
            p<E> next = pVar.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, pVar, next) && atomicReferenceFieldUpdater.get(this) == pVar) {
            }
        }
    }

    public final int getSize() {
        return ((p) f17720a.get(this)).getSize();
    }

    public final E removeFirstOrNull() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17720a;
            p pVar = (p) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) pVar.removeFirstOrNull();
            if (e10 != p.f17724h) {
                return e10;
            }
            p<E> next = pVar.next();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, pVar, next) && atomicReferenceFieldUpdater.get(this) == pVar) {
            }
        }
    }
}
