package kg;

import java.util.concurrent.Future;

/* compiled from: Future.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class o1 {
    public static final void cancelFutureOnCancellation(l<?> lVar, Future<?> future) {
        lVar.invokeOnCancellation(new i(future));
    }
}
