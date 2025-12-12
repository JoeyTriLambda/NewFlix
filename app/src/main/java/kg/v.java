package kg;

/* compiled from: CompletableDeferred.kt */
/* loaded from: classes2.dex */
public final class v<T> extends r1 implements u<T> {
    public v(k1 k1Var) {
        super(true);
        initParentJob(k1Var);
    }

    @Override // kg.k0
    public Object await(qf.c<? super T> cVar) throws Throwable {
        Object objAwaitInternal = awaitInternal(cVar);
        rf.a.getCOROUTINE_SUSPENDED();
        return objAwaitInternal;
    }

    @Override // kg.u
    public boolean complete(T t10) {
        return makeCompleting$kotlinx_coroutines_core(t10);
    }

    @Override // kg.u
    public boolean completeExceptionally(Throwable th2) {
        return makeCompleting$kotlinx_coroutines_core(new z(th2, false, 2, null));
    }

    @Override // kg.k0
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    @Override // kg.r1
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return true;
    }
}
