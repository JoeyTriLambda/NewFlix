package kg;

/* compiled from: CancellableContinuation.kt */
/* loaded from: classes2.dex */
public interface l<T> extends qf.c<T> {

    /* compiled from: CancellableContinuation.kt */
    public static final class a {
        public static /* synthetic */ boolean cancel$default(l lVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return lVar.cancel(th2);
        }
    }

    boolean cancel(Throwable th2);

    void completeResume(Object obj);

    void invokeOnCancellation(yf.l<? super Throwable, lf.h> lVar);

    void resume(T t10, yf.l<? super Throwable, lf.h> lVar);

    void resumeUndispatched(kotlinx.coroutines.b bVar, T t10);

    Object tryResume(T t10, Object obj, yf.l<? super Throwable, lf.h> lVar);
}
