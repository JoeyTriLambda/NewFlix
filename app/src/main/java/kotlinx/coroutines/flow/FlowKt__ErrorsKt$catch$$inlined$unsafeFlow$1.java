package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ng.a;
import ng.b;
import qf.c;
import sf.d;
import yf.q;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
/* loaded from: classes2.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> implements a<T> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f15393b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ q f15394m;

    /* compiled from: SafeCollector.common.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {113, 114}, m = "collect")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15395b;

        /* renamed from: m, reason: collision with root package name */
        public int f15396m;

        /* renamed from: o, reason: collision with root package name */
        public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 f15398o;

        /* renamed from: p, reason: collision with root package name */
        public b f15399p;

        public AnonymousClass1(c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15395b = obj;
            this.f15396m |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(a aVar, q qVar) {
        this.f15393b = aVar;
        this.f15394m = qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ng.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(ng.b<? super T> r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f15396m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15396m = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15395b
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15396m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            lf.f.throwOnFailure(r7)
            goto L6b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            ng.b r6 = r0.f15399p
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r2 = r0.f15398o
            lf.f.throwOnFailure(r7)
            goto L4f
        L3c:
            lf.f.throwOnFailure(r7)
            r0.f15398o = r5
            r0.f15399p = r6
            r0.f15396m = r4
            ng.a r7 = r5.f15393b
            java.lang.Object r7 = ng.c.catchImpl(r7, r6, r0)
            if (r7 != r1) goto L4e
            return r1
        L4e:
            r2 = r5
        L4f:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 == 0) goto L6b
            yf.q r2 = r2.f15394m
            r4 = 0
            r0.f15398o = r4
            r0.f15399p = r4
            r0.f15396m = r3
            r3 = 6
            zf.h.mark(r3)
            java.lang.Object r6 = r2.invoke(r6, r7, r0)
            r7 = 7
            zf.h.mark(r7)
            if (r6 != r1) goto L6b
            return r1
        L6b:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.collect(ng.b, qf.c):java.lang.Object");
    }
}
