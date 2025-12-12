package kotlinx.coroutines.flow.internal;

import kg.k1;
import kotlin.coroutines.CoroutineContext;
import pg.x;
import yf.p;
import zf.i;

/* compiled from: SafeCollector.common.kt */
/* loaded from: classes2.dex */
public final class SafeCollector_commonKt {
    public static final void checkContext(final SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new p<Integer, CoroutineContext.a, Integer>() { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$checkContext$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // yf.p
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.a aVar) {
                return invoke(num.intValue(), aVar);
            }

            public final Integer invoke(int i10, CoroutineContext.a aVar) {
                CoroutineContext.b<?> key = aVar.getKey();
                CoroutineContext.a aVar2 = safeCollector.f15548m.get(key);
                int i11 = k1.f15118i;
                if (key != k1.b.f15119b) {
                    return Integer.valueOf(aVar != aVar2 ? Integer.MIN_VALUE : i10 + 1);
                }
                k1 k1Var = (k1) aVar2;
                i.checkNotNull(aVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
                k1 k1VarTransitiveCoroutineParent = SafeCollector_commonKt.transitiveCoroutineParent((k1) aVar, k1Var);
                if (k1VarTransitiveCoroutineParent == k1Var) {
                    if (k1Var != null) {
                        i10++;
                    }
                    return Integer.valueOf(i10);
                }
                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + k1VarTransitiveCoroutineParent + ", expected child of " + k1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
        })).intValue() == safeCollector.f15549n) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.f15548m + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final k1 transitiveCoroutineParent(k1 k1Var, k1 k1Var2) {
        while (k1Var != null) {
            if (k1Var == k1Var2) {
                return k1Var;
            }
            if (!(k1Var instanceof x)) {
                return k1Var;
            }
            k1Var = k1Var.getParent();
        }
        return null;
    }
}
