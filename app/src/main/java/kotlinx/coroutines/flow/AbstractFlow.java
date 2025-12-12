package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.SafeCollector;
import lf.h;
import ng.a;
import ng.b;
import qf.c;
import sf.d;

/* compiled from: Flow.kt */
/* loaded from: classes2.dex */
public abstract class AbstractFlow<T> implements a<T> {

    /* compiled from: Flow.kt */
    @d(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.AbstractFlow$collect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public SafeCollector f15374b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f15375m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ AbstractFlow<T> f15376n;

        /* renamed from: o, reason: collision with root package name */
        public int f15377o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AbstractFlow<T> abstractFlow, c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.f15376n = abstractFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15375m = obj;
            this.f15377o |= Integer.MIN_VALUE;
            return this.f15376n.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ng.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(ng.b<? super T> r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.AbstractFlow.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = (kotlinx.coroutines.flow.AbstractFlow.AnonymousClass1) r0
            int r1 = r0.f15377o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15377o = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.AbstractFlow$collect$1 r0 = new kotlinx.coroutines.flow.AbstractFlow$collect$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f15375m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15377o
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlinx.coroutines.flow.internal.SafeCollector r6 = r0.f15374b
            lf.f.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L2b
            goto L4d
        L2b:
            r7 = move-exception
            goto L57
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            lf.f.throwOnFailure(r7)
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f15374b = r7     // Catch: java.lang.Throwable -> L53
            r0.f15377o = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r6 = r5.collectSafely(r7, r0)     // Catch: java.lang.Throwable -> L53
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r6 = r7
        L4d:
            r6.releaseIntercepted()
            lf.h r6 = lf.h.f16056a
            return r6
        L53:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L57:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.AbstractFlow.collect(ng.b, qf.c):java.lang.Object");
    }

    public abstract Object collectSafely(b<? super T> bVar, c<? super h> cVar);
}
