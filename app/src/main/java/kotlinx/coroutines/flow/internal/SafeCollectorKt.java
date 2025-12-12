package kotlinx.coroutines.flow.internal;

import lf.h;
import ng.b;
import qf.c;
import yf.q;
import zf.i;
import zf.n;

/* compiled from: SafeCollector.kt */
/* loaded from: classes2.dex */
public final class SafeCollectorKt {

    /* renamed from: a, reason: collision with root package name */
    public static final q<b<Object>, Object, c<? super h>, Object> f15553a;

    static {
        SafeCollectorKt$emitFun$1 safeCollectorKt$emitFun$1 = SafeCollectorKt$emitFun$1.f15554u;
        i.checkNotNull(safeCollectorKt$emitFun$1, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f15553a = (q) n.beforeCheckcastToFunctionOfArity(safeCollectorKt$emitFun$1, 3);
    }
}
