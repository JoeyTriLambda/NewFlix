package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes2.dex */
public interface e0 extends CoroutineContext.a {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f15105h = 0;

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class a {
        public static <R> R fold(e0 e0Var, R r10, yf.p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
            return (R) CoroutineContext.a.C0180a.fold(e0Var, r10, pVar);
        }

        public static <E extends CoroutineContext.a> E get(e0 e0Var, CoroutineContext.b<E> bVar) {
            return (E) CoroutineContext.a.C0180a.get(e0Var, bVar);
        }

        public static CoroutineContext minusKey(e0 e0Var, CoroutineContext.b<?> bVar) {
            return CoroutineContext.a.C0180a.minusKey(e0Var, bVar);
        }

        public static CoroutineContext plus(e0 e0Var, CoroutineContext coroutineContext) {
            return CoroutineContext.a.C0180a.plus(e0Var, coroutineContext);
        }
    }

    /* compiled from: CoroutineExceptionHandler.kt */
    public static final class b implements CoroutineContext.b<e0> {

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ b f15106b = new b();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th2);
}
