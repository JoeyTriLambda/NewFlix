package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.i0;
import kotlin.jvm.internal.PropertyReference0Impl;
import pg.b;
import pg.n;
import pg.u;
import pg.v;
import zf.i;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes2.dex */
public class LockFreeLinkedListNode {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15558b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15559m = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15560n = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends b<LockFreeLinkedListNode> {

        /* renamed from: b, reason: collision with root package name */
        public final LockFreeLinkedListNode f15561b;

        /* renamed from: c, reason: collision with root package name */
        public LockFreeLinkedListNode f15562c;

        public a(LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f15561b = lockFreeLinkedListNode;
        }

        @Override // pg.b
        public void complete(LockFreeLinkedListNode lockFreeLinkedListNode, Object obj) {
            boolean z10 = true;
            boolean z11 = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f15561b;
            LockFreeLinkedListNode lockFreeLinkedListNode3 = z11 ? lockFreeLinkedListNode2 : this.f15562c;
            if (lockFreeLinkedListNode3 != null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode.f15558b;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, this, lockFreeLinkedListNode3)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != this) {
                        z10 = false;
                        break;
                    }
                }
                if (z10 && z11) {
                    LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f15562c;
                    i.checkNotNull(lockFreeLinkedListNode4);
                    lockFreeLinkedListNode2.b(lockFreeLinkedListNode4);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r6 = ((pg.v) r6).f17731a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004c, code lost:
    
        if (r5.compareAndSet(r4, r2, r6) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0053, code lost:
    
        if (r5.get(r4) == r2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0055, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if (r7 != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode a() {
        /*
            r11 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f15559m
            java.lang.Object r1 = r0.get(r11)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = r1
        L9:
            r3 = 0
            r4 = r3
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f15558b
            java.lang.Object r6 = r5.get(r2)
            r7 = 1
            r8 = 0
            if (r6 != r11) goto L2a
            if (r1 != r2) goto L18
            return r2
        L18:
            boolean r3 = r0.compareAndSet(r11, r1, r2)
            if (r3 == 0) goto L1f
            goto L26
        L1f:
            java.lang.Object r3 = r0.get(r11)
            if (r3 == r1) goto L18
            r7 = 0
        L26:
            if (r7 != 0) goto L29
            goto L0
        L29:
            return r2
        L2a:
            boolean r9 = r11.isRemoved()
            if (r9 == 0) goto L31
            return r3
        L31:
            if (r6 != 0) goto L34
            return r2
        L34:
            boolean r9 = r6 instanceof pg.u
            if (r9 == 0) goto L3e
            pg.u r6 = (pg.u) r6
            r6.perform(r2)
            goto L0
        L3e:
            boolean r9 = r6 instanceof pg.v
            if (r9 == 0) goto L62
            if (r4 == 0) goto L5b
            pg.v r6 = (pg.v) r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = r6.f17731a
        L48:
            boolean r3 = r5.compareAndSet(r4, r2, r6)
            if (r3 == 0) goto L4f
            goto L56
        L4f:
            java.lang.Object r3 = r5.get(r4)
            if (r3 == r2) goto L48
            r7 = 0
        L56:
            if (r7 != 0) goto L59
            goto L0
        L59:
            r2 = r4
            goto L9
        L5b:
            java.lang.Object r2 = r0.get(r2)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto Lb
        L62:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            zf.i.checkNotNull(r6, r4)
            r4 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r10 = r4
            r4 = r2
            r2 = r10
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.a():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode lockFreeLinkedListNode) {
        boolean z10;
        f15559m.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15558b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, this);
        do {
            z10 = false;
            if (getNext() != this) {
                return false;
            }
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, this, lockFreeLinkedListNode)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != this) {
                    break;
                }
            }
        } while (!z10);
        lockFreeLinkedListNode.b(this);
        return true;
    }

    public final void b(LockFreeLinkedListNode lockFreeLinkedListNode) {
        boolean z10;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15559m;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (getNext() != lockFreeLinkedListNode) {
                return;
            }
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                    z10 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != lockFreeLinkedListNode2) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        if (isRemoved()) {
            lockFreeLinkedListNode.a();
        }
    }

    public final Object getNext() {
        while (true) {
            Object obj = f15558b.get(this);
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).perform(this);
        }
    }

    public final LockFreeLinkedListNode getNextNode() {
        return n.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNodeA = a();
        if (lockFreeLinkedListNodeA == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15559m;
            Object obj = atomicReferenceFieldUpdater.get(this);
            while (true) {
                lockFreeLinkedListNodeA = (LockFreeLinkedListNode) obj;
                if (!lockFreeLinkedListNodeA.isRemoved()) {
                    break;
                }
                obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNodeA);
            }
        }
        return lockFreeLinkedListNodeA;
    }

    public boolean isRemoved() {
        return getNext() instanceof v;
    }

    public boolean remove() {
        return removeOrNext() == null;
    }

    public final LockFreeLinkedListNode removeOrNext() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        boolean z10;
        do {
            Object next = getNext();
            if (next instanceof v) {
                return ((v) next).f17731a;
            }
            if (next == this) {
                return (LockFreeLinkedListNode) next;
            }
            i.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
            lockFreeLinkedListNode.getClass();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15560n;
            v vVar = (v) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (vVar == null) {
                vVar = new v(lockFreeLinkedListNode);
                atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, vVar);
            }
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15558b;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, next, vVar)) {
                    z10 = true;
                    break;
                }
                if (atomicReferenceFieldUpdater2.get(this) != next) {
                    z10 = false;
                    break;
                }
            }
        } while (!z10);
        lockFreeLinkedListNode.a();
        return null;
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // gg.e
            public Object get() {
                return i0.getClassSimpleName(this.f15250m);
            }
        } + '@' + i0.getHexAddress(this);
    }

    public final int tryCondAddNext(LockFreeLinkedListNode lockFreeLinkedListNode, LockFreeLinkedListNode lockFreeLinkedListNode2, a aVar) {
        boolean z10;
        f15559m.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15558b;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        aVar.f15562c = lockFreeLinkedListNode2;
        while (true) {
            if (atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedListNode2, aVar)) {
                z10 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != lockFreeLinkedListNode2) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return aVar.perform(this) == null ? 1 : 2;
        }
        return 0;
    }
}
