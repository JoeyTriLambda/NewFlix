package og;

import kotlinx.coroutines.flow.internal.AbortFlowException;

/* compiled from: FlowExceptions.common.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final void checkOwnership(AbortFlowException abortFlowException, ng.b<?> bVar) {
        if (abortFlowException.f15487b != bVar) {
            throw abortFlowException;
        }
    }
}
