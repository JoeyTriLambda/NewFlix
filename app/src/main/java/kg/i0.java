package kg;

import kotlin.Result;

/* compiled from: DebugStrings.kt */
/* loaded from: classes2.dex */
public final class i0 {
    public static final String getClassSimpleName(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(qf.c<?> cVar) {
        Object objM59constructorimpl;
        if (cVar instanceof pg.i) {
            return cVar.toString();
        }
        try {
            int i10 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(cVar + '@' + getHexAddress(cVar));
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(lf.f.createFailure(th2));
        }
        if (Result.m61exceptionOrNullimpl(objM59constructorimpl) != null) {
            objM59constructorimpl = cVar.getClass().getName() + '@' + getHexAddress(cVar);
        }
        return (String) objM59constructorimpl;
    }
}
