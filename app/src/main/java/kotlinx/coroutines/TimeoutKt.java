package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import yf.p;

/* compiled from: Timeout.kt */
/* loaded from: classes2.dex */
public final class TimeoutKt {

    /* compiled from: Timeout.kt */
    @sf.d(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {104}, m = "withTimeoutOrNull")
    /* renamed from: kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public p f15297b;

        /* renamed from: m, reason: collision with root package name */
        public Ref$ObjectRef f15298m;

        /* renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f15299n;

        /* renamed from: o, reason: collision with root package name */
        public int f15300o;

        public AnonymousClass1(qf.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15299n = obj;
            this.f15300o |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0L, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlinx.coroutines.TimeoutCancellationException TimeoutCancellationException(long r2, kotlinx.coroutines.e r4, kg.k1 r5) {
        /*
            boolean r0 = r4 instanceof kg.n0
            if (r0 == 0) goto L7
            kg.n0 r4 = (kg.n0) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            int r0 = jg.a.f14696o
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.MILLISECONDS
            long r0 = jg.c.toDuration(r2, r0)
            java.lang.String r4 = r4.m57timeoutMessageLRDsOJo(r0)
            if (r4 != 0) goto L2b
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "Timed out waiting for "
            r4.<init>(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2b:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.TimeoutCancellationException(long, kotlinx.coroutines.e, kg.k1):kotlinx.coroutines.TimeoutCancellationException");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object, java.lang.Runnable, kg.a, kg.j2, kg.k1, pg.x] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, yf.p<? super kg.g0, ? super qf.c<? super T>, ? extends java.lang.Object> r9, qf.c<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt.AnonymousClass1) r0
            int r1 = r0.f15300o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15300o = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f15299n
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15300o
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            kotlin.jvm.internal.Ref$ObjectRef r7 = r0.f15298m
            lf.f.throwOnFailure(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L2c
            goto L7a
        L2c:
            r8 = move-exception
            goto L7e
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            lf.f.throwOnFailure(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L40
            return r3
        L40:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.f15297b = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            r0.f15298m = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            r0.f15300o = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kg.j2 r2 = new kg.j2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            r10.f15262b = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            qf.c<T> r7 = r2.f17732o     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kotlinx.coroutines.e r7 = kg.m0.getDelay(r7)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            long r4 = r2.f15117p     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kotlin.coroutines.CoroutineContext r8 = r2.getContext()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kg.u0 r7 = r7.invokeOnTimeout(r4, r2, r8)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            kg.n1.disposeOnCompletion(r2, r7)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            java.lang.Object r7 = qg.b.startUndispatchedOrReturnIgnoreTimeout(r2, r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            java.lang.Object r8 = rf.a.getCOROUTINE_SUSPENDED()     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
            if (r7 != r8) goto L76
            sf.f.probeCoroutineSuspended(r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L7b
        L76:
            if (r7 != r1) goto L79
            return r1
        L79:
            r10 = r7
        L7a:
            return r10
        L7b:
            r7 = move-exception
            r8 = r7
            r7 = r10
        L7e:
            kg.k1 r9 = r8.f15296b
            T r7 = r7.f15262b
            if (r9 != r7) goto L85
            return r3
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, yf.p, qf.c):java.lang.Object");
    }
}
