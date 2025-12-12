package kotlinx.coroutines;

import kg.d0;
import kg.g0;
import kg.k2;
import kg.l2;
import kg.o0;
import kg.s0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$ObjectRef;
import qf.d;
import yf.p;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z10) {
        Boolean bool = Boolean.FALSE;
        CoroutineContextKt$hasCopyableElements$1 coroutineContextKt$hasCopyableElements$1 = CoroutineContextKt$hasCopyableElements$1.f15289b;
        boolean zBooleanValue = ((Boolean) coroutineContext.fold(bool, coroutineContextKt$hasCopyableElements$1)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) coroutineContext2.fold(bool, coroutineContextKt$hasCopyableElements$1)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f15262b = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f15239b;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v3, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // yf.p
            public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.a aVar) {
                if (!(aVar instanceof d0)) {
                    return coroutineContext4.plus(aVar);
                }
                Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                CoroutineContext.a aVar2 = ref$ObjectRef2.f15262b.get(aVar.getKey());
                if (aVar2 != null) {
                    ref$ObjectRef2.f15262b = ref$ObjectRef2.f15262b.minusKey(aVar.getKey());
                    return coroutineContext4.plus(((d0) aVar).mergeForChild(aVar2));
                }
                d0 d0VarCopyForChild = (d0) aVar;
                if (z10) {
                    d0VarCopyForChild = d0VarCopyForChild.copyForChild();
                }
                return coroutineContext4.plus(d0VarCopyForChild);
            }
        });
        if (zBooleanValue2) {
            ref$ObjectRef.f15262b = ((CoroutineContext) ref$ObjectRef.f15262b).fold(emptyCoroutineContext, new p<CoroutineContext, CoroutineContext.a, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // yf.p
                public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.a aVar) {
                    return aVar instanceof d0 ? coroutineContext4.plus(((d0) aVar).copyForChild()) : coroutineContext4.plus(aVar);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.f15262b);
    }

    public static final String getCoroutineName(CoroutineContext coroutineContext) {
        return null;
    }

    public static final CoroutineContext newCoroutineContext(g0 g0Var, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(g0Var.getCoroutineContext(), coroutineContext, true);
        if (coroutineContextA == s0.getDefault()) {
            return coroutineContextA;
        }
        int i10 = qf.d.f18151l;
        return coroutineContextA.get(d.b.f18152b) == null ? coroutineContextA.plus(s0.getDefault()) : coroutineContextA;
    }

    public static final k2<?> undispatchedCompletion(sf.c cVar) {
        while (!(cVar instanceof o0) && (cVar = cVar.getCallerFrame()) != null) {
            if (cVar instanceof k2) {
                return (k2) cVar;
            }
        }
        return null;
    }

    public static final k2<?> updateUndispatchedCompletion(qf.c<?> cVar, CoroutineContext coroutineContext, Object obj) {
        if (!(cVar instanceof sf.c)) {
            return null;
        }
        if (!(coroutineContext.get(l2.f15121b) != null)) {
            return null;
        }
        k2<?> k2VarUndispatchedCompletion = undispatchedCompletion((sf.c) cVar);
        if (k2VarUndispatchedCompletion != null) {
            k2VarUndispatchedCompletion.saveThreadContext(coroutineContext, obj);
        }
        return k2VarUndispatchedCompletion;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        if (!((Boolean) coroutineContext2.fold(Boolean.FALSE, CoroutineContextKt$hasCopyableElements$1.f15289b)).booleanValue()) {
            return coroutineContext.plus(coroutineContext2);
        }
        return a(coroutineContext, coroutineContext2, false);
    }
}
