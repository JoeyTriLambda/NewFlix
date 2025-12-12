package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.CoroutineContext;
import qf.c;
import qf.d;
import sf.b;
import zf.i;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final CoroutineContext _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(c<Object> cVar, CoroutineContext coroutineContext) {
        super(cVar);
        this._context = coroutineContext;
    }

    @Override // qf.c
    public CoroutineContext getContext() {
        CoroutineContext coroutineContext = this._context;
        i.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    public final c<Object> intercepted() {
        c<Object> cVarInterceptContinuation = this.intercepted;
        if (cVarInterceptContinuation == null) {
            CoroutineContext context = getContext();
            int i10 = d.f18151l;
            d dVar = (d) context.get(d.b.f18152b);
            if (dVar == null || (cVarInterceptContinuation = dVar.interceptContinuation(this)) == null) {
                cVarInterceptContinuation = this;
            }
            this.intercepted = cVarInterceptContinuation;
        }
        return cVarInterceptContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        c<?> cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            CoroutineContext context = getContext();
            int i10 = d.f18151l;
            CoroutineContext.a aVar = context.get(d.b.f18152b);
            i.checkNotNull(aVar);
            ((d) aVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f19280b;
    }

    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
