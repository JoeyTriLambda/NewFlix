package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$IntRef;
import ng.b;

/* compiled from: Limit.kt */
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$drop$2$1<T> implements b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f15413b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f15414m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ b<T> f15415n;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$drop$2$1(Ref$IntRef ref$IntRef, int i10, b<? super T> bVar) {
        this.f15413b = ref$IntRef;
        this.f15414m = i10;
        this.f15415n = bVar;
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
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1) r0
            int r1 = r0.f15418n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15418n = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1$emit$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f15416b
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15418n
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lf.f.throwOnFailure(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            lf.f.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f15413b
            int r2 = r7.f15260b
            int r4 = r5.f15414m
            if (r2 < r4) goto L4a
            r0.f15418n = r3
            ng.b<T> r7 = r5.f15415n
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            lf.h r6 = lf.h.f16056a
            return r6
        L4a:
            int r2 = r2 + r3
            r7.f15260b = r2
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1.emit(java.lang.Object, qf.c):java.lang.Object");
    }
}
