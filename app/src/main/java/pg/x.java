package pg;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* compiled from: Scopes.kt */
/* loaded from: classes2.dex */
public class x<T> extends kg.a<T> implements sf.c {

    /* renamed from: o, reason: collision with root package name */
    public final qf.c<T> f17732o;

    /* JADX WARN: Multi-variable type inference failed */
    public x(CoroutineContext coroutineContext, qf.c<? super T> cVar) {
        super(coroutineContext, true, true);
        this.f17732o = cVar;
    }

    @Override // kg.r1
    public void afterCompletion(Object obj) {
        qf.c<T> cVar = this.f17732o;
        j.resumeCancellableWith$default(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), kg.c0.recoverResult(obj, cVar), null, 2, null);
    }

    @Override // kg.a
    public void afterResume(Object obj) {
        qf.c<T> cVar = this.f17732o;
        cVar.resumeWith(kg.c0.recoverResult(obj, cVar));
    }

    @Override // sf.c
    public final sf.c getCallerFrame() {
        qf.c<T> cVar = this.f17732o;
        if (cVar instanceof sf.c) {
            return (sf.c) cVar;
        }
        return null;
    }

    @Override // kg.r1
    public final boolean isScopedCoroutine() {
        return true;
    }
}
