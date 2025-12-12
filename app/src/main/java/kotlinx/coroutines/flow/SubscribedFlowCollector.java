package kotlinx.coroutines.flow;

import cz.msebera.android.httpclient.HttpStatus;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.SafeCollector;
import lf.h;
import ng.b;
import qf.c;
import sf.d;

/* compiled from: Share.kt */
/* loaded from: classes2.dex */
public final class SubscribedFlowCollector<T> implements b<T> {

    /* compiled from: Share.kt */
    @d(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, HttpStatus.SC_LOCKED}, m = "onSubscription")
    /* renamed from: kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public SubscribedFlowCollector f15482b;

        /* renamed from: m, reason: collision with root package name */
        public SafeCollector f15483m;

        /* renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f15484n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ SubscribedFlowCollector<T> f15485o;

        /* renamed from: p, reason: collision with root package name */
        public int f15486p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubscribedFlowCollector<T> subscribedFlowCollector, c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.f15485o = subscribedFlowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15484n = obj;
            this.f15486p |= Integer.MIN_VALUE;
            return this.f15485o.onSubscription(this);
        }
    }

    @Override // ng.b
    public Object emit(T t10, c<? super h> cVar) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, kotlinx.coroutines.flow.internal.SafeCollector] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onSubscription(qf.c<? super lf.h> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector.AnonymousClass1) r0
            int r1 = r0.f15486p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15486p = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f15484n
            rf.a.getCOROUTINE_SUSPENDED()
            int r1 = r0.f15486p
            r2 = 1
            if (r1 == 0) goto L43
            if (r1 == r2) goto L35
            r0 = 2
            if (r1 != r0) goto L2d
            lf.f.throwOnFailure(r5)
        L2a:
            lf.h r5 = lf.h.f16056a
            return r5
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlinx.coroutines.flow.internal.SafeCollector r1 = r0.f15483m
            kotlinx.coroutines.flow.SubscribedFlowCollector r0 = r0.f15482b
            lf.f.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L57
            r1.releaseIntercepted()
            r0.getClass()
            goto L2a
        L43:
            lf.f.throwOnFailure(r5)
            kotlinx.coroutines.flow.internal.SafeCollector r1 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r3 = 0
            r1.<init>(r3, r5)
            r0.f15482b = r4     // Catch: java.lang.Throwable -> L57
            r0.f15483m = r1     // Catch: java.lang.Throwable -> L57
            r0.f15486p = r2     // Catch: java.lang.Throwable -> L57
            throw r3     // Catch: java.lang.Throwable -> L57
        L57:
            r5 = move-exception
            r1.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.onSubscription(qf.c):java.lang.Object");
    }
}
