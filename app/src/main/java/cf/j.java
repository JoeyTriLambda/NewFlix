package cf;

import io.reactivex.internal.queue.SpscArrayQueue;
import ne.q;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes2.dex */
public final class j {
    public static <T, U> boolean checkTerminated(boolean z10, boolean z11, q<?> qVar, boolean z12, ve.f<?> fVar, qe.b bVar, g<T, U> gVar) {
        we.j jVar = (we.j) gVar;
        if (jVar.cancelled()) {
            fVar.clear();
            bVar.dispose();
            return true;
        }
        if (!z10) {
            return false;
        }
        if (z12) {
            if (!z11) {
                return false;
            }
            if (bVar != null) {
                bVar.dispose();
            }
            Throwable thError = jVar.error();
            if (thError != null) {
                qVar.onError(thError);
            } else {
                qVar.onComplete();
            }
            return true;
        }
        Throwable thError2 = jVar.error();
        if (thError2 != null) {
            fVar.clear();
            if (bVar != null) {
                bVar.dispose();
            }
            qVar.onError(thError2);
            return true;
        }
        if (!z11) {
            return false;
        }
        if (bVar != null) {
            bVar.dispose();
        }
        qVar.onComplete();
        return true;
    }

    public static <T> ve.f<T> createQueue(int i10) {
        return i10 < 0 ? new af.a(-i10) : new SpscArrayQueue(i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r1 = r9.leave(-r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T, U> void drainLoop(ve.e<T> r12, ne.q<? super U> r13, boolean r14, qe.b r15, cf.g<T, U> r16) {
        /*
            r0 = 1
            r1 = 1
        L2:
            r9 = r16
            we.j r9 = (we.j) r9
            boolean r2 = r9.done()
            boolean r3 = r12.isEmpty()
            r4 = r13
            r5 = r14
            r6 = r12
            r7 = r15
            r8 = r9
            boolean r2 = checkTerminated(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L1a
            return
        L1a:
            boolean r2 = r9.done()
            java.lang.Object r10 = r12.poll()
            if (r10 != 0) goto L26
            r11 = 1
            goto L28
        L26:
            r3 = 0
            r11 = 0
        L28:
            r3 = r11
            r4 = r13
            r5 = r14
            r6 = r12
            r7 = r15
            r8 = r9
            boolean r2 = checkTerminated(r2, r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L35
            return
        L35:
            if (r11 == 0) goto L3f
            int r1 = -r1
            int r1 = r9.leave(r1)
            if (r1 != 0) goto L2
            return
        L3f:
            r2 = r13
            r9.accept(r13, r10)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.j.drainLoop(ve.e, ne.q, boolean, qe.b, cf.g):void");
    }
}
