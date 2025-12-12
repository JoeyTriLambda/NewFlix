package kg;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes2.dex */
public final class o {
    public static final void disposeOnCancellation(l<?> lVar, u0 u0Var) {
        lVar.invokeOnCancellation(new v0(u0Var));
    }

    public static final <T> m<T> getOrCreateCancellableContinuation(qf.c<? super T> cVar) {
        if (!(cVar instanceof pg.i)) {
            return new m<>(cVar, 1);
        }
        m<T> mVarClaimReusableCancellableContinuation = ((pg.i) cVar).claimReusableCancellableContinuation();
        if (mVarClaimReusableCancellableContinuation != null) {
            if (!mVarClaimReusableCancellableContinuation.resetStateReusable()) {
                mVarClaimReusableCancellableContinuation = null;
            }
            if (mVarClaimReusableCancellableContinuation != null) {
                return mVarClaimReusableCancellableContinuation;
            }
        }
        return new m<>(cVar, 2);
    }
}
