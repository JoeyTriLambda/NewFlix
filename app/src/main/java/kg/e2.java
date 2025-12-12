package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* loaded from: classes2.dex */
public class e2 extends a<lf.h> {
    public e2(CoroutineContext coroutineContext, boolean z10) {
        super(coroutineContext, true, z10);
    }

    @Override // kg.r1
    public boolean handleJobException(Throwable th2) {
        f0.handleCoroutineException(getContext(), th2);
        return true;
    }
}
