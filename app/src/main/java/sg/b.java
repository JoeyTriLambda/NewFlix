package sg;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Select.kt */
/* loaded from: classes2.dex */
public interface b<R> {
    CoroutineContext getContext();

    void selectInRegistrationPhase(Object obj);

    boolean trySelect(Object obj, Object obj2);
}
