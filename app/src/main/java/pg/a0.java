package pg;

import kotlin.Result;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes2.dex */
public final class a0 {
    static {
        Object objM59constructorimpl;
        Object objM59constructorimpl2;
        new b.a().coroutineBoundary();
        try {
            int i10 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(BaseContinuationImpl.class.getCanonicalName());
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(lf.f.createFailure(th2));
        }
        if (Result.m61exceptionOrNullimpl(objM59constructorimpl) != null) {
            objM59constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objM59constructorimpl2 = Result.m59constructorimpl(a0.class.getCanonicalName());
        } catch (Throwable th3) {
            int i12 = Result.f15189m;
            objM59constructorimpl2 = Result.m59constructorimpl(lf.f.createFailure(th3));
        }
        if (Result.m61exceptionOrNullimpl(objM59constructorimpl2) != null) {
            objM59constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }

    public static final <E extends Throwable> E recoverStackTrace(E e10) {
        return e10;
    }
}
