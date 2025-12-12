package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import qf.c;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(c<Object> cVar) {
        super(cVar);
        if (cVar != null) {
            if (!(cVar.getContext() == EmptyCoroutineContext.f15239b)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // qf.c
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f15239b;
    }
}
