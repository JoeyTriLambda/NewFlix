package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public class l0<T> extends a<T> implements k0<T> {
    public l0(CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    @Override // kg.k0
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }
}
