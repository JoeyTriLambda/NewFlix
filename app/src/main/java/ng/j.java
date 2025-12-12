package ng;

import kotlinx.coroutines.flow.SharedFlowImpl;

/* compiled from: SharedFlow.kt */
/* loaded from: classes2.dex */
public final class j extends og.b<SharedFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public long f16829a = -1;

    /* renamed from: b, reason: collision with root package name */
    public kg.m f16830b;

    @Override // og.b
    public boolean allocateLocked(SharedFlowImpl<?> sharedFlowImpl) {
        if (this.f16829a >= 0) {
            return false;
        }
        this.f16829a = sharedFlowImpl.updateNewCollectorIndexLocked$kotlinx_coroutines_core();
        return true;
    }

    @Override // og.b
    public qf.c<lf.h>[] freeLocked(SharedFlowImpl<?> sharedFlowImpl) {
        long j10 = this.f16829a;
        this.f16829a = -1L;
        this.f16830b = null;
        return sharedFlowImpl.updateCollectorIndexLocked$kotlinx_coroutines_core(j10);
    }
}
