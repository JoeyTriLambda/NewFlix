package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kg.g0;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import mf.s;
import mg.j;
import ng.b;
import qf.c;
import sf.d;
import yf.p;
import yf.q;

/* compiled from: Combine.kt */
/* loaded from: classes2.dex */
public final class CombineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: SafeCollector.common.kt */
    public static final class a<R> implements ng.a<R> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ng.a f15488b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ ng.a f15489m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ q f15490n;

        public a(ng.a aVar, ng.a aVar2, q qVar) {
            this.f15488b = aVar;
            this.f15489m = aVar2;
            this.f15490n = qVar;
        }

        @Override // ng.a
        public Object collect(b<? super R> bVar, c<? super h> cVar) {
            Object objCoroutineScope = h0.coroutineScope(new CombineKt$zipImpl$1$1(bVar, this.f15488b, this.f15489m, this.f15490n, null), cVar);
            return objCoroutineScope == rf.a.getCOROUTINE_SUSPENDED() ? objCoroutineScope : h.f16056a;
        }
    }

    /* compiled from: Combine.kt */
    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public mg.a f15491b;

        /* renamed from: m, reason: collision with root package name */
        public byte[] f15492m;

        /* renamed from: n, reason: collision with root package name */
        public int f15493n;

        /* renamed from: o, reason: collision with root package name */
        public int f15494o;

        /* renamed from: p, reason: collision with root package name */
        public int f15495p;

        /* renamed from: q, reason: collision with root package name */
        public /* synthetic */ Object f15496q;

        /* renamed from: r, reason: collision with root package name */
        public final /* synthetic */ ng.a<T>[] f15497r;

        /* renamed from: s, reason: collision with root package name */
        public final /* synthetic */ yf.a<T[]> f15498s;

        /* renamed from: t, reason: collision with root package name */
        public final /* synthetic */ q<b<? super R>, T[], c<? super h>, Object> f15499t;

        /* renamed from: u, reason: collision with root package name */
        public final /* synthetic */ b<R> f15500u;

        /* compiled from: Combine.kt */
        @d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {31}, m = "invokeSuspend")
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

            /* renamed from: b, reason: collision with root package name */
            public int f15501b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ng.a<T>[] f15502m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ int f15503n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ AtomicInteger f15504o;

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ mg.a<s<Object>> f15505p;

            /* compiled from: Combine.kt */
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01821<T> implements b {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ mg.a<s<Object>> f15506b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ int f15507m;

                public C01821(mg.a<s<Object>> aVar, int i10) {
                    this.f15506b = aVar;
                    this.f15507m = i10;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ng.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1) r0
                        int r1 = r0.f15510n
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f15510n = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1$emit$1
                        r0.<init>(r5, r7)
                    L18:
                        java.lang.Object r7 = r0.f15508b
                        java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f15510n
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L38
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        lf.f.throwOnFailure(r7)
                        goto L56
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        lf.f.throwOnFailure(r7)
                        goto L4d
                    L38:
                        lf.f.throwOnFailure(r7)
                        mf.s r7 = new mf.s
                        int r2 = r5.f15507m
                        r7.<init>(r2, r6)
                        r0.f15510n = r4
                        mg.a<mf.s<java.lang.Object>> r6 = r5.f15506b
                        java.lang.Object r6 = r6.send(r7, r0)
                        if (r6 != r1) goto L4d
                        return r1
                    L4d:
                        r0.f15510n = r3
                        java.lang.Object r6 = kg.n2.yield(r0)
                        if (r6 != r1) goto L56
                        return r1
                    L56:
                        lf.h r6 = lf.h.f16056a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.AnonymousClass1.C01821.emit(java.lang.Object, qf.c):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(ng.a<? extends T>[] aVarArr, int i10, AtomicInteger atomicInteger, mg.a<s<Object>> aVar, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.f15502m = aVarArr;
                this.f15503n = i10;
                this.f15504o = atomicInteger;
                this.f15505p = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final c<h> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.f15502m, this.f15503n, this.f15504o, this.f15505p, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
                int i10 = this.f15501b;
                AtomicInteger atomicInteger = this.f15504o;
                mg.a<s<Object>> aVar = this.f15505p;
                try {
                    if (i10 == 0) {
                        f.throwOnFailure(obj);
                        ng.a[] aVarArr = this.f15502m;
                        int i11 = this.f15503n;
                        ng.a aVar2 = aVarArr[i11];
                        C01821 c01821 = new C01821(aVar, i11);
                        this.f15501b = 1;
                        if (aVar2.collect(c01821, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        f.throwOnFailure(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        j.a.close$default(aVar, null, 1, null);
                    }
                    return h.f16056a;
                } finally {
                    if (atomicInteger.decrementAndGet() == 0) {
                        j.a.close$default(aVar, null, 1, null);
                    }
                }
            }

            @Override // yf.p
            public final Object invoke(g0 g0Var, c<? super h> cVar) {
                return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(b bVar, ng.a[] aVarArr, yf.a aVar, q qVar, c cVar) {
            super(2, cVar);
            this.f15497r = aVarArr;
            this.f15498s = aVar;
            this.f15499t = qVar;
            this.f15500u = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f15500u, this.f15497r, this.f15498s, this.f15499t, cVar);
            anonymousClass2.f15496q = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0151, code lost:
        
            r9 = r15;
            r10 = r14;
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d1 A[LOOP:0: B:28:0x00d1->B:51:?, LOOP_START, PHI: r6 r9
  0x00d1: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00cc, B:51:?] A[DONT_GENERATE, DONT_INLINE]
  0x00d1: PHI (r9v5 mf.s) = (r9v4 mf.s), (r9v21 mf.s) binds: [B:25:0x00cc, B:51:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0158  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x014f -> B:45:0x0150). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 350
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public static final <R, T> Object combineInternal(b<? super R> bVar, ng.a<? extends T>[] aVarArr, yf.a<T[]> aVar, q<? super b<? super R>, ? super T[], ? super c<? super h>, ? extends Object> qVar, c<? super h> cVar) {
        Object objFlowScope = og.f.flowScope(new AnonymousClass2(bVar, aVarArr, aVar, qVar, null), cVar);
        return objFlowScope == rf.a.getCOROUTINE_SUSPENDED() ? objFlowScope : h.f16056a;
    }

    public static final <T1, T2, R> ng.a<R> zipImpl(ng.a<? extends T1> aVar, ng.a<? extends T2> aVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return new a(aVar2, aVar, qVar);
    }
}
