package kg;

import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* compiled from: CompletionHandler.kt */
/* loaded from: classes2.dex */
public abstract class b0 extends LockFreeLinkedListNode implements yf.l<Throwable, lf.h> {
    public abstract void invoke(Throwable th2);
}
