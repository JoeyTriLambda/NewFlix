package kg;

/* compiled from: JobSupport.kt */
/* loaded from: classes2.dex */
public final class q extends l1 {

    /* renamed from: p, reason: collision with root package name */
    public final m<?> f15132p;

    public q(m<?> mVar) {
        this.f15132p = mVar;
    }

    @Override // yf.l
    public /* bridge */ /* synthetic */ lf.h invoke(Throwable th2) {
        invoke2(th2);
        return lf.h.f16056a;
    }

    @Override // kg.b0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable th2) {
        r1 job = getJob();
        m<?> mVar = this.f15132p;
        mVar.parentCancelled$kotlinx_coroutines_core(mVar.getContinuationCancellationCause(job));
    }
}
