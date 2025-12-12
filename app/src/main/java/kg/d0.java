package kg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes2.dex */
public interface d0<S> extends h2<S> {
    d0<S> copyForChild();

    CoroutineContext mergeForChild(CoroutineContext.a aVar);
}
