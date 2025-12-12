package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import lf.h;
import qf.c;
import rf.a;
import sf.e;
import sf.f;
import zf.i;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class BaseContinuationImpl implements c<Object>, sf.c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<h> create(c<?> cVar) {
        i.checkNotNullParameter(cVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // sf.c
    public sf.c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return e.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qf.c
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        c cVar = this;
        while (true) {
            f.probeCoroutineResumed(cVar);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            c cVar2 = baseContinuationImpl.completion;
            i.checkNotNull(cVar2);
            try {
                objInvokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th2) {
                int i10 = Result.f15189m;
                obj = Result.m59constructorimpl(lf.f.createFailure(th2));
            }
            if (objInvokeSuspend == a.getCOROUTINE_SUSPENDED()) {
                return;
            }
            obj = Result.m59constructorimpl(objInvokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(cVar2 instanceof BaseContinuationImpl)) {
                cVar2.resumeWith(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public c<h> create(Object obj, c<?> cVar) {
        i.checkNotNullParameter(cVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
