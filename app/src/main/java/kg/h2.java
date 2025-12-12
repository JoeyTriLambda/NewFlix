package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes2.dex */
public interface h2<S> extends CoroutineContext.a {
    void restoreThreadContext(CoroutineContext coroutineContext, S s10);

    S updateThreadContext(CoroutineContext coroutineContext);
}
