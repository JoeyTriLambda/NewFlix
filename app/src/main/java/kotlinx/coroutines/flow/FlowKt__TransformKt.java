package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import lf.h;
import ng.a;
import ng.b;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: Transform.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> a<T> filterNotNull(final a<? extends T> aVar) {
        return new a<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements b {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f15433b;

                /* compiled from: Emitters.kt */
                @d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f15434b;

                    /* renamed from: m, reason: collision with root package name */
                    public int f15435m;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f15434b = obj;
                        this.f15435m |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b bVar) {
                    this.f15433b = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ng.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T r5, qf.c<? super lf.h> r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f15435m
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f15435m = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f15434b
                        java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f15435m
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        lf.f.throwOnFailure(r6)
                        goto L41
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        lf.f.throwOnFailure(r6)
                        if (r5 == 0) goto L41
                        r0.f15435m = r3
                        ng.b r6 = r4.f15433b
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L41
                        return r1
                    L41:
                        lf.h r5 = lf.h.f16056a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
                }
            }

            @Override // ng.a
            public Object collect(b bVar, c cVar) {
                Object objCollect = aVar.collect(new AnonymousClass2(bVar), cVar);
                return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
            }
        };
    }

    public static final <T> a<T> onEach(final a<? extends T> aVar, final p<? super T, ? super c<? super h>, ? extends Object> pVar) {
        return new a<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements b {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f15439b;

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ p f15440m;

                /* compiled from: Emitters.kt */
                @d(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 224}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f15441b;

                    /* renamed from: m, reason: collision with root package name */
                    public int f15442m;

                    /* renamed from: o, reason: collision with root package name */
                    public Object f15444o;

                    /* renamed from: p, reason: collision with root package name */
                    public b f15445p;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f15441b = obj;
                        this.f15442m |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(b bVar, p pVar) {
                    this.f15439b = bVar;
                    this.f15440m = pVar;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ng.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(T r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f15442m
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f15442m = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.f15441b
                        java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f15442m
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        lf.f.throwOnFailure(r7)
                        goto L68
                    L2c:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L34:
                        ng.b r6 = r0.f15445p
                        java.lang.Object r2 = r0.f15444o
                        lf.f.throwOnFailure(r7)
                        goto L5a
                    L3c:
                        lf.f.throwOnFailure(r7)
                        r0.f15444o = r6
                        ng.b r7 = r5.f15439b
                        r0.f15445p = r7
                        r0.f15442m = r4
                        r2 = 6
                        zf.h.mark(r2)
                        yf.p r2 = r5.f15440m
                        java.lang.Object r2 = r2.invoke(r6, r0)
                        r4 = 7
                        zf.h.mark(r4)
                        if (r2 != r1) goto L58
                        return r1
                    L58:
                        r2 = r6
                        r6 = r7
                    L5a:
                        r7 = 0
                        r0.f15444o = r7
                        r0.f15445p = r7
                        r0.f15442m = r3
                        java.lang.Object r6 = r6.emit(r2, r0)
                        if (r6 != r1) goto L68
                        return r1
                    L68:
                        lf.h r6 = lf.h.f16056a
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
                }
            }

            @Override // ng.a
            public Object collect(b bVar, c cVar) {
                Object objCollect = aVar.collect(new AnonymousClass2(bVar, pVar), cVar);
                return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
            }
        };
    }
}
