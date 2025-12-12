package kotlinx.coroutines.channels;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kg.m;
import kg.m2;
import kg.o;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.TrySelectDetailedResult;
import lf.f;
import lf.h;
import mg.d;
import mg.k;
import pg.a0;
import pg.b0;
import pg.y;
import pg.z;
import qf.c;
import yf.l;
import yf.p;
import yf.q;
import zf.i;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public class BufferedChannel<E> implements mg.a<E> {

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15317n = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus");

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15318o = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15319p = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f15320q = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15321r = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment");

    /* renamed from: s, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15322s = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment");

    /* renamed from: t, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15323t = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment");

    /* renamed from: u, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15324u = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause");

    /* renamed from: v, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15325v = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* renamed from: b, reason: collision with root package name */
    public final int f15326b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: m, reason: collision with root package name */
    public final l<E, h> f15327m;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* compiled from: BufferedChannel.kt */
    public static final class b implements m2 {
        public final kg.l<Boolean> getCont() {
            return null;
        }

        @Override // kg.m2
        public void invokeOnCancellation(y<?> yVar, int i10) {
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i10, l<? super E, h> lVar) {
        this.f15326b = i10;
        this.f15327m = lVar;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(o1.a.d("Invalid channel capacity: ", i10, ", should be >=0").toString());
        }
        this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(i10);
        this.completedExpandBuffersAndPauseFlag = e();
        d dVar = new d(0L, null, this, 3);
        this.sendSegment = dVar;
        this.receiveSegment = dVar;
        if (h()) {
            dVar = BufferedChannelKt.f15339a;
            i.checkNotNull(dVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = dVar;
        if (lVar != 0) {
            new q<sg.b<?>, Object, Object, l<? super Throwable, ? extends h>>(this) { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ BufferedChannel<E> f15329b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                    this.f15329b = this;
                }

                @Override // yf.q
                public final l<Throwable, h> invoke(final sg.b<?> bVar, Object obj, final Object obj2) {
                    final BufferedChannel<E> bufferedChannel = this.f15329b;
                    return new l<Throwable, h>() { // from class: kotlinx.coroutines.channels.BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // yf.l
                        public /* bridge */ /* synthetic */ h invoke(Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            invoke2(th2);
                            return h.f16056a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                            b0 channel_closed = BufferedChannelKt.getCHANNEL_CLOSED();
                            Object obj3 = obj2;
                            if (obj3 != channel_closed) {
                                OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.f15327m, obj3, bVar.getContext());
                            }
                        }
                    };
                }
            };
        }
        this._closeCause = BufferedChannelKt.f15356r;
    }

    public static final d access$findSegmentSend(BufferedChannel bufferedChannel, long j10, d dVar) {
        Object objFindSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j11;
        long j12;
        boolean z10;
        bufferedChannel.getClass();
        p pVar = (p) BufferedChannelKt.createSegmentFunction();
        do {
            objFindSegmentInternal = pg.d.findSegmentInternal(dVar, j10, pVar);
            if (z.m235isClosedimpl(objFindSegmentInternal)) {
                break;
            }
            y yVarM234getSegmentimpl = z.m234getSegmentimpl(objFindSegmentInternal);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15321r;
                y yVar = (y) atomicReferenceFieldUpdater.get(bufferedChannel);
                z10 = true;
                if (yVar.f17734n >= yVarM234getSegmentimpl.f17734n) {
                    break;
                }
                boolean z11 = false;
                if (!yVarM234getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z10 = false;
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(bufferedChannel, yVar, yVarM234getSegmentimpl)) {
                        z11 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(bufferedChannel) != yVar) {
                        break;
                    }
                }
                if (z11) {
                    if (yVar.decPointers$kotlinx_coroutines_core()) {
                        yVar.remove();
                    }
                } else if (yVarM234getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    yVarM234getSegmentimpl.remove();
                }
            }
        } while (!z10);
        if (z.m235isClosedimpl(objFindSegmentInternal)) {
            bufferedChannel.isClosedForSend();
            if (dVar.f17734n * BufferedChannelKt.f15340b < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                dVar.cleanPrev();
            }
        } else {
            d dVar2 = (d) z.m234getSegmentimpl(objFindSegmentInternal);
            long j13 = dVar2.f17734n;
            if (j13 <= j10) {
                return dVar2;
            }
            long j14 = j13 * BufferedChannelKt.f15340b;
            do {
                atomicLongFieldUpdater = f15317n;
                j11 = atomicLongFieldUpdater.get(bufferedChannel);
                j12 = 1152921504606846975L & j11;
                if (j12 >= j14) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j11, BufferedChannelKt.access$constructSendersAndCloseStatus(j12, (int) (j11 >> 60))));
            if (dVar2.f17734n * BufferedChannelKt.f15340b < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                dVar2.cleanPrev();
            }
        }
        return null;
    }

    public static final boolean access$isClosedForSend0(BufferedChannel bufferedChannel, long j10) {
        return bufferedChannel.g(j10, false);
    }

    public static final void access$onClosedReceiveCatchingOnNoWaiterSuspend(BufferedChannel bufferedChannel, kg.l lVar) {
        bufferedChannel.getClass();
        int i10 = Result.f15189m;
        lVar.resumeWith(Result.m59constructorimpl(kotlinx.coroutines.channels.a.m71boximpl(kotlinx.coroutines.channels.a.f15358b.m81closedJP2dKIU(bufferedChannel.getCloseCause()))));
    }

    public static final void access$onClosedReceiveOnNoWaiterSuspend(BufferedChannel bufferedChannel, kg.l lVar) {
        bufferedChannel.getClass();
        int i10 = Result.f15189m;
        Throwable closeCause = bufferedChannel.getCloseCause();
        if (closeCause == null) {
            closeCause = new ClosedReceiveChannelException("Channel was closed");
        }
        lVar.resumeWith(Result.m59constructorimpl(f.createFailure(closeCause)));
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(BufferedChannel bufferedChannel, Object obj, kg.l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l<E, h> lVar2 = bufferedChannel.f15327m;
        if (lVar2 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(lVar2, obj, lVar.getContext());
        }
        Throwable sendException = bufferedChannel.getSendException();
        int i10 = Result.f15189m;
        lVar.resumeWith(Result.m59constructorimpl(f.createFailure(sendException)));
    }

    public static final void access$prepareReceiverForSuspension(BufferedChannel bufferedChannel, m2 m2Var, d dVar, int i10) {
        bufferedChannel.onReceiveEnqueued();
        m2Var.invokeOnCancellation(dVar, i10);
    }

    public static final void access$prepareSenderForSuspension(BufferedChannel bufferedChannel, m2 m2Var, d dVar, int i10) {
        bufferedChannel.getClass();
        m2Var.invokeOnCancellation(dVar, i10 + BufferedChannelKt.f15340b);
    }

    public static final int access$updateCellSend(BufferedChannel bufferedChannel, d dVar, int i10, Object obj, long j10, Object obj2, boolean z10) {
        bufferedChannel.getClass();
        dVar.storeElement$kotlinx_coroutines_core(i10, obj);
        if (z10) {
            return bufferedChannel.q(dVar, i10, obj, j10, obj2, z10);
        }
        Object state$kotlinx_coroutines_core = dVar.getState$kotlinx_coroutines_core(i10);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferedChannel.a(j10)) {
                if (dVar.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.f15342d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (dVar.casState$kotlinx_coroutines_core(i10, null, obj2)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof m2) {
            dVar.cleanElement$kotlinx_coroutines_core(i10);
            if (bufferedChannel.n(state$kotlinx_coroutines_core, obj)) {
                dVar.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15347i);
                bufferedChannel.onReceiveDequeued();
                return 0;
            }
            if (dVar.getAndSetState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15349k) != BufferedChannelKt.f15349k) {
                dVar.onCancelledRequest(i10, true);
            }
            return 5;
        }
        return bufferedChannel.q(dVar, i10, obj, j10, obj2, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ <E> java.lang.Object k(kotlinx.coroutines.channels.BufferedChannel<E> r14, qf.c<? super kotlinx.coroutines.channels.a<? extends E>> r15) throws java.lang.Throwable {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.f15335n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15335n = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L18:
            r6 = r0
            java.lang.Object r15 = r6.f15333b
            java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r6.f15335n
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            lf.f.throwOnFailure(r15)
            kotlinx.coroutines.channels.a r15 = (kotlinx.coroutines.channels.a) r15
            java.lang.Object r14 = r15.m80unboximpl()
            goto Lb6
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            lf.f.throwOnFailure(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = access$getReceiveSegment$FU$p()
            java.lang.Object r1 = r1.get(r14)
            mg.d r1 = (mg.d) r1
        L47:
            boolean r3 = r14.isClosedForReceive()
            if (r3 == 0) goto L59
            kotlinx.coroutines.channels.a$b r15 = kotlinx.coroutines.channels.a.f15358b
            java.lang.Throwable r14 = r14.getCloseCause()
            java.lang.Object r14 = r15.m81closedJP2dKIU(r14)
            goto Lb6
        L59:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = access$getReceivers$FU$p()
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.f15340b
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.f17734n
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L79
            mg.d r7 = access$findSegmentReceive(r14, r7, r1)
            if (r7 != 0) goto L77
            goto L47
        L77:
            r13 = r7
            goto L7a
        L79:
            r13 = r1
        L7a:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = access$updateCellReceive(r7, r8, r9, r10, r12)
            pg.b0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND$p()
            if (r1 == r7) goto Lb7
            pg.b0 r7 = kotlinx.coroutines.channels.BufferedChannelKt.access$getFAILED$p()
            if (r1 != r7) goto L9c
            long r7 = r14.getSendersCounter$kotlinx_coroutines_core()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L9a
            r13.cleanPrev()
        L9a:
            r1 = r13
            goto L47
        L9c:
            pg.b0 r15 = kotlinx.coroutines.channels.BufferedChannelKt.access$getSUSPEND_NO_WAITER$p()
            if (r1 != r15) goto Lad
            r6.f15335n = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.l(r2, r3, r4, r6)
            if (r14 != r0) goto Lb6
            return r0
        Lad:
            r13.cleanPrev()
            kotlinx.coroutines.channels.a$b r14 = kotlinx.coroutines.channels.a.f15358b
            java.lang.Object r14 = r14.m83successJP2dKIU(r1)
        Lb6:
            return r14
        Lb7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.k(kotlinx.coroutines.channels.BufferedChannel, qf.c):java.lang.Object");
    }

    public final boolean a(long j10) {
        return j10 < e() || j10 < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.f15326b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        r1 = (mg.d) r1.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final mg.d<E> b(long r12) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.b(long):mg.d");
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0012 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.c():void");
    }

    @Override // mg.i
    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th2) {
        if (th2 == null) {
            th2 = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th2, true);
    }

    @Override // mg.j
    public boolean close(Throwable th2) {
        return closeOrCancelImpl(th2, false);
    }

    public boolean closeOrCancelImpl(Throwable th2, boolean z10) {
        boolean z11;
        long j10;
        long jAccess$constructSendersAndCloseStatus;
        Object obj;
        boolean z12;
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15317n;
        if (z10) {
            do {
                j12 = atomicLongFieldUpdater.get(this);
                if (((int) (j12 >> 60)) != 0) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j12, BufferedChannelKt.access$constructSendersAndCloseStatus(j12 & 1152921504606846975L, 1)));
        }
        b0 b0Var = BufferedChannelKt.f15356r;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15324u;
            if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, th2)) {
                z11 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                z11 = false;
                break;
            }
        }
        if (z10) {
            do {
                j11 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j11, BufferedChannelKt.access$constructSendersAndCloseStatus(j11 & 1152921504606846975L, 3)));
        } else {
            do {
                j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 >> 60);
                if (i10 == 0) {
                    jAccess$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(j10 & 1152921504606846975L, 2);
                } else {
                    if (i10 != 1) {
                        break;
                    }
                    jAccess$constructSendersAndCloseStatus = BufferedChannelKt.access$constructSendersAndCloseStatus(j10 & 1152921504606846975L, 3);
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jAccess$constructSendersAndCloseStatus));
        }
        isClosedForSend();
        onClosedIdempotent();
        if (z11) {
            do {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15325v;
                obj = atomicReferenceFieldUpdater2.get(this);
                b0 b0Var2 = obj == null ? BufferedChannelKt.f15354p : BufferedChannelKt.f15355q;
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, obj, b0Var2)) {
                        z12 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        z12 = false;
                        break;
                    }
                }
            } while (!z12);
            if (obj != null) {
                ((l) obj).invoke(getCloseCause());
            }
        }
        return z11;
    }

    public final d<E> d(long j10, d<E> dVar) {
        Object objFindSegmentInternal;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j11;
        boolean z10;
        boolean z11;
        boolean z12;
        p pVar = (p) BufferedChannelKt.createSegmentFunction();
        do {
            objFindSegmentInternal = pg.d.findSegmentInternal(dVar, j10, pVar);
            if (z.m235isClosedimpl(objFindSegmentInternal)) {
                break;
            }
            y yVarM234getSegmentimpl = z.m234getSegmentimpl(objFindSegmentInternal);
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15322s;
                y yVar = (y) atomicReferenceFieldUpdater.get(this);
                if (yVar.f17734n >= yVarM234getSegmentimpl.f17734n) {
                    break;
                }
                if (!yVarM234getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z11 = false;
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, yVar, yVarM234getSegmentimpl)) {
                        z12 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != yVar) {
                        z12 = false;
                        break;
                    }
                }
                if (z12) {
                    if (yVar.decPointers$kotlinx_coroutines_core()) {
                        yVar.remove();
                    }
                } else if (yVarM234getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    yVarM234getSegmentimpl.remove();
                }
            }
            z11 = true;
        } while (!z11);
        if (z.m235isClosedimpl(objFindSegmentInternal)) {
            isClosedForSend();
            if (dVar.f17734n * BufferedChannelKt.f15340b >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            dVar.cleanPrev();
            return null;
        }
        d<E> dVar2 = (d) z.m234getSegmentimpl(objFindSegmentInternal);
        if (!h() && j10 <= e() / BufferedChannelKt.f15340b) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f15323t;
                y yVar2 = (y) atomicReferenceFieldUpdater2.get(this);
                if (yVar2.f17734n >= dVar2.f17734n || !dVar2.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                while (true) {
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, yVar2, dVar2)) {
                        z10 = true;
                        break;
                    }
                    if (atomicReferenceFieldUpdater2.get(this) != yVar2) {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    if (yVar2.decPointers$kotlinx_coroutines_core()) {
                        yVar2.remove();
                    }
                } else if (dVar2.decPointers$kotlinx_coroutines_core()) {
                    dVar2.remove();
                }
            }
        }
        long j12 = dVar2.f17734n;
        if (j12 <= j10) {
            return dVar2;
        }
        long j13 = j12 * BufferedChannelKt.f15340b;
        do {
            atomicLongFieldUpdater = f15318o;
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j13) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j11, j13));
        if (dVar2.f17734n * BufferedChannelKt.f15340b >= getSendersCounter$kotlinx_coroutines_core()) {
            return null;
        }
        dVar2.cleanPrev();
        return null;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j10) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        d<E> dVar = (d) f15322s.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f15318o;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(this.f15326b + j11, e())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = BufferedChannelKt.f15340b;
                long j12 = j11 / i10;
                int i11 = (int) (j11 % i10);
                if (dVar.f17734n != j12) {
                    d<E> dVarD = d(j12, dVar);
                    if (dVarD == null) {
                        continue;
                    } else {
                        dVar = dVarD;
                    }
                }
                Object objP = p(dVar, i11, j11, null);
                if (objP != BufferedChannelKt.f15353o) {
                    dVar.cleanPrev();
                    l<E, h> lVar = this.f15327m;
                    if (lVar != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, objP, null, 2, null)) != null) {
                        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
                    }
                } else if (j11 < getSendersCounter$kotlinx_coroutines_core()) {
                    dVar.cleanPrev();
                }
            }
        }
    }

    public final long e() {
        return f15319p.get(this);
    }

    public final void f(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15320q;
        if ((atomicLongFieldUpdater.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
            } while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ce, code lost:
    
        r12 = (mg.d) r12.getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(long r12, boolean r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.g(long, boolean):boolean");
    }

    public final Throwable getCloseCause() {
        return (Throwable) f15324u.get(this);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return f15318o.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException("Channel was closed") : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return f15317n.get(this) & 1152921504606846975L;
    }

    public final boolean h() {
        long jE = e();
        return jE == 0 || jE == Long.MAX_VALUE;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15322s;
            d<E> dVarD = (d) atomicReferenceFieldUpdater.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            boolean z10 = false;
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i10 = BufferedChannelKt.f15340b;
            long j10 = receiversCounter$kotlinx_coroutines_core / i10;
            if (dVarD.f17734n == j10 || (dVarD = d(j10, dVarD)) != null) {
                dVarD.cleanPrev();
                int i11 = (int) (receiversCounter$kotlinx_coroutines_core % i10);
                while (true) {
                    Object state$kotlinx_coroutines_core = dVarD.getState$kotlinx_coroutines_core(i11);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.f15343e) {
                        if (dVarD.casState$kotlinx_coroutines_core(i11, state$kotlinx_coroutines_core, BufferedChannelKt.f15346h)) {
                            c();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core == BufferedChannelKt.f15342d || (state$kotlinx_coroutines_core != BufferedChannelKt.f15348j && state$kotlinx_coroutines_core != BufferedChannelKt.getCHANNEL_CLOSED() && state$kotlinx_coroutines_core != BufferedChannelKt.f15347i && state$kotlinx_coroutines_core != BufferedChannelKt.f15346h && (state$kotlinx_coroutines_core == BufferedChannelKt.f15345g || (state$kotlinx_coroutines_core != BufferedChannelKt.f15344f && receiversCounter$kotlinx_coroutines_core == getReceiversCounter$kotlinx_coroutines_core())))) {
                        z10 = true;
                    }
                }
                if (z10) {
                    return true;
                }
                f15318o.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            } else if (((d) atomicReferenceFieldUpdater.get(this)).f17734n < j10) {
                return false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(long j10, d<E> dVar) {
        boolean z10;
        d<E> dVar2;
        d<E> dVar3;
        while (dVar.f17734n < j10 && (dVar3 = (d) dVar.getNext()) != null) {
            dVar = dVar3;
        }
        while (true) {
            if (!dVar.isRemoved() || (dVar2 = (d) dVar.getNext()) == null) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15323t;
                    y yVar = (y) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (yVar.f17734n >= dVar.f17734n) {
                        break;
                    }
                    boolean z11 = false;
                    if (!dVar.tryIncPointers$kotlinx_coroutines_core()) {
                        z10 = false;
                        break;
                    }
                    while (true) {
                        if (atomicReferenceFieldUpdater.compareAndSet(this, yVar, dVar)) {
                            z11 = true;
                            break;
                        } else if (atomicReferenceFieldUpdater.get(this) != yVar) {
                            break;
                        }
                    }
                    if (z11) {
                        if (yVar.decPointers$kotlinx_coroutines_core()) {
                            yVar.remove();
                        }
                    } else if (dVar.decPointers$kotlinx_coroutines_core()) {
                        dVar.remove();
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                dVar = dVar2;
            }
        }
    }

    @Override // mg.j
    public void invokeOnClose(l<? super Throwable, h> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean z10;
        boolean z11;
        while (true) {
            atomicReferenceFieldUpdater = f15325v;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, lVar)) {
                z10 = true;
                break;
            } else if (atomicReferenceFieldUpdater.get(this) != null) {
                z10 = false;
                break;
            }
        }
        if (z10) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != BufferedChannelKt.f15354p) {
                if (obj == BufferedChannelKt.f15355q) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            b0 b0Var = BufferedChannelKt.f15354p;
            b0 b0Var2 = BufferedChannelKt.f15355q;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, b0Var, b0Var2)) {
                    z11 = true;
                    break;
                } else if (atomicReferenceFieldUpdater.get(this) != b0Var) {
                    z11 = false;
                    break;
                }
            }
        } while (!z11);
        lVar.invoke(getCloseCause());
    }

    public boolean isClosedForReceive() {
        return g(f15317n.get(this), true);
    }

    public boolean isClosedForSend() {
        return g(f15317n.get(this), false);
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    public final Object j(E e10, c<? super h> cVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        l<E, h> lVar = this.f15327m;
        if (lVar == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, e10, null, 2, null)) == null) {
            Throwable sendException = getSendException();
            int i10 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(f.createFailure(sendException)));
        } else {
            lf.a.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, getSendException());
            int i11 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(f.createFailure(undeliveredElementExceptionCallUndeliveredElementCatchingException$default)));
        }
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(mg.d<E> r11, int r12, long r13, qf.c<? super kotlinx.coroutines.channels.a<? extends E>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.l(mg.d, int, long, qf.c):java.lang.Object");
    }

    public final void m(m2 m2Var, boolean z10) {
        Throwable sendException;
        if (m2Var instanceof b) {
            kg.l<Boolean> cont = ((b) m2Var).getCont();
            int i10 = Result.f15189m;
            cont.resumeWith(Result.m59constructorimpl(Boolean.FALSE));
            return;
        }
        if (m2Var instanceof kg.l) {
            c cVar = (c) m2Var;
            int i11 = Result.f15189m;
            if (z10) {
                sendException = getCloseCause();
                if (sendException == null) {
                    sendException = new ClosedReceiveChannelException("Channel was closed");
                }
            } else {
                sendException = getSendException();
            }
            cVar.resumeWith(Result.m59constructorimpl(f.createFailure(sendException)));
            return;
        }
        if (m2Var instanceof mg.h) {
            m<kotlinx.coroutines.channels.a<? extends E>> mVar = ((mg.h) m2Var).f16318b;
            int i12 = Result.f15189m;
            mVar.resumeWith(Result.m59constructorimpl(kotlinx.coroutines.channels.a.m71boximpl(kotlinx.coroutines.channels.a.f15358b.m81closedJP2dKIU(getCloseCause()))));
        } else if (m2Var instanceof a) {
            ((a) m2Var).tryResumeHasNextOnClosedChannel();
        } else if (m2Var instanceof sg.b) {
            ((sg.b) m2Var).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + m2Var).toString());
        }
    }

    public final boolean n(Object obj, E e10) {
        if (obj instanceof sg.b) {
            return ((sg.b) obj).trySelect(this, e10);
        }
        boolean z10 = obj instanceof mg.h;
        l<E, h> lVar = this.f15327m;
        if (z10) {
            i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            mg.h hVar = (mg.h) obj;
            return BufferedChannelKt.access$tryResume0(hVar.f16318b, kotlinx.coroutines.channels.a.m71boximpl(kotlinx.coroutines.channels.a.f15358b.m83successJP2dKIU(e10)), lVar != null ? OnUndeliveredElementKt.bindCancellationFun(lVar, e10, hVar.f16318b.getContext()) : null);
        }
        if (obj instanceof a) {
            i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).tryResumeHasNext(e10);
        }
        if (obj instanceof kg.l) {
            i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kg.l lVar2 = (kg.l) obj;
            return BufferedChannelKt.access$tryResume0(lVar2, e10, lVar != null ? OnUndeliveredElementKt.bindCancellationFun(lVar, e10, lVar2.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    public final boolean o(Object obj, d<E> dVar, int i10) {
        if (obj instanceof kg.l) {
            i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            kg.l lVar = (kg.l) obj;
            h hVar = h.f16056a;
            d<Object> dVar2 = BufferedChannelKt.f15339a;
            Object objTryResume = lVar.tryResume(hVar, null, null);
            if (objTryResume != null) {
                lVar.completeResume(objTryResume);
                return true;
            }
        } else if (obj instanceof sg.b) {
            i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultTrySelectDetailed = ((sg.a) obj).trySelectDetailed(this, h.f16056a);
            if (trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                dVar.cleanElement$kotlinx_coroutines_core(i10);
            }
            if (trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
        } else {
            if (!(obj instanceof b)) {
                throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
            }
            kg.l<Boolean> cont = ((b) obj).getCont();
            Boolean bool = Boolean.TRUE;
            d<Object> dVar3 = BufferedChannelKt.f15339a;
            Object objTryResume2 = cont.tryResume(bool, null, null);
            if (objTryResume2 != null) {
                cont.completeResume(objTryResume2);
                return true;
            }
        }
        return false;
    }

    public final Object p(d<E> dVar, int i10, long j10, Object obj) {
        Object state$kotlinx_coroutines_core = dVar.getState$kotlinx_coroutines_core(i10);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f15317n;
        if (state$kotlinx_coroutines_core == null) {
            if (j10 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.f15352n;
                }
                if (dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, obj)) {
                    c();
                    return BufferedChannelKt.f15351m;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.f15342d && dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.f15347i)) {
            c();
            return dVar.retrieveElement$kotlinx_coroutines_core(i10);
        }
        while (true) {
            Object state$kotlinx_coroutines_core2 = dVar.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core2 == null || state$kotlinx_coroutines_core2 == BufferedChannelKt.f15343e) {
                if (j10 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core2, BufferedChannelKt.f15346h)) {
                        c();
                        return BufferedChannelKt.f15353o;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.f15352n;
                    }
                    if (dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core2, obj)) {
                        c();
                        return BufferedChannelKt.f15351m;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core2 != BufferedChannelKt.f15342d) {
                    if (state$kotlinx_coroutines_core2 != BufferedChannelKt.f15348j && state$kotlinx_coroutines_core2 != BufferedChannelKt.f15346h) {
                        if (state$kotlinx_coroutines_core2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            c();
                            return BufferedChannelKt.f15353o;
                        }
                        if (state$kotlinx_coroutines_core2 != BufferedChannelKt.f15345g && dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core2, BufferedChannelKt.f15344f)) {
                            boolean z10 = state$kotlinx_coroutines_core2 instanceof k;
                            if (z10) {
                                state$kotlinx_coroutines_core2 = ((k) state$kotlinx_coroutines_core2).f16319a;
                            }
                            if (o(state$kotlinx_coroutines_core2, dVar, i10)) {
                                dVar.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15347i);
                                c();
                                return dVar.retrieveElement$kotlinx_coroutines_core(i10);
                            }
                            dVar.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15348j);
                            dVar.onCancelledRequest(i10, false);
                            if (z10) {
                                c();
                            }
                            return BufferedChannelKt.f15353o;
                        }
                    }
                    return BufferedChannelKt.f15353o;
                }
                if (dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core2, BufferedChannelKt.f15347i)) {
                    c();
                    return dVar.retrieveElement$kotlinx_coroutines_core(i10);
                }
            }
        }
    }

    public final int q(d<E> dVar, int i10, E e10, long j10, Object obj, boolean z10) {
        while (true) {
            Object state$kotlinx_coroutines_core = dVar.getState$kotlinx_coroutines_core(i10);
            if (state$kotlinx_coroutines_core == null) {
                if (!a(j10) || z10) {
                    if (z10) {
                        if (dVar.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.f15348j)) {
                            dVar.onCancelledRequest(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (dVar.casState$kotlinx_coroutines_core(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (dVar.casState$kotlinx_coroutines_core(i10, null, BufferedChannelKt.f15342d)) {
                    return 1;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.f15343e) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.f15349k) {
                        dVar.cleanElement$kotlinx_coroutines_core(i10);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.f15346h) {
                        dVar.cleanElement$kotlinx_coroutines_core(i10);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        dVar.cleanElement$kotlinx_coroutines_core(i10);
                        isClosedForSend();
                        return 4;
                    }
                    dVar.cleanElement$kotlinx_coroutines_core(i10);
                    if (state$kotlinx_coroutines_core instanceof k) {
                        state$kotlinx_coroutines_core = ((k) state$kotlinx_coroutines_core).f16319a;
                    }
                    if (n(state$kotlinx_coroutines_core, e10)) {
                        dVar.setState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15347i);
                        onReceiveDequeued();
                        return 0;
                    }
                    if (dVar.getAndSetState$kotlinx_coroutines_core(i10, BufferedChannelKt.f15349k) != BufferedChannelKt.f15349k) {
                        dVar.onCancelledRequest(i10, true);
                    }
                    return 5;
                }
                if (dVar.casState$kotlinx_coroutines_core(i10, state$kotlinx_coroutines_core, BufferedChannelKt.f15342d)) {
                    return 1;
                }
            }
        }
    }

    @Override // mg.i
    public Object receive(c<? super E> cVar) throws Throwable {
        d dVar;
        CoroutineContext context;
        d dVar2 = (d) f15322s.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = f15318o.getAndIncrement(this);
            long j10 = BufferedChannelKt.f15340b;
            long j11 = andIncrement / j10;
            int i10 = (int) (andIncrement % j10);
            if (dVar2.f17734n != j11) {
                d dVarD = d(j11, dVar2);
                if (dVarD == null) {
                    continue;
                } else {
                    dVar = dVarD;
                }
            } else {
                dVar = dVar2;
            }
            Object objP = p(dVar, i10, andIncrement, null);
            if (objP == BufferedChannelKt.f15351m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objP != BufferedChannelKt.f15353o) {
                if (objP == BufferedChannelKt.f15352n) {
                    m orCreateCancellableContinuation = o.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar));
                    try {
                        Object objP2 = p(dVar, i10, andIncrement, orCreateCancellableContinuation);
                        if (objP2 == BufferedChannelKt.f15351m) {
                            access$prepareReceiverForSuspension(this, orCreateCancellableContinuation, dVar, i10);
                        } else {
                            b0 b0Var = BufferedChannelKt.f15353o;
                            l<E, h> lVar = this.f15327m;
                            l<Throwable, h> lVarBindCancellationFun = null;
                            lVarBindCancellationFun = null;
                            if (objP2 == b0Var) {
                                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                    dVar.cleanPrev();
                                }
                                d dVar3 = (d) f15322s.get(this);
                                while (true) {
                                    if (isClosedForReceive()) {
                                        access$onClosedReceiveOnNoWaiterSuspend(this, orCreateCancellableContinuation);
                                        break;
                                    }
                                    long andIncrement2 = f15318o.getAndIncrement(this);
                                    long j12 = BufferedChannelKt.f15340b;
                                    long j13 = andIncrement2 / j12;
                                    int i11 = (int) (andIncrement2 % j12);
                                    if (dVar3.f17734n != j13) {
                                        d dVarD2 = d(j13, dVar3);
                                        if (dVarD2 != null) {
                                            dVar3 = dVarD2;
                                        }
                                    }
                                    Object objP3 = p(dVar3, i11, andIncrement2, orCreateCancellableContinuation);
                                    if (objP3 == BufferedChannelKt.f15351m) {
                                        m mVar = orCreateCancellableContinuation instanceof m2 ? orCreateCancellableContinuation : null;
                                        if (mVar != null) {
                                            access$prepareReceiverForSuspension(this, mVar, dVar3, i11);
                                        }
                                    } else if (objP3 == BufferedChannelKt.f15353o) {
                                        if (andIncrement2 < getSendersCounter$kotlinx_coroutines_core()) {
                                            dVar3.cleanPrev();
                                        }
                                    } else {
                                        if (objP3 == BufferedChannelKt.f15352n) {
                                            throw new IllegalStateException("unexpected".toString());
                                        }
                                        dVar3.cleanPrev();
                                        if (lVar != null) {
                                            context = orCreateCancellableContinuation.getContext();
                                            objP2 = objP3;
                                        } else {
                                            objP2 = objP3;
                                        }
                                    }
                                }
                                orCreateCancellableContinuation.resume(objP2, lVarBindCancellationFun);
                            } else {
                                dVar.cleanPrev();
                                if (lVar != null) {
                                    context = orCreateCancellableContinuation.getContext();
                                    lVarBindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(lVar, objP2, context);
                                }
                                orCreateCancellableContinuation.resume(objP2, lVarBindCancellationFun);
                            }
                        }
                        objP = orCreateCancellableContinuation.getResult();
                        if (objP == rf.a.getCOROUTINE_SUSPENDED()) {
                            sf.f.probeCoroutineSuspended(cVar);
                        }
                    } catch (Throwable th2) {
                        orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                        throw th2;
                    }
                } else {
                    dVar.cleanPrev();
                }
                return objP;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                dVar.cleanPrev();
            }
            dVar2 = dVar;
        }
        Throwable closeCause = getCloseCause();
        if (closeCause == null) {
            closeCause = new ClosedReceiveChannelException("Channel was closed");
        }
        throw a0.recoverStackTrace(closeCause);
    }

    @Override // mg.i
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo68receiveCatchingJP2dKIU(c<? super kotlinx.coroutines.channels.a<? extends E>> cVar) {
        return k(this, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01c6, code lost:
    
        return lf.h.f16056a;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0199  */
    /* JADX WARN: Type inference failed for: r1v10, types: [kg.m] */
    /* JADX WARN: Type inference failed for: r1v8, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // mg.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object send(E r21, qf.c<? super lf.h> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.send(java.lang.Object, qf.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d9, code lost:
    
        r3 = (mg.d) r3.getNext();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 523
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mg.i
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo69tryReceivePtdJZtk() {
        d dVar;
        long j10 = f15318o.get(this);
        long j11 = f15317n.get(this);
        if (g(j11, true)) {
            return kotlinx.coroutines.channels.a.f15358b.m81closedJP2dKIU(getCloseCause());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return kotlinx.coroutines.channels.a.f15358b.m82failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.f15349k;
        d dVar2 = (d) f15322s.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = f15318o.getAndIncrement(this);
            int i10 = BufferedChannelKt.f15340b;
            long j12 = andIncrement / i10;
            int i11 = (int) (andIncrement % i10);
            if (dVar2.f17734n != j12) {
                d dVarD = d(j12, dVar2);
                if (dVarD == null) {
                    continue;
                } else {
                    dVar = dVarD;
                }
            } else {
                dVar = dVar2;
            }
            Object objP = p(dVar, i11, andIncrement, obj);
            if (objP == BufferedChannelKt.f15351m) {
                m2 m2Var = obj instanceof m2 ? (m2) obj : null;
                if (m2Var != null) {
                    access$prepareReceiverForSuspension(this, m2Var, dVar, i11);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                dVar.onSlotCleaned();
                return kotlinx.coroutines.channels.a.f15358b.m82failurePtdJZtk();
            }
            if (objP != BufferedChannelKt.f15353o) {
                if (objP == BufferedChannelKt.f15352n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                dVar.cleanPrev();
                return kotlinx.coroutines.channels.a.f15358b.m83successJP2dKIU(objP);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                dVar.cleanPrev();
            }
            dVar2 = dVar;
        }
        return kotlinx.coroutines.channels.a.f15358b.m81closedJP2dKIU(getCloseCause());
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d7, code lost:
    
        return kotlinx.coroutines.channels.a.f15358b.m83successJP2dKIU(lf.h.f16056a);
     */
    @Override // mg.j
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo70trySendJP2dKIU(E r18) {
        /*
            r17 = this;
            r8 = r17
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.f15317n
            long r0 = r0.get(r8)
            r2 = 0
            boolean r3 = r8.g(r0, r2)
            r9 = 1
            r10 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L16
            goto L1d
        L16:
            long r0 = r0 & r10
            boolean r0 = r8.a(r0)
            r2 = r0 ^ 1
        L1d:
            if (r2 == 0) goto L26
            kotlinx.coroutines.channels.a$b r0 = kotlinx.coroutines.channels.a.f15358b
            java.lang.Object r0 = r0.m82failurePtdJZtk()
            return r0
        L26:
            pg.b0 r12 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = access$getSendSegment$FU$p()
            java.lang.Object r0 = r0.get(r8)
            mg.d r0 = (mg.d) r0
        L34:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = access$getSendersAndCloseStatus$FU$p()
            long r1 = r1.getAndIncrement(r8)
            long r13 = r1 & r10
            boolean r15 = access$isClosedForSend0(r8, r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f15340b
            long r2 = (long) r1
            long r2 = r13 / r2
            long r4 = (long) r1
            long r4 = r13 % r4
            int r7 = (int) r4
            long r4 = r0.f17734n
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L5c
            mg.d r1 = access$findSegmentSend(r8, r2, r0)
            if (r1 != 0) goto L5a
            if (r15 == 0) goto L34
            goto La6
        L5a:
            r6 = r1
            goto L5d
        L5c:
            r6 = r0
        L5d:
            r0 = r17
            r1 = r6
            r2 = r7
            r3 = r18
            r4 = r13
            r16 = r6
            r6 = r12
            r10 = r7
            r7 = r15
            int r0 = access$updateCellSend(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lca
            if (r0 == r9) goto Lcf
            r1 = 2
            if (r0 == r1) goto La1
            r1 = 3
            if (r0 == r1) goto L95
            r1 = 4
            if (r0 == r1) goto L89
            r1 = 5
            if (r0 == r1) goto L7e
            goto L81
        L7e:
            r16.cleanPrev()
        L81:
            r0 = r16
            r10 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L34
        L89:
            long r0 = r17.getReceiversCounter$kotlinx_coroutines_core()
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 >= 0) goto La6
            r16.cleanPrev()
            goto La6
        L95:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La1:
            if (r15 == 0) goto Lb1
            r16.onSlotCleaned()
        La6:
            kotlinx.coroutines.channels.a$b r0 = kotlinx.coroutines.channels.a.f15358b
            java.lang.Throwable r1 = r17.getSendException()
            java.lang.Object r0 = r0.m81closedJP2dKIU(r1)
            goto Ld7
        Lb1:
            boolean r0 = r12 instanceof kg.m2
            if (r0 == 0) goto Lb8
            kg.m2 r12 = (kg.m2) r12
            goto Lb9
        Lb8:
            r12 = 0
        Lb9:
            r0 = r16
            if (r12 == 0) goto Lc0
            access$prepareSenderForSuspension(r8, r12, r0, r10)
        Lc0:
            r0.onSlotCleaned()
            kotlinx.coroutines.channels.a$b r0 = kotlinx.coroutines.channels.a.f15358b
            java.lang.Object r0 = r0.m82failurePtdJZtk()
            goto Ld7
        Lca:
            r0 = r16
            r0.cleanPrev()
        Lcf:
            kotlinx.coroutines.channels.a$b r0 = kotlinx.coroutines.channels.a.f15358b
            lf.h r1 = lf.h.f16056a
            java.lang.Object r0 = r0.m83successJP2dKIU(r1)
        Ld7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.mo70trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        if (h()) {
            return;
        }
        while (e() <= j10) {
        }
        int i10 = BufferedChannelKt.f15341c;
        int i11 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f15320q;
            if (i11 >= i10) {
                do {
                    j11 = atomicLongFieldUpdater2.get(this);
                } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j11 & 4611686018427387903L, true)));
                while (true) {
                    long jE = e();
                    atomicLongFieldUpdater = f15320q;
                    long j13 = atomicLongFieldUpdater.get(this);
                    long j14 = j13 & 4611686018427387903L;
                    boolean z10 = (4611686018427387904L & j13) != 0;
                    if (jE == j14 && jE == e()) {
                        break;
                    } else if (!z10) {
                        atomicLongFieldUpdater.compareAndSet(this, j13, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j14, true));
                    }
                }
                do {
                    j12 = atomicLongFieldUpdater.get(this);
                } while (!atomicLongFieldUpdater.compareAndSet(this, j12, BufferedChannelKt.access$constructEBCompletedAndPauseFlag(j12 & 4611686018427387903L, false)));
                return;
            }
            long jE2 = e();
            if (jE2 == (atomicLongFieldUpdater2.get(this) & 4611686018427387903L) && jE2 == e()) {
                return;
            } else {
                i11++;
            }
        }
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    /* compiled from: BufferedChannel.kt */
    public final class a implements m2 {

        /* renamed from: b, reason: collision with root package name */
        public Object f15328b;

        public final boolean tryResumeHasNext(E e10) {
            i.checkNotNull(null);
            this.f15328b = e10;
            throw null;
        }

        public final void tryResumeHasNextOnClosedChannel() {
            i.checkNotNull(null);
            BufferedChannelKt.getCHANNEL_CLOSED();
            throw null;
        }

        @Override // kg.m2
        public void invokeOnCancellation(y<?> yVar, int i10) {
        }
    }
}
