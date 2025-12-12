package kg;

import kotlin.Result;

/* compiled from: CompletableDeferred.kt */
/* loaded from: classes2.dex */
public final class w {
    public static final <T> u<T> CompletableDeferred(k1 k1Var) {
        return new v(k1Var);
    }

    public static /* synthetic */ u CompletableDeferred$default(k1 k1Var, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k1Var = null;
        }
        return CompletableDeferred(k1Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean completeWith(u<T> uVar, Object obj) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        return thM61exceptionOrNullimpl == null ? uVar.complete(obj) : uVar.completeExceptionally(thM61exceptionOrNullimpl);
    }
}
