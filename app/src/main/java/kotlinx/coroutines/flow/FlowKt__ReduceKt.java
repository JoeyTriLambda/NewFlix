package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import lf.h;
import ng.b;
import qf.c;
import sf.d;

/* compiled from: Reduce.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Limit.kt */
    public static final class a<T> implements b<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f15427b;

        public a(Ref$ObjectRef ref$ObjectRef) {
            this.f15427b = ref$ObjectRef;
        }

        @Override // ng.b
        public Object emit(T t10, c<? super h> cVar) {
            this.f15427b.f15262b = t10;
            throw new AbortFlowException(this);
        }
    }

    /* compiled from: Reduce.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public Ref$ObjectRef f15428b;

        /* renamed from: m, reason: collision with root package name */
        public a f15429m;

        /* renamed from: n, reason: collision with root package name */
        public /* synthetic */ Object f15430n;

        /* renamed from: o, reason: collision with root package name */
        public int f15431o;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15430n = obj;
            this.f15431o |= Integer.MIN_VALUE;
            return ng.c.first(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object first(ng.a<? extends T> r4, qf.c<? super T> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.AnonymousClass1) r0
            int r1 = r0.f15431o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15431o = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1 r0 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f15430n
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15431o
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r4 = r0.f15429m
            kotlin.jvm.internal.Ref$ObjectRef r0 = r0.f15428b
            lf.f.throwOnFailure(r5)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L2d
            goto L5e
        L2d:
            r5 = move-exception
            goto L5b
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            lf.f.throwOnFailure(r5)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            pg.b0 r2 = og.j.f17095a
            r5.f15262b = r2
            kotlinx.coroutines.flow.FlowKt__ReduceKt$a r2 = new kotlinx.coroutines.flow.FlowKt__ReduceKt$a
            r2.<init>(r5)
            r0.f15428b = r5     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f15429m = r2     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            r0.f15431o = r3     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: kotlinx.coroutines.flow.internal.AbortFlowException -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r0 = r5
            goto L5e
        L57:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5b:
            og.g.checkOwnership(r5, r4)
        L5e:
            T r4 = r0.f15262b
            pg.b0 r5 = og.j.f17095a
            if (r4 == r5) goto L65
            return r4
        L65:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ReduceKt.first(ng.a, qf.c):java.lang.Object");
    }
}
