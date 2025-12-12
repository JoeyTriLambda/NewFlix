package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import mg.g;
import ng.a;
import ng.b;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", l = {89}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements p<g<? super Object>, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f15540b;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f15541m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ a<T2> f15542n;

    /* compiled from: Combine.kt */
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g<Object> f15543b;

        public AnonymousClass1(g<Object> gVar) {
            this.f15543b = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ng.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T2 r5, qf.c<? super lf.h> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1) r0
                int r1 = r0.f15546n
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15546n = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f15544b
                java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.f15546n
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                lf.f.throwOnFailure(r6)
                goto L47
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                lf.f.throwOnFailure(r6)
                mg.g<java.lang.Object> r6 = r4.f15543b
                mg.j r6 = r6.getChannel()
                if (r5 != 0) goto L3e
                pg.b0 r5 = og.j.f17095a
            L3e:
                r0.f15546n = r3
                java.lang.Object r5 = r6.send(r5, r0)
                if (r5 != r1) goto L47
                return r1
            L47:
                lf.h r5 = lf.h.f16056a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1.AnonymousClass1.emit(java.lang.Object, qf.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$zipImpl$1$1$second$1(a<? extends T2> aVar, c<? super CombineKt$zipImpl$1$1$second$1> cVar) {
        super(2, cVar);
        this.f15542n = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        CombineKt$zipImpl$1$1$second$1 combineKt$zipImpl$1$1$second$1 = new CombineKt$zipImpl$1$1$second$1(this.f15542n, cVar);
        combineKt$zipImpl$1$1$second$1.f15541m = obj;
        return combineKt$zipImpl$1$1$second$1;
    }

    @Override // yf.p
    public /* bridge */ /* synthetic */ Object invoke(g<? super Object> gVar, c<? super h> cVar) {
        return invoke2((g<Object>) gVar, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f15540b;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((g) this.f15541m);
            this.f15540b = 1;
            if (this.f15542n.collect(anonymousClass1, this) == coroutine_suspended) {
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

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g<Object> gVar, c<? super h> cVar) {
        return ((CombineKt$zipImpl$1$1$second$1) create(gVar, cVar)).invokeSuspend(h.f16056a);
    }
}
