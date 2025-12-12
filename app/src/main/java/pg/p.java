package pg;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes2.dex */
public final class p<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f17721e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f17722f = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f17723g = AtomicLongFieldUpdater.newUpdater(p.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f17724h = new b0("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f17725a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17726b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17727c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f17728d;

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final int addFailReason(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long updateHead(long j10, int i10) {
            return wo(j10, 1073741823L) | (i10 << 0);
        }

        public final long updateTail(long j10, int i10) {
            return wo(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long wo(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f17729a;

        public b(int i10) {
            this.f17729a = i10;
        }
    }

    public p(int i10, boolean z10) {
        this.f17725a = i10;
        this.f17726b = z10;
        int i11 = i10 - 1;
        this.f17727c = i11;
        this.f17728d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int addLast(E r15) {
        /*
            r14 = this;
        L0:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = pg.p.f17723g
            long r3 = r0.get(r14)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            pg.p$a r5 = pg.p.f17721e
            r7 = 0
            int r6 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r6 == 0) goto L16
            int r15 = r5.addFailReason(r3)
            return r15
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r2 = (int) r1
            r10 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r10 = r10 & r3
            r1 = 30
            long r10 = r10 >> r1
            int r11 = (int) r10
            int r1 = r11 + 2
            int r10 = r14.f17727c
            r1 = r1 & r10
            r6 = r2 & r10
            r12 = 1
            if (r1 != r6) goto L32
            return r12
        L32:
            boolean r1 = r14.f17726b
            java.util.concurrent.atomic.AtomicReferenceArray r13 = r14.f17728d
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L51
            r1 = r11 & r10
            java.lang.Object r1 = r13.get(r1)
            if (r1 == 0) goto L51
            r0 = 1024(0x400, float:1.435E-42)
            int r1 = r14.f17725a
            if (r1 < r0) goto L50
            int r11 = r11 - r2
            r0 = r11 & r6
            int r1 = r1 >> 1
            if (r0 <= r1) goto L0
        L50:
            return r12
        L51:
            int r1 = r11 + 1
            r1 = r1 & r6
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = pg.p.f17723g
            long r5 = r5.updateTail(r3, r1)
            r1 = r2
            r2 = r14
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L0
            r1 = r11 & r10
            r13.set(r1, r15)
            r1 = r14
        L68:
            long r2 = r0.get(r1)
            r4 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r2 = r2 & r4
            int r4 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r4 == 0) goto L91
            pg.p r1 = r1.next()
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r1.f17728d
            int r3 = r1.f17727c
            r3 = r3 & r11
            java.lang.Object r4 = r2.get(r3)
            boolean r5 = r4 instanceof pg.p.b
            if (r5 == 0) goto L8e
            pg.p$b r4 = (pg.p.b) r4
            int r4 = r4.f17729a
            if (r4 != r11) goto L8e
            r2.set(r3, r15)
            goto L8f
        L8e:
            r1 = 0
        L8f:
            if (r1 != 0) goto L68
        L91:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.p.addLast(java.lang.Object):int");
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        do {
            atomicLongFieldUpdater = f17723g;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, 2305843009213693952L | j10));
        return true;
    }

    public final int getSize() {
        long j10 = f17723g.get(this);
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0)));
    }

    public final boolean isEmpty() {
        long j10 = f17723g.get(this);
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final p<E> next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j10;
        while (true) {
            atomicLongFieldUpdater = f17723g;
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                break;
            }
            long j11 = j10 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j10, j11)) {
                j10 = j11;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17722f;
            p<E> pVar = (p) atomicReferenceFieldUpdater.get(this);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p(this.f17725a * 2, this.f17726b);
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            while (true) {
                int i12 = this.f17727c;
                int i13 = i10 & i12;
                if (i13 == (i12 & i11)) {
                    break;
                }
                Object bVar = this.f17728d.get(i13);
                if (bVar == null) {
                    bVar = new b(i10);
                }
                pVar2.f17728d.set(pVar2.f17727c & i10, bVar);
                i10++;
            }
            atomicLongFieldUpdater.set(pVar2, f17721e.wo(j10, 1152921504606846976L));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, pVar2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object removeFirstOrNull() {
        while (true) {
            long j10 = f17723g.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return f17724h;
            }
            int i10 = (int) ((j10 & 1073741823) >> 0);
            int i11 = this.f17727c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f17728d;
            Object obj = atomicReferenceArray.get(i10 & i11);
            boolean z10 = this.f17726b;
            if (obj == null) {
                if (z10) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                AtomicLongFieldUpdater atomicLongFieldUpdater = f17723g;
                a aVar = f17721e;
                if (atomicLongFieldUpdater.compareAndSet(this, j10, aVar.updateHead(j10, i12))) {
                    atomicReferenceArray.set(i10 & i11, null);
                    return obj;
                }
                if (z10) {
                    p<E> next = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f17723g;
                        long j11 = atomicLongFieldUpdater2.get(next);
                        int i13 = (int) ((j11 & 1073741823) >> 0);
                        if ((j11 & 1152921504606846976L) != 0) {
                            next = next.next();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(next, j11, aVar.updateHead(j11, i12))) {
                                next.f17728d.set(next.f17727c & i13, null);
                                next = null;
                            } else {
                                continue;
                            }
                        }
                        if (next == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
