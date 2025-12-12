package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$BooleanRef;
import ng.b;
import qf.c;
import yf.p;

/* compiled from: Limit.kt */
/* loaded from: classes2.dex */
public final class FlowKt__LimitKt$dropWhile$1$1<T> implements b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$BooleanRef f15419b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b<T> f15420m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ p<T, c<? super Boolean>, Object> f15421n;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$dropWhile$1$1(Ref$BooleanRef ref$BooleanRef, b<? super T> bVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        this.f15419b = ref$BooleanRef;
        this.f15420m = bVar;
        this.f15421n = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // ng.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(T r7, qf.c<? super lf.h> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.f15426p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15426p = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f15424n
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f15426p
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            lf.f.throwOnFailure(r8)
            goto L86
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L37:
            java.lang.Object r7 = r0.f15423m
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = r0.f15422b
            lf.f.throwOnFailure(r8)
            goto L6a
        L3f:
            lf.f.throwOnFailure(r8)
            goto L57
        L43:
            lf.f.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.f15419b
            boolean r8 = r8.f15259b
            if (r8 == 0) goto L5a
            r0.f15426p = r5
            ng.b<T> r8 = r6.f15420m
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L57
            return r1
        L57:
            lf.h r7 = lf.h.f16056a
            return r7
        L5a:
            r0.f15422b = r6
            r0.f15423m = r7
            r0.f15426p = r4
            yf.p<T, qf.c<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f15421n
            java.lang.Object r8 = r8.invoke(r7, r0)
            if (r8 != r1) goto L69
            return r1
        L69:
            r2 = r6
        L6a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L89
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.f15419b
            r8.f15259b = r5
            r8 = 0
            r0.f15422b = r8
            r0.f15423m = r8
            r0.f15426p = r3
            ng.b<T> r8 = r2.f15420m
            java.lang.Object r7 = r8.emit(r7, r0)
            if (r7 != r1) goto L86
            return r1
        L86:
            lf.h r7 = lf.h.f16056a
            return r7
        L89:
            lf.h r7 = lf.h.f16056a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.emit(java.lang.Object, qf.c):java.lang.Object");
    }
}
