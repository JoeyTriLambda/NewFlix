package kotlinx.coroutines;

import kg.i0;
import kotlin.coroutines.CoroutineContext;
import pg.m;
import qf.d;
import yf.l;

/* compiled from: CoroutineDispatcher.kt */
/* loaded from: classes2.dex */
public abstract class b extends qf.a implements qf.d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15310b = new a(null);

    /* compiled from: CoroutineDispatcher.kt */
    public static final class a extends qf.b<qf.d, b> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zf.f fVar) {
            super(d.b.f18152b, new l<CoroutineContext.a, b>() { // from class: kotlinx.coroutines.CoroutineDispatcher$Key$1
                @Override // yf.l
                public final b invoke(CoroutineContext.a aVar) {
                    if (aVar instanceof b) {
                        return (b) aVar;
                    }
                    return null;
                }
            });
            int i10 = qf.d.f18151l;
        }
    }

    public b() {
        super(d.b.f18152b);
    }

    public abstract void dispatch(CoroutineContext coroutineContext, Runnable runnable);

    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        dispatch(coroutineContext, runnable);
    }

    @Override // qf.a, kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) d.a.get(this, bVar);
    }

    @Override // qf.d
    public final <T> qf.c<T> interceptContinuation(qf.c<? super T> cVar) {
        return new pg.i(this, cVar);
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return true;
    }

    public b limitedParallelism(int i10) {
        m.checkParallelism(i10);
        return new pg.l(this, i10);
    }

    @Override // qf.a, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return d.a.minusKey(this, bVar);
    }

    @Override // qf.d
    public final void releaseInterceptedContinuation(qf.c<?> cVar) {
        zf.i.checkNotNull(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((pg.i) cVar).release();
    }

    public String toString() {
        return i0.getClassSimpleName(this) + '@' + i0.getHexAddress(this);
    }
}
