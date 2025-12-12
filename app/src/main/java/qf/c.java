package qf;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Continuation.kt */
/* loaded from: classes2.dex */
public interface c<T> {
    CoroutineContext getContext();

    void resumeWith(Object obj);
}
