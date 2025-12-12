package kg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* compiled from: Builders.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class g {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T runBlocking(kotlin.coroutines.CoroutineContext r5, yf.p<? super kg.g0, ? super qf.c<? super T>, ? extends java.lang.Object> r6) throws java.lang.InterruptedException {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            int r1 = qf.d.f18151l
            qf.d$b r1 = qf.d.b.f18152b
            kotlin.coroutines.CoroutineContext$a r1 = r5.get(r1)
            qf.d r1 = (qf.d) r1
            kg.d1 r2 = kg.d1.f15100b
            if (r1 != 0) goto L21
            kg.i2 r1 = kg.i2.f15113a
            kg.y0 r1 = r1.getEventLoop$kotlinx_coroutines_core()
            kotlin.coroutines.CoroutineContext r5 = r5.plus(r1)
            kotlin.coroutines.CoroutineContext r5 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r5)
            goto L42
        L21:
            boolean r3 = r1 instanceof kg.y0
            r4 = 0
            if (r3 == 0) goto L29
            kg.y0 r1 = (kg.y0) r1
            goto L2a
        L29:
            r1 = r4
        L2a:
            if (r1 == 0) goto L38
            boolean r3 = r1.shouldBeProcessedFromContext()
            if (r3 == 0) goto L33
            r4 = r1
        L33:
            if (r4 != 0) goto L36
            goto L38
        L36:
            r1 = r4
            goto L3e
        L38:
            kg.i2 r1 = kg.i2.f15113a
            kg.y0 r1 = r1.currentOrNull$kotlinx_coroutines_core()
        L3e:
            kotlin.coroutines.CoroutineContext r5 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r5)
        L42:
            kg.e r2 = new kg.e
            r2.<init>(r5, r0, r1)
            kotlinx.coroutines.CoroutineStart r5 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r2.start(r5, r2, r6)
            java.lang.Object r5 = r2.joinBlocking()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kg.g.runBlocking(kotlin.coroutines.CoroutineContext, yf.p):java.lang.Object");
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, yf.p pVar, int i10, Object obj) throws InterruptedException {
        if ((i10 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f15239b;
        }
        return f.runBlocking(coroutineContext, pVar);
    }
}
