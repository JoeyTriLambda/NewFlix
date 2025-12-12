package com.unity3d.services.core.extensions;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import lf.f;
import yf.a;
import zf.i;

/* compiled from: CoroutineExtensions.kt */
/* loaded from: classes2.dex */
public final class CoroutineExtensionsKt {
    public static final <R> Object runReturnSuspendCatching(a<? extends R> aVar) {
        Object objM59constructorimpl;
        i.checkNotNullParameter(aVar, "block");
        try {
            int i10 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(aVar.invoke());
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            objM59constructorimpl = Result.m59constructorimpl(f.createFailure(th2));
        }
        if (Result.m64isSuccessimpl(objM59constructorimpl)) {
            return Result.m59constructorimpl(objM59constructorimpl);
        }
        Throwable thM61exceptionOrNullimpl = Result.m61exceptionOrNullimpl(objM59constructorimpl);
        return thM61exceptionOrNullimpl != null ? Result.m59constructorimpl(f.createFailure(thM61exceptionOrNullimpl)) : objM59constructorimpl;
    }

    public static final <R> Object runSuspendCatching(a<? extends R> aVar) {
        i.checkNotNullParameter(aVar, "block");
        try {
            int i10 = Result.f15189m;
            return Result.m59constructorimpl(aVar.invoke());
        } catch (CancellationException e10) {
            throw e10;
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            return Result.m59constructorimpl(f.createFailure(th2));
        }
    }
}
