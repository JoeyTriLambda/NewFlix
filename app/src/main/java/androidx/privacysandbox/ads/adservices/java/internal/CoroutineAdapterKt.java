package androidx.privacysandbox.ads.adservices.java.internal;

import a2.x;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import e8.c;
import java.util.concurrent.CancellationException;
import kg.k0;
import lf.h;
import yf.l;
import zf.i;

/* compiled from: CoroutineAdapter.kt */
/* loaded from: classes.dex */
public final class CoroutineAdapterKt {
    public static void a(final k0 k0Var, Object obj, final CallbackToFutureAdapter.a aVar) {
        i.checkNotNullParameter(k0Var, "$this_asListenableFuture");
        i.checkNotNullParameter(aVar, "completer");
        k0Var.invokeOnCompletion(new l<Throwable, h>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                CallbackToFutureAdapter.a<T> aVar2 = aVar;
                if (th2 == null) {
                    aVar2.set(k0Var.getCompleted());
                } else if (th2 instanceof CancellationException) {
                    aVar2.setCancelled();
                } else {
                    aVar2.setException(th2);
                }
            }
        });
    }

    public static final <T> c<T> asListenableFuture(k0<? extends T> k0Var, Object obj) {
        i.checkNotNullParameter(k0Var, "<this>");
        c<T> future = CallbackToFutureAdapter.getFuture(new x(1, k0Var, obj));
        i.checkNotNullExpressionValue(future, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return future;
    }

    public static /* synthetic */ c asListenableFuture$default(k0 k0Var, Object obj, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(k0Var, obj);
    }
}
