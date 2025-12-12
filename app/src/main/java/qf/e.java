package qf;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import lf.h;
import yf.p;
import zf.i;

/* compiled from: Continuation.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final <R, T> void startCoroutine(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar) {
        i.checkNotNullParameter(pVar, "<this>");
        i.checkNotNullParameter(cVar, "completion");
        c cVarIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, r10, cVar));
        int i10 = Result.f15189m;
        cVarIntercepted.resumeWith(Result.m59constructorimpl(h.f16056a));
    }
}
