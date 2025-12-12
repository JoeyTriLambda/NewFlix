package kg;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Job.kt */
/* loaded from: classes2.dex */
public interface k1 extends CoroutineContext.a {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f15118i = 0;

    /* compiled from: Job.kt */
    public static final class a {
        public static /* synthetic */ void cancel$default(k1 k1Var, CancellationException cancellationException, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                cancellationException = null;
            }
            k1Var.cancel(cancellationException);
        }

        public static <R> R fold(k1 k1Var, R r10, yf.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0180a.fold(k1Var, r10, pVar);
        }

        public static <E extends CoroutineContext.a> E get(k1 k1Var, CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0180a.get(k1Var, bVar);
        }

        public static /* synthetic */ u0 invokeOnCompletion$default(k1 k1Var, boolean z10, boolean z11, yf.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i10 & 1) != 0) {
                z10 = false;
            }
            if ((i10 & 2) != 0) {
                z11 = true;
            }
            return k1Var.invokeOnCompletion(z10, z11, lVar);
        }

        public static CoroutineContext minusKey(k1 k1Var, CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0180a.minusKey(k1Var, bVar);
        }

        public static CoroutineContext plus(k1 k1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0180a.plus(k1Var, coroutineContext);
        }
    }

    /* compiled from: Job.kt */
    public static final class b implements CoroutineContext.b<k1> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b f15119b = new b();
    }

    r attachChild(t tVar);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    k1 getParent();

    u0 invokeOnCompletion(yf.l<? super Throwable, lf.h> lVar);

    u0 invokeOnCompletion(boolean z10, boolean z11, yf.l<? super Throwable, lf.h> lVar);

    boolean isActive();

    boolean isCancelled();

    Object join(qf.c<? super lf.h> cVar);

    boolean start();
}
