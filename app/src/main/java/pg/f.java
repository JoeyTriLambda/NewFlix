package pg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Scopes.kt */
/* loaded from: classes2.dex */
public final class f implements kg.g0 {

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f17696b;

    public f(CoroutineContext coroutineContext) {
        this.f17696b = coroutineContext;
    }

    @Override // kg.g0
    public CoroutineContext getCoroutineContext() {
        return this.f17696b;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
