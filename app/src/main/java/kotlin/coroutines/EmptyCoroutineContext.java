package kotlin.coroutines;

import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import yf.p;
import zf.i;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes2.dex */
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f15239b = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        i.checkNotNullParameter(pVar, "operation");
        return r10;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        i.checkNotNullParameter(bVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        i.checkNotNullParameter(bVar, "key");
        return this;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        i.checkNotNullParameter(coroutineContext, "context");
        return coroutineContext;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
