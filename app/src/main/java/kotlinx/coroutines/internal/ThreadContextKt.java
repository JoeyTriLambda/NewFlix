package kotlinx.coroutines.internal;

import kg.h2;
import kotlin.coroutines.CoroutineContext;
import pg.b0;
import pg.i0;
import yf.p;
import zf.i;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
public final class ThreadContextKt {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f15566a = new b0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    public static final p<Object, CoroutineContext.a, Object> f15567b = new p<Object, CoroutineContext.a, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // yf.p
        public final Object invoke(Object obj, CoroutineContext.a aVar) {
            if (!(aVar instanceof h2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? aVar : Integer.valueOf(iIntValue + 1);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final p<h2<?>, CoroutineContext.a, h2<?>> f15568c = new p<h2<?>, CoroutineContext.a, h2<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // yf.p
        public final h2<?> invoke(h2<?> h2Var, CoroutineContext.a aVar) {
            if (h2Var != null) {
                return h2Var;
            }
            if (aVar instanceof h2) {
                return (h2) aVar;
            }
            return null;
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final p<i0, CoroutineContext.a, i0> f15569d = new p<i0, CoroutineContext.a, i0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // yf.p
        public final i0 invoke(i0 i0Var, CoroutineContext.a aVar) {
            if (aVar instanceof h2) {
                h2<?> h2Var = (h2) aVar;
                i0Var.append(h2Var, h2Var.updateThreadContext(i0Var.f17705a));
            }
            return i0Var;
        }
    };

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == f15566a) {
            return;
        }
        if (obj instanceof i0) {
            ((i0) obj).restore(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f15568c);
        i.checkNotNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((h2) objFold).restoreThreadContext(coroutineContext, obj);
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f15567b);
        i.checkNotNull(objFold);
        return objFold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return f15566a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new i0(coroutineContext, ((Number) obj).intValue()), f15569d);
        }
        i.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((h2) obj).updateThreadContext(coroutineContext);
    }
}
