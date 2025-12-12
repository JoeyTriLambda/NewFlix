package kotlinx.coroutines.flow.internal;

import kg.g0;
import kg.p1;
import kg.x;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.internal.ThreadContextKt;
import lf.f;
import lf.h;
import mg.e;
import mg.i;
import mg.j;
import ng.a;
import ng.b;
import og.g;
import qf.c;
import sf.d;
import yf.l;
import yf.p;
import yf.q;

/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", l = {126}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CombineKt$zipImpl$1$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f15511b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f15512m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b<R> f15513n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ a<T2> f15514o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ a<T1> f15515p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ q<T1, T2, c<? super R>, Object> f15516q;

    /* compiled from: Combine.kt */
    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", l = {127}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<h, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f15519b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ a<T1> f15520m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ CoroutineContext f15521n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ Object f15522o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ i<Object> f15523p;

        /* renamed from: q, reason: collision with root package name */
        public final /* synthetic */ b<R> f15524q;

        /* renamed from: r, reason: collision with root package name */
        public final /* synthetic */ q<T1, T2, c<? super R>, Object> f15525r;

        /* compiled from: Combine.kt */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements b {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CoroutineContext f15526b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ Object f15527m;

            /* renamed from: n, reason: collision with root package name */
            public final /* synthetic */ i<Object> f15528n;

            /* renamed from: o, reason: collision with root package name */
            public final /* synthetic */ b<R> f15529o;

            /* renamed from: p, reason: collision with root package name */
            public final /* synthetic */ q<T1, T2, c<? super R>, Object> f15530p;

            /* compiled from: Combine.kt */
            @d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", l = {129, 132, 132}, m = "invokeSuspend")
            /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C01831 extends SuspendLambda implements p<h, c<? super h>, Object> {

                /* renamed from: b, reason: collision with root package name */
                public b f15531b;

                /* renamed from: m, reason: collision with root package name */
                public int f15532m;

                /* renamed from: n, reason: collision with root package name */
                public final /* synthetic */ i<Object> f15533n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ b<R> f15534o;

                /* renamed from: p, reason: collision with root package name */
                public final /* synthetic */ q<T1, T2, c<? super R>, Object> f15535p;

                /* renamed from: q, reason: collision with root package name */
                public final /* synthetic */ T1 f15536q;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C01831(i<? extends Object> iVar, b<? super R> bVar, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar, T1 t12, c<? super C01831> cVar) {
                    super(2, cVar);
                    this.f15533n = iVar;
                    this.f15534o = bVar;
                    this.f15535p = qVar;
                    this.f15536q = t12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final c<h> create(Object obj, c<?> cVar) {
                    return new C01831(this.f15533n, this.f15534o, this.f15535p, this.f15536q, cVar);
                }

                /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[RETURN] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                    /*
                        r6 = this;
                        java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
                        int r1 = r6.f15532m
                        r2 = 0
                        r3 = 3
                        r4 = 2
                        r5 = 1
                        if (r1 == 0) goto L2e
                        if (r1 == r5) goto L24
                        if (r1 == r4) goto L1e
                        if (r1 != r3) goto L16
                        lf.f.throwOnFailure(r7)
                        goto L6e
                    L16:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r0)
                        throw r7
                    L1e:
                        ng.b r1 = r6.f15531b
                        lf.f.throwOnFailure(r7)
                        goto L63
                    L24:
                        lf.f.throwOnFailure(r7)
                        kotlinx.coroutines.channels.a r7 = (kotlinx.coroutines.channels.a) r7
                        java.lang.Object r7 = r7.m80unboximpl()
                        goto L3c
                    L2e:
                        lf.f.throwOnFailure(r7)
                        r6.f15532m = r5
                        mg.i<java.lang.Object> r7 = r6.f15533n
                        java.lang.Object r7 = r7.mo68receiveCatchingJP2dKIU(r6)
                        if (r7 != r0) goto L3c
                        return r0
                    L3c:
                        boolean r1 = r7 instanceof kotlinx.coroutines.channels.a.c
                        ng.b<R> r5 = r6.f15534o
                        if (r1 == 0) goto L4e
                        java.lang.Throwable r7 = kotlinx.coroutines.channels.a.m74exceptionOrNullimpl(r7)
                        if (r7 != 0) goto L4d
                        kotlinx.coroutines.flow.internal.AbortFlowException r7 = new kotlinx.coroutines.flow.internal.AbortFlowException
                        r7.<init>(r5)
                    L4d:
                        throw r7
                    L4e:
                        pg.b0 r1 = og.j.f17095a
                        if (r7 != r1) goto L53
                        r7 = r2
                    L53:
                        r6.f15531b = r5
                        r6.f15532m = r4
                        yf.q<T1, T2, qf.c<? super R>, java.lang.Object> r1 = r6.f15535p
                        T1 r4 = r6.f15536q
                        java.lang.Object r7 = r1.invoke(r4, r7, r6)
                        if (r7 != r0) goto L62
                        return r0
                    L62:
                        r1 = r5
                    L63:
                        r6.f15531b = r2
                        r6.f15532m = r3
                        java.lang.Object r7 = r1.emit(r7, r6)
                        if (r7 != r0) goto L6e
                        return r0
                    L6e:
                        lf.h r7 = lf.h.f16056a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.C01831.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                @Override // yf.p
                public final Object invoke(h hVar, c<? super h> cVar) {
                    return ((C01831) create(hVar, cVar)).invokeSuspend(h.f16056a);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(CoroutineContext coroutineContext, Object obj, i<? extends Object> iVar, b<? super R> bVar, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
                this.f15526b = coroutineContext;
                this.f15527m = obj;
                this.f15528n = iVar;
                this.f15529o = bVar;
                this.f15530p = qVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // ng.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(T1 r11, qf.c<? super lf.h> r12) throws java.lang.Throwable {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r12
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1) r0
                    int r1 = r0.f15539n
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f15539n = r1
                    goto L18
                L13:
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$emit$1
                    r0.<init>(r10, r12)
                L18:
                    java.lang.Object r12 = r0.f15537b
                    java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f15539n
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    lf.f.throwOnFailure(r12)
                    goto L51
                L29:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L31:
                    lf.f.throwOnFailure(r12)
                    lf.h r12 = lf.h.f16056a
                    kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1 r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1
                    mg.i<java.lang.Object> r5 = r10.f15528n
                    ng.b<R> r6 = r10.f15529o
                    yf.q<T1, T2, qf.c<? super R>, java.lang.Object> r7 = r10.f15530p
                    r9 = 0
                    r4 = r2
                    r8 = r11
                    r4.<init>(r5, r6, r7, r8, r9)
                    r0.f15539n = r3
                    kotlin.coroutines.CoroutineContext r11 = r10.f15526b
                    java.lang.Object r3 = r10.f15527m
                    java.lang.Object r11 = og.c.withContextUndispatched(r11, r12, r3, r2, r0)
                    if (r11 != r1) goto L51
                    return r1
                L51:
                    lf.h r11 = lf.h.f16056a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.AnonymousClass2.AnonymousClass1.emit(java.lang.Object, qf.c):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(a<? extends T1> aVar, CoroutineContext coroutineContext, Object obj, i<? extends Object> iVar, b<? super R> bVar, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.f15520m = aVar;
            this.f15521n = coroutineContext;
            this.f15522o = obj;
            this.f15523p = iVar;
            this.f15524q = bVar;
            this.f15525r = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.f15520m, this.f15521n, this.f15522o, this.f15523p, this.f15524q, this.f15525r, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f15519b;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f15521n, this.f15522o, this.f15523p, this.f15524q, this.f15525r);
                this.f15519b = 1;
                if (this.f15520m.collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(h hVar, c<? super h> cVar) {
            return ((AnonymousClass2) create(hVar, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1(b<? super R> bVar, a<? extends T2> aVar, a<? extends T1> aVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar, c<? super CombineKt$zipImpl$1$1> cVar) {
        super(2, cVar);
        this.f15513n = bVar;
        this.f15514o = aVar;
        this.f15515p = aVar2;
        this.f15516q = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.f15513n, this.f15514o, this.f15515p, this.f15516q, cVar);
        combineKt$zipImpl$1$1.f15512m = obj;
        return combineKt$zipImpl$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        i iVar;
        i iVar2;
        CoroutineContext coroutineContextPlus;
        h hVar;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f15511b;
        final b<R> bVar = this.f15513n;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            g0 g0Var = (g0) this.f15512m;
            i iVarProduce$default = e.produce$default(g0Var, null, 0, new CombineKt$zipImpl$1$1$second$1(this.f15514o, null), 3, null);
            final x xVarJob$default = p1.Job$default(null, 1, null);
            zf.i.checkNotNull(iVarProduce$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>");
            ((j) iVarProduce$default).invokeOnClose(new l<Throwable, h>() { // from class: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                    invoke2(th2);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th2) {
                    x xVar = xVarJob$default;
                    if (xVar.isActive()) {
                        xVar.cancel(new AbortFlowException(bVar));
                    }
                }
            });
            try {
                CoroutineContext coroutineContext = g0Var.getCoroutineContext();
                Object objThreadContextElements = ThreadContextKt.threadContextElements(coroutineContext);
                coroutineContextPlus = g0Var.getCoroutineContext().plus(xVarJob$default);
                hVar = h.f16056a;
                anonymousClass2 = new AnonymousClass2(this.f15515p, coroutineContext, objThreadContextElements, iVarProduce$default, this.f15513n, this.f15516q, null);
                this.f15512m = iVarProduce$default;
                this.f15511b = 1;
                iVar = iVarProduce$default;
            } catch (AbortFlowException e10) {
                e = e10;
                iVar = iVarProduce$default;
            } catch (Throwable th2) {
                th = th2;
                iVar = iVarProduce$default;
            }
            try {
                if (og.c.withContextUndispatched$default(coroutineContextPlus, hVar, null, anonymousClass2, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iVar2 = iVar;
            } catch (AbortFlowException e11) {
                e = e11;
                iVar2 = iVar;
                g.checkOwnership(e, bVar);
                i.a.cancel$default(iVar2, null, 1, null);
                return h.f16056a;
            } catch (Throwable th3) {
                th = th3;
                iVar2 = iVar;
                i.a.cancel$default(iVar2, null, 1, null);
                throw th;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iVar2 = (i) this.f15512m;
            try {
                try {
                    f.throwOnFailure(obj);
                } catch (Throwable th4) {
                    th = th4;
                    i.a.cancel$default(iVar2, null, 1, null);
                    throw th;
                }
            } catch (AbortFlowException e12) {
                e = e12;
                g.checkOwnership(e, bVar);
                i.a.cancel$default(iVar2, null, 1, null);
                return h.f16056a;
            }
        }
        i.a.cancel$default(iVar2, null, 1, null);
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((CombineKt$zipImpl$1$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
