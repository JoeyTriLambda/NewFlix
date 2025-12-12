package mg;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;
import pg.y;

/* compiled from: BufferedChannel.kt */
/* loaded from: classes2.dex */
public final class d<E> extends y<d<E>> {

    /* renamed from: p, reason: collision with root package name */
    public final BufferedChannel<E> f16316p;

    /* renamed from: q, reason: collision with root package name */
    public final AtomicReferenceArray f16317q;

    public d(long j10, d<E> dVar, BufferedChannel<E> bufferedChannel, int i10) {
        super(j10, dVar, i10);
        this.f16316p = bufferedChannel;
        this.f16317q = new AtomicReferenceArray(BufferedChannelKt.f15340b * 2);
    }

    public final boolean casState$kotlinx_coroutines_core(int i10, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f16317q;
        int i11 = (i10 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i11, obj, obj2)) {
            if (atomicReferenceArray.get(i11) != obj) {
                return false;
            }
        }
        return true;
    }

    public final void cleanElement$kotlinx_coroutines_core(int i10) {
        this.f16317q.lazySet(i10 * 2, null);
    }

    public final Object getAndSetState$kotlinx_coroutines_core(int i10, Object obj) {
        return this.f16317q.getAndSet((i10 * 2) + 1, obj);
    }

    public final BufferedChannel<E> getChannel() {
        BufferedChannel<E> bufferedChannel = this.f16316p;
        zf.i.checkNotNull(bufferedChannel);
        return bufferedChannel;
    }

    public final E getElement$kotlinx_coroutines_core(int i10) {
        return (E) this.f16317q.get(i10 * 2);
    }

    @Override // pg.y
    public int getNumberOfSlots() {
        return BufferedChannelKt.f15340b;
    }

    public final Object getState$kotlinx_coroutines_core(int i10) {
        return this.f16317q.get((i10 * 2) + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        cleanElement$kotlinx_coroutines_core(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0065, code lost:
    
        r4 = getChannel().f15327m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        if (r4 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    @Override // pg.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCancellation(int r4, java.lang.Throwable r5, kotlin.coroutines.CoroutineContext r6) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f15340b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.getElement$kotlinx_coroutines_core(r4)
        Le:
            java.lang.Object r1 = r3.getState$kotlinx_coroutines_core(r4)
            boolean r2 = r1 instanceof kg.m2
            if (r2 != 0) goto L71
            boolean r2 = r1 instanceof mg.k
            if (r2 == 0) goto L1b
            goto L71
        L1b:
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            if (r1 == r2) goto L60
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
            if (r1 != r2) goto L28
            goto L60
        L28:
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_EB$p()
            if (r1 == r2) goto Le
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getRESUMING_BY_RCV$p()
            if (r1 != r2) goto L35
            goto Le
        L35:
            pg.b0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.access$getDONE_RCV$p()
            if (r1 == r4) goto L5f
            pg.b0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.f15342d
            if (r1 != r4) goto L40
            goto L5f
        L40:
            pg.b0 r4 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            if (r1 != r4) goto L47
            return
        L47:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "unexpected state: "
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L5f:
            return
        L60:
            r3.cleanElement$kotlinx_coroutines_core(r4)
            if (r0 == 0) goto L70
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.getChannel()
            yf.l<E, lf.h> r4 = r4.f15327m
            if (r4 == 0) goto L70
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6)
        L70:
            return
        L71:
            if (r0 == 0) goto L78
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_SEND$p()
            goto L7c
        L78:
            pg.b0 r2 = kotlinx.coroutines.channels.BufferedChannelKt.access$getINTERRUPTED_RCV$p()
        L7c:
            boolean r1 = r3.casState$kotlinx_coroutines_core(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.cleanElement$kotlinx_coroutines_core(r4)
            r1 = r0 ^ 1
            r3.onCancelledRequest(r4, r1)
            if (r0 == 0) goto L97
            kotlinx.coroutines.channels.BufferedChannel r4 = r3.getChannel()
            yf.l<E, lf.h> r4 = r4.f15327m
            if (r4 == 0) goto L97
            kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElement(r4, r5, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: mg.d.onCancellation(int, java.lang.Throwable, kotlin.coroutines.CoroutineContext):void");
    }

    public final void onCancelledRequest(int i10, boolean z10) {
        if (z10) {
            getChannel().waitExpandBufferCompletion$kotlinx_coroutines_core((this.f17734n * BufferedChannelKt.f15340b) + i10);
        }
        onSlotCleaned();
    }

    public final E retrieveElement$kotlinx_coroutines_core(int i10) {
        E element$kotlinx_coroutines_core = getElement$kotlinx_coroutines_core(i10);
        cleanElement$kotlinx_coroutines_core(i10);
        return element$kotlinx_coroutines_core;
    }

    public final void setState$kotlinx_coroutines_core(int i10, Object obj) {
        this.f16317q.set((i10 * 2) + 1, obj);
    }

    public final void storeElement$kotlinx_coroutines_core(int i10, E e10) {
        this.f16317q.lazySet(i10 * 2, e10);
    }
}
