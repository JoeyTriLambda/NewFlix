package kg;

import kotlin.Result;

/* compiled from: CompletionState.kt */
/* loaded from: classes2.dex */
public final class c0 {
    public static final <T> Object recoverResult(Object obj, qf.c<? super T> cVar) {
        if (!(obj instanceof z)) {
            return Result.m59constructorimpl(obj);
        }
        int i10 = Result.f15189m;
        return Result.m59constructorimpl(lf.f.createFailure(((z) obj).f15175a));
    }

    public static final <T> Object toState(Object obj, yf.l<? super Throwable, lf.h> lVar) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        return thM61exceptionOrNullimpl == null ? lVar != null ? new a0(obj, lVar) : obj : new z(thM61exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object toState$default(Object obj, yf.l lVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            lVar = null;
        }
        return toState(obj, (yf.l<? super Throwable, lf.h>) lVar);
    }

    public static final <T> Object toState(Object obj, l<?> lVar) {
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(obj);
        return thM61exceptionOrNullimpl == null ? obj : new z(thM61exceptionOrNullimpl, false, 2, null);
    }
}
