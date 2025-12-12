package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import lf.h;
import ng.a;
import ng.b;
import qf.c;
import sf.d;
import yf.q;

/* compiled from: Errors.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {

    /* compiled from: Errors.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public Ref$ObjectRef f15400b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ Object f15401m;

        /* renamed from: n, reason: collision with root package name */
        public int f15402n;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15401m = obj;
            this.f15402n |= Integer.MIN_VALUE;
            return ng.c.catchImpl(null, null, this);
        }
    }

    /* compiled from: Errors.kt */
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b<T> f15403b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Throwable> f15404m;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(b<? super T> bVar, Ref$ObjectRef<Throwable> ref$ObjectRef) {
            this.f15403b = bVar;
            this.f15404m = ref$ObjectRef;
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
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1) r0
                int r1 = r0.f15408o
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15408o = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f15406m
                java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.f15408o
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r5 = r0.f15405b
                lf.f.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2b
                goto L45
            L2b:
                r6 = move-exception
                goto L4b
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                lf.f.throwOnFailure(r6)
                ng.b<T> r6 = r4.f15403b     // Catch: java.lang.Throwable -> L48
                r0.f15405b = r4     // Catch: java.lang.Throwable -> L48
                r0.f15408o = r3     // Catch: java.lang.Throwable -> L48
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L48
                if (r5 != r1) goto L45
                return r1
            L45:
                lf.h r5 = lf.h.f16056a
                return r5
            L48:
                r5 = move-exception
                r6 = r5
                r5 = r4
            L4b:
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Throwable> r5 = r5.f15404m
                r5.f15262b = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
        }
    }

    /* renamed from: catch, reason: not valid java name */
    public static final <T> a<T> m84catch(a<? extends T> aVar, q<? super b<? super T>, ? super Throwable, ? super c<? super h>, ? extends Object> qVar) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(aVar, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object catchImpl(ng.a<? extends T> r4, ng.b<? super T> r5, qf.c<? super java.lang.Throwable> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.AnonymousClass1) r0
            int r1 = r0.f15402n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15402n = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f15401m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15402n
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            kotlin.jvm.internal.Ref$ObjectRef r4 = r0.f15400b
            lf.f.throwOnFailure(r6)     // Catch: java.lang.Throwable -> L2b
            goto L4d
        L2b:
            r5 = move-exception
            goto L52
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            lf.f.throwOnFailure(r6)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2     // Catch: java.lang.Throwable -> L4f
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L4f
            r0.f15400b = r6     // Catch: java.lang.Throwable -> L4f
            r0.f15402n = r3     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L4f
            if (r4 != r1) goto L4d
            return r1
        L4d:
            r4 = 0
            return r4
        L4f:
            r4 = move-exception
            r5 = r4
            r4 = r6
        L52:
            T r4 = r4.f15262b
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r6 = 0
            if (r4 == 0) goto L61
            boolean r1 = zf.i.areEqual(r4, r5)
            if (r1 == 0) goto L61
            r1 = 1
            goto L62
        L61:
            r1 = 0
        L62:
            if (r1 != 0) goto L99
            kotlin.coroutines.CoroutineContext r0 = r0.getContext()
            kg.k1$b r1 = kg.k1.b.f15119b
            kotlin.coroutines.CoroutineContext$a r0 = r0.get(r1)
            kg.k1 r0 = (kg.k1) r0
            if (r0 == 0) goto L88
            boolean r1 = r0.isCancelled()
            if (r1 != 0) goto L79
            goto L88
        L79:
            java.util.concurrent.CancellationException r0 = r0.getCancellationException()
            if (r0 == 0) goto L86
            boolean r0 = zf.i.areEqual(r0, r5)
            if (r0 == 0) goto L86
            goto L87
        L86:
            r3 = 0
        L87:
            r6 = r3
        L88:
            if (r6 != 0) goto L99
            if (r4 != 0) goto L8d
            return r5
        L8d:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L95
            lf.a.addSuppressed(r4, r5)
            throw r4
        L95:
            lf.a.addSuppressed(r5, r4)
            throw r5
        L99:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.catchImpl(ng.a, ng.b, qf.c):java.lang.Object");
    }
}
