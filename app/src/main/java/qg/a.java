package qg;

import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import lf.f;
import lf.h;
import pg.j;
import qf.c;
import yf.l;
import yf.p;

/* compiled from: Cancellable.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final <R, T> void startCoroutineCancellable(p<? super R, ? super c<? super T>, ? extends Object> pVar, R r10, c<? super T> cVar, l<? super Throwable, h> lVar) {
        try {
            c cVarIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(pVar, r10, cVar));
            int i10 = Result.f15189m;
            j.resumeCancellableWith(cVarIntercepted, Result.m59constructorimpl(h.f16056a), lVar);
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            cVar.resumeWith(Result.m59constructorimpl(f.createFailure(th2)));
            throw th2;
        }
    }

    public static /* synthetic */ void startCoroutineCancellable$default(p pVar, Object obj, c cVar, l lVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        startCoroutineCancellable(pVar, obj, cVar, lVar);
    }

    public static final void startCoroutineCancellable(c<? super h> cVar, c<?> cVar2) {
        try {
            c cVarIntercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar);
            int i10 = Result.f15189m;
            j.resumeCancellableWith$default(cVarIntercepted, Result.m59constructorimpl(h.f16056a), null, 2, null);
        } catch (Throwable th2) {
            int i11 = Result.f15189m;
            cVar2.resumeWith(Result.m59constructorimpl(f.createFailure(th2)));
            throw th2;
        }
    }
}
