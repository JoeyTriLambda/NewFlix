package kg;

import kotlin.Pair;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import qf.d;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class k2<T> extends pg.x<T> {

    /* renamed from: p, reason: collision with root package name */
    public final ThreadLocal<Pair<CoroutineContext, Object>> f15120p;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public k2(CoroutineContext coroutineContext, qf.c<? super T> cVar) {
        l2 l2Var = l2.f15121b;
        super(coroutineContext.get(l2Var) == null ? coroutineContext.plus(l2Var) : coroutineContext, cVar);
        this.f15120p = new ThreadLocal<>();
        CoroutineContext context = cVar.getContext();
        int i10 = qf.d.f18151l;
        if (context.get(d.b.f18152b) instanceof kotlinx.coroutines.b) {
            return;
        }
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, null);
        ThreadContextKt.restoreThreadContext(coroutineContext, objUpdateThreadContext);
        saveThreadContext(coroutineContext, objUpdateThreadContext);
    }

    @Override // pg.x, kg.a
    public void afterResume(Object obj) {
        if (this.threadLocalIsSet) {
            Pair<CoroutineContext, Object> pair = this.f15120p.get();
            if (pair != null) {
                ThreadContextKt.restoreThreadContext(pair.component1(), pair.component2());
            }
            this.f15120p.remove();
        }
        Object objRecoverResult = c0.recoverResult(obj, this.f17732o);
        qf.c<T> cVar = this.f17732o;
        CoroutineContext context = cVar.getContext();
        Object objUpdateThreadContext = ThreadContextKt.updateThreadContext(context, null);
        k2<?> k2VarUpdateUndispatchedCompletion = objUpdateThreadContext != ThreadContextKt.f15566a ? CoroutineContextKt.updateUndispatchedCompletion(cVar, context, objUpdateThreadContext) : null;
        try {
            this.f17732o.resumeWith(objRecoverResult);
            lf.h hVar = lf.h.f16056a;
        } finally {
            if (k2VarUpdateUndispatchedCompletion == null || k2VarUpdateUndispatchedCompletion.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(context, objUpdateThreadContext);
            }
        }
    }

    public final boolean clearThreadContext() {
        boolean z10 = this.threadLocalIsSet && this.f15120p.get() == null;
        this.f15120p.remove();
        return !z10;
    }

    public final void saveThreadContext(CoroutineContext coroutineContext, Object obj) {
        this.threadLocalIsSet = true;
        this.f15120p.set(lf.g.to(coroutineContext, obj));
    }
}
